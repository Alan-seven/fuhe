package com.jsite.busi.szy.formal.po;

import java.util.Date;

import com.jsite.dao.AbstractData;

/**
 * 水库计算结果
 * @author seven
 *
 */
public class TSfrdRsvrRslt extends AbstractData<TSfrdRsvrRslt>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String proCd;
	private String enCd;
	private Date tm;
	private Float z ;
	
	public String getProCd() {
		return proCd;
	}
	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	public String getEnCd() {
		return enCd;
	}
	public void setEnCd(String enCd) {
		this.enCd = enCd;
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
