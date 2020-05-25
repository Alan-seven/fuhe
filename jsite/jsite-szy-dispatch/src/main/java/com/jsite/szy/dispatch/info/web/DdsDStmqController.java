package com.jsite.szy.dispatch.info.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsDStmq;
import com.jsite.busi.szy.info.po.DdsDStz;
import com.jsite.busi.szy.info.po.DdsDrWq;
import com.jsite.busi.szy.info.service.DdsDStmqService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsDStmqVO;

/**
 * 测站实测流量信息表Controller
 * @author hjx
 * @version 2017-04-27
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsDStmq")
public class DdsDStmqController extends BaseController {

	@Autowired
	private DdsDStmqService ddsDStmqService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsDStmqVO ddsDStmqVO = new DdsDStmqVO();
		if (StringUtils.isNotBlank(id)){
			DdsDStmq ddsDStmq = ddsDStmqService.get(id);
			if (null != ddsDStmq) {
				ddsDStmqVO = BeanMapper.map(ddsDStmq, ddsDStmqVO.getClass());
			}
		}
		return renderString(response, ddsDStmqVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsDStmqVO ddsDStmqVO, HttpServletResponse response) {
		DdsDStmq ddsDStmq = new DdsDStmq();
		if (null != ddsDStmqVO) {
			ddsDStmq = BeanMapper.map(ddsDStmqVO, ddsDStmq.getClass());
		}
		Page<DdsDStmq> page = ddsDStmqService.getPage(new Page<DdsDStmq>(ddsDStmqVO.getPageNo(),ddsDStmqVO.getPageSize()), ddsDStmq); 
		return  renderString(response, page);
	}
	
	/**
	 * 日均流量
	 * @param ddsDStmqVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"listAvg", ""})
	public String listAvg(DdsDStmqVO ddsDStmqVO, HttpServletResponse response) {
		DdsDStmq ddsDStmq = new DdsDStmq();
		if (null != ddsDStmqVO) {
			ddsDStmq = BeanMapper.map(ddsDStmqVO, ddsDStmq.getClass());
		}
		List<DdsDStmq> list = ddsDStmqService.listDayQ(ddsDStmq);
		return  renderString(response, list);
	}
	/**
	 * 查询单个测站一段时间的监测数据
	 * @param ddsDStmqVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"listbystcd", ""})
	public String listByStcd(DdsDStmqVO ddsDStmqVO, HttpServletResponse response) {
		DdsDStmq ddsDStmq = new DdsDStmq();
		if (null != ddsDStmqVO) {
			ddsDStmq = BeanMapper.map(ddsDStmqVO, ddsDStmq.getClass());
		}
		List<DdsDStmq> list = ddsDStmqService.listByStcd(ddsDStmq);
		return  renderString(response, list);
	}
	

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsDStmqVO ddsDStmqVO, HttpServletResponse response) {
		DdsDStmq ddsDStmq = new DdsDStmq();
		if (null != ddsDStmqVO) {
			ddsDStmq = BeanMapper.map(ddsDStmqVO, ddsDStmq.getClass());
		}
		ServiceResp serviceResp = ddsDStmqService.save(ddsDStmq);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsDStmqVO ddsDStmqVO, HttpServletResponse response) {
		DdsDStmq ddsDStmq = new DdsDStmq();
		if (null != ddsDStmqVO) {
			ddsDStmq = BeanMapper.map(ddsDStmqVO, ddsDStmq.getClass());
		}
		ServiceResp serviceResp = ddsDStmqService.update(ddsDStmq);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsDStmqVO ddsDStmqVO, HttpServletResponse response) {
		DdsDStmq ddsDStmq = new DdsDStmq();
		if (null != ddsDStmqVO) {
			ddsDStmq = BeanMapper.map(ddsDStmqVO, ddsDStmq.getClass());
		}
		ServiceResp serviceResp = ddsDStmqService.remove(ddsDStmq);
		return renderString(response,serviceResp);
	}
	
}