package com.jsite.szy.dispatch.emergency.vo;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;


/**
 * 河流模型边界表Entity
 * @author hjx
 * @version 2017-06-12
 */
public class DdsMBoundryVO extends PageVO {
	
	private Integer rcd;		// 污染发生河段代码
	private String bname;		// 边界名称
	private String vtype;		// 数值类型
	private String stcd;		// 边界对应的测站代码
	private String secnm;		// 边界对应的断面名称
	private String fieldnm;		// 数据查询字段标识
	private String btype;		// 边界类型
	private String river;		//河流标识
	private Integer ord;		//排序
	
	private Double defaultValue;	//默认监测值
	
	public DdsMBoundryVO() {
		super();
	}

	@NotNull(message="污染发生河段代码不能为空")
	public Integer getRcd() {
		return rcd;
	}

	public void setRcd(Integer rcd) {
		this.rcd = rcd;
	}
	
	@Length(min=1, max=20, message="边界名称长度必须介于 1 和 20 之间")
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}
	
	@Length(min=0, max=10, message="数值类型长度必须介于 0 和 10 之间")
	public String getVtype() {
		return vtype;
	}

	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	
	@Length(min=0, max=8, message="边界对应的测站代码长度必须介于 0 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@Length(min=0, max=20, message="边界对应的断面名称长度必须介于 0 和 20 之间")
	public String getSecnm() {
		return secnm;
	}

	public void setSecnm(String secnm) {
		this.secnm = secnm;
	}
	
	@Length(min=0, max=20, message="数据查询字段标识长度必须介于 0 和 20 之间")
	public String getFieldnm() {
		return fieldnm;
	}

	public void setFieldnm(String fieldnm) {
		this.fieldnm = fieldnm;
	}
	
	@Length(min=0, max=20, message="边界类型长度必须介于 0 和 20 之间")
	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}

	public Integer getOrd() {
		return ord;
	}

	public void setOrd(Integer ord) {
		this.ord = ord;
	}

	public Double getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Double defaultValue) {
		this.defaultValue = defaultValue;
	}
	
}