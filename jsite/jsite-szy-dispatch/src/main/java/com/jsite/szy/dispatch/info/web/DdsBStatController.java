package com.jsite.szy.dispatch.info.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.info.po.DdsBStat;
import com.jsite.busi.szy.info.service.DdsBStatService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.info.vo.DdsBStatVO;

/**
 * 水文测站基本信息Controller
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/info/ddsBStat")
public class DdsBStatController extends BaseController {
	
	@Autowired
	private DdsBStatService ddsBStatService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsBStatVO ddsBStatVO = new DdsBStatVO();
		if (StringUtils.isNotBlank(id)){
			DdsBStat ddsBStat = ddsBStatService.get(id);
			if (null != ddsBStat) {
				BeanMapper.map(ddsBStat, ddsBStatVO.getClass());
			}
		}
		return renderString(response, ddsBStatVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsBStatVO ddsBStatVO, HttpServletResponse response) {
		DdsBStat ddsBStat = new DdsBStat();
		if (null != ddsBStatVO) {
			ddsBStat = BeanMapper.map(ddsBStatVO, ddsBStat.getClass());
		}
		Page<DdsBStat> page = new Page<DdsBStat>();
		if(null!=ddsBStatVO.getStTp()){
			page = ddsBStatService.getPage(new Page<DdsBStat>(), ddsBStat); 
			List<DdsBStat> list = new ArrayList<DdsBStat>();
			for(DdsBStat entity : page.getList()){
				//雨量站
				if("PP".equals(ddsBStatVO.getStTp()) && "PP".equals(entity.getStTp())){
					list.add(entity);
				}else if("WQ".equals(ddsBStatVO.getStTp()) && "WQ".equals(entity.getStTp()) ){//水质站
					list.add(entity);
				}else if("ZQ".equals(ddsBStatVO.getStTp())){//水文站
					if("ZQ".equals(entity.getStTp()) || "ZZ".equals(entity.getStTp()) || "ZR".equals(entity.getStTp())){
						list.add(entity);
					}
				}
			}
			page.setCount(list.size());
			page.setList(list);
			return  renderString(response, page);
		}else{
			page = ddsBStatService.getPage(new Page<DdsBStat>(ddsBStatVO.getPageNo(),ddsBStatVO.getPageSize()), ddsBStat); 
		}
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsBStatVO ddsBStatVO, HttpServletRequest request,HttpServletResponse response) {
		DdsBStat ddsBStat = new DdsBStat();
		if (null != ddsBStatVO) {
			BeanMapper.map(ddsBStatVO, ddsBStat.getClass());
		}
		ServiceResp serviceResp = ddsBStatService.save(ddsBStat);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsBStatVO ddsBStatVO, HttpServletResponse response) {
		DdsBStat ddsBStat = new DdsBStat();
		if (null != ddsBStatVO) {
			BeanMapper.map(ddsBStatVO, ddsBStat.getClass());
		}
		ServiceResp serviceResp = ddsBStatService.update(ddsBStat);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsBStatVO ddsBStatVO, HttpServletResponse response) {
		DdsBStat ddsBStat = new DdsBStat();
		if (null != ddsBStatVO) {
			BeanMapper.map(ddsBStatVO, ddsBStat.getClass());
		}
		ServiceResp serviceResp = ddsBStatService.remove(ddsBStat);
		return renderString(response,serviceResp);
	}

}