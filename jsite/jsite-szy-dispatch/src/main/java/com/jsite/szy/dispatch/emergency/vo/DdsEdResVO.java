package com.jsite.szy.dispatch.emergency.vo;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import javax.validation.constraints.NotNull;


/**
 * 应急调度方案结果表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsEdResVO extends PageVO {
	
	private String proCd;		// 方案ID
	private String secId;		// 河道断面ID
	private Date tm;		// 时间
	private Double z;		// 水位
	private Double q;		// 流量
	private Double w;		// 水量
	private Double p;		// 总磷
	private Double n;		// 总氮
	private Double nh3n;		// 氨氮
	private Double bod;		// BOD
	private Double cod;		// COD
	private Double boPl;		// 突发污染物
	private String oth;		// 其它
	private String qType;		// 水库下泄类型
	
	private Double inq;		//入库流量
	private Double otq;		//出库流量
	
	public DdsEdResVO() {
		super();
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=8, message="水利要素ID长度必须介于 1 和 8 之间")
	public String getSecId() {
		return secId;
	}

	public void setSecId(String secId) {
		this.secId = secId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间不能为空")
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}
	
	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}
	
	public Double getQ() {
		return q;
	}

	public void setQ(Double q) {
		this.q = q;
	}
	
	public Double getW() {
		return w;
	}

	public void setW(Double w) {
		this.w = w;
	}
	
	public Double getP() {
		return p;
	}

	public void setP(Double p) {
		this.p = p;
	}
	
	public Double getN() {
		return n;
	}

	public void setN(Double n) {
		this.n = n;
	}
	
	public Double getNh3n() {
		return nh3n;
	}

	public void setNh3n(Double nh3n) {
		this.nh3n = nh3n;
	}
	
	public Double getBod() {
		return bod;
	}

	public void setBod(Double bod) {
		this.bod = bod;
	}
	
	public Double getCod() {
		return cod;
	}

	public void setCod(Double cod) {
		this.cod = cod;
	}
	
	public Double getBoPl() {
		return boPl;
	}

	public void setBoPl(Double boPl) {
		this.boPl = boPl;
	}
	
	@Length(min=0, max=512, message="其它长度必须介于 0 和 512 之间")
	public String getOth() {
		return oth;
	}

	public void setOth(String oth) {
		this.oth = oth;
	}
	
	public Double getInq() {
		return inq;
	}

	public String getqType() {
		return qType;
	}

	public void setqType(String qType) {
		this.qType = qType;
	}

	public void setInq(Double inq) {
		this.inq = inq;
	}

	public Double getOtq() {
		return otq;
	}

	public void setOtq(Double otq) {
		this.otq = otq;
	}
	
}