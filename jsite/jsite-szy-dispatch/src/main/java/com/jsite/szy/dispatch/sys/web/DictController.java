package com.jsite.szy.dispatch.sys.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jsite.core.config.Global;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.dao.sys.po.Dict;
import com.jsite.busi.szy.sys.service.DictService;
import com.jsite.szy.dispatch.sys.vo.DictVO;

@Controller
@RequestMapping(value = "${adminPath}/szy/sys/dict")
public class DictController extends BaseController{

	@Autowired
	private DictService dictService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id,HttpServletResponse response) {
		DictVO dictVO = new DictVO();
		if (StringUtils.isNotBlank(id)){
			Dict dict = dictService.get(id);
			if (null != dict) {
				dictVO = BeanMapper.map(dict, dictVO.getClass());
			}
		}
		return renderString(response, dictVO);
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(DictVO dictVO, HttpServletRequest request, HttpServletResponse response) {
		List<String> typeList = dictService.findTypeList();
		Dict dict = new Dict();
		if(null!=dictVO){
			dict = BeanMapper.map(dictVO, dict.getClass());
		}
        Page<Dict> page = dictService.getPage(new Page<Dict>(dictVO.getPageNo(),dictVO.getPageSize()), dict); 
        Map map =new HashMap();
        map.put("typeList", typeList);
        map.put("page", page);
		return renderString(response,map);
	}

	@RequestMapping(value = "form")
	public String form(Dict dict, Model model) {
		model.addAttribute("dict", dict);
		return "modules/sys/dictForm";
	}

	@RequestMapping(value = "save")//@Valid 
	public String save(Dict dict, RedirectAttributes redirectAttributes,HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		if(Global.isDemoMode()){
			/*addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/dict/?repage&type="+dict.getType();*/
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("演示模式，不允许操作！");
			return renderString(response,serviceResp);
		}
		/*if (!beanValidator(model, dict)){
			return form(dict, model);
		}*/
		serviceResp = dictService.save(dict);
		/*addMessage(redirectAttributes, "保存字典'" + dict.getLabel() + "'成功");
		return "redirect:" + adminPath + "/sys/dict/?repage&type="+dict.getType();*/
		return renderString(response,serviceResp);
	}
	
	@RequestMapping(value = "delete")
	public String delete(Dict dict, RedirectAttributes redirectAttributes,HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		if(Global.isDemoMode()){
			/*addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/dict/?repage";*/
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("演示模式，不允许操作！");
			return renderString(response,serviceResp);
		}
		dict = dictService.get(dict);
		serviceResp = dictService.delete(dict);
		/*addMessage(redirectAttributes, "删除字典成功");
		return "redirect:" + adminPath + "/sys/dict/?repage&type="+dict.getType();*/
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "treeData")
	public String treeData(@RequestParam(required=false) String type, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		Dict dict = new Dict();
		dict.setType(type);
		List<Dict> list = dictService.list(dict);
		for (int i=0; i<list.size(); i++){
			Dict e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParentId());
			map.put("name", StringUtils.replace(e.getLabel(), " ", ""));
			mapList.add(map);
		}
		return renderString(response,mapList);
	}
	
	@ResponseBody
	@RequestMapping(value = "listData")
	public String listData(@RequestParam(required=false) String type,HttpServletResponse response) {
		Dict dict = new Dict();
		dict.setType(type);
		List<Dict> dlist = dictService.list(dict);
		return renderString(response, dlist);
	}	
	
}
