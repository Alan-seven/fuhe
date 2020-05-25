package com.jsite.szy.dispatch.info.vo;

import com.jsite.core.web.PageVO;

/**
 * 仪器设备基本信息Entity
 * 
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBEleVO extends PageVO {

	private String wceId; // 水利要素ID
	private String wceNm; // 水利要素名称
	private String wceTp; // 河道、水库、水文断面、用水分区、取水口、排污口、水利工程
	private String bnm; // 绝对基面名称
	private String chaVa; // 基面修正值
	private String ts; // 时间戳

	public DdsBEleVO() {
		super();
	}

	public String getWceId() {
		return wceId;
	}

	public void setWceId(String wceId) {
		this.wceId = wceId;
	}

	public String getWceNm() {
		return wceNm;
	}

	public void setWceNm(String wceNm) {
		this.wceNm = wceNm;
	}

	public String getWceTp() {
		return wceTp;
	}

	public void setWceTp(String wceTp) {
		this.wceTp = wceTp;
	}

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