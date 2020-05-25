package com.jsite.szy.dispatch.emergency.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;


/**
 * @author Dxl
 *
 * 控制断面
 */
public class ControlState implements Cloneable {

	private String StateType;//断面类型  0水库，1测站，2、取水口，3，made
	private String StateID;//断面id
	private int FID;//断面图层编号
	private String StateName;//断面名称
	private double upDistance;//节点距离上边界里程
	
	//private double initialCon;//初始浓度
	private double[] initialCon;//初始浓度,支持多溶质-20171105增加
	private double initialLevel;//初始水位
	private double initialQ;//初始流量
	
	//private double[] tributary;// 单位：立方米每秒--支流入流、取水口出流
	
	private int controlObject;// 控制目标  0、普通，1、水量，2、水质
	private double controlValue;// 流量 或 水位 或 水质 要达到的浓度目标
	
	/**
	 * 以下输出界面展示用，模型计算的结果
	 */
	
	private String Qtype;//结果类型：0 表示原计划下泄，1表示调整水库下泄，缺省值为0
	
	private double confluxTime;//从上边界 开始的 累计汇流时间
	private String[] date;// 时刻
	
	private int infuenceTime; // 水质大于目标值的时间
	private double[] inFlow;// 单位：立方米每秒
	private double[] outFlow;// 单位：立方米每秒
	private double[] Level;// 水位
	private double[] concentration;// 污染物浓度     单位：毫克每升
	private double[] WaterSpeed;
	
	// 调整下泄后
	private int realinfTime; // 水质大于目标值的时间
	private double[] realFlow;// 单位：立方米每秒
	private double[] realLevel;// 水位
	private double[] realconcen;// 污染物浓度     单位：毫克每升
	private double[] realSpeed;
	
	public String getStateType() {
		return StateType;
	}
	public void setStateType(String stateType) {
		StateType = stateType;
	}
	public String getStateName() {
		return StateName;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}
	
	public int getFID() {
		return FID;
	}
	public void setFID(int fID) {
		FID = fID;
	}
	public double getUpDistance() {
		return upDistance;
	}
	public void setUpDistance(double upDistance) {
		this.upDistance = upDistance;
	}
	
	public double[] getInitialCon() {
		return initialCon;
	}
	public void setInitialCon(double[] initialCon) {
		this.initialCon = initialCon;
	}
	public double getInitialLevel() {
		return initialLevel;
	}
	public void setInitialLevel(double initialLevel) {
		this.initialLevel = initialLevel;
	}
	public double getInitialQ() {
		return initialQ;
	}
	public void setInitialQ(double initialQ) {
		this.initialQ = initialQ;
	}
	
	public int getControlObject() {
		return controlObject;
	}
	public void setControlObject(int controlObject) {
		this.controlObject = controlObject;
	}
	public double getControlValue() {
		return controlValue;
	}
	public void setControlValue(double controlValue) {
		this.controlValue = controlValue;
	}
	public String getQtype() {
		return Qtype;
	}
	public void setQtype(String qtype) {
		Qtype = qtype;
	}
	public double getConfluxTime() {
		return confluxTime;
	}
	public void setConfluxTime(double confluxTime) {
		this.confluxTime = confluxTime;
	}
	
	public int getInfuenceTime() {
		return infuenceTime;
	}
	public void setInfuenceTime(int infuenceTime) {
		this.infuenceTime = infuenceTime;
	}
	public String[] getDate() {
		return date;
	}
	public void setDate(String[] date) {
		this.date = date;
	}
	
