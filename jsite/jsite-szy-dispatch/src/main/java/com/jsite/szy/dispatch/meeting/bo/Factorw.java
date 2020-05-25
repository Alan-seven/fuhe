package com.jsite.szy.dispatch.meeting.bo;

import java.util.Map;

public class Factorw {

	private String proCd;		//方案编号
	
	private Integer flag;		//是否是推荐方案编号
	
	private String name;		//方案名称
	
	private String scores;		//综合得分
	
	private Map<String,Object> map;		//方案评价指标得分

	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getScores() {
		return scores;
	}

	public void setScores(String scores) {
		this.scores = scores;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}
