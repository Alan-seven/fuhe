package com.jsite.szy.dispatch.info.vo;

import com.jsite.core.web.PageVO;

/**
 * 仪器设备基本信息Entity
 * 
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsMResgVO extends PageVO {
	private String resId; // 水库ID
	private String ocId; // 调度图ID
	private String ocTp; // 调度图类型
	private String ts; // 时间戳

	public DdsMResgVO() {
		super();
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getOcId() {
		return ocId;
	}

	public void setOcId(String ocId) {
		this.ocId = ocId;
	}

	public String getOcTp() {
		return ocTp;
	}

	public void setOcTp(String ocTp) {
		this.ocTp = ocTp;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

}