package com.jsite.szy.dispatch.dispatchwo.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.jsite.busi.szy.dispatch.po.DdsRdIfres;
import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.busi.szy.dispatch.po.DdsRdWares;
import com.jsite.busi.szy.dispatch.po.DdsRdWdcons;
import com.jsite.busi.szy.dispatch.po.DdsRdWdinit;
import com.jsite.busi.szy.dispatch.po.DdsRdWdinithis;
import com.jsite.busi.szy.dispatch.po.DdsRdWdres;
import com.jsite.busi.szy.dispatch.po.DdsRdWdwun;
import com.jsite.busi.szy.dispatch.service.DdsRdIfresService;
import com.jsite.busi.szy.dispatch.service.DdsRdPService;
import com.jsite.busi.szy.dispatch.service.DdsRdWaresService;
import com.jsite.busi.szy.dispatch.service.DdsRdWdconsService;
import com.jsite.busi.szy.dispatch.service.DdsRdWdinitService;
import com.jsite.busi.szy.dispatch.service.DdsRdWdinithisService;
import com.jsite.busi.szy.dispatch.service.DdsRdWdmparService;
import com.jsite.busi.szy.dispatch.service.DdsRdWdresService;
import com.jsite.busi.szy.dispatch.service.DdsRdWdwunService;
import com.jsite.szy.dispatch.dispatchwo.convert.ListService;
import com.jsite.szy.dispatch.dispatchwo.convert.TestPlan;
import com.jsite.szy.dispatch.dispatchwo.convert.WODisplayConvert;
import com.jsite.szy.dispatch.dispatchwo.data.WOJsonReader;
import com.jsite.szy.dispatch.dispatchwo.data.WOReservoir;
import com.jsite.szy.dispatch.dispatchwo.data.WOResult;
import com.jsite.szy.dispatch.dispatchwo.data.WOSection;
import com.jsite.szy.dispatch.dispatchwo.data.WOUseWater;
import com.jsite.szy.dispatch.dispatchwo.model.ELEMapping;
import com.jsite.szy.dispatch.dispatchwo.model.InflowConverter;
import com.jsite.szy.dispatch.dispatchwo.model.SpecialInformation;
import com.jsite.szy.dispatch.dispatchwo.vo.WaterOptimumVOMap;
import com.wrms.core.scheme.SchemeTypeEnum;
import com.wrms.core.scheme.regular.SchemeRAllocationResult;
import com.wrms.core.scheme.regular.SchemeRDispatchPara;
import com.wrms.core.scheme.regular.SchemeRDispatchResult;
import com.wrms.core.scheme.regular.SchemeRForcastResult;
import com.wrms.core.scheme.regular.SchemeRegularDispatch;
import com.wrms.core.scheme.regular.moudle.AllocationResult;
import com.wrms.core.scheme.regular.moudle.AllocationResultItem;
import com.wrms.core.scheme.regular.moudle.DispatchConstraintItem;
import com.wrms.core.scheme.regular.moudle.DispatchResultItem;
import com.wrms.core.scheme.regular.moudle.ForcastResultItem;
import com.wrms.core.subject.SubjectRegularDispatch;

import wrms.jiangxi.regular.RegulaSchemeController;
import wrms.jiangxi.regular.RegularExcute;
import wrms.jiangxi.regular.SchemeBean;
import wrms.jiangxi.regular.dispatch.WaterDispatchController;

@Service
public class WaterOptimumService {
	private Logger logger = LogManager.getLogger(this.getClass().getName());

	private WOJsonReader jsonReader;
	private ELEMapping eleMapping;
	
	@Autowired
	protected DdsRdPService DDS_RD_P;
	@Autowired
	protected DdsRdWdinitService DDS_RD_WDINIT;
	@Autowired
	protected DdsRdWdconsService DDS_RD_WDCONS;
	@Autowired
	protected DdsRdIfresService DDS_RD_IFRES;
	@Autowired
	protected DdsRdWaresService DDS_RD_WARES;
	@Autowired
	protected DdsRdWdmparService DDS_RD_WDMPAR;
	@Autowired
	protected DdsRdWdresService DDS_RD_WDRES;	
	@Autowired
	protected DdsRdWdwunService DDS_RD_WDWUN;
	@Autowired
	protected DdsRdWdinithisService DDS_RD_WDINITHIS;
	
	public WaterOptimumService() {
		jsonReader = new WOJsonReader();
		eleMapping = new ELEMapping();
	}
	
	public WaterOptimumVOMap initialCondition(String schemeId) {
		TestPlan plan = new TestPlan(schemeId, DDS_RD_P);	
		DdsRdP scheme = plan.getPlan();
		
		DdsRdWdinit ddsRdWdinit = new DdsRdWdinit();
		ddsRdWdinit.setProCd(schemeId);
		
		DdsRdIfres ddsRdIfres = new DdsRdIfres();
		ddsRdIfres.setProCd(schemeId);
		
		List<DdsRdWdinit> initList = DDS_RD_WDINIT.list(ddsRdWdinit);
		List<DdsRdIfres> forecastList = DDS_RD_IFRES.list(ddsRdIfres);
		
		if(initList != null && initList.size() > 0){
			//do nothing
		
		}
		else {
			String xmlPath = "com/jsite/szy/dispatch/dispatchwo/model/FHinitial.xml";
			if(scheme.getRvCd().indexOf("03") >= 0){
				xmlPath = "com/jsite/szy/dispatch/dispatchwo/model/YHinitial.xml";
			}
			
			ClassPathXmlApplicationContext modfh = new ClassPathXmlApplicationContext(xmlPath);
			WODisplayConvert mod = (WODisplayConvert) modfh.getBean("data");
			modfh.close();
			
			List<DdsRdWdinit> list = mod.getInitList();
			for(int i=0;i<list.size();i++){
				DdsRdWdinit single = list.get(i);
				single.setProCd(schemeId);
			}
			ListService.save(list, DDS_RD_WDINIT);
			
			initList = list;
		}
		
		if(forecastList != null && forecastList.size() > 0){
			//将预报径流转换为区间来水
			String xmlPath = "com/jsite/szy/dispatch/dispatchwo/model/FHinflow.json";
			if(scheme.getRvCd().indexOf("03") >= 0){
				xmlPath = "com/jsite/szy/dispatch/dispatchwo/model/YHinflow.json";
			}
			forecastList = new InflowConverter(xmlPath, forecastList, scheme).output();
		}
		
		//TODO---------临时更改以独立运行
		/*String xmlPath = "com/jsite/szy/dispatch/dispatchwo/model/FHmod.xml";
		if(scheme.getRvCd().indexOf("03") >= 0){
			xmlPath = "com/jsite/szy/dispatch/dispatchwo/model/YHmod.xml";
		}
		SpecialInformation information = new SpecialInformation(xmlPath);
		List<DdsRdIfres> list = information.loadSpecialForecastList(scheme);
		
		List<DdsRdIfres> selector = new ArrayList<>();
		for(DdsRdIfres item: list){
			if(item.getBgtm().getTime() < scheme.getBgDt().getTime())continue;
			if(item.getBgtm().getTime() >= scheme.getEdDt().getTime())continue;
			selector.add(item);
		}
		forecastList = selector;*/
		//TODO End
		
		List<DdsRdWdinithis> initHisPara = new ArrayList<>();
		Set<String> initSet = new HashSet<>();
		for(int i=0;i<initList.size();i++){
			initSet.add(initList.get(i).getWceId());
		}
		for(String text: initSet){
			DdsRdWdinithis temp = new DdsRdWdinithis();
			temp.setWceId(text);
			initHisPara.add(temp);
		}
		List<DdsRdWdinithis> initHisList = DDS_RD_WDINITHIS.listIn(initHisPara);
		
		return initialConditionYear(initList, forecastList, initHisList);
	}
	
