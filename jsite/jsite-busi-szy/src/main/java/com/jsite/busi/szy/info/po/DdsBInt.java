package com.jsite.busi.szy.info.po;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBInt extends AbstractData<DdsBInt> {
	
	private static final long serialVersionUID = 1L;
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
	
	public DdsBInt() {
		super();
	}

	public DdsBInt(String id){
		super(id);
	}

	@Length(min=1, max=12, message="地表水取水口代码长度必须介于 1 和 12 之间")
	public String getIntCd() {
		return intCd;
	}

	public void setIntCd(String intCd) {
		this.intCd = intCd;
	}
	
	@Length(min=1, max=100, message="地表水取水口名称长度必须介于 1 和 100 之间")
	public String getIntNm() {
		return intNm;
	}

	public void setIntNm(String intNm) {
		this.intNm = intNm;
	}
	
	@Length(min=0, max=1, message="取水方式长度必须介于 0 和 1 之间")
	public String getIntTp() {
		return intTp;
	}

	public void setIntTp(String intTp) {
		this.intTp = intTp;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
	
	@Length(min=0, max=1, message="运行状况长度必须介于 0 和 1 之间")
	public String getRunCond() {
		return runCond;
	}

	public void setRunCond(String runCond) {
		this.runCond = runCond;
	}
	
	@Length(min=1, max=9, message="管理单位代码长度必须介于 1 和 9 之间")
	public String getEngManCd() {
		return engManCd;
	}

	public void setEngManCd(String engManCd) {
		this.engManCd = engManCd;
	}
	
	@Length(min=0, max=256, message="供水范围长度必须介于 0 和 256 之间")
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
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
}