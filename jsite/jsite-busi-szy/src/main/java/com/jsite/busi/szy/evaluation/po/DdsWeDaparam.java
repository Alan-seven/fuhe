package com.jsite.busi.szy.evaluation.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 废污水排放率表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeDaparam extends AbstractData<DdsWeDaparam> {
	
	private static final long serialVersionUID = 1L;
	private String yr;		// 评价年份
	private String regCd;		// 分区代码
	private Long regType;		// 分区类型
	private Double townLifeDp;		// 城镇居民生活污水排放率
	private Double indSewDp;		// 工业废水排放率
	private Double bldDp;		// 建筑业废水排放率
	private Double srvDp;		// 第三产业废水排放率
	private Double ieyDp;		// 火电厂直流式冷却水排放率
	private Double imyDp;		// 矿坑排放率
	private Double rivDp;		// 入河排放率
	private String nt;		// 备注
	
	public DdsWeDaparam() {
		super();
	}

	public DdsWeDaparam(String id){
		super(id);
	}

	@Length(min=1, max=4, message="评价年份长度必须介于 1 和 4 之间")
	public String getYr() {
		return yr;
	}

	public void setYr(String yr) {
		this.yr = yr;
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
	
	public Double getTownLifeDp() {
		return townLifeDp;
	}

	public void setTownLifeDp(Double townLifeDp) {
		this.townLifeDp = townLifeDp;
	}
	
	public Double getIndSewDp() {
		return indSewDp;
	}

	public void setIndSewDp(Double indSewDp) {
		this.indSewDp = indSewDp;
	}
	
	public Double getBldDp() {
		return bldDp;
	}

	public void setBldDp(Double bldDp) {
		this.bldDp = bldDp;
	}
	
	public Double getSrvDp() {
		return srvDp;
	}

	public void setSrvDp(Double srvDp) {
		this.srvDp = srvDp;
	}
	
	public Double getIeyDp() {
		return ieyDp;
	}

	public void setIeyDp(Double ieyDp) {
		this.ieyDp = ieyDp;
	}
	
	public Double getImyDp() {
		return imyDp;
	}

	public void setImyDp(Double imyDp) {
		this.imyDp = imyDp;
	}
	
	public Double getRivDp() {
		return rivDp;
	}

	public void setRivDp(Double rivDp) {
		this.rivDp = rivDp;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}