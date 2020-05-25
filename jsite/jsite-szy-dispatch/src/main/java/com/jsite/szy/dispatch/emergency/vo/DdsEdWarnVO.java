package com.jsite.szy.dispatch.emergency.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 预警信息Entity
 * @author hjx
 * @version 2017-10-09
 */
public class DdsEdWarnVO extends PageVO{

	private String eid;
	
	private String secCd;	//断面CD
	
    private Date startTm;		//监测开始时间
	
	private Date endTm;		//监测结束时间
	
	private String label;		//指标名称
	
	private Double lvalue;		//指标值
	
	private String lel;		//告警级别

	private String flag = "1";	//  1-- 新建   2-- 确认   3-- 忽略 4--同步
	
	private String river;
	
	private String stm;//查询开始时间
	private String etm;//查询结束时间
	
	public DdsEdWarnVO(){
		super();
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
	public String getLabel() {
		return label;
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

	public String getLel() {
		return lel;
	}

	public void setLel(String lel) {
		this.lel = lel;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public String getStm() {
		return stm;
	}
	public void setStm(String stm) {
		this.stm = stm;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public String getEtm() {
		return etm;
	}
	public void setEtm(String etm) {
		this.etm = etm;
	}

}
