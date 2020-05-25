package com.jsite.szy.dispatch.meeting.vo;


import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.busi.szy.meeting.po.DdsSRes;
import com.jsite.core.web.PageVO;

/**
 * 历史案例Entity
 * @author hjx
 * @version 2017-07-26
 */
public class DdsSCaseVO extends PageVO{

	private String id;			//案例ID
	
	private Date hapDt;			//发生时间
	
	private String loc;			//发生地点
	
	private String sinfo;		//事件信息
	
	private String sresult;		//处置方法及结果
	
	private String[] resId;		//附件ID
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	private List<DdsSRes> ddsSRes;

	public DdsSCaseVO(){
		super();
	}
	
	@Length(min=1, max=32, message="案例ID长度必须介于 1 和32 之间")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
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

	public String[] getResId() {
		return resId;
	}

	public void setResId(String[] resId) {
		this.resId = resId;
	}

	public List<DdsSRes> getDdsSRes() {
		return ddsSRes;
	}

	public void setDdsSRes(List<DdsSRes> ddsSRes) {
		this.ddsSRes = ddsSRes;
	}
	
	
}
