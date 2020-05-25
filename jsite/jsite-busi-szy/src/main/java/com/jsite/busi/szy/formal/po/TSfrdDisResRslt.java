package com.jsite.busi.szy.formal.po;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

import javax.validation.constraints.NotNull;

/**
 * 水量调节计算水库结果Entity
 * @author 水量调节计算水库结果
 * @version 2020-03-17
 */
public class TSfrdDisResRslt extends AbstractData<TSfrdDisResRslt> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案代码
	private String enCd;		// 实体代码
	private String rsltTp;		// 结果类型
	private Date stDt;		// 起始日期
	private Date edDt;		// 终止日期
	private Double stZ;		// 时段初水位(m)
	private Double edZ;		// 时段末水位(m)
	private Double stW;		// 时段初蓄水量(万m3)
	private Double edW;		// 时段末蓄水量(万m3)
	private Double inq;		// 入库流量(m3/s)
	private Double outq;		// 下泄流量(m3/s)
	private Double egq;		// 发电引用流量(m3/s)
	private Double dq;		// 弃水流量(m3/s)
	private Long eg;		// 发电量(kWh)
	private Double wcr;		// 耗水率
	private Double n;		// 出力(MW)
	private Double gh;		// 毛水头(m)
	private Double nh;		// 净水头(m)
	private Double lh;		// 水头损失(m)
	private Date ts;		// 时间戳
	private String nt;		// 备注
	
	public TSfrdDisResRslt() {
		super();
	}

	public TSfrdDisResRslt(String id){
		super(id);
	}
	@NotNull(message="方案代码不能为空")
	@Length(min=1, max=20, message="方案代码长度必须介于 1 和 20 之间")
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
	
	public Double getStZ() {
		return stZ;
	}

	public void setStZ(Double stZ) {
		this.stZ = stZ;
	}
	
	public Double getEdZ() {
		return edZ;
	}

	public void setEdZ(Double edZ) {
		this.edZ = edZ;
	}
	
	public Double getStW() {
		return stW;
	}

	public void setStW(Double stW) {
		this.stW = stW;
	}
	
	public Double getEdW() {
		return edW;
	}

	public void setEdW(Double edW) {
		this.edW = edW;
	}
	
	public Double getInq() {
		return inq;
	}

	public void setInq(Double inq) {
		this.inq = inq;
	}
	
	public Double getOutq() {
		return outq;
	}

	public void setOutq(Double outq) {
		this.outq = outq;
	}
	
	public Double getEgq() {
		return egq;
	}

	public void setEgq(Double egq) {
		this.egq = egq;
	}
	
	public Double getDq() {
		return dq;
	}

	public void setDq(Double dq) {
		this.dq = dq;
	}
	
	public Long getEg() {
		return eg;
	}

	public void setEg(Long eg) {
		this.eg = eg;
	}
	
	public Double getWcr() {
		return wcr;
	}

	public void setWcr(Double wcr) {
		this.wcr = wcr;
	}
	
	public Double getN() {
		return n;
	}

	public void setN(Double n) {
		this.n = n;
	}
	
	public Double getGh() {
		return gh;
	}

	public void setGh(Double gh) {
		this.gh = gh;
	}
	
	public Double getNh() {
		return nh;
	}

	public void setNh(Double nh) {
		this.nh = nh;
	}
	
	public Double getLh() {
		return lh;
	}

	public void setLh(Double lh) {
		this.lh = lh;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间戳不能为空")
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