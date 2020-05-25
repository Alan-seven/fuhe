package com.jsite.szy.dispatch.info.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

public class DdsDrRsvrVO extends PageVO {

	private String stcd;		// 测站编码
	private String stNm;		//测站名称
	private Date tm;		// 时间
	private Double rz;		// 库上水位
	private Double inq;		// 入库流量
	private Double w;		// 蓄水量
	private Double blrz;		// 库下水位
	private Double otq;		// 出库流量
	private String rwchrcd;		// 库水特征码
	private String rwptn;		// 库水水势
	private Double inqdr;		// 入流时段长
	private String msqmt;		// 测流方法
	
	private String startTm;  	//查询开始时间
	private String endTm;  	//查询结束时间
	private String flag = "1"; //1,2代表作插值计算（ 1 代表实测值  2代表插值 ）
	private String river; //河流标识  后续需要配置到系统管理中 
	
	public DdsDrRsvrVO() {
		super();
	}

	@Length(min=1, max=8, message="测站编码长度必须介于 1 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	public String getStNm() {
		return stNm;
	}

	public void setStNm(String stNm) {
		this.stNm = stNm;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间不能为空")
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}
	
	public Double getRz() {
		return rz;
	}

	public void setRz(Double rz) {
		this.rz = rz;
	}
	
	public Double getInq() {
		return inq;
	}

	public void setInq(Double inq) {
		this.inq = inq;
	}
	
	public Double getW() {
		return w;
	}

	public void setW(Double w) {
		this.w = w;
	}
	
	public Double getBlrz() {
		return blrz;
	}

	public void setBlrz(Double blrz) {
		this.blrz = blrz;
	}
	
	public Double getOtq() {
		return otq;
	}

	public void setOtq(Double otq) {
		this.otq = otq;
	}
	
	@Length(min=0, max=1, message="库水特征码长度必须介于 0 和 1 之间")
	public String getRwchrcd() {
		return rwchrcd;
	}

	public void setRwchrcd(String rwchrcd) {
		this.rwchrcd = rwchrcd;
	}
	
	@Length(min=0, max=1, message="库水水势长度必须介于 0 和 1 之间")
	public String getRwptn() {
		return rwptn;
	}

	public void setRwptn(String rwptn) {
		this.rwptn = rwptn;
	}
	
	public Double getInqdr() {
		return inqdr;
	}

	public void setInqdr(Double inqdr) {
		this.inqdr = inqdr;
	}
	
	@Length(min=0, max=1, message="测流方法长度必须介于 0 和 1 之间")
	public String getMsqmt() {
		return msqmt;
	}

	public void setMsqmt(String msqmt) {
		this.msqmt = msqmt;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public String getStartTm() {
		return startTm;
	}

	public void setStartTm(String startTm) {
		this.startTm = startTm;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public String getEndTm() {
		return endTm;
	}

	public void setEndTm(String endTm) {
		this.endTm = endTm;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
}
