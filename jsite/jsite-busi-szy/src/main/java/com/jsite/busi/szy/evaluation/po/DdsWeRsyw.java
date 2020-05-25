package com.jsite.busi.szy.evaluation.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 水库年蓄水量表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeRsyw extends AbstractData<DdsWeRsyw> {
	
	private static final long serialVersionUID = 1L;
	private String yr;		// 评价年份
	private String rsCd;		// 水库编码
	private Double ysw;		// 年初蓄水量
	private Double yew;		// 年末需水量
	private String nt;		// 备注
	
	public DdsWeRsyw() {
		super();
	}

	public DdsWeRsyw(String id){
		super(id);
	}

	@Length(min=1, max=4, message="评价年份长度必须介于 1 和 4 之间")
	public String getYr() {
		return yr;
	}

	public void setYr(String yr) {
		this.yr = yr;
	}
	
	@Length(min=1, max=12, message="水库编码长度必须介于 1 和 12 之间")
	public String getRsCd() {
		return rsCd;
	}

	public void setRsCd(String rsCd) {
		this.rsCd = rsCd;
	}
	
	public Double getYsw() {
		return ysw;
	}

	public void setYsw(Double ysw) {
		this.ysw = ysw;
	}
	
	public Double getYew() {
		return yew;
	}

	public void setYew(Double yew) {
		this.yew = yew;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}