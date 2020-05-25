package com.jsite.szy.dispatch.formal.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;

/**
 * 需水预测计算结果Entity
 * @author 需水预测计算结果
 * @version 2020-03-17
 */
public class TSfrdWsaRsltVO extends PageVO{
	@ApiModelProperty(value = "方案代码")
	private String proCd;		// 方案代码
	@ApiModelProperty(value = "实体代码")
	private String enCd;		// 实体代码
	@ApiModelProperty(value = "时间")
	private Date tm;		//时间
	@ApiModelProperty(value = "工业逐月需水量")
	private Double indw;		//工业逐月需水量
	@ApiModelProperty(value = "生活逐月需水量")
	private Double lifw;		//生活逐月需水量
	@ApiModelProperty(value = "农业逐月需水量")
	private Double agrw;		//农业逐月需水量
	@ApiModelProperty(value = "林牧渔逐月需水量")
	private Double fafrw;		//林牧渔逐月需水量
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
	
	public String getEnCd() {
		return enCd;
	}

	public void setEnCd(String enCd) {
		this.enCd = enCd;
	}

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

	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
}
