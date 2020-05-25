package com.jsite.busi.szy.info.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsCDet extends AbstractData<DdsCDet> {
	
	private static final long serialVersionUID = 1L;
	private String curveId;		// 曲线ID
	private String v0;		// v0
	private String v1;		// v1
	private String v2;		// v2
	private String v3;		// v3
	private String ts;		// 时间戳
	private String nt;		// 备注
	
	public DdsCDet() {
		super();
	}

	public DdsCDet(String id){
		super(id);
	}

	@Length(min=1, max=8, message="曲线ID长度必须介于 1 和 8 之间")
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
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}