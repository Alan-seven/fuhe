package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.jsite.dao.AbstractData;

import javax.validation.constraints.NotNull;


/**
 * 应急调度方案结果表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsEdRes extends AbstractData<DdsEdRes> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String secId;		// 水利要素ID
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
	
	private String secnm;
	private String stype;
	private Integer rcd;
	
	private String startTime;	//查询开始时间
	private String endTime;		//查询结束时间
	
	private List<EDResData> list =  Lists.newArrayList();//封装断面结果集数据到集合
	
	public DdsEdRes() {
		super();
	}

	public DdsEdRes(String id){
		super(id);
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

	public void setInq(Double inq) {
		this.inq = inq;
	}

	public Double getOtq() {
		return otq;
	}

	public void setOtq(Double otq) {
		this.otq = otq;
	}

	public String getSecnm() {
		return secnm;
	}

	public void setSecnm(String secnm) {
		this.secnm = secnm;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public Integer getRcd() {
		return rcd;
	}

	public void setRcd(Integer rcd) {
		this.rcd = rcd;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getqType() {
		return qType;
	}

	public void setqType(String qType) {
		this.qType = qType;
	}

	public List<EDResData> getList() {
		return list;
	}

	public void setList(List<EDResData> list) {
		this.list = list;
	}

	
}