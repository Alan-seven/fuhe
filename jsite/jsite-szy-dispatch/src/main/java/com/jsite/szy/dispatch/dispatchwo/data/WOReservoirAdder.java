package com.jsite.szy.dispatch.dispatchwo.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 水库信息计数器
 * @author ferry
 *
 */
public class WOReservoirAdder {
	private Date time;
	private Date endTime;
	private Map<String, Double> valueMap;
	
	public WOReservoirAdder(Date time, Date endTime) {
		this.time = time;
		this.endTime = endTime;
		valueMap = new HashMap<>();
	}
	
	public void put(String entityID, Double value){
		valueMap.put(entityID, value);
	}
	
	public Double get(String entityID){
		return valueMap.get(entityID);
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
