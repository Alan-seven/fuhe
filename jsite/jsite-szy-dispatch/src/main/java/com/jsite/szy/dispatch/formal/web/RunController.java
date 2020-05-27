package com.jsite.szy.dispatch.formal.web;
  
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Maps;
import com.jsite.busi.szy.formal.po.TSfmmEnB;
import com.jsite.busi.szy.formal.po.TSfrdIfInitcond;
import com.jsite.busi.szy.formal.po.TSfrdIfRslt;
import com.jsite.busi.szy.formal.po.TSfrdPro;
import com.jsite.busi.szy.formal.service.TSfmmEnBService;
import com.jsite.busi.szy.formal.service.TSfrdIfInitcondService;
import com.jsite.busi.szy.formal.service.TSfrdIfRsltService;
import com.jsite.busi.szy.formal.service.TSfrdProService;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdProVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/runoff")
@Api(value="来水预报计算信息",tags="来水预报信息接口")
public class RunController extends BaseController{
	
	@Autowired
	private TSfmmEnBService tSfmmEnBService;
	@Autowired
	private TSfrdIfInitcondService tSfrdIfInitcondService;
	@Autowired
	private TSfrdIfRsltService tSfrdIfRsltService;
	@Autowired
	private TSfrdProService tSfrdProService;
	
	@ResponseBody
	@RequestMapping(value = "/getNext",method = RequestMethod.POST)
    @ApiOperation(value = "来水预报初始化数据", notes = "来水预报初始化数据")
	public String getNext(@RequestBody TSfrdProVO tSfrdProVO, HttpServletResponse response){
		String proCd = tSfrdProVO.getProCd();
		Map<String,Object> map = Maps.newHashMap();
		TSfmmEnB enb = new TSfmmEnB();
		enb.setRegionCd("000000F090500001");
		enb.setEnTp("05");
		List<TSfmmEnB> enList = tSfmmEnBService.list(enb);
		map.put("enbList", enList);
		TSfrdIfInitcond initcond = new TSfrdIfInitcond();
		initcond.setProCd(proCd);
		//负责对模型计算结果进行初始化
		List<TSfrdIfInitcond> initList = tSfrdIfInitcondService.list(initcond);
		//获取来水预报结果
		TSfrdPro pro = tSfrdProService.get(proCd);
		Double forw = 0d;
		if(Integer.parseInt(pro.getSchStat()) >= 1){
			 TSfrdIfRslt rslt = new TSfrdIfRslt();
			 rslt.setProCd(proCd);
			 for(TSfmmEnB entity : enList){
				 rslt.setEnCd(entity.getEnCd());
				 List<TSfrdIfRslt> rsltList = tSfrdIfRsltService.list(rslt);
				 //径流总量累加，
				 forw += rsltList.get(0).getForW();
				 map.put(entity.getEnCd(), rsltList);
			 }
			 map.put("forw", forw);
		}
		map.put("initList", initList);
		map.put("code", RespCode.SERVICE_RESP_ERROR_CODE_1);
		return renderString(response, map);
	}
	
	
	@RequestMapping(value = "/getResult")
    @ApiOperation(value = "来水预报计算", notes = "来水预报计算", httpMethod = "POST")
	public String getResult(@RequestBody TSfrdProVO tSfrdProVO, HttpServletResponse response) {
		String proCd = tSfrdProVO.getProCd();
		ServiceResp serviceResp = new ServiceResp();
		TSfrdIfInitcond initcond = new TSfrdIfInitcond();
		initcond.setProCd(proCd);
		List<TSfrdIfInitcond> initList = tSfrdIfInitcondService.list(initcond);
		TSfrdPro pro = tSfrdProService.get(proCd);
		for(TSfrdIfInitcond cond : initList){
			String enCd = cond.getEnCd();
			String enNm = cond.getEnNm();
			//暂无廖坊计算模型
			if("廖坊".equals(enNm))
				continue;
			String forPattern = cond.getForPattern();
			String pre_time = DateUtils.formatDate(pro.getBgDt(), "yyyy")+"年";
			String scale = ("Y".equals(pro.getProTp()))?"年":"月";
			try{
				JSONArray array = getPyRslt(enNm, pre_time, scale, forPattern);
				serviceResp = tSfrdIfRsltService.saveResult(array, proCd, enCd, pre_time);
				if(serviceResp.getCode() == 1){
					serviceResp = tSfrdProService.updateStat(proCd, "1");
				}
			}catch(Exception e){
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg("模型计算出错");
			}
			
		}
		return renderString(response, serviceResp);
	}

	/**
	 * 
	 * @param stationName 站点
	 * @param pre_time	预报时间
	 * @param scale	方案类型
	 * @param modelName	模型名称
	 * @return
	 */
	public JSONArray getPyRslt(String stationName, String pre_time, String scale, String modelName){
		String url = "http://122.112.181.229:5000/runoffForecasting";
		//设置参数
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("prediction_time", pre_time);
		params.add("scale", scale);
    	//服务访问密钥
		params.add("modelName", ("0".equals(modelName))?"lstm":"bp_lstm");
		params.add("stationName", stationName);
		params.add("lvding", "False");
    	//设置header信息
		HttpHeaders headers = new HttpHeaders(); 
    	headers.set("Accept-Charset", "utf-8");
    	RestTemplate restTemplate = new RestTemplate();   
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers); 
        JSONArray json =  restTemplate.postForObject(url, requestEntity, JSONArray.class);
        return json;
	}
	
	public static void main(String[] args){
//			String url = "http://122.112.181.229:5000/runoffForecasting";
//			//设置参数
//			MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//			params.add("prediction_time", "2014年");
//			params.add("scale", "年");
//	    	//服务访问密钥
//			params.add("modelName", "0"=="0"?"lstm":"bp_lstm");
//			params.add("stationName", "南城");
//			params.add("lvding", "False");
//	    	//设置header信息
//			HttpHeaders headers = new HttpHeaders(); 
//	    	headers.set("Accept-Charset", "utf-8");
//	    	RestTemplate restTemplate = new RestTemplate();   
//	        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers); 
//	        JSONArray json =  restTemplate.postForObject(url, requestEntity, JSONArray.class);
//	        System.out.println(json);
	        System.out.println(System.getProperty("user.dir"));
	        System.out.println(RunController.class.getClassLoader().getResource("/").getPath());
	}
}
