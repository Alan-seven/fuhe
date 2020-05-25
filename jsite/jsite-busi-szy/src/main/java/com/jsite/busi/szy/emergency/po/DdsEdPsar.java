package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;


/**
 * ]应急调度断面参数表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsEdPsar extends AbstractData<DdsEdPsar> {
	
	private static final long serialVersionUID = 1L;
	private String proeCd;		// 方案ID
	private String wceCd;		// 水利要素ID
	private Double bgZ;		// 起始水位
	private Double bgQ;		// 初始流量
	private Double bgConc;		// 初始污染物浓度
	private Double concSt;		// 污染物浓度标准
	private Double maxZ;		// 最高水位
	private Double minZ;		// 最低水位
	private Double weda;		// 污染物纳污能力
	
	public DdsEdPsar() {
		super();
	}

	public DdsEdPsar(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProeCd() {
		return proeCd;
	}

	public void setProeCd(String proeCd) {
		this.proeCd = proeCd;
	}
	
	@Length(min=1, max=8, message="水利要素ID长度必须介于 1 和 8 之间")
	public String getWceCd() {
		return wceCd;
	}

	public void setWceCd(String wceCd) {
		this.wceCd = wceCd;
	}
	
	public Double getBgZ() {
		return bgZ;
	}

	public void setBgZ(Double bgZ) {
		this.bgZ = bgZ;
	}
	
	public Double getBgQ() {
		return bgQ;
	}

	public void setBgQ(Double bgQ) {
		this.bgQ = bgQ;
	}
	
	public Double getBgConc() {
		return bgConc;
	}

	public void setBgConc(Double bgConc) {
		this.bgConc = bgConc;
	}
	
	public Double getConcSt() {
		return concSt;
	}

	public void setConcSt(Double concSt) {
		this.concSt = concSt;
	}
	
	public Double getMaxZ() {
		return maxZ;
	}

	public void setMaxZ(Double maxZ) {
		this.maxZ = maxZ;
	}
	
	public Double getMinZ() {
		return minZ;
	}

	public void setMinZ(Double minZ) {
		this.minZ = minZ;
	}
	
	public Double getWeda() {
		return weda;
	}

	public void setWeda(Double weda) {
		this.weda = weda;
	}
	
}