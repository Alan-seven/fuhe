package com.jsite.busi.szy.emergency.po;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 预警信息表Entity
 * @author hjx
 *
 */
public class DdsEdWarn  extends AbstractData<DdsEdWarn>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String eid;

	private String secCd;	//断面CD
	
	private Date startTm;		//监测开始时间
	
	private Date endTm;		//监测结束时间

	private String label;		//指标名称
	
	private Double lvalue;		//指标值
	
	private String lel;		//告警级别
	
	private Integer updown;		// 上下限标

	private String flag = "1";	//  1-- 新建   2-- 确认   3-- 忽略  4---同步
	
	public DdsEdWarn() {
		super();
	}

	@Length(min=1, max=8, message="断面CD长度必须介于 1 和 8 之间")
	public DdsEdWarn(String id){
		super(id);
	}
	@Length(min=1, max=32, message="事件ID长度必须介于 1 和32 之间")
	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getSecCd() {
		return secCd;
	}

	public void setSecCd(String secCd) {
		this.secCd = secCd;
	}

	@Length(min=1, max=100, message="指标名称长度必须介于 1 和100 之间")
	public String getLabel() {
		return label;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartTm() {
		return startTm;
	}

	public void setStartTm(Date startTm) {
		this.startTm = startTm;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndTm() {
		return endTm;
	}

	public void setEndTm(Date endTm) {
		this.endTm = endTm;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getLvalue() {
		return lvalue;
	}

	public void setLvalue(Double lvalue) {
		this.lvalue = lvalue;
	}
	
	@Length(min=1, max=2, message="告警级别长度必须介于 1 和2 之间")
	public String getLel() {
		return lel;
	}

	public void setLel(String lel) {
		this.lel = lel;
	}

	public Integer getUpdown() {
		return updown;
	}

	public void setUpdown(Integer updown) {
		this.updown = updown;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
