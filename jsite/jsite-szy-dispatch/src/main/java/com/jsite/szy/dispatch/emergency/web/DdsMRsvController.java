package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsMBoundry;
import com.jsite.busi.szy.emergency.po.DdsMRsv;
import com.jsite.busi.szy.emergency.service.DdsMRsvService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsMRsvVO;

/**
 * 河段模型水库表Controller
 * @author hjx
 * @version 2017-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsMRsv")
public class DdsMRsvController extends BaseController {

	@Autowired
	private DdsMRsvService ddsMRsvService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) DdsMRsvVO ddsMRsvVO, HttpServletResponse response) {
		DdsMRsv ddsMRsv = new DdsMRsv();
		if (null != ddsMRsvVO){
			ddsMRsv = BeanMapper.map(ddsMRsvVO, ddsMRsv.getClass());
			ddsMRsv = ddsMRsvService.get(ddsMRsv);
		}
		return renderString(response, ddsMRsv);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsMRsvVO ddsMRsvVO, HttpServletResponse response) {
		DdsMRsv ddsMRsv = new DdsMRsv();
		if (null != ddsMRsvVO) {
			ddsMRsv = BeanMapper.map(ddsMRsvVO, ddsMRsv.getClass());
		}
		Page<DdsMRsv> page = ddsMRsvService.getPage(new Page<DdsMRsv>(), ddsMRsv); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsMRsvVO ddsMRsvVO, HttpServletResponse response) {
		DdsMRsv ddsMRsv = new DdsMRsv();
		if (null != ddsMRsvVO) {
			ddsMRsv = BeanMapper.map(ddsMRsvVO, ddsMRsv.getClass());
		}
		//判断记录是否重复
		ServiceResp serviceResp = new ServiceResp();
		DdsMRsv entity = ddsMRsvService.get(ddsMRsv);
		if(null!=entity){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("该记录已存在，不可保存");
		}else{
			serviceResp = ddsMRsvService.save(ddsMRsv);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsMRsvVO ddsMRsvVO, HttpServletResponse response) {
		DdsMRsv ddsMRsv = new DdsMRsv();
		if (null != ddsMRsvVO) {
			ddsMRsv = BeanMapper.map(ddsMRsvVO, ddsMRsv.getClass());
		}
		ServiceResp serviceResp = ddsMRsvService.update(ddsMRsv);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsMRsvVO ddsMRsvVO, HttpServletResponse response) {
		DdsMRsv ddsMRsv = new DdsMRsv();
		if (null != ddsMRsvVO) {
			ddsMRsv = BeanMapper.map(ddsMRsvVO, ddsMRsv.getClass());
		}
		ServiceResp serviceResp = ddsMRsvService.remove(ddsMRsv);
		logger.warn("删除河段模型水库记录：ID为："+ddsMRsv.getRescd());
		return renderString(response,serviceResp);
	}

}