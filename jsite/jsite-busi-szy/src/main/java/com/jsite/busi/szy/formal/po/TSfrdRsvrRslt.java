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
	private Double inflow;
	private Double outflow;
	private Double z ;
	
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
	public Double getZ() {
		return z;
	}
	public void setZ(Double z) {
		this.z = z;
	}
	public Double getInflow() {
		return inflow;
	}
	public void setInflow(Double inflow) {
		this.inflow = inflow;
	}
	public Double getOutflow() {
		return outflow;
	}
	public void setOutflow(Double outflow) {
		this.outflow = outflow;
	}
	
}
