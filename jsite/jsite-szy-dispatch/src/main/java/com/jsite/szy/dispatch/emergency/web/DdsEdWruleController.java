package com.jsite.szy.dispatch.emergency.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdBound;
import com.jsite.busi.szy.emergency.po.DdsEdWrule;
import com.jsite.busi.szy.emergency.service.DdsEdWruleService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdBoundVO;
import com.jsite.szy.dispatch.emergency.vo.DdsEdWruleVO;

/**
 * 告警规则表Controller
 * @author hjx
 * @version 2017-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdWrule")
public class DdsEdWruleController extends BaseController {

	@Autowired
	private DdsEdWruleService ddsEdWruleService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(DdsEdWruleVO ddsEdWruleVO, HttpServletResponse response) {
		DdsEdWrule ddsEdWrule = new DdsEdWrule();
		if (null != ddsEdWrule){
			ddsEdWrule = BeanMapper.map(ddsEdWruleVO, ddsEdWrule.getClass());
			ddsEdWrule = ddsEdWruleService.get(ddsEdWrule);
		}
		return renderString(response, ddsEdWruleVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdWruleVO ddsEdWruleVO, HttpServletResponse response) {
		DdsEdWrule ddsEdWrule = new DdsEdWrule();
		if (null != ddsEdWruleVO) {
			ddsEdWrule = BeanMapper.map(ddsEdWruleVO, ddsEdWrule.getClass());
		}
		List<DdsEdWrule>  list = ddsEdWruleService.listGroupByIn(ddsEdWrule);
		for(DdsEdWrule entity : list){
			List<DdsEdWrule> wrulelist = ddsEdWruleService.list(entity);
			entity.setWruleList(wrulelist);
		}
		Page<DdsEdWrule> page = new Page();
		page.setList(list);
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdWruleVO ddsEdWruleVO, HttpServletResponse response) {
		DdsEdWrule ddsEdWrule = new DdsEdWrule();
		if (null != ddsEdWruleVO) {
			ddsEdWrule = BeanMapper.map(ddsEdWruleVO, ddsEdWrule.getClass());
		}
		ServiceResp serviceResp = new ServiceResp();
		DdsEdWrule entity = ddsEdWruleService.get(ddsEdWrule);
		if(null!=entity){
			serviceResp	= ddsEdWruleService.update(ddsEdWrule);
		}else{
			serviceResp	= ddsEdWruleService.save(ddsEdWrule);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdWruleVO ddsEdWruleVO, HttpServletResponse response) {
		DdsEdWrule ddsEdWrule = new DdsEdWrule();
		if (null != ddsEdWruleVO) {
			ddsEdWrule = BeanMapper.map(ddsEdWruleVO, ddsEdWrule.getClass());
		}
		ServiceResp serviceResp = ddsEdWruleService.update(ddsEdWrule);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdWruleVO ddsEdWruleVO, HttpServletResponse response) {
		DdsEdWrule ddsEdWrule = new DdsEdWrule();
		if (null != ddsEdWruleVO) {
			ddsEdWrule = BeanMapper.map(ddsEdWruleVO, ddsEdWrule.getClass());
		}
		ServiceResp serviceResp = ddsEdWruleService.remove(ddsEdWrule);
		return renderString(response,serviceResp);
	}

}