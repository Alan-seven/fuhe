package com.jsite.szy.dispatch.formal.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;

/**
 * 常规调度调度区域
 * @author seven
 *
 */
public class TSfmmRegionBVO extends PageVO{
	@ApiModelProperty(value = "调度区域代码")
	private String regionCd;
	@ApiModelProperty(value = "调度区域名称")
	private String regionNm;
	@ApiModelProperty(value = "基面代码")
	private String datCd;
	@ApiModelProperty(value = "河流代码")
	private String rvCd;
	@ApiModelProperty(value = "区域描述")
	private String regionDesc;
	@ApiModelProperty(value = "时间戳")
	private Date ts;
	@ApiModelProperty(value = "备注")
	private String nt;
	
	@Length(min=0, max=16, message="调度区域代码标识长度必须介于 0 和 16 之间")
	public String getRegionCd() {
		return regionCd;
	}
	public void setRegionCd(String regionCd) {
		this.regionCd = regionCd;
	}
	@Length(min=0, max=50, message="调度区域名称标识长度必须介于 0 和 50 之间")
	public String getRegionNm() {
		return regionNm;
	}
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	@Length(min=0, max=9, message="基面代码标识长度必须介于 0 和 9 之间")
	public String getDatCd() {
		return datCd;
	}
	public void setDatCd(String datCd) {
		this.datCd = datCd;
	}
	@Length(min=0, max=12, message="河流代码标识长度必须介于 0 和 12 之间")
	public String getRvCd() {
		return rvCd;
	}
	public void setRvCd(String rvCd) {
		this.rvCd = rvCd;
	}
	@Length(min=0, max=256, message="区域描述标识长度必须介于 0 和 256 之间")
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
