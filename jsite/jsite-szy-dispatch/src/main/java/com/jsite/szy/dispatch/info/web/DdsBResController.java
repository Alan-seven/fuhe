package com.jsite.szy.dispatch.info.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsBRes;
import com.jsite.busi.szy.info.service.DdsBResService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsBResVO;

/**
 * 水库基本信息Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsBRes")
public class DdsBResController extends BaseController {

	@Autowired
	private DdsBResService ddsBResService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsBResVO ddsBResVO = new DdsBResVO();
		if (StringUtils.isNotBlank(id)){
			DdsBRes ddsBRes = ddsBResService.get(id);
			if (null != ddsBRes) {
				BeanMapper.map(ddsBRes, ddsBResVO.getClass());
			}
		}
		return renderString(response, ddsBResVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsBResVO ddsBResVO, HttpServletResponse response) {
		DdsBRes ddsBRes = new DdsBRes();
		if (null != ddsBResVO) {
			ddsBRes = BeanMapper.map(ddsBResVO, ddsBRes.getClass());
		}
		Page<DdsBRes> page = ddsBResService.getPage(new Page<DdsBRes>(ddsBResVO.getPageNo(),ddsBResVO.getPageSize()), ddsBRes); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsBResVO ddsBResVO, HttpServletResponse response) {
		DdsBRes ddsBRes = new DdsBRes();
		if (null != ddsBResVO) {
			BeanMapper.map(ddsBResVO, ddsBRes.getClass());
		}
		ServiceResp serviceResp = ddsBResService.save(ddsBRes);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsBResVO ddsBResVO, HttpServletResponse response) {
		DdsBRes ddsBRes = new DdsBRes();
		if (null != ddsBResVO) {
			BeanMapper.map(ddsBResVO, ddsBRes.getClass());
		}
		ServiceResp serviceResp = ddsBResService.update(ddsBRes);
		return renderString(response,serviceResp);  
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsBResVO ddsBResVO, HttpServletResponse response) {
		DdsBRes ddsBRes = new DdsBRes();
		if (null != ddsBResVO) {
			BeanMapper.map(ddsBResVO, ddsBRes.getClass());
		}
		ServiceResp serviceResp = ddsBResService.remove(ddsBRes);
		return renderString(response,serviceResp);
	}

	//查询水位库容曲线
	@ResponseBody
	@RequestMapping(value = "findByZV")
	public String findByZV(DdsBResVO ddsBResVO, HttpServletResponse response){
		DdsBRes ddsBRes = new DdsBRes();
		if (null != ddsBResVO) {
			ddsBRes = BeanMapper.map(ddsBResVO, ddsBRes.getClass());
		}
		List<DdsBRes> list = ddsBResService.findByZV(ddsBRes);
		return  renderString(response, list);
	}
	
	//查询水位库容曲线
		@ResponseBody
		@RequestMapping(value = "findByZQ")
		public String findByZQ(DdsBResVO ddsBResVO, HttpServletResponse response){
			DdsBRes ddsBRes = new DdsBRes();
			if (null != ddsBResVO) {
				ddsBRes = BeanMapper.map(ddsBResVO, ddsBRes.getClass());
			}
			List<DdsBRes> list = ddsBResService.findByZQ(ddsBRes);
			return  renderString(response, list);
		}
}