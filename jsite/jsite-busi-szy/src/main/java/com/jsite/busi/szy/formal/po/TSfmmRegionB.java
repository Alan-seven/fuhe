package com.jsite.busi.szy.formal.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;


/**
 * 常规调度调度区域Entity
 * @author seven
 *
 */
public class TSfmmRegionB extends AbstractData<TSfmmRegionB> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String regionCd;
	private String regionNm;
	private String datCd;
	private String rvCd;
	private String regionDesc;
	private Date ts;
	private String nt;
	 
	public TSfmmRegionB(){
		super();
	}
	@NotNull(message="调度区域代码不能为空")
	@Length(min=1, max=16, message="调度区域代码标识长度必须介于 1 和 16 之间")
	public String getRegionCd() {
		return regionCd;
	}
	public void setRegionCd(String regionCd) {
		this.regionCd = regionCd;
	}
	@NotNull(message="调度区域名称不能为空")
	@Length(min=1, max=50, message="调度区域名称标识长度必须介于 1 和 50 之间")
	public String getRegionNm() {
		return regionNm;
	}
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	@NotNull(message="基面代码不能为空")
	@Length(min=1, max=9, message="基面代码标识长度必须介于 1和 9 之间")
	public String getDatCd() {
		return datCd;
	}
	public void setDatCd(String datCd) {
		this.datCd = datCd;
	}
	
	@Length(min=0, max=12, message="河流代码标识长度必须介于 0和 12 之间")
	public String getRvCd() {
		return rvCd;
	}
	public void setRvCd(String rvCd) {
		this.rvCd = rvCd;
	}
	@NotNull(message="区域描述不能为空")
	@Length(min=1, max=256, message="区域描述标识长度必须介于 0 和 256 之间")
	public String getRegionDesc() {
		return regionDesc;
	}
	public void setRegionDesc(String regionDesc) {
		this.regionDesc = regionDesc;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	@Length(min=0, max=256, message="备注标识长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}
	public void setNt(String nt) {
		this.nt = nt;
	}
	
}
