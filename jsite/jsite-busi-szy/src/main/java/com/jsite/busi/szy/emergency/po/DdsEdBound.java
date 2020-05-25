package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;


/**
 * 应急调度边界条件Entity
 * @author hjx
 * @version 2017-06-12
 */
public class DdsEdBound extends AbstractData<DdsEdBound> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String stcd;		// 测站编码
	private Integer qtype;		// 入流设置方式
	private Date tm;		// 时间
	private Double q;		// 流量
	private Double inq;		//入库流量
	private Double z;		// 水位
	private String vcheck;		// 数据完整性
	
	private String startTime;	//查询开始时间
	private String endTime;		//查询结束时间
	
	public DdsEdBound() {
		super();
	}

	public DdsEdBound(String id){
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
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@NotNull(message="入流设置方式不能为空")
	public Integer getQtype() {
		return qtype;
	}

	public void setQtype(Integer qtype) {
		this.qtype = qtype;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间不能为空")
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}
	
	public Double getQ() {
		return q;
	}

	public void setQ(Double q) {
		this.q = q;
	}

	public Double getInq() {
		return inq;
	}

	public void setInq(Double inq) {
		this.inq = inq;
	}

	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}
	
	@Length(min=0, max=1, message="数据完整性长度必须介于 0 和 1 之间")
	public String getVcheck() {
		return vcheck;
	}

	public void setVcheck(String vcheck) {
		this.vcheck = vcheck;
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
	
}