package com.jsite.szy.dispatch.meeting.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.meeting.po.DdsSExp;
import com.jsite.busi.szy.meeting.service.DdsSExpService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.IdGen;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.meeting.vo.DdsSExpVO;

/**
 * 专家信息Controller
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/meeting/ddsSExp")
public class DdsSExpController extends BaseController {

	@Autowired
	private DdsSExpService ddsSExpService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String code, HttpServletResponse response) {
		DdsSExpVO ddsSExpVO = new DdsSExpVO();
		if (StringUtils.isNotBlank(code)){
			DdsSExp ddsSExp = ddsSExpService.get(code);
			if (null != ddsSExp) {
				BeanMapper.map(ddsSExp, ddsSExpVO.getClass());
			}
		}
		return renderString(response, ddsSExpVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsSExpVO ddsSExpVO, HttpServletResponse response) {
		DdsSExp ddsSExp = new DdsSExp();
		if (null != ddsSExpVO) {
			ddsSExp = BeanMapper.map(ddsSExpVO, ddsSExp.getClass());
		}
		Page<DdsSExp> page = ddsSExpService.getPage(new Page<DdsSExp>(), ddsSExp); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsSExpVO ddsSExpVO, HttpServletResponse response) {
		ddsSExpVO.setCode(IdGen.uuid());
		DdsSExp ddsSExp = new DdsSExp();
		if (null != ddsSExpVO) {
			ddsSExp = BeanMapper.map(ddsSExpVO, ddsSExp.getClass());
		}
		ServiceResp serviceResp = ddsSExpService.save(ddsSExp);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsSExpVO ddsSExpVO, HttpServletResponse response) {
		DdsSExp ddsSExp = new DdsSExp();
		if (null != ddsSExpVO) {
			ddsSExp = BeanMapper.map(ddsSExpVO, ddsSExp.getClass());
		}
		ServiceResp serviceResp = ddsSExpService.update(ddsSExp);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsSExpVO ddsSExpVO, HttpServletResponse response) {
		DdsSExp ddsSExp = new DdsSExp();
		if (null != ddsSExpVO) {
			ddsSExp = BeanMapper.map(ddsSExpVO, ddsSExp.getClass());
		}
		ServiceResp serviceResp = ddsSExpService.remove(ddsSExp);
		return renderString(response,serviceResp);
	}

}