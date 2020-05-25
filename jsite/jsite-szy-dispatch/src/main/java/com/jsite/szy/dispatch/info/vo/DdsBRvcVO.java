package com.jsite.szy.dispatch.info.vo;

import com.jsite.core.web.PageVO;

/**
 * 仪器设备基本信息Entity
 * 
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBRvcVO extends PageVO {

	private String rivId; // 河道代码
	private String rivNm; // 河道名称
	private String rbNum; // 断面个数
	private String rivLen; // 河断长度

	public DdsBRvcVO() {
		super();
	}

	public String getRivId() {
		return rivId;
	}

	public void setRivId(String rivId) {
		this.rivId = rivId;
	}

	public String getRivNm() {
		return rivNm;
	}

	public void setRivNm(String rivNm) {
		this.rivNm = rivNm;
	}

	public String getRbNum() {
		return rbNum;
	}

	public void setRbNum(String rbNum) {
		this.rbNum = rbNum;
	}

	public String getRivLen() {
		return rivLen;
	}

	public void setRivLen(String rivLen) {
		this.rivLen = rivLen;
	}

}