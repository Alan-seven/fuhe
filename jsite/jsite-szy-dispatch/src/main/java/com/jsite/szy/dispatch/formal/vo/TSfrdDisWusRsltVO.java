package com.jsite.szy.dispatch.formal.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;

/**
 * 水量调节计算用水单元结果VO
 * @author seven
 *
 */
public class TSfrdDisWusRsltVO extends PageVO{
	
	@ApiModelProperty(value = "方案代码")
	private String proCd;		// 方案代码
	@ApiModelProperty(value = "实体代码")
	private String enCd;		// 实体代码
	@ApiModelProperty(value = "结果类型")
	private String rsltTp;		// 结果类型
	@ApiModelProperty(value = "起始日期")
	private Date stDt;		// 起始日期
	@ApiModelProperty(value = "终止日期")
	private Date edDt;		// 终止日期
	@ApiModelProperty(value = "用水类型")
	private String wuTp;		// 用水类型
	
	@ApiModelProperty(value = "供水量(万m3)")
	private Double ww;		// 供水量(万m3)
	@ApiModelProperty(value = "来水总量(万m3)")
	private Double inw;		// 来水总量(万m3)
	@ApiModelProperty(value = "用水总量(万m3)")
	private Double wu;		// 用水总量(万m3)
	@ApiModelProperty(value = "下泄总量(万m3)")
	private Double dchgw;	//下泄总量
	@ApiModelProperty(value = "申报需水量(万m3)")
	private Double wat;		// 申报需水量(万m3)
	@ApiModelProperty(value = "计划总需水量(万m3)")
	private Double planw;		// 计划总需水量(万m3)
	@ApiModelProperty(value = "需水满足率")
	private Double rwr;		// 需水满足率
	@ApiModelProperty(value = "工业需水量")
	private Double indw;		// 工业需水量
	@ApiModelProperty(value = "农业需水量")
	private Double agrw;		// 农业需水量
	@ApiModelProperty(value = "生活需水量")
	private Double lifw;		// 生活需水量
	@ApiModelProperty(value = "林牧渔需水量")
	private Double fafrw;		// 林牧渔需水量
	@ApiModelProperty(value = "计划分配工业需水量")
	private Double planindw;		// 工业需水量
	@ApiModelProperty(value = "计划分配农业需水量")
	private Double planagrw;		// 农业需水量
	@ApiModelProperty(value = "计划分配生活需水量")
	private Double planlifw;		// 生活需水量
	@ApiModelProperty(value = "计划分配林牧渔需水量")
	private Double planfafrw;		// 林牧渔需水量
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="起始日期不能为空")
	public Date getStDt() {
		return stDt;
	}

	public void setStDt(Date stDt) {
		this.stDt = stDt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="终止日期不能为空")
	public Date getEdDt() {
		return edDt;
	}

	public void setEdDt(Date edDt) {
		this.edDt = edDt;
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
	
	public Double getWu() {
		return wu;
	}

	public void setWu(Double wu) {
		this.wu = wu;
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

	public Double getInw() {
		return inw;
	}

	public void setInw(Double inw) {
		this.inw = inw;
	}

	public Double getDchgw() {
		return dchgw;
	}

	public void setDchgw(Double dchgw) {
		this.dchgw = dchgw;
	}

	public Double getPlanw() {
		return planw;
	}

	public void setPlanw(Double planw) {
		this.planw = planw;
	}

	public Double getRwr() {
		return rwr;
	}

	public void setRwr(Double rwr) {
		this.rwr = rwr;
	}

	public Double getIndw() {
		return indw;
	}

	public void setIndw(Double indw) {
		this.indw = indw;
	}

	public Double getAgrw() {
		return agrw;
	}

	public void setAgrw(Double agrw) {
		this.agrw = agrw;
	}

	public Double getLifw() {
		return lifw;
	}

	public void setLifw(Double lifw) {
		this.lifw = lifw;
	}

	public Double getFafrw() {
		return fafrw;
	}

	public void setFafrw(Double fafrw) {
		this.fafrw = fafrw;
	}

	public Double getPlanindw() {
		return planindw;
	}

	public void setPlanindw(Double planindw) {
		this.planindw = planindw;
	}

	public Double getPlanagrw() {
		return planagrw;
	}

	public void setPlanagrw(Double planagrw) {
		this.planagrw = planagrw;
	}

	public Double getPlanlifw() {
		return planlifw;
	}

	public void setPlanlifw(Double planlifw) {
		this.planlifw = planlifw;
	}

	public Double getPlanfafrw() {
		return planfafrw;
	}

	public void setPlanfafrw(Double planfafrw) {
		this.planfafrw = planfafrw;
	}
	
}
