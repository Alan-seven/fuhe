package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

import javax.validation.constraints.NotNull;


/**
 * 应急调度水库时段参数表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsEdPrdar extends AbstractData<DdsEdPrdar> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String wceCd;		// 水利要素ID
	private Date tm;		// 时间
	private Double maxZ;		// 最高水位
	private Double minZ;		// 最低水位
	private Double maxN;		// 最大出力
	private Double minN;		// 最小出力
	private Double maxQ;		// 最大流量
	private Double minQ;		// 最小流量
	private Double qin;		// 入库流量
	private Double qout;		// 下泄流量
	private Double c;		// 突发污染物浓度
	
	public DdsEdPrdar() {
		super();
	}

	public DdsEdPrdar(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=8, message="水利要素ID长度必须介于 1 和 8 之间")
	public String getWceCd() {
		return wceCd;
	}

	public void setWceCd(String wceCd) {
		this.wceCd = wceCd;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间不能为空")
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
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
	
	public Double getQin() {
		return qin;
	}

	public void setQin(Double qin) {
		this.qin = qin;
	}
	
	public Double getQout() {
		return qout;
	}

	public void setQout(Double qout) {
		this.qout = qout;
	}
	
	public Double getC() {
		return c;
	}

	public void setC(Double c) {
		this.c = c;
	}
	
}