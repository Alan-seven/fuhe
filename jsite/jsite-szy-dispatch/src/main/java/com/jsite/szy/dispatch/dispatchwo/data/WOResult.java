package com.jsite.szy.dispatch.dispatchwo.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.busi.szy.dispatch.po.DdsRdWdres;
import com.jsite.szy.dispatch.dispatchwo.service.WaterOptimumService;
import com.jsite.szy.dispatch.dispatchwo.vo.WaterOptimumVOMap;

public class WOResult {
	private List<DdsRdWdres> data;
	private WOJsonReader jsonReader;
	private WaterOptimumVOMap bone;
	
	public WOResult(DdsRdP ddsRdP) {
		data = new ArrayList<>();
		jsonReader = new WOJsonReader();
		if(ddsRdP.getRvCd().indexOf("03") >= 0){
			bone = jsonReader.read("bone_resultyh.json");
		}
		else bone = jsonReader.read("bone_result.json");
	}
	
	public void add(DdsRdWdres single){
		data.add(single);
	}
	
	public WaterOptimumVOMap brief(){
		WaterOptimumVOMap output = new WaterOptimumVOMap();
		output.put("index1", gridHeader());
		output.put("index2", output());
		return output;
	}
	
	protected List<WaterOptimumVOMap> gridHeader(){		
		List<LinkedHashMap<String, Object>> cols = (List<LinkedHashMap<String, Object>>) bone.get("columns");
		List<WaterOptimumVOMap> gridHeader = new ArrayList<>();
		for(int i=0;i<cols.size();i++){
			LinkedHashMap<String, Object> single = cols.get(i);
			WaterOptimumVOMap singleOutput = new WaterOptimumVOMap();
			if(single.get("hidden") != null && (boolean)single.get("hidden") == true)continue;
			singleOutput.put("id", single.get("id"));
			singleOutput.put("text", single.get("text"));
			singleOutput.put("type", single.get("type"));
			gridHeader.add(singleOutput);
		}
		return gridHeader;
	}
	
	protected List<WaterOptimumVOMap> output(){
		List<WaterOptimumVOMap> output = new ArrayList<>();
	//	Map<String, List<DdsRdWdres>> useWaterMap = new HashMap<>();
		Map<Date, Map<String, DdsRdWdres>> dateMap = new TreeMap<>();
		for(int i=0;i<data.size();i++){
			DdsRdWdres single = data.get(i);
			String entityID = single.getWceId();
			Date time = single.getBt();
			if(dateMap.get(time) == null)dateMap.put(time, new HashMap<>());
			Map<String, DdsRdWdres> useWaterMap = dateMap.get(time);
			useWaterMap.put(entityID, single);
		//	if(useWaterMap.get(entityID) == null)useWaterMap.put(entityID, new ArrayList<>());
		//	useWaterMap.get(entityID).add(single);
		}
		
		List<LinkedHashMap<String, Object>> cols = (List<LinkedHashMap<String, Object>>) bone.get("columns");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		for (Entry<Date, Map<String, DdsRdWdres>> entry: dateMap.entrySet()) {
			Date key = entry.getKey();
			Map<String, DdsRdWdres> map = entry.getValue();
			
			WaterOptimumVOMap wo = new WaterOptimumVOMap();
			Date endTime = null;
			
			for(int i=0;i<cols.size();i++){
				LinkedHashMap<String, Object> single = cols.get(i);
				String id = single.get("id").toString();
				String text = single.get("text").toString();
				String type = single.get("type").toString();
				List<LinkedHashMap<String, Object>> sub = (List<LinkedHashMap<String, Object>>) single.get("sub");
				
				if (type.equals("section")) {
					double inflow = 0;
					for (int p = 0; p < sub.size(); p++) {
						String ref = sub.get(p).get("ref").toString();
						DdsRdWdres temp = map.get(ref);
						inflow += temp.getInq();
					}
					wo.put(id + "_inflow", inflow);
				} else if (type.equals("usewater")) {
					double allocate = 0;
					double supply = 0;
					double lack = 0;
					double lackRate = 0;
					for (int p = 0; p < sub.size(); p++) {
						String ref = sub.get(p).get("ref").toString();
						DdsRdWdres temp = map.get(ref);
						if(endTime == null)endTime = temp.getEt();
						allocate += temp.getAw();
						supply += temp.getWw();
						lack += temp.getLw();
					}
					lackRate = lack / allocate;
					wo.put(id + "_allocate", allocate);
					wo.put(id + "_supply", supply);
					wo.put(id + "_lack", lack);
					wo.put(id + "_lackRate", lackRate);					
				} else if (type.equals("reservoir")) {
					double inflow = 0;
					double level = 0;
					double outflow = 0;
					for (int p = 0; p < sub.size(); p++) {
						String ref = sub.get(p).get("ref").toString();
						DdsRdWdres temp = map.get(ref);
						inflow += temp.getInq();
						level += temp.getEz();
						outflow += temp.getDw();
						
					}
					wo.put(id + "_inflow", inflow);
					wo.put(id + "_level", level);
					wo.put(id + "_outflow", outflow);
				}
				
			}
			wo.put("index1", WaterOptimumService.displayTime(key, endTime));
			wo.put("time_s", df.format(key));
			wo.put("time_e", df.format(endTime));
			output.add(wo);
		}
		return output;
	}
}
