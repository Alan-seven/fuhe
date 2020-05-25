/**
 */
package com.jsite.busi.szy.info.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;


/**
 * 测站实测流量信息表Entity
 * @author hjx
 * @version 2017-04-27
 */
public class DdsDStmq extends AbstractData<DdsDStmq> {
	
	private static final long serialVersionUID = 1L;
	private String stcd;		// 测站代码
	private String stNm;	//测站名称
	private String tm;		// 时间
	private Double q;		// 流量
	private Integer speRegData;		// 特殊区域数据
	private Date ts;		// 时间戳
	
	private String startTm;  	//查询开始时间
	private String endTm;  	//查询结束时间
	
	public DdsDStmq() {
		super();
	}

	public DdsDStmq(String id){
		super(id);
	}

	@Length(min=1, max=8, message="测站代码长度必须介于 1 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	public String getStNm() {
		return stNm;
	}

	public void setStNm(String stNm) {
		this.stNm = stNm;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Length(min=1, max=6, message="时间长度必须介于 1 和 6 之间")
	public String getTm() {
		return tm;
	}

	public void setTm(String tm) {
		this.tm = tm;
	}
	
	public Double getQ() {
		return q;
	}

	public void setQ(Double q) {
		this.q = q;
	}
	
	public Integer getSpeRegData() {
		return speRegData;
	}

	public void setSpeRegData(Integer speRegData) {
		this.speRegData = speRegData;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public String getStartTm() {
		return startTm;
	}

	public void setStartTm(String startTm) {
		this.startTm = startTm;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public String getEndTm() {
		return endTm;
	}

	public void setEndTm(String endTm) {
		this.endTm = endTm;
	}
}