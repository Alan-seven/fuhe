package com.jsite.busi.szy.info.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBEle extends AbstractData<DdsBEle> {
	
	private static final long serialVersionUID = 1L;
	private String wceId;		// 水利要素ID
	private String wceNm;		// 水利要素名称
	private String wceTp;		// 河道、水库、水文断面、用水分区、取水口、排污口、水利工程
	private String bnm;		// 绝对基面名称
	private String chaVa;		// 基面修正值
	private String ts;		// 时间戳
	
	public DdsBEle() {
		super();
	}

	public DdsBEle(String id){
		super(id);
	}

	@Length(min=1, max=8, message="水利要素ID长度必须介于 1 和 8 之间")
	public String getWceId() {
		return wceId;
	}

	public void setWceId(String wceId) {
		this.wceId = wceId;
	}
	
	@Length(min=0, max=100, message="水利要素名称长度必须介于 0 和 100 之间")
	public String getWceNm() {
		return wceNm;
	}

	public void setWceNm(String wceNm) {
		this.wceNm = wceNm;
	}
	
	@Length(min=0, max=2, message="河道、水库、水文断面、用水分区、取水口、排污口、水利工程长度必须介于 0 和 2 之间")
	public String getWceTp() {
		return wceTp;
	}

	public void setWceTp(String wceTp) {
		this.wceTp = wceTp;
	}
	
	@Length(min=0, max=100, message="绝对基面名称长度必须介于 0 和 100 之间")
	public String getBnm() {
		return bnm;
	}

	public void setBnm(String bnm) {
		this.bnm = bnm;
	}
	
	public String getChaVa() {
		return chaVa;
	}

	public void setChaVa(String chaVa) {
		this.chaVa = chaVa;
	}
	
	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}
	
}