	public WaterOptimumVOMap initialConditionYear(List<DdsRdWdinit> ddsrdwdinitList, List<DdsRdIfres> ddsrdifresList, List<DdsRdWdinithis> initHisList){
		WaterOptimumVOMap output = new WaterOptimumVOMap();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//查询水库初末水位设定 
		List<WaterOptimumVOMap> index1 = new ArrayList<>();
		List<WaterOptimumVOMap> index2 = new ArrayList<>();
		if(ddsrdwdinitList != null && ddsrdwdinitList.size() > 0){
			for(int i=0;i<ddsrdwdinitList.size();i++){
				DdsRdWdinit temp = ddsrdwdinitList.get(i);
				//index1为水库信息
				if(temp.getWceTp() == 0){
					WaterOptimumVOMap vo = new WaterOptimumVOMap();
					String id = temp.getWceId();
					vo.put("co", id);
					vo.put("index1", eleMapping.queryByCode(id));
					vo.put("index2", temp.getBgz());
					vo.put("index3", temp.getEdz());
					vo.put("index4", impoundment(temp.getBgz(), temp.getEdz(), id));
					vo.put("index5", historyFlowReservoir(id, initHisList));
					index1.add(vo);
				}
				//index2为断面信息
				else if(temp.getWceTp() == 1){
					WaterOptimumVOMap vo = new WaterOptimumVOMap();
					String id = temp.getWceId();
					vo.put("co", id);
					vo.put("index1", eleMapping.queryByCode(id));
					vo.put("index2", temp.getBq());
					vo.put("index3", temp.getMnq());
					vo.put("index4", temp.getMxq());
					vo.put("index5", historyFlowSection(id, temp.getMnq(), temp.getMxq()));
					index2.add(vo);
				}
			}			
		}
		//查询预报数据
		WaterOptimumVOMap index3 = new WaterOptimumVOMap();
		List<String> index3_1 = new ArrayList<>();
		List<WaterOptimumVOMap> index3_2 = new ArrayList<>();
		List<String> index3_3 = new ArrayList<>();
		
		if(ddsrdifresList != null && ddsrdifresList.size() > 0){
			//先找出断面号 与 预报时间的集合
			Set<String> sectionID = new TreeSet<>();
			Set<Date> timely = new TreeSet<>();
			//建立起始与终止时间对应关系
			Map<Date, Date> endTimeMap = new HashMap<>();			
			for(int i=0;i<ddsrdifresList.size();i++){
				DdsRdIfres item = ddsrdifresList.get(i);
				sectionID.add(item.getSecCd());
				timely.add(item.getBgtm());
				if(endTimeMap.get(item.getBgtm()) == null)endTimeMap.put(item.getBgtm(), item.getEdtm());
			}
			//建立下标映射关系
			Map<String, Integer> sectionMap = new HashMap<>();
			Map<Date, Integer> timelyMap = new HashMap<>();
			List<Date> timelyList = new ArrayList<>();
			int sFlag = 0;			
			for(String value: sectionID){
				sectionMap.put(value, sFlag++);
				//将名称填入header参考
				String code = eleMapping.queryByCode(value);
				if(code == null)index3_1.add("未识别"+sFlag);
				else index3_1.add(code);
				index3_3.add(value.trim());
			}
			int mFlag = 0;
			for(Date value: timely){
				timelyMap.put(value, mFlag++);
				timelyList.add(value);
			}
			//填充数据 [1.按月份数生成map; 2.按断面下标对照填入预报来水]
			WaterOptimumVOMap[] forecastMap = new WaterOptimumVOMap[mFlag];
			for(int i=0;i<forecastMap.length;i++){
				forecastMap[i] = new WaterOptimumVOMap();
				forecastMap[i].put("index1", displayTime(timelyList.get(i), endTimeMap.get(timelyList.get(i))));
				forecastMap[i].put("time_s", df.format(timelyList.get(i)));
				forecastMap[i].put("time_e", df.format(endTimeMap.get(timelyList.get(i))));				
				index3_2.add(forecastMap[i]);
			}
			
			for(int i=0;i<ddsrdifresList.size();i++){
				DdsRdIfres item = ddsrdifresList.get(i);
				if(sectionMap.get(item.getSecCd()) != null && timelyMap.get(item.getBgtm()) != null)
				forecastMap[timelyMap.get(item.getBgtm())].put("index"+(3+sectionMap.get(item.getSecCd())), item.getForW());
			}	
		}
		else{
			output.put("showmes", true);
			output.put("message", "<p style=\"font-size:18px;margin: 5px 10px 5px 10px;\">没有查询到预报数据，请返回 <span style=\"font-weight:bold; color:red;\">径流预报</span> 执行预报操作</p>");
		}
		//装填预报流量界面显示VO模块
		index3.put("index1", index3_1);
		index3.put("index2", index3_2);		
		//3个部分输出
		output.put("index1", index1);
		output.put("index2", index2);
		output.put("index3", index3);
		return output;
	}
		
	protected double impoundment(double start, double end, String eleId){
		if(start>80)return 171.0;
		else 
		return 11.20;
	}
	
	protected List<WaterOptimumVOMap> historyFlowReservoir(String eid,List<DdsRdWdinithis> initHisList){
		List<WaterOptimumVOMap> output = new ArrayList<>();
		List<DdsRdWdinithis> useable = new ArrayList<>();
		for(int i=0;i<initHisList.size();i++){
			DdsRdWdinithis single = initHisList.get(i);
			if(single.getWceId().equals(eid)){
				useable.add(single);
			}
		}
		Collections.sort(useable, new Comparator<DdsRdWdinithis>() {
			@Override
			public int compare(DdsRdWdinithis o1, DdsRdWdinithis o2) {
				// TODO Auto-generated method stub
				return o2.getYear().compareTo(o1.getYear());
			}
		});
		for(DdsRdWdinithis single: useable){
			WaterOptimumVOMap temp = new WaterOptimumVOMap();
			temp.put("index1", single.getYear());
			temp.put("index2", single.getZs());
			temp.put("index3", single.getZe());
			temp.put("index4", 0);
			output.add(temp);
		}		
		return output;
	}
	
