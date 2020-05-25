package com.jsite.busi.szy.emergency.po;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

public class DdsEdWqData extends AbstractData<DdsEdWqData>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String evenCd;		//事件ID
	private String downsec;		//下监测断面ID
	private Date tm;		//监测时间
	private Double c;		//污染物浓度
	private String startTm;
	private String endTm;
	
	public DdsEdWqData(){
		
	}
	
	public DdsEdWqData(String id){
		super(id);
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

	public String getStartTm() {
		return startTm;
	}

	public void setStartTm(String startTm) {
		this.startTm = startTm;
	}

	public String getEndTm() {
		return endTm;
	}

	public void setEndTm(String endTm) {
		this.endTm = endTm;
	}

	
}
