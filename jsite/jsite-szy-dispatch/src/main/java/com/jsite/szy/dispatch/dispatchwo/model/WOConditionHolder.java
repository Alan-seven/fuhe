package com.jsite.szy.dispatch.dispatchwo.model;

import java.util.List;

import com.wrms.core.scheme.regular.SchemeRAllocationResult;
import com.wrms.core.scheme.regular.SchemeRDemandResult;
import com.wrms.core.scheme.regular.SchemeRDispatchPara;
import com.wrms.core.scheme.regular.SchemeRForcastResult;

public class WOConditionHolder {
	private List<SchemeRForcastResult> forecast;
	private List<SchemeRDemandResult> demand;
	private List<SchemeRAllocationResult> allocation;
	private List<SchemeRDispatchPara> dispatchPara;
	
	public List<SchemeRForcastResult> getForecast() {
		return forecast;
	}
	public void setForecast(List<SchemeRForcastResult> forecast) {
		this.forecast = forecast;
	}
	public List<SchemeRDemandResult> getDemand() {
		return demand;
	}
	public void setDemand(List<SchemeRDemandResult> demand) {
		this.demand = demand;
	}
	public List<SchemeRAllocationResult> getAllocation() {
		return allocation;
	}
	public void setAllocation(List<SchemeRAllocationResult> allocation) {
		this.allocation = allocation;
	}
	public List<SchemeRDispatchPara> getDispatchPara() {
		return dispatchPara;
	}
	public void setDispatchPara(List<SchemeRDispatchPara> dispatchPara) {
		this.dispatchPara = dispatchPara;
	}	
}
