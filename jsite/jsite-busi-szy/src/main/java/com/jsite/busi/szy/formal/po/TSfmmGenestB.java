package com.jsite.busi.szy.formal.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 概化测站基本信息Entity
 * @author seven
 *
 */
public class TSfmmGenestB extends AbstractData<TSfmmGenestB>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String regionCd;
	private String genestCd;
	private String genestNm;
	private String datCd;
	private String stcd;
	private String genesttpCd;
	private Date ts;
	private String nt;
	
	public TSfmmGenestB(){
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
	@NotNull(message="概化测站代码不能为空")
	@Length(min=1, max=9, message="概化测站代码标识长度必须介于 1 和 9 之间")
	public String getGenestCd() {
		return genestCd;
	}
	public void setGenestCd(String genestCd) {
		this.genestCd = genestCd;
	}
	@NotNull(message="概化测站名称不能为空")
	@Length(min=1, max=50, message="概化测站名称标识长度必须介于 1 和 50 之间")
	public String getGenestNm() {
		return genestNm;
	}
	public void setGenestNm(String genestNm) {
		this.genestNm = genestNm;
	}
	@Length(min=0, max=9, message="基面代码长度必须介于 0 和 9 之间")
	public String getDatCd() {
		return datCd;
	}
	public void setDatCd(String datCd) {
		this.datCd = datCd;
	}
	@Length(min=0, max=8, message="测站代码长度必须介于 0 和 8 之间")
	public String getStcd() {
		return stcd;
	}
	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	@Length(min=0, max=8, message="概化测站类型标识长度必须介于 0 和 9 之间")
	public String getGenesttpCd() {
		return genesttpCd;
	}
	public void setGenesttpCd(String genesttpCd) {
		this.genesttpCd = genesttpCd;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
