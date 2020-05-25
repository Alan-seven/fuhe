package com.jsite.szy.dispatch.dispatchwo.data;

/**
 * 供水统计器
 * @author ferry
 *
 */
public class WOWaterSupplyAdder {
	private String entityID;
	private WOStatistics allocateList;
	private WOStatistics supplyList;
	private WOStatistics lackList;
	
	public WOWaterSupplyAdder(String entityID) {
		this.entityID = entityID;
		allocateList = new WOStatistics();
		supplyList = new WOStatistics();
		lackList = new WOStatistics();
	}
	
	public void add(Double allocate, Double supply, Double lack){
		allocateList.add(allocate);
		supplyList.add(supply);
		lackList.add(lack);
	}
	
	public Double getAllocate(){
		return allocateList.sum();
	}
	
	public Double getSupply(){
		return supplyList.sum();
	}
	
	public Double getLack(){
		return lackList.sum();
	}

	public String getEntityID() {
		return entityID;
	}

	public void setEntityID(String entityID) {
		this.entityID = entityID;
	}
	
}
