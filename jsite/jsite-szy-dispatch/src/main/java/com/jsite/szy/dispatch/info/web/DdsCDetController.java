package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsCDet;
import com.jsite.busi.szy.info.service.DdsCDetService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsCDetVO;

/**
 * 特征曲线表Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsCDet")
public class DdsCDetController extends BaseController {

	@Autowired
	private DdsCDetService ddsCDetService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsCDetVO ddsCDetVO = new DdsCDetVO();
		if (StringUtils.isNotBlank(id)){
			DdsCDet ddsCDet = ddsCDetService.get(id);
			if (null != ddsCDet) {
				BeanMapper.map(ddsCDet, ddsCDetVO.getClass());
			}
		}
		return renderString(response, ddsCDetVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsCDetVO ddsCDetVO, HttpServletResponse response) {
		DdsCDet ddsCDet = new DdsCDet();
		if (null != ddsCDetVO) {
			BeanMapper.map(ddsCDetVO, ddsCDet.getClass());
		}
		Page<DdsCDet> page = ddsCDetService.getPage(new Page<DdsCDet>(), ddsCDet); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsCDetVO ddsCDetVO, HttpServletResponse response) {
		DdsCDet ddsCDet = new DdsCDet();
		if (null != ddsCDetVO) {
			BeanMapper.map(ddsCDetVO, ddsCDet.getClass());
		}
		ServiceResp serviceResp = ddsCDetService.save(ddsCDet);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsCDetVO ddsCDetVO, HttpServletResponse response) {
		DdsCDet ddsCDet = new DdsCDet();
		if (null != ddsCDetVO) {
			BeanMapper.map(ddsCDetVO, ddsCDet.getClass());
		}
		ServiceResp serviceResp = ddsCDetService.update(ddsCDet);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsCDetVO ddsCDetVO, HttpServletResponse response) {
		DdsCDet ddsCDet = new DdsCDet();
		if (null != ddsCDetVO) {
			BeanMapper.map(ddsCDetVO, ddsCDet.getClass());
		}
		ServiceResp serviceResp = ddsCDetService.remove(ddsCDet);
		return renderString(response,serviceResp);
	}

}