package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

import javax.validation.constraints.NotNull;


/**
 * 应急调度约束条件表Entity
 * @author hjx
 * @version 2017-06-12
 */
public class DdsEdConst extends AbstractData<DdsEdConst> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String secid;		// 河道断面ID
	private Date tm;		// 时间
	private Double maxZ;		// 最高水位
	private Double minZ;		// 最低水位
	private Double maxN;		// 最大出力
	private Double minN;		// 最小出力
	private Double maxQ;		// 最大流量
	private Double minQ;		// 最小流量
	private Double bod;		// BOD
	private Double cod;		// COD
	private Double boPl;		// 突发污染物
	private String oth;		// 其它
	
	public DdsEdConst() {
		super();
	}

	public DdsEdConst(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=8, message="河道断面ID长度必须介于 1 和 8 之间")
	public String getSecid() {
		return secid;
	}

	public void setSecid(String secid) {
		this.secid = secid;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间不能为空")
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}
	
	public Double getMaxZ() {
		return maxZ;
	}

	public void setMaxZ(Double maxZ) {
		this.maxZ = maxZ;
	}
	
	public Double getMinZ() {
		return minZ;
	}

	public void setMinZ(Double minZ) {
		this.minZ = minZ;
	}
	
	public Double getMaxN() {
		return maxN;
	}

	public void setMaxN(Double maxN) {
		this.maxN = maxN;
	}
	
	public Double getMinN() {
		return minN;
	}

	public void setMinN(Double minN) {
		this.minN = minN;
	}
	
	public Double getMaxQ() {
		return maxQ;
	}

	public void setMaxQ(Double maxQ) {
		this.maxQ = maxQ;
	}
	
	public Double getMinQ() {
		return minQ;
	}

	public void setMinQ(Double minQ) {
		this.minQ = minQ;
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
	
}