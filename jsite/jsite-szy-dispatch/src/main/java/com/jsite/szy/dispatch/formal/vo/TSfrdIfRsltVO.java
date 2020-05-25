package com.jsite.szy.dispatch.formal.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;

/**
 * 来水预报计算结果Entity
 * @author 来水预报计算结果
 * @version 2020-03-17
 */
public class TSfrdIfRsltVO extends PageVO{

	@ApiModelProperty(value = "方案代码")
	private String proCd;		// 方案代码
	@ApiModelProperty(value = "实体代码")
	private String enCd;		// 实体代码
	@ApiModelProperty(value = "起始日期")
	private Date stDt;		// 起始日期
	@ApiModelProperty(value = "终止日期")
	private Date edDt;		// 终止日期
	@ApiModelProperty(value = "径流总量")
	private Double forW;		// 预测值(万m3)
	@ApiModelProperty(value = "径流过程")
	private Double relW;		// 观测值(万m3)
	@ApiModelProperty(value = "上一年径流量（同期）(万m3)")
	private Double lyW;		// 上一年径流量（同期）(万m3)
	@ApiModelProperty(value = "多年平均径流量（同期）(万m3")
	private Double myW;		// 多年平均径流量（同期）(万m3)
	@ApiModelProperty(value = "状态")
	private String stat;		// 状态
	@ApiModelProperty(value = "时间戳")
	private Date ts;		// 时间戳
	@ApiModelProperty(value = "备注")
	private String nt;		// 备注
	
	@Length(min=1, max=20, message="方案代码长度必须介于 1 和 20 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=9, message="实体代码长度必须介于 1 和 9 之间")
	public String getEnCd() {
		return enCd;
	}

	public void setEnCd(String enCd) {
		this.enCd = enCd;
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
	
	@NotNull(message="预测值(万m3)不能为空")
	public Double getForW() {
		return forW;
	}

	public void setForW(Double forW) {
		this.forW = forW;
	}
	
	public Double getRelW() {
		return relW;
	}

	public void setRelW(Double relW) {
		this.relW = relW;
	}
	
	public Double getLyW() {
		return lyW;
	}

	public void setLyW(Double lyW) {
		this.lyW = lyW;
	}
	
	public Double getMyW() {
		return myW;
	}

	public void setMyW(Double myW) {
		this.myW = myW;
	}
	
	@Length(min=1, max=1, message="状态长度必须介于 1 和 1 之间")
	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间戳不能为空")
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
