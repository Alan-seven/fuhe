package com.jsite.szy.dispatch.info.vo;

import java.util.Date;

import com.jsite.core.web.PageVO;

/**
 * 水库 水位、入库流量、出库流量年月旬均值系列表Entity
 * @author hjx
 * @version 2017-11-30
 */
public class DdsDrRsvrmyavVO extends PageVO {

	private String stcd;	//测站编码
	
	private Integer yr;		//年份
			
	private Integer mnth;	//月份
	
	private Integer prdtp;	//旬
		
	private Double avrz;    //平均水位
	
	private Double avinq;		//平均入库流量
	
	private Double avotq;		//平均出库流量	
	
	private Date moditime;	//时间戳

	public DdsDrRsvrmyavVO(){
		
	}
	
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}

	public Integer getYr() {
		return yr;
	}

	public void setYr(Integer yr) {
		this.yr = yr;
	}

	public Integer getMnth() {
		return mnth;
	}

	public void setMnth(Integer mnth) {
		this.mnth = mnth;
	}

	public Integer getPrdtp() {
		return prdtp;
	}

	public void setPrdtp(Integer prdtp) {
		this.prdtp = prdtp;
	}

	public Double getAvrz() {
		return avrz;
	}

	public void setAvrz(Double avrz) {
		this.avrz = avrz;
	}

	public Double getAvinq() {
		return avinq;
	}

	public void setAvinq(Double avinq) {
		this.avinq = avinq;
	}

	public Double getAvotq() {
		return avotq;
	}

	public void setAvotq(Double avotq) {
		this.avotq = avotq;
	}

	public Date getModitime() {
		return moditime;
	}

	public void setModitime(Date moditime) {
		this.moditime = moditime;
	}
	
}
