package com.jsite.szy.dispatch.emergency.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jsite.busi.szy.emergency.po.DdsEdEvent;
import com.jsite.busi.szy.emergency.po.DdsEdGis;
import com.jsite.busi.szy.emergency.po.DdsEdGisLegend;
import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.emergency.po.DdsEdRes;
import com.jsite.busi.szy.emergency.po.DdsEdWarn;
import com.jsite.busi.szy.emergency.po.DdsMConsec;
import com.jsite.busi.szy.emergency.po.DdsMRsv;
import com.jsite.busi.szy.emergency.service.DdsEdEventService;
import com.jsite.busi.szy.emergency.service.DdsEdGisLegendService;
import com.jsite.busi.szy.emergency.service.DdsEdGisService;
import com.jsite.busi.szy.emergency.service.DdsEdPService;
import com.jsite.busi.szy.emergency.service.DdsEdResService;
import com.jsite.busi.szy.emergency.service.DdsEdWarnService;
import com.jsite.busi.szy.emergency.service.DdsMConsecService;
import com.jsite.busi.szy.emergency.service.DdsMRsvService;
import com.jsite.busi.szy.info.po.DdsBStat;
import com.jsite.busi.szy.info.po.DdsBWqst;
import com.jsite.busi.szy.info.service.DdsBStatService;
import com.jsite.busi.szy.info.service.DdsBWqstService;
import com.jsite.busi.szy.meeting.po.DdsSCon;
import com.jsite.busi.szy.meeting.service.DdsSConService;
import com.jsite.core.config.Global;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.utils.IdGen;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.emergency.mconfig.EDGisData;
import com.jsite.szy.dispatch.emergency.mconfig.ModelConsec;
import com.jsite.szy.dispatch.emergency.mconfig.ModelConsecData;
import com.jsite.szy.dispatch.emergency.mconfig.ModelData;
import com.jsite.szy.dispatch.emergency.mconfig.YJPage;
import com.jsite.szy.dispatch.emergency.vo.DdsEdWarnVO;

