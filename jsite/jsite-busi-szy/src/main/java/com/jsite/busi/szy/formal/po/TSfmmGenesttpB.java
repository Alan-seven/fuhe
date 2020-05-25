package com.jsite.busi.szy.formal.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 概化测站类型信息表Entity
 * @author seven
 *
 */
public class TSfmmGenesttpB extends AbstractData<TSfmmGenesttpB>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String regionCd;
	private String genesttpCd;
	private String genesttpNm;
	private String dataitemCdLst;
	private Date ts;
	private String nt;
	
	public TSfmmGenesttpB(){
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
	@NotNull(message="概化测站类型代码不能为空")
	@Length(min=1, max=9, message="概化测站类型代码标识长度必须介于 1 和 9 之间")
	public String getGenesttpCd() {
		return genesttpCd;
	}
	public void setGenesttpCd(String genesttpCd) {
		this.genesttpCd = genesttpCd;
	}
	@NotNull(message="概化测站类型名称不能为空")
	@Length(min=1, max=50, message="概化测站类型名称标识长度必须介于 1 和 50 之间")
	public String getGenesttpNm() {
		return genesttpNm;
	}
	public void setGenesttpNm(String genesttpNm) {
		this.genesttpNm = genesttpNm;
	}
	@NotNull(message="类型所含数据项列表标识不能为空")
	@Length(min=1, max=256, message="类型所含数据项列表标识长度必须介于 1和256 之间")
	public String getDataitemCdLst() {
		return dataitemCdLst;
	}
	public void setDataitemCdLst(String dataitemCdLst) {
		this.dataitemCdLst = dataitemCdLst;
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
