package com.jsite.busi.szy.dispatch.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;
/**
 * 来水预报参数表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdIfpar extends AbstractData<DdsRdIfpar> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String secCd;		// 预报断面ID
	private Integer forTp;		// 预报方式
	private Integer state;		// 状态
	private String modelId;		// 模型ID
	
	public DdsRdIfpar() {
		super();
	}

	public DdsRdIfpar(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=6, message="预报断面ID长度必须介于 1 和 6 之间")
	public String getSecCd() {
		return secCd;
	}

	public void setSecCd(String secCd) {
		this.secCd = secCd;
	}
	
	public Integer getForTp() {
		return forTp;
	}

	public void setForTp(Integer forTp) {
		this.forTp = forTp;
	}
	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	@Length(min=0, max=6, message="模型ID长度必须介于 0 和 6 之间")
	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	
}