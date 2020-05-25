package com.jsite.szy.dispatch.meeting.vo;

import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;

/**
 * 会商方案专家打分Entity
 * @author 徐旺旺
 * @version 2017-03-30
 */
public class DdsSGradeVO extends PageVO{
	
	private String conId;		// 会商ID
	private String proId;		// 方案ID
	private String expId;		// 专家ID
	private String grade;		// 评分
	private String weight;		// 专家权重
	
	public DdsSGradeVO() {
		super();
	}

	@Length(min=1, max=8, message="会商ID长度必须介于 1 和 8 之间")
	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}
	
	@Length(min=1, max=8, message="方案ID长度必须介于 1 和 8 之间")
	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}
	
	@Length(min=1, max=8, message="专家ID长度必须介于 1 和 8 之间")
	public String getExpId() {
		return expId;
	}

	public void setExpId(String expId) {
		this.expId = expId;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
}