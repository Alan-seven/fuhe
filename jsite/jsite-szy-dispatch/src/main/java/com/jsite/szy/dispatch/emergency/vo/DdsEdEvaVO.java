package com.jsite.szy.dispatch.emergency.vo;

import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;


/**
 * 应急调度方案结果评价表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsEdEvaVO extends PageVO {
	
	private String proCd;		// 方案ID
	private String fatNm;		// 指标名称
	private Double value;		// 指标值
	private String nt;		// nt
	
	public DdsEdEvaVO() {
		super();
	}


	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=20, message="指标名称长度必须介于 1 和 20 之间")
	public String getFatNm() {
		return fatNm;
	}

	public void setFatNm(String fatNm) {
		this.fatNm = fatNm;
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	@Length(min=0, max=256, message="nt长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}