package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdEva;
import com.jsite.busi.szy.emergency.service.DdsEdEvaService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdEvaVO;

/**
 * 应急调度方案结果评价表Controller
 * @author hjx
 * @version 2017-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdEva")
public class DdsEdEvaController extends BaseController {

	@Autowired
	private DdsEdEvaService ddsEdEvaService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String proCd, HttpServletResponse response) {
		DdsEdEvaVO ddsEdEvaVO = new DdsEdEvaVO();
		if (StringUtils.isNotBlank(proCd)){
			DdsEdEva ddsEdEva = ddsEdEvaService.get(proCd);
			if (null != ddsEdEva) {
				ddsEdEvaVO = BeanMapper.map(ddsEdEva, ddsEdEvaVO.getClass());
			}
		}
		return renderString(response, ddsEdEvaVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdEvaVO ddsEdEvaVO, HttpServletResponse response) {
		DdsEdEva ddsEdEva = new DdsEdEva();
		if (null != ddsEdEvaVO) {
			ddsEdEva = BeanMapper.map(ddsEdEvaVO, ddsEdEva.getClass());
		}
		//Page<DdsEdEva> page = ddsEdEvaService.getPage(new Page<DdsEdEva>(ddsEdEvaVO.getPage(),ddsEdEvaVO.getLimit()), ddsEdEva); 
		Page<DdsEdEva> page = ddsEdEvaService.getPage(new Page<DdsEdEva>(ddsEdEvaVO.getPageNo(),ddsEdEvaVO.getPageSize()), ddsEdEva); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdEvaVO ddsEdEvaVO, HttpServletResponse response) {
		DdsEdEva ddsEdEva = new DdsEdEva();
		if (null != ddsEdEvaVO) {
			ddsEdEva = BeanMapper.map(ddsEdEvaVO, ddsEdEva.getClass());
		}
		ServiceResp serviceResp = ddsEdEvaService.save(ddsEdEva);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdEvaVO ddsEdEvaVO, HttpServletResponse response) {
		DdsEdEva ddsEdEva = new DdsEdEva();
		if (null != ddsEdEvaVO) {
			ddsEdEva = BeanMapper.map(ddsEdEvaVO, ddsEdEva.getClass());
		}
		ServiceResp serviceResp = ddsEdEvaService.update(ddsEdEva);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdEvaVO ddsEdEvaVO, HttpServletResponse response) {
		DdsEdEva ddsEdEva = new DdsEdEva();
		if (null != ddsEdEvaVO) {
			ddsEdEva = BeanMapper.map(ddsEdEvaVO, ddsEdEva.getClass());
		}
		ServiceResp serviceResp = ddsEdEvaService.remove(ddsEdEva);
		return renderString(response,serviceResp);
	}

}