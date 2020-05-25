package com.jsite.szy.dispatch.info.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 水位流量年月旬均值系列表Entity
 * @author hjx
 * @version 2017-11-30
 */
public class DdsDrRvdmmysqVO extends PageVO {

	private String stcd;	//测站编码
	
	private Integer yr;		//年份
			
	private Integer mnth;	//月份 1---12
	
	/**
	 * 1--上旬  
	 * 2--中旬
	 * 3--下旬
	 */
	private Integer prdtp;	//旬   
		
	private Double avz;    //平均水位
	
	private Double avq;		//平均流量
	
	private Date moditime;	//时间戳
	
	private String river;
	
	public DdsDrRvdmmysqVO(){
		
	}

	@Length(min=1, max=8, message="测站代码长度必须介于 1 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}

	public Integer getYr() {
		return yr;
	}

	public void setYr(Integer yr) {
		this.yr = yr;
	}

	public Integer getMnth() {
		return mnth;
	}

	public void setMnth(Integer mnth) {
		this.mnth = mnth;
	}

	public Integer getPrdtp() {
		return prdtp;
	}

	public void setPrdtp(Integer prdtp) {
		this.prdtp = prdtp;
	}

	public Double getAvz() {
		return avz;
	}

	public void setAvz(Double avz) {
		this.avz = avz;
	}

	public Double getAvq() {
		return avq;
	}

	public void setAvq(Double avq) {
		this.avq = avq;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getModitime() {
		return moditime;
	}

	public void setModitime(Date moditime) {
		this.moditime = moditime;
	}

	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
}
