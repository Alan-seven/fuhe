package com.jsite.szy.dispatch.info.vo;

import com.jsite.core.web.PageVO;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBWqstVO extends PageVO{
	
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
	
	public DdsBWqstVO() {
		super();
	}

	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	public String getStnm() {
		return stnm;
	}

	public void setStnm(String stnm) {
		this.stnm = stnm;
	}
	
	public String getStgrd() {
		return stgrd;
	}

	public void setStgrd(String stgrd) {
		this.stgrd = stgrd;
	}
	
	public String getBsnm() {
		return bsnm;
	}

	public void setBsnm(String bsnm) {
		this.bsnm = bsnm;
	}
	
	public String getHnnm() {
		return hnnm;
	}

	public void setHnnm(String hnnm) {
		this.hnnm = hnnm;
	}
	
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
	
	public String getStlc() {
		return stlc;
	}

	public void setStlc(String stlc) {
		this.stlc = stlc;
	}
	
	public String getAddvcs() {
		return addvcs;
	}

	public void setAddvcs(String addvcs) {
		this.addvcs = addvcs;
	}
	
	public String getWrrcd() {
		return wrrcd;
	}

	public void setWrrcd(String wrrcd) {
		this.wrrcd = wrrcd;
	}
	
	public String getWfrcd() {
		return wfrcd;
	}

	public void setWfrcd(String wfrcd) {
		this.wfrcd = wfrcd;
	}
	
	public String getAdag() {
		return adag;
	}

	public void setAdag(String adag) {
		this.adag = adag;
	}
	
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
	
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}