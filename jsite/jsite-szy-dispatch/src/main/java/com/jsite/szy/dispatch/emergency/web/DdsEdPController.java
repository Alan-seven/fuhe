package com.jsite.szy.dispatch.emergency.web;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdBound;
import com.jsite.busi.szy.emergency.po.DdsEdEva;
import com.jsite.busi.szy.emergency.po.DdsEdGis;
import com.jsite.busi.szy.emergency.po.DdsEdGisLegend;
import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.emergency.po.DdsEdRes;
import com.jsite.busi.szy.emergency.po.DdsEdRsv;
import com.jsite.busi.szy.emergency.po.DdsMRsv;
import com.jsite.busi.szy.emergency.po.DdsMRsvr;
import com.jsite.busi.szy.emergency.service.DdsEdBoundService;
import com.jsite.busi.szy.emergency.service.DdsEdEvaService;
import com.jsite.busi.szy.emergency.service.DdsEdGisLegendService;
import com.jsite.busi.szy.emergency.service.DdsEdGisService;
import com.jsite.busi.szy.emergency.service.DdsEdPService;
import com.jsite.busi.szy.emergency.service.DdsEdResService;
import com.jsite.busi.szy.emergency.service.DdsEdRsvService;
import com.jsite.busi.szy.emergency.service.DdsMRsvService;
import com.jsite.busi.szy.emergency.service.DdsMRsvrService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.IdGen;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdPVO;

