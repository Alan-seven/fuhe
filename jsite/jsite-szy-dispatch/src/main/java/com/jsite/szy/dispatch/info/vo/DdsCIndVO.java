package com.jsite.szy.dispatch.info.vo;

import com.jsite.core.web.PageVO;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsCIndVO extends PageVO {
	
	private String curveId;		// 曲线ID
	private String curveNm;		// 曲线名称
	private String curveEp;		// 曲线说明
	private String ts;		// 时间戳
	private String nt;		// 备注
	
	public DdsCIndVO() {
		super();
	}

	public String getCurveId() {
		return curveId;
	}

	public void setCurveId(String curveId) {
		this.curveId = curveId;
	}
	
	public String getCurveNm() {
		return curveNm;
	}

	public void setCurveNm(String curveNm) {
		this.curveNm = curveNm;
	}
	
	public String getCurveEp() {
		return curveEp;
	}

	public void setCurveEp(String curveEp) {
		this.curveEp = curveEp;
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