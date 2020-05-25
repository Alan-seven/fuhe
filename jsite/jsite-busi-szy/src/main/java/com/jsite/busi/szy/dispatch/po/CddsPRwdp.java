package com.jsite.busi.szy.dispatch.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;


/**
 * 居民需水计算Entity
 * @author 徐旺旺
 * @version 2017-04-19
 */
public class CddsPRwdp extends AbstractData<CddsPRwdp> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String wrcsCd;		// 用水区域ID
	private String wrcsNm;		// 用水区域名称
	private String totPopGr;		// 总人口增长率
	private String dPopGr;		// 总人口增长率
	private String dWquo;		// 城市人口增长率
	private String rWquo;		// 农村生活用水定额
	private String pDPop;		// 预测年城市人口
	private String pRPop;		// 预测年农村人口
	private String pDNwat;		// 预测年城市生活净需水
	private String pUNwat;		// 预测年农村生活净需水
	
	public CddsPRwdp() {
		super();
	}

	public CddsPRwdp(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
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
	
	public String getTotPopGr() {
		return totPopGr;
	}

	public void setTotPopGr(String totPopGr) {
		this.totPopGr = totPopGr;
	}
	
	public String getDPopGr() {
		return dPopGr;
	}

	public void setDPopGr(String dPopGr) {
		this.dPopGr = dPopGr;
	}
	
	public String getDWquo() {
		return dWquo;
	}

	public void setDWquo(String dWquo) {
		this.dWquo = dWquo;
	}
	
	public String getRWquo() {
		return rWquo;
	}

	public void setRWquo(String rWquo) {
		this.rWquo = rWquo;
	}
	
	public String getPDPop() {
		return pDPop;
	}

	public void setPDPop(String pDPop) {
		this.pDPop = pDPop;
	}
	
	public String getPRPop() {
		return pRPop;
	}

	public void setPRPop(String pRPop) {
		this.pRPop = pRPop;
	}
	
	public String getPDNwat() {
		return pDNwat;
	}

	public void setPDNwat(String pDNwat) {
		this.pDNwat = pDNwat;
	}
	
	public String getPUNwat() {
		return pUNwat;
	}

	public void setPUNwat(String pUNwat) {
		this.pUNwat = pUNwat;
	}
	
}