package com.jsite.szy.dispatch.emergency.web;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.jsite.busi.szy.emergency.po.DdsEdMedel;
import com.jsite.busi.szy.emergency.service.DdsEdMedelService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdMedelVO;

/**
 * 应急调度模型参数表Controller
 * @author hjx
 * @version 2017-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdMedel")
public class DdsEdMedelController extends BaseController {

	@Autowired
	private DdsEdMedelService ddsEdMedelService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(DdsEdMedelVO ddsEdMedelVO , HttpServletResponse response) {
		DdsEdMedel ddsEdMedel = new DdsEdMedel();
		if (null != ddsEdMedelVO){
			ddsEdMedel = BeanMapper.map(ddsEdMedelVO, ddsEdMedel.getClass());
			ddsEdMedel = ddsEdMedelService.get(ddsEdMedel);
		}
		return renderString(response, ddsEdMedel);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdMedelVO ddsEdMedelVO, HttpServletResponse response) {
		DdsEdMedel ddsEdMedel = new DdsEdMedel();
		if (null != ddsEdMedelVO) {
			ddsEdMedel = BeanMapper.map(ddsEdMedelVO, ddsEdMedel.getClass());
		}
		Page<DdsEdMedel> page = ddsEdMedelService.getPage(new Page<DdsEdMedel>(), ddsEdMedel); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdMedelVO ddsEdMedelVO, HttpServletResponse response) {
		DdsEdMedel ddsEdMedel = new DdsEdMedel();
		if (null != ddsEdMedelVO) {
			ddsEdMedel = BeanMapper.map(ddsEdMedelVO, ddsEdMedel.getClass());
		}
		ServiceResp serviceResp = new ServiceResp();
		DdsEdMedel entity = ddsEdMedelService.get(ddsEdMedel);
		if(null!=entity){
			serviceResp = ddsEdMedelService.update(ddsEdMedel);
		}else{
			serviceResp = ddsEdMedelService.save(ddsEdMedel);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdMedelVO ddsEdMedelVO, HttpServletResponse response) {
		DdsEdMedel ddsEdMedel = new DdsEdMedel();
		if (null != ddsEdMedelVO) {
			ddsEdMedel = BeanMapper.map(ddsEdMedelVO, ddsEdMedel.getClass());
		}
		ServiceResp serviceResp = ddsEdMedelService.update(ddsEdMedel);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdMedelVO ddsEdMedelVO, HttpServletResponse response) {
		DdsEdMedel ddsEdMedel = new DdsEdMedel();
		if (null != ddsEdMedelVO) {
			ddsEdMedel = BeanMapper.map(ddsEdMedelVO, ddsEdMedel.getClass());
		}
		ServiceResp serviceResp = ddsEdMedelService.remove(ddsEdMedel);
		return renderString(response,serviceResp);
	}

}