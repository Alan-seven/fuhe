package com.jsite.szy.dispatch.formal.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;
/**
 * 用水计划核定初始条件Entity
 * @author 用水计划核定初始条件
 * @version 2020-03-17
 */
public class TSfrdWtrplanVerInitcondVO extends PageVO{
	@ApiModelProperty(value = "方案代码")
	private String proCd;		// 方案代码
	@ApiModelProperty(value = "实体代码")
	private String enCd;		// 实体代码
	@ApiModelProperty(value = "是否完成")
	private String isFnsh;		// 是否完成
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
	
	@Length(min=1, max=1, message="是否完成长度必须介于 1 和 1 之间")
	public String getIsFnsh() {
		return isFnsh;
	}

	public void setIsFnsh(String isFnsh) {
		this.isFnsh = isFnsh;
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
