package com.jsite.szy.dispatch.sys.web;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.sys.service.DeptInfoService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.dao.sys.po.DeptInfo;
import com.jsite.szy.dispatch.sys.vo.DdsSysDepinfoVO;

/**
 * 部门信息表Controller
 * @author hjx
 * @version 2017-09-12
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/sys/dept")
public class DdsSysDepinfoController extends BaseController {

	@Autowired
	private DeptInfoService ddsSysDepinfoService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsSysDepinfoVO ddsSysDepinfoVO = new DdsSysDepinfoVO();
		if (StringUtils.isNotBlank(id)){
			DeptInfo ddsSysDepinfo = ddsSysDepinfoService.get(id);
			if (null != ddsSysDepinfo) {
				ddsSysDepinfoVO = BeanMapper.map(ddsSysDepinfo, ddsSysDepinfoVO.getClass());
			}
		}
		return renderString(response, ddsSysDepinfoVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsSysDepinfoVO ddsSysDepinfoVO, HttpServletResponse response) {
		DeptInfo ddsSysDepinfo = new DeptInfo();
		if (null != ddsSysDepinfoVO) {
			ddsSysDepinfo = BeanMapper.map(ddsSysDepinfoVO, ddsSysDepinfo.getClass());
		}
		//Page<DeptInfo> page = ddsSysDepinfoService.getPage(new Page<DeptInfo>(ddsSysDepinfoVO.getPage(),ddsSysDepinfoVO.getLimit()), ddsSysDepinfo); 
		Page<DeptInfo> page = ddsSysDepinfoService.getPage(new Page<DeptInfo>(ddsSysDepinfoVO.getPageNo(),ddsSysDepinfoVO.getPageSize()), ddsSysDepinfo); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsSysDepinfoVO ddsSysDepinfoVO, HttpServletResponse response) {
		DeptInfo ddsSysDepinfo = new DeptInfo();
		if (null != ddsSysDepinfoVO) {
			ddsSysDepinfo = BeanMapper.map(ddsSysDepinfoVO, ddsSysDepinfo.getClass());
		}
		ServiceResp serviceResp = ddsSysDepinfoService.save(ddsSysDepinfo);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsSysDepinfoVO ddsSysDepinfoVO, HttpServletResponse response) {
		DeptInfo ddsSysDepinfo = new DeptInfo();
		if (null != ddsSysDepinfoVO) {
			ddsSysDepinfo = BeanMapper.map(ddsSysDepinfoVO, ddsSysDepinfo.getClass());
		}
		ServiceResp serviceResp = ddsSysDepinfoService.update(ddsSysDepinfo);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsSysDepinfoVO ddsSysDepinfoVO, HttpServletResponse response) {
		DeptInfo ddsSysDepinfo = new DeptInfo();
		if (null != ddsSysDepinfoVO) {
			ddsSysDepinfo = BeanMapper.map(ddsSysDepinfoVO, ddsSysDepinfo.getClass());
		}
		ServiceResp serviceResp = ddsSysDepinfoService.remove(ddsSysDepinfo);
		return renderString(response,serviceResp);
	}

}