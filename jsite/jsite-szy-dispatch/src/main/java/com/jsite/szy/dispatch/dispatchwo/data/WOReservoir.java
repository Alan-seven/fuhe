package com.jsite.szy.dispatch.dispatchwo.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.jsite.busi.szy.dispatch.po.DdsRdWdcons;
import com.jsite.busi.szy.dispatch.po.DdsRdWdres;
import com.jsite.szy.dispatch.dispatchwo.model.ELEMapping;
import com.jsite.szy.dispatch.dispatchwo.service.WaterOptimumService;
import com.jsite.szy.dispatch.dispatchwo.vo.WaterOptimumVOMap;

public class WOReservoir {
	private List<DdsRdWdres> data;
	private List<DdsRdWdcons> constraints;
	
	public WOReservoir() {
		data = new ArrayList<>();
	}
	
	public void add(DdsRdWdres single){
		data.add(single);
	}
	
	public WaterOptimumVOMap statistics(){
		WaterOptimumVOMap output = new WaterOptimumVOMap();
		ELEMapping eleMapping = new ELEMapping();	
		List<WaterOptimumVOMap> index2 = new ArrayList<>();
		Map<Date, WOReservoirAdder> reservoirMap = new HashMap<>();
		Set<String> reservoirSet = new TreeSet<>();
		for(int i=0;i<data.size();i++){
			DdsRdWdres single = data.get(i);			
			Date time = single.getBt();
			if(reservoirMap.get(time) == null)reservoirMap.put(time, new WOReservoirAdder(time, single.getEt()));
			reservoirMap.get(time).put(single.getWceId(), single.getWsv());
			reservoirSet.add(single.getWceId());
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		for(WOReservoirAdder adder: reservoirMap.values()){
			WaterOptimumVOMap record = new WaterOptimumVOMap();
			record.put("index1", WaterOptimumService.displayTime(adder.getTime(), adder.getEndTime()));
			record.put("time_s", df.format(adder.getTime()));
			record.put("time_e", df.format(adder.getEndTime()));
			int index = 2;
			for(String reservoir: reservoirSet){
				record.put("index"+index, adder.get(reservoir));
				index++;
			}
			index2.add(record);
		}
		//装填数据
		Object[] eid = reservoirSet.toArray();
		String[] reservoirNames = new String[eid.length];
		for(int i=0;i<eid.length;i++){
			reservoirNames[i] = eleMapping.queryByCode(eid[i].toString());
		}
		output.put("index1", reservoirNames);
		Collections.sort(index2, new Comparator<WaterOptimumVOMap>() {

			@Override
			public int compare(WaterOptimumVOMap o1, WaterOptimumVOMap o2) {
				// TODO Auto-generated method stub
				return ((String) o1.get("time_s")).compareTo((String) o2.get("time_s"));
			}
		});
		output.put("index2", index2);
		return output;
	}
	
	public WaterOptimumVOMap single(){
		WaterOptimumVOMap output = new WaterOptimumVOMap();
		ELEMapping eleMapping = new ELEMapping();	
		Map<Date, WOReservoirAdder> reservoirMap = new HashMap<>();
		Set<String> reservoirSet = new TreeSet<>();
		for(int i=0;i<data.size();i++){
			DdsRdWdres single = data.get(i);
			Date time = single.getBt();
			if(reservoirMap.get(time) == null)reservoirMap.put(time, new WOReservoirAdder(time, single.getEt()));
			reservoirMap.get(time).put(single.getWceId()+"_level", single.getBz());
			reservoirMap.get(time).put(single.getWceId()+"_inflow", single.getInq());
			reservoirMap.get(time).put(single.getWceId()+"_outflow", single.getDw());
			reservoirSet.add(single.getWceId());
		}
		for(int i=0;i<constraints.size();i++){
			DdsRdWdcons single = constraints.get(i);
			Date time = single.getBgt();
			if(reservoirMap.get(time) != null){
				reservoirMap.get(time).put(single.getWceId()+"_levelMax", single.getZmx());
				reservoirMap.get(time).put(single.getWceId()+"_levelMin", single.getZmn());
			}
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//装填数据
		Object[] eid = reservoirSet.toArray();
		String[] reservoirNames = new String[eid.length];
		for(int i=0;i<eid.length;i++){
			reservoirNames[i] = eleMapping.queryByCode(eid[i].toString());
		}
		
		output.put("index1", reservoirNames);
		int index = 2;
		for(String reservoir: reservoirSet){
			List<WaterOptimumVOMap> timelyList = new ArrayList<>();
			for(WOReservoirAdder adder: reservoirMap.values()){
				WaterOptimumVOMap record = new WaterOptimumVOMap();
				record.put("index1", WaterOptimumService.displayTime(adder.getTime(), adder.getEndTime()));
				record.put("time_s", df.format(adder.getTime()));
				record.put("time_e", df.format(adder.getEndTime()));
				record.put("index2", adder.get(reservoir+"_inflow"));
				record.put("index3", adder.get(reservoir+"_outflow"));
				record.put("index4", adder.get(reservoir+"_level"));
				record.put("index5", adder.get(reservoir+"_levelMax"));
				record.put("index6", adder.get(reservoir+"_levelMin"));
				timelyList.add(record);
			}
			Collections.sort(timelyList, new Comparator<WaterOptimumVOMap>() {

				@Override
				public int compare(WaterOptimumVOMap o1, WaterOptimumVOMap o2) {
					// TODO Auto-generated method stub
					return ((String) o1.get("time_s")).compareTo((String) o2.get("time_s"));
				}
			});
			output.put("index"+index, timelyList);
			index++;
		}
		return output;
	}

	public List<DdsRdWdcons> getConstraints() {
		return constraints;
	}

	public void setConstraints(List<DdsRdWdcons> constraints) {
		this.constraints = constraints;
	}	
	
}
