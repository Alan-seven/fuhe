package com.jsite.szy.dispatch.meeting.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.meeting.po.DdsSFactor;
import com.jsite.busi.szy.meeting.service.DdsSFactorService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.meeting.vo.DdsSFactorVO;

/**
 * 会商方案评价指标Controller
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/meeting/ddsSFactor")
public class DdsSFactorController extends BaseController {

	@Autowired
	private DdsSFactorService ddsSFactorService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsSFactorVO ddsSFactorVO = new DdsSFactorVO();
		if (StringUtils.isNotBlank(id)){
			DdsSFactor ddsSFactor = ddsSFactorService.get(id);
			if (null != ddsSFactor) {
				BeanMapper.map(ddsSFactor, ddsSFactorVO.getClass());
			}
		}
		return renderString(response, ddsSFactorVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsSFactorVO ddsSFactorVO, HttpServletResponse response) {
		DdsSFactor ddsSFactor = new DdsSFactor();
		if (null != ddsSFactorVO) {
			BeanMapper.map(ddsSFactorVO, ddsSFactor.getClass());
		}
		Page<DdsSFactor> page = ddsSFactorService.getPage(new Page<DdsSFactor>(), ddsSFactor); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsSFactorVO ddsSFactorVO, HttpServletResponse response) {
		DdsSFactor ddsSFactor = new DdsSFactor();
		if (null != ddsSFactorVO) {
			BeanMapper.map(ddsSFactorVO, ddsSFactor.getClass());
		}
		ServiceResp serviceResp = ddsSFactorService.save(ddsSFactor);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsSFactorVO ddsSFactorVO, HttpServletResponse response) {
		DdsSFactor ddsSFactor = new DdsSFactor();
		if (null != ddsSFactorVO) {
			BeanMapper.map(ddsSFactorVO, ddsSFactor.getClass());
		}
		ServiceResp serviceResp = ddsSFactorService.update(ddsSFactor);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsSFactorVO ddsSFactorVO, HttpServletResponse response) {
		DdsSFactor ddsSFactor = new DdsSFactor();
		if (null != ddsSFactorVO) {
			BeanMapper.map(ddsSFactorVO, ddsSFactor.getClass());
		}
		ServiceResp serviceResp = ddsSFactorService.remove(ddsSFactor);
		return renderString(response,serviceResp);
	}

}