	protected List<WaterOptimumVOMap> historyFlowReservoir(String eleId, Double start, Double end){
		List<WaterOptimumVOMap> output = new ArrayList<>();
		for(int i=2012;i<2017;i++){
			WaterOptimumVOMap temp = new WaterOptimumVOMap();
			temp.put("index1", i);
			temp.put("index2", start);
			temp.put("index3", end);
			temp.put("index4", impoundment(start, end, eleId));
			output.add(temp);
		}
		return output;
	}
	
	protected List<WaterOptimumVOMap> historyFlowSection(String eleId, Double min, Double max){
		List<WaterOptimumVOMap> output = new ArrayList<>();
		for(int i=2012;i<2017;i++){
			WaterOptimumVOMap temp = new WaterOptimumVOMap();
			temp.put("index1", i);
			temp.put("index2", Math.random()*(max - min) + min);
			temp.put("index3", min);
			temp.put("index4", max);
			output.add(temp);
		}
		return output;
	}
	
	public WaterOptimumVOMap uploadHistory(InputStream fis, String eid) throws IOException{
		WaterOptimumVOMap output = new WaterOptimumVOMap();
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		int rowStart = sheet.getFirstRowNum();
		int rowEnd = sheet.getLastRowNum();
		List<DdsRdWdinithis> list = new ArrayList<>();
		for(int i=rowStart;i<=rowEnd;i++){
			Row row = sheet.getRow(i);
			if(row == null)continue;
			
			if(row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC){
				int year = (int) row.getCell(0).getNumericCellValue();
				double zs = row.getCell(1).getNumericCellValue();
				double ze = row.getCell(2).getNumericCellValue();
				
				DdsRdWdinithis ddsRdWdinithis = new DdsRdWdinithis();
				ddsRdWdinithis.setWceId(eid);
				ddsRdWdinithis.setYear(year);
				ddsRdWdinithis.setZs(zs);
				ddsRdWdinithis.setZe(ze);
				list.add(ddsRdWdinithis);
			}
		}
		DdsRdWdinithis temp = new DdsRdWdinithis();
		temp.setWceId(eid);
		DDS_RD_WDINITHIS.remove(temp);
		ListService.save(list, DDS_RD_WDINITHIS);
		output.put("success", true);
		return output;
	}
	
	public WaterOptimumVOMap schedulingConstraints(String schemeId){
		TestPlan plan = new TestPlan(schemeId, DDS_RD_P);	
		DdsRdP scheme = plan.getPlan();
		
		DdsRdWdcons noUse = new DdsRdWdcons();
		noUse.setProCd(schemeId);
		List<DdsRdWdcons> constraintsList = DDS_RD_WDCONS.list(noUse);
		if(constraintsList != null && constraintsList.size() > 0){
			//do nothing
		}
		else {
			Date start = scheme.getBgDt();
			Date end = scheme.getEdDt();
			
			Calendar startC = Calendar.getInstance();
			startC.setTime(start);
			
			Calendar endC = Calendar.getInstance();
			endC.setTime(end);			
			
			String xmlPath = "com/jsite/szy/dispatch/dispatchwo/model/FHconstraints.xml";
			if(scheme.getRvCd().indexOf("03") >= 0){
				xmlPath = "com/jsite/szy/dispatch/dispatchwo/model/YHconstraints.xml";
			}
			ClassPathXmlApplicationContext modfh = new ClassPathXmlApplicationContext(xmlPath);
			WODisplayConvert mod = (WODisplayConvert) modfh.getBean("data");
			modfh.close();
			
			List<DdsRdWdcons> template = mod.getConsList();
			List<DdsRdWdcons> list = new ArrayList<>();
			
			Map<String, DdsRdWdcons> map = new HashMap<>();
			Set<String> reservoirSet = new TreeSet<>();
			for(int i=0;i<template.size();i++){
				DdsRdWdcons single = template.get(i);
				int month = getMonth(single.getBgt());
				String entityID = single.getWceId();
				map.put(entityID+"-"+month, single);
				reservoirSet.add(single.getWceId());
			}
			
			for(String reservoir: reservoirSet){
				Calendar tempStart = Calendar.getInstance();
				tempStart.setTime(new Date(startC.getTime().getTime()));
				while(tempStart.before(endC)){
					Calendar tempEnd = Calendar.getInstance();
					tempEnd.setTime(new Date(tempStart.getTime().getTime()));
					
					if(scheme.getProTp().indexOf("3") >= 0){
						//旬
						tempEnd.add(Calendar.DAY_OF_MONTH, 15);
						int day = tempEnd.get(Calendar.DAY_OF_MONTH);
						if(day < 11)day = 1;
						else if(day < 21)day = 11;
						else day = 21;
						tempEnd.set(Calendar.DAY_OF_MONTH, day);
					}
					else {
						tempEnd.add(Calendar.MONTH, 1);
					}
					
					int month = tempStart.get(Calendar.MONTH)+1;
					DdsRdWdcons con = map.get(reservoir+"-"+month);						
					
					DdsRdWdcons ddsRdWdcons = new DdsRdWdcons();
					ddsRdWdcons.setProCd(schemeId);
					ddsRdWdcons.setWceId(reservoir);
					ddsRdWdcons.setBgt(tempStart.getTime());
					ddsRdWdcons.setEdt(tempEnd.getTime());
					ddsRdWdcons.setZmx(con.getZmx());
					ddsRdWdcons.setZmn(con.getZmn());
					ddsRdWdcons.setQmx(con.getQmx());
					ddsRdWdcons.setQmn(con.getQmn());
					ddsRdWdcons.setNmx(con.getNmx());
					ddsRdWdcons.setNmn(con.getNmn());
					list.add(ddsRdWdcons);
					
					tempStart = tempEnd;
				}
			}
			
			ListService.save(list, DDS_RD_WDCONS);			
			constraintsList = list;
		}
		return schedulingConstraintsYear(constraintsList);
	}
	
