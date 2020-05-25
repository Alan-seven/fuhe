package com.jsite.busi.szy.info.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBAd extends AbstractData<DdsBAd> {
	
	private static final long serialVersionUID = 1L;
	private String adCd;		// 行政区划代码
	private String adNm;		// 行政区划名称
	private String adShnm;		// 行政区划简称
	private String adA;		// 行政区划面积km^2
	private Date ts;		// 时间戳
	private String nt;		// 备注
	
	public DdsBAd() {
		super();
	}

	public DdsBAd(String id){
		super(id);
	}

	@Length(min=1, max=6, message="行政区划代码长度必须介于 1 和 6 之间")
	public String getAdCd() {
		return adCd;
	}

	public void setAdCd(String adCd) {
		this.adCd = adCd;
	}
	
	@Length(min=1, max=100, message="行政区划名称长度必须介于 1 和 100 之间")
	public String getAdNm() {
		return adNm;
	}

	public void setAdNm(String adNm) {
		this.adNm = adNm;
	}
	
	@Length(min=0, max=4, message="行政区划简称长度必须介于 0 和 4 之间")
	public String getAdShnm() {
		return adShnm;
	}

	public void setAdShnm(String adShnm) {
		this.adShnm = adShnm;
	}
	
	public String getAdA() {
		return adA;
	}

	public void setAdA(String adA) {
		this.adA = adA;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间戳不能为空")
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
	
}