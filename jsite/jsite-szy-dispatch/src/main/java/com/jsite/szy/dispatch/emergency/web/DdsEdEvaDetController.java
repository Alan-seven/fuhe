package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdEvaDet;
import com.jsite.busi.szy.emergency.service.DdsEdEvaDetService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdEvaDetVO;

/**
 * 应急调度方案结果评价详情表Controller
 * @author hjx
 * @version 2017-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdEvaDet")
public class DdsEdEvaDetController extends BaseController {

	@Autowired
	private DdsEdEvaDetService ddsEdEvaDetService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String proCd, HttpServletResponse response) {
		DdsEdEvaDetVO ddsEdEvaDetVO = new DdsEdEvaDetVO();
		if (StringUtils.isNotBlank(proCd)){
			DdsEdEvaDet ddsEdEvaDet = ddsEdEvaDetService.get(proCd);
			if (null != ddsEdEvaDet) {
				ddsEdEvaDetVO = BeanMapper.map(ddsEdEvaDet, ddsEdEvaDetVO.getClass());
			}
		}
		return renderString(response, ddsEdEvaDetVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdEvaDetVO ddsEdEvaDetVO, HttpServletResponse response) {
		DdsEdEvaDet ddsEdEvaDet = new DdsEdEvaDet();
		if (null != ddsEdEvaDetVO) {
			ddsEdEvaDet = BeanMapper.map(ddsEdEvaDetVO, ddsEdEvaDet.getClass());
		}
		//Page<DdsEdEvaDet> page = ddsEdEvaDetService.getPage(new Page<DdsEdEvaDet>(ddsEdEvaDetVO.getPage(),ddsEdEvaDetVO.getLimit()), ddsEdEvaDet); 
		Page<DdsEdEvaDet> page = ddsEdEvaDetService.getPage(new Page<DdsEdEvaDet>(ddsEdEvaDetVO.getPageNo(),ddsEdEvaDetVO.getPageSize()), ddsEdEvaDet); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdEvaDetVO ddsEdEvaDetVO, HttpServletResponse response) {
		DdsEdEvaDet ddsEdEvaDet = new DdsEdEvaDet();
		if (null != ddsEdEvaDetVO) {
			ddsEdEvaDet = BeanMapper.map(ddsEdEvaDetVO, ddsEdEvaDet.getClass());
		}
		ServiceResp serviceResp = ddsEdEvaDetService.save(ddsEdEvaDet);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdEvaDetVO ddsEdEvaDetVO, HttpServletResponse response) {
		DdsEdEvaDet ddsEdEvaDet = new DdsEdEvaDet();
		if (null != ddsEdEvaDetVO) {
			ddsEdEvaDet = BeanMapper.map(ddsEdEvaDetVO, ddsEdEvaDet.getClass());
		}
		ServiceResp serviceResp = ddsEdEvaDetService.update(ddsEdEvaDet);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdEvaDetVO ddsEdEvaDetVO, HttpServletResponse response) {
		DdsEdEvaDet ddsEdEvaDet = new DdsEdEvaDet();
		if (null != ddsEdEvaDetVO) {
			ddsEdEvaDet = BeanMapper.map(ddsEdEvaDetVO, ddsEdEvaDet.getClass());
		}
		ServiceResp serviceResp = ddsEdEvaDetService.remove(ddsEdEvaDet);
		return renderString(response,serviceResp);
	}

}