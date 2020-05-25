package com.jsite.szy.dispatch.emergency.model;

public class GISData {
	 // 前台要求出planValue和realValue的综合的max、min，用来做色彩分级、图例用，如分5级
     String time; // 时刻值：0、1、2h
     int Fid;
	 double planValue;// “水质模拟”、“水量调度”都有这个结果
	 double realValue;// 只有水库参与的“水量调度”有这个结果（对应水库加大泄后的浓度序列）
	 
	 int pColor;// 浓度为planValue时 fid对应的颜色  1、2、 3、 4、 5 颜色依次变深
	 int rColor;// 浓度为planValue时 fid对应的颜色  1、2、 3、 4、 5 颜色依次变深
	 
	
	 
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getFid() {
		return Fid;
	}
	public void setFid(int fid) {
		Fid = fid;
	}
	public double getPlanValue() {
		return planValue;
	}
	public void setPlanValue(double planValue) {
		this.planValue = planValue;
	}
	public double getRealValue() {
		return realValue;
	}
	public void setRealValue(double realValue) {
		this.realValue = realValue;
	}
	public int getpColor() {
		return pColor;
	}
	public void setpColor(int pColor) {
		this.pColor = pColor;
	}
	public int getrColor() {
		return rColor;
	}
	public void setrColor(int rColor) {
		this.rColor = rColor;
	}

    
}
