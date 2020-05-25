package com.jsite.szy.dispatch.info.web;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.jsite.busi.szy.info.po.DdsDrPptn;
import com.jsite.busi.szy.info.po.DdsDrRiver;
import com.jsite.busi.szy.info.service.DdsDrRiverService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsDrRiverVO;

/**
 * 河道水情表Controller
 * @author hjx
 * @version 2017-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/info/ddsDrRiver")
public class DdsDrRiverController extends BaseController {

	@Autowired
	private DdsDrRiverService ddsDrRiverService;
	
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String stcd, HttpServletResponse response) {
		DdsDrRiverVO ddsDrRiverVO = new DdsDrRiverVO();
		if (StringUtils.isNotBlank(stcd)){
			DdsDrRiver ddsDrRiver = ddsDrRiverService.get(stcd);
			if (null != ddsDrRiver) {
				ddsDrRiverVO = BeanMapper.map(ddsDrRiver, ddsDrRiverVO.getClass());
			}
		}
		return renderString(response, ddsDrRiverVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsDrRiverVO ddsDrRiverVO, HttpServletResponse response) {
		DdsDrRiver ddsDrRiver = new DdsDrRiver();
		if (null != ddsDrRiverVO) {
			BeanMapper.map(ddsDrRiverVO, ddsDrRiver.getClass());
		}
		Page<DdsDrRiver> page = ddsDrRiverService.getPage(new Page<DdsDrRiver>(), ddsDrRiver); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsDrRiverVO ddsDrRiverVO, HttpServletResponse response) {
		DdsDrRiver ddsDrRiver = new DdsDrRiver();
		if (null != ddsDrRiverVO) {
			ddsDrRiver = BeanMapper.map(ddsDrRiverVO, ddsDrRiver.getClass());
		}
		ServiceResp serviceResp = ddsDrRiverService.save(ddsDrRiver);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsDrRiverVO ddsDrRiverVO, HttpServletResponse response) {
		DdsDrRiver ddsDrRiver = new DdsDrRiver();
		if (null != ddsDrRiverVO) {
			ddsDrRiver = BeanMapper.map(ddsDrRiverVO, ddsDrRiver.getClass());
		}
		ServiceResp serviceResp = ddsDrRiverService.update(ddsDrRiver);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsDrRiverVO ddsDrRiverVO, HttpServletResponse response) {
		DdsDrRiver ddsDrRiver = new DdsDrRiver();
		if (null != ddsDrRiverVO) {
			ddsDrRiver = BeanMapper.map(ddsDrRiverVO, ddsDrRiver.getClass());
		}
		ServiceResp serviceResp = ddsDrRiverService.remove(ddsDrRiver);
		return renderString(response,serviceResp);
	}
	
	/**
	 * 单个测站查询
	 * 标记flag 1,2 代表作插值计算（ 1 代表实测值  2代表插值 ）
	 * @param ddsDrRiverVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "listbystcd")
	public String listByStcd(DdsDrRiverVO ddsDrRiverVO, HttpServletResponse response) {
		DdsDrRiver ddsDrRiver = new DdsDrRiver();
		if (null != ddsDrRiverVO) {
			ddsDrRiver = BeanMapper.map(ddsDrRiverVO, ddsDrRiver.getClass());
		}
		List<DdsDrRiver>  list = Lists.newArrayList();
		//查询当前时间的24条数据
		if(StringUtils.isBlank(ddsDrRiver.getStartTime()) && StringUtils.isBlank(ddsDrRiver.getEndTime()) ){
			/*Calendar cal = Calendar.getInstance();
			String startTm = DateUtils.formatDateTime(cal.getTime());
			cal.add(Calendar.DAY_OF_MONTH, -1);
			String endTm = DateUtils.formatDateTime(cal.getTime());
			ddsDrRiver.setStartTime(startTm);
			ddsDrRiver.setEndTime(endTm);*/
			DdsDrRiver entity = ddsDrRiverService.findMaxTime(ddsDrRiver);
			if(null != entity){
				if(null != entity.getTm()){
					Calendar cal = Calendar.getInstance();
					cal.setTime(entity.getTm());
					cal.add(Calendar.DAY_OF_MONTH, -1);
					ddsDrRiver.setStartTime(DateUtils.formatDateTime(cal.getTime()));
					ddsDrRiver.setEndTime(DateUtils.formatDateTime(entity.getTm()));
					list = ddsDrRiverService.listByStcd(ddsDrRiver); 
				}
			}
		}else if(StringUtils.isNotBlank(ddsDrRiver.getStartTime()) && StringUtils.isNotBlank(ddsDrRiver.getEndTime()) ){
			list = ddsDrRiverService.listByStcd(ddsDrRiver); 
		}
		return renderString(response,list);
	}
	
	@ResponseBody
	@RequestMapping(value = "findNewData")
	public String findNewData(DdsDrRiverVO ddsDrRiverVO, HttpServletResponse response) {
		DdsDrRiver ddsDrRiver = new DdsDrRiver();
		if (null != ddsDrRiverVO) {
			ddsDrRiver = BeanMapper.map(ddsDrRiverVO, ddsDrRiver.getClass());
		}
		List<DdsDrRiver>  list = ddsDrRiverService.findNewData(ddsDrRiver);
		return renderString(response,list);
	}
}