package com.jsite.busi.szy.emergency.po;

import com.jsite.dao.AbstractData;

/**
 * 应急调度地图色彩分级Entity
 * @author hjx
 * @version 2017-10-30
 */
public class DdsEdGisLegend extends AbstractData<DdsEdGisLegend>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String proCd;
	private Double gmax;
	private Double gmin;
	public String getProCd() {
		return proCd;
	}
	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	public Double getGmax() {
		return gmax;
	}
	public void setGmax(Double gmax) {
		this.gmax = gmax;
	}
	public Double getGmin() {
		return gmin;
	}
	public void setGmin(Double gmin) {
		this.gmin = gmin;
	}
	
	
	
}
