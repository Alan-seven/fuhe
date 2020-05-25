package com.jsite.busi.szy.info.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsMResgd extends AbstractData<DdsMResgd> {
	
	private static final long serialVersionUID = 1L;
	private String ocId;		// 调度图ID
	private String bt;		// 起始时间
	private String et;		// 终止时间
	private String uoc;		// 上调度线
	private String doc;		// 下调度线
	private String cg;		// 控制指标
	private String ts;		// 时间戳
	
	public DdsMResgd() {
		super();
	}

	public DdsMResgd(String id){
		super(id);
	}

	@Length(min=1, max=12, message="调度图ID长度必须介于 1 和 12 之间")
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