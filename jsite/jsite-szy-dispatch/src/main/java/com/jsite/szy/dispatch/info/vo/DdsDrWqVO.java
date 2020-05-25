package com.jsite.szy.dispatch.info.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 水质信息Entity
 * @author 徐旺旺
 * @version 2017-03-21
 */
public class DdsDrWqVO extends PageVO {
	
	private String stcd;		// 测站编码
	private String stNm ;		//测站名称
	private Date spt;		// 采样时间
	private Float wt;		// 水温
	private Float ph;		// PH
	private Float codcr;	//化学需氧量
	private Float nh3n;		//氨氮
	private Float codmn;		// 高锰酸盐
	private Float tp;		//总磷
	private Float cond;
	private Float turb;
	private Float dox;
	private Float tn;
	private Float no2;
	private Float no3;
	private Float toc;
	private Float vlph;
	private Float chla;
	private Float f;
	private Float ars;
	private Float hg;
	private Float cr6;
	private Float cu;
	private Float pb;
	private Float cd;
	private Float zn;
	private Float sb;
	
	private Double lgtd;		// 经度
	private Double lttd;		// 纬度
	
	private String startTm;  	//查询开始时间
	private String endTm;  	//查询结束时间
	private String river; //河流标识  后续需要配置到系统管理中 
	
	public DdsDrWqVO() {
		super();
	}

	@Length(min=0, max=8, message="测站编码长度必须介于 0 和 8 之间")
	@NotNull(message="测站编码不能为空")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@Length(min=0, max=30, message="测站名称长度必须介于 0 和 30之间")
	@NotNull(message="测站名称不能为空")
	public String getStNm() {
		return stNm;
	}

	public void setStNm(String stNm) {
		this.stNm = stNm;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间不能为空")
	public Date getSpt() {
		return spt;
	}

	public void setSpt(Date spt) {
		this.spt = spt;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public String getStartTm() {
		return startTm;
	}

	public void setStartTm(String startTm) {
		this.startTm = startTm;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

	public Float getCond() {
		return cond;
	}

	public void setCond(Float cond) {
		this.cond = cond;
	}

	public Float getTurb() {
		return turb;
	}

	public void setTurb(Float turb) {
		this.turb = turb;
	}

	public Float getDox() {
		return dox;
	}

	public void setDox(Float dox) {
		this.dox = dox;
	}

	public Float getTn() {
		return tn;
	}

	public void setTn(Float tn) {
		this.tn = tn;
	}

	public Float getNo2() {
		return no2;
	}

	public void setNo2(Float no2) {
		this.no2 = no2;
	}

	public Float getNo3() {
		return no3;
	}

	public void setNo3(Float no3) {
		this.no3 = no3;
	}

	public Float getToc() {
		return toc;
	}

	public void setToc(Float toc) {
		this.toc = toc;
	}

	public Float getVlph() {
		return vlph;
	}

	public void setVlph(Float vlph) {
		this.vlph = vlph;
	}

	public Float getChla() {
		return chla;
	}

	public void setChla(Float chla) {
		this.chla = chla;
	}

	public Float getF() {
		return f;
	}

	public void setF(Float f) {
		this.f = f;
	}

	public Float getArs() {
		return ars;
	}

	public void setArs(Float ars) {
		this.ars = ars;
	}

	public Float getHg() {
		return hg;
	}

	public void setHg(Float hg) {
		this.hg = hg;
	}

	public Float getCr6() {
		return cr6;
	}

	public void setCr6(Float cr6) {
		this.cr6 = cr6;
	}

	public Float getCu() {
		return cu;
	}

	public void setCu(Float cu) {
		this.cu = cu;
	}

	public Float getPb() {
		return pb;
	}

	public void setPb(Float pb) {
		this.pb = pb;
	}

	public Float getCd() {
		return cd;
	}

	public void setCd(Float cd) {
		this.cd = cd;
	}

	public Float getZn() {
		return zn;
	}
	public Float getWt() {
		return wt;
	}

	public Float getPh() {
		return ph;
	}

	public Float getCodcr() {
		return codcr;
	}

	public Float getNh3n() {
		return nh3n;
	}

	public Float getCodmn() {
		return codmn;
	}

	public Float getTp() {
		return tp;
	}

	public void setZn(Float zn) {
		this.zn = zn;
	}

	public Float getSb() {
		return sb;
	}

	public void setSb(Float sb) {
		this.sb = sb;
	}

	public void setWt(Float wt) {
		this.wt = wt;
	}

	public void setPh(Float ph) {
		this.ph = ph;
	}

	public void setCodcr(Float codcr) {
		this.codcr = codcr;
	}

	public void setNh3n(Float nh3n) {
		this.nh3n = nh3n;
	}

	public void setCodmn(Float codmn) {
		this.codmn = codmn;
	}

	public void setTp(Float tp) {
		this.tp = tp;
	}
	
}