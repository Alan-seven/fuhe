package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdPrdar;
import com.jsite.busi.szy.emergency.service.DdsEdPrdarService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdPrdarVO;

/**
 * 应急调度水库时段参数表Controller
 * @author hjx
 * @version 2017-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdPrdar")
public class DdsEdPrdarController extends BaseController {

	@Autowired
	private DdsEdPrdarService ddsEdPrdarService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String proCd, HttpServletResponse response) {
		DdsEdPrdarVO ddsEdPrdarVO = new DdsEdPrdarVO();
		if (StringUtils.isNotBlank(proCd)){
			DdsEdPrdar ddsEdPrdar = ddsEdPrdarService.get(proCd);
			if (null != ddsEdPrdar) {
				ddsEdPrdarVO = BeanMapper.map(ddsEdPrdar, ddsEdPrdarVO.getClass());
			}
		}
		return renderString(response, ddsEdPrdarVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdPrdarVO ddsEdPrdarVO, HttpServletResponse response) {
		DdsEdPrdar ddsEdPrdar = new DdsEdPrdar();
		if (null != ddsEdPrdarVO) {
			ddsEdPrdar = BeanMapper.map(ddsEdPrdarVO, ddsEdPrdar.getClass());
		}
		//Page<DdsEdPrdar> page = ddsEdPrdarService.getPage(new Page<DdsEdPrdar>(ddsEdPrdarVO.getPage(),ddsEdPrdarVO.getLimit()), ddsEdPrdar); 
		Page<DdsEdPrdar> page = ddsEdPrdarService.getPage(new Page<DdsEdPrdar>(ddsEdPrdarVO.getPageNo(),ddsEdPrdarVO.getPageSize()), ddsEdPrdar); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdPrdarVO ddsEdPrdarVO, HttpServletResponse response) {
		DdsEdPrdar ddsEdPrdar = new DdsEdPrdar();
		if (null != ddsEdPrdarVO) {
			ddsEdPrdar = BeanMapper.map(ddsEdPrdarVO, ddsEdPrdar.getClass());
		}
		ServiceResp serviceResp = ddsEdPrdarService.save(ddsEdPrdar);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdPrdarVO ddsEdPrdarVO, HttpServletResponse response) {
		DdsEdPrdar ddsEdPrdar = new DdsEdPrdar();
		if (null != ddsEdPrdarVO) {
			ddsEdPrdar = BeanMapper.map(ddsEdPrdarVO, ddsEdPrdar.getClass());
		}
		ServiceResp serviceResp = ddsEdPrdarService.update(ddsEdPrdar);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdPrdarVO ddsEdPrdarVO, HttpServletResponse response) {
		DdsEdPrdar ddsEdPrdar = new DdsEdPrdar();
		if (null != ddsEdPrdarVO) {
			ddsEdPrdar = BeanMapper.map(ddsEdPrdarVO, ddsEdPrdar.getClass());
		}
		ServiceResp serviceResp = ddsEdPrdarService.remove(ddsEdPrdar);
		return renderString(response,serviceResp);
	}

}