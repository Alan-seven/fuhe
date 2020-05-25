package com.jsite.busi.standard.sl325.po;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 水质分类标准Entity
 * @author 徐旺旺
 * @version 2017-03-13
 */
public class WqPasA extends AbstractData<WqPasA> {
	
	private static final long serialVersionUID = 1L;
	private String itmid;		// 项目标识
	private Integer smcl;		// 样品分类
	private String stncd;		// 标准代号
	private String wqg;		// 水质类别
	private Double wqgulv;		// 类别上限值
	private Double wqgllv;		// 类别下限值
	
	public WqPasA() {
		super();
	}

	public WqPasA(String id){
		super(id);
	}

	@Length(min=1, max=10, message="项目标识长度必须介于 1 和 10 之间")
	public String getItmid() {
		return itmid;
	}

	public void setItmid(String itmid) {
		this.itmid = itmid;
	}
	
	@NotNull(message="样品分类不能为空")
	public Integer getSmcl() {
		return smcl;
	}

	public void setSmcl(Integer smcl) {
		this.smcl = smcl;
	}
	
	@Length(min=1, max=20, message="标准代号长度必须介于 1 和 20 之间")
	public String getStncd() {
		return stncd;
	}

	public void setStncd(String stncd) {
		this.stncd = stncd;
	}
	
	@Length(min=1, max=8, message="水质类别长度必须介于 1 和 8 之间")
	public String getWqg() {
		return wqg;
	}

	public void setWqg(String wqg) {
		this.wqg = wqg;
	}
	
	public Double getWqgulv() {
		return wqgulv;
	}

	public void setWqgulv(Double wqgulv) {
		this.wqgulv = wqgulv;
	}
	
	public Double getWqgllv() {
		return wqgllv;
	}

	public void setWqgllv(Double wqgllv) {
		this.wqgllv = wqgllv;
	}
	
}