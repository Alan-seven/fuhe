package com.jsite.busi.szy.dispatch.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;
/**
 * 水量调度初始条件表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdWdinit extends AbstractData<DdsRdWdinit> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String wceId;		// 水利要素ID
	private Integer wceTp;		// 水利要素类型
	private Double bgz;		// 初始水位
	private Double edz;		// 末水位
	private Double inq;		// 入库流量
	private Double bq;		// 初始流量
	private Double mnq;		// 最小生态流量
	private Double mxq;		// 最大流量
	private Double eg;		// 发电量
	
	public DdsRdWdinit() {
		super();
	}

	public DdsRdWdinit(String id){
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
	
	public Integer getWceTp() {
		return wceTp;
	}

	public void setWceTp(Integer wceTp) {
		this.wceTp = wceTp;
	}
	
	public Double getBgz() {
		return bgz;
	}

	public void setBgz(Double bgz) {
		this.bgz = bgz;
	}
	
	public Double getEdz() {
		return edz;
	}

	public void setEdz(Double edz) {
		this.edz = edz;
	}
	
	public Double getInq() {
		return inq;
	}

	public void setInq(Double inq) {
		this.inq = inq;
	}
	
	public Double getBq() {
		return bq;
	}

	public void setBq(Double bq) {
		this.bq = bq;
	}
	
	public Double getMnq() {
		return mnq;
	}

	public void setMnq(Double mnq) {
		this.mnq = mnq;
	}
	
	public Double getMxq() {
		return mxq;
	}

	public void setMxq(Double mxq) {
		this.mxq = mxq;
	}
	
	public Double getEg() {
		return eg;
	}

	public void setEg(Double eg) {
		this.eg = eg;
	}
	
}