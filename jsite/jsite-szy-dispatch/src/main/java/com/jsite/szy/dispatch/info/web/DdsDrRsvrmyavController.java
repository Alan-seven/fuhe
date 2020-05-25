package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsDrRsvrmyav;
import com.jsite.busi.szy.info.service.DdsDrRsvrmyavService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsDrRsvrmyavVO;

/**
 * 水库 水位、入库流量、出库流量年月旬均值系列表Controller
 * @author hjx
 * @version 2017-11-30
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsDrRsvrmyav")
public class DdsDrRsvrmyavController extends BaseController{

	@Autowired
	private DdsDrRsvrmyavService ddsDrRsvrmyavService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(DdsDrRsvrmyavVO ddsDrRsvrmyavVO, HttpServletResponse response) {
		DdsDrRsvrmyav ddsDrRsvrmyav = new DdsDrRsvrmyav();
		if (null != ddsDrRsvrmyavVO && StringUtils.isNotBlank(ddsDrRsvrmyavVO.getStcd()) && ddsDrRsvrmyavVO.getYr()!=null) {
			ddsDrRsvrmyav = BeanMapper.map(ddsDrRsvrmyavVO, ddsDrRsvrmyav.getClass());
			ddsDrRsvrmyav = ddsDrRsvrmyavService.get(ddsDrRsvrmyav);
		}
		return renderString(response, ddsDrRsvrmyav);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsDrRsvrmyavVO ddsDrRsvrmyavVO, HttpServletResponse response) {
		DdsDrRsvrmyav ddsDrRsvrmyav = new DdsDrRsvrmyav();
		if (null != ddsDrRsvrmyavVO) {
			ddsDrRsvrmyav = BeanMapper.map(ddsDrRsvrmyavVO, ddsDrRsvrmyav.getClass());
		}
		Page<DdsDrRsvrmyav> page = ddsDrRsvrmyavService.getPage(new Page<DdsDrRsvrmyav>(ddsDrRsvrmyavVO.getPageNo(),ddsDrRsvrmyavVO.getPageSize()), ddsDrRsvrmyav); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsDrRsvrmyavVO ddsDrRsvrmyavVO, HttpServletResponse response) {
		DdsDrRsvrmyav ddsDrRsvrmyav = new DdsDrRsvrmyav();
		if (null != ddsDrRsvrmyavVO) {
			ddsDrRsvrmyav = BeanMapper.map(ddsDrRsvrmyavVO, ddsDrRsvrmyav.getClass());
		}
		ServiceResp serviceResp = ddsDrRsvrmyavService.save(ddsDrRsvrmyav);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsDrRsvrmyavVO ddsDrRsvrmyavVO, HttpServletResponse response) {
		DdsDrRsvrmyav ddsDrRsvrmyav = new DdsDrRsvrmyav();
		ServiceResp serviceResp = new ServiceResp();
		if (null != ddsDrRsvrmyavVO) {
			ddsDrRsvrmyav = BeanMapper.map(ddsDrRsvrmyavVO, ddsDrRsvrmyav.getClass());
		}
		if (null != ddsDrRsvrmyavVO && StringUtils.isNotBlank(ddsDrRsvrmyavVO.getStcd()) && ddsDrRsvrmyavVO.getYr()!=null) {
			serviceResp= ddsDrRsvrmyavService.update(ddsDrRsvrmyav);
		}else{
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("更新操作测站编码和年份不能为空");
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsDrRsvrmyavVO ddsDrRsvrmyavVO, HttpServletResponse response) {
		DdsDrRsvrmyav ddsDrRsvrmyav = new DdsDrRsvrmyav();
		ServiceResp serviceResp = new ServiceResp();
		if (null != ddsDrRsvrmyavVO) {
			ddsDrRsvrmyav = BeanMapper.map(ddsDrRsvrmyavVO, ddsDrRsvrmyav.getClass());
		}
		if (null != ddsDrRsvrmyavVO && StringUtils.isNotBlank(ddsDrRsvrmyavVO.getStcd()) && ddsDrRsvrmyavVO.getYr()!=null) {
			serviceResp = ddsDrRsvrmyavService.remove(ddsDrRsvrmyav);
		}else{
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("删除操作测站编码和年份不能为空");
		}
		
		return renderString(response,serviceResp);
	}
	
}
