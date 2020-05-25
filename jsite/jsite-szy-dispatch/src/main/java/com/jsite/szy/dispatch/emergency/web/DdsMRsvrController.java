package com.jsite.szy.dispatch.emergency.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsMRsvr;
import com.jsite.busi.szy.emergency.service.DdsMRsvrService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsMRsvrVO;

/**
 * 应急调度水库调节设置初始条件Controller
 * @author hjx
 * @version 2017-07-10
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsMRsvr")
public class DdsMRsvrController extends BaseController {

	@Autowired
	private DdsMRsvrService ddsMRsvrService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) DdsMRsvrVO ddsMRsvrVO, HttpServletResponse response) {
		DdsMRsvr ddsMRsvr = new DdsMRsvr();
		if (StringUtils.isNotBlank(ddsMRsvrVO.getProCd())&&StringUtils.isNotBlank(ddsMRsvrVO.getResCd())){
			ddsMRsvr = BeanMapper.map(ddsMRsvrVO, ddsMRsvr.getClass());
			ddsMRsvr = ddsMRsvrService.get(ddsMRsvr);
		}
		return renderString(response, ddsMRsvr);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsMRsvrVO ddsMRsvrVO, HttpServletResponse response) {
		DdsMRsvr ddsMRsvr = new DdsMRsvr();
		if (null != ddsMRsvrVO) {
			ddsMRsvr = BeanMapper.map(ddsMRsvrVO, ddsMRsvr.getClass());
		}
		Page<DdsMRsvr> page = ddsMRsvrService.getPage(new Page<DdsMRsvr>(), ddsMRsvr); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(@RequestBody List<DdsMRsvrVO> volist, HttpServletResponse response) {
		DdsMRsvr ddsMRsvr = new DdsMRsvr();
		ServiceResp serviceResp = new ServiceResp();
		if (null != volist) {
			for(int i = 0 ; i < volist.size(); i ++){
				DdsMRsvrVO ddsMRsvrVO = volist.get(i);
				ddsMRsvr = BeanMapper.map(ddsMRsvrVO, ddsMRsvr.getClass());
				serviceResp = ddsMRsvrService.save(ddsMRsvr);
			}
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsMRsvrVO ddsMRsvrVO, HttpServletResponse response) {
		DdsMRsvr ddsMRsvr = new DdsMRsvr();
		if (null != ddsMRsvrVO) {
			ddsMRsvr = BeanMapper.map(ddsMRsvrVO, ddsMRsvr.getClass());
		}
		ServiceResp serviceResp = ddsMRsvrService.update(ddsMRsvr);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "updateTimeById")
	public String updateTimeById(DdsMRsvrVO ddsMRsvrVO, HttpServletResponse response) {
		DdsMRsvr ddsMRsvr = new DdsMRsvr();
		if (null != ddsMRsvrVO) {
			ddsMRsvr = BeanMapper.map(ddsMRsvrVO, ddsMRsvr.getClass());
		}
		DdsMRsvr entity = ddsMRsvrService.get(ddsMRsvr);
		ServiceResp serviceResp = new ServiceResp();
		serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
		serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
		if(null!=entity){
			if(null!=ddsMRsvrVO.getStarttime()){
				entity.setStarttime(ddsMRsvrVO.getStarttime());
			}
			if(null!=ddsMRsvrVO.getEndtime()){
				entity.setEndtime(ddsMRsvrVO.getEndtime());
			}
			serviceResp = ddsMRsvrService.update(ddsMRsvr);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsMRsvrVO ddsMRsvrVO, HttpServletResponse response) {
		DdsMRsvr ddsMRsvr = new DdsMRsvr();
		if (null != ddsMRsvrVO) {
			ddsMRsvr = BeanMapper.map(ddsMRsvrVO, ddsMRsvr.getClass());
		}
		ServiceResp serviceResp = ddsMRsvrService.remove(ddsMRsvr);
		return renderString(response,serviceResp);
	}

}