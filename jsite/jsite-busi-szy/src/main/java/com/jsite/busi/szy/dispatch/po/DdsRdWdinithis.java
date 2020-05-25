package com.jsite.busi.szy.dispatch.po;

import com.jsite.dao.AbstractData;
/**
 * 水量调度初始条件表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdWdinithis extends AbstractData<DdsRdWdinithis> {
	
	private static final long serialVersionUID = 1L;
	private String wceId;		// 水利要素ID
	private Integer year;		// 水利要素类型
	private Double zs;		// 初始水位
	private Double ze;		// 末水位
	private Double qmin;	// 最小流量
	private Double qmax;	// 最大流量
	
	public DdsRdWdinithis() {
		super();
	}

	public DdsRdWdinithis(String id){
		super(id);
	}

	public String getWceId() {
		return wceId;
	}

	public void setWceId(String wceId) {
		this.wceId = wceId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getZs() {
		return zs;
	}

	public void setZs(Double zs) {
		this.zs = zs;
	}

	public Double getZe() {
		return ze;
	}

	public void setZe(Double ze) {
		this.ze = ze;
	}

	public Double getQmin() {
		return qmin;
	}

	public void setQmin(Double qmin) {
		this.qmin = qmin;
	}

	public Double getQmax() {
		return qmax;
	}

	public void setQmax(Double qmax) {
		this.qmax = qmax;
	}

	
}