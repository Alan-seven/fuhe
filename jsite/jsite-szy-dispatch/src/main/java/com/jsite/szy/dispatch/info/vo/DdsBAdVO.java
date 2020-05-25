package com.jsite.szy.dispatch.info.vo;

import java.util.Date;

import com.jsite.core.web.PageVO;

/**
 * 仪器设备基本信息Entity
 * 
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBAdVO extends PageVO{

	private String adCd; // 行政区划代码
	private String adNm; // 行政区划名称
	private String adShnm; // 行政区划简称
	private String adA; // 行政区划面积km^2
	private Date ts; // 时间戳
	private String nt; // 备注

	public DdsBAdVO() {
		super();
	}

	public String getAdCd() {
		return adCd;
	}

	public void setAdCd(String adCd) {
		this.adCd = adCd;
	}

	public String getAdNm() {
		return adNm;
	}

	public void setAdNm(String adNm) {
		this.adNm = adNm;
	}

	public String getAdShnm() {
		return adShnm;
	}

	public void setAdShnm(String adShnm) {
		this.adShnm = adShnm;
	}

	public String getAdA() {
		return adA;
	}

	public void setAdA(String adA) {
		this.adA = adA;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}

	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

}