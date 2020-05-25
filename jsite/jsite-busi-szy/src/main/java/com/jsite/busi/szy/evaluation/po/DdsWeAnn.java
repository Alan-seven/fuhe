package com.jsite.busi.szy.evaluation.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 多年平均信息表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeAnn extends AbstractData<DdsWeAnn> {
	
	private static final long serialVersionUID = 1L;
	private String regCd;		// 分区代码
	private Long regType;		// 分区类型
	private Double annP;		// 降水多年平均
	private Double annW;		// 地表水多年平均
	private String nt;		// 备注
	
	public DdsWeAnn() {
		super();
	}

	public DdsWeAnn(String id){
		super(id);
	}

	@Length(min=1, max=13, message="分区代码长度必须介于 1 和 13 之间")
	public String getRegCd() {
		return regCd;
	}

	public void setRegCd(String regCd) {
		this.regCd = regCd;
	}
	
	public Long getRegType() {
		return regType;
	}

	public void setRegType(Long regType) {
		this.regType = regType;
	}
	
	public Double getAnnP() {
		return annP;
	}

	public void setAnnP(Double annP) {
		this.annP = annP;
	}
	
	public Double getAnnW() {
		return annW;
	}

	public void setAnnW(Double annW) {
		this.annW = annW;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}