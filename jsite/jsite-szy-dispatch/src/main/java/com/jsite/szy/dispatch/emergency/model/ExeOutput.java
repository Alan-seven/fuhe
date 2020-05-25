package com.jsite.szy.dispatch.emergency.model;

import java.util.List;

/**
 * @author Dxl
 *  模型统一输入 
 */
public class ExeOutput{
	/**
	 * 输出展示用
	 */
	private double time;//计算耗时间
	double delt;// 输出时间间隔
	/**
	 * 输出所有断面结果
	 */
	private ControlState states[];
	
	
	public void setdelt(double mydelt){
		this.delt=mydelt;
	}
	public double getdelt() {
		return this.delt;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public ControlState[] getStates() {
		return states;
	}
	public void setStates(ControlState[] states) {
		this.states = states;
	}
	
}
