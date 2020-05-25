package com.jsite.szy.dispatch.formal.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;
/**
 * 水量调节计算行政区划统计结果Entity
 * @author 水量调节计算行政区划统计结果
 * @version 2020-03-17
 */
public class TSfrdDisAdRsltVO extends PageVO{
	
	@ApiModelProperty(value = "方案代码")
	private String proCd;		// 方案代码
	@ApiModelProperty(value = "实体代码")
	private String enCd;		// 实体代码
	@ApiModelProperty(value = "结果类型")
	private String rsltTp;		// 结果类型
	@ApiModelProperty(value = "用水类型")
	private String wuTp;		// 用水类型
	@ApiModelProperty(value = "需水量(万m3)")
	private Double wat;		// 需水量(万m3)
	@ApiModelProperty(value = "供水量(万m3)")
	private Double ww;		// 供水量(万m3)
	@ApiModelProperty(value = "用水量(万m3)")
	private Double uw;		// 用水量(万m3)
	@ApiModelProperty(value = "退水量(万m3)")
	private Double rw;		// 退水量(万m3)
	@ApiModelProperty(value = "缺水量(万m3)")
	private Double dw;		// 缺水量(万m3)
	@ApiModelProperty(value = "缺水率(%)")
	private Double dwR;		// 缺水率(%)
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
	
	@Length(min=1, max=1, message="结果类型长度必须介于 1 和 1 之间")
	public String getRsltTp() {
		return rsltTp;
	}

	public void setRsltTp(String rsltTp) {
		this.rsltTp = rsltTp;
	}
	
	@Length(min=1, max=3, message="用水类型长度必须介于 1 和 3 之间")
	public String getWuTp() {
		return wuTp;
	}

	public void setWuTp(String wuTp) {
		this.wuTp = wuTp;
	}
	
	public Double getWat() {
		return wat;
	}

	public void setWat(Double wat) {
		this.wat = wat;
	}
	
	public Double getWw() {
		return ww;
	}

	public void setWw(Double ww) {
		this.ww = ww;
	}
	
	public Double getUw() {
		return uw;
	}

	public void setUw(Double uw) {
		this.uw = uw;
	}
	
	public Double getRw() {
		return rw;
	}

	public void setRw(Double rw) {
		this.rw = rw;
	}
	
	public Double getDw() {
		return dw;
	}

	public void setDw(Double dw) {
		this.dw = dw;
	}
	
	public Double getDwR() {
		return dwR;
	}

	public void setDwR(Double dwR) {
		this.dwR = dwR;
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
