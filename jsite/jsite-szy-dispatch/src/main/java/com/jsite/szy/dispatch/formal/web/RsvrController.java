package com.jsite.szy.dispatch.formal.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jsite.busi.szy.formal.po.TSfrdDisWu;
import com.jsite.busi.szy.formal.po.TSfrdDisWusRslt;
import com.jsite.busi.szy.formal.po.TSfrdIfRslt;
import com.jsite.busi.szy.formal.po.TSfrdPro;
import com.jsite.busi.szy.formal.po.TSfrdRsvrInit;
import com.jsite.busi.szy.formal.po.TSfrdWsaWt;
import com.jsite.busi.szy.formal.po.TSfrdWtrplanInitcond;
import com.jsite.busi.szy.formal.service.TSfrdDisWuService;
import com.jsite.busi.szy.formal.service.TSfrdDisWusRsltService;
import com.jsite.busi.szy.formal.service.TSfrdIfRsltService;
import com.jsite.busi.szy.formal.service.TSfrdProService;
import com.jsite.busi.szy.formal.service.TSfrdRsvrInitService;
import com.jsite.busi.szy.formal.service.TSfrdWsaWtService;
import com.jsite.busi.szy.formal.service.TSfrdWtrplanInitcondService;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.utils.ModelUtils;
import com.jsite.szy.dispatch.formal.vo.TSfrdProVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import waterDispatch.controller.ModelController;
import waterDispatch.entity.InputEntity;
import waterDispatch.entity.ResultEntity;

@Controller
@RequestMapping(value = "${adminPath}/formal/rsvr")
@Api(value="水库计算信息",tags="水库计算信息接口")
public class RsvrController extends BaseController{
	
	@Autowired
	private TSfrdProService tSfrdProService;
	@Autowired
	private TSfrdRsvrInitService tSfrdRsvrInitService;
	@Autowired
	private TSfrdDisWuService tSfrdDisWuService;
	@Autowired
	private TSfrdWtrplanInitcondService tSfrdWtrplanInitcondService;
	@Autowired
	private TSfrdDisWusRsltService tSfrdDisWusRsltService;
	@Autowired
	private TSfrdWsaWtService tSfrdWsaWtService;
	@Autowired
	private TSfrdIfRsltService tSfrdIfRsltService;
	
