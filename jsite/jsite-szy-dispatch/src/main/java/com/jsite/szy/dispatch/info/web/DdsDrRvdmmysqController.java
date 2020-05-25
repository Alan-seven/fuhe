package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsDrRvdmmysq;
import com.jsite.busi.szy.info.service.DdsDrRvdmmysqService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsDrRvdmmysqVO;

/**
 * 水位流量年月旬均值系列表Controller
 * @author hjx
 * @version 2017-11-30
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsDrRvdmmysq")
public class DdsDrRvdmmysqController extends BaseController{

	@Autowired
	private DdsDrRvdmmysqService ddsDrRvdmmysqService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(DdsDrRvdmmysqVO ddsDrRvdmmysqVO, HttpServletResponse response) {
		DdsDrRvdmmysq ddsDrRvdmmysq = new DdsDrRvdmmysq();
		if (null != ddsDrRvdmmysqVO && StringUtils.isNotBlank(ddsDrRvdmmysqVO.getStcd()) && ddsDrRvdmmysqVO.getYr()!=null) {
			ddsDrRvdmmysq = BeanMapper.map(ddsDrRvdmmysqVO, ddsDrRvdmmysq.getClass());
			ddsDrRvdmmysq = ddsDrRvdmmysqService.get(ddsDrRvdmmysq);
		}
		return renderString(response, ddsDrRvdmmysq);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsDrRvdmmysqVO ddsDrRvdmmysqVO, HttpServletResponse response) {
		DdsDrRvdmmysq ddsDrRvdmmysq = new DdsDrRvdmmysq();
		if (null != ddsDrRvdmmysqVO) {
			ddsDrRvdmmysq = BeanMapper.map(ddsDrRvdmmysqVO, ddsDrRvdmmysq.getClass());
		}
		Page<DdsDrRvdmmysq> page = ddsDrRvdmmysqService.getPage(new Page<DdsDrRvdmmysq>(ddsDrRvdmmysqVO.getPageNo(),ddsDrRvdmmysqVO.getPageSize()), ddsDrRvdmmysq); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsDrRvdmmysqVO ddsDrRvdmmysqVO, HttpServletResponse response) {
		DdsDrRvdmmysq ddsDrRvdmmysq = new DdsDrRvdmmysq();
		if (null != ddsDrRvdmmysqVO) {
			ddsDrRvdmmysq = BeanMapper.map(ddsDrRvdmmysqVO, ddsDrRvdmmysq.getClass());
		}
		ServiceResp serviceResp = ddsDrRvdmmysqService.save(ddsDrRvdmmysq);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsDrRvdmmysqVO ddsDrRvdmmysqVO, HttpServletResponse response) {
		DdsDrRvdmmysq ddsDrRvdmmysq = new DdsDrRvdmmysq();
		ServiceResp serviceResp = new ServiceResp();
		if (null != ddsDrRvdmmysqVO) {
			ddsDrRvdmmysq = BeanMapper.map(ddsDrRvdmmysqVO, ddsDrRvdmmysq.getClass());
		}
		if (null != ddsDrRvdmmysqVO && StringUtils.isNotBlank(ddsDrRvdmmysqVO.getStcd()) && ddsDrRvdmmysqVO.getYr()!=null) {
			serviceResp= ddsDrRvdmmysqService.update(ddsDrRvdmmysq);
		}else{
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("更新操作测站编码和年份不能为空");
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsDrRvdmmysqVO ddsDrRvdmmysqVO, HttpServletResponse response) {
		DdsDrRvdmmysq ddsDrRvdmmysq = new DdsDrRvdmmysq();
		ServiceResp serviceResp = new ServiceResp();
		if (null != ddsDrRvdmmysqVO) {
			ddsDrRvdmmysq = BeanMapper.map(ddsDrRvdmmysqVO, ddsDrRvdmmysq.getClass());
		}
		if (null != ddsDrRvdmmysqVO && StringUtils.isNotBlank(ddsDrRvdmmysqVO.getStcd()) && ddsDrRvdmmysqVO.getYr()!=null) {
			serviceResp = ddsDrRvdmmysqService.remove(ddsDrRvdmmysq);
		}else{
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("删除操作测站编码和年份不能为空");
		}
		
		return renderString(response,serviceResp);
	}
}
