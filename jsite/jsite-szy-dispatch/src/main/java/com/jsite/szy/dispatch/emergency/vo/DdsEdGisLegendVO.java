package com.jsite.szy.dispatch.emergency.vo;

import com.jsite.core.web.PageVO;

/**
 * 应急调度地图色彩分级Entity
 * @author hjx
 * @version 2017-06-12
 */
public class DdsEdGisLegendVO extends PageVO{

	private String  proCd;
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
