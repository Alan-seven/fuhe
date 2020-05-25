package com.jsite.busi.szy.emergency.po;

import java.util.List;

public class EDResData {

	private String time;	// 时刻值：0、1、2h
	private List<DdsEdRes> data;//按照主键分组后，封装
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<DdsEdRes> getData() {
		return data;
	}
	public void setData(List<DdsEdRes> data) {
		this.data = data;
	}
	
}
