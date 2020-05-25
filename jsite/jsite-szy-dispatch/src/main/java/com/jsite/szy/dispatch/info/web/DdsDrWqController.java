package com.jsite.szy.dispatch.info.web;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsDrWq;
import com.jsite.busi.szy.info.service.DdsDrWqService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsDrWqVO;

/**
 * 水质信息Controller
 * @author 徐旺旺
 * @version 2017-03-21
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsDrWq")
public class DdsDrWqController extends BaseController {

	@Autowired
	private DdsDrWqService ddsDrWqService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(DdsDrWqVO ddsDrWqVO, HttpServletResponse response) {
		DdsDrWq ddsDrWq = new DdsDrWq();
		if (null != ddsDrWqVO){
			ddsDrWq = BeanMapper.map(ddsDrWqVO, ddsDrWq.getClass());
			ddsDrWq = ddsDrWqService.get(ddsDrWq);
		}
		return renderString(response, ddsDrWq);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsDrWqVO ddsDrWqVO, HttpServletResponse response) {
		DdsDrWq ddsDrWq = new DdsDrWq();
		if (null != ddsDrWqVO) {
			ddsDrWq = BeanMapper.map(ddsDrWqVO, ddsDrWq.getClass());
		}
		Page<DdsDrWq> page = ddsDrWqService.getPage(new Page<DdsDrWq>(ddsDrWqVO.getPageNo(),ddsDrWqVO.getPageSize()), ddsDrWq); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsDrWqVO ddsDrWqVO, HttpServletResponse response) {
		DdsDrWq ddsDrWq = new DdsDrWq();
		if (null != ddsDrWqVO) {
			ddsDrWq = BeanMapper.map(ddsDrWqVO, ddsDrWq.getClass());
		}
		ServiceResp serviceResp = ddsDrWqService.save(ddsDrWq);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsDrWqVO ddsDrWqVO, HttpServletResponse response) {
		DdsDrWq ddsDrWq = new DdsDrWq();
		if (null != ddsDrWqVO) {
			ddsDrWq = BeanMapper.map(ddsDrWqVO, ddsDrWq.getClass());
		}
		ServiceResp serviceResp = ddsDrWqService.update(ddsDrWq);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsDrWqVO ddsDrWqVO, HttpServletResponse response) {
		DdsDrWq ddsDrWq = new DdsDrWq();
		if (null != ddsDrWqVO) {
			ddsDrWq = BeanMapper.map(ddsDrWqVO, ddsDrWq.getClass());
		}
		ServiceResp serviceResp = ddsDrWqService.remove(ddsDrWq);
		return renderString(response,serviceResp);
	}

	/**
	 * 水质监测  频次为旬
	 * @param ddsDrWqVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"listbystcd", ""})
	public String listByStcd(DdsDrWqVO ddsDrWqVO, HttpServletResponse response) {
		DdsDrWq ddsDrWq = new DdsDrWq();
		if (null != ddsDrWqVO) {
			ddsDrWq = BeanMapper.map(ddsDrWqVO, ddsDrWq.getClass());
		}
		//查询当前时间的24条数据
		if(StringUtils.isBlank(ddsDrWq.getStartTm()) && StringUtils.isBlank(ddsDrWq.getEndTm()) ){
			Calendar cal = Calendar.getInstance();
			String endTm = DateUtils.formatDateTime(cal.getTime());
			cal.add(Calendar.YEAR, -1);
			String startTm = DateUtils.formatDateTime(cal.getTime());
			ddsDrWq.setStartTm(startTm);
			ddsDrWq.setEndTm(endTm);
		}
		List<DdsDrWq> list = ddsDrWqService.listByStcd(ddsDrWq); 
		return  renderString(response, list);
	}
}