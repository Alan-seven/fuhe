package com.jsite.busi.wq.data.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 监测数据统计Entity
 * @author 徐旺旺
 * @version 2017-04-09
 */
public class DataStatis extends AbstractData<DataStatis> {
	
	private static final long serialVersionUID = 1L;
	private String tm;		// tm
	private String stcd;		// 监测站
	private String itmId;		// 指标ID
	private String emptyTimes;		// 空值次数
	private String outTimes;		// 超标次数
	private String sttdrcd;		// 统计时段标志1一日，2三日，3一侯，4一旬，5一月，6一年
	
	public DataStatis() {
		super();
	}

	public DataStatis(String id){
		super(id);
	}

	@Length(min=1, max=23, message="tm长度必须介于 1 和 23 之间")
	public String getTm() {
		return tm;
	}

	public void setTm(String tm) {
		this.tm = tm;
	}
	
	@Length(min=1, max=10, message="监测站长度必须介于 1 和 10 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@Length(min=1, max=64, message="指标ID长度必须介于 1 和 64 之间")
	public String getItmId() {
		return itmId;
	}

	public void setItmId(String itmId) {
		this.itmId = itmId;
	}
	
	@Length(min=0, max=11, message="空值次数长度必须介于 0 和 11 之间")
	public String getEmptyTimes() {
		return emptyTimes;
	}

	public void setEmptyTimes(String emptyTimes) {
		this.emptyTimes = emptyTimes;
	}
	
	@Length(min=0, max=11, message="超标次数长度必须介于 0 和 11 之间")
	public String getOutTimes() {
		return outTimes;
	}

	public void setOutTimes(String outTimes) {
		this.outTimes = outTimes;
	}
	
	@Length(min=0, max=1, message="统计时段标志1一日，2三日，3一侯，4一旬，5一月，6一年长度必须介于 0 和 1 之间")
	public String getSttdrcd() {
		return sttdrcd;
	}

	public void setSttdrcd(String sttdrcd) {
		this.sttdrcd = sttdrcd;
	}
	
}