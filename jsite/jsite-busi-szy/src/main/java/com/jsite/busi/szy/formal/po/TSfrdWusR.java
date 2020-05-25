package com.jsite.busi.szy.formal.po;
import org.hibernate.validator.constraints.Length;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 调度区域实际用水结果Entity
 * @author 调度区域实际用水结果
 * @version 2020-03-17
 */
public class TSfrdWusR extends AbstractData<TSfrdWusR> {
	
	private static final long serialVersionUID = 1L;
	private String regionCd;		// 调度区域
	private String enCd;		// 实体代码
	private Date stDt;		// 起始时间
	private Date edDt;		// 终止时间
	private Double lifWw;		// 生活用水量
	private Double agrWw;		// 农业用水量
	private Double indWw;		// 工业用水量
	private Double ecoWw;		// 生态用水量
	private Date ts;		// 时间戳
	private String nt;		// 备注
	
	@NotNull(message="调度区域代码不能为空")
	@Length(min=1, max=16, message="调度区域代码长度必须介于 1 和 16 之间")
	public String getRegionCd() {
		return regionCd;
	}

	public void setRegionCd(String regionCd) {
		this.regionCd = regionCd;
	}
	@NotNull(message="实体代码不能为空")
	@Length(min=1, max=9, message="实体代码长度必须介于 1 和 9 之间")
	public String getEnCd() {
		return enCd;
	}

	public void setEnCd(String enCd) {
		this.enCd = enCd;
	}
	
	public TSfrdWusR() {
		super();
	}

	public TSfrdWusR(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStDt() {
		return stDt;
	}

	public void setStDt(Date stDt) {
		this.stDt = stDt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEdDt() {
		return edDt;
	}

	public void setEdDt(Date edDt) {
		this.edDt = edDt;
	}
	
	public Double getLifWw() {
		return lifWw;
	}

	public void setLifWw(Double lifWw) {
		this.lifWw = lifWw;
	}
	
	public Double getAgrWw() {
		return agrWw;
	}

	public void setAgrWw(Double agrWw) {
		this.agrWw = agrWw;
	}
	
	public Double getIndWw() {
		return indWw;
	}

	public void setIndWw(Double indWw) {
		this.indWw = indWw;
	}
	
	public Double getEcoWw() {
		return ecoWw;
	}

	public void setEcoWw(Double ecoWw) {
		this.ecoWw = ecoWw;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}
	
	@Length(min=0, max=255, message="nt长度必须介于 0 和 255 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}