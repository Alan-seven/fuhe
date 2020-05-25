package com.jsite.szy.dispatch.info.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsCInd;
import com.jsite.busi.szy.info.service.DdsCIndService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsCIndVO;

/**
 * 曲线索引Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsCInd")
public class DdsCIndController extends BaseController {

	@Autowired
	private DdsCIndService ddsCIndService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsCIndVO ddsCIndVO = new DdsCIndVO();
		if (StringUtils.isNotBlank(id)){
			DdsCInd ddsCInd = ddsCIndService.get(id);
			if (null != ddsCInd) {
				BeanMapper.map(ddsCInd, ddsCIndVO.getClass());
			}
		}
		return renderString(response, ddsCIndVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsCIndVO ddsCIndVO, HttpServletResponse response) {
		DdsCInd ddsCInd = new DdsCInd();
		if (null != ddsCIndVO) {
			BeanMapper.map(ddsCIndVO, ddsCInd.getClass());
		}
		Page<DdsCInd> page = ddsCIndService.getPage(new Page<DdsCInd>(), ddsCInd); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsCIndVO ddsCIndVO, HttpServletResponse response) {
		DdsCInd ddsCInd = new DdsCInd();
		if (null != ddsCIndVO) {
			BeanMapper.map(ddsCIndVO, ddsCInd.getClass());
		}
		ServiceResp serviceResp = ddsCIndService.save(ddsCInd);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsCIndVO ddsCIndVO, HttpServletResponse response) {
		DdsCInd ddsCInd = new DdsCInd();
		if (null != ddsCIndVO) {
			BeanMapper.map(ddsCIndVO, ddsCInd.getClass());
		}
		ServiceResp serviceResp = ddsCIndService.update(ddsCInd);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsCIndVO ddsCIndVO, HttpServletResponse response) {
		DdsCInd ddsCInd = new DdsCInd();
		if (null != ddsCIndVO) {
			BeanMapper.map(ddsCIndVO, ddsCInd.getClass());
		}
		ServiceResp serviceResp = ddsCIndService.remove(ddsCInd);
		return renderString(response,serviceResp);
	}

}