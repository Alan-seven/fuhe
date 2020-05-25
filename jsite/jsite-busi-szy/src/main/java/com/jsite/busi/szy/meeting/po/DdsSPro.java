package com.jsite.busi.szy.meeting.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 会商方案Entity
 * @author 徐旺旺
 * @version 2017-03-30
 */
public class DdsSPro extends AbstractData<DdsSPro> {
	
	private static final long serialVersionUID = 1L;
	private String conId;		// 会商ID
	private String proId;		// 方案编号
	private String grade;		// 方案评分
	private String conTech;		// con_tech
	
	public DdsSPro() {
		super();
	}

	public DdsSPro(String id){
		super(id);
	}

	@Length(min=1, max=32, message="会商ID长度必须介于 1 和 32 之间")
	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}
	
	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Length(min=0, max=12, message="con_tech长度必须介于 0 和 12 之间")
	public String getConTech() {
		return conTech;
	}

	public void setConTech(String conTech) {
		this.conTech = conTech;
	}
	
}