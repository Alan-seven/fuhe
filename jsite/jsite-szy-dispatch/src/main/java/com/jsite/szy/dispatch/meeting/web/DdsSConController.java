package com.jsite.szy.dispatch.meeting.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.busi.szy.dispatch.service.DdsRdPService;
import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.meeting.po.DdsSCon;
import com.jsite.busi.szy.meeting.po.DdsSFactorw;
import com.jsite.busi.szy.meeting.po.DdsSPro;
import com.jsite.busi.szy.meeting.service.DdsSConService;
import com.jsite.busi.szy.meeting.service.DdsSFactorwService;
import com.jsite.busi.szy.meeting.service.DdsSProService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.IdGen;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.meeting.vo.DdsSConVO;

/**
 * 会商信息Controller
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/meeting/ddsSCon")
public class DdsSConController extends BaseController {

	@Autowired
	private DdsSConService ddsSConService;
	
	@Autowired
	private DdsSFactorwService ddsSFactorwService;
	
	@Autowired
	private DdsSProService ddsSProService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String conId, HttpServletResponse response) {
		DdsSConVO ddsSConVO = new DdsSConVO();
		if (StringUtils.isNotBlank(conId)){
			DdsSCon ddsSCon = ddsSConService.get(conId);
			if (null != ddsSCon) {
				ddsSConVO = BeanMapper.map(ddsSCon, ddsSConVO.getClass());
			}
		}
		return renderString(response, ddsSConVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsSConVO ddsSConVO, HttpServletResponse response) {
		DdsSCon ddsSCon = new DdsSCon();
		if (null != ddsSConVO) {
			ddsSCon = BeanMapper.map(ddsSConVO, ddsSCon.getClass());
		}
		Page<DdsSCon> page = ddsSConService.getPage(new Page<DdsSCon>(), ddsSCon); 
		return  renderString(response, page);
	}
	
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsSConVO ddsSConVO, HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		ddsSConVO.setConId(IdGen.uuid());
		DdsSCon ddsSCon = new DdsSCon();
		if (null != ddsSConVO) {
			ddsSCon = BeanMapper.map(ddsSConVO, ddsSCon.getClass());
		}
		if(ddsSConService.findByName(ddsSCon)!=null){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("会商名称已存在");
		}else{
			serviceResp = ddsSConService.save(ddsSCon);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsSConVO ddsSConVO, HttpServletResponse response) {
		DdsSCon ddsSCon = new DdsSCon();
		if (null != ddsSConVO) {
			ddsSCon = BeanMapper.map(ddsSConVO, ddsSCon.getClass());
		}
		DdsSCon entity = ddsSConService.get(ddsSCon);
		if(null!=entity){
			ddsSCon.setProIdDec(entity.getProIdDec());
			ddsSCon.setProIdRec(entity.getProIdRec());
		}
		ServiceResp serviceResp = ddsSConService.update(ddsSCon);
		return renderString(response,serviceResp);
	}
	
	/**
	 * 修改会商推荐方案编号
	 * @param ddsSConVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateProIdRec")
	public String updateProIdRec(DdsSConVO ddsSConVO, HttpServletResponse response) {
		DdsSCon ddsSCon = new DdsSCon();
		if (null != ddsSConVO) {
			ddsSCon = BeanMapper.map(ddsSConVO, ddsSCon.getClass());
		}
		//根据会商ID，获取会商信息
		ddsSCon = ddsSConService.get(ddsSCon);
		//设置会商推荐方案
		ddsSCon.setProIdRec(ddsSConVO.getProIdRec());
		ServiceResp serviceResp = ddsSConService.update(ddsSCon);
		return renderString(response,serviceResp);
	}
	
	/**
	 * 修改会商决策方案编号
	 * @param ddsSConVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateProIdDec")
	public String updateProIdDec(DdsSConVO ddsSConVO, HttpServletResponse response) {
		DdsSCon ddsSCon = new DdsSCon();
		if (null != ddsSConVO) {
			ddsSCon = BeanMapper.map(ddsSConVO, ddsSCon.getClass());
		}
		//根据会商ID，获取会商信息
		ddsSCon = ddsSConService.get(ddsSCon);
		//设置会商推荐方案
		ddsSCon.setProIdDec(ddsSConVO.getProIdDec());
		ServiceResp serviceResp = ddsSConService.update(ddsSCon);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsSConVO ddsSConVO, HttpServletResponse response) {
		ServiceResp serviceResp  = new ServiceResp();
		DdsSCon ddsSCon = new DdsSCon();
		if (null != ddsSConVO) {
			ddsSCon = BeanMapper.map(ddsSConVO, ddsSCon.getClass());
		}
		//删除方案得分
		DdsSPro ddsSPro = new DdsSPro();
		ddsSPro.setConId(ddsSConVO.getConId());
		serviceResp = ddsSProService.remove(ddsSPro);
		//删除会商对应的指标体系
		DdsSFactorw ddsSFactorw = new DdsSFactorw();
		ddsSFactorw.setConId(ddsSConVO.getConId());
		serviceResp = ddsSFactorwService.removeAll(ddsSFactorw);
		//删除会商数据
		serviceResp = ddsSConService.remove(ddsSCon);
		return renderString(response,serviceResp);
	}

}