package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdPfar;
import com.jsite.busi.szy.emergency.service.DdsEdPfarService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdPfarVO;

/**
 * 应急调度预报参数表Controller
 * @author hjx
 * @version 2017-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdPfar")
public class DdsEdPfarController extends BaseController {

	@Autowired
	private DdsEdPfarService ddsEdPfarService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String proeCd, HttpServletResponse response) {
		DdsEdPfarVO ddsEdPfarVO = new DdsEdPfarVO();
		if (StringUtils.isNotBlank(proeCd)){
			DdsEdPfar ddsEdPfar = ddsEdPfarService.get(proeCd);
			if (null != ddsEdPfar) {
				ddsEdPfarVO = BeanMapper.map(ddsEdPfar, ddsEdPfarVO.getClass());
			}
		}
		return renderString(response, ddsEdPfarVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdPfarVO ddsEdPfarVO, HttpServletResponse response) {
		DdsEdPfar ddsEdPfar = new DdsEdPfar();
		if (null != ddsEdPfarVO) {
			ddsEdPfar = BeanMapper.map(ddsEdPfarVO, ddsEdPfar.getClass());
		}
		//Page<DdsEdPfar> page = ddsEdPfarService.getPage(new Page<DdsEdPfar>(ddsEdPfarVO.getPage(),ddsEdPfarVO.getLimit()), ddsEdPfar); 
		Page<DdsEdPfar> page = ddsEdPfarService.getPage(new Page<DdsEdPfar>(ddsEdPfarVO.getPageNo(),ddsEdPfarVO.getPageSize()), ddsEdPfar); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdPfarVO ddsEdPfarVO, HttpServletResponse response) {
		DdsEdPfar ddsEdPfar = new DdsEdPfar();
		if (null != ddsEdPfarVO) {
			ddsEdPfar = BeanMapper.map(ddsEdPfarVO, ddsEdPfar.getClass());
		}
		ServiceResp serviceResp = ddsEdPfarService.save(ddsEdPfar);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdPfarVO ddsEdPfarVO, HttpServletResponse response) {
		DdsEdPfar ddsEdPfar = new DdsEdPfar();
		if (null != ddsEdPfarVO) {
			ddsEdPfar = BeanMapper.map(ddsEdPfarVO, ddsEdPfar.getClass());
		}
		ServiceResp serviceResp = ddsEdPfarService.update(ddsEdPfar);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdPfarVO ddsEdPfarVO, HttpServletResponse response) {
		DdsEdPfar ddsEdPfar = new DdsEdPfar();
		if (null != ddsEdPfarVO) {
			ddsEdPfar = BeanMapper.map(ddsEdPfarVO, ddsEdPfar.getClass());
		}
		ServiceResp serviceResp = ddsEdPfarService.remove(ddsEdPfar);
		return renderString(response,serviceResp);
	}

}