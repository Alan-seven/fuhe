package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsMRiver;
import com.jsite.busi.szy.emergency.service.DdsMRiverService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsMRiverVO;

/**
 * 河流概化河段表Controller
 * @author hjx
 * @version 2017-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsMRiver")
public class DdsMRiverController extends BaseController {

	@Autowired
	private DdsMRiverService ddsMRiverService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsMRiverVO ddsMRiverVO = new DdsMRiverVO();
		if (StringUtils.isNotBlank(id)){
			DdsMRiver ddsMRiver = ddsMRiverService.get(id);
			if (null != ddsMRiver) {
				ddsMRiverVO = BeanMapper.map(ddsMRiver, ddsMRiverVO.getClass());
			}
		}
		return renderString(response, ddsMRiverVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsMRiverVO ddsMRiverVO, HttpServletResponse response) {
		DdsMRiver ddsMRiver = new DdsMRiver();
		if (null != ddsMRiverVO) {
			ddsMRiver = BeanMapper.map(ddsMRiverVO, ddsMRiver.getClass());
		}
		Page<DdsMRiver> page = ddsMRiverService.getPage(new Page<DdsMRiver>(), ddsMRiver); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsMRiverVO ddsMRiverVO, HttpServletResponse response) {
		DdsMRiver ddsMRiver = new DdsMRiver();
		if (null != ddsMRiverVO) {
			ddsMRiver = BeanMapper.map(ddsMRiverVO, ddsMRiver.getClass());
		}
		ServiceResp serviceResp = new ServiceResp();
		DdsMRiver entity = ddsMRiverService.get(ddsMRiver);
		if(null!=entity){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("该记录已存在，不可保存");
		}else{
			serviceResp = ddsMRiverService.save(ddsMRiver);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsMRiverVO ddsMRiverVO, HttpServletResponse response) {
		DdsMRiver ddsMRiver = new DdsMRiver();
		if (null != ddsMRiverVO) {
			ddsMRiver = BeanMapper.map(ddsMRiverVO, ddsMRiver.getClass());
		}
		ServiceResp serviceResp = ddsMRiverService.update(ddsMRiver);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsMRiverVO ddsMRiverVO, HttpServletResponse response) {
		DdsMRiver ddsMRiver = new DdsMRiver();
		if (null != ddsMRiverVO) {
			ddsMRiver = BeanMapper.map(ddsMRiverVO, ddsMRiver.getClass());
		}
		ServiceResp serviceResp = ddsMRiverService.remove(ddsMRiver);
		logger.warn("删除河流概化河段记录：ID为："+ddsMRiver.getRcd());
		return renderString(response,serviceResp);
	}

}