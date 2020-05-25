package com.jsite.busi.szy.dispatch.po;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

import java.util.Date;

/**
 * 来水预报结果表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdIfres extends AbstractData<DdsRdIfres> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String secCd;		// 断面ID
	private Date bgtm;		// 起始时间
	private Date edtm;		// 结束时间
	private Integer month;		// 月份
	private Double forW;		// 预测值
	private Double lyW;		// 上一年径流量
	private Double lyRt;		// 同比
	private Double annW;		// 多年平均
	private Double anoV;		// 距平值
	private Integer concl;		// 结论


	public DdsRdIfres() {
		super();
	}

	public DdsRdIfres(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=8, message="断面ID长度必须介于 1 和 8 之间")
	public String getSecCd() {
		return secCd;
	}

	public void setSecCd(String secCd) {
		this.secCd = secCd;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="起始时间不能为空")
	public Date getBgtm() {
		return bgtm;
	}

	public void setBgtm(Date bgtm) {
		this.bgtm = bgtm;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="结束时间不能为空")
	public Date getEdtm() {
		return edtm;
	}

	public void setEdtm(Date edtm) {
		this.edtm = edtm;
	}
	
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}
	
	public Double getForW() {
		return forW;
	}

	public void setForW(Double forW) {
		this.forW = forW;
	}
	
	public Double getLyW() {
		return lyW;
	}

	public void setLyW(Double lyW) {
		this.lyW = lyW;
	}
	
	public Double getLyRt() {
		return lyRt;
	}

	public void setLyRt(Double lyRt) {
		this.lyRt = lyRt;
	}
	
	public Double getAnnW() {
		return annW;
	}

	public void setAnnW(Double annW) {
		this.annW = annW;
	}
	
	public Double getAnoV() {
		return anoV;
	}

	public void setAnoV(Double anoV) {
		this.anoV = anoV;
	}
	
	public Integer getConcl() {
		return concl;
	}

	public void setConcl(Integer concl) {
		this.concl = concl;
	}


}