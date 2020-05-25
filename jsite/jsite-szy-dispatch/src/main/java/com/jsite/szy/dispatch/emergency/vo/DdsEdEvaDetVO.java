package com.jsite.szy.dispatch.emergency.vo;

import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;


/**
 * 应急调度方案结果评价详情表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsEdEvaDetVO extends PageVO {
	
	private String proCd;		// 方案ID
	private String secId;		// 河道断面
	private Double secValue;		// 影响指标
	
	public DdsEdEvaDetVO() {
		super();
	}


	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}

	@Length(min=1, max=8, message="指标名称长度必须介于 1 和 8 之间")
	public String getSecId() {
		return secId;
	}


	public void setSecId(String secId) {
		this.secId = secId;
	}


	public Double getSecValue() {
		return secValue;
	}


	public void setSecValue(Double secValue) {
		this.secValue = secValue;
	}
	
}