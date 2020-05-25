package com.jsite.busi.szy.evaluation.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 水资源评价水库基本信息表2Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeWrcs2 extends AbstractData<DdsWeWrcs2> {
	
	private static final long serialVersionUID = 1L;
	private String regCd;		// 分区代码
	private String regNm;		// 分区名称
	private String adCd;		// 行政分区
	private String wrzCd;		// 水资源分区
	private Double area;		// 分区面积
	private Double adW;		// 占水行政分区权重
	private Double wrzW;		// 占水资源分区权重
	private String nt;		// 备注
	
	public DdsWeWrcs2() {
		super();
	}

	public DdsWeWrcs2(String id){
		super(id);
	}

	@Length(min=1, max=13, message="分区代码长度必须介于 1 和 13 之间")
	public String getRegCd() {
		return regCd;
	}

	public void setRegCd(String regCd) {
		this.regCd = regCd;
	}
	
	@Length(min=0, max=128, message="分区名称长度必须介于 0 和 128 之间")
	public String getRegNm() {
		return regNm;
	}

	public void setRegNm(String regNm) {
		this.regNm = regNm;
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
	
	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}
	
	public Double getAdW() {
		return adW;
	}

	public void setAdW(Double adW) {
		this.adW = adW;
	}
	
	public Double getWrzW() {
		return wrzW;
	}

	public void setWrzW(Double wrzW) {
		this.wrzW = wrzW;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}