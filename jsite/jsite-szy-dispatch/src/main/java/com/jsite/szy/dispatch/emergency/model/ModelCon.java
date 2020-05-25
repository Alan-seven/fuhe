package com.jsite.szy.dispatch.emergency.model;

import java.util.Date;

public class ModelCon {

	/**
	 *  方案基本信息表
	 */
	private String PRO_CD;
	private int deltaT;//输入序列的时间间隔：一般默认1h
	// 时间顺序：预热期foreTime、起始时间0、污染发生时刻accurTime、持续时段数durTime、计算总时段数length
	private Date startTime;// 计算起始时间，
	private int foreTime;//前沿时段数
	private int length;//计算总时段数
	// 转化时段数变量
	private int accurTime;//污染发生时间 距离 计算起始时间的时段数 (TM-startTime)/deltaT
	private int durTime;// 污染物持续时段数 DUR/deltaT
	
	/**
	 * 污染源信息表
	 */
	private Date TM;// 污染发生时间
	private double DUR;// 污染物持续时间 h
	private int RCD;//发生河道
	private String UPSEC;//上监测断面ID
	private double LEN_UP;//起点距 = 距离上监测断面的距离+上断面的起点距
	private double DA;// 污染量：kg
	private int DA_TYPE;//污染物类型  0保守型物质、1挥发性物质 体现在降解系数不同
	
	/**
	 * 方案模型参数信息——加
	 */
	private  double r;// 按控制断面区间给
	private double a;// 扩散系数
	private double k;// 衰减系数
	
	/**
	 * 初始条件信息
	 */
	 private  double BG_CO;// 流域初始浓度（新建方案界面）
	 private  double[] BG_Z;//水库初始水位（水库运行方式界面）
	 private double[] BG_CONC; // 水库初始污染物浓度
	 private double[] BG_Q;// 断面初始流量（新建方案界面）
	 private double[] WQgoal; //控制断面 水质 目标浓度 mg/L ——modelSection
	
	/**
	 * 方案边界条件信息表—— modelBoundry
	 */
	 private  double[][]boundry; //一定要根据模型配置的上下游顺序，每一个边界存一个数组
		
	/**
	 * 水库调节信息表
	 */
	 private  double[][]outflow; //原计划
	 private  double[][]deltaflow; //加大量
	 
	
	public int getForeTime() {
		return foreTime;
	}
	public void setForeTime(int foreTime) {
		this.foreTime = foreTime;
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
	public int getDurTime() {
		return durTime;
	}
	public void setDurTime(int durTime) {
		this.durTime = durTime;
	}
	public int getRCD() {
		return RCD;
	}
	public void setRCD(int rCD) {
		RCD = rCD;
	}
	public String getUPSEC() {
		return UPSEC;
	}
	public void setUPSEC(String uPSEC) {
		UPSEC = uPSEC;
	}
	public double getLEN_UP() {
		return LEN_UP;
	}
	public void setLEN_UP(double lEN_UP) {
		LEN_UP = lEN_UP;
	}
	public double getDA() {
		return DA;
	}
	public void setDA(double dA) {
		DA = dA;
	}
	public int getDA_TYPE() {
		return DA_TYPE;
	}
	public void setDA_TYPE(int dA_TYPE) {
		DA_TYPE = dA_TYPE;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getK() {
		return k;
	}
	public void setK(double k) {
		this.k = k;
	}
	public double[] getBG_Z() {
		return BG_Z;
	}
	public void setBG_Z(double[] bG_Z) {
		BG_Z = bG_Z;
	}
	public double[] getBG_CONC() {
		return BG_CONC;
	}
	public void setBG_CONC(double[] bG_CONC) {
		BG_CONC = bG_CONC;
	}
	public double[] getBG_Q() {
		return BG_Q;
	}
	public void setBG_Q(double[] bG_Q) {
		BG_Q = bG_Q;
	}
	public double[][] getBoundry() {
		return boundry;
	}
	public void setBoundry(double[][] boundry) {
		this.boundry = boundry;
	}
	public double[][] getOutflow() {
		return outflow;
	}
	public void setOutflow(double[][] outflow) {
		this.outflow = outflow;
	}
	public double[][] getDeltaflow() {
		return deltaflow;
	}
	public void setDeltaflow(double[][] deltaflow) {
		this.deltaflow = deltaflow;
	}
	public int getAccurTime() {
		return accurTime;
	}
	public void setAccurTime(int accurTime) {
		this.accurTime = accurTime;
	}
	public String getPRO_CD() {
		return PRO_CD;
	}
	public void setPRO_CD(String pRO_CD) {
		PRO_CD = pRO_CD;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getTM() {
		return TM;
	}
	public void setTM(Date tM) {
		TM = tM;
	}
	public double getDUR() {
		return DUR;
	}
	public void setDUR(double dUR) {
		DUR = dUR;
	}
	public double[] getWQgoal() {
		return WQgoal;
	}
	public void setWQgoal(double[] wQgoal) {
		WQgoal = wQgoal;
	}
	public double getBG_CO() {
		return BG_CO;
	}
	public void setBG_CO(double bG_CO) {
		BG_CO = bG_CO;
	}
	
}
