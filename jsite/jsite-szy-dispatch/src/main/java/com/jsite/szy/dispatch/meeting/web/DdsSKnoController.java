package com.jsite.szy.dispatch.meeting.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.meeting.po.DdsSKno;
import com.jsite.busi.szy.meeting.service.DdsSKnoService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.IdGen;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.meeting.vo.DdsSKnoVO;

/**
 * 会商知识库Controller
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/meeting/ddsSKno")
public class DdsSKnoController extends BaseController {

	@Autowired
	private DdsSKnoService ddsSKnoService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsSKnoVO ddsSKnoVO = new DdsSKnoVO();
		if (StringUtils.isNotBlank(id)){
			DdsSKno ddsSKno = ddsSKnoService.get(id);
			if (null != ddsSKno) {
				ddsSKnoVO = BeanMapper.map(ddsSKno, ddsSKnoVO.getClass());
			}
		}
		return renderString(response, ddsSKnoVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsSKnoVO ddsSKnoVO, HttpServletResponse response) {
		DdsSKno ddsSKno = new DdsSKno();
		if (null != ddsSKnoVO) {
			ddsSKno = BeanMapper.map(ddsSKnoVO, ddsSKno.getClass());
		}
		Page<DdsSKno> page = ddsSKnoService.getPage(new Page<DdsSKno>(), ddsSKno); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsSKnoVO ddsSKnoVO, HttpServletResponse response) {
		ddsSKnoVO.setKnoId(IdGen.randomBase62(32));
		DdsSKno ddsSKno = new DdsSKno();
		ServiceResp serviceResp = new ServiceResp();
		if (null != ddsSKnoVO) {
			ddsSKno = BeanMapper.map(ddsSKnoVO, ddsSKno.getClass());
		}
		if(ddsSKnoService.findByTitle(ddsSKno)!=null){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("标题已存在");
		}else{
			 serviceResp = ddsSKnoService.save(ddsSKno);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsSKnoVO ddsSKnoVO, HttpServletResponse response) {
		DdsSKno ddsSKno = new DdsSKno();
		if (null != ddsSKnoVO) {
			ddsSKno = BeanMapper.map(ddsSKnoVO, ddsSKno.getClass());
		}
		ServiceResp serviceResp = ddsSKnoService.update(ddsSKno);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsSKnoVO ddsSKnoVO, HttpServletResponse response) {
		DdsSKno ddsSKno = new DdsSKno();
		if (null != ddsSKnoVO) {
			ddsSKno = BeanMapper.map(ddsSKnoVO, ddsSKno.getClass());
		}
		ServiceResp serviceResp = ddsSKnoService.remove(ddsSKno);
		return renderString(response,serviceResp);
	}

}