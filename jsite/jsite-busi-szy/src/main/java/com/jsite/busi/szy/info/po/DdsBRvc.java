package com.jsite.busi.szy.info.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBRvc extends AbstractData<DdsBRvc> {
	
	private static final long serialVersionUID = 1L;
	private String rivId;		// 河道代码
	private String rivNm;		// 河道名称
	private String rbNum;		// 断面个数
	private String rivLen;		// 河断长度
	
	public DdsBRvc() {
		super();
	}

	public DdsBRvc(String id){
		super(id);
	}

	@Length(min=1, max=8, message="河道代码长度必须介于 1 和 8 之间")
	public String getRivId() {
		return rivId;
	}

	public void setRivId(String rivId) {
		this.rivId = rivId;
	}
	
	@Length(min=0, max=100, message="河道名称长度必须介于 0 和 100 之间")
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