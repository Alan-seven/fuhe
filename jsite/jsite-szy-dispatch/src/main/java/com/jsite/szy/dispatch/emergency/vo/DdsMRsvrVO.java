package com.jsite.szy.dispatch.emergency.vo;

import java.util.Date;

import com.jsite.core.web.PageVO;

/**
 * 应急调度水库调节设置初始条件Entity
 * @author hjx
 * @version 2017-07-10
 */
public class DdsMRsvrVO extends PageVO{

	private String proCd;		// 方案ID
	private String resCd;		// 水库代码
	private String resNm;		//水库名称
	private Double z;		// 初始水位
	private Double q;		// 原计划下泄流量
	private Date starttime;		// 释染起始时间
	private Date endtime;		// 释染结束时间
	private String type;		// 加大下泄方式  1--固定值  2--序列
	private Double exq;		//加大下泄方式固值
	private Integer rcd;		//河段编号
	public String getProCd() {
		return proCd;
	}
	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	public String getResCd() {
		return resCd;
	}
	public void setResCd(String resCd) {
		this.resCd = resCd;
	}
	public Double getZ() {
		return z;
	}
	public void setZ(Double z) {
		this.z = z;
	}
	public Double getQ() {
		return q;
	}
	public void setQ(Double q) {
		this.q = q;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getResNm() {
		return resNm;
	}
	public void setResNm(String resNm) {
		this.resNm = resNm;
	}
	public Integer getRcd() {
		return rcd;
	}
	public void setRcd(Integer rcd) {
		this.rcd = rcd;
	}
	public Double getExq() {
		return exq;
	}
	public void setExq(Double exq) {
		this.exq = exq;
	}
	
	
}
