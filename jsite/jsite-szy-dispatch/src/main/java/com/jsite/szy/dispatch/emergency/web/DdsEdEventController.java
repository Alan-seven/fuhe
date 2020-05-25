package com.jsite.szy.dispatch.emergency.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.emergency.po.DdsEdBound;
import com.jsite.busi.szy.emergency.po.DdsEdEva;
import com.jsite.busi.szy.emergency.po.DdsEdEvent;
import com.jsite.busi.szy.emergency.po.DdsEdGis;
import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.emergency.po.DdsEdRes;
import com.jsite.busi.szy.emergency.po.DdsEdRsv;
import com.jsite.busi.szy.emergency.po.DdsEdSource;
import com.jsite.busi.szy.emergency.po.DdsMRsvr;
import com.jsite.busi.szy.emergency.service.DdsEdBoundService;
import com.jsite.busi.szy.emergency.service.DdsEdEvaService;
import com.jsite.busi.szy.emergency.service.DdsEdEventService;
import com.jsite.busi.szy.emergency.service.DdsEdGisService;
import com.jsite.busi.szy.emergency.service.DdsEdPService;
import com.jsite.busi.szy.emergency.service.DdsEdResService;
import com.jsite.busi.szy.emergency.service.DdsEdRsvService;
import com.jsite.busi.szy.emergency.service.DdsEdSourceService;
import com.jsite.busi.szy.emergency.service.DdsMRsvrService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.IdGen;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.common.BoxSelection;
import com.jsite.szy.dispatch.emergency.vo.DdsEdEventVO;

