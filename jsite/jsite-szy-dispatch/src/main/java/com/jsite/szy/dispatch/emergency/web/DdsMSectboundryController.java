package com.jsite.szy.dispatch.emergency.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsMSectboundry;
import com.jsite.busi.szy.emergency.service.DdsMSectboundryService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.vo.DdsMSectboundryVO;

/**
 * 河段模型断面表Controller
 * @author hjx
 * @version 2017-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsMSectboundry")
public class DdsMSectboundryController extends BaseController {

	@Autowired
	private DdsMSectboundryService ddsMSectboundryService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsMSectboundryVO ddsMSectboundryVO = new DdsMSectboundryVO();
		if (StringUtils.isNotBlank(id)){
			DdsMSectboundry ddsMSectboundry = ddsMSectboundryService.get(id);
			if (null != ddsMSectboundry) {
				ddsMSectboundryVO = BeanMapper.map(ddsMSectboundry, ddsMSectboundryVO.getClass());
			}
		}
		return renderString(response, ddsMSectboundryVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsMSectboundryVO ddsMSectboundryVO, HttpServletResponse response) {
		DdsMSectboundry ddsMSectboundry = new DdsMSectboundry();
		if (null != ddsMSectboundryVO) {
			ddsMSectboundry = BeanMapper.map(ddsMSectboundryVO, ddsMSectboundry.getClass());
		}
		Page<DdsMSectboundry> page = ddsMSectboundryService.getPage(new Page<DdsMSectboundry>(), ddsMSectboundry); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsMSectboundryVO ddsMSectboundryVO, HttpServletResponse response) {
		DdsMSectboundry ddsMSectboundry = new DdsMSectboundry();
		if (null != ddsMSectboundryVO) {
			ddsMSectboundry = BeanMapper.map(ddsMSectboundryVO, ddsMSectboundry.getClass());
		}
		ServiceResp serviceResp = ddsMSectboundryService.save(ddsMSectboundry);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsMSectboundryVO ddsMSectboundryVO, HttpServletResponse response) {
		DdsMSectboundry ddsMSectboundry = new DdsMSectboundry();
		if (null != ddsMSectboundryVO) {
			ddsMSectboundry = BeanMapper.map(ddsMSectboundryVO, ddsMSectboundry.getClass());
		}
		ServiceResp serviceResp = ddsMSectboundryService.update(ddsMSectboundry);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsMSectboundryVO ddsMSectboundryVO, HttpServletResponse response) {
		DdsMSectboundry ddsMSectboundry = new DdsMSectboundry();
		if (null != ddsMSectboundryVO) {
			ddsMSectboundry = BeanMapper.map(ddsMSectboundryVO, ddsMSectboundry.getClass());
		}
		ServiceResp serviceResp = ddsMSectboundryService.remove(ddsMSectboundry);
		return renderString(response,serviceResp);
	}

}