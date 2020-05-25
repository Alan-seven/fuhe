package com.jsite.busi.standard.sl325.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 单表生成Entity
 * @author 徐旺旺
 * @version 2017-03-02
 */
public class WqMsarA extends AbstractData<WqMsarA> {
	
	private static final long serialVersionUID = 1L;
	private String stcd;		// 测站编码
	private Date asot;		// 评价时间
	private String asdr;		// 评价时段长
	private String asmt;		// 评价方法
	private String wqg;		// 水质类别
	private String mespest;		// 主要超标项目与倍数
	private String avz;		// 平均水位
	private String avq;		// 平均流量
	private String nt;		// 备注
	
	public WqMsarA() {
		super();
	}

	public WqMsarA(String id){
		super(id);
	}

	@Length(min=1, max=64, message="测站编码长度必须介于 1 和 64 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="评价时间不能为空")
	public Date getAsot() {
		return asot;
	}

	public void setAsot(Date asot) {
		this.asot = asot;
	}
	
	@Length(min=1, max=3, message="评价时段长长度必须介于 1 和 3 之间")
	public String getAsdr() {
		return asdr;
	}

	public void setAsdr(String asdr) {
		this.asdr = asdr;
	}
	
	@Length(min=1, max=2, message="评价方法长度必须介于 1 和 2 之间")
	public String getAsmt() {
		return asmt;
	}

	public void setAsmt(String asmt) {
		this.asmt = asmt;
	}
	
	@Length(min=0, max=8, message="水质类别长度必须介于 0 和 8 之间")
	public String getWqg() {
		return wqg;
	}

	public void setWqg(String wqg) {
		this.wqg = wqg;
	}
	
	public String getMespest() {
		return mespest;
	}

	public void setMespest(String mespest) {
		this.mespest = mespest;
	}
	
	public String getAvz() {
		return avz;
	}

	public void setAvz(String avz) {
		this.avz = avz;
	}
	
	public String getAvq() {
		return avq;
	}

	public void setAvq(String avq) {
		this.avq = avq;
	}
	
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}