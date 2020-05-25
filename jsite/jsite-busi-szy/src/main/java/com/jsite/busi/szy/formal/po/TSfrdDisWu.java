package com.jsite.busi.szy.formal.po;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.jsite.dao.AbstractData;

/**
 * 水量分配用水系数Entity
 * @author 
 * @version 2020-03-17
 */
public class TSfrdDisWu  extends AbstractData<TSfrdDisWu>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String proCd;		//方案编码
	private String enCd;		//实体编码
	private Date tm;			//时间
	private Float indWusWt;		//工业用水系数
	private Float agrWusWt;		//农业用水系数
	private Float lifWusWt;		//生活用水系数
	private Float fafrWusWt;	//林牧鱼用水系数
	private Float indReWt;		//工业回归系数
	private Float agrReWt;		//农业回归系数
	private Float lifReWt;		//生活回归系数
	private Float fafrReWt;		//林牧鱼回归系数
	
	private List<TSfrdDisWu> sub = Lists.newArrayList();
	
	@NotNull(message="方案代码不能为空")
	@Length(min=1, max=20, message="方案代码标识长度必须介于 1 和 20 之间")
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
	public Float getIndWusWt() {
		return indWusWt;
	}
	public void setIndWusWt(Float indWusWt) {
		this.indWusWt = indWusWt;
	}
	public Float getAgrWusWt() {
		return agrWusWt;
	}
	public void setAgrWusWt(Float agrWusWt) {
		this.agrWusWt = agrWusWt;
	}
	public Float getLifWusWt() {
		return lifWusWt;
	}
	public void setLifWusWt(Float lifWusWt) {
		this.lifWusWt = lifWusWt;
	}
	public Float getFafrWusWt() {
		return fafrWusWt;
	}
	public void setFafrWusWt(Float fafrWusWt) {
		this.fafrWusWt = fafrWusWt;
	}
	public Float getIndReWt() {
		return indReWt;
	}
	public void setIndReWt(Float indReWt) {
		this.indReWt = indReWt;
	}
	public Float getAgrReWt() {
		return agrReWt;
	}
	public void setAgrReWt(Float agrReWt) {
		this.agrReWt = agrReWt;
	}
	public Float getLifReWt() {
		return lifReWt;
	}
	public void setLifReWt(Float lifReWt) {
		this.lifReWt = lifReWt;
	}
	public Float getFafrReWt() {
		return fafrReWt;
	}
	public void setFafrReWt(Float fafrReWt) {
		this.fafrReWt = fafrReWt;
	}
	public List<TSfrdDisWu> getSub() {
		return sub;
	}
	public void setSub(List<TSfrdDisWu> sub) {
		this.sub = sub;
	}
	
	
	
	

}
