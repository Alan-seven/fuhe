package com.jsite.szy.dispatch.emergency.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.emergency.po.DdsEdRes;
import com.jsite.busi.szy.emergency.service.DdsEdPService;
import com.jsite.busi.szy.emergency.service.DdsEdResService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.mconfig.ModelData;
import com.jsite.szy.dispatch.emergency.vo.DdsEdResVO;

/**
 * 应急调度方案结果表Controller
 * @author hjx
 * @version 2017-06-08
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdRes")
public class DdsEdResController extends BaseController {

	@Autowired
	private DdsEdResService ddsEdResService;
	
	@Autowired
	private DdsEdPService ddsEdPService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String proCd, HttpServletResponse response) {
		DdsEdRes ddsEdResVO = new DdsEdRes();
		if (StringUtils.isNotBlank(proCd)){
			DdsEdRes ddsEdRes = ddsEdResService.get(proCd);
			if (null != ddsEdRes) {
				BeanMapper.map(ddsEdRes, ddsEdResVO.getClass());
			}
		}
		return renderString(response, ddsEdResVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdResVO ddsEdResVO, HttpServletResponse response) {
		DdsEdRes ddsEdRes = new DdsEdRes();
		if (null != ddsEdResVO) {
			ddsEdRes = BeanMapper.map(ddsEdResVO, ddsEdRes.getClass());
		}
		//Page<DdsEdRes> page = ddsEdResService.getPage(new Page<DdsEdRes>(ddsEdResVO.getPage(),ddsEdResVO.getLimit()), ddsEdRes); 
		Page<DdsEdRes> page = ddsEdResService.getPage(new Page<DdsEdRes>(ddsEdResVO.getPageNo(),ddsEdResVO.getPageSize()), ddsEdRes); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdResVO ddsEdResVO, HttpServletResponse response) {
		DdsEdRes ddsEdRes = new DdsEdRes();
		if (null != ddsEdResVO) {
			ddsEdRes = BeanMapper.map(ddsEdResVO, ddsEdRes.getClass());
		}
		ServiceResp serviceResp = ddsEdResService.save(ddsEdRes);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdResVO ddsEdResVO, HttpServletResponse response) {
		DdsEdRes ddsEdRes = new DdsEdRes();
		if (null != ddsEdResVO) {
			ddsEdRes = BeanMapper.map(ddsEdResVO, ddsEdRes.getClass());
		}
		ServiceResp serviceResp = ddsEdResService.update(ddsEdRes);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdResVO ddsEdResVO, HttpServletResponse response) {
		DdsEdRes ddsEdRes = new DdsEdRes();
		if (null != ddsEdResVO) {
			ddsEdRes = BeanMapper.map(ddsEdResVO, ddsEdRes.getClass());
		}
		ServiceResp serviceResp = ddsEdResService.remove(ddsEdRes);
		return renderString(response,serviceResp);
	}

	@ResponseBody
	@RequestMapping(value = {"listBySecId", ""})
	public String listBySecId(DdsEdResVO ddsEdResVO, HttpServletResponse response) {
		DdsEdRes ddsEdRes = new DdsEdRes();
		if (null != ddsEdResVO) {
			ddsEdRes = BeanMapper.map(ddsEdResVO, ddsEdRes.getClass());
		}
		DdsEdP ddsEdP = ddsEdPService.get(ddsEdResVO.getProCd());
		if(null!=ddsEdP && null!=ddsEdP.getBgDt()){
			ddsEdRes.setStartTime(DateUtils.formatDateTime(ddsEdP.getBgDt()));
		}
		if(null!=ddsEdP && null!=ddsEdP.getEdDt()){
			ddsEdRes.setEndTime(DateUtils.formatDateTime(ddsEdP.getEdDt()));
		}
		List<DdsEdRes>  reslist = ddsEdResService.list(ddsEdRes);
		List<ModelData> datalist = new ArrayList();
		//循环树第一层
		List<DdsEdRes> planRes = new ArrayList();
		List<DdsEdRes> realRes = new ArrayList();
		for(int i = 0 ; i < reslist.size(); i++){
			if("0".equals(reslist.get(i).getqType())){
				planRes.add(reslist.get(i));
			}else{
				realRes.add(reslist.get(i));
			}
		}
		for(int i = 0 ; i < planRes.size(); i++){
			DdsEdRes res = planRes.get(i);
			ModelData data = new ModelData();
			data.setSecId(res.getSecId());
			data.setTm(res.getTm());
			if("Z".equals(ddsEdResVO.getqType())){
				data.setPlanValue(res.getZ());
			}else if("Q".equals(ddsEdResVO.getqType())){
				data.setPlanValue(res.getQ());
			}else if("INQ".equals(ddsEdResVO.getqType())){
				data.setPlanValue(res.getInq());
			}else if("OTQ".equals(ddsEdResVO.getqType())){
				data.setPlanValue(res.getOtq());
			}else if("BOPL".equals(ddsEdResVO.getqType())){
				data.setPlanValue(res.getBoPl());
			}
			datalist.add(data);
		}
		for(int i = 0 ; i < realRes.size(); i++){
			DdsEdRes res = realRes.get(i);
			for(int j = 0 ; j < datalist.size();j++){
				ModelData data = datalist.get(j);
				
				if(data.getSecId().equals(res.getSecId())&& (data.getTm().getTime())==(res.getTm().getTime())){
					if("Z".equals(ddsEdResVO.getqType())){
						data.setRealValue(res.getZ());
					}else if("Q".equals(ddsEdResVO.getqType())){
						data.setRealValue(res.getQ());
					}else if("INQ".equals(ddsEdResVO.getqType())){
						data.setRealValue(res.getInq());
					}else if("OTQ".equals(ddsEdResVO.getqType())){
						data.setRealValue(res.getOtq());
					}else if("BOPL".equals(ddsEdResVO.getqType())){
						data.setRealValue(res.getBoPl());
					}
					datalist.set(j, data);
					break;
				}
			}
		}
		return  renderString(response, datalist);
	}
	
}