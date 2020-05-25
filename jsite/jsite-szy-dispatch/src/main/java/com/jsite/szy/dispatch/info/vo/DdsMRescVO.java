package com.jsite.szy.dispatch.info.vo;

import com.jsite.core.web.PageVO;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsMRescVO extends PageVO {
	
	private String rtId;		// 约束ID
	private String resId;		// 水库ID
	private String bt;		// 起始时间
	private String et;		// 终止时间
	private String rtTp;		// 水位约束、流量约束、水头约束、出力约束
	private String max;		// 最大值
	private String min;		// 最小值
	
	public DdsMRescVO() {
		super();
	}

	public String getRtId() {
		return rtId;
	}

	public void setRtId(String rtId) {
		this.rtId = rtId;
	}
	
	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
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
	
	public String getRtTp() {
		return rtTp;
	}

	public void setRtTp(String rtTp) {
		this.rtTp = rtTp;
	}
	
	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}
	
	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}
	
}