/**
 * 应急事件信息表Controller
 * @author hjx
 * @version 2017-06-07
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdEvent")
public class DdsEdEventController extends BaseController {

	@Autowired
	private DdsEdEventService ddsEdEventService;
	
	@Autowired
	private DdsEdSourceService ddsEdSourceService;
	
	@Autowired
	private DdsEdPService ddsEdPService;
	
	@Autowired
	private DdsEdBoundService ddsEdBoundService;
	
	@Autowired
	private DdsEdRsvService ddsEdRsvService;
	
	@Autowired
	private DdsEdResService ddsEdResService;
	
	@Autowired
	private DdsMRsvrService ddsMRsvrService;
	
	@Autowired
	private DdsEdEvaService ddsEdEvaService;
	
	@Autowired
	private DdsEdGisService ddsEdGisService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String evenCd, HttpServletResponse response) {
		DdsEdEventVO ddsEdEventVO = new DdsEdEventVO();
		if (StringUtils.isNotBlank(evenCd)){
			DdsEdEvent ddsEdEvent = ddsEdEventService.get(evenCd);
			if (null != ddsEdEvent) {
				ddsEdEventVO = BeanMapper.map(ddsEdEvent, ddsEdEventVO.getClass());
			}
		}
		return renderString(response, ddsEdEventVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdEventVO ddsEdEventVO, HttpServletResponse response) {
		DdsEdEvent ddsEdEvent = new DdsEdEvent();
		if (null != ddsEdEventVO) {
			ddsEdEvent = BeanMapper.map(ddsEdEventVO, ddsEdEvent.getClass());
		}
		//Page<DdsEdEvent> pg = new Page<DdsEdEvent>(ddsEdEventVO.getPage(),ddsEdEventVO.getLimit());
		Page<DdsEdEvent> pg = new Page<DdsEdEvent>(ddsEdEventVO.getPageNo(),ddsEdEventVO.getPageSize());
		pg.setOrderBy(" a.pub_dt desc ");
		Page<DdsEdEvent> page = ddsEdEventService.getPage(pg, ddsEdEvent); 
		return  renderString(response, page);
	}

	@ResponseBody
    @RequestMapping(value = {"listAll", ""})
    public String listAll(DdsEdEventVO ddsEdEventVO, HttpServletResponse response) {
        DdsEdEvent ddsEdEvent = new DdsEdEvent();
        if (null != ddsEdEventVO) {
            ddsEdEvent = BeanMapper.map(ddsEdEventVO, ddsEdEvent.getClass());
        }
        List<DdsEdEvent> list = ddsEdEventService.list(ddsEdEvent);
        List<BoxSelection> bs = new ArrayList<>();
        for(int i = 0 ; i < list.size() ; i ++){
            BoxSelection box = new BoxSelection();
            box.setLabel(list.get(i).getEvenNm());
            box.setValue(list.get(i).getEvenCd());
            bs.add(box);
        }
        
        return  renderString(response, bs);
    }
	 
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdEventVO ddsEdEventVO, HttpServletRequest request,HttpServletResponse response) {
		ddsEdEventVO.setEvenCd(IdGen.randomBase62(8));
		DdsEdEvent ddsEdEvent = new DdsEdEvent();
		if (null != ddsEdEventVO) {
			ddsEdEvent = BeanMapper.map(ddsEdEventVO, ddsEdEvent.getClass());
		}
		List<DdsEdEvent> list = ddsEdEventService.findByEvenNm(ddsEdEvent);
		ServiceResp serviceResp = new ServiceResp();
		if(null!=list && list.size() > 0){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("事件名称已存在");
		}else{
			serviceResp = ddsEdEventService.save(ddsEdEvent);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdEventVO ddsEdEventVO, HttpServletResponse response) {
		DdsEdEvent ddsEdEvent = new DdsEdEvent();
		if (null != ddsEdEventVO) {
			ddsEdEvent = BeanMapper.map(ddsEdEventVO, ddsEdEvent.getClass());
		}
		ServiceResp serviceResp = ddsEdEventService.update(ddsEdEvent);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdEventVO ddsEdEventVO, HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		DdsEdEvent ddsEdEvent = new DdsEdEvent();
		if (null != ddsEdEventVO) {
			ddsEdEvent = BeanMapper.map(ddsEdEventVO, ddsEdEvent.getClass());
		}
		
		DdsEdP ddsEdP = new DdsEdP();
		ddsEdP.setEvenCd(ddsEdEventVO.getEvenCd());
		List<DdsEdP> edplist = ddsEdPService.list(ddsEdP);
		//删除应急事件跟方案有关联的数据
		for(DdsEdP entity : edplist){
			//删除调度结果
			DdsEdRes ddsEdRes = new DdsEdRes();
			ddsEdRes.setProCd(entity.getProCd());
			serviceResp = ddsEdResService.removeAll(ddsEdRes);
			
			//删除调度结果GIS
			DdsEdGis ddsEdGis = new DdsEdGis();
			ddsEdGis.setProCd(entity.getProCd());
			serviceResp = ddsEdGisService.removeAll(ddsEdGis);
			
			//删除调度结果评价数据
			DdsEdEva ddsEdEva = new DdsEdEva();
			ddsEdEva.setProCd(entity.getProCd());
			serviceResp = ddsEdEvaService.remove(ddsEdEva);
			
			//删除水库数据
			DdsEdRsv ddsEdRsv = new DdsEdRsv();
			ddsEdRsv.setProCd(entity.getProCd());
			serviceResp = ddsEdRsvService.removeAll(ddsEdRsv);
			
			//删除水库配置数据
			DdsMRsvr ddsMRsvr = new DdsMRsvr();
			ddsMRsvr.setProCd(entity.getProCd());
			serviceResp = ddsMRsvrService.removeAll(ddsMRsvr);
			
			//删除河段边界监测数据
			DdsEdBound ddsEdBound = new DdsEdBound();
			ddsEdBound.setProCd(entity.getProCd());
			serviceResp = ddsEdBoundService.removeAll(ddsEdBound);
			
		}
		//删除应急事件对应的溯源信息
		DdsEdSource ddsEdSource = new DdsEdSource();
		ddsEdSource.setEvenCd(ddsEdEventVO.getEvenCd());
		ddsEdSourceService.remove(ddsEdSource);
		//删除应急事件
		serviceResp = ddsEdEventService.remove(ddsEdEvent);
		logger.warn("删除应急事件信息：应急事件ID为："+ddsEdEvent.getEvenCd());
		return renderString(response,serviceResp);
	}

}