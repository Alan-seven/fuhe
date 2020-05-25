package com.jsite.szy.dispatch.emergency.vo;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;


/**
 * 河段模型水库表Entity
 * @author hjx
 * @version 2017-06-12
 */
public class DdsMRsvVO extends PageVO {
	
	private Integer rcd;		// 污染发生河段代码
	private String rescd;		//水库编码
	private String resnm;		// 参与调度水库名称
	private String stcd;		// 水库测站编码
	private String stnm;		// 水库测站名称
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
	private Double defaultValue;	//默认监测值
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	public DdsMRsvVO() {
		super();
	}


	@NotNull(message="污染发生河段代码不能为空")
	public Integer getRcd() {
		return rcd;
	}

	public void setRcd(Integer rcd) {
		this.rcd = rcd;
	}
	
	@Length(min=1, max=100, message="参与调度水库名称长度必须介于 1 和 100 之间")
	public String getResnm() {
		return resnm;
	}

	public void setResnm(String resnm) {
		this.resnm = resnm;
	}
	
	@Length(min=0, max=8, message="水库测站编码长度必须介于 0 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@Length(min=0, max=100, message="水库测站名称长度必须介于 0 和 100 之间")
	public String getStnm() {
		return stnm;
	}

	public void setStnm(String stnm) {
		this.stnm = stnm;
	}


	public String getRescd() {
		return rescd;
	}


	public void setRescd(String rescd) {
		this.rescd = rescd;
	}

	public Double getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Double defaultValue) {
		this.defaultValue = defaultValue;
	}
	
}