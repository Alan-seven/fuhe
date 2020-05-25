package com.jsite.szy.dispatch.dispatchwo.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.busi.szy.dispatch.po.DdsRdWdres;
import com.jsite.busi.szy.dispatch.po.DdsRdWdwun;
import com.jsite.szy.dispatch.dispatchwo.model.ELEMapping;
import com.jsite.szy.dispatch.dispatchwo.service.WaterOptimumService;
import com.jsite.szy.dispatch.dispatchwo.vo.WaterOptimumVOMap;

public class WOUseWater {
	private DdsRdP plan;
	private List<DdsRdWdres> data;
	private List<DdsRdWdwun> allocate;
	
	public WOUseWater(DdsRdP plan) {
		this.plan = plan;
		data = new ArrayList<>();
	}
	
	public void add(DdsRdWdres single){
		data.add(single);
	}
	
	public void setAllocate(List<DdsRdWdwun> allocateList){
		this.allocate = allocateList;
	}
	
	public List<WaterOptimumVOMap> administrative(){
		List<WaterOptimumVOMap> output = new ArrayList<>();
		Map<String, WOWaterSupplyAdder> countUse = new HashMap<>();
		ELEMapping eleMapping = new ELEMapping();		
		for(int i=0;i<data.size();i++){
			DdsRdWdres single = data.get(i);
			String entityID = single.getWceId().substring(0, 13);			
			if(countUse.get(entityID) == null)countUse.put(entityID, new WOWaterSupplyAdder(entityID));
			countUse.get(entityID).add(single.getAw(), single.getWw(), single.getLw());
		}
		
		for(WOWaterSupplyAdder adder: countUse.values()){
			String entityID = adder.getEntityID();
			String admin = entityID.substring(0, 6);
			String area = entityID.substring(6);
			
			double allocate = adder.getAllocate();
			double supply = adder.getSupply();
			double lack = adder.getLack();
			double lackRate = lack/allocate;
			
			WaterOptimumVOMap record = new WaterOptimumVOMap();
			record.put("index1", eleMapping.queryByCode(admin));
			record.put("index2", eleMapping.queryByCode(area));
			record.put("index3", allocate);
			record.put("index4", supply);
			record.put("index5", lack);
			record.put("index6", lackRate);
			output.add(record);
		}
		return output;
	}
	
	public List<WaterOptimumVOMap> waterarea(){
		List<WaterOptimumVOMap> output = new ArrayList<>();
		Map<String, WOWaterSupplyAdder> countUse = new HashMap<>();
		ELEMapping eleMapping = new ELEMapping();		
		for(int i=0;i<data.size();i++){
			DdsRdWdres single = data.get(i);
			String entityID = single.getWceId();
			String admin = entityID.substring(0, 6);
			String area = entityID.substring(6, 13);
			
			if(countUse.get(area) == null)countUse.put(area, new WOWaterSupplyAdder(area));
			countUse.get(area).add(single.getAw(), single.getWw(), single.getLw());
		}
		
		for(WOWaterSupplyAdder adder: countUse.values()){
			String entityID = adder.getEntityID();
		//	String admin = entityID.substring(0, 6);
		//	String area = entityID.substring(6);
			
			double allocate = adder.getAllocate();
			double supply = adder.getSupply();
			double lack = adder.getLack();
			double lackRate = lack/allocate;
			
			WaterOptimumVOMap record = new WaterOptimumVOMap();
			record.put("index1", eleMapping.queryByCode(entityID));
			record.put("index3", allocate);
			record.put("index4", supply);
			record.put("index5", lack);
			record.put("index6", lackRate);
			output.add(record);
		}
		return output;
	}
	
	public List<WaterOptimumVOMap> usewaterUnit(){
		List<WaterOptimumVOMap> output = new ArrayList<>();
		//先分类用水单元数据
		Map<Date, List<DdsRdWdwun>> useWaterMap = new TreeMap<>();
		for(int i=0;i<allocate.size();i++){
			DdsRdWdwun layer01 = allocate.get(i);
			Date time = layer01.getBt();
			if(useWaterMap.get(time) == null)useWaterMap.put(time, new ArrayList<>());
			useWaterMap.get(time).add(layer01);
		}		
		//统计数据
		for (Entry<Date, List<DdsRdWdwun>> entry: useWaterMap.entrySet()) {
			Date key = entry.getKey();
			List<DdsRdWdwun> map = entry.getValue();
			WaterOptimumVOMap wo = new WaterOptimumVOMap();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date endTime = null;
			//需 供 缺 率
			double[] agriculture = new double[4];
			double[] industry = new double[4];
			double[] domestic = new double[4];
			double[] ecology = new double[4];
			double[] total = new double[4];
			
			for(DdsRdWdwun single: map){
				if(endTime == null)endTime = single.getEt();
				agriculture[0] += single.getArgAw();
				industry[0] += single.getIndAw();
				domestic[0] += single.getLifeAw();
				ecology[0] += 0;

				agriculture[1] += single.getAgrWw();
				industry[1] += single.getIndWw();
				domestic[1] += single.getLifeWw();
				ecology[1] += 0;
			}
			total[0] += agriculture[0]+industry[0]+domestic[0]+ecology[0];
			total[1] += agriculture[1]+industry[1]+domestic[1]+ecology[1];
			agriculture[2] = agriculture[0] - agriculture[1];
			industry[2] = industry[0] - industry[1];
			domestic[2] = domestic[0] - domestic[1];
			ecology[2] = ecology[0] - ecology[1];
			total[2] = total[0] - total[1];
			
			wo.put("index1", WaterOptimumService.displayTime(key, endTime));
			wo.put("time_s", df.format(key));
			wo.put("time_e", df.format(endTime));
			wo.put("index2", agriculture[0]);
			wo.put("index3", agriculture[1]);
			wo.put("index4", agriculture[2]);
			wo.put("index5", agriculture[3]);
			wo.put("index6", industry[0]);
			wo.put("index7", industry[1]);
			wo.put("index8", industry[2]);
			wo.put("index9", industry[3]);
			wo.put("index10", domestic[0]);
			wo.put("index11", domestic[1]);
			wo.put("index12", domestic[2]);
			wo.put("index13", domestic[3]);
			wo.put("index14", ecology[0]);
			wo.put("index15", ecology[1]);
			wo.put("index16", ecology[2]);
			wo.put("index17", ecology[3]);
			wo.put("index18", total[0]);
			wo.put("index19", total[1]);
			wo.put("index20", total[2]);
			wo.put("index21", total[3]);
			output.add(wo);
		}
		
		return output;
	}
}
