package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsBRvc;
import com.jsite.busi.szy.info.service.DdsBRvcService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsBRvcVO;

/**
 * 河道信息Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsBRvc")
public class DdsBRvcController extends BaseController {

	@Autowired
	private DdsBRvcService ddsBRvcService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsBRvcVO ddsBRvcVO = new DdsBRvcVO();
		if (StringUtils.isNotBlank(id)){
			DdsBRvc ddsBRvc = ddsBRvcService.get(id);
			if (null != ddsBRvc) {
				BeanMapper.map(ddsBRvc, ddsBRvcVO.getClass());
			}
		}
		return renderString(response, ddsBRvcVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsBRvcVO ddsBRvcVO, HttpServletResponse response) {
		DdsBRvc ddsBRvc = new DdsBRvc();
		if (null != ddsBRvcVO) {
			BeanMapper.map(ddsBRvcVO, ddsBRvc.getClass());
		}
		Page<DdsBRvc> page = ddsBRvcService.getPage(new Page<DdsBRvc>(), ddsBRvc); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsBRvcVO ddsBRvcVO, HttpServletResponse response) {
		DdsBRvc ddsBRvc = new DdsBRvc();
		if (null != ddsBRvcVO) {
			BeanMapper.map(ddsBRvcVO, ddsBRvc.getClass());
		}
		ServiceResp serviceResp = ddsBRvcService.save(ddsBRvc);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsBRvcVO ddsBRvcVO, HttpServletResponse response) {
		DdsBRvc ddsBRvc = new DdsBRvc();
		if (null != ddsBRvcVO) {
			BeanMapper.map(ddsBRvcVO, ddsBRvc.getClass());
		}
		ServiceResp serviceResp = ddsBRvcService.update(ddsBRvc);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsBRvcVO ddsBRvcVO, HttpServletResponse response) {
		DdsBRvc ddsBRvc = new DdsBRvc();
		if (null != ddsBRvcVO) {
			BeanMapper.map(ddsBRvcVO, ddsBRvc.getClass());
		}
		ServiceResp serviceResp = ddsBRvcService.remove(ddsBRvc);
		return renderString(response,serviceResp);
	}

}