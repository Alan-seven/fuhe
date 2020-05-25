package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsMBoundry;
import com.jsite.busi.szy.emergency.po.DdsMRiver;
import com.jsite.busi.szy.emergency.service.DdsMBoundryService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsMBoundryVO;

/**
 * 河流模型边界表Controller
 * @author hjx
 * @version 2017-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsMBoundry")
public class DdsMBoundryController extends BaseController {

	@Autowired
	private DdsMBoundryService ddsMBoundryService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) DdsMBoundryVO ddsMBoundryVO, HttpServletResponse response) {
		DdsMBoundry ddsMBoundry = new DdsMBoundry();
		if (null != ddsMBoundryVO){
			ddsMBoundry = BeanMapper.map(ddsMBoundryVO, ddsMBoundry.getClass());
			ddsMBoundry = ddsMBoundryService.get(ddsMBoundry);
		}
		return renderString(response, ddsMBoundry);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsMBoundryVO ddsMBoundryVO, HttpServletResponse response) {
		DdsMBoundry ddsMBoundry = new DdsMBoundry();
		if (null != ddsMBoundryVO) {
			ddsMBoundry = BeanMapper.map(ddsMBoundryVO, ddsMBoundry.getClass());
		}
		Page<DdsMBoundry> page = ddsMBoundryService.getPage(new Page<DdsMBoundry>(), ddsMBoundry); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsMBoundryVO ddsMBoundryVO, HttpServletResponse response) {
		DdsMBoundry ddsMBoundry = new DdsMBoundry();
		if (null != ddsMBoundryVO) {
			ddsMBoundry = BeanMapper.map(ddsMBoundryVO, ddsMBoundry.getClass());
		}
		//判断记录是否重复
		ServiceResp serviceResp = new ServiceResp();
		DdsMBoundry entity = ddsMBoundryService.get(ddsMBoundry);
		if(null!=entity){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("该记录已存在，不可保存");
		}else{
			serviceResp = ddsMBoundryService.save(ddsMBoundry);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsMBoundryVO ddsMBoundryVO, HttpServletResponse response) {
		DdsMBoundry ddsMBoundry = new DdsMBoundry();
		if (null != ddsMBoundryVO) {
			ddsMBoundry = BeanMapper.map(ddsMBoundryVO, ddsMBoundry.getClass());
		}
		ServiceResp serviceResp = ddsMBoundryService.update(ddsMBoundry);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsMBoundryVO ddsMBoundryVO, HttpServletResponse response) {
		DdsMBoundry ddsMBoundry = new DdsMBoundry();
		if (null != ddsMBoundryVO) {
			ddsMBoundry = BeanMapper.map(ddsMBoundryVO, ddsMBoundry.getClass());
		}
		ServiceResp serviceResp = ddsMBoundryService.remove(ddsMBoundry);
		logger.warn("删除河流模型边界记录：ID为："+ddsMBoundryVO.getRcd());
		return renderString(response,serviceResp);
	}

}