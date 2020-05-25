package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdConst;
import com.jsite.busi.szy.emergency.service.DdsEdConstService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdConstVO;

/**
 * 应急调度约束条件表Controller
 * @author hjx
 * @version 2017-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdConst")
public class DdsEdConstController extends BaseController {

	@Autowired
	private DdsEdConstService ddsEdConstService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsEdConstVO ddsEdConstVO = new DdsEdConstVO();
		if (StringUtils.isNotBlank(id)){
			DdsEdConst ddsEdConst = ddsEdConstService.get(id);
			if (null != ddsEdConst) {
				ddsEdConstVO = BeanMapper.map(ddsEdConst, ddsEdConstVO.getClass());
			}
		}
		return renderString(response, ddsEdConstVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdConstVO ddsEdConstVO, HttpServletResponse response) {
		DdsEdConst ddsEdConst = new DdsEdConst();
		if (null != ddsEdConstVO) {
			ddsEdConst = BeanMapper.map(ddsEdConstVO, ddsEdConst.getClass());
		}
		Page<DdsEdConst> page = ddsEdConstService.getPage(new Page<DdsEdConst>(), ddsEdConst); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdConstVO ddsEdConstVO, HttpServletResponse response) {
		DdsEdConst ddsEdConst = new DdsEdConst();
		if (null != ddsEdConstVO) {
			ddsEdConst = BeanMapper.map(ddsEdConstVO, ddsEdConst.getClass());
		}
		ServiceResp serviceResp = ddsEdConstService.save(ddsEdConst);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdConstVO ddsEdConstVO, HttpServletResponse response) {
		DdsEdConst ddsEdConst = new DdsEdConst();
		if (null != ddsEdConstVO) {
			ddsEdConst = BeanMapper.map(ddsEdConstVO, ddsEdConst.getClass());
		}
		ServiceResp serviceResp = ddsEdConstService.update(ddsEdConst);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdConstVO ddsEdConstVO, HttpServletResponse response) {
		DdsEdConst ddsEdConst = new DdsEdConst();
		if (null != ddsEdConstVO) {
			ddsEdConst = BeanMapper.map(ddsEdConstVO, ddsEdConst.getClass());
		}
		ServiceResp serviceResp = ddsEdConstService.remove(ddsEdConst);
		return renderString(response,serviceResp);
	}

}