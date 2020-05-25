package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;


/**
 * 应急调度模型参数表Entity
 * @author hjx
 * @version 2017-06-12
 */
public class DdsEdMedel extends AbstractData<DdsEdMedel> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private Double r;		// 糙率
	private Double a;		// 扩散系数
	private Double k;		// 衰减系数
	private String hydro;		// 水文预报参数
	
	public DdsEdMedel() {
		super();
	}

	public DdsEdMedel(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	public Double getR() {
		return r;
	}

	public void setR(Double r) {
		this.r = r;
	}
	
	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}
	
	public Double getK() {
		return k;
	}

	public void setK(Double k) {
		this.k = k;
	}
	
	public String getHydro() {
		return hydro;
	}

	public void setHydro(String hydro) {
		this.hydro = hydro;
	}
	
}