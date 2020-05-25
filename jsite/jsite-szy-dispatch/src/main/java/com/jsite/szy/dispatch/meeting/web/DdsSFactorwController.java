package com.jsite.szy.dispatch.meeting.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.meeting.po.DdsSFactorw;
import com.jsite.busi.szy.meeting.service.DdsSFactorwService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.meeting.vo.DdsSFactorwVO;

/**
 *	会商方案评价规则表controller
 * @author hjx
 * @version 2017-07-20
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/meeting/DdsSFactorw")
public class DdsSFactorwController extends BaseController {

	@Autowired
	private DdsSFactorwService ddsSFactorwService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false)DdsSFactorwVO ddsSFactorwVO, HttpServletResponse response) {
		DdsSFactorw ddsSFactorw = new DdsSFactorw();
		if (null != ddsSFactorwVO) {
			ddsSFactorw = BeanMapper.map(ddsSFactorwVO, ddsSFactorw.getClass());
			ddsSFactorw = ddsSFactorwService.get(ddsSFactorw);
		}
		return renderString(response, ddsSFactorw);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsSFactorwVO DdsSFactorwVO, HttpServletResponse response) {
		DdsSFactorw ddsSFactorw = new DdsSFactorw();
		if (null != DdsSFactorwVO) {
			ddsSFactorw = BeanMapper.map(DdsSFactorwVO, ddsSFactorw.getClass());
		}
		Page<DdsSFactorw> page = ddsSFactorwService.getPage(new Page<DdsSFactorw>(), ddsSFactorw); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(List<DdsSFactorwVO> volist, HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		DdsSFactorw ddsSFactorw = new DdsSFactorw();
		for(DdsSFactorwVO vo : volist){
			ddsSFactorw = BeanMapper.map(vo, ddsSFactorw.getClass());
			serviceResp = ddsSFactorwService.save(ddsSFactorw);
		}
		return renderString(response,serviceResp);
	}
	
	/**
	 * 根据指标名称修改指标值
	 * @param volist
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "update",consumes = "application/json")
	public String update(@RequestBody List<DdsSFactorwVO> volist, HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		if(null!=volist){
			for(DdsSFactorwVO vo : volist){
				DdsSFactorw ddsSFactorw = new DdsSFactorw();
				if (null != vo) {
					ddsSFactorw = BeanMapper.map(vo, ddsSFactorw.getClass());
				}
				if(StringUtils.isNotBlank(ddsSFactorw.getScoreMax())){
					serviceResp = ddsSFactorwService.updateScoreMax(ddsSFactorw);
				}else if(StringUtils.isNotBlank(ddsSFactorw.getScoreMin())){
					serviceResp = ddsSFactorwService.updateScoreMin(ddsSFactorw);
				}else if(StringUtils.isNotBlank(ddsSFactorw.getWeight())){
					serviceResp = ddsSFactorwService.updateWeight(ddsSFactorw);
				}
			}
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsSFactorwVO DdsSFactorwVO, HttpServletResponse response) {
		DdsSFactorw ddsSFactorw = new DdsSFactorw();
		if (null != DdsSFactorwVO) {
			ddsSFactorw = BeanMapper.map(DdsSFactorwVO, ddsSFactorw.getClass());
		}
		ServiceResp serviceResp = ddsSFactorwService.remove(ddsSFactorw);
		return renderString(response,serviceResp);
	}

}