	public WaterOptimumVOMap schedulingConstraintsYear(List<DdsRdWdcons> ddsRdWdconsList){
		WaterOptimumVOMap output = new WaterOptimumVOMap();
		//约束条件骨架——index1:水库名; index2:各水库约束
		List<String> index1 = new ArrayList<>();
		List<WaterOptimumVOMap> index2 = new ArrayList<>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if(ddsRdWdconsList != null && ddsRdWdconsList.size() > 0){
			//先找出水库号 与 约束起始时间的集合
			Set<String> reservoirID = new TreeSet<>();
			Set<Date> timely = new TreeSet<>();
			//建立起始与终止时间对应关系
			Map<Date, Date> endTimeMap = new HashMap<>();
			for(int i=0;i<ddsRdWdconsList.size();i++){
				DdsRdWdcons item = ddsRdWdconsList.get(i);
				reservoirID.add(item.getWceId());
				timely.add(item.getBgt());
				if(endTimeMap.get(item.getBgt()) == null)endTimeMap.put(item.getBgt(), item.getEdt());
			}
			//建立下标映射关系
			Map<String, Integer> reservoirMap = new HashMap<>();
			Map<Date, Integer> timelyMap = new HashMap<>();
			List<Date> timelyList = new ArrayList<>();
			int sFlag = 0;
			
			for(String value: reservoirID){
				reservoirMap.put(value, sFlag++);
				//把水库名填入array，作为表头参照
				index1.add(eleMapping.queryByCode(value));
			}
			int mFlag = 0;
			for(Date value: timely){
				timelyMap.put(value, mFlag++);
				timelyList.add(value);
			}
			//填充数据 [1.按月份数生成map; 2.按断面下标对照填入预报来水]
			WaterOptimumVOMap[] constraintsMap = new WaterOptimumVOMap[mFlag];
			for(int i=0;i<constraintsMap.length;i++){
				constraintsMap[i] = new WaterOptimumVOMap();
				constraintsMap[i].put("index1", displayTime(timelyList.get(i), endTimeMap.get(timelyList.get(i))));
				constraintsMap[i].put("time_s", df.format(timelyList.get(i)));
				constraintsMap[i].put("time_e", df.format(endTimeMap.get(timelyList.get(i))));
				//写入时间列
				index2.add(constraintsMap[i]);
			}
			//写入约束列
			for(int i=0;i<ddsRdWdconsList.size();i++){
				DdsRdWdcons item = ddsRdWdconsList.get(i);
				if(reservoirMap.get(item.getWceId()) != null && timelyMap.get(item.getBgt()) != null){
					int c = timelyMap.get(item.getBgt());
					int subscript = reservoirMap.get(item.getWceId());
					constraintsMap[c].put("index"+(1+subscript)+"_co", item.getWceId());
					constraintsMap[c].put("index"+(1+subscript)+"_1", item.getZmx());
					constraintsMap[c].put("index"+(1+subscript)+"_2", item.getZmn());
					constraintsMap[c].put("index"+(1+subscript)+"_3", item.getQmx());
					constraintsMap[c].put("index"+(1+subscript)+"_4", item.getQmn());
					constraintsMap[c].put("index"+(1+subscript)+"_5", item.getNmx());
					constraintsMap[c].put("index"+(1+subscript)+"_6", item.getNmn());
				}				
			}
		}
		//最后的装填
		output.put("index1", index1);
		output.put("index2", index2);
		return output;
	}
	
	public WaterOptimumVOMap schedulingChart(String schemeId){
		sysLog("reading scheduling chart data...");
		WaterOptimumVOMap output;
		TestPlan plan = new TestPlan(schemeId, DDS_RD_P);
		DdsRdP scheme = plan.getPlan();
		if(scheme.getRvCd().indexOf("03") >= 0){
			output = jsonReader.read("schedulingChartYH.json");
		}
		else output = jsonReader.read("schedulingChart.json");
		return output;
	}
	
	public WaterOptimumVOMap readAllocate(String schemeId){
		TestPlan plan = new TestPlan(schemeId, DDS_RD_P);
		DdsRdP scheme = plan.getPlan();
		WaterOptimumVOMap output = new WaterOptimumVOMap();
		DdsRdWares ddsRdWares = new DdsRdWares();
		ddsRdWares.setProCd(schemeId);
		List<DdsRdWares> allocateList = DDS_RD_WARES.list(ddsRdWares);
		
		List<WaterOptimumVOMap> details = new ArrayList<>();
		TreeMap<Date, Date> datePack = new TreeMap<>();
		
		if(allocateList != null && allocateList.size() > 0){
			List<SchemeRAllocationResult> data = fillAllocate(allocateList, scheme);
			for(int i=0;i<data.size();i++){
				SchemeRAllocationResult srar = data.get(i);
				List<AllocationResult> results = srar.getAllocationResults();
				
				for(int j=0;j<results.size();j++){
					AllocationResult ar = results.get(j);
					List<AllocationResultItem> declare = ar.getDeclareWaters();
					List<AllocationResultItem> allocate = ar.getAllocatedWaters();
					WaterOptimumVOMap item = new WaterOptimumVOMap();
					item.put("admin", srar.getEntityId());
					item.put("adminname", srar.getEntityName());
					item.put("eid", ar.getEntityId());
					item.put("name", ar.getEntityName());
					item.put("rid", ar.getEntityId().substring(6));
					item.put("rname", eleMapping.queryByCode(ar.getEntityId().substring(6)));
					for(int k=0;k<declare.size();k++){
						AllocationResultItem ds = declare.get(k);
						AllocationResultItem as = allocate.get(k);
						String pre = "col"+(k+1)+"_";
						
						item.put(pre+"ts", ds.getTimeStart());
						item.put(pre+"te", ds.getTimeEnd());
						item.put("time", displayTime(ds.getTimeStart(), ds.getTimeEnd()));
						if(datePack.get(ds.getTimeStart()) == null)datePack.put(ds.getTimeStart(), ds.getTimeEnd());
						
						item.put(pre+"da", ds.getAgriculturalWater());
						item.put(pre+"dd", ds.getDomesticWater());
					//	item.put(pre+"de", ds.getEcologicalWater());
						item.put(pre+"di", ds.getIndustrialWater());
						item.put(pre+"dt", ds.getTOT_RS());
						
						item.put(pre+"aa", as.getAgriculturalWater());
						item.put(pre+"ad", as.getDomesticWater());
					//	item.put(pre+"ae", as.getEcologicalWater());
						item.put(pre+"ai", as.getIndustrialWater());
						item.put(pre+"at", as.getTOT_RS());
					}
					details.add(item);
				}
			}
			
			int sflag = 1;
			List<WaterOptimumVOMap> head = new ArrayList<>();
			for (Entry<Date, Date> entry : datePack.entrySet()) {
				Date key = entry.getKey();
				Date value = entry.getValue();
				WaterOptimumVOMap single = new WaterOptimumVOMap();
				single.put("text", displayTime(key, value));
				single.put("id", "col"+sflag);
				sflag++;
				head.add(single);
			}
			
			output.put("index1", head);
			output.put("index2", details);
		}
		else {
			output.put("success", false);
			output.put("message", "<p style=\"font-size:18px;margin: 5px 10px 5px 10px;\">没有查询到水量分配数据，请返回 <span style=\"font-weight:bold; color:red;\">水量分配</span> 执行相应的操作</p>");
			return output;
		}
		
		return output;
	}
	