/**
 * 预警信息Controller
 * @author hjx
 * @version 2017-10-09
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdWarn")
public class DdsEdWarnController extends BaseController{
	
	@Autowired
	private DdsEdWarnService ddsEdWarnService;
	
	@Autowired
	private DdsEdEventService ddsEdEventService;
	
	@Autowired
	private DdsBStatService ddsBStatService;
	
	@Autowired
	private DdsEdPService ddsEdPService;
	
	@Autowired
	private DdsEdResService ddsEdResService;
	
	@Autowired
	private DdsSConService ddsSConService;
	
	@Autowired
	private DdsBWqstService ddsBWqstService;
	
	@Autowired
	private DdsEdGisService ddsEdGisService;
	
	@Autowired
	private DdsEdGisLegendService ddsEdGisLegendService;
	
	@Autowired
	private DdsMConsecService ddsMConsecService;
	
	@Autowired
	private DdsMRsvService ddsMRsvService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) DdsEdWarnVO ddsEdWarnVO, HttpServletResponse response) {
		DdsEdWarn ddsEdWarn = new DdsEdWarn();
		if (null != ddsEdWarnVO){
			ddsEdWarn = BeanMapper.map(ddsEdWarnVO, ddsEdWarn.getClass());
			ddsEdWarn = ddsEdWarnService.get(ddsEdWarn);
		}
		return renderString(response, ddsEdWarn);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdWarnVO ddsEdWarnVO, HttpServletResponse response) {
		DdsEdWarn ddsEdWarn = new DdsEdWarn();
		if (null != ddsEdWarnVO) {
			ddsEdWarn = BeanMapper.map(ddsEdWarnVO, ddsEdWarn.getClass());
		}
		//Page<DdsEdWarn> page = ddsEdWarnService.getPage(new Page<DdsEdWarn>(ddsEdWarnVO.getPage(),ddsEdWarnVO.getLimit()), ddsEdWarn); 
		Page<DdsEdWarn> page = ddsEdWarnService.getPage(new Page<DdsEdWarn>(ddsEdWarnVO.getPageNo(),ddsEdWarnVO.getPageSize()), ddsEdWarn); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsEdWarnVO ddsEdWarnVO, HttpServletResponse response) {
		ddsEdWarnVO.setEid(IdGen.uuid());
		DdsEdWarn ddsEdWarn = new DdsEdWarn();
		if (null != ddsEdWarnVO) {
			ddsEdWarn = BeanMapper.map(ddsEdWarnVO, ddsEdWarn.getClass());
		}
		ServiceResp serviceResp = ddsEdWarnService.save(ddsEdWarn);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdWarnVO ddsEdWarnVO, HttpServletResponse response) {
		DdsEdWarn ddsEdWarn = new DdsEdWarn();
		if (null != ddsEdWarnVO) {
			ddsEdWarn = BeanMapper.map(ddsEdWarnVO, ddsEdWarn.getClass());
		}
		ServiceResp serviceResp = ddsEdWarnService.update(ddsEdWarn);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "updateFlag")
	public String updateFlag(DdsEdWarnVO ddsEdWarnVO, HttpServletResponse response) {
		DdsEdWarn ddsEdWarn = new DdsEdWarn();
		if (null != ddsEdWarnVO) {
			ddsEdWarn = BeanMapper.map(ddsEdWarnVO, ddsEdWarn.getClass());
		}
		ServiceResp serviceResp = new ServiceResp();
		//DdsEdWarn entity = ddsEdWarnService.get(ddsEdWarn);
		//添加到应急事件中
		//新增应急事件
		DdsEdEvent ddsEdEvent = new DdsEdEvent();
		ddsEdEvent.setEvenCd(IdGen.randomBase62(8));
		ddsEdEvent.setHapDt(ddsEdWarnVO.getStartTm());
		ddsEdEvent.setEvenTp("20");
		DdsBStat stat = ddsBStatService.get(ddsEdWarn.getSecCd());
		if(stat!=null){
			ddsEdEvent.setEvenNm(stat.getStNm()+"突发水污染");
		}else{
			ddsEdEvent.setEvenNm(ddsEdWarn.getSecCd()+"突发水污染");
		}
		//ddsEdEvent.setEvenG(entity.getLel());
		ddsEdEvent.setPubDt( new Date());
		ddsEdEvent.setNt(ddsEdWarn.getEid());
		ddsEdEvent.setRiver(ddsEdWarn.getRiver());
		List<DdsEdEvent> eventlist = ddsEdEventService.list(ddsEdEvent);
		if(eventlist.size()>0){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("该预警已存在应急事件中");
		}else{
			serviceResp = ddsEdEventService.save(ddsEdEvent);
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdWarnVO ddsEdWarnVO, HttpServletResponse response) {
		DdsEdWarn ddsEdWarn = new DdsEdWarn();
		if (null != ddsEdWarnVO) {
			ddsEdWarn = BeanMapper.map(ddsEdWarnVO, ddsEdWarn.getClass());
		}
		ServiceResp serviceResp = ddsEdWarnService.remove(ddsEdWarn);
		return renderString(response,serviceResp);
	}

	/**
	 * 超图根据应急事件  条件查询对应的方案计算结果数据
	 * secCd 断面编码
	 * TM	应急发生时间
	 * @param ddsEdWarnVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"listResult", ""})
	public String listResult(DdsEdWarnVO ddsEdWarnVO, HttpServletResponse response){
		//所有方案信息
		Map<String,Object> map = Maps.newHashMap();
		Map<String,Object> dataMap = Maps.newHashMap();
		ServiceResp serviceResp = new ServiceResp();
		
		DdsEdWarn ddsEdWarn = new DdsEdWarn();
		/*if (null != ddsEdWarnVO) {
			ddsEdWarnVO.setFlag("2");//代表确认，数据进入应急事件
			ddsEdWarn = BeanMapper.map(ddsEdWarnVO, ddsEdWarn.getClass());
		}*/
		/*List<DdsEdWarn> listwarn = ddsEdWarnService.list(ddsEdWarn);
		if(listwarn==null||listwarn.size()<=0){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("没有确认预警事件记录");
			map.put("serviceResp",serviceResp);
			return renderString(response,map);
		}*/
		List<DdsEdEvent> listevent = Lists.newArrayList();//预警对应的应急事件集合
		DdsEdEvent ddsEdEvent = new DdsEdEvent();
		if(StringUtils.isNotBlank(ddsEdWarnVO.getEid())){
			ddsEdEvent.setNt(ddsEdWarnVO.getEid());//根据预警事件ID查询应急事件
		}else{
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("请输入预警事件ID");
			return renderString(response,serviceResp);
		}
		
		List<DdsEdEvent> yjInfoList = ddsEdEventService.list(ddsEdEvent);
		if(yjInfoList != null && yjInfoList.size() > 0){
			listevent.add(yjInfoList.get(0));
		}else{
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("没有确认预警事件记录");
			return renderString(response,serviceResp);
		}
		for(DdsEdEvent event : listevent){
			Map<String,Object> result = Maps.newHashMap();
			DdsEdP ddsEdP = new DdsEdP();
			ddsEdP.setEvenCd(event.getEvenCd());
			ddsEdP.setSta(4);
			List<DdsEdP> listedp = ddsEdPService.list(ddsEdP);
			//传输所有
			map.put("plan", listedp);//所有方案
			for(DdsEdP ddsEdPVO : listedp){
				DdsEdP good = ddsEdPVO;
				//断面信息
				DdsEdRes resvo = new DdsEdRes();
				resvo.setProCd(good.getProCd());
				resvo.setRcd(event.getRcd());
				resvo.setRiver(event.getRiver());
				List<DdsEdRes> listmconsec = ddsEdResService.listTree(resvo);
				List<ModelConsecData> consecdata = Lists.newArrayList();
				List<ModelConsec> mclist = Lists.newArrayList();
				for(DdsEdRes vo: listmconsec){
					ModelConsec mc = new ModelConsec();
					mc.setSecId(vo.getSecId());
					mc.setSecnm(vo.getSecnm());
					mc.setLy("长江");
					if("02".equals(event.getRiver())){
						mc.setSx("抚河流域");
					}else if("03".equals(event.getRiver())){
						mc.setSx("袁河流域");
					}
					DdsMConsec dmconsec = ddsMConsecService.get(vo.getSecId());
					mc.setLgtd(dmconsec.getLgtd());
					mc.setLttd(dmconsec.getLttd());
					mclist.add(mc);
				}
				dataMap.put("consec",mclist);
				
				DdsEdGis gis = new DdsEdGis();
				gis.setProCd(good.getProCd());
				gis.setRcd(good.getRcd());
				List<DdsEdGis> gislist= ddsEdGisService.findTime(gis);
				
				DdsEdGisLegend gisLegend = new DdsEdGisLegend();
				gisLegend.setProCd(good.getProCd());
				DdsEdGisLegend legend = ddsEdGisLegendService.get(gisLegend);
				
				//判断是水质模拟，还是水量调度				
				DdsMRsv rsv = new DdsMRsv();
				boolean flag = true;
				rsv.setRcd(good.getRcd());
				List<DdsMRsv> rsvlist =  ddsMRsvService.list(rsv);
				if(null==rsvlist||rsvlist.size()<=0){
					flag = false;//水质调度
				}else if(rsvlist!=null && rsvlist.size()>0){
					flag = true;//水量调度
				}
				
				List<EDGisData> dataList = Lists.newArrayList();
				for(DdsEdGis edGis : gislist){
					EDGisData data = new EDGisData();
					Calendar cal = Calendar.getInstance();
					cal.setTime(ddsEdPVO.getBgDt());
					cal.add(Calendar.HOUR_OF_DAY, edGis.getTime());
					data.setDt(DateUtils.formatDateTime(cal.getTime()));
					gis.setTime(edGis.getTime());
					List<DdsEdGis> timeList = ddsEdGisService.list(gis);
					for(DdsEdGis ddsEdGis : timeList){
						ddsEdGis.setProCd(null);
						ddsEdGis.setRcd(null);						
						if(!flag){//如果是水质模拟
							ddsEdGis.setRealValue(ddsEdGis.getPlanValue());
						}
						ddsEdGis.setPlanValue(null);
					}
					data.setData(timeList);
					dataList.add(data);
				}
				//动画演进基本信息
				List<ModelConsec> consec = Lists.newArrayList();
				
				
				
				for(DdsEdRes res : listmconsec){//循环断面
					ModelConsecData mcd = new ModelConsecData();
					mcd.setSecId(res.getSecId());
					mcd.setSecnm(res.getSecnm());
					DdsEdRes ddsEdRes = new DdsEdRes();
					ddsEdRes.setProCd(good.getProCd());
					ddsEdRes.setSecId(res.getSecId());
					if(null!=good && null!=good.getBgDt()){
						ddsEdRes.setStartTime(DateUtils.formatDateTime(good.getBgDt()));
					}
					if(null!=good && null!=good.getEdDt()){
						ddsEdRes.setEndTime(DateUtils.formatDateTime(good.getEdDt()));
					}
					List<DdsEdRes> listres = ddsEdResService.list(ddsEdRes);
					List<ModelData> datalist = new ArrayList();
					List<DdsEdRes> realRes = new ArrayList();
					for(int i = 0 ; i < listres.size(); i++){
						if(flag && "1".equals(listres.get(i).getqType())){
							realRes.add(listres.get(i));
						}else if(!flag ){
							realRes.add(listres.get(i));
						}
					}
					for(int i = 0 ; i < realRes.size(); i++){//实际值
						DdsEdRes real = realRes.get(i);
						ModelData data = new ModelData();
						data.setTm(real.getTm());
						data.setRealz(real.getZ());
						data.setRealotq(real.getOtq());
						data.setRealbopl(real.getBoPl());
						datalist.add(data);
					}
					mcd.setDataList(datalist);
					consecdata.add(mcd);
					
					//设置断面的经纬度坐标
					if("测站".equals(res.getStype())){//处理只显示测试的断面
						ModelConsec mconsec = new ModelConsec();
						mconsec.setStcd(res.getSecId());
						mconsec.setStnm(res.getSecnm());
						mconsec.setLy("长江");
						if("02".equals(event.getRiver())){
							mconsec.setSx("抚河流域");
						}else if("03".equals(event.getRiver())){
							mconsec.setSx("袁河流域");
						}
						DdsMConsec dmconsec = ddsMConsecService.get(res.getSecId());
						mconsec.setLgtd(dmconsec.getLgtd());
						mconsec.setLttd(dmconsec.getLttd());
						consec.add(mconsec);
					}
				}
				dataMap.put("data", consecdata);//应急调度数据
				dataMap.put("gislist",dataList);//动画演进信息
				dataMap.put("legend", legend);//应急调度地图色彩分级
				dataMap.put("station", consec);//测站信息
				map.put(ddsEdPVO.getProCd(), dataMap);
			}
		}
		return renderString(response,map);
	}
	
	/**
	 * 点击预警信息查询 同步请求超图信息接口
	 * @param ddsEdWarnVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"syncYjInfo", ""})
	public String syncYjInfo(DdsEdWarnVO ddsEdWarnVO, HttpServletResponse response){
		//默认查询最近一个月的数据
		String stm = ddsEdWarnVO.getStm();
		String etm = ddsEdWarnVO.getEtm();
		if(StringUtils.isBlank(stm)){
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);
			stm = DateUtils.formatDate(cal.getTime(), "yyyy-MM-dd HH:mm");
		}
		if(StringUtils.isBlank(etm)){
			etm = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm");
		}
		YJPage yjPage =  new YJPage();
		if(StringUtils.isBlank(ddsEdWarnVO.getSecCd())){
			List<DdsBWqst> listWq= ddsBWqstService.list(new  DdsBWqst());
			if(listWq.size()>0){//默认请求第一个测站数据
				//yjPage = getYj(listWq.get(0).getStcd(),stm,etm,ddsEdWarnVO.getLimit(),ddsEdWarnVO.getPage());
				yjPage = getYj("61190100","2014-08-08 17:02","2018-08-08 17:02",ddsEdWarnVO.getPageNo(),ddsEdWarnVO.getPageSize());
			}
		}else{
			yjPage = getYj(ddsEdWarnVO.getSecCd(),stm,etm,ddsEdWarnVO.getPageNo(),ddsEdWarnVO.getPageSize());
		}
		return renderString(response, yjPage);
	}
	
	/**
	 * 请求超图应急信息接口
	 * @param stcd 测站编码
	 * @param allItem	请求指标
	 * @param stm	开始时间
	 * @param etm	结束时间
	 * @param pageSize	页面大小
	 * @param currPage 页码
	 * @return
	 */
	public YJPage getYj(String stcd,String stm,String etm,int pageSize,int currPage ){
		String url=Global.getConfig("yjeventurl");
		YJPage yjPage = new YJPage();
        BufferedReader in = null;
        OutputStreamWriter out = null;
        BufferedReader reader = null;
        String response="";
        
        JSONObject params = new JSONObject();
        try {
	        	URL httpUrl = null; //HTTP URL类 用这个类来创建连接
	            //创建URL
	           	httpUrl = new URL(url);
           	        //建立连接
                HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("connection", "keep-alive");
                conn.setUseCaches(false);//设置不要缓存
                conn.setInstanceFollowRedirects(true);
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.connect();
                //POST请求
                out = new OutputStreamWriter(conn.getOutputStream());
                params.put("stcd", stcd);
                params.put("stm", stm);
                params.put("etm", etm);
                params.put("pageSize", pageSize);
                params.put("currPage", currPage);
                out.write(params.toString());
                out.flush();
                //读取响应
                reader = new BufferedReader(new InputStreamReader(
                        conn.getInputStream()));
                String lines;
                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes(), "utf-8");
                    response+=lines;
                }
                reader.close();
                // 断开连接
                conn.disconnect();
                if(StringUtils.isNotBlank(response)){
                	yjPage = JSON.parseObject(response,YJPage.class); 
                }
                return yjPage;
        } catch (Exception e) {
        	yjPage.setCode(1);
        	yjPage.setMessage("请求超图接口异常："+e.getMessage());
            return yjPage;
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
                return yjPage;
            }
        }
	}
	
}
