package com.jsite.szy.dispatch.info.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBIntVO extends PageVO {
	
	private String intCd;		// 地表水取水口代码
	private String intNm;		// 地表水取水口名称
	private String intTp;		// 取水方式
	private Date fromIntDt;		// 开始取水日期
	private Float maxPermQ;		// 许可最大流量m^3/s
	private Float desQ;		// 设计流量m^3/s
	private Float permWw;		// 许可总取水量m^4
	private String runCond;		// 运行状况
	private String engManCd;		// 管理单位代码
	private String wsReg;		// 供水范围
	private String ts;		// 时间戳
	private String nt;		// 备注
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
	public DdsBIntVO() {
		super();
	}

	public String getIntCd() {
		return intCd;
	}

	public void setIntCd(String intCd) {
		this.intCd = intCd;
	}
	
	public String getIntNm() {
		return intNm;
	}

	public void setIntNm(String intNm) {
		this.intNm = intNm;
	}
	
	public String getIntTp() {
		return intTp;
	}

	public void setIntTp(String intTp) {
		this.intTp = intTp;
	}
	
	public Date getFromIntDt() {
		return fromIntDt;
	}

	public void setFromIntDt(Date fromIntDt) {
		this.fromIntDt = fromIntDt;
	}
	
	public Float getMaxPermQ() {
		return maxPermQ;
	}

	public void setMaxPermQ(Float maxPermQ) {
		this.maxPermQ = maxPermQ;
	}
	
	public Float getDesQ() {
		return desQ;
	}

	public void setDesQ(Float desQ) {
		this.desQ = desQ;
	}
	
	public Float getPermWw() {
		return permWw;
	}

	public void setPermWw(Float permWw) {
		this.permWw = permWw;
	}
	
	public String getRunCond() {
		return runCond;
	}

	public void setRunCond(String runCond) {
		this.runCond = runCond;
	}
	
	public String getEngManCd() {
		return engManCd;
	}

	public void setEngManCd(String engManCd) {
		this.engManCd = engManCd;
	}
	
	public String getWsReg() {
		return wsReg;
	}

	public void setWsReg(String wsReg) {
		this.wsReg = wsReg;
	}
	
	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}
	
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	 
}