package com.jsite.szy.dispatch.emergency.model;

import java.util.Date;

/**
 * @author Dxl
 *  模型统一输入 
 *  20170615增加的上下边界类型
 */
public class ExeInput{
	/**
	 * 1、水污染（水动力水质），2、干旱（水动力）
	 */
	private int modelType;// 
	/**
	 * 污染发生河段代码： 1 、沙子岭-南城     2、洪门坝下-廖坊入库   
	 *               3、临水应急取水口-娄家村-汇入点   
	 *               4、廖坊坝-李家渡（临水用娄家村的流量作为支流汇入，考虑洪门下泄的到廖坊入库的汇流时间）
	 */
	private int riverCode;// 
	/**
	 * 控制断面
	 */
	private ControlState states[]; //这里面会给出  河段中的 节点名称，位置，支流入流、取水口出流
	/**
	 * 模型参数
	 */
	private double r;//糙率
	//private  double n[];// 按控制断面区间给
	private int solvendkinds;//溶质种类
	private double a[];// 扩散系数
	private double k[];// 降解系数
	
	
	/**
	 * 输入序列的时间间隔：1h(默认),或2h等
	 */
	private int deltaT;
	/**
	 * 计算总时长，单位：h
	 */
	private int length;//
	
	/**
	 * 流量上边界时序(m3/s)
	 */
	private double upboundary[];
	/**
	 * 水位下边界时序(m)
	 */
	private double lowboundary[];
	
	
	/**
	 * 点源个数
	 */
	private int pnum;	
	/**
	 * 点源所在河流
	 */
	private String priver[];
	/**
	 * 点源里程
	 */
	private double plength[];
	/**
	 * 点源坐标
	 */
	private double  coordinate[][];//n*2,列分别是经度、纬度
	/**
	 * 输入时序点数
	 */
	private int tnum;	
	/**
	 * 时序点（距起始时刻秒数）
	 */
	private double tlength[];
	/**
	 * 各点源时序流量(m3/s)，矩阵=点源数*时序点
	 */
	private double pointQ[][];
	
	/**
	 * 浓度入流点源数
	 */
	private int solvendn[];
	/**
	 * 浓度入流点源编号
	 */
	private String solvendq[][];
	/**
	 * 浓度入流时序数据，矩阵=溶质*点源数*时序点
	 */
	private double solvendtimesity[][][];
	
	// 以下为增加的上下边界类型
	/**
	 * 下边界种类，默认false为水位时序，true为水位流量关系
	 */
	private boolean stagedischarge;
	/**
	 * 水位流量关系点数
	 */
	private int stagepn;
	/**
	 * 水位流量关系对
	 */
	private double stagep[][];
	/**
	 * 上边界条件类型 0：流量
	 */
	private int upBoundaryType;
	/**
	 * 下边界条件类型-1：水位，-2：水位流量关系
	 */
	private int lowBoundaryType;
	
	
	public int getModelType() {
		return modelType;
	}

	public void setModelType(int modelType) {
		this.modelType = modelType;
	}

	public int getRiverCode() {
		return riverCode;
	}

	public void setRiverCode(int riverCode) {
		this.riverCode = riverCode;
	}

	public void setsolvendtimesity(double[][][] mysolvendtimesity){
		this.solvendtimesity=mysolvendtimesity;
	}
	
	public double[][][] getsolvendtimesity(){
		return this.solvendtimesity;
	}
	public String[][] getsolvendq() {
		return this.solvendq;
	}
	public void setsolvendq(String[][] mysolvendq) {
		this.solvendq=mysolvendq;
	}
	
	public int[] getsolvendn() {
		return this.solvendn;
	}
	public void setsolvendn(int[] mysolvendn) {
		this.solvendn=mysolvendn;
	}
	public int getpnum() {
		return this.pnum;
	}
	public void setpnum(int mypnum) {
		this.pnum=mypnum;
	}
	public String[] getpriver() {
		return this.priver;
	}
	public void setpriver(String[] mypriver) {
		this.priver=mypriver;
	}
	public double[] getplength() {
		return this.plength;
	}
	public void setplength(double[] myplength) {
		this.plength=myplength;
	}
	
	public double[][] getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(double[][] coordinate) {
		this.coordinate = coordinate;
	}

	public int gettnum() {
		return this.tnum;
	}
	public void settnum(int mytnum) {
		this.tnum=mytnum;
	}
	public double[] gettlength() {
		return this.tlength;
	}
	public void settlength(double[] mytlength) {
		this.tlength=mytlength;
	}
	
	public double[][] getpointQ() {
		return this.pointQ;
	}
	public void setpointQ(double[][] mypointQ) {
		this.pointQ=mypointQ;
	}
	
	public double[] getupboundary() {
		return this.upboundary;
	}
	public void setupboundary(double[] myupboundary) {
		this.upboundary=myupboundary;
	}
	public double[] getlowboundary() {
		return this.lowboundary;
	}
	public void setlowboundary(double[] mylowboundary) {
		this.lowboundary=mylowboundary;
	}


	public int getDeltaT() {
		return deltaT;
	}

	public void setDeltaT(int deltaT) {
		this.deltaT = deltaT;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	
	
	public ControlState[] getStates() {
		return states;
	}

	public void setStates(ControlState[] states) {
		this.states = states;
	}



	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double[] getA() {
		return a;
	}

	public void setA(double[] a) {
		this.a = a;
	}

	public double[] getK() {
		return k;
	}

	public void setK(double[] k) {
		this.k = k;
	}

	public boolean isStagedischarge() {
		return stagedischarge;
	}

	public void setStagedischarge(boolean stagedischarge) {
		this.stagedischarge = stagedischarge;
	}

	public double[][] getStagep() {
		return stagep;
	}

	public void setStagep(double stagep[][]) {
		this.stagep = stagep;
	}

	public int getStagepn() {
		return stagepn;
	}

	public void setStagepn(int stagepn) {
		this.stagepn = stagepn;
	}

	public int getSolvendkinds() {
		return solvendkinds;
	}

	public void setSolvendkinds(int solvendkinds) {
		this.solvendkinds = solvendkinds;
	}
	
	
}
