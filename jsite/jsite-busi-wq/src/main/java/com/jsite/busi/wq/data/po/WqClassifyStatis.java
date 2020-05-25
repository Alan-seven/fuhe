package com.jsite.busi.wq.data.po;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 水质分类统计Entity
 * @author 徐旺旺
 * @version 2017-04-09
 */
public class WqClassifyStatis extends AbstractData<WqClassifyStatis> {
	
	private static final long serialVersionUID = 1L;
	private String stcd;		// stcd
	private String wqg;		// 水质分类
	private String times;		// 数量
	private String ratio;		// 占比
	private Date tm;		// tm
	private String sttdrcd;		// 统计时段标志1一日，2三日，3一侯，4一旬，5一月，6一年
	
	public WqClassifyStatis() {
		super();
	}

	public WqClassifyStatis(String id){
		super(id);
	}

	@Length(min=0, max=10, message="stcd长度必须介于 0 和 10 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@Length(min=0, max=1, message="水质分类长度必须介于 0 和 1 之间")
	public String getWqg() {
		return wqg;
	}

	public void setWqg(String wqg) {
		this.wqg = wqg;
	}
	
	@Length(min=0, max=11, message="数量长度必须介于 0 和 11 之间")
	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}
	
	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
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