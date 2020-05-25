package com.jsite.szy.dispatch.emergency.vo;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;

/**
 * 模型控制断面表Entity
 * @author hjx
 * @version 2017-07-05
 */
public class DdsMConsecVO extends PageVO {
	
	private Integer rcd;		// 污染发生河段代码
	private String secid;		// 河道断面ID
	private String secflag;		// 上下边界标志
	private Double lendelta;		// 距离上一个断面的距离
	private Double lenup;		// 距离上边界的里程km
	private String secnm;		//断面名称
	private String stype;		//断面类型
	private String flag;	//数据类型  0--计算数据  1--自定义数据，不参与调度计算
	
	private String river; //河流标识  后续需要配置到系统管理中 
	private Double lttd;	//纬度
	private Double lgtd;	//经度
	private Integer ord;
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	public DdsMConsecVO() {
		super();
	}

	@NotNull(message="污染发生河段代码不能为空")
	public Integer getRcd() {
		return rcd;
	}

	public void setRcd(Integer rcd) {
		this.rcd = rcd;
	}
	
	@Length(min=1, max=8, message="河道断面ID长度必须介于 1 和 8 之间")
	public String getSecid() {
		return secid;
	}

	public void setSecid(String secid) {
		this.secid = secid;
	}
	
	@Length(min=0, max=10, message="上下边界标志长度必须介于 0 和 10 之间")
	public String getSecflag() {
		return secflag;
	}

	public void setSecflag(String secflag) {
		this.secflag = secflag;
	}
	
	public Double getLendelta() {
		return lendelta;
	}

	public void setLendelta(Double lendelta) {
		this.lendelta = lendelta;
	}
	
	public Double getLenup() {
		return lenup;
	}

	public void setLenup(Double lenup) {
		this.lenup = lenup;
	}

	public String getSecnm() {
		return secnm;
	}

	public void setSecnm(String secnm) {
		this.secnm = secnm;
	}

	@Length(min=0, max=30, message="断面类型长度必须介于 0 和 30 之间")
	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Double getLttd() {
		return lttd;
	}

	public void setLttd(Double lttd) {
		this.lttd = lttd;
	}

	public Double getLgtd() {
		return lgtd;
	}

	public void setLgtd(Double lgtd) {
		this.lgtd = lgtd;
	}

	public Integer getOrd() {
		return ord;
	}

	public void setOrd(Integer ord) {
		this.ord = ord;
	}

}