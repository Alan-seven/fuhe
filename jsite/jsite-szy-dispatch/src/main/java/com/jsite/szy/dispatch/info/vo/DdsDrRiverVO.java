package com.jsite.szy.dispatch.info.vo;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import javax.validation.constraints.NotNull;


/**
 * 河道水情表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsDrRiverVO extends PageVO {
	
	private String stcd;		// 测站编码
	private Date tm;		// 时间
	private Double z;		// 水位
	private Double q;		// 流量
	private Double xsa;		// 断面过水面积
	private Double xsavv;		// 断面平均流速
	private Double xsmxv;		// 断面最大流速
	private String flwchrcd;		// 河水特征码
	private String wptn;		// 水势
	private String msqmt;		// 测流方法
	private String msamt;		// 测积方法
	private String msvmt;		// 测速方法
	
	private String startTime;	//查询开始时间
	private String endTime;		//查询结束时间
	private String flag = "1"; //1,2 代表作插值计算（ 1 代表实测值  2代表插值 ） 3--代表不做插值计算
	private String stNm;
	private String river;
	
	public DdsDrRiverVO() {
		super();
	}

	@Length(min=1, max=8, message="测站编码长度必须介于 1 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间不能为空")
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}
	
	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}
	
	public Double getQ() {
		return q;
	}

	public void setQ(Double q) {
		this.q = q;
	}
	
	public Double getXsa() {
		return xsa;
	}

	public void setXsa(Double xsa) {
		this.xsa = xsa;
	}
	
	public Double getXsavv() {
		return xsavv;
	}

	public void setXsavv(Double xsavv) {
		this.xsavv = xsavv;
	}
	
	public Double getXsmxv() {
		return xsmxv;
	}

	public void setXsmxv(Double xsmxv) {
		this.xsmxv = xsmxv;
	}
	
	@Length(min=0, max=1, message="河水特征码长度必须介于 0 和 1 之间")
	public String getFlwchrcd() {
		return flwchrcd;
	}

	public void setFlwchrcd(String flwchrcd) {
		this.flwchrcd = flwchrcd;
	}
	
	@Length(min=0, max=1, message="水势长度必须介于 0 和 1 之间")
	public String getWptn() {
		return wptn;
	}

	public void setWptn(String wptn) {
		this.wptn = wptn;
	}
	
	@Length(min=0, max=1, message="测流方法长度必须介于 0 和 1 之间")
	public String getMsqmt() {
		return msqmt;
	}

	public void setMsqmt(String msqmt) {
		this.msqmt = msqmt;
	}
	
	@Length(min=0, max=1, message="测积方法长度必须介于 0 和 1 之间")
	public String getMsamt() {
		return msamt;
	}

	public void setMsamt(String msamt) {
		this.msamt = msamt;
	}
	
	@Length(min=0, max=1, message="测速方法长度必须介于 0 和 1 之间")
	public String getMsvmt() {
		return msvmt;
	}

	public void setMsvmt(String msvmt) {
		this.msvmt = msvmt;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getStNm() {
		return stNm;
	}

	public void setStNm(String stNm) {
		this.stNm = stNm;
	}

	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
}