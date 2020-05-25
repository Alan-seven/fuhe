package com.jsite.busi.szy.dispatch.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;
/**
 * 水量调度结果表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdWdres extends AbstractData<DdsRdWdres> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String wceId;		// 水利要素ID
	private Integer wceTp;		// 水利要素类型
	private Date bt;		// 开始时间
	private Date et;
	private Double bz;		// 月初水位
	private Double ez;		// 月末水位
	private Double az;		// 月均水位
	private Double inq;		// 入库流量
	private Double dw;		// 下泄流量
	private Double aq;		// 月均流量
	private Double dq;		// 弃水流量
	private Double wsv;		// 蓄水变化量
	private Double aw;		// 分配水量
	private Double ww;		// 供水量
	private Double rw;		// 退水量
	private Double lw;		// 缺水量
	private Double fr;		// 满足率
	private Double minEdw;		// 最小生态流量
	private Double eg;		// 发电量
	private Double n;		// 出力
	private Double h;		// 水头
	
	public DdsRdWdres() {
		super();
	}

	public DdsRdWdres(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 8 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=16, message="水利要素ID长度必须介于 1 和 12 之间")
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBt() {
		return bt;
	}

	public void setBt(Date bt) {
		this.bt = bt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEt() {
		return et;
	}

	public void setEt(Date et) {
		this.et = et;
	}

	public Double getBz() {
		return bz;
	}

	public void setBz(Double bz) {
		this.bz = bz;
	}
	
	public Double getEz() {
		return ez;
	}

	public void setEz(Double ez) {
		this.ez = ez;
	}
	
	public Double getAz() {
		return az;
	}

	public void setAz(Double az) {
		this.az = az;
	}
	
	public Double getInq() {
		return inq;
	}

	public void setInq(Double inq) {
		this.inq = inq;
	}
	
	public Double getDw() {
		return dw;
	}

	public void setDw(Double dw) {
		this.dw = dw;
	}
	
	public Double getAq() {
		return aq;
	}

	public void setAq(Double aq) {
		this.aq = aq;
	}
	
	public Double getDq() {
		return dq;
	}

	public void setDq(Double dq) {
		this.dq = dq;
	}
	
	public Double getWsv() {
		return wsv;
	}

	public void setWsv(Double wsv) {
		this.wsv = wsv;
	}
	
	public Double getAw() {
		return aw;
	}

	public void setAw(Double aw) {
		this.aw = aw;
	}
	
	public Double getWw() {
		return ww;
	}

	public void setWw(Double ww) {
		this.ww = ww;
	}
	
	public Double getRw() {
		return rw;
	}

	public void setRw(Double rw) {
		this.rw = rw;
	}
	
	public Double getLw() {
		return lw;
	}

	public void setLw(Double lw) {
		this.lw = lw;
	}
	
	public Double getFr() {
		return fr;
	}

	public void setFr(Double fr) {
		this.fr = fr;
	}
	
	public Double getMinEdw() {
		return minEdw;
	}

	public void setMinEdw(Double minEdw) {
		this.minEdw = minEdw;
	}
	
	public Double getEg() {
		return eg;
	}

	public void setEg(Double eg) {
		this.eg = eg;
	}
	
	public Double getN() {
		return n;
	}

	public void setN(Double n) {
		this.n = n;
	}
	
	public Double getH() {
		return h;
	}

	public void setH(Double h) {
		this.h = h;
	}
	
}