	public double[] getInFlow() {
		return inFlow;
	}
	public void setInFlow(double[] inFlow) {
		this.inFlow = inFlow;
	}
	public double[] getOutFlow() {
		return outFlow;
	}
	public int getRealinfTime() {
		return realinfTime;
	}
	public void setRealinfTime(int realinfTime) {
		this.realinfTime = realinfTime;
	}
	public String getStateID() {
		return StateID;
	}
	public void setStateID(String stateID) {
		StateID = stateID;
	}
	public void setOutFlow(double[] outFlow) {
		this.outFlow=new double[outFlow.length];
		for (int i = 0; i < outFlow.length; i++) {
			BigDecimal  b  =   new   BigDecimal(outFlow[i]);  
			double  f1  =  b.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();
			this.outFlow[i]= f1;
			//this.outFlow[i]=(double)Math.round((outFlow[i])*10)/10;// 1位小数
		}
//		this.outFlow = outFlow;
	}
	public double[] getLevel() {
		return Level;
	}
	public void setLevel(double[] level) {
		this.Level=new double[level.length];
		for (int i = 0; i < level.length; i++) {
			BigDecimal  b  =   new   BigDecimal(level[i]);  
			double  f1  =  b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
			this.Level[i]=f1;// 2位小数
			//this.Level[i]=(double)Math.round((level[i])*100)/100;// 2位小数
		}
//		Level = level;
	}
	
	public double[] getConcentration() {
		return concentration;
	}
	public void setConcentration(double[] concentration) {
		this.concentration=new double[concentration.length];
		for (int i = 0; i < concentration.length; i++) {
			BigDecimal   b   =   new   BigDecimal(concentration[i]);  
			double   f1   =   b.setScale(6,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			//this.concentration[i]=(double)Math.round((concentration[i])*1000000)/1000000;// 6位小数//concentration[i];
			this.concentration[i] = f1;
			//System.out.println(concentration[i]);
		}
//		this.concentration = concentration;
	}
	
	public double[] getRealFlow() {
		return realFlow;
	}
	public void setRealFlow(double[] realFlow) {
		//this.realFlow = realFlow;
		this.realFlow=new double[realFlow.length];
		for (int i = 0; i < realFlow.length; i++) {
			//this.realFlow[i]=(double)Math.round((realFlow[i])*10)/10;// 1位小数
			BigDecimal  b  =   new   BigDecimal(realFlow[i]);  
			double  f1  =  b.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();
			this.realFlow[i]= f1;
		}
	}
	public double[] getRealLevel() {
		return realLevel;
	}
	public void setRealLevel(double[] realLevel) {
		//this.realLevel = realLevel;
		this.realLevel=new double[realLevel.length];
		for (int i = 0; i < realLevel.length; i++) {
			//this.realLevel[i]=(double)Math.round((realLevel[i])*100)/100;// 2位小数
			BigDecimal  b  =   new   BigDecimal(realLevel[i]);  
			double  f1  =  b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
			this.realLevel[i]=f1;
		}
		
	}
	public double[] getRealconcen() {
		return realconcen;
	}
	public void setRealconcen(double[] realconcen) {
		//this.realconcen = realconcen;
		this.realconcen=new double[realconcen.length];
		for (int i = 0; i < realconcen.length; i++) {
			//this.realconcen[i]=realconcen[i];
			BigDecimal  b  =   new   BigDecimal(realconcen[i]);  
			double  f1  =  b.setScale(5,   BigDecimal.ROUND_HALF_UP).doubleValue();
			//this.realconcen[i]=(double)Math.round((realconcen[i])*100000)/100000;// 5位小数
			this.realconcen[i]= f1;
		}
	}
	public double[] getWaterSpeed() {
		return WaterSpeed;
	}
	public void setWaterSpeed(double[] waterSpeed) {
		//WaterSpeed = waterSpeed;
		this.WaterSpeed=new double[waterSpeed.length];
		for (int i = 0; i < waterSpeed.length; i++) {
			this.WaterSpeed[i]=waterSpeed[i];
		}
		
	}
	public double[] getRealSpeed() {
		return realSpeed;
	}
	public void setRealSpeed(double[] realSpeed) {
		//this.realSpeed = realSpeed;
		this.realSpeed=new double[realSpeed.length];
		for (int i = 0; i < realSpeed.length; i++) {
			//this.realSpeed[i]=(double)Math.round((realSpeed[i])*1000)/1000;// 1位小数
			BigDecimal  b  =   new   BigDecimal(realSpeed[i]);  
			double  f1  =  b.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();
			this.realSpeed[i]= f1;
		}
	}
	
}

