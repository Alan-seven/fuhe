package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsBAd;
import com.jsite.busi.szy.info.po.DdsBPdo;
import com.jsite.busi.szy.info.service.DdsBAdService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsBAdVO;

/**
 * 行政区划基本信息Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsBAd")
public class DdsBAdController extends BaseController {

	@Autowired
	private DdsBAdService ddsBAdService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsBAdVO ddsBAdVO = new DdsBAdVO();
		if (StringUtils.isNotBlank(id)){
			DdsBAd ddsBAd = ddsBAdService.get(id);
			if (null != ddsBAd) {
				BeanMapper.map(ddsBAd, ddsBAdVO.getClass());
			}
		}
		return renderString(response, ddsBAdVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsBAdVO ddsBAdVO, HttpServletResponse response) {
		DdsBAd ddsBAd = new DdsBAd();
		if (null != ddsBAdVO) {
			BeanMapper.map(ddsBAdVO, ddsBAd.getClass());
		}
		Page<DdsBAd> page = ddsBAdService.getPage(new Page<DdsBAd>(ddsBAdVO.getPageNo(),ddsBAdVO.getPageSize()), ddsBAd); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsBAdVO ddsBAdVO, HttpServletResponse response) {
		DdsBAd ddsBAd = new DdsBAd();
		if (null != ddsBAdVO) {
			BeanMapper.map(ddsBAdVO, ddsBAd.getClass());
		}
		ServiceResp serviceResp = ddsBAdService.save(ddsBAd);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsBAdVO ddsBAdVO, HttpServletResponse response) {
		DdsBAd ddsBAd = new DdsBAd();
		if (null != ddsBAdVO) {
			BeanMapper.map(ddsBAdVO, ddsBAd.getClass());
		}
		ServiceResp serviceResp = ddsBAdService.update(ddsBAd);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsBAdVO ddsBAdVO, HttpServletResponse response) {
		DdsBAd ddsBAd = new DdsBAd();
		if (null != ddsBAdVO) {
			BeanMapper.map(ddsBAdVO, ddsBAd.getClass());
		}
		ServiceResp serviceResp = ddsBAdService.remove(ddsBAd);
		return renderString(response,serviceResp);
	}

}