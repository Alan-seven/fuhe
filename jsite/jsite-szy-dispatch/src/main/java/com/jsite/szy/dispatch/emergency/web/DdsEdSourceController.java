package com.jsite.szy.dispatch.emergency.web;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.jsite.busi.szy.emergency.po.DdsEdEvent;
import com.jsite.busi.szy.emergency.po.DdsEdSource;
import com.jsite.busi.szy.emergency.po.DdsEdWqData;
import com.jsite.busi.szy.emergency.po.DdsMConsec;
import com.jsite.busi.szy.emergency.service.DdsEdEventService;
import com.jsite.busi.szy.emergency.service.DdsEdSourceService;
import com.jsite.busi.szy.emergency.service.DdsEdWqDataService;
import com.jsite.busi.szy.emergency.service.DdsMConsecService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.model.TraceSource;
import com.jsite.szy.dispatch.emergency.vo.DdsEdSourceVO;
import com.jsite.szy.dispatch.emergency.vo.DdsMRiverVO;

/**
 * 应急事件溯源信息表Controller
 * @author hjx
 * @version 2017-06-07
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdSource")
public class DdsEdSourceController extends BaseController {

	@Autowired
	private DdsEdSourceService ddsEdSourceService;
	
	@Autowired
	private DdsEdEventService ddsEdEventService;
	
	@Autowired
	private DdsEdWqDataService ddsEdWqDataService;
	
	@Autowired
	private DdsMConsecService ddsMConSecService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String evenCd, HttpServletResponse response) {
		DdsEdSourceVO ddsEdSourceVO = new DdsEdSourceVO();
		if (StringUtils.isNotBlank(evenCd)){
			DdsEdSource ddsEdSource = ddsEdSourceService.get(evenCd);
			if (null != ddsEdSource) {
				ddsEdSourceVO = BeanMapper.map(ddsEdSource, ddsEdSourceVO.getClass());
			}
		}
		return renderString(response, ddsEdSourceVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdSourceVO ddsEdSourceVO, HttpServletResponse response) {
		DdsEdSource ddsEdSource = new DdsEdSource();
		if (null != ddsEdSourceVO) {
			ddsEdSource = BeanMapper.map(ddsEdSourceVO, ddsEdSource.getClass());
		}
		Page<DdsEdSource> page = ddsEdSourceService.getPage(new Page<DdsEdSource>(), ddsEdSource); 
		return  renderString(response, page);
	}

	/**
	 * 追踪溯源--选择应急事件
	 * @param ddsMRiverVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"listinit", ""})
	public String listInit(DdsEdSourceVO ddsEdSourceVO,HttpServletResponse response){
		Map<String,Object> map = Maps.newHashMap();
		//获取应急事件
		DdsEdEvent ddsEdEvent = new DdsEdEvent();
		ddsEdEvent.setRiver(ddsEdSourceVO.getRiver());
		List<DdsEdEvent> listEvent = ddsEdEventService.list(ddsEdEvent);
		map.put("listevent", listEvent);
		Map<String,Object> mapSource = Maps.newHashMap();
		//得到所有事件对应的溯源信息
		for(DdsEdEvent event : listEvent){
			DdsEdSource ddsEdSource = ddsEdSourceService.get(event.getEvenCd());
			if(null!=ddsEdSource){
				mapSource.put(event.getEvenCd(), ddsEdSource);
			}
		}
		map.put("resource", mapSource);
		return  renderString(response, map);
	}
	
	/**
	 * 溯源结果页面点击保存
	 * @param ddsEdSourceVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdSourceVO ddsEdSourceVO, HttpServletResponse response) {
		DdsEdSource ddsEdSource = new DdsEdSource();
		if (null != ddsEdSourceVO) {
			ddsEdSource = BeanMapper.map(ddsEdSourceVO, ddsEdSource.getClass());
		}
		ServiceResp serviceResp =  new ServiceResp();
		DdsEdSource entity = ddsEdSourceService.get(ddsEdSource);
		if(null!=entity){
			ddsEdSource.setBgConc(entity.getBgConc());
			serviceResp = ddsEdSourceService.update(ddsEdSource);
		}else{
			Double bgConc = 1d;
			if(ddsEdSourceVO.getDaType()==3){//3==COD
				bgConc=8d;
		    }else if(ddsEdSourceVO.getDaType()==4){//4==NH3N
		    	bgConc=0.41d;
		    }else if(ddsEdSourceVO.getDaType()==5){//5==CODMN
		    	bgConc=2.2d;
		    }else if(ddsEdSourceVO.getDaType()==6){//6==TP
		    	bgConc=0.042d;
		    }
			ddsEdSource.setBgConc(bgConc);
			serviceResp = ddsEdSourceService.save(ddsEdSource);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdSourceVO ddsEdSourceVO, HttpServletResponse response) {
		DdsEdSource ddsEdSource = new DdsEdSource();
		if (null != ddsEdSourceVO) {
			ddsEdSource = BeanMapper.map(ddsEdSourceVO, ddsEdSource.getClass());
		}
		ServiceResp serviceResp = ddsEdSourceService.update(ddsEdSource);
		return renderString(response,serviceResp);
	}
	
	/**
	 * 修改物质初始浓度
	 * @param ddsEdSourceVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateBgConc")
	public String updateBgConc(DdsEdSourceVO ddsEdSourceVO, HttpServletResponse response) {
		DdsEdSource ddsEdSource = new DdsEdSource();
		if (null != ddsEdSourceVO) {
			ddsEdSource = BeanMapper.map(ddsEdSourceVO, ddsEdSource.getClass());
		}
		DdsEdSource source = ddsEdSourceService.get(ddsEdSourceVO.getEvenCd());
		if(source != null && ddsEdSourceVO.getBgConc() != null){
			source.setBgConc(ddsEdSourceVO.getBgConc());
		}
		ServiceResp serviceResp = ddsEdSourceService.update(source);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdSourceVO ddsEdSourceVO, HttpServletResponse response) {
		DdsEdSource ddsEdSource = new DdsEdSource();
		if (null != ddsEdSourceVO) {
			ddsEdSource = BeanMapper.map(ddsEdSourceVO, ddsEdSource.getClass());
		}
		ServiceResp serviceResp = ddsEdSourceService.remove(ddsEdSource);
		logger.warn("删除溯源信息：溯源ID为："+ddsEdSource.getEvenCd());
		return renderString(response,serviceResp);
	}

	/**
	 * 追踪溯源计算结果
	 * @param ddsEdSourceVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getresult")
	public String getResult(DdsEdSourceVO ddsEdSourceVO, HttpServletResponse response){
		ServiceResp serviceResp = new ServiceResp();
		TraceSource traceSource = new TraceSource();
		if(StringUtils.isBlank(ddsEdSourceVO.getTscale())){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG+",时间尺度不可为空！");
			logger.warn("时间尺度不可为空！");
			return renderString(response, serviceResp);
		}
		traceSource.setTimelen(Integer.valueOf(ddsEdSourceVO.getTscale())*3600);//小时转换为s
		DdsEdWqData entity = new DdsEdWqData();
		entity.setDownsec(ddsEdSourceVO.getDownsec());
		entity.setEvenCd(ddsEdSourceVO.getEvenCd());
		List<DdsEdWqData> wqlist = ddsEdWqDataService.list(entity);
		double cc[] = null;
		if(null==wqlist){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG+",应急事件水质监测数据不可为空！");
			logger.warn("应急事件水质监测数据不可为空！");
			return renderString(response, serviceResp);
		}else{
			cc = new double[wqlist.size()];
			for(int i = 0 ; i < wqlist.size(); i++){
				cc[i]= wqlist.get(i).getC();
			}
		}
		long ss = System.currentTimeMillis();
		//获取上端面
		DdsMConsec ddsMConsec = ddsMConSecService.get(ddsEdSourceVO.getUpsec());
		double upLength = ddsMConsec.getLenup();
		double length = ddsEdSourceVO.getLenUp()-upLength;
		//缺少浓度
		traceSource.setC(cc);//浓度序列设置
		traceSource.setXmax(length*1000);//监测断面距上边界断面距离(m) km-->m
		traceSource.setU(ddsEdSourceVO.getQ());//平均流速(m/s)
		traceSource.setDx(6.4);//扩散系数(m2/min)
		traceSource.setK(0.001);//衰减系数(/min)
		traceSource.dea();
		long tt = System.currentTimeMillis();
		String progress = traceSource.getProgress();

		//结果输出
		double result[][];
		
		//显示两位小数
		DecimalFormat decimalFormat=new DecimalFormat("0.00");
		result=traceSource.getOutresult();
		
		double st  =traceSource.getStartTime(); 
		Calendar cal = Calendar.getInstance();
		if(null!=ddsEdSourceVO.getBegt()){
			cal.setTime(ddsEdSourceVO.getBegt());
			cal.set(Calendar.SECOND,(new   Double(st)).intValue());
		}else{
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG+",开始时间数据不可为空！");
			logger.warn("开始时间数据不可为空！");
			return renderString(response, serviceResp);
		}
		String startTime = DateUtils.formatDateTime(cal.getTime());
		//发生时间
		ddsEdSourceVO.setTm(cal.getTime());
		//距断面距离
		BigDecimal bigd  =   new   BigDecimal((traceSource.getDistance())/1000);  
		double lenup = bigd.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		ddsEdSourceVO.setLenUp(lenup);//m-->km
		//污染持续时间区间s
		BigDecimal bd  =   new   BigDecimal((traceSource.getLastTime())/3600);  
		double dur = bd.setScale(0,   BigDecimal.ROUND_HALF_UP).doubleValue();
		ddsEdSourceVO.setDur(new Double(dur).intValue());//s---->h
		//污染物质量区间(kg)
		BigDecimal bdm  =   new   BigDecimal(traceSource.getM());  
		double da = bdm.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
		ddsEdSourceVO.setDa(da);
		Map<String,Object> map = Maps.newHashMap();
		map.put("code", RespCode.SERVICE_RESP_ERROR_CODE_1);
		map.put("result",ddsEdSourceVO);
		return renderString(response, map);
	}
	
}