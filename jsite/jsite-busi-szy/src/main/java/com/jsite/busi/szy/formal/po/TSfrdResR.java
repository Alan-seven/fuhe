package com.jsite.busi.szy.formal.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 水库实际调节过程Entity
 * @author seven
 *
 */
public class TSfrdResR  extends AbstractData<TSfrdResR>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String proCd;	//调度区域代码
	private String enCd;		//实体代码
	private Date stDt;			//起始日期
	private Date edDt;			//结束日期
	private Float edZ;			//时段末水位
	private Float edW;			//时段末蓄水量
	private Float inW;			//入库水量
	private Float outW;			//出库水量
	private Float dchgW;		//下泄水量
	private Float ww;			//供水量
	private Date ts;			//时间戳
	private String nt;			//备注
	
	public TSfrdResR(){
		super();
	}
	
	
	@NotNull(message="方案代码不能为空")
	@Length(min=1, max=16, message="方案代码长度必须介于 1 和 16 之间")
	public String getProCd() {
		return proCd;
	}
	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	@NotNull(message="实体代码不能为空")
	@Length(min=1, max=9, message="实体代码长度必须介于 1 和 9 之间")
	public String getEnCd() {
		return enCd;
	}
	public void setEnCd(String enCd) {
		this.enCd = enCd;
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
	public Float getEdZ() {
		return edZ;
	}
	public void setEdZ(Float edZ) {
		this.edZ = edZ;
	}
	public Float getEdW() {
		return edW;
	}
	public void setEdW(Float edW) {
		this.edW = edW;
	}
	public Float getInW() {
		return inW;
	}
	public void setInW(Float inW) {
		this.inW = inW;
	}
	public Float getOutW() {
		return outW;
	}
	public void setOutW(Float outW) {
		this.outW = outW;
	}
	public Float getDchgW() {
		return dchgW;
	}
	public void setDchgW(Float dchgW) {
		this.dchgW = dchgW;
	}
	public Float getWw() {
		return ww;
	}
	public void setWw(Float ww) {
		this.ww = ww;
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
