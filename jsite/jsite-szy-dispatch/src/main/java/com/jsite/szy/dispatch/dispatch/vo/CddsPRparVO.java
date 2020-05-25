package com.jsite.szy.dispatch.dispatch.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

public class CddsPRparVO extends PageVO {

	private String proCd;		// 方案ID
	private String proNm;		// 方案名称
	private String bywq;		// 基准年
	private String pyr;		// 预测年
	private String fj;		// 完成度
	private Date lastmodDt;		// 最后修改时间
	private String postSta;		// 发布状态

	public CddsPRparVO(){
		super();
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=60, message="方案名称长度必须介于 1 和 60 之间")
	public String getProNm() {
		return proNm;
	}

	public void setProNm(String proNm) {
		this.proNm = proNm;
	}
	
	@Length(min=1, max=4, message="基准年长度必须介于 1 和 4 之间")
	public String getBywq() {
		return bywq;
	}

	public void setBywq(String bywq) {
		this.bywq = bywq;
	}
	
	@Length(min=1, max=4, message="预测年长度必须介于 1 和 4 之间")
	public String getPyr() {
		return pyr;
	}

	public void setPyr(String pyr) {
		this.pyr = pyr;
	}
	
	@Length(min=0, max=1, message="完成度长度必须介于 0 和 1 之间")
	public String getFj() {
		return fj;
	}

	public void setFj(String fj) {
		this.fj = fj;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastmodDt() {
		return lastmodDt;
	}

	public void setLastmodDt(Date lastmodDt) {
		this.lastmodDt = lastmodDt;
	}
	
	@Length(min=0, max=1, message="发布状态长度必须介于 0 和 1 之间")
	public String getPostSta() {
		return postSta;
	}

	public void setPostSta(String postSta) {
		this.postSta = postSta;
	}
	
}
