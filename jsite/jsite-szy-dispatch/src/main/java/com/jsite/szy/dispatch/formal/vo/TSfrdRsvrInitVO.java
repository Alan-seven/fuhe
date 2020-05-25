package com.jsite.szy.dispatch.formal.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;

/**
 * 水库初始化Entity
 * @author seven
 *
 */
public class TSfrdRsvrInitVO extends PageVO{
	
	@ApiModelProperty(value = "方案代码")
	private String proCd;
	@ApiModelProperty(value = "实体代码")
	private String enCd;
	@ApiModelProperty(value = "初始水位")
	private Float stz;	//初始水位
	@ApiModelProperty(value = "期末水位")
	private Float edz;	//期末水位
	@ApiModelProperty(value = "初始库容")
	private Float stv;	//初始库容
	@ApiModelProperty(value = "期末库容")
	private Float edv;	//期末库容
	
	public Float getStv() {
		return stv;
	}
	public void setStv(Float stv) {
		this.stv = stv;
	}
	public Float getEdv() {
		return edv;
	}
	public void setEdv(Float edv) {
		this.edv = edv;
	}
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
	public Float getStz() {
		return stz;
	}
	public void setStz(Float stz) {
		this.stz = stz;
	}
	public Float getEdz() {
		return edz;
	}
	public void setEdz(Float edz) {
		this.edz = edz;
	}
	
	
}
