package com.jsite.busi.szy.formal.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

import javax.validation.constraints.NotNull;

/**
 * 水量调节计算河道断面结果Entity
 * @author 水量调节计算河道断面结果
 * @version 2020-03-17
 */
public class TSfrdDisSectRslt extends AbstractData<TSfrdDisSectRslt> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案代码
	private String enCd;		// 实体代码
	private String sectCd;		// 断面编号
	private String rsltTp;		// 结果类型
	private Date stDt;		// 起始日期
	private Date edDt;		// 终止日期
	private Double avgZ;		// 平均水位(m)
	private Double avgQ;		// 平均流量(m3/s)
	private Double sectW;		// 过流水量(万m3)
	private Date ts;		// 时间戳
	private String nt;		// 备注
	
	public TSfrdDisSectRslt() {
		super();
	}

	public TSfrdDisSectRslt(String id){
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
	
	@Length(min=1, max=4, message="断面编号长度必须介于 1 和 4 之间")
	public String getSectCd() {
		return sectCd;
	}

	public void setSectCd(String sectCd) {
		this.sectCd = sectCd;
	}
	
	@Length(min=1, max=1, message="结果类型长度必须介于 1 和 1 之间")
	public String getRsltTp() {
		return rsltTp;
	}

	public void setRsltTp(String rsltTp) {
		this.rsltTp = rsltTp;
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
	
	public Double getAvgZ() {
		return avgZ;
	}

	public void setAvgZ(Double avgZ) {
		this.avgZ = avgZ;
	}
	
	public Double getAvgQ() {
		return avgQ;
	}

	public void setAvgQ(Double avgQ) {
		this.avgQ = avgQ;
	}
	
	public Double getSectW() {
		return sectW;
	}

	public void setSectW(Double sectW) {
		this.sectW = sectW;
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