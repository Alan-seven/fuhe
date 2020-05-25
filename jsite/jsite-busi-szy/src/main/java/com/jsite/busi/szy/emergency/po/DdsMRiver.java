package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.jsite.dao.AbstractData;

/**
 * 河流概化河段表Entity
 * @author hjx
 * @version 2017-06-12
 */
public class DdsMRiver extends AbstractData<DdsMRiver> {
	
	private static final long serialVersionUID = 1L;
	private String river;		// 河流代码
	private Integer rcd;		// 污染发生河段代码
	private String rnm;		// 污染位置河段
	private String calriver;		// 模拟计算河段
	
	public DdsMRiver() {
		super();
	}

	public DdsMRiver(String id){
		super(id);
	}

	@Length(min=1, max=2, message="河流代码长度必须介于 1 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	@NotNull(message="污染发生河段代码不能为空")
	public Integer getRcd() {
		return rcd;
	}

	public void setRcd(Integer rcd) {
		this.rcd = rcd;
	}
	
	@Length(min=0, max=100, message="污染位置河段长度必须介于 0 和 100 之间")
	public String getRnm() {
		return rnm;
	}

	public void setRnm(String rnm) {
		this.rnm = rnm;
	}
	
	@Length(min=0, max=100, message="模拟计算河段长度必须介于 0 和 100 之间")
	public String getCalriver() {
		return calriver;
	}

	public void setCalriver(String calriver) {
		this.calriver = calriver;
	}
	
}