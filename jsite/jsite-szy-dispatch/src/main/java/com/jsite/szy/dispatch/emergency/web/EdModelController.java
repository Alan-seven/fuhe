package com.jsite.szy.dispatch.emergency.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jsite.busi.szy.emergency.po.DdsEdBound;
import com.jsite.busi.szy.emergency.po.DdsEdGis;
import com.jsite.busi.szy.emergency.po.DdsEdGisLegend;
import com.jsite.busi.szy.emergency.po.DdsEdInit;
import com.jsite.busi.szy.emergency.po.DdsEdMedel;
import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.emergency.po.DdsEdRes;
import com.jsite.busi.szy.emergency.po.DdsEdRsv;
import com.jsite.busi.szy.emergency.po.DdsEdSource;
import com.jsite.busi.szy.emergency.po.DdsMBoundry;
import com.jsite.busi.szy.emergency.po.DdsMConsec;
import com.jsite.busi.szy.emergency.po.DdsMRsv;
import com.jsite.busi.szy.emergency.po.DdsMRsvr;
import com.jsite.busi.szy.emergency.po.EDResData;
import com.jsite.busi.szy.emergency.service.DdsEdBoundService;
import com.jsite.busi.szy.emergency.service.DdsEdGisLegendService;
import com.jsite.busi.szy.emergency.service.DdsEdGisService;
import com.jsite.busi.szy.emergency.service.DdsEdInitService;
import com.jsite.busi.szy.emergency.service.DdsEdMedelService;
import com.jsite.busi.szy.emergency.service.DdsEdPService;
import com.jsite.busi.szy.emergency.service.DdsEdResService;
import com.jsite.busi.szy.emergency.service.DdsEdRsvService;
import com.jsite.busi.szy.emergency.service.DdsEdSourceService;
import com.jsite.busi.szy.emergency.service.DdsMBoundryService;
import com.jsite.busi.szy.emergency.service.DdsMConsecService;
import com.jsite.busi.szy.emergency.service.DdsMRsvService;
import com.jsite.busi.szy.emergency.service.DdsMRsvrService;
import com.jsite.busi.szy.info.po.DdsDrRiver;
import com.jsite.busi.szy.info.po.DdsDrRsvr;
import com.jsite.busi.szy.info.service.DdsDrRiverService;
import com.jsite.busi.szy.info.service.DdsDrRsvrService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.mconfig.EDGisData;
import com.jsite.szy.dispatch.emergency.mconfig.EdModelUtils;
import com.jsite.szy.dispatch.emergency.vo.DdsEdPVO;
import com.jsite.szy.dispatch.emergency.vo.DdsEdRsvVO;

