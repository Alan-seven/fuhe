package com.jsite.busi.szy.info.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-21
 */
public class DdsDrPptn extends AbstractData<DdsDrPptn> {
	
	private static final long serialVersionUID = 1L;
	private String stcd;		// 测站编码
	private String stNm;		//测站名称
	private Date tm;		// 时间
	private Double drp;		// 时段降水量
	private Double intv;		// 时段长
	private Double pdr;		// 降水历时
	private Double annP;		// 日降水量
	private String wth;		// 天气状况
	private Double lgtd;		// 经度
	private Double lttd;		// 纬度
	
	private String startTm;  	//查询开始时间
	private String endTm;  	//查询结束时间
	
	public DdsDrPptn() {
		super();
	}

	public DdsDrPptn(String id){
		super(id);
	}

	@Length(min=1, max=8, message="测站编码长度必须介于 1 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	public String getStNm() {
		return stNm;
	}

	public void setStNm(String stNm) {
		this.stNm = stNm;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间不能为空")
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}
	
	public Double getDrp() {
		return drp;
	}

	public void setDrp(Double drp) {
		this.drp = drp;
	}
	
	public Double getIntv() {
		return intv;
	}

	public void setIntv(Double intv) {
		this.intv = intv;
	}
	
	public Double getPdr() {
		return pdr;
	}

	public void setPdr(Double pdr) {
		this.pdr = pdr;
	}
	
	public Double getAnnP() {
		return annP;
	}

	public void setAnnP(Double annP) {
		this.annP = annP;
	}
	
	@Length(min=0, max=1, message="天气状况长度必须介于 0 和 1 之间")
	public String getWth() {
		return wth;
	}

	public void setWth(String wth) {
		this.wth = wth;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public String getStartTm() {
		return startTm;
	}

	public void setStartTm(String startTm) {
		this.startTm = startTm;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public String getEndTm() {
		return endTm;
	}

	public void setEndTm(String endTm) {
		this.endTm = endTm;
	}

	public Double getLgtd() {
		return lgtd;
	}

	public void setLgtd(Double lgtd) {
		this.lgtd = lgtd;
	}

	public Double getLttd() {
		return lttd;
	}

	public void setLttd(Double lttd) {
		this.lttd = lttd;
	}
	
}