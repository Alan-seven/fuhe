package com.jsite.busi.szy.evaluation.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 水库蓄水动态评价表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeRs extends AbstractData<DdsWeRs> {
	
	private static final long serialVersionUID = 1L;
	private String yr;		// 评价年份
	private String regCd;		// 分区代码
	private Long regType;		// 分区类型
	private Integer larResNum;		// 大型水库座数
	private Double larResYsw;		// 大型水库年初蓄水量
	private Double larResYew;		// 大型水库年末蓄水量
	private Integer midResNum;		// 中型水库座数
	private Double midResYsw;		// 中型水库年初蓄水量
	private Double midResYew;		// 中型水库年末蓄水量
	private Date dt;		// 评价时间
	private String nt;		// 备注
	
	public DdsWeRs() {
		super();
	}

	public DdsWeRs(String id){
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
	
	public Integer getLarResNum() {
		return larResNum;
	}

	public void setLarResNum(Integer larResNum) {
		this.larResNum = larResNum;
	}
	
	public Double getLarResYsw() {
		return larResYsw;
	}

	public void setLarResYsw(Double larResYsw) {
		this.larResYsw = larResYsw;
	}
	
	public Double getLarResYew() {
		return larResYew;
	}

	public void setLarResYew(Double larResYew) {
		this.larResYew = larResYew;
	}
	
	public Integer getMidResNum() {
		return midResNum;
	}

	public void setMidResNum(Integer midResNum) {
		this.midResNum = midResNum;
	}
	
	public Double getMidResYsw() {
		return midResYsw;
	}

	public void setMidResYsw(Double midResYsw) {
		this.midResYsw = midResYsw;
	}
	
	public Double getMidResYew() {
		return midResYew;
	}

	public void setMidResYew(Double midResYew) {
		this.midResYew = midResYew;
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