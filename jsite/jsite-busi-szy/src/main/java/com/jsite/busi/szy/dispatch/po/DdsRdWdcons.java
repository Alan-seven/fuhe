package com.jsite.busi.szy.dispatch.po;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;
/**
 * 水量调度约束条件表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdWdcons extends AbstractData<DdsRdWdcons> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String wceId;		// 水利要素ID
	private Date bgt;		// 开始时间
	private Date edt;		// 结束时间
	private Double zmx;		// 最高水位
	private Double zmn;		// 最低水位
	private Double qmx;		// 最大下泄流量
	private Double qmn;		// 最小下泄流量
	private Double nmx;		// 最大出力
	private Double nmn;		// 最小出力
	
	public DdsRdWdcons() {
		super();
	}

	public DdsRdWdcons(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=12, message="水利要素ID长度必须介于 1 和 12 之间")
	public String getWceId() {
		return wceId;
	}

	public void setWceId(String wceId) {
		this.wceId = wceId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBgt() {
		return bgt;
	}

	public void setBgt(Date bgt) {
		this.bgt = bgt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEdt() {
		return edt;
	}

	public void setEdt(Date edt) {
		this.edt = edt;
	}
	
	public Double getZmx() {
		return zmx;
	}

	public void setZmx(Double zmx) {
		this.zmx = zmx;
	}
	
	public Double getZmn() {
		return zmn;
	}

	public void setZmn(Double zmn) {
		this.zmn = zmn;
	}
	
	public Double getQmx() {
		return qmx;
	}

	public void setQmx(Double qmx) {
		this.qmx = qmx;
	}
	
	public Double getQmn() {
		return qmn;
	}

	public void setQmn(Double qmn) {
		this.qmn = qmn;
	}
	
	public Double getNmx() {
		return nmx;
	}

	public void setNmx(Double nmx) {
		this.nmx = nmx;
	}
	
	public Double getNmn() {
		return nmn;
	}

	public void setNmn(Double nmn) {
		this.nmn = nmn;
	}
	
}