package com.jsite.busi.szy.evaluation.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 降水代表站权重表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWePstpar extends AbstractData<DdsWePstpar> {
	
	private static final long serialVersionUID = 1L;
	private String yr;		// 评价年份
	private String stcd;		// 测站编码
	private String adcd;		// 行政区划
	private Double area;		// 面积
	private Double weigh;		// 权重
	private Double curP;		// 年降水深
	private Double curPd;		// 权重降水深
	private String nt;		// 备注
	
	public DdsWePstpar() {
		super();
	}

	public DdsWePstpar(String id){
		super(id);
	}

	@Length(min=1, max=4, message="评价年份长度必须介于 1 和 4 之间")
	public String getYr() {
		return yr;
	}

	public void setYr(String yr) {
		this.yr = yr;
	}
	
	@Length(min=1, max=8, message="测站编码长度必须介于 1 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@Length(min=1, max=6, message="行政区划长度必须介于 1 和 6 之间")
	public String getAdcd() {
		return adcd;
	}

	public void setAdcd(String adcd) {
		this.adcd = adcd;
	}
	
	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}
	
	public Double getWeigh() {
		return weigh;
	}

	public void setWeigh(Double weigh) {
		this.weigh = weigh;
	}
	
	public Double getCurP() {
		return curP;
	}

	public void setCurP(Double curP) {
		this.curP = curP;
	}
	
	public Double getCurPd() {
		return curPd;
	}

	public void setCurPd(Double curPd) {
		this.curPd = curPd;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}