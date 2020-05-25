/**
 */
package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;


/**
 * 应急调度方案结果评价表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsEdEva extends AbstractData<DdsEdEva> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String factId;		// 指标编码
	private String factNm;		//指标名称
	private Double value;		// 指标值
	private String nt;		// nt
	
	private String evenCd;	
	private double mavalue;
	private double mivalue;
	
	public DdsEdEva() {
		super();
	}

	public DdsEdEva(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=20, message="指标名称长度必须介于 1 和 20 之间")
	public String getFactId() {
		return factId;
	}

	public void setFactId(String factId) {
		this.factId = factId;
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	@Length(min=0, max=256, message="nt长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

	public String getEvenCd() {
		return evenCd;
	}

	public void setEvenCd(String evenCd) {
		this.evenCd = evenCd;
	}

	public double getMavalue() {
		return mavalue;
	}

	public void setMavalue(double mavalue) {
		this.mavalue = mavalue;
	}

	public double getMivalue() {
		return mivalue;
	}

	public void setMivalue(double mivalue) {
		this.mivalue = mivalue;
	}

	public String getFactNm() {
		return factNm;
	}

	public void setFactNm(String factNm) {
		this.factNm = factNm;
	}
	
}