	public WaterOptimumVOMap calculation(String schemeId, String initData, String constraintsData){
		TestPlan plan = new TestPlan(schemeId, DDS_RD_P);
		DdsRdP scheme = plan.getPlan();
		WaterOptimumVOMap output = new WaterOptimumVOMap();
		saveCondition(scheme, initData, constraintsData);
		try {
			output.put("success", true);
			
			DdsRdWdinit ddsRdWdinit = new DdsRdWdinit();
			ddsRdWdinit.setProCd(schemeId);
			List<DdsRdWdinit> initList = DDS_RD_WDINIT.list(ddsRdWdinit);
			if(initList != null && initList.size() > 0){
				
			}
			else {
				output.put("success", false);
				output.put("message", "<p style=\"font-size:18px;margin: 5px 10px 5px 10px;\">没有查询到初始条件，请返回 <span style=\"font-weight:bold; color:red;\">初始条件</span> 选项卡执行相应的操作</p>");
				return output;
			}
			
			DdsRdWdcons noUse = new DdsRdWdcons();
			noUse.setProCd(schemeId);
			List<DdsRdWdcons> constraintsList = DDS_RD_WDCONS.list(noUse);
			if(constraintsList != null && constraintsList.size() > 0){
				
			}
			else {
				output.put("success", false);
				output.put("message", "<p style=\"font-size:18px;margin: 5px 10px 5px 10px;\">没有查询到约束条件，请返回 <span style=\"font-weight:bold; color:red;\">约束条件</span> 选项卡执行相应的操作</p>");
				return output;
			}
			
			DdsRdIfres ddsRdIfres = new DdsRdIfres();
			ddsRdIfres.setProCd(schemeId);
			List<DdsRdIfres> forecastList = DDS_RD_IFRES.list(ddsRdIfres);
			//TODO---------临时更改以独立运行
			/*String xmlPathT = "com/jsite/szy/dispatch/dispatchwo/model/FHmod.xml";
			if(plan.getPlan().getRvCd().indexOf("03") >= 0){
				xmlPathT = "com/jsite/szy/dispatch/dispatchwo/model/YHmod.xml";
			}
			SpecialInformation information = new SpecialInformation(xmlPathT);
			List<DdsRdIfres> list = information.loadSpecialForecastList(plan.getPlan());
			
			List<DdsRdIfres> selector = new ArrayList<>();
			for(DdsRdIfres item: list){
				if(item.getBgtm().getTime() < plan.getPlan().getBgDt().getTime())continue;
				if(item.getBgtm().getTime() >= plan.getPlan().getEdDt().getTime())continue;
				selector.add(item);
			}
			forecastList = selector;*/
			//TODO End
			if(forecastList != null && forecastList.size() > 0){
				//将预报来水转换区间来水
				String xmlPath = "com/jsite/szy/dispatch/dispatchwo/model/FHinflow.json";
				if(scheme.getRvCd().indexOf("03") >= 0){
					xmlPath = "com/jsite/szy/dispatch/dispatchwo/model/YHinflow.json";
				}
				forecastList = new InflowConverter(xmlPath, forecastList, scheme).output();
			}
			else {
				output.put("success", false);
				output.put("message", "<p style=\"font-size:18px;margin: 5px 10px 5px 10px;\">没有查询到预报数据，请返回 <span style=\"font-weight:bold; color:red;\">径流预报</span> 执行预报操作</p>");
				return output;
			}
			
			DdsRdWares ddsRdWares = new DdsRdWares();
			ddsRdWares.setProCd(schemeId);
			List<DdsRdWares> allocateList = DDS_RD_WARES.list(ddsRdWares);
			//TODO---------临时更改以独立运行
		//	allocateList = information.loadSpecialAllocateList(plan.getPlan());
			//TODO End
			if(allocateList != null && allocateList.size() > 0){
				
			}
			else {
				output.put("success", false);
				output.put("message", "<p style=\"font-size:18px;margin: 5px 10px 5px 10px;\">没有查询到水量分配数据，请返回 <span style=\"font-weight:bold; color:red;\">水量分配</span> 执行相应的操作</p>");
				return output;
			}			
			
			List<SchemeRDispatchResult> results = runModel(plan.getPlan(), initList, constraintsList, forecastList, allocateList);
			saveResults(plan.getPlan(), results);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output.put("success", false);
			output.put("message", "<p style=\"font-size:18px;margin: 5px 10px 5px 10px;\">预报数据或水量分配数据与调度模型不匹配</p>");
		}
		return output;
	}
	
	protected void saveCondition(DdsRdP plan, String initData, String constraintsData) {
		List<DdsRdWdinit> initList = new ArrayList<>();
		List<DdsRdWdcons> consList = new ArrayList<>();
		
		if(initData != null){			
			WaterOptimumVOMap init = jsonReader.readString(initData);
			List<LinkedHashMap<String, Object>> reservoirs = (List<LinkedHashMap<String, Object>>) init.get("index1");
			for(int i=0;i<reservoirs.size();i++){
				LinkedHashMap<String, Object> reservoirSingle = reservoirs.get(i);
				DdsRdWdinit ddsRdWdinit = new DdsRdWdinit();
				ddsRdWdinit.setProCd(plan.getProCd());
				ddsRdWdinit.setWceId(reservoirSingle.get("co").toString());
				ddsRdWdinit.setWceTp(0);
				ddsRdWdinit.setBgz(Double.parseDouble(reservoirSingle.get("index2").toString()));
				ddsRdWdinit.setEdz(Double.parseDouble(reservoirSingle.get("index3").toString()));
				initList.add(ddsRdWdinit);
			}
			
			List<LinkedHashMap<String, Object>> section = (List<LinkedHashMap<String, Object>>) init.get("index2");
			for(int i=0;i<section.size();i++){
				LinkedHashMap<String, Object> sectionSingle = section.get(i);
				DdsRdWdinit ddsRdWdinit = new DdsRdWdinit();
				ddsRdWdinit.setProCd(plan.getProCd());
				ddsRdWdinit.setWceId(sectionSingle.get("co").toString());
				ddsRdWdinit.setWceTp(1);
				ddsRdWdinit.setBq(Double.parseDouble(sectionSingle.get("index2").toString()));
				ddsRdWdinit.setMnq(Double.parseDouble(sectionSingle.get("index3").toString()));
				ddsRdWdinit.setMxq(Double.parseDouble(sectionSingle.get("index4").toString()));
				initList.add(ddsRdWdinit);
			}
		}
		if(constraintsData != null){
			WaterOptimumVOMap cons = jsonReader.readString(constraintsData);
			List<LinkedHashMap<String, Object>> constraints = (List<LinkedHashMap<String, Object>>) cons.get("index1");
			for(int i=0;i<constraints.size();i++){
				LinkedHashMap<String, Object> constraintsSingle = constraints.get(i);
				int ri = 1;
				while(constraintsSingle.get("index"+ri+"_co") != null){
					DdsRdWdcons ddsRdWdcons = new DdsRdWdcons();
					ddsRdWdcons.setProCd(plan.getProCd());
					ddsRdWdcons.setWceId(constraintsSingle.get("index"+ri+"_co").toString());
					ddsRdWdcons.setBgt(parseDate(constraintsSingle.get("time_s").toString()));
					ddsRdWdcons.setEdt(parseDate(constraintsSingle.get("time_e").toString()));
					ddsRdWdcons.setZmx(Double.parseDouble(constraintsSingle.get("index"+ri+"_1").toString()));
					ddsRdWdcons.setZmn(Double.parseDouble(constraintsSingle.get("index"+ri+"_2").toString()));
					ddsRdWdcons.setQmx(Double.parseDouble(constraintsSingle.get("index"+ri+"_3").toString()));
					ddsRdWdcons.setQmn(Double.parseDouble(constraintsSingle.get("index"+ri+"_4").toString()));
					ddsRdWdcons.setNmx(Double.parseDouble(constraintsSingle.get("index"+ri+"_5").toString()));
					ddsRdWdcons.setNmn(Double.parseDouble(constraintsSingle.get("index"+ri+"_6").toString()));
					consList.add(ddsRdWdcons);
					ri++;
				}
			}
		}
		//先清空以前的记录再插入
		DdsRdWdinit noUse1 = new DdsRdWdinit();
		noUse1.setProCd(plan.getProCd());
		DDS_RD_WDINIT.remove(noUse1);
		DdsRdWdcons noUse2 = new DdsRdWdcons();
		noUse2.setProCd(plan.getProCd());
		DDS_RD_WDCONS.remove(noUse2);
		ListService.save(initList, DDS_RD_WDINIT);
		ListService.save(consList, DDS_RD_WDCONS);
		sysLog("初始条件与约束条件保存完毕");
	}
	
	
	
