package com.jsite.busi.szy.meeting.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 *	会商方案评价规则表Entity
 * @author hjx
 * @version 2017-07-20
 */
public class DdsSFactorw extends AbstractData<DdsSFactorw>{

	private static final long serialVersionUID = 1L;
	private String conId;		// 会商ID
	private String factId;		// 指标ID
	private String scoreMax;		// 最优指标得分
	private String weight;		// 指标权重
	private String scoreMin;		// 最劣指标得分
	
	public DdsSFactorw() {
		super();
	}

	public DdsSFactorw(String id){
		super(id);
	}
	
	@Length(min=1, max=32, message="会商ID长度必须介于 1 和 32 之间")
	public String getConId() {
		return conId;
	}
	public void setConId(String conId) {
		this.conId = conId;
	}
	
	public String getScoreMax() {
		return scoreMax;
	}
	
	@Length(min=1, max=6, message="指标ID长度必须介于 1 和 6 之间")
	public String getFactId() {
		return factId;
	}
	public void setFactId(String factId) {
		this.factId = factId;
	}
	public void setScoreMax(String scoreMax) {
		this.scoreMax = scoreMax;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getScoreMin() {
		return scoreMin;
	}
	public void setScoreMin(String scoreMin) {
		this.scoreMin = scoreMin;
	}
	
}
