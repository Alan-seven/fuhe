package com.jsite.szy.dispatch.meeting.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.jsite.busi.szy.dispatch.po.DdsRdEva;
import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.busi.szy.dispatch.service.DdsRdEvaService;
import com.jsite.busi.szy.dispatch.service.DdsRdPService;
import com.jsite.busi.szy.emergency.po.DdsEdEva;
import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.emergency.service.DdsEdEvaService;
import com.jsite.busi.szy.emergency.service.DdsEdPService;
import com.jsite.busi.szy.meeting.po.DdsSCon;
import com.jsite.busi.szy.meeting.po.DdsSFactor;
import com.jsite.busi.szy.meeting.po.DdsSFactorw;
import com.jsite.busi.szy.meeting.po.DdsSPro;
import com.jsite.busi.szy.meeting.service.DdsSConService;
import com.jsite.busi.szy.meeting.service.DdsSFactorService;
import com.jsite.busi.szy.meeting.service.DdsSFactorwService;
import com.jsite.busi.szy.meeting.service.DdsSProService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.meeting.bo.Factorw;
import com.jsite.szy.dispatch.meeting.vo.DdsSFactorwVO;

/**
 * 方案对比Controller
 * @author hjx
 * @version 2017-07-21
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/meeting/scompare")
public class SCompareController extends BaseController{


	@Autowired
	private DdsEdPService ddsEdPService;
	
	@Autowired
	private DdsSConService ddsSConService;
	
	@Autowired
	private DdsEdEvaService ddsEdEvaService;
	
	@Autowired
	private DdsSFactorService ddsSFactorService;
	
	@Autowired
	private DdsSFactorwService ddsSFactorwService;
	
	@Autowired
	private DdsSProService ddsSProService;
	
	@Autowired
	private DdsRdPService ddsRdPService;
	
	@Autowired
	private DdsRdEvaService ddsRdEvaService;
	
	/**
	 * 根据会商ID,查询对应的方案
	 * @param ddsEdPVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findByConId")
	public String findByConId(String conId,HttpServletResponse response){
		ServiceResp serviceResp = new ServiceResp();
		if(StringUtils.isNotBlank(conId)){
			Map<String,Object> map = Maps.newHashMap();
			//根据会商Id，获取会商信息
			DdsSCon ddsSCon = ddsSConService.get(conId);
			map.put("ddsSCon", ddsSCon);
			List<DdsSFactor> factorlist = listFactor(ddsSCon);
			map.put("factorlist", factorlist);
			
			//会商方案评价规则表信息
			DdsSFactorw ddsSFactorw = new DdsSFactorw();
			ddsSFactorw.setConId(conId);
			Page<DdsSFactorw> pgw = new Page<DdsSFactorw>();
			pgw.setOrderBy(" a.fact_id asc ");
			Page<DdsSFactorw> pagew = ddsSFactorwService.getPage(pgw,ddsSFactorw);
			List<DdsSFactorw> factorwlist = pagew.getList();
				
			if(factorwlist.size() <= 0 ){
				if(ddsSCon!=null&& "1".equals(ddsSCon.getConType())){//常规调度
					//赋值，并写入数据库
					for(DdsSFactor factor : factorlist){
						if(factor.getFactNm().contains("期末水位")){
							ddsSFactorw.setFactId(factor.getFactId());
							ddsSFactorw.setScoreMax("100");
							ddsSFactorw.setScoreMin("60");
							ddsSFactorw.setWeight("0.2");
						}else if(factor.getFactNm().contains("供水量")){
							ddsSFactorw.setFactId(factor.getFactId());
							ddsSFactorw.setScoreMax("100");
							ddsSFactorw.setScoreMin("60");
							ddsSFactorw.setWeight("0.2");
						}else if(factor.getFactNm().contains("缺水量")){
							ddsSFactorw.setFactId(factor.getFactId());
							ddsSFactorw.setScoreMax("100");
							ddsSFactorw.setScoreMin("60");
							ddsSFactorw.setWeight("0.2");
						}else if(factor.getFactNm().contains("月最小出力")){
							ddsSFactorw.setFactId(factor.getFactId());
							ddsSFactorw.setScoreMax("100");
							ddsSFactorw.setScoreMin("60");
							ddsSFactorw.setWeight("0.2");
						}else if(factor.getFactNm().contains("发电量")){
							ddsSFactorw.setFactId(factor.getFactId());
							ddsSFactorw.setScoreMax("100");
							ddsSFactorw.setScoreMin("60");
							ddsSFactorw.setWeight("0.1");
						}else if(factor.getFactNm().contains("弃水量")){
							ddsSFactorw.setFactId(factor.getFactId());
							ddsSFactorw.setScoreMax("100");
							ddsSFactorw.setScoreMin("60");
							ddsSFactorw.setWeight("0.1");
						}
						ddsSFactorwService.save(ddsSFactorw);
					}
				}else if(ddsSCon!=null&&"3".equals(ddsSCon.getConType())){//应急调度
					//赋值，并写入数据库
					for(DdsSFactor factor : factorlist){
						if(factor.getFactNm().contains("时长")){
							ddsSFactorw.setFactId(factor.getFactId());
							ddsSFactorw.setScoreMax("100");
							ddsSFactorw.setScoreMin("60");
							ddsSFactorw.setWeight("0.2");
						}else if(factor.getFactNm().contains("取水口")){
							ddsSFactorw.setFactId(factor.getFactId());
							ddsSFactorw.setScoreMax("100");
							ddsSFactorw.setScoreMin("60");
							ddsSFactorw.setWeight("0.3");
						}else if(factor.getFactNm().contains("耗水量")){
							ddsSFactorw.setFactId(factor.getFactId());
							ddsSFactorw.setScoreMax("100");
							ddsSFactorw.setScoreMin("70");
							ddsSFactorw.setWeight("0.3");
						}else if(factor.getFactNm().contains("损失")){
							ddsSFactorw.setFactId(factor.getFactId());
							ddsSFactorw.setScoreMax("100");
							ddsSFactorw.setScoreMin("60");
							ddsSFactorw.setWeight("0.2");
						}
						ddsSFactorwService.save(ddsSFactorw);
					}
				}
			}	
				
			if(ddsSCon!=null&& "1".equals(ddsSCon.getConType())){//常规调度
				String proTp = ddsSCon.getProTp();
				DdsRdP ddsRdP = new DdsRdP();
				ddsRdP.setProTp(ddsSCon.getProTp());
				//获取常规调度方案起始、截止时间
				ddsRdP = getTime(ddsSCon,ddsRdP);
				ddsRdP.setSta(4);
				List<DdsRdP> rdPlist = ddsRdPService.listByMeeting(ddsRdP);
				
				//根据方案，查询方案对应的指标值
				for(DdsRdP vo : rdPlist){
					DdsRdEva ddsRdEva = new DdsRdEva();
					ddsRdEva.setProCd(vo.getProCd());
					List<DdsRdEva> evalist = ddsRdEvaService.list(ddsRdEva);
					vo.setList(evalist);
				}
				//计算得分
				factorwlist = ddsSFactorwService.list(ddsSFactorw);
				if(factorwlist.size() > 0  ){
					countDc(ddsSCon, rdPlist);
				}
				
				List<Factorw> ruleslist = getFactorw(factorlist,factorwlist);
				map.put("ruleslist", ruleslist);
				List<Factorw> factlist = new ArrayList<Factorw>();
				for(DdsRdP entity : rdPlist){
					Factorw fw = new Factorw();
					fw.setProCd(entity.getProCd());
					fw.setName(entity.getProNm());
					//获取每一个方案的得分
					DdsSPro ddsSPro = new DdsSPro();
					ddsSPro.setProId(entity.getProCd());
					ddsSPro.setConId(conId);
					ddsSPro = ddsSProService.get(ddsSPro);
					if(null!=ddsSPro){
						fw.setScores(ddsSPro.getGrade());
					}
					
					if(entity.getProCd().equals(ddsSCon.getProIdRec())){
						fw.setFlag(1);
					}
					Map<String,Object> mp = Maps.newHashMap();
					List<DdsRdEva> evalist = entity.getList();
					for(int j = 0 ; j < evalist.size();j++){
						DdsRdEva eva = evalist.get(j);
						mp.put(eva.getFactId(), eva.getValue());
					}
					fw.setMap(mp);
					factlist.add(fw);
				}
				map.put("edplist", factlist);
			
			}else if(ddsSCon!=null&& "3".equals(ddsSCon.getConType())){//应急调度
				//根据会商信息得到会商对应的应急事件
				DdsEdP ddsEdP = new DdsEdP();
				ddsEdP.setEvenCd(ddsSCon.getEvenCd());
				ddsEdP.setSta(4);
				List<DdsEdP> list = ddsEdPService.list(ddsEdP);
				//根据方案，查询方案对应的指标值
				for(DdsEdP vo : list){
					DdsEdEva ddsEdEva = new DdsEdEva();
					ddsEdEva.setProCd(vo.getProCd());
					List<DdsEdEva> evalist = ddsEdEvaService.list(ddsEdEva);
					vo.setList(evalist);
				}
				//计算得分
				factorwlist = ddsSFactorwService.list(ddsSFactorw);
				if(factorwlist.size() > 0 ){
					count(ddsSCon, list);
				}
				
				List<Factorw> ruleslist = getFactorw(factorlist,factorwlist);
				map.put("ruleslist", ruleslist);
				List<Factorw> factlist = new ArrayList<Factorw>();
				for(DdsEdP entity : list){
					Factorw fw = new Factorw();
					fw.setProCd(entity.getProCd());
					fw.setName(entity.getProNm());
					//获取每一个方案的得分
					DdsSPro ddsSPro = new DdsSPro();
					ddsSPro.setProId(entity.getProCd());
					ddsSPro.setConId(conId);
					ddsSPro = ddsSProService.get(ddsSPro);
					if(null!=ddsSPro){
						fw.setScores(ddsSPro.getGrade());
					}
					
					if(entity.getProCd().equals(ddsSCon.getProIdRec())){
						fw.setFlag(1);
					}
					Map<String,Object> mp = Maps.newHashMap();
					List<DdsEdEva> evalist = entity.getList();
					for(int j = 0 ; j < evalist.size();j++){
						DdsEdEva eva = evalist.get(j);
						mp.put(eva.getFactId(), eva.getValue());
					}
					fw.setMap(mp);
					factlist.add(fw);
				}
				map.put("edplist", factlist);
			}
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg("计算得分成功");
			map.put("serviceResp", serviceResp);
			return renderString(response,map);
		}else{
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG+",会商ID不能为空");
			logger.warn("会商ID不能为空");
			return renderString(response,serviceResp);
		}
	}
	
	/**
	 * 更新评分规则设置
	 * @param DdsSFactorwVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "update",consumes = "application/json")
	public String update(@RequestBody List<DdsSFactorwVO> volist, HttpServletResponse response) {
		Map<String,Object> map = Maps.newHashMap();
		ServiceResp serviceResp = new ServiceResp();
		String conId = null;
		//保存评分规则
		if(null!=volist){
			for(DdsSFactorwVO vo : volist){
				DdsSFactorw ddsSFactorw = new DdsSFactorw();
				if (null != vo) {
					ddsSFactorw = BeanMapper.map(vo, ddsSFactorw.getClass());
				}
				if(StringUtils.isNotBlank(ddsSFactorw.getConId())){
					conId = ddsSFactorw.getConId();
				}else{
					serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
					serviceResp.setMsg("会商ID不能为空！");
					logger.warn("会商ID不能为空");
					return  renderString(response, serviceResp);
				}
				if(StringUtils.isNotBlank(ddsSFactorw.getScoreMax())){
					serviceResp = ddsSFactorwService.updateScoreMax(ddsSFactorw);
				}else if(StringUtils.isNotBlank(ddsSFactorw.getScoreMin())){
					serviceResp = ddsSFactorwService.updateScoreMin(ddsSFactorw);
				}else if(StringUtils.isNotBlank(ddsSFactorw.getWeight())){
					serviceResp = ddsSFactorwService.updateWeight(ddsSFactorw);
				}
			}
		}
		if(serviceResp.getCode()==1){//保存成功
			if(StringUtils.isNotBlank(conId)){
				//根据会商Id，获取会商信息
				DdsSCon ddsSCon = ddsSConService.get(conId);
				map.put("ddsSCon", ddsSCon);
				List<DdsSFactor> factorlist = listFactor(ddsSCon);
				map.put("factorlist", factorlist);
				
				//会商方案评价规则表信息
				DdsSFactorw ddsSFactorw = new DdsSFactorw();
				ddsSFactorw.setConId(conId);
				Page<DdsSFactorw> pgw = new Page<DdsSFactorw>();
				pgw.setOrderBy(" a.fact_id asc ");
				Page<DdsSFactorw> pagew = ddsSFactorwService.getPage(pgw,ddsSFactorw);
				List<DdsSFactorw> factorwlist = pagew.getList();
					
					
				if(ddsSCon!=null&& "1".equals(ddsSCon.getConType())){//常规调度
					String proTp = ddsSCon.getProTp();
					DdsRdP ddsRdP = new DdsRdP();
					ddsRdP.setProTp(ddsSCon.getProTp());
					//获取常规调度方案起始、截止时间
					ddsRdP = getTime(ddsSCon,ddsRdP);
					ddsRdP.setSta(4);
					List<DdsRdP> rdPlist = ddsRdPService.listByMeeting(ddsRdP);
					
					//根据方案，查询方案对应的指标值
					for(DdsRdP vo : rdPlist){
						DdsRdEva ddsRdEva = new DdsRdEva();
						ddsRdEva.setProCd(vo.getProCd());
						List<DdsRdEva> evalist = ddsRdEvaService.list(ddsRdEva);
						vo.setList(evalist);
					}
					//计算得分
					factorwlist = ddsSFactorwService.list(ddsSFactorw);
					if(factorwlist.size() > 0  ){
						countDc(ddsSCon, rdPlist);
					}
					
					List<Factorw> ruleslist = getFactorw(factorlist,factorwlist);
					map.put("ruleslist", ruleslist);
					List<Factorw> factlist = new ArrayList<Factorw>();
					for(DdsRdP entity : rdPlist){
						Factorw fw = new Factorw();
						fw.setProCd(entity.getProCd());
						fw.setName(entity.getProNm());
						//获取每一个方案的得分
						DdsSPro ddsSPro = new DdsSPro();
						ddsSPro.setProId(entity.getProCd());
						ddsSPro.setConId(conId);
						ddsSPro = ddsSProService.get(ddsSPro);
						if(null!=ddsSPro){
							fw.setScores(ddsSPro.getGrade());
						}
						
						if(entity.getProCd().equals(ddsSCon.getProIdRec())){
							fw.setFlag(1);
						}
						Map<String,Object> mp = Maps.newHashMap();
						List<DdsRdEva> evalist = entity.getList();
						for(int j = 0 ; j < evalist.size();j++){
							DdsRdEva eva = evalist.get(j);
							mp.put(eva.getFactId(), eva.getValue());
						}
						fw.setMap(mp);
						factlist.add(fw);
					}
					map.put("edplist", factlist);
				
				}else if(ddsSCon!=null&& "3".equals(ddsSCon.getConType())){//应急调度
					//根据会商信息得到会商对应的应急事件
					DdsEdP ddsEdP = new DdsEdP();
					ddsEdP.setEvenCd(ddsSCon.getEvenCd());
					ddsEdP.setSta(4);
					List<DdsEdP> list = ddsEdPService.list(ddsEdP);
					//根据方案，查询方案对应的指标值
					for(DdsEdP vo : list){
						DdsEdEva ddsEdEva = new DdsEdEva();
						ddsEdEva.setProCd(vo.getProCd());
						List<DdsEdEva> evalist = ddsEdEvaService.list(ddsEdEva);
						vo.setList(evalist);
					}
					//计算得分
					factorwlist = ddsSFactorwService.list(ddsSFactorw);
					if(factorwlist.size() > 0 ){
						count(ddsSCon, list);
					}
					
					List<Factorw> ruleslist = getFactorw(factorlist,factorwlist);
					map.put("ruleslist", ruleslist);
					List<Factorw> factlist = new ArrayList<Factorw>();
					for(DdsEdP entity : list){
						Factorw fw = new Factorw();
						fw.setProCd(entity.getProCd());
						fw.setName(entity.getProNm());
						//获取每一个方案的得分
						DdsSPro ddsSPro = new DdsSPro();
						ddsSPro.setProId(entity.getProCd());
						ddsSPro.setConId(conId);
						ddsSPro = ddsSProService.get(ddsSPro);
						if(null!=ddsSPro){
							fw.setScores(ddsSPro.getGrade());
						}
						
						if(entity.getProCd().equals(ddsSCon.getProIdRec())){
							fw.setFlag(1);
						}
						Map<String,Object> mp = Maps.newHashMap();
						List<DdsEdEva> evalist = entity.getList();
						for(int j = 0 ; j < evalist.size();j++){
							DdsEdEva eva = evalist.get(j);
							mp.put(eva.getFactId(), eva.getValue());
						}
						fw.setMap(mp);
						factlist.add(fw);
					}
					map.put("edplist", factlist);
				}
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
				serviceResp.setMsg("计算得分成功");
				map.put("serviceResp", serviceResp);
			}
		}else{
			serviceResp.setMsg("会商ID不可为空！");
			return renderString(response,serviceResp);
		}
		return renderString(response,map);
	}
	
	/**
	 * 评分规则设置 ---把列数据转换为行数据
	 * @param factorlist
	 * @param factorwlist
	 * @return
	 */
	public List<Factorw> getFactorw(List<DdsSFactor> factorlist,List<DdsSFactorw> factorwlist){
		List<Factorw> ruleslist = new ArrayList();
		Factorw max = new Factorw();//最优得分
		max.setProCd("scoreMax");
		max.setName("最优指标得分");
		Factorw min = new Factorw();//最劣得分
		min.setProCd("scoreMin");
		min.setName("最劣指标得分");
		Factorw weight = new Factorw();//权重
		weight.setProCd("weight");
		weight.setName("指标权重");
		Map<String,Object> maxMap = Maps.newHashMap();
		Map<String,Object> minMap = Maps.newHashMap();
		Map<String,Object> weightMap = Maps.newHashMap();
		
		for(DdsSFactor factor : factorlist){
			for(DdsSFactorw entity : factorwlist){
				if(factor.getFactId().equals(entity.getFactId())){
					if(null!=entity.getScoreMax()){
						maxMap.put(entity.getFactId(), Double.parseDouble(entity.getScoreMax()));
					}
					if(null!=entity.getScoreMin()){
						minMap.put(entity.getFactId(), Double.parseDouble(entity.getScoreMin()));
					}
					if(null!=entity.getWeight()){
						weightMap.put(entity.getFactId(), Double.parseDouble(entity.getWeight()));
					}
				}
			}
		}
		max.setMap(maxMap);
		min.setMap(minMap);
		weight.setMap(weightMap);
		ruleslist.add(max);
		ruleslist.add(min);
		ruleslist.add(weight);
		return ruleslist;
	}
	
	
	/**
	 * 计算得分--常规调度
	 * @param ddsSCon	会商信息
	 * @param list	方案信息，包含评价结果
	 */
	public void countDc(DdsSCon ddsSCon,List<DdsRdP> list){
		
		Map<String,DdsRdEva> maps = Maps.newHashMap();
		Map<String,DdsSFactorw> maprules = Maps.newHashMap();
		String proCds="";
		for(DdsRdP vo : list){
			proCds+=vo.getProCd()+",";
		}
		DdsRdEva rdEva = new DdsRdEva();
		if(StringUtils.isNotBlank(proCds)){
			proCds = proCds.substring(0, proCds.length()-1);
			rdEva.setProCds(proCds);
		}
		for(DdsRdP vo : list){
			List<DdsRdEva> evalist = vo.getList();
			DdsSPro ddsSPro = new DdsSPro();
			ddsSPro.setProId(vo.getProCd());
			ddsSPro.setConId(ddsSCon.getConId());
			//方案中每一个指标的加权
			double factDouble = 0.0d;
			for(int i = 0 ; i < evalist.size();i++){
				DdsRdEva evavo = evalist.get(i);
				String factId = evavo.getFactId();
				//每一个指标值
				Double everyValue = evavo.getValue();
				
				//根据应急事件id，查询应急事件对于的所有方案中单一指标的最大值，最小值
				DdsRdEva maxmin = null;
				if(null != maps.get(factId)){
					maxmin = maps.get(factId);
				}else{
					rdEva.setFactId(factId);
					//每一个指标最大最小值
					maxmin= ddsRdEvaService.getMaxMIn(rdEva);
					maps.put(factId, maxmin);
				}
				
				//每一个指标最大值
				Double maxvalue = maxmin.getMavalue();
				//每一个指标最小值
				Double minvalue = maxmin.getMivalue();
				
				DdsSFactorw ddsSFactorw = new DdsSFactorw();
				if(null!=maprules.get(factId)){
					ddsSFactorw = maprules.get(factId);
				}else{
					ddsSFactorw.setConId(ddsSCon.getConId());
					ddsSFactorw.setFactId(factId);
					//得到每一个指标的评价规则
					ddsSFactorw =ddsSFactorwService.get(ddsSFactorw);
					maprules.put(factId, ddsSFactorw);
				}
				
				
				Double factValue = 0.0d;
				Double sMax = 0.0d;//每一个指标最优得分
				Double sMin = 0.0d;//每一个指标最劣得分
				Double sweight = 0.0d;//每一个指标权重
				String scoreMax = ddsSFactorw.getScoreMax();
				if(null != scoreMax){
					sMax =  Double.valueOf(scoreMax);
				}
				String scoreMin = ddsSFactorw.getScoreMin();
				if(null != scoreMin){
					sMin =  Double.valueOf(scoreMin);
				}
				String weight = ddsSFactorw.getWeight();
				if(null != weight){
					sweight =  Double.valueOf(weight);
				}
				
				if(maxvalue==everyValue){
					factValue = sMax;
				}else if(minvalue==everyValue){
					factValue = sMin;
				}else{
					factValue = getInterpolation(minvalue,sMax,maxvalue,sMin,everyValue);
				}
				factDouble=factDouble+factValue*sweight;
			}
			ddsSPro.setGrade(String.valueOf(factDouble));
			DdsSPro entity = ddsSProService.get(ddsSPro);
			if(null!=entity){
				 ddsSProService.update(ddsSPro);
			}else{
				 ddsSProService.save(ddsSPro);
			}
		}
	}
	
	/**
	 * 计算得分
	 * @param ddsSCon	会商信息
	 * @param list	方案信息，包含评价结果
	 */
	public void count(DdsSCon ddsSCon,List<DdsEdP> list){
		
		Map<String,DdsEdEva> maps = Maps.newHashMap();
		Map<String,DdsSFactorw> maprules = Maps.newHashMap();
		for(DdsEdP vo : list){
			List<DdsEdEva> evalist = vo.getList();
			DdsSPro ddsSPro = new DdsSPro();
			ddsSPro.setProId(vo.getProCd());
			ddsSPro.setConId(ddsSCon.getConId());
			//方案中每一个指标的加权
			double factDouble = 0.0d;
			for(int i = 0 ; i < evalist.size();i++){
				DdsEdEva evavo = evalist.get(i);
				String factId = evavo.getFactId();
				//每一个指标值
				Double everyValue = evavo.getValue();
				
				//根据应急事件id，查询应急事件对于的所有方案中单一指标的最大值，最小值
				DdsEdEva maxmin = null;
				if(null != maps.get(factId)){
					maxmin = maps.get(factId);
				}else{
					DdsEdEva eva = new DdsEdEva();
					eva.setEvenCd(ddsSCon.getEvenCd());
					eva.setFactId(factId);
					//每一个指标最大最小值
					maxmin= ddsEdEvaService.getMaxMIn(eva);
					maps.put(factId, maxmin);
				}
				
				//每一个指标最大值
				Double maxvalue = maxmin.getMavalue();
				//每一个指标最小值
				Double minvalue = maxmin.getMivalue();
				
				DdsSFactorw ddsSFactorw = new DdsSFactorw();
				if(null!=maprules.get(factId)){
					ddsSFactorw = maprules.get(factId);
				}else{
					ddsSFactorw.setConId(ddsSCon.getConId());
					ddsSFactorw.setFactId(factId);
					//得到每一个指标的评价规则
					ddsSFactorw =ddsSFactorwService.get(ddsSFactorw);
					maprules.put(factId, ddsSFactorw);
				}
				
				
				Double factValue = 0.0d;
				Double sMax = 0.0d;//每一个指标最优得分
				Double sMin = 0.0d;//每一个指标最劣得分
				Double sweight = 0.0d;//每一个指标权重
				String scoreMax = ddsSFactorw.getScoreMax();
				if(null != scoreMax){
					sMax =  Double.valueOf(scoreMax);
				}
				String scoreMin = ddsSFactorw.getScoreMin();
				if(null != scoreMin){
					sMin =  Double.valueOf(scoreMin);
				}
				String weight = ddsSFactorw.getWeight();
				if(null != weight){
					sweight =  Double.valueOf(weight);
				}
				
				if(maxvalue==everyValue){
					factValue = sMax;
				}else if(minvalue==everyValue){
					factValue = sMin;
				}else{
					factValue = getInterpolation(minvalue,sMax,maxvalue,sMin,everyValue);
				}
				factDouble=factDouble+factValue*sweight;
			}
			ddsSPro.setGrade(String.valueOf(factDouble));
			DdsSPro entity = ddsSProService.get(ddsSPro);
			if(null!=entity){
				 ddsSProService.update(ddsSPro);
			}else{
				 ddsSProService.save(ddsSPro);
			}
		}
	}
	
	//得到线性插值
	public double getInterpolation(Double x0,Double y0,Double x1,Double y1,Double x){
		if(x1-x0!=0){
			return y0+(((y1-y0)/(x1-x0))*(x-x0));
		}else{
			return y0;
		}
	}
	
	//根据常规调度会商类似，组装常规调度方案起始、截止时间
	public DdsRdP getTime(DdsSCon ddsSCon,DdsRdP ddsRdp){
		Date bgDt = new Date();		// 起始时间
		Date edDt = new Date();		// 终止时间
		int year = 2017;
		int month = 1;
		int tenday = 1;
		Calendar cal = Calendar.getInstance();
		if("1".equals(ddsSCon.getProTp())){//年调度
			year = ddsSCon.getYear();
			cal.clear();  
			cal.set(Calendar.YEAR, year);
			bgDt =  cal.getTime();//设置开始时间
			cal.set(Calendar.YEAR, year+1);//设置结束时间
			edDt = cal.getTime();
		}else if("2".equals(ddsSCon.getProTp())){//月调度
			month = ddsSCon.getMonth();
			cal.clear();  
			cal.set(Calendar.MONTH, month);//设置开始时间
			bgDt =  cal.getTime();
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  
			cal.set(Calendar.DAY_OF_MONTH, lastDay);  //设置结束时间
			edDt = cal.getTime();
		}else if("3".equals(ddsSCon.getProTp())){//旬调度
			tenday = ddsSCon.getTenDay();
			cal.clear();  
			cal.set(Calendar.MONTH, month);//设置开始时间
			if(tenday==1){//上旬
				cal.set(Calendar.DAY_OF_MONTH, 1);
				bgDt =  cal.getTime();
				cal.set(Calendar.DAY_OF_MONTH, 10);
				edDt = cal.getTime();
			}else if(tenday==2){//中旬
				cal.set(Calendar.DAY_OF_MONTH, 11);
				bgDt =  cal.getTime();
				cal.set(Calendar.DAY_OF_MONTH, 20);
				edDt = cal.getTime();
			}else if(tenday==3){//下旬
				cal.set(Calendar.DAY_OF_MONTH, 21);
				bgDt =  cal.getTime();
				int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  
				cal.set(Calendar.DAY_OF_MONTH, lastDay);  //设置结束时间
				edDt = cal.getTime();
			}
		}
		ddsRdp.setBgDt(bgDt);
		ddsRdp.setEdDt(edDt);
		return ddsRdp;
	}
	
	public List<DdsSFactor> listFactor(DdsSCon ddsSCon){
		//获取所有指标信息列表
		Page<DdsSFactor> pg = new Page<DdsSFactor>();
		pg.setOrderBy(" a.fact_id asc ");
		DdsSFactor factorVO = new DdsSFactor();
		if(ddsSCon!=null&& "1".equals(ddsSCon.getConType())){
			factorVO.setFactTp("1");
		}else if(ddsSCon!=null&& "3".equals(ddsSCon.getConType())){//应急调度
			factorVO.setFactTp("3");
		}
		Page<DdsSFactor> page = ddsSFactorService.getPage(pg, factorVO);
		return page.getList();
	}
	
}