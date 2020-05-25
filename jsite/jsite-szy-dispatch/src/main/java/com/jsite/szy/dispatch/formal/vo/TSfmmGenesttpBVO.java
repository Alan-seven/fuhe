package com.jsite.szy.dispatch.formal.vo;

import java.util.Date;

import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;

/**
 * 概化测站类型信息
 * @author seven
 *
 */
public class TSfmmGenesttpBVO extends PageVO{
	@ApiModelProperty(value = "调度区域代码")
	private String regionCd;
	@ApiModelProperty(value = "调度区域代码")
	private String genesttpCd;
	@ApiModelProperty(value = "调度区域代码")
	private String genesttpNm;
	@ApiModelProperty(value = "调度区域代码")
	private String dataitemCdLst;
	@ApiModelProperty(value = "时间戳")
	private Date ts;
	@ApiModelProperty(value = "备注")
	private String nt;
	public String getRegionCd() {
		return regionCd;
	}
	public void setRegionCd(String regionCd) {
		this.regionCd = regionCd;
	}
	public String getGenesttpCd() {
		return genesttpCd;
	}
	public void setGenesttpCd(String genesttpCd) {
		this.genesttpCd = genesttpCd;
	}
	public String getGenesttpNm() {
		return genesttpNm;
	}
	public void setGenesttpNm(String genesttpNm) {
		this.genesttpNm = genesttpNm;
	}
	public String getDataitemCdLst() {
		return dataitemCdLst;
	}
	public void setDataitemCdLst(String dataitemCdLst) {
		this.dataitemCdLst = dataitemCdLst;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	public String getNt() {
		return nt;
	}
	public void setNt(String nt) {
		this.nt = nt;
	}
	
}