	private List<SchemeRDispatchResult> runModel(DdsRdP plan, List<DdsRdWdinit> initList, List<DdsRdWdcons> constraintsList, List<DdsRdIfres> forecastList, List<DdsRdWares> allocateList) throws IOException {
		SchemeBean bean = newSchemeBean(plan);
		
		String configPath = "com/jsite/szy/dispatch/dispatchwo/model/FH0001.xml";
		if(plan.getRvCd().indexOf("03") >= 0){
			configPath = "com/jsite/szy/dispatch/dispatchwo/model/YH0001.xml";
		}
		Resource resource = new ClassPathResource(configPath);
		if (resource.isReadable()){
			InputStream is = resource.getInputStream();  
			RegularExcute re = new RegularExcute(is);
			is.close();
			
			SubjectRegularDispatch normalDispatch = re.getNormalDispatch();
			RegulaSchemeController schemeController = new RegulaSchemeController(normalDispatch);
			SchemeRegularDispatch scheme = schemeController.newScheme(bean);
			
		//	fillForecast(scheme, woch.getForecast());
			scheme.setForcastResults(fillForecast(forecastList, plan));
		//	scheme.setDemandResults(woch.getDemand());
			scheme.setAllocationResults(fillAllocate(allocateList, plan));
			
			List<SchemeRDispatchPara> para = fillDispatchPara(initList, constraintsList, plan);
		//	fillParameters(scheme, para);
			scheme.setDispatchParas(para);				
			
			WaterDispatchController dispatchController = new WaterDispatchController(normalDispatch);
			List<SchemeRDispatchResult> dispatchResults = dispatchController.execute(scheme, scheme.getForcastResults(), scheme.getAllocationResults(), scheme.getDispatchParas());
							
		//	System.out.println(dispatchResults);
			
			return dispatchResults;
		}
		else throw new RuntimeException("不可读的配置文件");
	}
	
	protected List<SchemeRDispatchPara> fillDispatchPara(List<DdsRdWdinit> initList, List<DdsRdWdcons> consList, DdsRdP plan){
		List<SchemeRDispatchPara> output = new ArrayList<>();
		
		Map<String, List<DdsRdWdcons>> consMap = new HashMap<>();
		for(DdsRdWdcons cons: consList){
			String entity = cons.getWceId();
			if(consMap.get(entity) == null)consMap.put(entity, new ArrayList<>());
			consMap.get(entity).add(cons);
		}
		
		for(DdsRdWdinit init: initList){
			if(init.getWceTp() == 1)continue;
			
			SchemeRDispatchPara srdp = new SchemeRDispatchPara();
			srdp.setSchemeId(plan.getProCd());
			srdp.setEntityId(init.getWceId().trim());
			srdp.setEntityName(eleMapping.queryByCode(init.getWceId()));
			srdp.setTimeStart(plan.getBgDt());
			srdp.setLevelBegin(init.getBgz());
			srdp.setLevelEnd(init.getEdz());
			
			List<DdsRdWdcons> consDetailList = consMap.get(init.getWceId());
			if(consDetailList != null && consDetailList.size()>0){
				List<DispatchConstraintItem> itemList = new ArrayList<>();
				
				for(DdsRdWdcons consDetail: consDetailList){
					DispatchConstraintItem dci = new DispatchConstraintItem();
					dci.setEntityId(consDetail.getWceId().trim());
					dci.setEntityName(eleMapping.queryByCode(consDetail.getWceId()));
					dci.setSchemeId(plan.getProCd());
					dci.setLevelMax(consDetail.getZmx());
					dci.setLevelMin(consDetail.getZmn());
					dci.setOutflowMax(consDetail.getQmx());
					dci.setOutflowMin(consDetail.getQmn());
					dci.setOutputMax(consDetail.getNmx());
					dci.setOutputMin(consDetail.getNmn());
					dci.setTimeStart(consDetail.getBgt());
					dci.setTimeEnd(consDetail.getEdt());
					itemList.add(dci);
				}
				
				srdp.setDispatchConstraints(itemList);
			}
			
			output.add(srdp);
		}
		
		return output;
	}
	
	protected List<SchemeRForcastResult> fillForecast(List<DdsRdIfres> list, DdsRdP plan){
		List<SchemeRForcastResult> output = new ArrayList<>();
		Map<String, List<DdsRdIfres>> sectionMap = new HashMap<>();
		
		for(int i=0;i<list.size();i++){
			DdsRdIfres single = list.get(i);
			String entityID = single.getSecCd();
			//只对方案时间区间内的时间项进行操作
			if(single.getBgtm() != null && single.getBgtm().getTime() >= plan.getBgDt().getTime() && single.getEdtm() != null && single.getEdtm().getTime() <= plan.getEdDt().getTime()){
				if(sectionMap.get(entityID) == null)sectionMap.put(entityID, new ArrayList<>());
				sectionMap.get(entityID).add(single);
			}
		}
		
		for(List<DdsRdIfres> section: sectionMap.values()){
			if(section != null && section.size()>0){
				SchemeRForcastResult srfr = new SchemeRForcastResult();
				srfr.setSchemeId(plan.getProCd());
				srfr.setEntityId(section.get(0).getSecCd());
				srfr.setEntityName(eleMapping.queryByCode(section.get(0).getSecCd()));
				
				Map<Date, DdsRdIfres> timelyMap = new TreeMap<>();
				for(int i=0;i<section.size();i++){
					DdsRdIfres temp = section.get(i);
					timelyMap.put(temp.getBgtm(), temp);
				}
				
				List<ForcastResultItem> itemList = new ArrayList<>();
				for(DdsRdIfres temp: timelyMap.values()){
					ForcastResultItem fri = new ForcastResultItem();
					fri.setSchemeId(temp.getProCd());
					fri.setEntityId(temp.getSecCd());
					fri.setEntityName(srfr.getEntityName());
					fri.setTimeStart(temp.getBgtm());
					fri.setTimeEnd(temp.getEdtm());
					fri.setFocastValue(temp.getForW());
					itemList.add(fri);
				}
				srfr.setForcastResults(itemList);
				output.add(srfr);
			}			
		}
		return output;
	}
	
