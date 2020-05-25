package com.jsite.busi.wq.data.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 设备信息Entity
 * @author 徐旺旺
 * @version 2017-04-09
 */
public class Device extends AbstractData<Device> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String precision;		// precision
	
	public Device() {
		super();
	}

	public Device(String id){
		super(id);
	}

	@Length(min=0, max=255, message="name长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=11, message="precision长度必须介于 0 和 11 之间")
	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}
	
}