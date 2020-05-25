package com.jsite.busi.szy.dispatch.po;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;
/**
 * 水量调度结果评价表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdEva extends AbstractData<DdsRdEva> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String factNm;		// 指标名称
	private String factId;		// 指标编号
	private Double value;		// 指标值
	private String nt;		// 备注
	
	private String proCds;
	private Double mavalue;
	private Double mivalue;
	
	public DdsRdEva() {
		super();
	}

	public DdsRdEva(String id){
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
	public String getFactNm() {
		return factNm;
	}

	public void setFactNm(String factNm) {
		this.factNm = factNm;
	}
	
	@NotNull(message="指标值不能为空")
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

	public String getFactId() {
		return factId;
	}

	public void setFactId(String factId) {
		this.factId = factId;
	}

	public Double getMavalue() {
		return mavalue;
	}

	public void setMavalue(Double mavalue) {
		this.mavalue = mavalue;
	}

	public Double getMivalue() {
		return mivalue;
	}

	public void setMivalue(Double mivalue) {
		this.mivalue = mivalue;
	}

	public String getProCds() {
		return proCds;
	}

	public void setProCds(String proCds) {
		this.proCds = proCds;
	}
	
}