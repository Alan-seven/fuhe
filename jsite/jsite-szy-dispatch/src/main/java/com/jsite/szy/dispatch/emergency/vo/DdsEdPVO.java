package com.jsite.szy.dispatch.emergency.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 应急方案信息表Entity
 * @author hjx
 * @version 2017-06-07
 */
public class DdsEdPVO extends PageVO{

	private String proCd;		// 方案ID
	private String evenCd;		// 事件ID
	private String proTp;		// 方案类型
	private String proNm;		// 方案名称
	private Date pubDt;		// 发布时间
	private Date bgDt;		// 起始时间
	private Date edDt;		// 终止时间
	private String rgTp;		// 时段类型
	private Integer rgLg;		// 时段长度
	private String producer;		// 制作人
	private Date crDt;		// 制作时间
	private Integer sta;		// 状态
	private String evaSta;		// 评价状态
	private Date ts;		// 时间戳
	private String nt;		// 备注
	
	private String evenTp;		// 事件类型
	private String loc;		// 位置
	private Double bgco;	//物质初始浓度
	private Integer forTime;		//预热期
	private Integer rcd;
	
	private String startTime;
	private String endTime;
	
	private String stype;	//类型，判断是水质模拟--1，还是水量调度 -- 2
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	public DdsEdPVO() {
		super();
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=8, message="事件ID长度必须介于 1 和 8 之间")
	public String getEvenCd() {
		return evenCd;
	}

	public void setEvenCd(String evenCd) {
		this.evenCd = evenCd;
	}
	
	@Length(min=0, max=10, message="方案类型长度必须介于 0 和 10 之间")
	public String getProTp() {
		return proTp;
	}

	public void setProTp(String proTp) {
		this.proTp = proTp;
	}
	
	@Length(min=0, max=60, message="方案名称长度必须介于 0 和 60 之间")
	public String getProNm() {
		return proNm;
	}

	public void setProNm(String proNm) {
		this.proNm = proNm;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPubDt() {
		return pubDt;
	}

	public void setPubDt(Date pubDt) {
		this.pubDt = pubDt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBgDt() {
		return bgDt;
	}

	public void setBgDt(Date bgDt) {
		this.bgDt = bgDt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEdDt() {
		return edDt;
	}

	public void setEdDt(Date edDt) {
		this.edDt = edDt;
	}
	
	@Length(min=0, max=10, message="时段类型长度必须介于 0 和 10 之间")
	public String getRgTp() {
		return rgTp;
	}

	public void setRgTp(String rgTp) {
		this.rgTp = rgTp;
	}
	
	public Integer getRgLg() {
		return rgLg;
	}

	public void setRgLg(Integer rgLg) {
		this.rgLg = rgLg;
	}
	
	@Length(min=0, max=64, message="制作人长度必须介于 0 和 64 之间")
	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCrDt() {
		return crDt;
	}

	public void setCrDt(Date crDt) {
		this.crDt = crDt;
	}
	
	public Integer getSta() {
		return sta;
	}

	public void setSta(Integer sta) {
		this.sta = sta;
	}
	
	@Length(min=0, max=100, message="评价状态长度必须介于 0 和 100 之间")
	public String getEvaSta() {
		return evaSta;
	}

	public void setEvaSta(String evaSta) {
		this.evaSta = evaSta;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

	public String getEvenTp() {
		return evenTp;
	}

	public void setEvenTp(String evenTp) {
		this.evenTp = evenTp;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Length(min=0, max=30, message="预热期长度必须介于 0 和 3 之间")
	public Integer getForTime() {
		return forTime;
	}

	public void setForTime(Integer forTime) {
		this.forTime = forTime;
	}

	public Integer getRcd() {
		return rcd;
	}

	public void setRcd(Integer rcd) {
		this.rcd = rcd;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public Double getBgco() {
		return bgco;
	}

	public void setBgco(Double bgco) {
		this.bgco = bgco;
	}

}
