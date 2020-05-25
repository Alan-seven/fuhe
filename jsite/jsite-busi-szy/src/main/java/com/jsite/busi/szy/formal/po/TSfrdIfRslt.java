package com.jsite.busi.szy.formal.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

import javax.validation.constraints.NotNull;

/**
 * 来水预报计算结果Entity
 * @author 来水预报计算结果
 * @version 2020-03-17
 */
public class TSfrdIfRslt extends AbstractData<TSfrdIfRslt> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案代码
	private String enCd;		// 实体代码
	private Date stDt;		// 起始日期
	private Date edDt;		// 终止日期
	private Double forW;		// 徑流總量(万m3)
	private Double relW;		// 径流过程(万m3)
	private Double lyW;		// 上一年径流量（同期）(万m3)
	private Double myW;		// 多年平均径流量（同期）(万m3)
	private String stat;		// 状态
	private Date ts;		// 时间戳
	private String nt;		// 备注
	
	public TSfrdIfRslt() {
		super();
	}

	public TSfrdIfRslt(String id){
		super(id);
	}

	@Length(min=1, max=20, message="方案代码长度必须介于 1 和 20 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=9, message="实体代码长度必须介于 1 和 9 之间")
	public String getEnCd() {
		return enCd;
	}

	public void setEnCd(String enCd) {
		this.enCd = enCd;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="起始日期不能为空")
	public Date getStDt() {
		return stDt;
	}

	public void setStDt(Date stDt) {
		this.stDt = stDt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="终止日期不能为空")
	public Date getEdDt() {
		return edDt;
	}

	public void setEdDt(Date edDt) {
		this.edDt = edDt;
	}
	
	@NotNull(message="预测值(万m3)不能为空")
	public Double getForW() {
		return forW;
	}

	public void setForW(Double forW) {
		this.forW = forW;
	}
	
	public Double getRelW() {
		return relW;
	}

	public void setRelW(Double relW) {
		this.relW = relW;
	}
	
	public Double getLyW() {
		return lyW;
	}

	public void setLyW(Double lyW) {
		this.lyW = lyW;
	}
	
	public Double getMyW() {
		return myW;
	}

	public void setMyW(Double myW) {
		this.myW = myW;
	}
	
	@Length(min=1, max=1, message="状态长度必须介于 1 和 1 之间")
	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
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