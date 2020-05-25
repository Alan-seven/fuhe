package com.jsite.busi.szy.meeting.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 会商方案评价指标Entity
 * @author 徐旺旺
 * @version 2017-03-30
 */
public class DdsSFactor extends AbstractData<DdsSFactor> {
	
	private static final long serialVersionUID = 1L;
	private String factId;		// 指标ID
	private String factTp;		// 指标类型
	private String factNm;		// 指标名称
	
	public DdsSFactor() {
		super();
	}

	public DdsSFactor(String id){
		super(id);
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