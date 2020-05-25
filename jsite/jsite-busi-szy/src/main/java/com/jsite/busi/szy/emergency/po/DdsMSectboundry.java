package com.jsite.busi.szy.emergency.po;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;


/**
 * 河段模型断面表Entity
 * @author hjx
 * @version 2017-06-12
 */
public class DdsMSectboundry extends AbstractData<DdsMSectboundry> {
	
	private static final long serialVersionUID = 1L;
	private Integer rcd;		// 污染发生河段代码
	private String secid;		// 河道断面ID
	private String sectype;		// 断面类型
	private String secnm;		// 数值类型
	private Integer fid;		// 断面对应的地理要素ID
	private Double lendelta;		// 距离上一个断面的距离
	private Double lenup;		// 距离上边界的里程km
	
	public DdsMSectboundry() {
		super();
	}

	public DdsMSectboundry(String id){
		super(id);
	}

	@NotNull(message="污染发生河段代码不能为空")
	public Integer getRcd() {
		return rcd;
	}

	public void setRcd(Integer rcd) {
		this.rcd = rcd;
	}
	
	@Length(min=0, max=8, message="河道断面ID长度必须介于 0 和 8 之间")
	public String getSecid() {
		return secid;
	}

	public void setSecid(String secid) {
		this.secid = secid;
	}
	
	@Length(min=1, max=100, message="断面类型长度必须介于 1 和 100 之间")
	public String getSectype() {
		return sectype;
	}

	public void setSectype(String sectype) {
		this.sectype = sectype;
	}
	
	@Length(min=0, max=100, message="数值类型长度必须介于 0 和 100 之间")
	public String getSecnm() {
		return secnm;
	}

	public void setSecnm(String secnm) {
		this.secnm = secnm;
	}
	
	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}
	
	public Double getLendelta() {
		return lendelta;
	}

	public void setLendelta(Double lendelta) {
		this.lendelta = lendelta;
	}
	
	public Double getLenup() {
		return lenup;
	}

	public void setLenup(Double lenup) {
		this.lenup = lenup;
	}
	
}