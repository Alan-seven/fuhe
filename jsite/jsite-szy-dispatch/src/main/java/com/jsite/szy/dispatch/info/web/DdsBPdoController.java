package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsBPdo;
import com.jsite.busi.szy.info.service.DdsBPdoService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsBPdoVO;

/**
 * 入河排污口基本信息表Controller
 * @author hjx
 * @version 2017-04-26
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsBPdo")
public class DdsBPdoController extends BaseController {

	@Autowired
	private DdsBPdoService ddsBPdoService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsBPdoVO ddsBPdoVO = new DdsBPdoVO();
		if (StringUtils.isNotBlank(id)){
			DdsBPdo ddsBPdo = ddsBPdoService.get(id);
			if (null != ddsBPdo) {
				ddsBPdoVO = BeanMapper.map(ddsBPdo, ddsBPdoVO.getClass());
			}
		}
		return renderString(response, ddsBPdoVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsBPdoVO ddsBPdoVO, HttpServletResponse response) {
		DdsBPdo ddsBPdo = new DdsBPdo();
		if (null != ddsBPdoVO) {
			ddsBPdo = BeanMapper.map(ddsBPdoVO, ddsBPdo.getClass());
		}
		Page<DdsBPdo> page = ddsBPdoService.getPage(new Page<DdsBPdo>(ddsBPdoVO.getPageNo(),ddsBPdoVO.getPageSize()), ddsBPdo); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsBPdoVO ddsBPdoVO, HttpServletResponse response) {
		DdsBPdo ddsBPdo = new DdsBPdo();
		if (null != ddsBPdoVO) {
			ddsBPdo = ddsBPdo = BeanMapper.map(ddsBPdoVO, ddsBPdo.getClass());
		}
		ServiceResp serviceResp = ddsBPdoService.save(ddsBPdo);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsBPdoVO ddsBPdoVO, HttpServletResponse response) {
		DdsBPdo ddsBPdo = new DdsBPdo();
		if (null != ddsBPdoVO) {
			ddsBPdo = BeanMapper.map(ddsBPdoVO, ddsBPdo.getClass());
		}
		ServiceResp serviceResp = ddsBPdoService.update(ddsBPdo);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsBPdoVO ddsBPdoVO, HttpServletResponse response) {
		DdsBPdo ddsBPdo = new DdsBPdo();
		if (null != ddsBPdoVO) {
			ddsBPdo = BeanMapper.map(ddsBPdoVO, ddsBPdo.getClass());
		}
		ServiceResp serviceResp = ddsBPdoService.remove(ddsBPdo);
		return renderString(response,serviceResp);
	}

}