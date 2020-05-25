package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;


/**
 * 应急调度水库调节设置初始条件Entity
 * @author hjx
 * @version 2017-07-10
 */
public class DdsMRsvr extends AbstractData<DdsMRsvr> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String resCd;		// 水库代码
	private String resNm;		//水库名称
	private Double z;		// 初始水位
	private Double q;		// 原计划下泄流量
	private Date starttime;		// 释染起始时间
	private Date endtime;		// 释染结束时间
	private String type;		// 加大下泄方式
	private Integer rcd;		//河段编号
	private Double exq;		//加大下泄方式固值
	private String stcd;		//测站编码
	
	public DdsMRsvr() {
		super();
	}

	public DdsMRsvr(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=12, message="水库代码长度必须介于 1 和 12 之间")
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
	@Length(min=0, max=50, message="加大下泄方式长度必须介于 0 和 50 之间")
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

	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}

	public Double getExq() {
		return exq;
	}

	public void setExq(Double exq) {
		this.exq = exq;
	}
	
}