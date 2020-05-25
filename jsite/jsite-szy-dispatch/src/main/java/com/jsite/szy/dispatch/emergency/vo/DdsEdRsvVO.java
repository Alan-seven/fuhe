package com.jsite.szy.dispatch.emergency.vo;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import javax.validation.constraints.NotNull;


/**
 * 应急调度水库调节方式Entity
 * @author hjx
 * @version 2017-06-12
 */
public class DdsEdRsvVO extends PageVO {
	
	private String proCd;		// 方案ID
	private String stcd;		// 测站编码
	private Date tm;		// 时间
	private Double otq;		// 水库下泄流量
	private Double exq;		// 加大下泄量
	private Integer otqtype;//水库下泄流量方式1--读取   2--导入  3--默认值
	private Integer exqtype;//加大下泄量方式1--固值  2--导入
	
	private Integer rcd;
	
	public DdsEdRsvVO() {
		super();
	}


	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间不能为空")
	public Date getTm() {
		return tm;
	}

	@Length(min=1, max=8, message="测站编码长度必须介于 1 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}
	
	public Double getOtq() {
		return otq;
	}

	public void setOtq(Double otq) {
		this.otq = otq;
	}
	
	public Double getExq() {
		return exq;
	}

	public void setExq(Double exq) {
		this.exq = exq;
	}


	public Integer getOtqtype() {
		return otqtype;
	}


	public void setOtqtype(Integer otqtype) {
		this.otqtype = otqtype;
	}


	public Integer getExqtype() {
		return exqtype;
	}


	public void setExqtype(Integer exqtype) {
		this.exqtype = exqtype;
	}


	public Integer getRcd() {
		return rcd;
	}


	public void setRcd(Integer rcd) {
		this.rcd = rcd;
	}
	
}