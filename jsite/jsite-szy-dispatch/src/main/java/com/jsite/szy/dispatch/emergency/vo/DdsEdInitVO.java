package com.jsite.szy.dispatch.emergency.vo;

import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;


/**
 * 应急调度初始条件Entity
 * @author hjx
 * @version 2017-06-12
 */
public class DdsEdInitVO extends PageVO {
	
	private String proCd;		// 方案ID
	private String secid;		// 河道断面ID
	private Double bgZ;		// 起始水位
	private Double bgQ;		// 初始流量
	private Double bgConc;		// 初始污染物浓度
	private Double concSt;		// 污染物浓度标准
	
	public DdsEdInitVO() {
		super();
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=8, message="河道断面ID长度必须介于 1 和 8 之间")
	public String getSecid() {
		return secid;
	}

	public void setSecid(String secid) {
		this.secid = secid;
	}
	
	public Double getBgZ() {
		return bgZ;
	}

	public void setBgZ(Double bgZ) {
		this.bgZ = bgZ;
	}
	
	public Double getBgQ() {
		return bgQ;
	}

	public void setBgQ(Double bgQ) {
		this.bgQ = bgQ;
	}
	
	public Double getBgConc() {
		return bgConc;
	}

	public void setBgConc(Double bgConc) {
		this.bgConc = bgConc;
	}
	
	public Double getConcSt() {
		return concSt;
	}

	public void setConcSt(Double concSt) {
		this.concSt = concSt;
	}
	
}