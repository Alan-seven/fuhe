package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdPrar;
import com.jsite.busi.szy.emergency.service.DdsEdPrarService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdPrarVO;

/**
 * 应急调度水库参数表Controller
 * @author hjx
 * @version 2017-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdPrar")
public class DdsEdPrarController extends BaseController {

	@Autowired
	private DdsEdPrarService ddsEdPrarService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String proeCd, HttpServletResponse response) {
		DdsEdPrarVO ddsEdPrarVO = new DdsEdPrarVO();
		if (StringUtils.isNotBlank(proeCd)){
			DdsEdPrar ddsEdPrar = ddsEdPrarService.get(proeCd);
			if (null != ddsEdPrar) {
				ddsEdPrarVO = BeanMapper.map(ddsEdPrar, ddsEdPrarVO.getClass());
			}
		}
		return renderString(response, ddsEdPrarVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdPrarVO ddsEdPrarVO, HttpServletResponse response) {
		DdsEdPrar ddsEdPrar = new DdsEdPrar();
		if (null != ddsEdPrarVO) {
			ddsEdPrar = BeanMapper.map(ddsEdPrarVO, ddsEdPrar.getClass());
		}
		//Page<DdsEdPrar> page = ddsEdPrarService.getPage(new Page<DdsEdPrar>(ddsEdPrarVO.getPage(),ddsEdPrarVO.getLimit()), ddsEdPrar); 
		Page<DdsEdPrar> page = ddsEdPrarService.getPage(new Page<DdsEdPrar>(ddsEdPrarVO.getPageNo(),ddsEdPrarVO.getPageSize()), ddsEdPrar); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdPrarVO ddsEdPrarVO, HttpServletResponse response) {
		DdsEdPrar ddsEdPrar = new DdsEdPrar();
		if (null != ddsEdPrarVO) {
			ddsEdPrar = BeanMapper.map(ddsEdPrarVO, ddsEdPrar.getClass());
		}
		ServiceResp serviceResp = ddsEdPrarService.save(ddsEdPrar);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdPrarVO ddsEdPrarVO, HttpServletResponse response) {
		DdsEdPrar ddsEdPrar = new DdsEdPrar();
		if (null != ddsEdPrarVO) {
			ddsEdPrar = BeanMapper.map(ddsEdPrarVO, ddsEdPrar.getClass());
		}
		ServiceResp serviceResp = ddsEdPrarService.update(ddsEdPrar);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdPrarVO ddsEdPrarVO, HttpServletResponse response) {
		DdsEdPrar ddsEdPrar = new DdsEdPrar();
		if (null != ddsEdPrarVO) {
			ddsEdPrar = BeanMapper.map(ddsEdPrarVO, ddsEdPrar.getClass());
		}
		ServiceResp serviceResp = ddsEdPrarService.remove(ddsEdPrar);
		return renderString(response,serviceResp);
	}

}