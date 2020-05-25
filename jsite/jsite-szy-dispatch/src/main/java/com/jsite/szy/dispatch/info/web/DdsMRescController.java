package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsMResc;
import com.jsite.busi.szy.info.service.DdsMRescService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsMRescVO;

/**
 * 水库约束表Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsMResc")
public class DdsMRescController extends BaseController {

	@Autowired
	private DdsMRescService ddsMRescService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsMRescVO ddsMRescVO = new DdsMRescVO();
		if (StringUtils.isNotBlank(id)){
			DdsMResc ddsMResc = ddsMRescService.get(id);
			if (null != ddsMResc) {
				BeanMapper.map(ddsMResc, ddsMRescVO.getClass());
			}
		}
		return renderString(response, ddsMRescVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsMRescVO ddsMRescVO, HttpServletResponse response) {
		DdsMResc ddsMResc = new DdsMResc();
		if (null != ddsMRescVO) {
			BeanMapper.map(ddsMRescVO, ddsMResc.getClass());
		}
		Page<DdsMResc> page = ddsMRescService.getPage(new Page<DdsMResc>(), ddsMResc); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsMRescVO ddsMRescVO, HttpServletResponse response) {
		DdsMResc ddsMResc = new DdsMResc();
		if (null != ddsMRescVO) {
			BeanMapper.map(ddsMRescVO, ddsMResc.getClass());
		}
		ServiceResp serviceResp = ddsMRescService.save(ddsMResc);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsMRescVO ddsMRescVO, HttpServletResponse response) {
		DdsMResc ddsMResc = new DdsMResc();
		if (null != ddsMRescVO) {
			BeanMapper.map(ddsMRescVO, ddsMResc.getClass());
		}
		ServiceResp serviceResp = ddsMRescService.update(ddsMResc);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsMRescVO ddsMRescVO, HttpServletResponse response) {
		DdsMResc ddsMResc = new DdsMResc();
		if (null != ddsMRescVO) {
			BeanMapper.map(ddsMRescVO, ddsMResc.getClass());
		}
		ServiceResp serviceResp = ddsMRescService.remove(ddsMResc);
		return renderString(response,serviceResp);
	}

}