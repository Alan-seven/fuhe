package com.jsite.busi.wq.data.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 指标信息Entity
 * @author 徐旺旺
 * @version 2017-04-09
 */
public class Itm extends AbstractData<Itm> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String sort;		// sort
	private String unit;		// unit
	
	public Itm() {
		super();
	}

	public Itm(String id){
		super(id);
	}

	@Length(min=0, max=20, message="name长度必须介于 0 和 20 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=11, message="sort长度必须介于 0 和 11 之间")
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	@Length(min=0, max=10, message="unit长度必须介于 0 和 10 之间")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}