package com.jsite.busi.szy.evaluation.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 地表水资源量评价表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeSw extends AbstractData<DdsWeSw> {
	
	private static final long serialVersionUID = 1L;
	private String yr;		// 评价年份
	private String regCd;		// 分区代码
	private Long regType;		// 分区类型
	private Double yrW;		// 年径流量
	private Double yrRd;		// 年径流深
	private Double lyW;		// 上年径流量
	private Double annW;		// 多年平均径流量
	private Double lyRt;		// 与上年比较
	private Double annRt;		// 与多年平均径流量比较
	private Date dt;		// 评价时间
	private String nt;		// 备注
	
	public DdsWeSw() {
		super();
	}

	public DdsWeSw(String id){
		super(id);
	}

	@Length(min=1, max=4, message="评价年份长度必须介于 1 和 4 之间")
	public String getYr() {
		return yr;
	}

	public void setYr(String yr) {
		this.yr = yr;
	}
	
	@Length(min=1, max=14, message="分区代码长度必须介于 1 和 14 之间")
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
	
	public Double getYrW() {
		return yrW;
	}

	public void setYrW(Double yrW) {
		this.yrW = yrW;
	}
	
	public Double getYrRd() {
		return yrRd;
	}

	public void setYrRd(Double yrRd) {
		this.yrRd = yrRd;
	}
	
	public Double getLyW() {
		return lyW;
	}

	public void setLyW(Double lyW) {
		this.lyW = lyW;
	}
	
	public Double getAnnW() {
		return annW;
	}

	public void setAnnW(Double annW) {
		this.annW = annW;
	}
	
	public Double getLyRt() {
		return lyRt;
	}

	public void setLyRt(Double lyRt) {
		this.lyRt = lyRt;
	}
	
	public Double getAnnRt() {
		return annRt;
	}

	public void setAnnRt(Double annRt) {
		this.annRt = annRt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}