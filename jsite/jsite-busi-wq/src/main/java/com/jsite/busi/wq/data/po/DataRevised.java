package com.jsite.busi.wq.data.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 数据校正Entity
 * @author 徐旺旺
 * @version 2017-04-09
 */
public class DataRevised extends AbstractData<DataRevised> {
	
	private static final long serialVersionUID = 1L;
	private String dataId;		// data_id
	private String revised;		// 修正后的值
	
	public DataRevised() {
		super();
	}

	public DataRevised(String id){
		super(id);
	}

	@Length(min=0, max=64, message="data_id长度必须介于 0 和 64 之间")
	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	
	@Length(min=0, max=10, message="修正后的值长度必须介于 0 和 10 之间")
	public String getRevised() {
		return revised;
	}

	public void setRevised(String revised) {
		this.revised = revised;
	}
}