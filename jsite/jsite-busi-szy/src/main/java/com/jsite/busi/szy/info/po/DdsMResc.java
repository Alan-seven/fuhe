package com.jsite.busi.szy.info.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsMResc extends AbstractData<DdsMResc> {
	
	private static final long serialVersionUID = 1L;
	private String rtId;		// 约束ID
	private String resId;		// 水库ID
	private String bt;		// 起始时间
	private String et;		// 终止时间
	private String rtTp;		// 水位约束、流量约束、水头约束、出力约束
	private String max;		// 最大值
	private String min;		// 最小值
	
	public DdsMResc() {
		super();
	}

	public DdsMResc(String id){
		super(id);
	}

	@Length(min=1, max=8, message="约束ID长度必须介于 1 和 8 之间")
	public String getRtId() {
		return rtId;
	}

	public void setRtId(String rtId) {
		this.rtId = rtId;
	}
	
	@Length(min=1, max=12, message="水库ID长度必须介于 1 和 12 之间")
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
	
	@Length(min=0, max=2, message="水位约束、流量约束、水头约束、出力约束长度必须介于 0 和 2 之间")
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