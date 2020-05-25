package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsBWrz;
import com.jsite.busi.szy.info.service.DdsBWrzService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsBWrzVO;

/**
 * 水资源分区基本信息Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsBWrz")
public class DdsBWrzController extends BaseController {

	@Autowired
	private DdsBWrzService ddsBWrzService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsBWrzVO ddsBWrzVO = new DdsBWrzVO();
		if (StringUtils.isNotBlank(id)){
			DdsBWrz ddsBWrz = ddsBWrzService.get(id);
			if (null != ddsBWrz) {
				BeanMapper.map(ddsBWrz, ddsBWrzVO.getClass());
			}
		}
		return renderString(response, ddsBWrzVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsBWrzVO ddsBWrzVO, HttpServletResponse response) {
		DdsBWrz ddsBWrz = new DdsBWrz();
		if (null != ddsBWrzVO) {
			ddsBWrz = BeanMapper.map(ddsBWrzVO, ddsBWrz.getClass());
		}
		Page<DdsBWrz> page = ddsBWrzService.getPage(new Page<DdsBWrz>(), ddsBWrz); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsBWrzVO ddsBWrzVO, HttpServletResponse response) {
		DdsBWrz ddsBWrz = new DdsBWrz();
		if (null != ddsBWrzVO) {
			BeanMapper.map(ddsBWrzVO, ddsBWrz.getClass());
		}
		ServiceResp serviceResp = ddsBWrzService.save(ddsBWrz);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsBWrzVO ddsBWrzVO, HttpServletResponse response) {
		DdsBWrz ddsBWrz = new DdsBWrz();
		if (null != ddsBWrzVO) {
			BeanMapper.map(ddsBWrzVO, ddsBWrz.getClass());
		}
		ServiceResp serviceResp = ddsBWrzService.update(ddsBWrz);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsBWrzVO ddsBWrzVO, HttpServletResponse response) {
		DdsBWrz ddsBWrz = new DdsBWrz();
		if (null != ddsBWrzVO) {
			BeanMapper.map(ddsBWrzVO, ddsBWrz.getClass());
		}
		ServiceResp serviceResp = ddsBWrzService.remove(ddsBWrz);
		return renderString(response,serviceResp);
	}

}