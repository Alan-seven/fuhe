package com.jsite.szy.dispatch.emergency.vo;

import com.jsite.core.web.PageVO;

/**
 * 应急调度模型计算地图结果Entity
 * @author hjx
 * @version 2017-08-11
 */
public class DdsEdGisVO extends PageVO{

	private String proCd;
	private Integer rcd;
	private Integer time; // 时刻值：0、1、2h
    private Integer fid;
	private double planValue;
	private double realValue;
	
	public DdsEdGisVO(){
		
	}
	
	public String getProCd() {
		return proCd;
	}
	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	public Integer getRcd() {
		return rcd;
	}
	public void setRcd(Integer rcd) {
		this.rcd = rcd;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public double getPlanValue() {
		return planValue;
	}
	public void setPlanValue(double planValue) {
		this.planValue = planValue;
	}
	public double getRealValue() {
		return realValue;
	}
	public void setRealValue(double realValue) {
		this.realValue = realValue;
	}
	
	
}
