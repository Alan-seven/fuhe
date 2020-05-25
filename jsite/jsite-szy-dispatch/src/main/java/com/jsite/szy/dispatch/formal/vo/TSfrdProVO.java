package com.jsite.szy.dispatch.formal.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;

/**
 * 常规方案VO
 * @author seven
 *
 */
public class TSfrdProVO extends PageVO{

	@ApiModelProperty(value = "方案代码")
	private String proCd;
	@ApiModelProperty(value = "调度区域代码")
	private String regionCd;
	@ApiModelProperty(value = "专题代码")
	private String sbjCd;
	@ApiModelProperty(value = "请求代码")
	private String reqCd;
	@ApiModelProperty(value = "方案类型")
	private String proTp;
	@ApiModelProperty(value = "方案名称")
	private String proNm;
	@ApiModelProperty(value = "水平年")
	private String year;
	@ApiModelProperty(value = "来水频率")
	private String ifFreq;
	@ApiModelProperty(value = "父方案代码")
	private String parProCd;
	@ApiModelProperty(value = "参考方案代码")
	private String refProCd;
	@ApiModelProperty(value = "起始日期")
	private Date bgDt;
	@ApiModelProperty(value = "结束日期")
	private Date edDt;
	@ApiModelProperty(value = "计算步长")
	private String dpCyc;
	@ApiModelProperty(value = "方案状态")
	private String proSta;
	@ApiModelProperty(value = "进度状态")
	private String schStat;
	@ApiModelProperty(value = "制作人")
	private String usrCd;
	@ApiModelProperty(value = "制作人名称")
	private String usrNm;
	@ApiModelProperty(value = "发布时间")
	private Date pubTm;
	@ApiModelProperty(value = "方案描述")
	private String proDesc;
	@ApiModelProperty(value = "时间戳")
	private Date ts;
	@ApiModelProperty(value = "备注")
	private String nt;
	
	@NotNull(message="方案代码不能为空")
	@Length(min=1, max=20, message="方案代码标识长度必须介于 1 和 20 之间")
	public String getProCd() {
		return proCd;
	}
	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	@NotNull(message="调度区域代码不能为空")
	@Length(min=1, max=16, message="调度区域代码标识长度必须介于 1 和 16 之间")
	public String getRegionCd() {
		return regionCd;
	}
	public void setRegionCd(String regionCd) {
		this.regionCd = regionCd;
	}
	@NotNull(message="专题代码不能为空")
	@Length(min=1, max=9, message="专题代码标识长度必须介于 1 和 9 之间")
	public String getSbjCd() {
		return sbjCd;
	}
	public void setSbjCd(String sbjCd) {
		this.sbjCd = sbjCd;
	}
	@NotNull(message="请求代码不能为空")
	@Length(min=1, max=64, message="请求代码标识长度必须介于 1 和 64 之间")
	public String getReqCd() {
		return reqCd;
	}
	public void setReqCd(String reqCd) {
		this.reqCd = reqCd;
	}
	@NotNull(message="方案类型不能为空")
	@Length(min=1, max=1, message="方案类型标识长度必须介于 1 和 1 之间")
	public String getProTp() {
		return proTp;
	}
	public void setProTp(String proTp) {
		this.proTp = proTp;
	}
	@NotNull(message="方案名称不能为空")
	@Length(min=1, max=256, message="方案名称标识长度必须介于 1 和 256 之间")
	public String getProNm() {
		return proNm;
	}
	public void setProNm(String proNm) {
		this.proNm = proNm;
	}
	@NotNull(message="水平年不能为空")
	@Length(min=1, max=4, message="水平年标识长度必须介于 1 和 4 之间")
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@NotNull(message="来水频率不能为空")
	@Length(min=1, max=4, message="来水频率标识长度必须介于 1 和 4 之间")
	public String getIfFreq() {
		return ifFreq;
	}
	public void setIfFreq(String ifFreq) {
		this.ifFreq = ifFreq;
	}
	@Length(min=1, max=20, message="父方案代码标识长度必须介于 1 和 20 之间")
	public String getParProCd() {
		return parProCd;
	}
	public void setParProCd(String parProCd) {
		this.parProCd = parProCd;
	}
	@Length(min=1, max=20, message="参考方案代码标识长度必须介于 1 和 20 之间")
	public String getRefProCd() {
		return refProCd;
	}
	public void setRefProCd(String refProCd) {
		this.refProCd = refProCd;
	}
	@NotNull(message="起始日期不能为空")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBgDt() {
		return bgDt;
	}
	public void setBgDt(Date bgDt) {
		this.bgDt = bgDt;
	}
	@NotNull(message="终止日期不能为空")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEdDt() {
		return edDt;
	}
	public void setEdDt(Date edDt) {
		this.edDt = edDt;
	}
	@NotNull(message="计算步长不能为空")
	@Length(min=1, max=1, message="计算步长标识长度必须介于 1 和 1 之间")
	public String getDpCyc() {
		return dpCyc;
	}
	public void setDpCyc(String dpCyc) {
		this.dpCyc = dpCyc;
	}
	@NotNull(message="方案级别不能为空")
	@Length(min=1, max=3, message="方案级别标识长度必须介于 1 和3 之间")
	public String getProSta() {
		return proSta;
	}
	public void setProSta(String proSta) {
		this.proSta = proSta;
	}
	@NotNull(message="进度状态不能为空")
	@Length(min=1, max=1, message="进度状态标识长度必须介于 1 和1 之间")
	public String getSchStat() {
		return schStat;
	}
	public void setSchStat(String schStat) {
		this.schStat = schStat;
	}
	@NotNull(message="制作人不能为空")
	@Length(min=1, max=64, message="制作人标识长度必须介于 1 和64 之间")
	public String getUsrCd() {
		return usrCd;
	}
	public void setUsrCd(String usrCd) {
		this.usrCd = usrCd;
	}
	@NotNull(message="制作人名称不能为空")
	@Length(min=1, max=50, message="制作人名称标识长度必须介于 1 和50 之间")
	public String getUsrNm() {
		return usrNm;
	}
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPubTm() {
		return pubTm;
	}
	public void setPubTm(Date pubTm) {
		this.pubTm = pubTm;
	}
	@NotNull(message="方案描述不能为空")
	@Length(min=1, max=512, message="方案描述标识长度必须介于 1 和512 之间")
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
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
