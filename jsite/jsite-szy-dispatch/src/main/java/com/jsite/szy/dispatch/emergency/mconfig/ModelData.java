package com.jsite.szy.dispatch.emergency.mconfig;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ModelData {

	private String secId;		// 水利要素ID
	private Date tm;		// 时间
	private Double planValue;		// 原计划水位
	private Double realValue;		//调整值
	
	private Double planz;
	private Double realz;
	private Double planq;
	private Double realq;
	private Double planinq;
	private Double realinq;
	private Double planotq;
	private Double realotq;
	private Double planbopl;
	private Double realbopl;
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
	public Double getPlanValue() {
		return planValue;
	}
	public void setPlanValue(Double planValue) {
		this.planValue = planValue;
	}
	public Double getRealValue() {
		return realValue;
	}
	public void setRealValue(Double realValue) {
		this.realValue = realValue;
	}
	public Double getPlanz() {
		return planz;
	}
	public void setPlanz(Double planz) {
		this.planz = planz;
	}
	public Double getRealz() {
		return realz;
	}
	public void setRealz(Double realz) {
		this.realz = realz;
	}
	public Double getPlanq() {
		return planq;
	}
	public void setPlanq(Double planq) {
		this.planq = planq;
	}
	public Double getRealq() {
		return realq;
	}
	public void setRealq(Double realq) {
		this.realq = realq;
	}
	public Double getPlaninq() {
		return planinq;
	}
	public void setPlaninq(Double planinq) {
		this.planinq = planinq;
	}
	public Double getRealinq() {
		return realinq;
	}
	public void setRealinq(Double realinq) {
		this.realinq = realinq;
	}
	public Double getPlanotq() {
		return planotq;
	}
	public void setPlanotq(Double planotq) {
		this.planotq = planotq;
	}
	public Double getRealotq() {
		return realotq;
	}
	public void setRealotq(Double realotq) {
		this.realotq = realotq;
	}
	public Double getPlanbopl() {
		return planbopl;
	}
	public void setPlanbopl(Double planbopl) {
		this.planbopl = planbopl;
	}
	public Double getRealbopl() {
		return realbopl;
	}
	public void setRealbopl(Double realbopl) {
		this.realbopl = realbopl;
	}

	
}
