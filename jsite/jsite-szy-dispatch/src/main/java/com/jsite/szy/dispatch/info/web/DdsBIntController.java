package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsBInt;
import com.jsite.busi.szy.info.service.DdsBIntService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsBIntVO;

/**
 * 地表取水口基本信息Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsBInt")
public class DdsBIntController extends BaseController {

	@Autowired
	private DdsBIntService ddsBIntService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsBIntVO ddsBIntVO = new DdsBIntVO();
		if (StringUtils.isNotBlank(id)){
			DdsBInt ddsBInt = ddsBIntService.get(id);
			if (null != ddsBInt) {
				ddsBIntVO = BeanMapper.map(ddsBInt, ddsBIntVO.getClass());
			}
		}
		return renderString(response, ddsBIntVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsBIntVO ddsBIntVO, HttpServletResponse response) {
		DdsBInt ddsBInt = new DdsBInt();
		if (null != ddsBIntVO) {
			ddsBInt = BeanMapper.map(ddsBIntVO, ddsBInt.getClass());
		}
		Page<DdsBInt> page = ddsBIntService.getPage(new Page<DdsBInt>(ddsBIntVO.getPageNo(),ddsBIntVO.getPageSize()), ddsBInt); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsBIntVO ddsBIntVO, HttpServletResponse response) {
		DdsBInt ddsBInt = new DdsBInt();
		if (null != ddsBIntVO) {
			BeanMapper.map(ddsBIntVO, ddsBInt.getClass());
		}
		ServiceResp serviceResp = ddsBIntService.save(ddsBInt);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsBIntVO ddsBIntVO, HttpServletResponse response) {
		DdsBInt ddsBInt = new DdsBInt();
		if (null != ddsBIntVO) {
			BeanMapper.map(ddsBIntVO, ddsBInt.getClass());
		}
		ServiceResp serviceResp = ddsBIntService.update(ddsBInt);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsBIntVO ddsBIntVO, HttpServletResponse response) {
		DdsBInt ddsBInt = new DdsBInt();
		if (null != ddsBIntVO) {
			BeanMapper.map(ddsBIntVO, ddsBInt.getClass());
		}
		ServiceResp serviceResp = ddsBIntService.remove(ddsBInt);
		return renderString(response,serviceResp);
	}

}