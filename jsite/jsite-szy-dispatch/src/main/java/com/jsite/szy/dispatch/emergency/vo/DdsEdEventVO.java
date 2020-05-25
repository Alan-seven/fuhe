package com.jsite.szy.dispatch.emergency.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 应急事件信息表Entity
 * @author hjx
 * @version 2017-06-07
 */
public class DdsEdEventVO extends PageVO{

	private String evenCd;		// 事件ID
	private String evenNm;		// 事件名称
	private String evenTp;		// 事件类型
	private Date hapDt;		// 发生时间
	private Integer rcd	;		//发生河道编号
	private String pubTp;		// 发布方式
	private String evenG;		// 事件等级
	private String evenD;		// 事件描述
	private String pubU;		// 发布用户
	private Date pubDt;		// 发布时间
	private String plS;		// 处置状态
	private Date ts;		// 时间戳
	private String nt;		// 备注    1--从超图同步数据
	
	private String startTime; //查询开始时间
	private String endTime;	//查询结束时间
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	public DdsEdEventVO() {
		super();
	}

	@Length(min=1, max=8, message="事件ID长度必须介于 1 和 8 之间")
	public String getEvenCd() {
		return evenCd;
	}

	public void setEvenCd(String evenCd) {
		this.evenCd = evenCd;
	}
	
	@Length(min=1, max=100, message="事件名称长度必须介于 1 和 100 之间")
	public String getEvenNm() {
		return evenNm;
	}

	public void setEvenNm(String evenNm) {
		this.evenNm = evenNm;
	}
	
	@Length(min=0, max=2, message="事件类型长度必须介于 0 和 2 之间")
	public String getEvenTp() {
		return evenTp;
	}

	public void setEvenTp(String evenTp) {
		this.evenTp = evenTp;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getHapDt() {
		return hapDt;
	}

	public void setHapDt(Date hapDt) {
		this.hapDt = hapDt;
	}
	
	public Integer getRcd() {
		return rcd;
	}

	public void setRcd(Integer rcd) {
		this.rcd = rcd;
	}
	
	@Length(min=0, max=2, message="发布方式长度必须介于 0 和 2 之间")
	public String getPubTp() {
		return pubTp;
	}

	public void setPubTp(String pubTp) {
		this.pubTp = pubTp;
	}
	
	@Length(min=0, max=2, message="事件等级长度必须介于 0 和 2 之间")
	public String getEvenG() {
		return evenG;
	}

	public void setEvenG(String evenG) {
		this.evenG = evenG;
	}
	
	@Length(min=0, max=200, message="事件描述长度必须介于 0 和 200 之间")
	public String getEvenD() {
		return evenD;
	}

	public void setEvenD(String evenD) {
		this.evenD = evenD;
	}
	
	@Length(min=0, max=2, message="发布用户长度必须介于 0 和 2 之间")
	public String getPubU() {
		return pubU;
	}

	public void setPubU(String pubU) {
		this.pubU = pubU;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPubDt() {
		return pubDt;
	}

	public void setPubDt(Date pubDt) {
		this.pubDt = pubDt;
	}
	
	@Length(min=0, max=2, message="处置状态长度必须介于 0 和 2 之间")
	public String getPlS() {
		return plS;
	}

	public void setPlS(String plS) {
		this.plS = plS;
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

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}
