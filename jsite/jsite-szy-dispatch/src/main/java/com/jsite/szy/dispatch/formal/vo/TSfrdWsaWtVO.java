package com.jsite.szy.dispatch.formal.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;

/**
 * 需水预测用水比例指标Entity
 * @author 需水预测用水比例指标
 * @version 2020-04-01
 */
public class TSfrdWsaWtVO extends PageVO{
	@ApiModelProperty(value = "方案编码")
	private String proCd;		//方案编码
	@ApiModelProperty(value = "实体代码")
	private String enCd;		//实体编码
	@ApiModelProperty(value = "时间")
	private Date tm;		//时间
	@ApiModelProperty(value = "工业用水比例")
	private Float indWt;		//工业用水权重
	@ApiModelProperty(value = "农业用水比例")
	private Float agrWt;		//农业用水权重
	@ApiModelProperty(value = "生活用水比例")
	private Float LifWt;		//生活用水权重
	@ApiModelProperty(value = "林牧渔用水比例")
	private Float FafrWt;		//林牧渔用水权重
	
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
