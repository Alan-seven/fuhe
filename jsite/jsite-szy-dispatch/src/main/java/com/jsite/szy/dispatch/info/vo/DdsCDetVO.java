package com.jsite.szy.dispatch.info.vo;

import com.jsite.core.web.PageVO;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsCDetVO extends PageVO{
	
	private String curveId;		// 曲线ID
	private String v0;		// v0
	private String v1;		// v1
	private String v2;		// v2
	private String v3;		// v3
	private String ts;		// 时间戳
	private String nt;		// 备注
	
	public DdsCDetVO() {
		super();
	}

	public String getCurveId() {
		return curveId;
	}

	public void setCurveId(String curveId) {
		this.curveId = curveId;
	}
	
	public String getV0() {
		return v0;
	}

	public void setV0(String v0) {
		this.v0 = v0;
	}
	
	public String getV1() {
		return v1;
	}

	public void setV1(String v1) {
		this.v1 = v1;
	}
	
	public String getV2() {
		return v2;
	}

	public void setV2(String v2) {
		this.v2 = v2;
	}
	
	public String getV3() {
		return v3;
	}

	public void setV3(String v3) {
		this.v3 = v3;
	}
	
	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}
	
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}