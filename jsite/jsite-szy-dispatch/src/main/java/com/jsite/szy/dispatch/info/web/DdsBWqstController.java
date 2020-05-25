package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsBWqst;
import com.jsite.busi.szy.info.service.DdsBWqstService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsBWqstVO;

/**
 * 水质监测站基本信息Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsBWqst")
public class DdsBWqstController extends BaseController {

	@Autowired
	private DdsBWqstService ddsBWqstService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(DdsBWqstVO ddsBWqstVO, HttpServletResponse response) {
		DdsBWqst ddsBWqst = new DdsBWqst();
		if (StringUtils.isNotBlank(ddsBWqstVO.getStcd())){
			ddsBWqst = ddsBWqstService.get(ddsBWqstVO.getStcd());
			if (null != ddsBWqst) {
				ddsBWqstVO = BeanMapper.map(ddsBWqst, ddsBWqstVO.getClass());
			}
		}
		return renderString(response, ddsBWqstVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsBWqstVO ddsBWqstVO, HttpServletResponse response) {
		DdsBWqst ddsBWqst = new DdsBWqst();
		if (null != ddsBWqstVO) {
			BeanMapper.map(ddsBWqstVO, ddsBWqst.getClass());
		}
		Page<DdsBWqst> page = ddsBWqstService.getPage(new Page<DdsBWqst>(), ddsBWqst); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsBWqstVO ddsBWqstVO, HttpServletResponse response) {
		DdsBWqst ddsBWqst = new DdsBWqst();
		if (null != ddsBWqstVO) {
			BeanMapper.map(ddsBWqstVO, ddsBWqst.getClass());
		}
		ServiceResp serviceResp = ddsBWqstService.save(ddsBWqst);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsBWqstVO ddsBWqstVO, HttpServletResponse response) {
		DdsBWqst ddsBWqst = new DdsBWqst();
		if (null != ddsBWqstVO) {
			BeanMapper.map(ddsBWqstVO, ddsBWqst.getClass());
		}
		ServiceResp serviceResp = ddsBWqstService.update(ddsBWqst);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsBWqstVO ddsBWqstVO, HttpServletResponse response) {
		DdsBWqst ddsBWqst = new DdsBWqst();
		if (null != ddsBWqstVO) {
			BeanMapper.map(ddsBWqstVO, ddsBWqst.getClass());
		}
		ServiceResp serviceResp = ddsBWqstService.remove(ddsBWqst);
		return renderString(response,serviceResp);
	}

}