package com.jsite.szy.dispatch.emergency.vo;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 应急调度边界条件Entity
 * @author hjx
 * @version 2017-06-12
 */
public class DdsEdBoundVO extends PageVO {
	
	private String proCd;		// 方案ID
	private String stcd;		// 河道断面ID
	private Integer qtype;		// 入流设置方式  1、历史；2、预报；3、人工导入 
	private Date tm;		// 时间
	private Double q;		// 流量
	private Double z;		// 水位
	private Double inq;		//入库流量
	private String vcheck = "1";		// 数据完整性
	
	public DdsEdBoundVO() {
		super();
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
	
}