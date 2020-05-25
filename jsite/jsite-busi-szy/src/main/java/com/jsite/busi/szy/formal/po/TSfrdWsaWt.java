package com.jsite.busi.szy.formal.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 需水预测用水比例指标Entity
 * @author 需水预测用水比例指标
 * @version 2020-04-01
 */
public class TSfrdWsaWt extends AbstractData<TSfrdWsaWt>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String proCd;		//方案编码
	private String enCd;		//实体编码
	private Date tm;		//时间
	private Float indWt;		//工业用水比例
	private Float agrWt;		//农业用水比例
	private Float LifWt;		//生活用水比例
	private Float FafrWt;		//林牧渔用水比例
	
	public TSfrdWsaWt(){
		super();
	}
	
	@NotNull(message="方案代码不能为空")
	@Length(min=1, max=20, message="方案代码长度必须介于 1 和 20 之间")
	public String getProCd() {
		return proCd;
	}
	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	@NotNull(message="实体代码不能为空")
	@Length(min=1, max=9, message="实体代码长度必须介于 1 和 9 之间")
	public String getEnCd() {
		return enCd;
	}
	public void setEnCd(String enCd) {
		this.enCd = enCd;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTm() {
		return tm;
	}
	public void setTm(Date tm) {
		this.tm = tm;
	}
	public Float getIndWt() {
		return indWt;
	}
	public void setIndWt(Float indWt) {
		this.indWt = indWt;
	}
	public Float getAgrWt() {
		return agrWt;
	}
	public void setAgrWt(Float agrWt) {
		this.agrWt = agrWt;
	}
	public Float getLifWt() {
		return LifWt;
	}
	public void setLifWt(Float lifWt) {
		LifWt = lifWt;
	}
	public Float getFafrWt() {
		return FafrWt;
	}
	public void setFafrWt(Float fafrWt) {
		FafrWt = fafrWt;
	}
	
	
	
}
