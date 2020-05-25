package com.jsite.busi.szy.formal.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;


/**
 * 需水预测计算结果Entity
 * @author 可供水量计算结果
 * @version 2020-03-17
 */
public class TSfrdWsaRslt extends AbstractData<TSfrdWsaRslt> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案代码
	private String enCd;		// 实体代码
	private Date tm;		//时间
	private Double indw;		//工业逐月需水量
	private Double lifw;		//生活逐月需水量
	private Double agrw;		//农业逐月需水量
	private Double fafrw;		//林牧渔逐月需水量
	private Date ts;		// 时间戳
	private String nt;		// 备注
	
	public TSfrdWsaRslt() {
		super();
	}

	public TSfrdWsaRslt(String id){
		super(id);
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

	public Double getIndw() {
		return indw;
	}

	public void setIndw(Double indw) {
		this.indw = indw;
	}

	public Double getLifw() {
		return lifw;
	}

	public void setLifw(Double lifw) {
		this.lifw = lifw;
	}

	public Double getAgrw() {
		return agrw;
	}

	public void setAgrw(Double agrw) {
		this.agrw = agrw;
	}

	public Double getFafrw() {
		return fafrw;
	}

	public void setFafrw(Double fafrw) {
		this.fafrw = fafrw;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}