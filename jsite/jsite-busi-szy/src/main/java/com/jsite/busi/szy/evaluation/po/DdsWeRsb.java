package com.jsite.busi.szy.evaluation.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 水资源评价水库基本信息表2Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeRsb extends AbstractData<DdsWeRsb> {
	
	private static final long serialVersionUID = 1L;
	private String rsCd;		// 水库代码
	private String rsNm;		// 水库名称
	private String rsType;		// 水库类型
	private String adCd;		// 行政分区
	private String wrzCd;		// 水资源分区
	private String nt;		// 备注
	
	public DdsWeRsb() {
		super();
	}

	public DdsWeRsb(String id){
		super(id);
	}

	@Length(min=1, max=12, message="水库代码长度必须介于 1 和 12 之间")
	public String getRsCd() {
		return rsCd;
	}

	public void setRsCd(String rsCd) {
		this.rsCd = rsCd;
	}
	
	@Length(min=0, max=128, message="水库名称长度必须介于 0 和 128 之间")
	public String getRsNm() {
		return rsNm;
	}

	public void setRsNm(String rsNm) {
		this.rsNm = rsNm;
	}
	
	@Length(min=0, max=1, message="水库类型长度必须介于 0 和 1 之间")
	public String getRsType() {
		return rsType;
	}

	public void setRsType(String rsType) {
		this.rsType = rsType;
	}
	
	@Length(min=1, max=6, message="行政分区长度必须介于 1 和 6 之间")
	public String getAdCd() {
		return adCd;
	}

	public void setAdCd(String adCd) {
		this.adCd = adCd;
	}
	
	@Length(min=1, max=7, message="水资源分区长度必须介于 1 和 7 之间")
	public String getWrzCd() {
		return wrzCd;
	}

	public void setWrzCd(String wrzCd) {
		this.wrzCd = wrzCd;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}