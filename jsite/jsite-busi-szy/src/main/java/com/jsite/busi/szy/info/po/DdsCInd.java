package com.jsite.busi.szy.info.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsCInd extends AbstractData<DdsCInd> {
	
	private static final long serialVersionUID = 1L;
	private String curveId;		// 曲线ID
	private String curveNm;		// 曲线名称
	private String curveEp;		// 曲线说明
	private String ts;		// 时间戳
	private String nt;		// 备注
	
	public DdsCInd() {
		super();
	}

	public DdsCInd(String id){
		super(id);
	}

	@Length(min=1, max=6, message="曲线ID长度必须介于 1 和 6 之间")
	public String getCurveId() {
		return curveId;
	}

	public void setCurveId(String curveId) {
		this.curveId = curveId;
	}
	
	@Length(min=0, max=100, message="曲线名称长度必须介于 0 和 100 之间")
	public String getCurveNm() {
		return curveNm;
	}

	public void setCurveNm(String curveNm) {
		this.curveNm = curveNm;
	}
	
	@Length(min=0, max=200, message="曲线说明长度必须介于 0 和 200 之间")
	public String getCurveEp() {
		return curveEp;
	}

	public void setCurveEp(String curveEp) {
		this.curveEp = curveEp;
	}
	
	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}