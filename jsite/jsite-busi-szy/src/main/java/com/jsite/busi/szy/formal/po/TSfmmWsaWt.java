package com.jsite.busi.szy.formal.po;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.jsite.dao.AbstractData;

/**
 * 需水预测基准参数信息表Entity
 * @author 
 * @version 2020-03-17
 */
public class TSfmmWsaWt extends AbstractData<TSfmmWsaWt>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String enCd;		//实体编码
	private int yr;				//基准年
	private Float rate;			//频率
	private Float lifw;			//生活用水
	private Float agrw;			//农业用水
	private Float indw;			//工作用水
	private Float fafrw;		//林牧渔用水
	private Float totalw;		//总用水量
	private Float indwt;		//工业用水比例
	private Float agrwt;		//农业用水比例
	private Float fafrwt;		//林牧渔用水比例
	private Float lifwt;		//生活用水比例
	@NotNull(message="实体代码代码不能为空")
	@Length(min=1, max=9, message="实体代码代码标识长度必须介于 1 和 9 之间")
	public String getEnCd() {
		return enCd;
	}
	public void setEnCd(String enCd) {
		this.enCd = enCd;
	}
	@NotNull(message="基准年不能为空")
	@Range(min = 1990,max = 2100,message="基准年数据介于1990年至2100年之间")
	public int getYr() {
		return yr;
	}
	public void setYr(int yr) {
		this.yr = yr;
	}
	@NotNull(message="频率不能为空")
	@Range(min = 0,max = 1,message="频率数据介于0年至1年之间")
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public Float getLifw() {
		return lifw;
	}
	public void setLifw(Float lifw) {
		this.lifw = lifw;
	}
	public Float getAgrw() {
		return agrw;
	}
	public void setAgrw(Float agrw) {
		this.agrw = agrw;
	}
	public Float getIndw() {
		return indw;
	}
	public void setIndw(Float indw) {
		this.indw = indw;
	}
	public Float getFafrw() {
		return fafrw;
	}
	public void setFafrw(Float fafrw) {
		this.fafrw = fafrw;
	}
	public Float getTotalw() {
		return totalw;
	}
	public void setTotalw(Float totalw) {
		this.totalw = totalw;
	}
	@Range(min = 0,max = 1,message="工业用水比例数据介于0年至1年之间")
	public Float getIndwt() {
		return indwt;
	}
	public void setIndwt(Float indwt) {
		this.indwt = indwt;
	}
	@Range(min = 0,max = 1,message="农业用水比例数据介于0年至1年之间")
	public Float getAgrwt() {
		return agrwt;
	}
	public void setAgrwt(Float agrwt) {
		this.agrwt = agrwt;
	}
	@Range(min = 0,max = 1,message="林牧渔用水比例数据介于0年至1年之间")
	public Float getFafrwt() {
		return fafrwt;
	}
	public void setFafrwt(Float fafrwt) {
		this.fafrwt = fafrwt;
	}
	@Range(min = 0,max = 1,message="生活用水比例数据介于0年至1年之间")
	public Float getLifwt() {
		return lifwt;
	}
	public void setLifwt(Float lifwt) {
		this.lifwt = lifwt;
	}
	

}