/**
 * 应急调度模拟 Controller
 * @author hjx
 * @version 2017-07-07
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/edmodel")
public class EdModelController extends BaseController {

	@Autowired
	private DdsEdPService ddsEdPService;
	
	@Autowired
	private DdsDrRiverService ddsDrRiverService;
	
	@Autowired
	private DdsDrRsvrService ddsDrRsvrService;
	
	@Autowired
	private DdsMBoundryService ddsMBoundryService;
	
	@Autowired
	private DdsMConsecService ddsMConsecService;
	
	@Autowired
	private DdsMRsvService ddsMRsvService;
	
	@Autowired
	private DdsEdBoundService ddsEdBoundService;
	
	@Autowired
	private DdsMRsvrService ddsMRsvrService;
	
	@Autowired
	private DdsEdRsvService ddsEdRsvService;
	
	@Autowired
	private DdsEdMedelService ddsEdMedelService;
	
	@Autowired
	private DdsEdResService ddsEdResService;
	
	@Autowired
	private DdsEdInitService ddsEdInitService;
	
	@Autowired
	private DdsEdGisService ddsEdGisService;
	
	@Autowired
	private DdsEdGisLegendService ddsEdGisLegendService;
	
	@Autowired
	private DdsEdSourceService ddsEdSourceService;
		
	/**
	 * 污染模拟边界条件初始化
	 * @param ddsEdPVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "initboundry")
	public String initBoundry(DdsEdPVO ddsEdPVO, HttpServletResponse response){
		ServiceResp serviceResp = new ServiceResp();
		Map<String,Object> map = Maps.newHashMap();
		//根据方案id，得到方案的河流代码
		DdsEdP ddsEdP = ddsEdPService.get(ddsEdPVO.getProCd());
		if(null==ddsEdP.getForTime()){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("第一步预热期数据不可为空");
			logger.warn("第一步预热期数据不可为空!");
			return renderString(response, serviceResp);
		}
		if(null==ddsEdP.getSta()){
			ddsEdP.setSta(1);//设置状态为第一步
			ddsEdPService.update(ddsEdP);
			DdsEdMedel medel = new DdsEdMedel();
			DdsEdMedel entity = ddsEdMedelService.get(medel);
			if(entity==null){
				medel.setProCd(ddsEdPVO.getProCd());
				medel.setR(0.02);
				medel.setK(0.3);
				medel.setA(0.01);
				ddsEdMedelService.save(medel);
			}
		}
		int rcd = ddsEdPVO.getRcd();
		//初始化数据
		Date bgDt = ddsEdP.getBgDt();
		Date edDt = ddsEdP.getEdDt();
		//得到边界设置内容
		DdsMBoundry mboundry = new DdsMBoundry();
		mboundry.setRcd(rcd);
		List<DdsMBoundry> listBoundry = ddsMBoundryService.list(mboundry);
		if(listBoundry.size()<=0){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("请初始化河段模型边界表数据！");
			logger.warn("请初始化河段模型边界表数据!");
			return renderString(response, serviceResp);
		}
		map.put("listBoundry", listBoundry);
		DdsEdBound ddsEdBound = new DdsEdBound();
		ddsEdBound.setProCd(ddsEdPVO.getProCd());
		ddsEdBound.setStartTime(DateUtils.formatDateTime(bgDt));
		ddsEdBound.setEndTime(DateUtils.formatDateTime(edDt));
		//应急调度边界条件表无数据时，进行实时数据插值初始化
		List<DdsEdBound> boundlist = ddsEdBoundService.list(ddsEdBound);
				
		if(boundlist!=null &&boundlist.size()<=0){
			for(int i = 0 ; i < listBoundry.size();i++){
				mboundry = listBoundry.get(i);
				String fieldNm = mboundry.getFieldnm();
				if("Z".equals(fieldNm)||"Q".equals(fieldNm)){//查河流表
					DdsDrRiver ddsDrRiver = new DdsDrRiver();
					ddsDrRiver.setStcd(mboundry.getStcd());
					ddsDrRiver.setStartTime(DateUtils.formatDateTime(ddsEdP.getBgDt()));
					ddsDrRiver.setEndTime(DateUtils.formatDateTime(ddsEdP.getEdDt()));
					List<DdsDrRiver> riverlist = ddsDrRiverService.listByStcd(ddsDrRiver);
					//插值处理
					List<Date> listDate = EdModelUtils.getDateBetweenTwoDate(bgDt, edDt);
					if(riverlist.size()<=0){
						//循环所有预初始化的值  -河流表无监测数据时，写入方案ID，测站编码   监测时间  类型  插入默认值
						for(int k = 0 ; k < listDate.size();k++){
							Date tm = listDate.get(k);
							ddsEdBound = new DdsEdBound();
							ddsEdBound.setProCd(ddsEdPVO.getProCd());
							ddsEdBound.setStcd(mboundry.getStcd());
							ddsEdBound.setTm(tm);
							ddsEdBound.setZ(mboundry.getDefaultValue());
							ddsEdBound.setQ(mboundry.getDefaultValue());
							ddsEdBound.setQtype(2);
							DdsEdBound vo = ddsEdBoundService.get(ddsEdBound);
							if(null==vo){//预初始化的值如果不存在的话，就保存到
								ddsEdBoundService.save(ddsEdBound);
							}
						}
					}else{
						riverlist = EdModelUtils.getFullDrRiver(listDate, riverlist);
						riverlist = EdModelUtils.getListRiverByIn(riverlist);
						//循环所有预初始化的值  --  河流表有监测数据时
						for(int k = 0 ; k < riverlist.size();k++){
							ddsDrRiver = riverlist.get(k);
							ddsEdBound = new DdsEdBound();
							ddsEdBound.setProCd(ddsEdPVO.getProCd());
							ddsEdBound.setStcd(mboundry.getStcd());
							ddsEdBound.setTm(ddsDrRiver.getTm());
							ddsEdBound.setQtype(1);
							ddsEdBound.setQ(ddsDrRiver.getQ());
							ddsEdBound.setZ(ddsDrRiver.getZ());
							DdsEdBound vo = ddsEdBoundService.get(ddsEdBound);
							if(null==vo){//预初始化的值如果不存在的话，就保存到
								ddsEdBoundService.save(ddsEdBound);
							}
						}
					}
					
				}else if("INQ".equals(fieldNm)){//查水库表
					DdsDrRsvr ddsDrRsvr = new DdsDrRsvr();
					ddsDrRsvr.setStcd(mboundry.getStcd());
					ddsDrRsvr.setStartTm(DateUtils.formatDateTime(bgDt));
					ddsDrRsvr.setEndTm(DateUtils.formatDateTime(edDt));
					List<DdsDrRsvr> listrsvr = ddsDrRsvrService.listByStcd(ddsDrRsvr);
					//插值处理
					List<Date> listDate = EdModelUtils.getDateBetweenTwoDate(bgDt, edDt);
					if(listrsvr.size()<=0){
						//循环每个水库测站对应的出库流量  -- 水库无监测数据时  插入默认值
						for(int k = 0; k < listDate.size();k++){
							Date tm = listDate.get(k);
							ddsEdBound = new DdsEdBound();
							ddsEdBound.setProCd(ddsEdPVO.getProCd());
							ddsEdBound.setStcd(mboundry.getStcd());
							ddsEdBound.setTm(tm);
							ddsEdBound.setQtype(2);
							ddsEdBound.setInq(mboundry.getDefaultValue());
							DdsEdBound vo = ddsEdBoundService.get(ddsEdBound);
							if(null==vo){//预初始化的值如果不存在的话，就保存到
								ddsEdBoundService.save(ddsEdBound);
							}
						}
					}else{
						listrsvr = EdModelUtils.getFullDrRsvr(listDate, listrsvr);
						listrsvr = EdModelUtils.getListRsvrByIn(listrsvr);
						//循环每个水库测站对应的出库流量  -- 水库有监测数据时
						for(int k = 0; k < listrsvr.size();k++){
							ddsDrRsvr = listrsvr.get(k);
							ddsEdBound = new DdsEdBound();
							ddsEdBound.setProCd(ddsEdPVO.getProCd());
							ddsEdBound.setStcd(mboundry.getStcd());
							ddsEdBound.setTm(ddsDrRsvr.getTm());
							ddsEdBound.setQtype(1);
							ddsEdBound.setInq(ddsDrRsvr.getInq());
							DdsEdBound vo = ddsEdBoundService.get(ddsEdBound);
							if(null==vo){//预初始化的值如果不存在的话，就保存到
								ddsEdBoundService.save(ddsEdBound);
							}
						}
					}
				}
			}
		}
		serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
		serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
		map.put("serviceResp", serviceResp);
		return renderString(response,map);
	}
	
	/**
	 * 水库调节初始化
	 * @param ddsEdPVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "initrsvr")
	public String initrsvr(DdsEdRsvVO ddsEdRsvVO, HttpServletResponse response){
		Map<String,Object> map = Maps.newHashMap();
		ServiceResp serviceResp = new ServiceResp();
		//判断模拟期数据是否满足
		//根据方案id，得到方案的河流代码
		DdsEdP ddsEdP = ddsEdPService.get(ddsEdRsvVO.getProCd());
		Date bgDt = ddsEdP.getBgDt();
		Date edDt = ddsEdP.getEdDt();
		long l = (edDt.getTime()-bgDt.getTime())/(60*60*1000);
		int length=  new Long(l).intValue();//计算总时段数，单位：h
		DdsMBoundry mboundry = new DdsMBoundry();
		mboundry.setRcd(ddsEdRsvVO.getRcd());
		List<DdsMBoundry> listBoundry = ddsMBoundryService.list(mboundry);
		
		if(ddsEdP.getSta()<2){
			DdsEdBound ddsEdBound = new DdsEdBound();
			ddsEdBound.setProCd(ddsEdRsvVO.getProCd());
			ddsEdBound.setStartTime(DateUtils.formatDateTime(bgDt));
			ddsEdBound.setEndTime(DateUtils.formatDateTime(edDt));
			List<DdsEdBound> boundlist = ddsEdBoundService.list(ddsEdBound);
			int total = length*listBoundry.size();
			if(total>boundlist.size()){
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg("边界条件导入的数据条数不可小于"+total+"条记录");
				logger.warn("边界条件导入的数据条数不可小于"+total+"条记录");
				return renderString(response, serviceResp);
			}
			for(DdsEdBound entity : boundlist){
				 if( entity.getQ() == null && entity.getZ() ==null && entity.getInq()==null){
						serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
						serviceResp.setMsg("请设置边界条件的监测数据值");
						logger.warn("请设置边界条件的监测数据值");
						return renderString(response, serviceResp);
					}
			}
			ddsEdP.setSta(2);
			//更新方案状态为2
			ddsEdPService.update(ddsEdP);
		}
		
		int rcd = ddsEdRsvVO.getRcd();
		//获取河段对应的水库
		DdsMRsv ddsMRsv = new DdsMRsv();
		ddsMRsv.setRcd(rcd);
		List<DdsMRsv> listrsv = ddsMRsvService.list(ddsMRsv);
		 if(null==listrsv || listrsv.size()<=0){
			 serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			 serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG+",请设置河段模型水库参数！");
			 logger.warn("请设置河段模型水库参数");
			 return  renderString(response,serviceResp);
		 }
		 
		//下泄流量设置
		Map<String,List<DdsEdRsv>> listOTQ = Maps.newHashMap();
		DdsMRsvr ddsMRsvr = new DdsMRsvr();
		ddsMRsvr.setProCd(ddsEdRsvVO.getProCd());
		List<DdsMRsvr> listmrsvr = ddsMRsvrService.list(ddsMRsvr);
		if(null!=ddsEdP.getSta() && ddsEdP.getSta()>=3){
			//根据方案编码查询方案对应 的水库调节设置
			map.put("listrsv", listmrsvr);
			
			//根据方案编码查询方案对应的下泄流量情况
			for(int i = 0 ; i < listrsv.size();i++){
				DdsEdRsv edrsv = new DdsEdRsv();
				edrsv = BeanMapper.map(ddsEdRsvVO, edrsv.getClass());
				edrsv.setStcd(listrsv.get(i).getStcd());
				edrsv.setStartTm(DateUtils.formatDateTime(bgDt));
				edrsv.setEndTm(DateUtils.formatDateTime(edDt));
				List<DdsEdRsv> edrsvlist = ddsEdRsvService.list(edrsv);
				if(null != listmrsvr && listmrsvr.size() > 0){
					List<Date> listDate = EdModelUtils.getDateBetweenTwoDate(bgDt, edDt);
					edrsvlist = EdModelUtils.getFullEdRsv(listDate, edrsvlist);
					edrsvlist = EdModelUtils.getListEdRsvByIn(edrsvlist);
					listOTQ.put(listrsv.get(i).getRescd(),edrsvlist);
				}
			}
			map.put("listOTQ",listOTQ);
		}else{
			//水库调节设置
			List<DdsMRsvr> mrsvrlist = new ArrayList<DdsMRsvr>();
			
			if(null != listrsv && listrsv.size() > 0 ){
				
				//循环河段对应的水库
				for(int i = 0 ; i < listrsv.size();i++){
					DdsEdRsv edrsv = new DdsEdRsv();
					edrsv.setProCd(ddsEdRsvVO.getProCd());
					edrsv.setStcd(listrsv.get(i).getStcd());
					edrsv.setStartTm(DateUtils.formatDateTime(bgDt));
					edrsv.setEndTm(DateUtils.formatDateTime(edDt));
					List<DdsEdRsv> edrsvlist = ddsEdRsvService.list(edrsv);
					List<DdsEdRsv>  everyRsvr = new ArrayList<DdsEdRsv>();
					
					edrsv = BeanMapper.map(ddsEdRsvVO, edrsv.getClass());
					edrsv.setStcd(listrsv.get(i).getStcd());
					
					//如果水库调节有数据，不进行初始化设置--适用于填写导入数据后，没有点击下一步的方案
					if(null != edrsvlist && edrsvlist.size() > 0){
						everyRsvr = edrsvlist;
						DdsMRsvr  mrsvr = new DdsMRsvr();
						mrsvr.setProCd(ddsEdRsvVO.getProCd());
						mrsvr.setResCd(listrsv.get(i).getRescd());
						mrsvr.setRcd(rcd);
						mrsvr.setStcd(listrsv.get(i).getStcd());
						DdsMRsvr mvo = ddsMRsvrService.getByRcd(mrsvr);
						if(null==mvo){
							ddsMRsvrService.save(mrsvr);
							mrsvrlist.add(mrsvr);
						}else{
							mrsvrlist.add(mvo);
						}
						listOTQ.put(listrsv.get(i).getRescd(),edrsvlist);
					}else{//如果水库调节中无数据，就采用水库中的数据
						//启用监测表数据
						DdsDrRsvr ddsDrRsvr = new DdsDrRsvr();
						ddsDrRsvr.setStcd(listrsv.get(i).getStcd());
						ddsDrRsvr.setStartTm(DateUtils.formatDateTime(bgDt));
						ddsDrRsvr.setEndTm(DateUtils.formatDateTime(edDt));
						List<DdsDrRsvr> listrsvr = ddsDrRsvrService.listByStcd(ddsDrRsvr);
						//插值处理
						List<Date> listDate = EdModelUtils.getDateBetweenTwoDate(bgDt, edDt);
						if(listrsvr.size()<=0){
							//  --无水库监测数据  做预初始化  插入默认值
							for(int k = 0; k < listDate.size();k++){
								Date tm = listDate.get(k);
								DdsEdRsv rsv = new DdsEdRsv();
								rsv.setProCd(ddsEdRsvVO.getProCd());
								rsv.setStcd(listrsv.get(i).getStcd());
								rsv.setTm(tm);
								rsv.setOtq(listrsv.get(i).getDefaultValue());//默认出库流量
								rsv.setOtqtype(3);
								DdsEdRsv vo = ddsEdRsvService.get(rsv);
								if(null!=vo){
									ddsEdRsvService.update(rsv);//update 出库流量到 水库调节中
								}else{
									ddsEdRsvService.save(rsv);	//add 出库流量到 水库调节中
								}
								everyRsvr.add(rsv);
								if(k==0){
									DdsMRsvr  mrsvr = new DdsMRsvr();
									mrsvr.setProCd(ddsEdRsvVO.getProCd());
									mrsvr.setResCd(listrsv.get(i).getRescd());
									mrsvr.setStarttime(bgDt);
									mrsvr.setEndtime(edDt);
									mrsvr.setRcd(rcd);
									DdsMRsvr mvo = ddsMRsvrService.getByRcd(mrsvr);
									mrsvr.setResNm(listrsv.get(i).getResnm());
									if(null!=mvo){
										ddsMRsvrService.update(mrsvr);
									}else{
										ddsMRsvrService.save(mrsvr);
									}
									mrsvrlist.add(mrsvr);
								}
							}
						}else{
							listrsvr = EdModelUtils.getFullDrRsvr(listDate, listrsvr);
							listrsvr = EdModelUtils.getListRsvrByIn(listrsvr);
							//循环每个水库测站对应的出库流量--有水库监测数据 做预初始化
							for(int k = 0; k < listrsvr.size();k++){
								DdsDrRsvr rsvr = listrsvr.get(k);
								DdsEdRsv rsv = new DdsEdRsv();
								rsv.setProCd(ddsEdRsvVO.getProCd());
								rsv.setStcd(rsvr.getStcd());
								rsv.setTm(rsvr.getTm());
								rsv.setOtq(rsvr.getOtq());//出库流量
								rsv.setOtqtype(1);
								DdsEdRsv vo = ddsEdRsvService.get(rsv);
								if(null!=vo){
									ddsEdRsvService.update(rsv);//update 出库流量到 水库调节中
								}else{
									ddsEdRsvService.save(rsv);	//add 出库流量到 水库调节中
								}
								everyRsvr.add(rsv);
								if(k==0){
									DdsMRsvr  mrsvr = new DdsMRsvr();
									mrsvr.setProCd(ddsEdRsvVO.getProCd());
									mrsvr.setResCd(listrsv.get(i).getRescd());
									mrsvr.setZ(rsvr.getRz());
									mrsvr.setQ(rsvr.getOtq());
									mrsvr.setStarttime(bgDt);
									mrsvr.setEndtime(edDt);
									mrsvr.setRcd(rcd);
									DdsMRsvr mvo = ddsMRsvrService.getByRcd(mrsvr);
									mrsvr.setResNm(listrsv.get(i).getResnm());
									if(null!=mvo){
										ddsMRsvrService.update(mrsvr);
									}else{
										ddsMRsvrService.save(mrsvr);
									}
									mrsvrlist.add(mrsvr);
								}
							}
						}
						listOTQ.put(listrsv.get(i).getRescd(),everyRsvr);
					}
				}
			}
			map.put("listOTQ", listOTQ);
			map.put("listrsv", mrsvrlist);
		}
		
		//根据河段代码获取所有控制断面
		DdsMConsec mconsec = new DdsMConsec();
		mconsec.setProcd(ddsEdRsvVO.getProCd());
		mconsec.setRcd(rcd);
		mconsec.setFlag("0");
		List<DdsMConsec> listconsec = ddsMConsecService.list(mconsec);
		//水质浓度初始化
		Double concSt = 0.1d;
		DdsEdSource source = ddsEdSourceService.get(ddsEdP.getEvenCd());
		if(source.getDaType()==3){//3==COD
			concSt=20d;
	    }else if(source.getDaType()==4){//4==NH3N
	    	concSt=1d;
	    }else if(source.getDaType()==5){//5==CODMN
	    	concSt=6d;
	    }else if(source.getDaType()==6){//6==TP
	    	concSt=0.2d;
	    }
		for(int i =  0 ; i < listconsec.size(); i++ ){
			DdsMConsec consec = listconsec.get(i);
			DdsEdInit init = new DdsEdInit();
			init.setProCd(ddsEdRsvVO.getProCd());
			init.setSecid(consec.getSecid());
			DdsEdInit vo = ddsEdInitService.get(init);
			//不存在时，附默认值并保存
			if(null==vo){
				init.setConcSt(concSt);
				ddsEdInitService.save(init);
			}
		}
		listconsec = ddsMConsecService.listParams(mconsec);
		map.put("listconsec", listconsec);
		//默认保存断面目标设置		
		return renderString(response,map);
	}
	
	/**
	 * 调度地图展示结果
	 * @param ddsEdPVO
	 * 
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "initgis")
	public String initGis(DdsEdPVO ddsEdPVO, HttpServletResponse response){
		Map<String,Object> map = Maps.newHashMap();
		ServiceResp serviceResp = new ServiceResp();
		DdsEdP ddsEdP = ddsEdPService.get(ddsEdPVO.getProCd());
		//判断状态是否为第五步
		 if((5==ddsEdP.getSta()&&"2".equals(ddsEdPVO.getStype()))||(4==ddsEdP.getSta()&&"1".equals(ddsEdPVO.getStype()))){
			DdsEdGis gis = new DdsEdGis();
			gis.setProCd(ddsEdPVO.getProCd());
			gis.setRcd(ddsEdPVO.getRcd());
			List<DdsEdGis> gislist= ddsEdGisService.findTime(gis);
			
			List<EDGisData> dataList = Lists.newArrayList();
			for(DdsEdGis edGis : gislist){
				EDGisData data = new EDGisData();
				data.setTime(edGis.getTime());
				gis.setTime(edGis.getTime());
				data.setData(ddsEdGisService.list(gis));
				dataList.add(data);
			}
			
			DdsEdGisLegend gisLegend = new DdsEdGisLegend();
			gisLegend.setProCd(ddsEdPVO.getProCd());
			DdsEdGisLegend entity = ddsEdGisLegendService.get(gisLegend);
			
			DdsEdRes ddsEdRes = new DdsEdRes();
			ddsEdRes.setProCd(ddsEdPVO.getProCd());
			ddsEdRes.setRcd(ddsEdP.getRcd());
			ddsEdRes.setRiver(ddsEdP.getRiver());
			//获取所有断面结果集
			List<DdsEdRes> stationTree = ddsEdResService.listTree(ddsEdRes);
			List<DdsEdRes> listres = Lists.newArrayList();
			for(DdsEdRes res:stationTree){
				if("测站".equals(res.getStype())){//处理只显示测试的断面
					ddsEdRes.setSecId(res.getSecId());
					//根据测站代码对时间进行分组
					List<EDResData> resDataList = Lists.newArrayList();
					ddsEdRes.setStartTime(DateUtils.formatDateTime(ddsEdP.getBgDt()));
					ddsEdRes.setEndTime(DateUtils.formatDateTime(ddsEdP.getEdDt()));
					List<DdsEdRes> groupTime = ddsEdResService.findTimeBySecId(ddsEdRes);
					for(DdsEdRes gtime:groupTime){
						ddsEdRes.setTm(gtime.getTm());
						//得到测站对应的原始值和序列值集合
						List<DdsEdRes> list = ddsEdResService.list(ddsEdRes);
						EDResData data = new  EDResData();
						data.setTime(DateUtils.formatDateTime(gtime.getTm()));
						data.setData(list);
						resDataList.add(data);
					}
					// ddsEdResService.list(ddsEdRes);
					//res.setList(list);
					res.setList(resDataList);
					listres.add(res);
				}
			}
			map.put("listres", listres);
			map.put("gislist", dataList);
			map.put("gislegend",entity);
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg("操作成功");
		}else{
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			logger.warn("该方案当前状态没有进行进行到当前步骤！");
			serviceResp.setMsg("该方案当前状态没有进行进行到当前步骤！");
		}
		map.put("serviceResp", serviceResp);
		return renderString(response, map);
	}
	
}