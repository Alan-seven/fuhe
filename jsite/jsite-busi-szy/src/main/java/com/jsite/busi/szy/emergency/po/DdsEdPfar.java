package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;


/**
 * 应急调度预报参数表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsEdPfar extends AbstractData<DdsEdPfar> {
	
	private static final long serialVersionUID = 1L;
	private String proeCd;		// 方案ID
	private String wceCd;		// 水利要素ID
	private String forcTp;		// 预报方式
	private String status;		// 状态
	private String rnm;		// 支流名称
	
	public DdsEdPfar() {
		super();
	}

	public DdsEdPfar(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProeCd() {
		return proeCd;
	}

	public void setProeCd(String proeCd) {
		this.proeCd = proeCd;
	}
	
	@Length(min=1, max=8, message="水利要素ID长度必须介于 1 和 8 之间")
	public String getWceCd() {
		return wceCd;
	}

	public void setWceCd(String wceCd) {
		this.wceCd = wceCd;
	}
	
	@Length(min=0, max=32, message="预报方式长度必须介于 0 和 32 之间")
	public String getForcTp() {
		return forcTp;
	}

	public void setForcTp(String forcTp) {
		this.forcTp = forcTp;
	}
	
	@Length(min=0, max=126, message="状态长度必须介于 0 和 126 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=64, message="支流名称长度必须介于 0 和 64 之间")
	public String getRnm() {
		return rnm;
	}

	public void setRnm(String rnm) {
		this.rnm = rnm;
	}
	
}