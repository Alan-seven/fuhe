package com.jsite.szy.dispatch.meeting.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 会商信息Entity
 * @author 徐旺旺
 * @version 2017-03-30
 */
public class DdsSConVO extends PageVO {
	
	private String conId;		// 会商ID
	private String conName;		// 会商名称
	private String conType;		// 会商类型  1-- 常规调度   2--应急调度
	
	//常规调度
	private String proTp;		//方案类型 1--年  2--月  3--旬
	private Integer year;		// 年
	private Integer month;		// 月
	private Integer tenDay;		//日
	private String proIdRec;		// 推荐方案标号
	private String proIdDec;		// 决策方案编号
	private Date dt;		// dt
	private String addr;		// 地点
	private String persons;		// 参与人员
	private String topics;		// 会商主题
	private String department;		// 主持单位
	private String summary;		// 会议纪要
	private String evenCd;		//应急事件ID
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	public DdsSConVO() {
		super();
	}

	@Length(min=1, max=32, message="会商ID长度必须介于 1 和32 之间")
	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}
	
	@Length(min=0, max=32, message="会商名称长度必须介于 0 和 32 之间")
	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}
	
	@Length(min=0, max=32, message="会商类型长度必须介于 0 和 32 之间")
	public String getConType() {
		return conType;
	}

	public void setConType(String conType) {
		this.conType = conType;
	}
	
	@Length(min=0, max=13, message="推荐方案标号长度必须介于 0 和 13 之间")
	public String getProIdRec() {
		return proIdRec;
	}

	public void setProIdRec(String proIdRec) {
		this.proIdRec = proIdRec;
	}
	
	@Length(min=0, max=13, message="决策方案编号长度必须介于 0 和 13 之间")
	public String getProIdDec() {
		return proIdDec;
	}

	public void setProIdDec(String proIdDec) {
		this.proIdDec = proIdDec;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}
	
	@Length(min=0, max=200, message="地点长度必须介于 0 和 200 之间")
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Length(min=0, max=1000, message="参与人员长度必须介于 0 和 1000 之间")
	public String getPersons() {
		return persons;
	}

	public void setPersons(String persons) {
		this.persons = persons;
	}
	
	@Length(min=0, max=255, message="会商主题长度必须介于 0 和 255 之间")
	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}
	
	@Length(min=0, max=32, message="主持单位长度必须介于 0 和 32 之间")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Length(min=0, max=2000, message="会议纪要长度必须介于 0 和 2000 之间")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Length(min=0, max=32, message="会议纪要长度必须介于 0 和32 之间")
	public String getEvenCd() {
		return evenCd;
	}

	public void setEvenCd(String evenCd) {
		this.evenCd = evenCd;
	}

	public String getProTp() {
		return proTp;
	}

	public void setProTp(String proTp) {
		this.proTp = proTp;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getTenDay() {
		return tenDay;
	}

	public void setTenDay(Integer tenDay) {
		this.tenDay = tenDay;
	}

	
}