package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;
import com.jsite.dao.AbstractData;

import java.util.List;

import javax.validation.constraints.NotNull;


/**
 * 告警规则表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsEdWrule extends AbstractData<DdsEdWrule> {
	
	private static final long serialVersionUID = 1L;
	private String stcd;		// 测站编码
	private String types;		// 监测指标
	private String unitCode;	//单位
	private Integer levels;		// 级别
	private Integer updown;		// 上下限标识
	private Double vavule;		// 指标值
	private String nt;		// 备注.
	
	private List<DdsEdWrule> wruleList = Lists.newArrayList();
	
	private String stNm;		//测站名称
	
	public DdsEdWrule() {
		super();
	}

	public DdsEdWrule(String id){
		super(id);
	}

	@Length(min=1, max=8, message="测站编码长度必须介于 1 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@Length(min=1, max=16, message="监测指标长度必须介于 1 和 16 之间")
	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}
	
	@NotNull(message="级别不能为空")
	public Integer getLevels() {
		return levels;
	}

	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	
	@NotNull(message="上下限标识不能为空")
	public Integer getUpdown() {
		return updown;
	}

	public void setUpdown(Integer updown) {
		this.updown = updown;
	}
	
	public Double getVavule() {
		return vavule;
	}

	public void setVavule(Double vavule) {
		this.vavule = vavule;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

	public String getStNm() {
		return stNm;
	}

	public void setStNm(String stNm) {
		this.stNm = stNm;
	}

	public List<DdsEdWrule> getWruleList() {
		return wruleList;
	}

	public void setWruleList(List<DdsEdWrule> wruleList) {
		this.wruleList = wruleList;
	}

	@Length(min=0, max=20, message="单位长度必须介于 0 和 20 之间")
	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

}