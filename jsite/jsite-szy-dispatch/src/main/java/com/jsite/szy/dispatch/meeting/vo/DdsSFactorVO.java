package com.jsite.szy.dispatch.meeting.vo;

import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;

/**
 * 会商方案评价指标Entity
 * @author 徐旺旺
 * @version 2017-03-30
 */
public class DdsSFactorVO extends PageVO {
	
	private String factId;		// 指标ID
	private String factTp;		// 指标类型 FACT _TP —— 0常规调度评价指标；1应急水污染调度评价指标
	private String factNm;		// 指标名称
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	public DdsSFactorVO() {
		super();
	}

	@Length(min=1, max=6, message="指标ID长度必须介于 1 和6 之间")
	public String getFactId() {
		return factId;
	}

	public void setFactId(String factId) {
		this.factId = factId;
	}

	@Length(min=0, max=1, message="指标类型长度必须介于 0和1之间")
	public String getFactTp() {
		return factTp;
	}

	public void setFactTp(String factTp) {
		this.factTp = factTp;
	}

	@Length(min=1, max=20, message="指标名称长度必须介于 1 和20 之间")
	public String getFactNm() {
		return factNm;
	}

	public void setFactNm(String factNm) {
		this.factNm = factNm;
	}
	
}