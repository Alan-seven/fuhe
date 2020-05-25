package com.jsite.busi.szy.info.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBWqst extends AbstractData<DdsBWqst> {
	
	private static final long serialVersionUID = 1L;
	private String stcd;		// 测站编码
	private String stnm;		// 测站名称
	private String stgrd;		// 测站等级
	private String bsnm;		// 流域名称
	private String hnnm;		// 水系名称
	private String rvnm;		// 河流名称
	private String lgtd;		// 经度
	private String lttd;		// 纬度
	private String stlc;		// 站址
	private String addvcs;		// 行政区划码
	private String wrrcd;		// 水资源分区码
	private String wfrcd;		// 水功能区划码
	private String adag;		// 管理单位
	private String mnag;		// 监测单位
	private String mnfrq;		// 监测频次（次/年）
	private String atmn;		// 自动监测
	private String esstym;		// 建站年月
	private String wdstym;		// 撤站年月
	private String nt;		// 备注
	
	public DdsBWqst() {
		super();
	}

	public DdsBWqst(String id){
		super(id);
	}

	@Length(min=0, max=8, message="测站编码长度必须介于 0 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@Length(min=0, max=30, message="测站名称长度必须介于 0 和 30 之间")
	public String getStnm() {
		return stnm;
	}

	public void setStnm(String stnm) {
		this.stnm = stnm;
	}
	
	@Length(min=0, max=1, message="测站等级长度必须介于 0 和 1 之间")
	public String getStgrd() {
		return stgrd;
	}

	public void setStgrd(String stgrd) {
		this.stgrd = stgrd;
	}
	
	@Length(min=0, max=30, message="流域名称长度必须介于 0 和 30 之间")
	public String getBsnm() {
		return bsnm;
	}

	public void setBsnm(String bsnm) {
		this.bsnm = bsnm;
	}
	
	@Length(min=0, max=30, message="水系名称长度必须介于 0 和 30 之间")
	public String getHnnm() {
		return hnnm;
	}

	public void setHnnm(String hnnm) {
		this.hnnm = hnnm;
	}
	
	@Length(min=0, max=30, message="河流名称长度必须介于 0 和 30 之间")
	public String getRvnm() {
		return rvnm;
	}

	public void setRvnm(String rvnm) {
		this.rvnm = rvnm;
	}
	
	public String getLgtd() {
		return lgtd;
	}

	public void setLgtd(String lgtd) {
		this.lgtd = lgtd;
	}
	
	public String getLttd() {
		return lttd;
	}

	public void setLttd(String lttd) {
		this.lttd = lttd;
	}
	
	@Length(min=0, max=40, message="站址长度必须介于 0 和 40 之间")
	public String getStlc() {
		return stlc;
	}

	public void setStlc(String stlc) {
		this.stlc = stlc;
	}
	
	@Length(min=0, max=6, message="行政区划码长度必须介于 0 和 6 之间")
	public String getAddvcs() {
		return addvcs;
	}

	public void setAddvcs(String addvcs) {
		this.addvcs = addvcs;
	}
	
	@Length(min=0, max=7, message="水资源分区码长度必须介于 0 和 7 之间")
	public String getWrrcd() {
		return wrrcd;
	}

	public void setWrrcd(String wrrcd) {
		this.wrrcd = wrrcd;
	}
	
	@Length(min=0, max=14, message="水功能区划码长度必须介于 0 和 14 之间")
	public String getWfrcd() {
		return wfrcd;
	}

	public void setWfrcd(String wfrcd) {
		this.wfrcd = wfrcd;
	}
	
	@Length(min=0, max=40, message="管理单位长度必须介于 0 和 40 之间")
	public String getAdag() {
		return adag;
	}

	public void setAdag(String adag) {
		this.adag = adag;
	}
	
	@Length(min=0, max=40, message="监测单位长度必须介于 0 和 40 之间")
	public String getMnag() {
		return mnag;
	}

	public void setMnag(String mnag) {
		this.mnag = mnag;
	}
	
	public String getMnfrq() {
		return mnfrq;
	}

	public void setMnfrq(String mnfrq) {
		this.mnfrq = mnfrq;
	}
	
	public String getAtmn() {
		return atmn;
	}

	public void setAtmn(String atmn) {
		this.atmn = atmn;
	}
	
	public String getEsstym() {
		return esstym;
	}

	public void setEsstym(String esstym) {
		this.esstym = esstym;
	}
	
	public String getWdstym() {
		return wdstym;
	}

	public void setWdstym(String wdstym) {
		this.wdstym = wdstym;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}