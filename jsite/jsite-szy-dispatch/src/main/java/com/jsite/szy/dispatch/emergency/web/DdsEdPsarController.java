package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdPsar;
import com.jsite.busi.szy.emergency.service.DdsEdPsarService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdPsarVO;

/**
 * ]应急调度断面参数表Controller
 * @author hjx
 * @version 2017-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdPsar")
public class DdsEdPsarController extends BaseController {

	@Autowired
	private DdsEdPsarService ddsEdPsarService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String proeCd, HttpServletResponse response) {
		DdsEdPsarVO ddsEdPsarVO = new DdsEdPsarVO();
		if (StringUtils.isNotBlank(proeCd)){
			DdsEdPsar ddsEdPsar = ddsEdPsarService.get(proeCd);
			if (null != ddsEdPsar) {
				ddsEdPsarVO = BeanMapper.map(ddsEdPsar, ddsEdPsarVO.getClass());
			}
		}
		return renderString(response, ddsEdPsarVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdPsarVO ddsEdPsarVO, HttpServletResponse response) {
		DdsEdPsar ddsEdPsar = new DdsEdPsar();
		if (null != ddsEdPsarVO) {
			ddsEdPsar = BeanMapper.map(ddsEdPsarVO, ddsEdPsar.getClass());
		}
		Page<DdsEdPsar> page = ddsEdPsarService.getPage(new Page<DdsEdPsar>(), ddsEdPsar); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdPsarVO ddsEdPsarVO, HttpServletResponse response) {
		DdsEdPsar ddsEdPsar = new DdsEdPsar();
		if (null != ddsEdPsarVO) {
			ddsEdPsar = BeanMapper.map(ddsEdPsarVO, ddsEdPsar.getClass());
		}
		ServiceResp serviceResp = ddsEdPsarService.save(ddsEdPsar);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdPsarVO ddsEdPsarVO, HttpServletResponse response) {
		DdsEdPsar ddsEdPsar = new DdsEdPsar();
		if (null != ddsEdPsarVO) {
			BeanMapper.map(ddsEdPsarVO, ddsEdPsar.getClass());
		}
		ServiceResp serviceResp = ddsEdPsarService.update(ddsEdPsar);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdPsarVO ddsEdPsarVO, HttpServletResponse response) {
		DdsEdPsar ddsEdPsar = new DdsEdPsar();
		if (null != ddsEdPsarVO) {
			ddsEdPsar = BeanMapper.map(ddsEdPsarVO, ddsEdPsar.getClass());
		}
		ServiceResp serviceResp = ddsEdPsarService.remove(ddsEdPsar);
		return renderString(response,serviceResp);
	}

}