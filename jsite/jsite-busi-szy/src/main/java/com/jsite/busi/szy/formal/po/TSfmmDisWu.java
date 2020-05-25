package com.jsite.busi.szy.formal.po;

import com.jsite.dao.AbstractData;

/**
 * 水量分配用水系数初始化参数表Entity
 * @author 
 * @version 2020-03-17
 */
public class TSfmmDisWu extends AbstractData<TSfmmDisWu>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mnth;
	private Float indWusWt;		//工业用水系数
	private Float agrWusWt;		//农业用水系数
	private Float lifWusWt;		//生活用水系数
	private Float fafrWusWt;	//林牧鱼用水系数
	private Float indReWt;		//工业回归系数
	private Float agrReWt;		//农业回归系数
	private Float lifReWt;		//生活回归系数
	private Float fafrReWt;		//林牧鱼回归系数
	public int getMnth() {
		return mnth;
	}
	public void setMnth(int mnth) {
		this.mnth = mnth;
	}
	public Float getIndWusWt() {
		return indWusWt;
	}
	public void setIndWusWt(Float indWusWt) {
		this.indWusWt = indWusWt;
	}
	public Float getAgrWusWt() {
		return agrWusWt;
	}
	public void setAgrWusWt(Float agrWusWt) {
		this.agrWusWt = agrWusWt;
	}
	public Float getLifWusWt() {
		return lifWusWt;
	}
	public void setLifWusWt(Float lifWusWt) {
		this.lifWusWt = lifWusWt;
	}
	public Float getFafrWusWt() {
		return fafrWusWt;
	}
	public void setFafrWusWt(Float fafrWusWt) {
		this.fafrWusWt = fafrWusWt;
	}
	public Float getIndReWt() {
		return indReWt;
	}
	public void setIndReWt(Float indReWt) {
		this.indReWt = indReWt;
	}
	public Float getAgrReWt() {
		return agrReWt;
	}
	public void setAgrReWt(Float agrReWt) {
		this.agrReWt = agrReWt;
	}
	public Float getLifReWt() {
		return lifReWt;
	}
	public void setLifReWt(Float lifReWt) {
		this.lifReWt = lifReWt;
	}
	public Float getFafrReWt() {
		return fafrReWt;
	}
	public void setFafrReWt(Float fafrReWt) {
		this.fafrReWt = fafrReWt;
	}
	
	
}
