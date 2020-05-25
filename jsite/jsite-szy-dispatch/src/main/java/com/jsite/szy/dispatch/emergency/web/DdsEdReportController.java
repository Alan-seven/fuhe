package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdReport;
import com.jsite.busi.szy.emergency.service.DdsEdReportService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.IdGen;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdReportVO;

/**
 * 应急事件处置报告表Controller
 * @author hjx
 * @version 2017-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdReport")
public class DdsEdReportController extends BaseController {

	@Autowired
	private DdsEdReportService ddsEdReportService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String repCd, HttpServletResponse response) {
		DdsEdReportVO ddsEdReportVO = new DdsEdReportVO();
		if (StringUtils.isNotBlank(repCd)){
			DdsEdReport ddsEdReport = ddsEdReportService.get(repCd);
			if (null != ddsEdReport) {
				ddsEdReportVO = BeanMapper.map(ddsEdReport, ddsEdReportVO.getClass());
			}
		}
		return renderString(response, ddsEdReportVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdReportVO ddsEdReportVO, HttpServletResponse response) {
		DdsEdReport ddsEdReport = new DdsEdReport();
		if (null != ddsEdReportVO) {
			BeanMapper.map(ddsEdReportVO, ddsEdReport.getClass());
		}
		//Page<DdsEdReport> page = ddsEdReportService.getPage(new Page<DdsEdReport>(ddsEdReportVO.getPage(),ddsEdReportVO.getLimit()), ddsEdReport); 
		Page<DdsEdReport> page = ddsEdReportService.getPage(new Page<DdsEdReport>(ddsEdReportVO.getPageNo(),ddsEdReportVO.getPageSize()), ddsEdReport); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdReportVO ddsEdReportVO, HttpServletResponse response) {
		ddsEdReportVO.setRepCd(IdGen.randomBase62(8));
		DdsEdReport ddsEdReport = new DdsEdReport();
		if (null != ddsEdReportVO) {
			ddsEdReport = BeanMapper.map(ddsEdReportVO, ddsEdReport.getClass());
		}
		ServiceResp serviceResp = ddsEdReportService.save(ddsEdReport);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdReportVO ddsEdReportVO, HttpServletResponse response) {
		DdsEdReport ddsEdReport = new DdsEdReport();
		if (null != ddsEdReportVO) {
			ddsEdReport = BeanMapper.map(ddsEdReportVO, ddsEdReport.getClass());
		}
		ServiceResp serviceResp = ddsEdReportService.update(ddsEdReport);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdReportVO ddsEdReportVO, HttpServletResponse response) {
		DdsEdReport ddsEdReport = new DdsEdReport();
		if (null != ddsEdReportVO) {
			ddsEdReport = BeanMapper.map(ddsEdReportVO, ddsEdReport.getClass());
		}
		ServiceResp serviceResp = ddsEdReportService.remove(ddsEdReport);
		return renderString(response,serviceResp);
	}

}