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
import com.jsite.busi.szy.info.po.DdsDrRsvr;
import com.jsite.busi.szy.info.service.DdsDrRsvrService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsDrRsvrVO;

/**
 * 水库水情表Controller
 * @author hjx
 * @version 2017-04-27
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsDrRsvr")
public class DdsDrRsvrController extends BaseController {

	@Autowired
	private DdsDrRsvrService ddsDrRsvrService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsDrRsvrVO ddsDrRsvrVO = new DdsDrRsvrVO();
		if (StringUtils.isNotBlank(id)){
			DdsDrRsvr ddsDrRsvr = ddsDrRsvrService.get(id);
			if (null != ddsDrRsvr) {
				ddsDrRsvrVO = BeanMapper.map(ddsDrRsvr, ddsDrRsvrVO.getClass());
			}
		}
		return renderString(response, ddsDrRsvrVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsDrRsvrVO ddsDrRsvrVO, HttpServletResponse response) {
		DdsDrRsvr ddsDrRsvr = new DdsDrRsvr();
		if (null != ddsDrRsvrVO) {
			ddsDrRsvr = BeanMapper.map(ddsDrRsvrVO, ddsDrRsvr.getClass());
		}
		Page<DdsDrRsvr> page = ddsDrRsvrService.getPage(new Page<DdsDrRsvr>(ddsDrRsvrVO.getPageNo(),ddsDrRsvrVO.getPageSize()), ddsDrRsvr); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsDrRsvrVO ddsDrRsvrVO, HttpServletResponse response) {
		DdsDrRsvr ddsDrRsvr = new DdsDrRsvr();
		if (null != ddsDrRsvrVO) {
			BeanMapper.map(ddsDrRsvrVO, ddsDrRsvr.getClass());
		}
		ServiceResp serviceResp = ddsDrRsvrService.save(ddsDrRsvr);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsDrRsvrVO ddsDrRsvrVO, HttpServletResponse response) {
		DdsDrRsvr ddsDrRsvr = new DdsDrRsvr();
		if (null != ddsDrRsvrVO) {
			ddsDrRsvr = BeanMapper.map(ddsDrRsvrVO, ddsDrRsvr.getClass());
		}
		ServiceResp serviceResp = ddsDrRsvrService.update(ddsDrRsvr);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsDrRsvrVO ddsDrRsvrVO, HttpServletResponse response) {
		DdsDrRsvr ddsDrRsvr = new DdsDrRsvr();
		if (null != ddsDrRsvrVO) {
			ddsDrRsvr = BeanMapper.map(ddsDrRsvrVO, ddsDrRsvr.getClass());
		}
		ServiceResp serviceResp = ddsDrRsvrService.remove(ddsDrRsvr);
		return renderString(response,serviceResp);
	}

	/**
	 * 单个测站查询一段时间监测数据
	 * 1,2 代表作插值计算（ 1 代表实测值 2代表插值 ）
	 * @param ddsDrRsvrVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "listbystcd")
	public String listByStcd(DdsDrRsvrVO ddsDrRsvrVO, HttpServletResponse response) {
		DdsDrRsvr ddsDrRsvr = new DdsDrRsvr();
		if (null != ddsDrRsvrVO) {
			ddsDrRsvr = BeanMapper.map(ddsDrRsvrVO, ddsDrRsvr.getClass());
		}
		List<DdsDrRsvr>  list = Lists.newArrayList();
		//查询当前时间的24条数据
		if(StringUtils.isBlank(ddsDrRsvr.getStartTm()) && StringUtils.isBlank(ddsDrRsvr.getEndTm()) ){
			/*Calendar cal = Calendar.getInstance();
			String startTm = DateUtils.formatDateTime(cal.getTime());
			cal.add(Calendar.DAY_OF_MONTH, -1);
			String endTm = DateUtils.formatDateTime(cal.getTime());
			ddsDrRsvr.setStartTm(startTm);
			ddsDrRsvr.setEndTm(endTm);*/
			DdsDrRsvr entity = ddsDrRsvrService.findMaxTime(ddsDrRsvr);
			if(null != entity && null != entity.getTm() ){
				Calendar cal = Calendar.getInstance();
				cal.setTime(entity.getTm());
				cal.add(Calendar.DAY_OF_MONTH, -1);
				ddsDrRsvr.setStartTm(DateUtils.formatDateTime(cal.getTime()));
				ddsDrRsvr.setEndTm(DateUtils.formatDateTime(entity.getTm()));
				list = ddsDrRsvrService.listByStcd(ddsDrRsvr);
			}
		}else if(StringUtils.isNotBlank(ddsDrRsvr.getStartTm()) && StringUtils.isNotBlank(ddsDrRsvr.getEndTm()) ){
			list = ddsDrRsvrService.listByStcd(ddsDrRsvr);
		}
		return renderString(response,list);
	}
	
	/**
	 * 查询水库水文站最新监测数据
	 * @param ddsDrRsvrVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findNewData")
	public String findNewData(DdsDrRsvrVO ddsDrRsvrVO, HttpServletResponse response) {
		DdsDrRsvr ddsDrRsvr = new DdsDrRsvr();
		if (null != ddsDrRsvrVO) {
			ddsDrRsvr = BeanMapper.map(ddsDrRsvrVO, ddsDrRsvr.getClass());
		}
		List<DdsDrRsvr>  list = ddsDrRsvrService.findNewData(ddsDrRsvr);
		return renderString(response,list);
	}
}