package com.jsite.busi.wq.data.po;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 水质超标统计Entity
 * @author 徐旺旺
 * @version 2017-04-09
 */
public class WqOutStatis extends AbstractData<WqOutStatis> {
	
	private static final long serialVersionUID = 1L;
	private String stcd;		// stcd
	private String out;		// 超标物
	private String times;		// 超标倍数
	private Date tm;		// tm
	private String sttdrcd;		// 统计时段标志1一日，2三日，3一侯，4一旬，5一月，6一年
	
	public WqOutStatis() {
		super();
	}

	public WqOutStatis(String id){
		super(id);
	}

	@Length(min=0, max=10, message="stcd长度必须介于 0 和 10 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@Length(min=0, max=255, message="超标物长度必须介于 0 和 255 之间")
	public String getOut() {
		return out;
	}

	public void setOut(String out) {
		this.out = out;
	}
	
	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}
	
	@Length(min=0, max=1, message="统计时段标志1一日，2三日，3一侯，4一旬，5一月，6一年长度必须介于 0 和 1 之间")
	public String getSttdrcd() {
		return sttdrcd;
	}

	public void setSttdrcd(String sttdrcd) {
		this.sttdrcd = sttdrcd;
	}
	
}