package com.jsite.szy.dispatch.dispatchwo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.jsite.busi.szy.dispatch.po.DdsRdIfres;
import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.szy.dispatch.dispatchwo.data.WOJsonReader;
import com.jsite.szy.dispatch.dispatchwo.vo.WaterOptimumVOMap;

public class InflowConverter {
	private WaterOptimumVOMap bone;
	private List<DdsRdIfres> data;
	private DdsRdP plan;
	
	public InflowConverter(String path, List<DdsRdIfres> data, DdsRdP plan) {
		bone = new WOJsonReader().readPath(path);
		this.data = data;
		this.plan = plan;
	}
	
	public List<DdsRdIfres> output(){
		List<DdsRdIfres> output = new ArrayList<>();
		
		Map<Date, Map<String, DdsRdIfres>> dateMap = new TreeMap<>();
		Map<Date, Date> endTimeMap = new TreeMap<>();
		for(int i=0;i<data.size();i++){
			DdsRdIfres single = data.get(i);
			Date start = single.getBgtm();
			if(single.getBgtm() != null && single.getBgtm().getTime() >= plan.getBgDt().getTime() && single.getEdtm() != null && single.getEdtm().getTime() <= plan.getEdDt().getTime()){
				if(dateMap.get(start) == null)dateMap.put(start, new HashMap<>());
				dateMap.get(start).put(single.getSecCd(), single);
				
				if(endTimeMap.get(start) == null)endTimeMap.put(start, single.getEdtm());
			}
			
		}
		
		List<LinkedHashMap<String, Object>> sites = (List<LinkedHashMap<String, Object>>) bone.get("data");
		for(int i=0;i<sites.size();i++){
			LinkedHashMap<String, Object> single = sites.get(i);
			String ref = (String) single.get("ref");
			String comment = (String) single.get("comment");
			if(single.get("value") == null){
				List<LinkedHashMap<String, Object>> fomula = (List<LinkedHashMap<String, Object>>) single.get("formula");
				
				for(Entry<Date, Map<String, DdsRdIfres>> entry : dateMap.entrySet()){
					Date key = entry.getKey();
					Map<String, DdsRdIfres> value = entry.getValue();
					Date end = endTimeMap.get(key);
					
					double sum = 0;
					for(int j=0;j<fomula.size();j++){
						LinkedHashMap<String, Object> item = fomula.get(j);
						String itemRef = (String) item.get("ref");
						double multiple = (double) item.get("multiple");
						if(value.get(itemRef) == null)continue;
						sum += multiple * value.get(itemRef).getForW();
					}
					//TODO Start 将值强行归正
					sum = Math.abs(sum);
					//TODO End
					
					DdsRdIfres temp = new DdsRdIfres();
					temp.setProCd(plan.getProCd());
					temp.setSecCd(ref);
					temp.setBgtm(key);
					temp.setEdtm(end);
					temp.setForW(sum);
					output.add(temp);
				}
			}
			else{
				for(Date start: dateMap.keySet()){
					DdsRdIfres temp = new DdsRdIfres();
					temp.setProCd(plan.getProCd());
					temp.setSecCd(ref);
					temp.setBgtm(start);
					temp.setEdtm(endTimeMap.get(start));
					temp.setForW(Double.parseDouble(single.get("value").toString()));
					output.add(temp);
				}
			}
		}
		
		return output;
	}
}
