package com.jsite.szy.dispatch.emergency.model;

import java.util.List;

public class ModelResult {

	String Information; //模型计算报错提示
	/**
	 * 水库调度结果，存库、图表 用
	 */
	Reservior[] reserviors;
	
	/**
	 * 输出全部的断面结果(原计划、调整后)，存库
	 */
	private List<ControlState> listALL;
	/**
	 * 输出控制断面结果(原计划、调整后)，供图表展示
	 */
	private List<ControlState> listSEC;
	
	/**
	 * 输出全部断面水质序列(原计划、调整后)，GIS动画展示用
	 */
	private List<GISData> listGIS;
	//2017.10.27新增legend
	private GISLegend legend;// 这里面存了planValue和realValue 的最大、最小值，前台分成5段 拿来做图例显示
	
	/**
	 * 方案评价指标：
	 * 应急时长（这里算不了）
	 * 受影响取水口（个）、最大中断时长（h）、应急耗水量（万m³）、水头损失（m）
	*/
	private int intakeNUM; //受影响取水口（个）
	private double interTM; //最大中断时长（h）
	private double deltaWA; //应急耗水量（万m³）-几个水库耗水总量
	private double deltaHA; //水头损失（m）-几个水库平均水头损失
	
	public String getInformation() {
		return Information;
	}
	public void setInformation(String information) {
		Information = information;
	}
	public Reservior[] getReserviors() {
		return reserviors;
	}
	public void setReserviors(Reservior[] reserviors) {
		this.reserviors = reserviors;
	}
	public List<ControlState> getListALL() {
		return listALL;
	}
	public void setListALL(List<ControlState> listALL) {
		this.listALL = listALL;
	}
	public List<ControlState> getListSEC() {
		return listSEC;
	}
	public void setListSEC(List<ControlState> listSEC) {
		this.listSEC = listSEC;
	}
	public List<GISData> getListGIS() {
		return listGIS;
	}
	public void setListGIS(List<GISData> listGIS) {
		this.listGIS = listGIS;
	}
	public int getIntakeNUM() {
		return intakeNUM;
	}
	public void setIntakeNUM(int intakeNUM) {
		this.intakeNUM = intakeNUM;
	}
	public double getInterTM() {
		return interTM;
	}
	public void setInterTM(double interTM) {
		this.interTM = interTM;
	}
	public double getDeltaWA() {
		return deltaWA;
	}
	public void setDeltaWA(double deltaWA) {
		this.deltaWA = deltaWA;
	}
	public double getDeltaHA() {
		return deltaHA;
	}
	public void setDeltaHA(double deltaHA) {
		this.deltaHA = deltaHA;
	}
	public GISLegend getLegend() {
		return legend;
	}
	public void setLegend(GISLegend legend) {
		this.legend = legend;
	}
	
	
}
