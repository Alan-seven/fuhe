package com.jsite.busi.szy.meeting.po;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 历史案例Entity
 * @author hjx
 * @version 2017-07-26
 */
public class DdsSCase extends AbstractData<DdsSCase>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date hapDt;			//发生时间
	
	private String loc;			//发生地点
	
	private String sinfo;		//事件信息
	
	private String sresult;		//处置方法及结果
	
	private List<DdsSRes> ddsSResList;
	
	public DdsSCase(){
		super();
	}

	public DdsSCase(String id){
		super(id);
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getHapDt() {
		return hapDt;
	}

	public void setHapDt(Date hapDt) {
		this.hapDt = hapDt;
	}

	@Length(min=0, max=200, message="发生地点长度必须介于0 和200 之间")
	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Length(min=0, max=512, message="事件信息长度必须介于0 和512 之间")
	public String getSinfo() {
		return sinfo;
	}

	public void setSinfo(String sinfo) {
		this.sinfo = sinfo;
	}

	@Length(min=0, max=512, message="处置方法及结果长度必须介于0 和512 之间")
	public String getSresult() {
		return sresult;
	}

	public void setSresult(String sresult) {
		this.sresult = sresult;
	}
	
	public List<DdsSRes> getDdsSResList() {
		return ddsSResList;
	}

	public void setDdsSResList(List<DdsSRes> ddsSResList) {
		this.ddsSResList = ddsSResList;
	}
	
}
