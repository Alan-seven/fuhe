package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdInit;
import com.jsite.busi.szy.emergency.service.DdsEdInitService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdInitVO;

/**
 * 应急调度初始条件Controller
 * @author hjx
 * @version 2017-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdInit")
public class DdsEdInitController extends BaseController {

	@Autowired
	private DdsEdInitService ddsEdInitService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsEdInitVO ddsEdInitVO = new DdsEdInitVO();
		if (StringUtils.isNotBlank(id)){
			DdsEdInit ddsEdInit = ddsEdInitService.get(id);
			if (null != ddsEdInit) {
				ddsEdInitVO = BeanMapper.map(ddsEdInit, ddsEdInitVO.getClass());
			}
		}
		return renderString(response, ddsEdInitVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdInitVO ddsEdInitVO, HttpServletResponse response) {
		DdsEdInit ddsEdInit = new DdsEdInit();
		if (null != ddsEdInitVO) {
			ddsEdInit = BeanMapper.map(ddsEdInitVO, ddsEdInit.getClass());
		}
		Page<DdsEdInit> page = ddsEdInitService.getPage(new Page<DdsEdInit>(), ddsEdInit); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdInitVO ddsEdInitVO, HttpServletResponse response) {
		DdsEdInit ddsEdInit = new DdsEdInit();
		if (null != ddsEdInitVO) {
			ddsEdInit = BeanMapper.map(ddsEdInitVO, ddsEdInit.getClass());
		}
		ServiceResp	serviceResp = ddsEdInitService.save(ddsEdInit);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdInitVO ddsEdInitVO, HttpServletResponse response) {
		DdsEdInit ddsEdInit = new DdsEdInit();
		if (null != ddsEdInitVO) {
			ddsEdInit = BeanMapper.map(ddsEdInitVO, ddsEdInit.getClass());
		}
		ServiceResp serviceResp = ddsEdInitService.update(ddsEdInit);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "updateConcstById")
	public String updateConcstById(DdsEdInitVO ddsEdInitVO, HttpServletResponse response) {
		DdsEdInit ddsEdInit = new DdsEdInit();
		if (null != ddsEdInitVO) {
			ddsEdInit = BeanMapper.map(ddsEdInitVO, ddsEdInit.getClass());
		}
		ServiceResp serviceResp = new ServiceResp();
		DdsEdInit entity = ddsEdInitService.get(ddsEdInit);
		if(null!=entity){
			entity.setConcSt(ddsEdInitVO.getConcSt());
			serviceResp = ddsEdInitService.update(entity);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdInitVO ddsEdInitVO, HttpServletResponse response) {
		DdsEdInit ddsEdInit = new DdsEdInit();
		if (null != ddsEdInitVO) {
			ddsEdInit = BeanMapper.map(ddsEdInitVO, ddsEdInit.getClass());
		}
		ServiceResp serviceResp = ddsEdInitService.remove(ddsEdInit);
		return renderString(response,serviceResp);
	}

}