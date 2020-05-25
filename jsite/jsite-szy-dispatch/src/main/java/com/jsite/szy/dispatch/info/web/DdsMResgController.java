package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsMResg;
import com.jsite.busi.szy.info.service.DdsMResgService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsMResgVO;

/**
 * 水库调度图Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsMResg")
public class DdsMResgController extends BaseController {

	@Autowired
	private DdsMResgService ddsMResgService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsMResgVO ddsMResgVO = new DdsMResgVO();
		if (StringUtils.isNotBlank(id)){
			DdsMResg ddsMResg = ddsMResgService.get(id);
			if (null != ddsMResg) {
				BeanMapper.map(ddsMResg, ddsMResgVO.getClass());
			}
		}
		return renderString(response, ddsMResgVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsMResgVO ddsMResgVO, HttpServletResponse response) {
		DdsMResg ddsMResg = new DdsMResg();
		if (null != ddsMResgVO) {
			BeanMapper.map(ddsMResgVO, ddsMResg.getClass());
		}
		Page<DdsMResg> page = ddsMResgService.getPage(new Page<DdsMResg>(), ddsMResg); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsMResgVO ddsMResgVO, HttpServletResponse response) {
		DdsMResg ddsMResg = new DdsMResg();
		if (null != ddsMResgVO) {
			BeanMapper.map(ddsMResgVO, ddsMResg.getClass());
		}
		ServiceResp serviceResp = ddsMResgService.save(ddsMResg);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsMResgVO ddsMResgVO, HttpServletResponse response) {
		DdsMResg ddsMResg = new DdsMResg();
		if (null != ddsMResgVO) {
			BeanMapper.map(ddsMResgVO, ddsMResg.getClass());
		}
		ServiceResp serviceResp = ddsMResgService.update(ddsMResg);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsMResgVO ddsMResgVO, HttpServletResponse response) {
		DdsMResg ddsMResg = new DdsMResg();
		if (null != ddsMResgVO) {
			BeanMapper.map(ddsMResgVO, ddsMResg.getClass());
		}
		ServiceResp serviceResp = ddsMResgService.remove(ddsMResg);
		return renderString(response,serviceResp);
	}

}