/**
 * 应急方案信息表Controller
 * @author hjx
 * @version 2017-06-07
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdP")
public class DdsEdPController extends BaseController {

	@Autowired
	private DdsEdPService ddsEdPService;
	
	@Autowired
	private DdsEdBoundService ddsEdBoundService;
	
	@Autowired
	private DdsEdRsvService ddsEdRsvService;
	
	@Autowired
	private DdsEdResService ddsEdResService;
	
	@Autowired
	private DdsMRsvrService ddsMRsvrService;
	
	@Autowired
	private DdsEdEvaService ddsEdEvaService;
	
	@Autowired
	private DdsEdGisService ddsEdGisService;
	
	@Autowired
	private DdsMRsvService ddsMRsvService;
	
	@Autowired
	private DdsEdGisLegendService ddsEdGisLegendService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String proCd, HttpServletResponse response) {
		DdsEdPVO ddsEdPVO = new DdsEdPVO();
		if (StringUtils.isNotBlank(proCd)){
			DdsEdP ddsEdP = ddsEdPService.get(proCd);
			if (null != ddsEdP) {
				ddsEdPVO = BeanMapper.map(ddsEdP, ddsEdPVO.getClass());
			}
		}
		return renderString(response, ddsEdPVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdPVO ddsEdPVO, HttpServletResponse response) {
		DdsEdP ddsEdP = new DdsEdP();
		if (null != ddsEdPVO) {
			ddsEdP = BeanMapper.map(ddsEdPVO, ddsEdP.getClass());
		}
		Page<DdsEdP> page = ddsEdPService.getPage(new Page<DdsEdP>(), ddsEdP); 
		for(DdsEdP vo : page.getList()){
			DdsMRsv rsv = new DdsMRsv();
			rsv.setRcd(vo.getRcd());
			List<DdsMRsv> rsvlist =  ddsMRsvService.list(rsv);
			if(null==rsvlist||rsvlist.size()<=0){
				vo.setNt("1");//水质调度
			}else if(rsvlist!=null && rsvlist.size()>0){
				vo.setNt("2");//水量调度
			}
		}
		return  renderString(response, page);
	}

	/**
	 * 水质模拟
	 * @param ddsEdPVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"listSz", ""})
	public String listSz(DdsEdPVO ddsEdPVO, HttpServletResponse response) {
		DdsEdP ddsEdP = new DdsEdP();
		if (null != ddsEdPVO) {
			ddsEdP = BeanMapper.map(ddsEdPVO, ddsEdP.getClass());
		}
		List<DdsEdP> listsz = ddsEdPService.listSz(ddsEdP); 
		return  renderString(response, listsz);
	}
	
	/**
	 * 水量调度
	 * @param ddsEdPVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"listDispatch", ""})
	public String listDispatch(DdsEdPVO ddsEdPVO, HttpServletResponse response) {
		DdsEdP ddsEdP = new DdsEdP();
		if (null != ddsEdPVO) {
			ddsEdP = BeanMapper.map(ddsEdPVO, ddsEdP.getClass());
		}
		List<DdsEdP> listdispatch = ddsEdPService.listDispatch(ddsEdP); 
		return  renderString(response, listdispatch);
	}
	
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdPVO ddsEdPVO, HttpServletResponse response) {
		ddsEdPVO.setProCd(IdGen.randomBase62(13));
		DdsEdP ddsEdP = new DdsEdP();
		if (null != ddsEdPVO) {
			ddsEdPVO.setCrDt(new Date());
			ddsEdP = BeanMapper.map(ddsEdPVO, ddsEdP.getClass());
		}
		ServiceResp serviceResp =  new ServiceResp();
		if(null!=ddsEdPVO.getBgDt() && null!=ddsEdPVO.getEdDt() && null!=ddsEdPVO.getPubDt()){
			if(ddsEdPVO.getBgDt().after(ddsEdPVO.getPubDt()) || ddsEdPVO.getPubDt().after(ddsEdPVO.getEdDt())){
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg("发生时间必须介入起始时间和结束时间之间");
				return renderString(response,serviceResp);
			}
		}
		if(ddsEdPService.findByProNm(ddsEdP)!=null){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("会商方案名称已存在");
		}else{
			serviceResp = ddsEdPService.save(ddsEdP);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdPVO ddsEdPVO, HttpServletResponse response) {
		DdsEdP ddsEdP = new DdsEdP();
		if (null != ddsEdPVO) {
			ddsEdP = BeanMapper.map(ddsEdPVO, ddsEdP.getClass());
		}
		ServiceResp serviceResp =  new ServiceResp();
		if(null!=ddsEdPVO.getBgDt() && null!=ddsEdPVO.getEdDt() && null!=ddsEdPVO.getPubDt()){
			if(ddsEdPVO.getBgDt().after(ddsEdPVO.getPubDt()) || ddsEdPVO.getPubDt().after(ddsEdPVO.getEdDt())){
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg("发生时间必须介入起始时间和结束时间之间");
				return renderString(response,serviceResp);
			}
		}
		serviceResp = ddsEdPService.update(ddsEdP);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdPVO ddsEdPVO, HttpServletResponse response) {
		DdsEdP ddsEdP = new DdsEdP();
		if (null != ddsEdPVO) {
			ddsEdP = BeanMapper.map(ddsEdPVO, ddsEdP.getClass());
		}
		ServiceResp serviceResp = new ServiceResp();
		//删除调度结果
		DdsEdRes ddsEdRes = new DdsEdRes();
		ddsEdRes.setProCd(ddsEdPVO.getProCd());
		serviceResp = ddsEdResService.removeAll(ddsEdRes);
		//删除应急调度  地图色彩分级
		DdsEdGisLegend gisLegend = new DdsEdGisLegend();
		gisLegend.setProCd(ddsEdPVO.getProCd());
		serviceResp = ddsEdGisLegendService.remove(gisLegend);
		//删除调度结果GIS
		DdsEdGis ddsEdGis = new DdsEdGis();
		ddsEdGis.setProCd(ddsEdPVO.getProCd());
		serviceResp = ddsEdGisService.removeAll(ddsEdGis);
		
		//删除调度结果评价数据
		DdsEdEva ddsEdEva = new DdsEdEva();
		ddsEdEva.setProCd(ddsEdPVO.getProCd());
		serviceResp = ddsEdEvaService.remove(ddsEdEva);
		
		//删除水库数据
		DdsEdRsv ddsEdRsv = new DdsEdRsv();
		ddsEdRsv.setProCd(ddsEdPVO.getProCd());
		serviceResp = ddsEdRsvService.removeAll(ddsEdRsv);
		
		//删除水库配置数据
		DdsMRsvr ddsMRsvr = new DdsMRsvr();
		ddsMRsvr.setProCd(ddsEdPVO.getProCd());
		serviceResp = ddsMRsvrService.removeAll(ddsMRsvr);
		
		//删除河段边界监测数据
		DdsEdBound ddsEdBound = new DdsEdBound();
		ddsEdBound.setProCd(ddsEdPVO.getProCd());
		serviceResp = ddsEdBoundService.removeAll(ddsEdBound);
		
		serviceResp = ddsEdPService.remove(ddsEdP);
		return renderString(response,serviceResp);
	}
	
	/**
	 * 点击下一步时，更新方案的状态
	 * @param ddsEdPVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateSta")
	public String updateSta(DdsEdPVO ddsEdPVO, HttpServletResponse response){
		DdsEdP ddsEdP = new DdsEdP();
		if (null != ddsEdPVO) {
			ddsEdP = BeanMapper.map(ddsEdPVO, ddsEdP.getClass());
		}
		ServiceResp serviceResp = ddsEdPService.updateSta(ddsEdP);
		return renderString(response,serviceResp);
	}
	
}