package com.jsite.busi.szy.info.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsMResg extends AbstractData<DdsMResg> {
	
	private static final long serialVersionUID = 1L;
	private String resId;		// 水库ID
	private String ocId;		// 调度图ID
	private String ocTp;		// 调度图类型
	private String ts;		// 时间戳
	
	public DdsMResg() {
		super();
	}

	public DdsMResg(String id){
		super(id);
	}

	@Length(min=1, max=12, message="水库ID长度必须介于 1 和 12 之间")
	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}
	
	@Length(min=1, max=12, message="调度图ID长度必须介于 1 和 12 之间")
	public String getOcId() {
		return ocId;
	}

	public void setOcId(String ocId) {
		this.ocId = ocId;
	}
	
	@Length(min=0, max=2, message="调度图类型长度必须介于 0 和 2 之间")
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