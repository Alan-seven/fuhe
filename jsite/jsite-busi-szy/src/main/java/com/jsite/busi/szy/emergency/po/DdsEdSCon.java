package com.jsite.busi.szy.emergency.po;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 应急调度追踪溯源断面设置Entity
 * @author hjx
 * @version 2017-06-12
 */
public class DdsEdSCon extends AbstractData<DdsEdSCon>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String evenCd;		// 事件ID
	private String secId;		//断面编码
	private Date tm;			//监测时间
	private Double conc;		//浓度
	
	@Length(min=1, max=8, message="事件ID长度必须介于 1 和 8 之间")
	public String getEvenCd() {
		return evenCd;
	}
	public void setEvenCd(String evenCd) {
		this.evenCd = evenCd;
	}
	
	@Length(min=1, max=8, message="断面ID长度必须介于 1 和 8 之间")
	public String getSecId() {
		return secId;
	}
	public void setSecId(String secId) {
		this.secId = secId;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTm() {
		return tm;
	}
	public void setTm(Date tm) {
		this.tm = tm;
	}
	public Double getConc() {
		return conc;
	}
	public void setConc(Double conc) {
		this.conc = conc;
	}
	
}
