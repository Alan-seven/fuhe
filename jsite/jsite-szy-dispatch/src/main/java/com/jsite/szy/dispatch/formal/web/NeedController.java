package com.jsite.szy.dispatch.formal.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Maps;
import com.jsite.busi.szy.formal.po.TSfmmEnB;
import com.jsite.busi.szy.formal.po.TSfrdPro;
import com.jsite.busi.szy.formal.po.TSfrdWsaInitcond;
import com.jsite.busi.szy.formal.po.TSfrdWsaRslt;
import com.jsite.busi.szy.formal.po.TSfrdWsaWt;
import com.jsite.busi.szy.formal.po.TSfrdWtrplanInitcond;
import com.jsite.busi.szy.formal.service.TSfmmEnBService;
import com.jsite.busi.szy.formal.service.TSfrdProService;
import com.jsite.busi.szy.formal.service.TSfrdWsaInitcondService;
import com.jsite.busi.szy.formal.service.TSfrdWsaRsltService;
import com.jsite.busi.szy.formal.service.TSfrdWsaWtService;
import com.jsite.busi.szy.formal.service.TSfrdWtrplanInitcondService;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdProVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/need")
@Api(value="需水预测计算信息",tags="需水预测信息接口")
public class NeedController extends BaseController{

	@Autowired
	private TSfmmEnBService tSfmmEnBService;
	@Autowired
	private TSfrdWtrplanInitcondService tSfrdWtrplanInitcondService;
	@Autowired
	private TSfrdWsaWtService tSfrdWsaWtService;
	@Autowired
	private TSfrdWsaInitcondService tSfrdWsaInitcondService;
	@Autowired
	private TSfrdProService tSfrdProService;
	@Autowired
	private TSfrdWsaRsltService tSfrdWsaRsltService;
	
	@RequestMapping(value = "/getNext")
    @ApiOperation(value = "需水预测初始化数据", notes = "需水预测初始化数据", httpMethod = "POST")
	public String getNext(@RequestBody TSfrdProVO tSfrdProVO, HttpServletResponse response){
		String proCd = tSfrdProVO.getProCd();
		Map<String,Object> map = Maps.newHashMap();
		List<TSfmmEnB> enList = tSfmmEnBService.listByEnTp("000000F090500001","12");
		//申报水量
		List<TSfrdWtrplanInitcond> planList = tSfrdWtrplanInitcondService.listByProCd(proCd);
		map.put("planList", planList);
		//用水参数
		List<TSfrdWsaWt> wtList = tSfrdWsaWtService.listByProCd(proCd);
		map.put("wtList", wtList);
		//逐月分水系数
		List<TSfrdWsaInitcond> initList = tSfrdWsaInitcondService.listByProCd(proCd);
		map.put("initList", initList);
		//计算结果
		TSfrdPro pro = tSfrdProService.get(proCd);
		if(Integer.parseInt(pro.getSchStat()) >= 2){
			TSfrdWsaRslt rslt = new TSfrdWsaRslt();
			rslt.setProCd(proCd);
			for(TSfmmEnB entity : enList){
				rslt.setEnCd(entity.getEnCd());
				List<TSfrdWsaRslt> rsltList = tSfrdWsaRsltService.list(rslt);
				map.put(entity.getEnCd(), rsltList);
			}
		}
		map.put("code", RespCode.SERVICE_RESP_ERROR_CODE_1);
		return renderString(response, map);
	}
	
	@RequestMapping(value = "/getResult")
    @ApiOperation(value = "需水预测计算", notes = "需水预测计算", httpMethod = "POST")
	public String getResult(@RequestBody TSfrdProVO tSfrdProVO, HttpServletResponse response) {
		String proCd = tSfrdProVO.getProCd() ;
		ServiceResp serviceResp = new ServiceResp();
		List<TSfmmEnB> enList = tSfmmEnBService.listByEnTp("000000F090500001","12");
		for(TSfmmEnB entity : enList){
			//得到实体申报水量
			TSfrdWtrplanInitcond initcond = tSfrdWtrplanInitcondService.getEntity(proCd,entity.getEnCd());
			//得到实体用水参数
			TSfrdWsaWt wt = tSfrdWsaWtService.getEntity(proCd, entity.getEnCd());
			//得到实体逐月分水系数
			List<TSfrdWsaInitcond>  condList = tSfrdWsaInitcondService.listParams(proCd,entity.getEnCd());
			serviceResp = tSfrdWsaRsltService.saveResult(initcond, wt, condList);
		}
		if(serviceResp.getCode() == 1){
			serviceResp = tSfrdProService.updateStat(proCd, "2");
		}
		return renderString(response, serviceResp);
	}
}
