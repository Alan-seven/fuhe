package com.jsite.szy.dispatch.formal.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;
/**
 * 需水预测逐月分水系数Entity
 * @author 需水预测逐月分水系数
 * @version 2020-03-17
 */
public class TSfrdWsaInitcondVO extends PageVO{

	@ApiModelProperty(value = "方案代码")
	private String proCd;		// 方案代码
	@ApiModelProperty(value = "实体代码")
	private String enCd;		// 实体代码
	@ApiModelProperty(value = "时间")
	private Date tm;		//时间
	@ApiModelProperty(value = "工业逐月用水系数")
	private Double indr;		//工业逐月用水系数
	@ApiModelProperty(value = "生活逐月用水系数")
	private Double lifr;		//生活逐月用水系数
	@ApiModelProperty(value = "农业逐月用水系数")
	private Double agrr;		//农业逐月用水系数
	@ApiModelProperty(value = "林牧渔逐月用水系数")
	private Double fafrr;		//林牧渔逐月用水系数
	@ApiModelProperty(value = "时间戳")
	private Date ts;		// 时间戳
	@ApiModelProperty(value = "备注")
	private String nt;		// 备注
	
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

	public Double getIndr() {
		return indr;
	}

	public void setIndr(Double indr) {
		this.indr = indr;
	}

	public Double getLifr() {
		return lifr;
	}

	public void setLifr(Double lifr) {
		this.lifr = lifr;
	}

	public Double getAgrr() {
		return agrr;
	}

	public void setAgrr(Double agrr) {
		this.agrr = agrr;
	}

	public Double getFafrr() {
		return fafrr;
	}

	public void setFafrr(Double fafrr) {
		this.fafrr = fafrr;
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
