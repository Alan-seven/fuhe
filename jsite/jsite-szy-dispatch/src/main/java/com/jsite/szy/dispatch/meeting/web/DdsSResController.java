package com.jsite.szy.dispatch.meeting.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.meeting.po.DdsSRes;
import com.jsite.busi.szy.meeting.service.DdsSResService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.meeting.vo.DdsSResVO;

/**
 * 会商材料Controller
 * 
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/meeting/ddsSRes")
public class DdsSResController extends BaseController {

	@Autowired
	private DdsSResService ddsSResService;

	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(DdsSResVO ddsSResVO, HttpServletResponse response) {
		DdsSRes ddsSRes = new DdsSRes();
		if (null != ddsSResVO) {
			ddsSRes = BeanMapper.map(ddsSResVO, ddsSRes.getClass());
			ddsSRes = ddsSResService.get(ddsSRes);
		}
		return renderString(response, ddsSRes);
	}

	@ResponseBody
	@RequestMapping(value = { "list", "" })
	public String list(DdsSResVO ddsSResVO, HttpServletResponse response) {
		DdsSRes ddsSRes = new DdsSRes();
		if (null != ddsSResVO) {
			ddsSRes = BeanMapper.map(ddsSResVO, ddsSRes.getClass());
		}
		Page<DdsSRes> page = ddsSResService.getPage(new Page<DdsSRes>(), ddsSRes);
		return renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsSResVO ddsSResVO, HttpServletResponse response) {
		DdsSRes ddsSRes = new DdsSRes();
		if (null != ddsSResVO) {
			ddsSRes = BeanMapper.map(ddsSResVO, ddsSRes.getClass());
		}
		ServiceResp serviceResp = ddsSResService.save(ddsSRes);
		return renderString(response, serviceResp);
	}

	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsSResVO ddsSResVO, HttpServletResponse response) {
		DdsSRes ddsSRes = new DdsSRes();
		if (null != ddsSResVO) {
			ddsSRes = BeanMapper.map(ddsSResVO, ddsSRes.getClass());
		}
		ServiceResp serviceResp = ddsSResService.update(ddsSRes);
		return renderString(response, serviceResp);
	}

	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsSResVO ddsSResVO, HttpServletResponse response) {
		DdsSRes ddsSRes = new DdsSRes();
		if (null != ddsSResVO) {
			ddsSRes = BeanMapper.map(ddsSResVO, ddsSRes.getClass());
		}
		ServiceResp serviceResp = ddsSResService.remove(ddsSRes);
		return renderString(response, serviceResp);
	}

}