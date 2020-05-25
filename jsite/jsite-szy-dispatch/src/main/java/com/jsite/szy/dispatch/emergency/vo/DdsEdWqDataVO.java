package com.jsite.szy.dispatch.emergency.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

public class DdsEdWqDataVO extends PageVO{

	private String evenCd;		//事件ID
	private String downsec;		//下监测断面ID
	private Date tm;		//监测时间
	private Double c;		//污染物浓度
	private String startTm; //查询监测数据 起始时间
	private String endTm;	//查询监测数据 结束时间
	private Integer daType;
	
	private Date begt;		// 起始时间
	private Date edt;		// 结束时间
	
	public DdsEdWqDataVO(){
		
	}

	@Length(min=1, max=8, message="事件ID长度必须介于 1 和 8 之间")
	public String getEvenCd() {
		return evenCd;
	}
	public void setEvenCd(String evenCd) {
		this.evenCd = evenCd;
	}
	@Length(min=1, max=8, message="断面ID长度必须介于 1 和 8 之间")
	public String getDownsec() {
		return downsec;
	}
	public void setDownsec(String downsec) {
		this.downsec = downsec;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTm() {
		return tm;
	}
	public void setTm(Date tm) {
		this.tm = tm;
	}
	public Double getC() {
		return c;
	}
	public void setC(Double c) {
		this.c = c;
	}

	public Date getBegt() {
		return begt;
	}

	public void setBegt(Date begt) {
		this.begt = begt;
	}

	public Date getEdt() {
		return edt;
	}

	public void setEdt(Date edt) {
		this.edt = edt;
	}

	public Integer getDaType() {
		return daType;
	}

	public void setDaType(Integer daType) {
		this.daType = daType;
	}
	
}
