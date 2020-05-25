package com.jsite.busi.szy.info.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

import javax.validation.constraints.NotNull;


/**
 * 河道水情表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsDrRiver extends AbstractData<DdsDrRiver> {
	
	private static final long serialVersionUID = 1L;
	private String stcd;		// 测站编码
	private String stNm;
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
	private Double lgtd;		// 经度
	private Double lttd;		// 纬度
	
	private String startTime;	//查询开始时间
	private String endTime;		//查询结束时间
	private String flag = "1"; //默认只为1 代表实测值  2 代表插值   3--代表不做插值计算
	private String river;
	
	public DdsDrRiver() {
		super();
	}

	public DdsDrRiver(String id){
		super(id);
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

	public Double getLgtd() {
		return lgtd;
	}

	public void setLgtd(Double lgtd) {
		this.lgtd = lgtd;
	}

	public Double getLttd() {
		return lttd;
	}

	public void setLttd(Double lttd) {
		this.lttd = lttd;
	}
	
}