package com.jsite.szy.dispatch.meeting.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.jsite.busi.szy.meeting.po.DdsSGrade;
import com.jsite.busi.szy.meeting.service.DdsSGradeService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.meeting.vo.DdsSGradeVO;

/**
 * 会商方案专家打分Controller
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/meeting/ddsSGrade")
public class DdsSGradeController extends BaseController {

	@Autowired
	private DdsSGradeService ddsSGradeService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(DdsSGradeVO ddsSGradeVO, HttpServletResponse response) {
		DdsSGrade ddsSGrade = new DdsSGrade();
		if (null != ddsSGradeVO) {
			ddsSGrade = BeanMapper.map(ddsSGradeVO, ddsSGrade.getClass());
			ddsSGrade = ddsSGradeService.get(ddsSGrade);
		}
		return renderString(response, ddsSGrade);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsSGradeVO ddsSGradeVO, HttpServletResponse response) {
		DdsSGrade ddsSGrade = new DdsSGrade();
		if (null != ddsSGradeVO) {
			ddsSGrade = BeanMapper.map(ddsSGradeVO, ddsSGrade.getClass());
		}
		Page<DdsSGrade> page = ddsSGradeService.getPage(new Page<DdsSGrade>(), ddsSGrade); 
		return  renderString(response, page);
	}

	/**
	 * 批量保存
	 * @param volist
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(@RequestBody List<DdsSGradeVO> volist, HttpServletResponse response) {
		DdsSGrade ddsSGrade = new DdsSGrade();
		ServiceResp serviceResp = new ServiceResp();
		if (null != volist) {
			for(int i = 0 ; i < volist.size();i++){
				DdsSGradeVO ddsSGradeVO = volist.get(i);
				ddsSGrade = BeanMapper.map(ddsSGradeVO, ddsSGrade.getClass());
				serviceResp = ddsSGradeService.save(ddsSGrade);
			}
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsSGradeVO ddsSGradeVO, HttpServletResponse response) {
		DdsSGrade ddsSGrade = new DdsSGrade();
		if (null != ddsSGradeVO) {
			ddsSGrade = BeanMapper.map(ddsSGradeVO, ddsSGrade.getClass());
		}
		ServiceResp serviceResp = ddsSGradeService.update(ddsSGrade);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsSGradeVO ddsSGradeVO, HttpServletResponse response) {
		DdsSGrade ddsSGrade = new DdsSGrade();
		if (null != ddsSGradeVO) {
			ddsSGrade = BeanMapper.map(ddsSGradeVO, ddsSGrade.getClass());
		}
		ServiceResp serviceResp = ddsSGradeService.remove(ddsSGrade);
		return renderString(response,serviceResp);
	}

	/**
	 * 根据会商ID，获取会商设置的相关专家人员信息  方案信息列表
	 * @param ddsSGrade
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getGrade")
	public String getGrade(DdsSGradeVO ddsSGradeVO, HttpServletResponse response){
		DdsSGrade ddsSGrade = new DdsSGrade();
		if (null != ddsSGradeVO) {
			ddsSGrade = BeanMapper.map(ddsSGradeVO, ddsSGrade.getClass());
		}
		List<DdsSGrade> explist = ddsSGradeService.getExpByConid(ddsSGrade);
		List<DdsSGrade> prolist = ddsSGradeService.getProByConid(ddsSGrade);
		List<DdsSGrade> gradelist = ddsSGradeService.list(ddsSGrade);
		Map<String, Object> map = Maps.newHashMap();
		map.put("exp", explist);
		map.put("edp", prolist);
		map.put("grade",gradelist);
		return renderString(response, map);
	}
	
}