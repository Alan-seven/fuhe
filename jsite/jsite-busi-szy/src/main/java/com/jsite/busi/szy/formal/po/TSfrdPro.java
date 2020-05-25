package com.jsite.busi.szy.formal.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 常规调度方案信息Entity
 * @author seven
 *
 */
public class TSfrdPro extends AbstractData<TSfrdPro>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String proCd;		//方案代码
	private String regionCd;	//调度区域代码
	private String sbjCd;		//专题代码
	private String reqCd;		//请求代码
	private String proTp;		//方案类型  Y--年  M--月  T--旬
	private String proNm;		//方案名称
	private String year;		//基准年
	private String ifFreq;		//
	private String parProCd;	//父方案代码
	private String refProCd;	//参考方案代码
	private Date bgDt;			//起始时间
	private Date edDt;			//终止日期
	private String dpCyc;		//计算步长	M--月  T--旬  D--日
	private String proSta;		//方案级别  PER---草稿   CMP---比选 DEC---发布
	private String schStat;		//进度状态  0---->4
	private String usrCd;		//制作人
	private String usrNm;		//制作人名称
	private Date pubTm;			//发布时间
	private String proDesc;		//方案描述
	private Date ts;
	private String nt;
	
	public TSfrdPro(){
		super();
	}
	
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
	//@NotNull(message="来水频率不能为空")
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