	protected List<SchemeRAllocationResult> fillAllocate(List<DdsRdWares> list, DdsRdP plan){
		List<SchemeRAllocationResult> output = new ArrayList<>();
		//收集数据：因行政区数据无用，只选择用水单元数据
		Map<String, List<DdsRdWares>> adminMap = new HashMap<>();
		Map<String, List<DdsRdWares>> useWaterMap = new HashMap<>();		
				
		for(int i=0;i<list.size();i++){
			DdsRdWares layer01 = list.get(i);
			String entityID = layer01.getRegCd();
			//只对方案时间区间内的时间项进行操作
			if(layer01.getBt() != null && layer01.getBt().getTime() >= plan.getBgDt().getTime() && layer01.getEt() != null && layer01.getEt().getTime() <= plan.getEdDt().getTime()){
				if(entityID.length() < 7){
					if(adminMap.get(entityID) == null)adminMap.put(entityID, new ArrayList<>());
					adminMap.get(entityID).add(layer01);
				}
				else {
					if(useWaterMap.get(entityID) == null)useWaterMap.put(entityID, new ArrayList<>());
					useWaterMap.get(entityID).add(layer01);
				}
			}
		}
		//建立 行政区--用水单元 映射表
		Set<String> useWaterSet = useWaterMap.keySet();
		Map<String, List<String>> useWater_admin_Mapping = new HashMap<>();
		for(String text: useWaterSet){
			String adminStr = text.substring(0, 6);
			String riverStr = text.substring(6);
			if(useWater_admin_Mapping.get(adminStr) == null)useWater_admin_Mapping.put(adminStr, new ArrayList<>());
			useWater_admin_Mapping.get(adminStr).add(text);
		}

		//数据匹配
		for (Entry<String, List<String>> entry: useWater_admin_Mapping.entrySet()) {
		    String admin = entry.getKey();
		    List<String> useWaterList = entry.getValue();
		    
		    SchemeRAllocationResult srar = new SchemeRAllocationResult();
		    srar.setSchemeId(plan.getProCd());
		    srar.setEntityId(admin);
		    srar.setEntityName(eleMapping.queryByCode(admin));
	    	double sumAllocate = 0;
	    	double sumDeclare = 0;
		    
		    List<AllocationResult> arList = new ArrayList<>();
		    for(String useWater: useWaterList){
		    	AllocationResult ar = new AllocationResult();
		    	ar.setSchemeId(plan.getProCd());
		    	ar.setEntityId(useWater);
		    	ar.setEntityName(eleMapping.queryByCode(useWater));
		    	
		    	List<AllocationResultItem> allocateList = new ArrayList<>();
		    	List<AllocationResultItem> declareList = new ArrayList<>();
		    	List<DdsRdWares> alloc_need_List = useWaterMap.get(useWater);
		    	for(DdsRdWares single: alloc_need_List){
		    		double domestic = single.getDRs() + single.getURs() + single.getBhRs() + single.getShRs();
		    		double agricultural = single.getPwirRs() + single.getPdirRs() + single.getPvirRs() + single.getFiRs() + single.getAiRs() + single.getMfishRs();
		    		double industrial = single.getIndRs() + single.getNindRs();
		    		
		    		AllocationResultItem allocate = new AllocationResultItem();
		    		allocate.setAgriculturalWater(agricultural);
		    		allocate.setAI_RS(single.getAiRs());
		    		allocate.setBH_RS(single.getBhRs());
		    		allocate.setD_RS(single.getDRs());
		    		allocate.setDomesticWater(domestic);
		    		allocate.setEcologicalWater(0);
		    		allocate.setEntityId(single.getRegCd());
		    		allocate.setEntityName(eleMapping.queryByCode(single.getRegCd()));
		    		allocate.setFI_RS(single.getFiRs());
		    		allocate.setIND_RS(single.getIndRs());
		    		allocate.setIndustrialWater(industrial);
		    		allocate.setMFISH_RS(single.getMfishRs());
		    		allocate.setNIND_RS(single.getNindRs());
		    		allocate.setPDIR_RS(single.getPdirRs());
		    		allocate.setPVIR_RS(single.getPvirRs());
		    		allocate.setPWIR_RS(single.getPwirRs());
		    		allocate.setSchemeId(single.getProCd());
		    		allocate.setSH_RS(single.getShRs());
		    		allocate.setTimeEnd(single.getEt());
		    		allocate.setTimeStart(single.getBt());
		    		allocate.setTOT_RS(single.getTotRs());
		    		allocate.setU_RS(single.getURs());
		    		if(single.getRsTp() == 1){
		    			allocateList.add(allocate);
		    			sumAllocate += single.getTotRs();
		    		}
		    		else {
		    			declareList.add(allocate);
		    			sumDeclare += single.getTotRs();
		    		}
		    	}
		    	Collections.sort(allocateList, new Comparator<AllocationResultItem>() {
					@Override
					public int compare(AllocationResultItem o1, AllocationResultItem o2) {
						// TODO Auto-generated method stub
						return o1.getTimeStart().compareTo(o2.getTimeStart());
					}
				});
		    	Collections.sort(declareList, new Comparator<AllocationResultItem>() {
					@Override
					public int compare(AllocationResultItem o1, AllocationResultItem o2) {
						// TODO Auto-generated method stub
						return o1.getTimeStart().compareTo(o2.getTimeStart());
					}
				});
		    	ar.setAllocatedWaters(allocateList);
		    	ar.setDeclareWaters(declareList);
		    	for(int i=0;i<allocateList.size();i++){
		    		System.out.println(allocateList.get(i).getTimeStart());
		    	}
		    	System.out.println("++++++++++++++++++++++=");
		    	for(int i=0;i<declareList.size();i++){
		    		System.out.println(declareList.get(i).getTimeStart());
		    	}
		    	arList.add(ar);
		    }
		    srar.setAllocationResults(arList);
		    srar.setAllocatedWater(sumAllocate);
		    srar.setDeclareWater(sumDeclare);
		    srar.setDeltaWater(sumDeclare - sumAllocate);
		    output.add(srar);
		}
		return output;
	}