	@RequestMapping(value = "/getNext")
    @ApiOperation(value = "水量分配初始化数据", notes = "水量分配初始化数据", httpMethod = "POST")
	public String getNext(@RequestBody TSfrdProVO tSfrdProVO, HttpServletResponse response){
		Map<String,Object> map = Maps.newHashMap();
		String proCd = tSfrdProVO.getProCd();
		List<TSfrdRsvrInit> initList = tSfrdRsvrInitService.listByProCd(proCd);
		map.put("initList", initList);
		List<TSfrdDisWu> diswuList = tSfrdDisWuService.listByEncd(proCd);
		map.put("diswuList", diswuList);
		map.put("code", RespCode.SERVICE_RESP_ERROR_CODE_1);
		return renderString(response, map);
	}
	
	
	@RequestMapping(value = "/getResult")
    @ApiOperation(value = "水量分配计算", notes = "水量分配计算", httpMethod = "POST")
	public String getResult(@RequestBody TSfrdProVO tSfrdProVO, HttpServletResponse response) {
		String proCd = tSfrdProVO.getProCd();
		TSfrdPro pro = tSfrdProService.get(proCd);
		//得到水库的初始化数据
		TSfrdRsvrInit rsvrinit = new TSfrdRsvrInit();
		rsvrinit.setProCd(proCd);
		List<TSfrdRsvrInit> rsvrlist = tSfrdRsvrInitService.list(rsvrinit);
		List<TSfrdWsaWt> wtList = tSfrdWsaWtService.listByProCd(proCd);
		//得到水量分配用水系数
		List<TSfrdDisWu> dislist = tSfrdDisWuService.listByEncd(proCd);
		//需水预测结果
		TSfrdWtrplanInitcond initcond = new TSfrdWtrplanInitcond();
		List<TSfrdWtrplanInitcond> initcondlist = tSfrdWtrplanInitcondService.list(initcond);
		InputEntity input = new InputEntity();
		//模式水库参数输入
		input = initModelByRsvr(pro, rsvrlist, input);
		//自产水量
		input = initModelByInflow(proCd, input);
		//最小水量
		input = initModelByMinFlow(input);
		//各时段频率来水
		input = initModelByFrequency(input);
		//模型需水总量输入
		input = initModelWw(initcondlist, input);
		//模型用水比例输入
		input = initModelWt(wtList, input);
		//模型分水系数、回归系数输入
		input = initModelRatio(dislist, input);
		input = setRsvr(input);
		ModelController mc = new ModelController();
		try {
			ResultEntity result = mc.newBuiltPlanController(input);
			saveData(result, pro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return renderString(response, "");
    }
	
	/**
	 * 模型水库参数输入
	 * @param pro
	 * @param rsvrlist
	 * @param input
	 * @return
	 */
	public InputEntity initModelByRsvr(TSfrdPro pro ,List<TSfrdRsvrInit> rsvrlist,InputEntity input){
		if("Y".equals(pro.getProTp())){
			input.setTimeLength(12);
		}
		//设置洪门廖坊的水位
		for(int i = 0 ; i < rsvrlist.size();i++){
			TSfrdRsvrInit init = rsvrlist.get(i);
			if(init!=null){
				if("102000000".equals(init.getEnCd())){
					input.setHMstart(init.getStz());
					input.setHMend(init.getEdz());
				}else{
					input.setLFstart(init.getStz());
					input.setLFend(init.getEdz());
				}
			}
		}
		return input;
	}
	
	/**
	 * 自产水量
	 * 数据顺序   广昌县   南丰县 乐安县  崇仁县  宜黄县  黎川县  南城县  资溪县  金溪县  临川区  东乡县  赣抚平原
	 * 需要减少数据表的查询次数，故顺序是乱序赋值，最后按照索引顺序输入参数
	 * @param proCd
	 * @param input
	 * @return
	 */
	public InputEntity initModelByInflow(String proCd, InputEntity input){
		 TSfrdIfRslt rslt = new TSfrdIfRslt();
	     rslt.setProCd(proCd);
	     rslt.setEnCd("105000000");//沙子岭
	     List<TSfrdIfRslt> rsltList = tSfrdIfRsltService.list(rslt);
	     List<Double[]> inflow = Lists.newArrayList(); 
	     //广昌
	     Double[] gcFlow = new Double[12];
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 gcFlow[index] = item.getRelW();
	     });
	     //南丰
	     Double[] nfFlow = new Double[12];
	     rslt.setEnCd("105000051");//南城
	     rsltList = tSfrdIfRsltService.list(rslt);
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 nfFlow[index] = ModelUtils.getRslt(2, item.getRelW()*0.72);
	     });
	    
	     //南城县
	     Double[] ncFlow = new Double[12];
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 ncFlow[index] = ModelUtils.getRslt(3, item.getRelW()*0.258);
	     });
	     
	     //宜黄
	     Double[] yhFlow = new Double[12];
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 yhFlow[index] = ModelUtils.getRslt(3, item.getRelW()*0.009);
	     });
	     rslt.setEnCd("105000001");  //娄家村
	     rsltList = tSfrdIfRsltService.list(rslt);
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 yhFlow[index] = yhFlow[index]+ ModelUtils.getRslt(3, item.getRelW()*0.367);
	     });
	     //乐安
	     Double[] laFlow = new Double[12];
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 laFlow[index] =  ModelUtils.getRslt(3, item.getRelW()*0.197);
	     });
	     
	     //崇仁
	     Double[] crFlow = new Double[12];
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 crFlow[index] =  ModelUtils.getRslt(3, item.getRelW()*0.295);
	     });
	    
	     //临川
	     Double[] lcFlow = new Double[12];
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 lcFlow[index] =  ModelUtils.getRslt(3, item.getRelW()*0.141);
	     });
	     rslt.setEnCd("105000054");		//李家渡
	     rsltList = tSfrdIfRsltService.list(rslt);
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 lcFlow[index] = lcFlow[index]+ ModelUtils.getRslt(3, item.getRelW()*0.633);
	     });
	     //东乡
	     Double[] dxFlow = new Double[12];
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 dxFlow[index] =  ModelUtils.getRslt(3, item.getRelW()*0.335);
	     });
	    
	     //赣抚平原
	     Double[] gfFlow = new Double[12];
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 gfFlow[index] =  ModelUtils.getRslt(3, item.getRelW()*0.032);
	     });
	    
	     //黎川
	     Double[] lchuanFlow = new Double[12];
	     rslt.setEnCd("105000052");//洪门
	     rsltList = tSfrdIfRsltService.list(rslt);
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 lchuanFlow[index] = ModelUtils.getRslt(3, item.getRelW());
	     });
	     rslt.setEnCd("105000051");  //南城
	     rsltList = tSfrdIfRsltService.list(rslt);
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 lchuanFlow[index] = lchuanFlow[index]+ ModelUtils.getRslt(3, item.getRelW()*0.011);
	     });
	     
	     //资溪
	     Double[] zxFlow = new Double[12];
	     rslt.setEnCd("105000053");		//廖家湾
	     rsltList = tSfrdIfRsltService.list(rslt);
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 zxFlow[index] =  ModelUtils.getRslt(3, item.getRelW()*0.378);
	     });
	    
	     //金溪
	     Double[] jxFlow = new Double[12];
	     rsltList.stream().forEach(item -> {
	    	 int index = item.getStDt().getMonth();
	    	 jxFlow[index] =  ModelUtils.getRslt(3, item.getRelW()*0.62);
	     });
	     inflow.add(0, gcFlow);
	     inflow.add(1, nfFlow);
	     inflow.add(2, laFlow);
	     inflow.add(3, crFlow);
	     inflow.add(4, yhFlow);
	     inflow.add(5, lchuanFlow);
	     inflow.add(6, ncFlow);
	     inflow.add(7, zxFlow);
	     inflow.add(8, jxFlow);
	     inflow.add(9, lcFlow);
	     inflow.add(10, dxFlow);
	     inflow.add(11, gfFlow);
	     
	     input.setSelfProducedInflow(inflow);
		 return input;
	}
	
	/**
	 * 最小水量
	 * 数据顺序   广昌县   南丰县 乐安县  崇仁县  宜黄县  黎川县  南城县  资溪县  金溪县  临川区  东乡县  赣抚平原
	 * @param input
	 * @return
	 */
	public InputEntity initModelByMinFlow(InputEntity input){
		Double[] minFlow = {0d,0d,0d,0d,0d,0d,0d,0d,0d,0d,0d,0d};
		List<Double[]> list = Lists.newArrayList();
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		input.setMinInstreamingEcologicalFlow(list);
		return input;
	}
	
	/**
	 * 各时段来水频率
	 * 数据顺序   广昌县   南丰县 乐安县  崇仁县  宜黄县  黎川县  南城县  资溪县  金溪县  临川区  东乡县  赣抚平原
	 * @param input
	 * @return
	 */
	public InputEntity initModelByFrequency(InputEntity input){
		Double[] minFlow = {0.75,0.75,0.75,0.75,0.75,0.75,0.75,0.75,0.75,0.75,0.75,0.75};
		List<Double[]> list = Lists.newArrayList();
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		list.add(minFlow);
		input.setInflowFrequency(list);
		return input;
	}
	
	/**
	 * 模型各区县需水总量输入
	 * 数据顺序   广昌县   南丰县 乐安县  崇仁县  宜黄县  黎川县  南城县  资溪县  金溪县  临川区  东乡县  赣抚平原
	 * @param initcondlist
	 * @param input
	 * @return
	 */
	public InputEntity initModelWw(List<TSfrdWtrplanInitcond> initcondlist, InputEntity input){
		//各区县需水总量
		Double[] selfFlow = new Double[12];
		for(int index = 0 ;index < initcondlist.size();index++ ){
			if(initcondlist.get(index)!=null && "112000023".equals(initcondlist.get(index).getEnCd())){
				selfFlow[0] = ModelUtils.getRslt(3, initcondlist.get(index).getWw());
			}else if(initcondlist.get(index)!=null && "112000024".equals(initcondlist.get(index).getEnCd())){
				selfFlow[1] = ModelUtils.getRslt(3, initcondlist.get(index).getWw());
			}else if(initcondlist.get(index)!=null && "112000025".equals(initcondlist.get(index).getEnCd())){
				selfFlow[6] = ModelUtils.getRslt(3, initcondlist.get(index).getWw());
			}else if(initcondlist.get(index)!=null && "112000026".equals(initcondlist.get(index).getEnCd())){
				selfFlow[5] = ModelUtils.getRslt(3, initcondlist.get(index).getWw());
			}else if(initcondlist.get(index)!=null && "112000027".equals(initcondlist.get(index).getEnCd())){
				selfFlow[7] = ModelUtils.getRslt(3, initcondlist.get(index).getWw());
			}else if(initcondlist.get(index)!=null && "112000028".equals(initcondlist.get(index).getEnCd())){
				selfFlow[8] = ModelUtils.getRslt(3, initcondlist.get(index).getWw());
			}else if(initcondlist.get(index)!=null && "112000029".equals(initcondlist.get(index).getEnCd())){
				selfFlow[9] = ModelUtils.getRslt(3, initcondlist.get(index).getWw());
			}else if(initcondlist.get(index)!=null && "112000030".equals(initcondlist.get(index).getEnCd())){
				selfFlow[4] = ModelUtils.getRslt(3, initcondlist.get(index).getWw());
			}else if(initcondlist.get(index)!=null && "112000031".equals(initcondlist.get(index).getEnCd())){
				selfFlow[3] = ModelUtils.getRslt(3, initcondlist.get(index).getWw());
			}else if(initcondlist.get(index)!=null && "112000032".equals(initcondlist.get(index).getEnCd())){
				selfFlow[2] = ModelUtils.getRslt(3, initcondlist.get(index).getWw());
			}else if(initcondlist.get(index)!=null && "112000033".equals(initcondlist.get(index).getEnCd())){
				selfFlow[10] =  ModelUtils.getRslt(3, initcondlist.get(index).getWw());
			}else if(initcondlist.get(index)!=null && "112000034".equals(initcondlist.get(index).getEnCd())){
				selfFlow[11] = ModelUtils.getRslt(3, initcondlist.get(index).getWw());
			}
		}
		input.setWaterRequirement(Arrays.asList(selfFlow));
		return input;
	}
	
	/**
	 * 模型用水比例输入
	 * 数据顺序   广昌县   南丰县 乐安县  崇仁县  宜黄县  黎川县  南城县  资溪县  金溪县  临川区  东乡县  赣抚平原
	 * @param wtList
	 * @param input
	 * @return
	 */
	public InputEntity initModelWt(List<TSfrdWsaWt> wtList, InputEntity input){
		Double[][] wt = new Double[4][wtList.size()];
		for(TSfrdWsaWt entity : wtList){
			if(null!=entity && "112000023".equals(entity.getEnCd())){
				wt = getArrayWt(wt, entity, 0);
			}else if(null!=entity && "112000024".equals(entity.getEnCd())){
				wt = getArrayWt(wt, entity,  1);
			}else if(null!=entity && "112000032".equals(entity.getEnCd())){
				wt = getArrayWt(wt, entity,  2);
			}else if(null!=entity && "112000031".equals(entity.getEnCd())){
				wt = getArrayWt(wt, entity,  3);
			}else if(null!=entity && "112000030".equals(entity.getEnCd())){
				wt = getArrayWt(wt, entity,  4);
			}else if(null!=entity && "112000026".equals(entity.getEnCd())){
				wt = getArrayWt(wt, entity,  5);
			}else if(null!=entity && "112000025".equals(entity.getEnCd())){
				wt = getArrayWt(wt, entity,  6);
			}else if(null!=entity && "112000027".equals(entity.getEnCd())){
				wt = getArrayWt(wt, entity,  7);
			}else if(null!=entity && "112000028".equals(entity.getEnCd())){
				wt = getArrayWt(wt, entity,  8);
			}else if(null!=entity && "112000029".equals(entity.getEnCd())){
				wt = getArrayWt(wt, entity,  9);
			}else if(null!=entity && "112000033".equals(entity.getEnCd())){
				wt = getArrayWt(wt, entity,  10);
			}else if(null!=entity && "112000034".equals(entity.getEnCd())){
				wt = getArrayWt(wt, entity,  11);
			}
		}
		input.setIndustrialWaterWeight(Arrays.asList(wt[0]));
		input.setAgriculturalWaterWeight(Arrays.asList(wt[1]));
		input.setDomesticWaterWeight(Arrays.asList(wt[2]));
		input.setForestryWaterWeight(Arrays.asList(wt[3]));
		return input;
	}
	
	/**
	 * 模型用水系数，回归系数输入
	 * 数据顺序   广昌县   南丰县 乐安县  崇仁县  宜黄县  黎川县  南城县  资溪县  金溪县  临川区  东乡县  赣抚平原
	 * @param dislist
	 * @param input
	 * @return
	 */
	public InputEntity initModelRatio(List<TSfrdDisWu> dislist, InputEntity input){
		//用水系数
		Map<String,Double[][]> maps = Maps.newConcurrentMap();
		//得到水量分配用水系数
		for(int i = 0 ; i < dislist.size(); i++){
			//广昌
			if(dislist.get(i)!=null && "112000023".equals(dislist.get(i).getEnCd())){
				List<TSfrdDisWu> sub = dislist.get(i).getSub();
				Double[][] ratio = getArrayValue(sub);
				maps.put("112000023", ratio);
			}else if(dislist.get(i)!=null && "112000024".equals(dislist.get(i).getEnCd())){//南丰
				List<TSfrdDisWu> sub = dislist.get(i).getSub();
				Double[][] ratio = getArrayValue(sub);
				maps.put("112000024", ratio);
			}else if(dislist.get(i)!=null && "112000032".equals(dislist.get(i).getEnCd())){//乐安
				List<TSfrdDisWu> sub = dislist.get(i).getSub();
				Double[][] ratio = getArrayValue(sub);
				maps.put("112000032", ratio);
			}else if(dislist.get(i)!=null && "112000031".equals(dislist.get(i).getEnCd())){//崇仁
				List<TSfrdDisWu> sub = dislist.get(i).getSub();
				Double[][] ratio = getArrayValue(sub);
				maps.put("112000031", ratio);
			}else if(dislist.get(i)!=null && "112000030".equals(dislist.get(i).getEnCd())){//宜黄
				List<TSfrdDisWu> sub = dislist.get(i).getSub();
				Double[][] ratio = getArrayValue(sub);
				maps.put("112000030", ratio);
			}else if(dislist.get(i)!=null && "112000026".equals(dislist.get(i).getEnCd())){//黎川
				List<TSfrdDisWu> sub = dislist.get(i).getSub();
				Double[][] ratio = getArrayValue(sub);
				maps.put("112000026", ratio);
			}else if(dislist.get(i)!=null && "112000025".equals(dislist.get(i).getEnCd())){//南城
				List<TSfrdDisWu> sub = dislist.get(i).getSub();
				Double[][] ratio = getArrayValue(sub);
				maps.put("112000025", ratio);
			}else if(dislist.get(i)!=null && "112000027".equals(dislist.get(i).getEnCd())){//资溪
				List<TSfrdDisWu> sub = dislist.get(i).getSub();
				Double[][] ratio = getArrayValue(sub);
				maps.put("112000027", ratio);
			}else if(dislist.get(i)!=null && "112000028".equals(dislist.get(i).getEnCd())){//金溪
				List<TSfrdDisWu> sub = dislist.get(i).getSub();
				Double[][] ratio = getArrayValue(sub);
				maps.put("112000028", ratio);
			}else if(dislist.get(i)!=null && "112000029".equals(dislist.get(i).getEnCd())){//临川
				List<TSfrdDisWu> sub = dislist.get(i).getSub();
				Double[][] ratio = getArrayValue(sub);
				maps.put("112000029", ratio);
			}else if(dislist.get(i)!=null && "112000033".equals(dislist.get(i).getEnCd())){//东乡
				List<TSfrdDisWu> sub = dislist.get(i).getSub();
				Double[][] ratio = getArrayValue(sub);
				maps.put("112000033", ratio);
			}else if(dislist.get(i)!=null && "112000034".equals(dislist.get(i).getEnCd())){//东乡
				List<TSfrdDisWu> sub = dislist.get(i).getSub();
				Double[][] ratio = getArrayValue(sub);
				maps.put("112000034", ratio);
			}
		}
		input.setIndustrialWaterRatio(getListArrays(maps,0));
		input.setAgriculturalWaterRatio(getListArrays(maps,1));
		input.setDomesticWaterRatio(getListArrays(maps,2));
		input.setForestryWaterRatio(getListArrays(maps,3));
		input.setIndustrialWaterReturnRatio(getListArrays(maps,4));
		input.setAgriculturalWaterReturnRatio(getListArrays(maps,5));
		input.setDomesticWaterReturnRatio(getListArrays(maps,6));
		input.setForestryWaterReturnRatio(getListArrays(maps,7));
		return input;
	}
	
	/**
	 * 从Map集合中，根据参数顺序，获取List<Double[]>类型数据
	 * 数据顺序   广昌县   南丰县 乐安县  崇仁县  宜黄县  黎川县  南城县  资溪县  金溪县  临川区  东乡县  赣抚平原
	 * @param map
	 * @param ParamsIndex
	 * @return
	 */
	public List<Double[]> getListArrays(Map<String,Double[][]> map, int ParamsIndex){
		List<Double[]> list = Lists.newArrayList();
		list.add(map.get("112000023")[ParamsIndex]);
		list.add(map.get("112000024")[ParamsIndex]);
		list.add(map.get("112000032")[ParamsIndex]);
		list.add(map.get("112000031")[ParamsIndex]);
		list.add(map.get("112000030")[ParamsIndex]);
		list.add(map.get("112000026")[ParamsIndex]);
		list.add(map.get("112000025")[ParamsIndex]);
		list.add(map.get("112000027")[ParamsIndex]);
		list.add(map.get("112000028")[ParamsIndex]);
		list.add(map.get("112000029")[ParamsIndex]);
		list.add(map.get("112000033")[ParamsIndex]);
		list.add(map.get("112000034")[ParamsIndex]);
		return list;
	}
	
	/**
	 * 把列表数据转换为二维数组数据
	 * @param list
	 *  数据顺序  工业 农业  生活  林牧渔 用水系数/回归系数
	 * @return
	 */
	public Double[][] getArrayValue(List<TSfrdDisWu> list){
		Double[][] ratio = new Double[8][list.size()];
		for(int index = 0 ; index < list.size() ;index++){
			ratio[0][index] = ModelUtils.getRslt(3, list.get(index).getIndWusWt()); //Double.valueOf(list.get(index).getIndWusWt());
			ratio[1][index] = ModelUtils.getRslt(3, list.get(index).getAgrWusWt());//Double.valueOf(list.get(index).getAgrWusWt());
			ratio[2][index] = ModelUtils.getRslt(3, list.get(index).getLifWusWt());//Double.valueOf(list.get(index).getLifWusWt());
			ratio[3][index] = ModelUtils.getRslt(3, list.get(index).getFafrWusWt());//Double.valueOf(list.get(index).getFafrWusWt());
			ratio[4][index] = ModelUtils.getRslt(3, list.get(index).getIndReWt());//Double.valueOf(list.get(index).getIndReWt());
			ratio[5][index] = ModelUtils.getRslt(3, list.get(index).getAgrReWt());//Double.valueOf(list.get(index).getAgrReWt());
			ratio[6][index] = ModelUtils.getRslt(3, list.get(index).getLifReWt());//Double.valueOf(list.get(index).getLifReWt());
			ratio[7][index] = ModelUtils.getRslt(3, list.get(index).getFafrReWt());//Double.valueOf(list.get(index).getFafrReWt());
		}
		return ratio;
	}
	
	/**
	 * 把对象数据转换为二维数组数据
	 * @param list
	 *  数据顺序  工业 农业  生活  林牧渔 用水比例
	 * @return
	 */
	public Double[][] getArrayWt(Double[][] wt, TSfrdWsaWt entity,int index){
		wt[0][index] = ModelUtils.getRslt(3, entity.getIndWt()); //Double.valueOf(entity.getIndWt());
		wt[1][index] = ModelUtils.getRslt(3, entity.getAgrWt());//Double.valueOf(entity.getAgrWt());
		wt[2][index] = ModelUtils.getRslt(3, entity.getLifWt());//Double.valueOf(entity.getLifWt());
		wt[3][index] = ModelUtils.getRslt(3, entity.getFafrWt());//Double.valueOf(entity.getFafrWt());
		return wt;
	}
	
	/**
	 * 设置洪门、廖坊的自产流量、生态流量、来水频率
	 * @param input
	 * @return
	 */
	public InputEntity setRsvr(InputEntity input){
		double[] hmInFlow = {175,175,175,175,175,175,175,175,175,175,175,175};
		double[] hmeFlow = {35,35,35,35,35,35,35,35,35,35,35,35};
		double[] hmfre = {0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5};
		input.setHMSKselfProducedInflow(hmInFlow);
		input.setHMSKminInstreamingEcologicalFlow(hmeFlow);
		input.setHMSKinflowFrequency(hmfre);
		double[] lfInFlow = {400,400,400,400,400,400,400,400,400,400,400,400};
		double[] lfeFlow = {60,60,60,60,60,60,60,60,60,60,60,60};
		double[] lffre = {0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5};
		input.setLFSKselfProducedInflow(lfInFlow);
		input.setLFSKminInstreamingEcologicalFlow(lfeFlow);
		input.setLFSKinflowFrequency(lffre);
		return input;
	}
	
	/**
	 * 保存模型计算结果
	 * @param result
	 * @return
	 */
	public ServiceResp saveData(ResultEntity result,TSfrdPro pro){
		ServiceResp resp = new ServiceResp();
		TSfrdDisWusRslt wus = new TSfrdDisWusRslt();
		wus.setProCd(pro.getProCd());
		//清楚方案所有的计算结果，重新保存结果
		tSfrdDisWusRsltService.remove(wus);
		//保存广昌县数据
		List<TSfrdDisWusRslt> gcxList = ModelUtils.getParamList(result, pro, 0,"112000023");
		resp = tSfrdDisWusRsltService.saveAll(gcxList);
		//保存南丰数据
		List<TSfrdDisWusRslt> nfxList = ModelUtils.getParamList(result, pro, 1,"112000024");
		resp = tSfrdDisWusRsltService.saveAll(nfxList);
		//保存南城数据
		List<TSfrdDisWusRslt> ncxList = ModelUtils.getParamList(result, pro, 6,"112000025");
		resp = tSfrdDisWusRsltService.saveAll(ncxList);
		//保存黎川数据
		List<TSfrdDisWusRslt> lcxList = ModelUtils.getParamList(result, pro, 5,"112000026");
		resp = tSfrdDisWusRsltService.saveAll(lcxList);
		//保存资溪数据
		List<TSfrdDisWusRslt> zxxList = ModelUtils.getParamList(result, pro, 7,"112000027");
		resp = tSfrdDisWusRsltService.saveAll(zxxList);
		//保存金溪数据
		List<TSfrdDisWusRslt> jxxList = ModelUtils.getParamList(result, pro, 8,"112000028");
		resp = tSfrdDisWusRsltService.saveAll(jxxList);
		//保存临川数据
		List<TSfrdDisWusRslt> lcqList = ModelUtils.getParamList(result, pro, 9,"112000029");
		resp = tSfrdDisWusRsltService.saveAll(lcqList);
		//保存宜黄数据
		List<TSfrdDisWusRslt> yhxList = ModelUtils.getParamList(result, pro, 4,"112000030");
		resp = tSfrdDisWusRsltService.saveAll(yhxList);
		//保存崇仁数据
		List<TSfrdDisWusRslt> crxList = ModelUtils.getParamList(result, pro, 3,"112000031");
		resp = tSfrdDisWusRsltService.saveAll(crxList);
		//保存乐安数据
		List<TSfrdDisWusRslt> laxList = ModelUtils.getParamList(result, pro, 2,"112000032");
		resp = tSfrdDisWusRsltService.saveAll(laxList);
		//保存东乡数据
		List<TSfrdDisWusRslt> dxxList = ModelUtils.getParamList(result, pro, 10,"112000033");
		resp = tSfrdDisWusRsltService.saveAll(dxxList);
		//保存赣抚平原灌区数据
		List<TSfrdDisWusRslt> gfpyList = ModelUtils.getParamList(result, pro, 11,"112000034");
		resp = tSfrdDisWusRsltService.saveAll(gfpyList);
		//保存方案进度
		resp = tSfrdProService.updateStat(pro.getProCd(), "3");
		return resp;
	}
	
}