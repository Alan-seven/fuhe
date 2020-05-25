package com.jsite.szy.dispatch.info.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 测站水位预警信息表Entity
 * @author hjx
 * @version 2019-11-27
 */
public class DdsDWarnVO extends PageVO {

	private String stcd;
	private Date tm;
	private Float z;		//水位
	private Float wrz;		//警戒水位
	private Float grz;		//保证水位
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
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
	public String getRiver() {
		return river;
	}
	public void setRiver(String river) {
		this.river = river;
	}
	
	
}
