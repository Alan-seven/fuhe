package com.jsite.busi.wq.data.po;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * @author 徐旺旺
 * @version 2017-04-09
 */
public class Data extends AbstractData<Data> {

	private static final long serialVersionUID = 1L;
	private String stcd; // 测站编码
	private Date tm; // 采集时间
	private String itmId; // 指标名称
	private String itmVl; // 指标值

	public Data() {
		super();
	}

	public Data(String id) {
		super(id);
	}

	@Length(min = 0, max = 64, message = "测站编码长度必须介于 0 和 64 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}

	@Length(min = 0, max = 64, message = "指标名称长度必须介于 0 和 64 之间")
	public String getItmId() {
		return itmId;
	}

	public void setItmId(String itmId) {
		this.itmId = itmId;
	}

	@Length(min = 0, max = 64, message = "指标值长度必须介于 0 和 64 之间")
	public String getItmVl() {
		return itmVl;
	}

	public void setItmVl(String itmVl) {
		this.itmVl = itmVl;
	}
}