package com.jsite.szy.dispatch.info.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 降水量Entity
 * @author 徐旺旺
 * @version 2017-03-21
 */
public class DdsDrPptnVO extends PageVO {
	
	private String stcd;		// 测站编码
	private String stNm;		//测站名称
	private Date tm;		// 时间
	private Double drp;		// 时段降水量
	private Double intv;		// 时段长
	private Double pdr;		// 降水历时
	private Double annP;		// 日降水量
	private String wth;		// 天气状况
	
	private String startTm;  	//查询开始时间
	private String endTm;  	//查询结束时间
	private String river; //河流标识  后续需要配置到系统管理中 
	
	public DdsDrPptnVO() {
		super();
	}

	@Length(min=1, max=8, message="测站编码长度必须介于 1 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间不能为空")
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}
	
	public String getStNm() {
		return stNm;
	}

	public void setStNm(String stNm) {
		this.stNm = stNm;
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

	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
}