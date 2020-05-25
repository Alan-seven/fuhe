package com.jsite.szy.dispatch.emergency.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdSCon;
import com.jsite.busi.szy.emergency.service.DdsEdSConService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsEdSConVO;


/**
 * 应急调度追踪溯源断面设置Entity
 * @author hjx
 * @version 2017-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdSCon")
public class DdsEdSConController extends BaseController{

	@Autowired
	private DdsEdSConService ddsEdSConService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) DdsEdSConVO ddsEdSConVO, HttpServletResponse response) {
		DdsEdSCon ddsEdSCon = new DdsEdSCon();
		if (null != ddsEdSConVO){
			ddsEdSCon = BeanMapper.map(ddsEdSConVO, ddsEdSCon.getClass());
			ddsEdSCon = ddsEdSConService.get(ddsEdSCon);
		}
		return renderString(response, ddsEdSCon);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdSConVO ddsEdSConVO, HttpServletResponse response) {
		DdsEdSCon ddsEdSCon = new DdsEdSCon();
		if (null != ddsEdSConVO) {
			ddsEdSCon = BeanMapper.map(ddsEdSConVO, ddsEdSCon.getClass());
		}
		Page<DdsEdSCon> page = ddsEdSConService.getPage(new Page<DdsEdSCon>(), ddsEdSCon); 
		return  renderString(response, page);
	}

	//批量保存
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(@RequestBody List<DdsEdSConVO> volist, HttpServletResponse response) {
		DdsEdSCon ddsEdSCon = new DdsEdSCon();
		ServiceResp serviceResp = new ServiceResp();
		if (null != volist && volist.size() > 0) {
			for( int i = 0 ; i < volist.size() ; i++){
				DdsEdSConVO ddsEdSConVO = volist.get(i);
				ddsEdSCon = BeanMapper.map(ddsEdSConVO, ddsEdSCon.getClass());
				serviceResp = ddsEdSConService.save(ddsEdSCon);
			}
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdSConVO ddsEdSConVO, HttpServletResponse response) {
		DdsEdSCon ddsEdSCon = new DdsEdSCon();
		if (null != ddsEdSConVO) {
			ddsEdSCon = BeanMapper.map(ddsEdSConVO, ddsEdSCon.getClass());
		}
		ServiceResp serviceResp = ddsEdSConService.update(ddsEdSCon);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdSConVO ddsEdSConVO, HttpServletResponse response) {
		DdsEdSCon ddsEdSCon = new DdsEdSCon();
		if (null != ddsEdSConVO) {
			ddsEdSCon = BeanMapper.map(ddsEdSConVO, ddsEdSCon.getClass());
		}
		ServiceResp serviceResp = ddsEdSConService.remove(ddsEdSCon);
		return renderString(response,serviceResp);
	}
}
