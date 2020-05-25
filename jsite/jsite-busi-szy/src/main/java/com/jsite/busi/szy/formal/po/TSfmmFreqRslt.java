package com.jsite.busi.szy.formal.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 水文测站频率来水成果表Entity
 * @author seven
 *
 */
public class TSfmmFreqRslt extends AbstractData<TSfmmFreqRslt>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String stcd;
	private Float ifFreq;
	private String tmVal;
	private Float q;
	private Date ts;
	private String nt;
	
	public TSfmmFreqRslt(){
		super();
	}
	
	@NotNull(message="测站代码不能为空")
	@Length(min=1, max=8, message="测站代码标识长度必须介于 1 和 8 之间")
	public String getStcd() {
		return stcd;
	}
	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	public Float getIfFreq() {
		return ifFreq;
	}
	public void setIfFreq(Float ifFreq) {
		this.ifFreq = ifFreq;
	}
	@NotNull(message="时段值不能为空")
	@Length(min=1, max=2, message="时段值标识长度必须介于 1 和2 之间")
	public String getTmVal() {
		return tmVal;
	}
	public void setTmVal(String tmVal) {
		this.tmVal = tmVal;
	}
	public Float getQ() {
		return q;
	}
	public void setQ(Float q) {
		this.q = q;
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
