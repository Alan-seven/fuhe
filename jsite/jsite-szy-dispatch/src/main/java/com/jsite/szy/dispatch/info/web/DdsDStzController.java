package com.jsite.szy.dispatch.info.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsDStz;
import com.jsite.busi.szy.info.po.DdsDrWq;
import com.jsite.busi.szy.info.service.DdsDStzService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsDStzVO;

/**
 * 测站水位监测信息表Controller
 * @author hjx
 * @version 2017-04-27
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsDStz")
public class DdsDStzController extends BaseController {

	@Autowired
	private DdsDStzService ddsDStzService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsDStzVO ddsDStzVO = new DdsDStzVO();
		if (StringUtils.isNotBlank(id)){
			DdsDStz ddsDStz = ddsDStzService.get(id);
			if (null != ddsDStz) {
				BeanMapper.map(ddsDStz, ddsDStzVO.getClass());
			}
		}
		return renderString(response, ddsDStzVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsDStzVO ddsDStzVO, HttpServletResponse response) {
		DdsDStz ddsDStz = new DdsDStz();
		if (null != ddsDStzVO) {
			ddsDStz = BeanMapper.map(ddsDStzVO, ddsDStz.getClass());
		}
		Page<DdsDStz> page = ddsDStzService.getPage(new Page<DdsDStz>(ddsDStzVO.getPageNo(),ddsDStzVO.getPageSize()), ddsDStz); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = {"listAvg", ""})
	public String listAvg(DdsDStzVO ddsDStzVO, HttpServletResponse response) {
		DdsDStz ddsDStz = new DdsDStz();
		if (null != ddsDStzVO) {
			ddsDStz = BeanMapper.map(ddsDStzVO, ddsDStz.getClass());
		}
		List<DdsDStz> list = ddsDStzService.listDayZ(ddsDStz);
		return  renderString(response, list);
	}
	
	/**
	 * 查询单个测站一段时间的监测数据
	 * @param ddsDStzVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"listbystcd", ""})
	public String listByStcd(DdsDStzVO ddsDStzVO, HttpServletResponse response) {
		DdsDStz ddsDStz = new DdsDStz();
		if (null != ddsDStzVO) {
			ddsDStz = BeanMapper.map(ddsDStzVO, ddsDStz.getClass());
		}
		List<DdsDStz> list = ddsDStzService.listByStcd(ddsDStz);
		return  renderString(response, list);
	}

	
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsDStzVO ddsDStzVO, HttpServletResponse response) {
		DdsDStz ddsDStz = new DdsDStz();
		if (null != ddsDStzVO) {
			ddsDStz = BeanMapper.map(ddsDStzVO, ddsDStz.getClass());
		}
		ServiceResp serviceResp = ddsDStzService.save(ddsDStz);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsDStzVO ddsDStzVO, HttpServletResponse response) {
		DdsDStz ddsDStz = new DdsDStz();
		if (null != ddsDStzVO) {
			ddsDStz = BeanMapper.map(ddsDStzVO, ddsDStz.getClass());
		}
		ServiceResp serviceResp = ddsDStzService.update(ddsDStz);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsDStzVO ddsDStzVO, HttpServletResponse response) {
		DdsDStz ddsDStz = new DdsDStz();
		if (null != ddsDStzVO) {
			ddsDStz = BeanMapper.map(ddsDStzVO, ddsDStz.getClass());
		}
		ServiceResp serviceResp = ddsDStzService.remove(ddsDStz);
		return renderString(response,serviceResp);
	}

}