package com.jsite.szy.dispatch.meeting.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.meeting.po.DdsSPro;
import com.jsite.busi.szy.meeting.service.DdsSProService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.meeting.vo.DdsSProVO;

/**
 * 会商方案Controller
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/meeting/ddsSPro")
public class DdsSProController extends BaseController {

	@Autowired
	private DdsSProService ddsSProService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(DdsSProVO ddsSProVO, HttpServletResponse response) {
		DdsSPro ddsSPro = new DdsSPro();
		if (null != ddsSProVO) {
			ddsSPro = BeanMapper.map(ddsSProVO , ddsSPro.getClass());
			ddsSPro = ddsSProService.get(ddsSPro);
		}
		return renderString(response, ddsSPro);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsSProVO ddsSProVO, HttpServletResponse response) {
		DdsSPro ddsSPro = new DdsSPro();
		if (null != ddsSProVO) {
			ddsSPro = BeanMapper.map(ddsSProVO, ddsSPro.getClass());
		}
		Page<DdsSPro> page = ddsSProService.getPage(new Page<DdsSPro>(), ddsSPro); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsSProVO ddsSProVO, HttpServletResponse response) {
		DdsSPro ddsSPro = new DdsSPro();
		if (null != ddsSProVO) {
			ddsSPro = BeanMapper.map(ddsSProVO, ddsSPro.getClass());
		}
		ServiceResp serviceResp = ddsSProService.save(ddsSPro);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsSProVO ddsSProVO, HttpServletResponse response) {
		DdsSPro ddsSPro = new DdsSPro();
		if (null != ddsSProVO) {
			ddsSPro = BeanMapper.map(ddsSProVO, ddsSPro.getClass());
		}
		ServiceResp serviceResp = ddsSProService.update(ddsSPro);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsSProVO ddsSProVO, HttpServletResponse response) {
		DdsSPro ddsSPro = new DdsSPro();
		if (null != ddsSProVO) {
			ddsSPro = BeanMapper.map(ddsSProVO, ddsSPro.getClass());
		}
		ServiceResp serviceResp = ddsSProService.remove(ddsSPro);
		return renderString(response,serviceResp);
	}

}