package com.jsite.busi.szy.info.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBWrz extends AbstractData<DdsBWrz> {
	
	private static final long serialVersionUID = 1L;
	private String wrzCd;		// 水资源分区代码
	private String wrzNm;		// 水资源分区名称
	private String wrzA;		// 水资源分区面积km^2
	private String hillZoneA;		// 山丘区面积km^2
	private String plaiA;		// 平原区面积km^2
	private String avgP;		// 多年平均降水量(10^6)m^3
	private String avgWat;		// 多年平均水资源问题(10^6)m^3
	private String avgSurfWat;		// 多年平均地表水资源量(10^6)m^3
	private String avgGwWat;		// 多年平均地下水资源量(10^6)m^3
	private String avgSgWat;		// 多年平均地表水和地下水资源重复计算量(10^6)m^3
	private Date ts;		// 时间戳
	private String nt;		// 备注
	
	public DdsBWrz() {
		super();
	}

	public DdsBWrz(String id){
		super(id);
	}

	@Length(min=1, max=7, message="水资源分区代码长度必须介于 1 和 7 之间")
	public String getWrzCd() {
		return wrzCd;
	}

	public void setWrzCd(String wrzCd) {
		this.wrzCd = wrzCd;
	}
	
	@Length(min=1, max=100, message="水资源分区名称长度必须介于 1 和 100 之间")
	public String getWrzNm() {
		return wrzNm;
	}

	public void setWrzNm(String wrzNm) {
		this.wrzNm = wrzNm;
	}
	
	public String getWrzA() {
		return wrzA;
	}

	public void setWrzA(String wrzA) {
		this.wrzA = wrzA;
	}
	
	public String getHillZoneA() {
		return hillZoneA;
	}

	public void setHillZoneA(String hillZoneA) {
		this.hillZoneA = hillZoneA;
	}
	
	public String getPlaiA() {
		return plaiA;
	}

	public void setPlaiA(String plaiA) {
		this.plaiA = plaiA;
	}
	
	public String getAvgP() {
		return avgP;
	}

	public void setAvgP(String avgP) {
		this.avgP = avgP;
	}
	
	public String getAvgWat() {
		return avgWat;
	}

	public void setAvgWat(String avgWat) {
		this.avgWat = avgWat;
	}
	
	public String getAvgSurfWat() {
		return avgSurfWat;
	}

	public void setAvgSurfWat(String avgSurfWat) {
		this.avgSurfWat = avgSurfWat;
	}
	
	public String getAvgGwWat() {
		return avgGwWat;
	}

	public void setAvgGwWat(String avgGwWat) {
		this.avgGwWat = avgGwWat;
	}
	
	public String getAvgSgWat() {
		return avgSgWat;
	}

	public void setAvgSgWat(String avgSgWat) {
		this.avgSgWat = avgSgWat;
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