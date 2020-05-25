package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsMResgd;
import com.jsite.busi.szy.info.service.DdsMResgdService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsMResgdVO;

/**
 * 水库调度图详细情况Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsMResgd")
public class DdsMResgdController extends BaseController {

	@Autowired
	private DdsMResgdService ddsMResgdService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsMResgdVO ddsMResgdVO = new DdsMResgdVO();
		if (StringUtils.isNotBlank(id)){
			DdsMResgd ddsMResgd = ddsMResgdService.get(id);
			if (null != ddsMResgd) {
				BeanMapper.map(ddsMResgd, ddsMResgdVO.getClass());
			}
		}
		return renderString(response, ddsMResgdVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsMResgdVO ddsMResgdVO, HttpServletResponse response) {
		DdsMResgd ddsMResgd = new DdsMResgd();
		if (null != ddsMResgdVO) {
			BeanMapper.map(ddsMResgdVO, ddsMResgd.getClass());
		}
		Page<DdsMResgd> page = ddsMResgdService.getPage(new Page<DdsMResgd>(), ddsMResgd); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsMResgdVO ddsMResgdVO, HttpServletResponse response) {
		DdsMResgd ddsMResgd = new DdsMResgd();
		if (null != ddsMResgdVO) {
			BeanMapper.map(ddsMResgdVO, ddsMResgd.getClass());
		}
		ServiceResp serviceResp = ddsMResgdService.save(ddsMResgd);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsMResgdVO ddsMResgdVO, HttpServletResponse response) {
		DdsMResgd ddsMResgd = new DdsMResgd();
		if (null != ddsMResgdVO) {
			BeanMapper.map(ddsMResgdVO, ddsMResgd.getClass());
		}
		ServiceResp serviceResp = ddsMResgdService.update(ddsMResgd);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsMResgdVO ddsMResgdVO, HttpServletResponse response) {
		DdsMResgd ddsMResgd = new DdsMResgd();
		if (null != ddsMResgdVO) {
			BeanMapper.map(ddsMResgdVO, ddsMResgd.getClass());
		}
		ServiceResp serviceResp = ddsMResgdService.remove(ddsMResgd);
		return renderString(response,serviceResp);
	}

}