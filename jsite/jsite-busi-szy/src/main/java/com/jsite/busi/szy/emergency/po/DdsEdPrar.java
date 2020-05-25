package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;


/**
 * 应急调度水库参数表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsEdPrar extends AbstractData<DdsEdPrar> {
	
	private static final long serialVersionUID = 1L;
	private String proeCd;		// 方案ID
	private String wceCd;		// 水利要素ID
	private Double bgZ;		// 起始水位
	private Double bgQ;		// 初始流量
	private Double bgConc;		// 初始污染物浓度
	private Double concSt;		// 污染物浓度标准
	private Double exq;		// 加大下泄量
	private Double edZ;		// 终止水位
	private Double maxQ;		// 最大流量
	private Double minQ;		// 最小流量
	private Double maxN;		// 最大出力
	private Double minN;		// 最小出力
	private Double maxH;		// 最大水头
	private Double minH;		// 最小水头
	private Double k;		// 出力系数
	private String qType;		// 入库流量类型
	private String profCd;		// 预报方案ID
	private String hyr;		// 历史年份
	private Double maxZ;		// 最高水位
	private Double minZ;		// 最低水位
	private Double weda;		// 污染物纳污能力
	
	public DdsEdPrar() {
		super();
	}

	public DdsEdPrar(String id){
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
	
	public Double getExq() {
		return exq;
	}

	public void setExq(Double exq) {
		this.exq = exq;
	}
	
	public Double getEdZ() {
		return edZ;
	}

	public void setEdZ(Double edZ) {
		this.edZ = edZ;
	}
	
	public Double getMaxQ() {
		return maxQ;
	}

	public void setMaxQ(Double maxQ) {
		this.maxQ = maxQ;
	}
	
	public Double getMinQ() {
		return minQ;
	}

	public void setMinQ(Double minQ) {
		this.minQ = minQ;
	}
	
	public Double getMaxN() {
		return maxN;
	}

	public void setMaxN(Double maxN) {
		this.maxN = maxN;
	}
	
	public Double getMinN() {
		return minN;
	}

	public void setMinN(Double minN) {
		this.minN = minN;
	}
	
	public Double getMaxH() {
		return maxH;
	}

	public void setMaxH(Double maxH) {
		this.maxH = maxH;
	}
	
	public Double getMinH() {
		return minH;
	}

	public void setMinH(Double minH) {
		this.minH = minH;
	}
	
	public Double getK() {
		return k;
	}

	public void setK(Double k) {
		this.k = k;
	}
	
	@Length(min=0, max=1, message="入库流量类型长度必须介于 0 和 1 之间")
	public String getQType() {
		return qType;
	}

	public void setQType(String qType) {
		this.qType = qType;
	}
	
	@Length(min=0, max=13, message="预报方案ID长度必须介于 0 和 13 之间")
	public String getProfCd() {
		return profCd;
	}

	public void setProfCd(String profCd) {
		this.profCd = profCd;
	}
	
	@Length(min=0, max=4, message="历史年份长度必须介于 0 和 4 之间")
	public String getHyr() {
		return hyr;
	}

	public void setHyr(String hyr) {
		this.hyr = hyr;
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