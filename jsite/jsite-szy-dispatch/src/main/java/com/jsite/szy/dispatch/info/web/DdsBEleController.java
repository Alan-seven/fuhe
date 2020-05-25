package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsBEle;
import com.jsite.busi.szy.info.service.DdsBEleService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsBEleVO;

/**
 * 水利要素备基本信息Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsBEle")
public class DdsBEleController extends BaseController {

	@Autowired
	private DdsBEleService ddsBEleService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsBEleVO ddsBEleVO = new DdsBEleVO();
		if (StringUtils.isNotBlank(id)){
			DdsBEle ddsBEle = ddsBEleService.get(id);
			if (null != ddsBEle) {
				BeanMapper.map(ddsBEle, ddsBEleVO.getClass());
			}
		}
		return renderString(response, ddsBEleVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsBEleVO ddsBEleVO, HttpServletResponse response) {
		DdsBEle ddsBEle = new DdsBEle();
		if (null != ddsBEleVO) {
			BeanMapper.map(ddsBEleVO, ddsBEle.getClass());
		}
		Page<DdsBEle> page = ddsBEleService.getPage(new Page<DdsBEle>(), ddsBEle); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsBEleVO ddsBEleVO, HttpServletResponse response) {
		DdsBEle ddsBEle = new DdsBEle();
		if (null != ddsBEleVO) {
			BeanMapper.map(ddsBEleVO, ddsBEle.getClass());
		}
		ServiceResp serviceResp = ddsBEleService.save(ddsBEle);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsBEleVO ddsBEleVO, HttpServletResponse response) {
		DdsBEle ddsBEle = new DdsBEle();
		if (null != ddsBEleVO) {
			BeanMapper.map(ddsBEleVO, ddsBEle.getClass());
		}
		ServiceResp serviceResp = ddsBEleService.update(ddsBEle);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsBEleVO ddsBEleVO, HttpServletResponse response) {
		DdsBEle ddsBEle = new DdsBEle();
		if (null != ddsBEleVO) {
			BeanMapper.map(ddsBEleVO, ddsBEle.getClass());
		}
		ServiceResp serviceResp = ddsBEleService.remove(ddsBEle);
		return renderString(response,serviceResp);
	}

}