package com.jsite.szy.dispatch.info.web;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.jsite.busi.szy.info.po.DdsDrPptn;
import com.jsite.busi.szy.info.service.DdsDrPptnService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.common.SyncSyqForInter;
import com.jsite.szy.dispatch.info.vo.DdsDrPptnVO;

/**
 * 降水量Controller
 * @author 徐旺旺
 * @version 2017-03-21
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsDrPptn")
public class DdsDrPptnController extends BaseController {

	@Autowired
	private DdsDrPptnService ddsDrPptnService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsDrPptnVO ddsDrPptnVO = new DdsDrPptnVO();
		if (StringUtils.isNotBlank(id)){
			DdsDrPptn ddsDrPptn = ddsDrPptnService.get(id);
			if (null != ddsDrPptn) {
				ddsDrPptnVO = BeanMapper.map(ddsDrPptn, ddsDrPptnVO.getClass());
			}
		}
		return renderString(response, ddsDrPptnVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsDrPptnVO ddsDrPptnVO, HttpServletResponse response) {
		DdsDrPptn ddsDrPptn = new DdsDrPptn();
		if (null != ddsDrPptnVO) {
			ddsDrPptn = BeanMapper.map(ddsDrPptnVO, ddsDrPptn.getClass());
		}
		Page<DdsDrPptn> page = ddsDrPptnService.getPage(new Page<DdsDrPptn>(ddsDrPptnVO.getPageNo(),ddsDrPptnVO.getPageSize()), ddsDrPptn); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsDrPptnVO ddsDrPptnVO, HttpServletResponse response) {
		DdsDrPptn ddsDrPptn = new DdsDrPptn();
		if (null != ddsDrPptnVO) {
			ddsDrPptn = BeanMapper.map(ddsDrPptnVO, ddsDrPptn.getClass());
		}
		ServiceResp serviceResp = ddsDrPptnService.save(ddsDrPptn);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsDrPptnVO ddsDrPptnVO, HttpServletResponse response) {
		DdsDrPptn ddsDrPptn = new DdsDrPptn();
		if (null != ddsDrPptnVO) {
			ddsDrPptn = BeanMapper.map(ddsDrPptnVO, ddsDrPptn.getClass());
		}
		ServiceResp serviceResp = ddsDrPptnService.update(ddsDrPptn);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsDrPptnVO ddsDrPptnVO, HttpServletResponse response) {
		DdsDrPptn ddsDrPptn = new DdsDrPptn();
		if (null != ddsDrPptnVO) {
			ddsDrPptn = BeanMapper.map(ddsDrPptnVO, ddsDrPptn.getClass());
		}
		ServiceResp serviceResp = ddsDrPptnService.remove(ddsDrPptn);
		return renderString(response,serviceResp);
	}

	/**
	 * 日 降雨量
	 * @param ddsDrPptnVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"listbystcd", ""})
	public String listByStcd(DdsDrPptnVO ddsDrPptnVO, HttpServletResponse response) {
		DdsDrPptn ddsDrPptn = new DdsDrPptn();
		if (null != ddsDrPptnVO) {
			ddsDrPptn = BeanMapper.map(ddsDrPptnVO, ddsDrPptn.getClass());
		}
		if(StringUtils.isNotBlank(ddsDrPptnVO.getEndTm())){
			Calendar cal = Calendar.getInstance();
			cal.setTime(DateUtils.parseDate(ddsDrPptnVO.getEndTm()));
			cal.add(Calendar.DAY_OF_MONTH, 1);
			ddsDrPptn.setEndTm(DateUtils.formatDateTime(cal.getTime()));
		}
		List<DdsDrPptn> list = ddsDrPptnService.listByStcd(ddsDrPptn); 
		return  renderString(response, list);
	}
	
	/**
	 * 实时 降雨量
	 * @param ddsDrPptnVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"listHourByStcd", ""})
	public String listHourByStcd(DdsDrPptnVO ddsDrPptnVO, HttpServletResponse response) {
		DdsDrPptn ddsDrPptn = new DdsDrPptn();
		if (null != ddsDrPptnVO) {
			ddsDrPptn = BeanMapper.map(ddsDrPptnVO, ddsDrPptn.getClass());
		}
		List<DdsDrPptn> list = Lists.newArrayList();
		//查询当前时间的24条数据
		if(StringUtils.isBlank(ddsDrPptn.getStartTm()) && StringUtils.isBlank(ddsDrPptn.getEndTm()) ){
			/*Calendar cal = Calendar.getInstance();
			String startTm = DateUtils.formatDateTime(cal.getTime());
			cal.add(Calendar.DAY_OF_MONTH, -1);
			String endTm = DateUtils.formatDateTime(cal.getTime());
			ddsDrPptn.setStartTm(startTm);
			ddsDrPptn.setEndTm(endTm);*/
			DdsDrPptn entity = ddsDrPptnService.findMaxTime(ddsDrPptn);
			if(null != entity && null != entity.getTm()){
				Calendar cal = Calendar.getInstance();
				cal.setTime(entity.getTm());
				cal.add(Calendar.DAY_OF_MONTH, -1);
				ddsDrPptn.setStartTm(DateUtils.formatDateTime(cal.getTime()));
				ddsDrPptn.setEndTm(DateUtils.formatDateTime(entity.getTm()));
				list = ddsDrPptnService.listHourByStcd(ddsDrPptn); 
			}
		}else if(StringUtils.isNotBlank(ddsDrPptn.getStartTm()) && StringUtils.isNotBlank(ddsDrPptn.getEndTm()) ){
			list = ddsDrPptnService.listHourByStcd(ddsDrPptn); 
		}
		return  renderString(response, list);
	}
	
	@ResponseBody
	@RequestMapping(value = {"sync", ""})
	public String sync(DdsDrPptnVO ddsDrPptnVO, HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		String startTm = ddsDrPptnVO.getStartTm();
		String endTm = ddsDrPptnVO.getEndTm();
		if(StringUtils.isNotBlank(startTm)&&StringUtils.isNotBlank(endTm)){
			java.util.Date start = DateUtils.parseDate(startTm);
			java.util.Date end = DateUtils.parseDate(endTm);
			SyncSyqForInter ss = new SyncSyqForInter(new java.sql.Date(start.getTime()),new java.sql.Date(end.getTime()));
			ss.syncPptn();
			ss.syncRiver();
			ss.syncRsvr();
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg("数据同步成功");
		}else{
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("数据同步开始时间结束时间不可为空");
		}
		return  renderString(response, serviceResp);
	}
}