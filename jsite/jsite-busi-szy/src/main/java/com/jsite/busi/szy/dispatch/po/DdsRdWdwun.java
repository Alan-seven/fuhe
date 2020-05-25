package com.jsite.busi.szy.dispatch.po;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

public class DdsRdWdwun extends AbstractData<DdsRdWdwun>{
	private static final long serialVersionUID = 1L;
	private String proCd;
	private String regId;
	private Date bt;
	private Date et;
	private Integer month;
	private Integer dedade;
	private Double lifeAw;
	private Double argAw;
	private Double indAw;
	private Double lifeWw;
	private Double agrWw;
	private Double indWw;
	private Double lifeLw;
	private Double agrLw;
	private Double indLw;
	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}
	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	@Length(min=1, max=16, message="用水单元ID长度必须介于 1 和 16 之间")
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBt() {
		return bt;
	}
	public void setBt(Date bt) {
		this.bt = bt;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEt() {
		return et;
	}
	public void setEt(Date et) {
		this.et = et;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getDedade() {
		return dedade;
	}
	public void setDedade(Integer dedade) {
		this.dedade = dedade;
	}
	public Double getLifeAw() {
		return lifeAw;
	}
	public void setLifeAw(Double lifeAw) {
		this.lifeAw = lifeAw;
	}
	public Double getArgAw() {
		return argAw;
	}
	public void setArgAw(Double argAw) {
		this.argAw = argAw;
	}
	public Double getIndAw() {
		return indAw;
	}
	public void setIndAw(Double indAw) {
		this.indAw = indAw;
	}
	public Double getLifeWw() {
		return lifeWw;
	}
	public void setLifeWw(Double lifeWw) {
		this.lifeWw = lifeWw;
	}
	public Double getAgrWw() {
		return agrWw;
	}
	public void setAgrWw(Double agrWw) {
		this.agrWw = agrWw;
	}
	public Double getIndWw() {
		return indWw;
	}
	public void setIndWw(Double indWw) {
		this.indWw = indWw;
	}
	public Double getLifeLw() {
		return lifeLw;
	}
	public void setLifeLw(Double lifeLw) {
		this.lifeLw = lifeLw;
	}
	public Double getAgrLw() {
		return agrLw;
	}
	public void setAgrLw(Double agrLw) {
		this.agrLw = agrLw;
	}
	public Double getIndLw() {
		return indLw;
	}
	public void setIndLw(Double indLw) {
		this.indLw = indLw;
	}
}
