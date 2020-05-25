package com.jsite.busi.szy.info.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 测站水位预警信息表Entity
 * @author hjx
 * @version 2017-04-27
 */
public class DdsDWarn extends AbstractData<DdsDWarn> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String stcd;
	private Date tm;
	private Float z;		//水位
	private Float wrz;		//警戒水位
	private Float grz;		//保证水位
	public String getStcd() {
		return stcd;
	}
	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTm() {
		return tm;
	}
	public void setTm(Date tm) {
		this.tm = tm;
	}
	public Float getZ() {
		return z;
	}
	public void setZ(Float z) {
		this.z = z;
	}
	public Float getWrz() {
		return wrz;
	}
	public void setWrz(Float wrz) {
		this.wrz = wrz;
	}
	public Float getGrz() {
		return grz;
	}
	public void setGrz(Float grz) {
		this.grz = grz;
	}
	
	

}
