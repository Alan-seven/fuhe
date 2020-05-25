package com.jsite.szy.dispatch.dispatch.vo;

import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;

/**
 * 生活需水基础Entity
 * @author wantwantxu
 *
 */
public class CddsDDwdpVO extends PageVO{

	private String proCd;		//方案ID
	private String wrcsCd;		// 用水区域ID
	private String wrcsNm;		// 用水区域名称
	private String bywq;		// 基准年
	private String bDPop;		// 基期年城市人口
	private String bdRPop;		// 基期年农村人口
	private String bBhQty;		// 基期年大牲畜数量
	private String bShQty;		// 基期年小牲畜数量
	
	public CddsDDwdpVO() {
		super();
	}

	@Length(min=1, max=13, message="用水区域ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}

	@Length(min=1, max=13, message="用水区域ID长度必须介于 1 和 13 之间")
	public String getWrcsCd() {
		return wrcsCd;
	}

	public void setWrcsCd(String wrcsCd) {
		this.wrcsCd = wrcsCd;
	}
	
	@Length(min=1, max=100, message="用水区域名称长度必须介于 1 和 100 之间")
	public String getWrcsNm() {
		return wrcsNm;
	}

	public void setWrcsNm(String wrcsNm) {
		this.wrcsNm = wrcsNm;
	}
	
	@Length(min=1, max=4, message="基准年长度必须介于 1 和 4 之间")
	public String getBywq() {
		return bywq;
	}

	public void setBywq(String bywq) {
		this.bywq = bywq;
	}
	
	public String getBDPop() {
		return bDPop;
	}

	public void setBDPop(String bDPop) {
		this.bDPop = bDPop;
	}
	
	public String getBdRPop() {
		return bdRPop;
	}

	public void setBdRPop(String bdRPop) {
		this.bdRPop = bdRPop;
	}
	
	public String getBBhQty() {
		return bBhQty;
	}

	public void setBBhQty(String bBhQty) {
		this.bBhQty = bBhQty;
	}
	
	public String getBShQty() {
		return bShQty;
	}

	public void setBShQty(String bShQty) {
		this.bShQty = bShQty;
	}
	
}
