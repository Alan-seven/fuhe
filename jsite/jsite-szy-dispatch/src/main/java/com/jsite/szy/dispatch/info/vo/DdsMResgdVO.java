package com.jsite.szy.dispatch.info.vo;

import com.jsite.core.web.PageVO;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsMResgdVO extends PageVO{
	
	private String ocId;		// 调度图ID
	private String bt;		// 起始时间
	private String et;		// 终止时间
	private String uoc;		// 上调度线
	private String doc;		// 下调度线
	private String cg;		// 控制指标
	private String ts;		// 时间戳
	
	public DdsMResgdVO() {
		super();
	}

	public String getOcId() {
		return ocId;
	}

	public void setOcId(String ocId) {
		this.ocId = ocId;
	}
	
	public String getBt() {
		return bt;
	}

	public void setBt(String bt) {
		this.bt = bt;
	}
	
	public String getEt() {
		return et;
	}

	public void setEt(String et) {
		this.et = et;
	}
	
	public String getUoc() {
		return uoc;
	}

	public void setUoc(String uoc) {
		this.uoc = uoc;
	}
	
	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	public String getCg() {
		return cg;
	}

	public void setCg(String cg) {
		this.cg = cg;
	}
	
	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}
	
}