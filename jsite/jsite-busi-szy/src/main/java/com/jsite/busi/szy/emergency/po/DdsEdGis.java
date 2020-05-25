package com.jsite.busi.szy.emergency.po;

import com.jsite.dao.AbstractData;

/**
 * 应急调度模型计算地图结果Entity
 * @author hjx
 * @version 2017-08-11
 */
public class DdsEdGis extends AbstractData<DdsEdGis>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String proCd;	//方	案编码
	private Integer rcd;		//河段编码
	private Integer time; // 时刻值：0、1、2h
    private Integer fid;
	private Double planValue;		//计划值
	private Double realValue;		//实际值
	
	public DdsEdGis(){
		super();
	}
	
	public DdsEdGis(String id){
		super(id);
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

	public Double getPlanValue() {
		return planValue;
	}
	public void setPlanValue(Double planValue) {
		this.planValue = planValue;
	}
	public Double getRealValue() {
		return realValue;
	}
	public void setRealValue(Double realValue) {
		this.realValue = realValue;
	}
}