	protected void saveResults(DdsRdP plan, List<SchemeRDispatchResult> results) {
		String schemeID = plan.getProCd();
		resultRepair(results);
		List<DdsRdWdres> wdresList = new ArrayList<>();
		List<DdsRdWdwun> wdwunsList = new ArrayList<>();
		for(int i=0;i<results.size();i++){
			SchemeRDispatchResult layer01 = results.get(i);
			String entityID = layer01.getEntityId();
			String entityName = layer01.getEntityName();
			int type = layer01.getType();
			List<DispatchResultItem> details = layer01.getDispatchResults();			
			for(int j=0;j<details.size();j++){
				DispatchResultItem dri = details.get(j);				
				DdsRdWdres dds = new DdsRdWdres();
				dds.setProCd(schemeID);
				dds.setWceId(entityID);
				dds.setWceTp(type);
				dds.setBt(dri.getTimeStart());
				dds.setEt(dri.getTimeEnd());
				dds.setBz(dri.getLevelBegin());
				dds.setEz(dri.getLevelEnd());
				dds.setAz(dri.getAverageLevel());
				dds.setInq(dri.getInflow());
				dds.setDw(dri.getOutflow());
				dds.setAq(dri.getAverageFlow());
				dds.setDq(dri.getDesertflow());
				dds.setWsv(dri.getDeltaStorage());
				dds.setAw(dri.getAllocatedWater());
				dds.setWw(dri.getSuppliedWater());
				dds.setRw(dri.getReturnedWater());
				dds.setLw(dri.getDeficitdWater());
				dds.setFr(dri.getSuppliedWaterRate());
				dds.setMinEdw(dri.getEcologicalflow());
				dds.setEg(dri.getGeneration());
				dds.setN(dri.getOutput());
				dds.setH(dri.getWaterHead());
				wdresList.add(dds);
				
				AllocationResultItem allocatedItem = dri.getAllocatedItem();
				AllocationResultItem deficitdItem = dri.getDeficitdItem();
				AllocationResultItem suppliedItem = dri.getSuppliedItem();
				
				DdsRdWdwun wun = new DdsRdWdwun();
				wun.setProCd(schemeID);
				wun.setRegId(entityID);
				wun.setBt(dri.getTimeStart());
				wun.setEt(dri.getTimeEnd());
				wun.setMonth(getMonth(dri.getTimeStart()));
				wun.setLifeAw(allocatedItem.getDomesticWater());
				wun.setArgAw(allocatedItem.getAgriculturalWater());
				wun.setIndAw(allocatedItem.getIndustrialWater());
				wun.setLifeWw(suppliedItem.getDomesticWater());
				wun.setAgrWw(suppliedItem.getAgriculturalWater());
				wun.setIndWw(suppliedItem.getIndustrialWater());
				wun.setLifeLw(deficitdItem.getDomesticWater());
				wun.setAgrLw(deficitdItem.getAgriculturalWater());
				wun.setIndLw(deficitdItem.getIndustrialWater());
				wdwunsList.add(wun);
			}
		//	System.out.println(entityID+"\t"+entityName+"\t"+type);
		}
		//先清空以前的记录再插入
		DdsRdWdres noUse1 = new DdsRdWdres();
		noUse1.setProCd(schemeID);
		DDS_RD_WDRES.remove(noUse1);
		DdsRdWdwun noUse2 = new DdsRdWdwun();
		noUse2.setProCd(schemeID);
		DDS_RD_WDWUN.remove(noUse2);
		ListService.save(wdresList, DDS_RD_WDRES);
		ListService.save(wdwunsList, DDS_RD_WDWUN);
		plan.setSta(4);
		DDS_RD_P.update(plan);
	}
	
	public void resultRepair(List<SchemeRDispatchResult> results){
		int line = 0;
		for(int i=0;i<results.size();i++){
			SchemeRDispatchResult srdr = results.get(i);
			int srdrType = srdr.getType();
			if(srdrType == 2){
				List<DispatchResultItem> srdrList = srdr.getDispatchResults();
				for(int j=0;j<srdrList.size();j++){
					DispatchResultItem dri = srdrList.get(j);
					AllocationResultItem allList = dri.getAllocatedItem();
					dri.setAllocatedWater(allList.getAgriculturalWater()+allList.getDomesticWater()+allList.getEcologicalWater()+allList.getIndustrialWater());
					AllocationResultItem supList = dri.getSuppliedItem();
					dri.setSuppliedWater(supList.getAgriculturalWater()+supList.getDomesticWater()+supList.getEcologicalWater()+supList.getIndustrialWater());
					line++;
				}
			}
		}
		sysLog("edited "+line+" lines...");
	}
	
	public WaterOptimumVOMap readResult(String schemeId){
		TestPlan plan = new TestPlan(schemeId, DDS_RD_P);
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/jsite/szy/dispatch/dispatchwo/model/FHmod.xml");
		WODisplayConvert wodc = (WODisplayConvert) context.getBean("data");
		context.close();*/
		DdsRdWdcons noUse1 = new DdsRdWdcons();
		noUse1.setProCd(schemeId);
		List<DdsRdWdcons> consList = DDS_RD_WDCONS.list(noUse1);
		DdsRdWdres noUse2 = new DdsRdWdres();
		noUse2.setProCd(schemeId);
		List<DdsRdWdres> resultList = DDS_RD_WDRES.list(noUse2);
		DdsRdWdwun noUse3 = new DdsRdWdwun();
		noUse3.setProCd(schemeId);
		List<DdsRdWdwun> detailList = DDS_RD_WDWUN.list(noUse3);
		
		WaterOptimumVOMap output = new WaterOptimumVOMap();
		//结果拼装
		WOResult woResult = new WOResult(plan.getPlan());
		WOReservoir woReservoir = new WOReservoir();
		WOUseWater woUseWater = new WOUseWater(plan.getPlan());
		WOSection woSection = new WOSection();
		//水库显示用约束条件
		woReservoir.setConstraints(consList);
		
		List<DdsRdWdres> wdresList = resultList;
		for(int i=0;i<wdresList.size();i++){
			DdsRdWdres wdresSingle = wdresList.get(i);
			//type value-----0:水库  1:河道  2:用水单元 3:断面 4:汇口
			int type = wdresSingle.getWceTp();
			if(type == 0){
				woResult.add(wdresSingle);
				woReservoir.add(wdresSingle);
			}
			else if(type == 1){
				// do nothing
				woResult.add(wdresSingle);
			}
			else if(type == 2){
				woResult.add(wdresSingle);
				woUseWater.add(wdresSingle);
			}
			else if(type == 3){
				woResult.add(wdresSingle);
				woSection.add(wdresSingle);
			}
			else if(type == 4){
				// do nothing
				woResult.add(wdresSingle);
			}			
		}
		woUseWater.setAllocate(detailList);
		//装填
		output.put("index1", woResult.brief());
		output.put("index2", woUseWater.administrative());
		output.put("index3", woUseWater.waterarea());
		output.put("index4", woUseWater.usewaterUnit());
		output.put("index6", woReservoir.statistics());
		output.put("index8", woReservoir.single());
		return output;
	}
	
	protected int getMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH) + 1;
		return month;
	}

	public static String displayTime(Date start, Date end){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String output = month + "月";
		
		long mix = end.getTime() - start.getTime();
		long compare = 15 * 24 * 60 * 60 * 1000;
		if(mix < compare){
			if(day < 10)output += "上旬";
			else if(day < 20)output += "中旬";
			else output += "下旬";
		}
		return output;
	}
	
	public static Date parseDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	protected SchemeBean newSchemeBean(DdsRdP plan){
		SchemeBean bean = new SchemeBean();
		if(plan.getProCd() != null && !plan.getProCd().equals("")){
			bean.setId(plan.getProCd());			
			if(plan.getProTp().indexOf("2") >= 0){
				bean.setType(SchemeTypeEnum.REGULAR_YEAR);
			}
			else if(plan.getProTp().indexOf("3") >= 0){
				bean.setType(SchemeTypeEnum.REGULAR_XUN);
			}
			else {			
				bean.setType(SchemeTypeEnum.REGULAR_YEAR);
			}			
			bean.setName(plan.getProNm());
			bean.setTimeStart(plan.getBgDt());
			bean.setTimeEnd(plan.getEdDt());
			bean.setComment(plan.getNt());
			return bean;
		}
		else return null;
	}
	
	public void sysLog(String text){
		System.out.println(text);
	}
}
