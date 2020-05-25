package com.jsite.szy.dispatch.emergency.model;

import java.util.List;

import com.jsite.busi.szy.info.po.DdsBRes;

/**
 * @author Dxl
 *
 * 水库基本参数、特征曲线，入库出库流量
 */
public class Reservior {
	String stateCD;
	String stateNM;
	private double iniZ;//初始水位 --界面设置
	
	// 约束条件 --读数据库初始化，用户可以改
	private double k;//出力系数
	private double maxZ;// 正常蓄水位  单位：米
	private double minZ;// 死水位  单位：米
	private double maxQ;// 最大下泄  单位：米
	private double minQ;// 死水位  单位：米
	private double maxN;// 装机容量  单位：万kw
	private double minN;// 保证出力  单位：万kw
	private double maxH;// 水头
	private double minH;// 
	
	private String zvcurveId; // 水位库容曲线id
	private String ftcurveId; // 下泄尾水曲线id
	
	private List<DdsBRes> listZV;// 水位-库容曲线
	private List<DdsBRes> listZdQ;// 尾水位-下泄流量关系
	
	private double q[];//区间来水 （如，对廖坊来水，要加上南城的流量）
	
	private double planQin[];//计划入库
	private double planQout[];//计划出库
	private double planLevel[];//计划水位——由入库出库计算得来
	
	private double deltaQout[];//调整增加、减小出库
	
	private double realQin[];//调整后入库
	private double realQout[];//调整后出库
	private double realLevel[];//计划水位——由入库出库计算得来
	
	// 要加 平均水头损失、应急耗水量，方案评价要用
	private double deltaH;
	private double deltaW;
	
	// 构造函数这里初始化 后期改成读数据库
	Reservior(String stateName){
		if (stateName.equals("洪门水库")){
			// 运行规则：年末94m，汛前至92m为宜
			stateCD="62403400";//
			stateNM=stateName;
			zvcurveId ="02zv01";
			ftcurveId ="02zq01";
			
			k=8.5;//2006年平水年， 2011枯水年8.7
			maxZ=100;
			minZ=92;
			maxQ=8500;//河道安全泄量  8500m3/s
			minQ=0;
			maxN=4.2;
			minN=0.8;
			maxH=27.5;//27.50m   26.00m  19.50m
			minH=19.5;

		}
		
        if (stateName.equals("廖坊水库")){
        	stateCD="62401300";//
        	stateNM=stateName;
        	zvcurveId ="02zv02";
			ftcurveId ="02zq02";
    
        	stateNM=stateName;
        	k=8.5;//未定
			maxZ=65;//正蓄65
			minZ=61;
			maxQ=7130;//河道安全泄量  7130m3/s
			minQ=0;
			maxN=4.95;//16500×3KW
			minN=0.712;		
			maxH=14.6;//14.46m、10.10m、6.60m
			minH=6.6;
		}
        
		 if (stateName.equals("江口水库")){
	        	stateCD="62311050";//
	        	stateNM=stateName;
	        	zvcurveId ="03zv01";
				ftcurveId ="03zq01";// 无
	        	stateNM=stateName;
	        	k=8.5;//未定
				maxZ=72;//正蓄72
				minZ=65;
				maxQ=3940;// 最大泄流能力
				minQ=0;
				maxN=3.52;//16500×3KW
				minN=1.35;		
				maxH=21.2;//设计21.2，近期18.7
				minH=12;//设计14.7，近期12
			}
		
	}

	

	public String getStateCD() {
		return stateCD;
	}



	public void setStateCD(String stateCD) {
		this.stateCD = stateCD;
	}



	
	public String getStateNM() {
		return stateNM;
	}



	public void setStateNM(String stateNM) {
		this.stateNM = stateNM;
	}



	public double[] getPlanQin() {
		return planQin;
	}



	public void setPlanQin(double[] planQin) {
		//this.planQin = planQin;
		this.planQin = new double[planQin.length];
		for (int i = 0; i < planQin.length; i++) {
			this.planQin[i]=planQin[i];// 2位小数
		}
	}



	public double[] getPlanQout() {
		return planQout;
	}



	public void setPlanQout(double[] planQout) {
		//this.planQout = planQout;
		//this.planQin = planQin;
		this.planQout = new double[planQout.length];
		for (int i = 0; i < planQout.length; i++) {
			this.planQout[i]=planQout[i];// 2位小数
		}
	}



	public double getIniZ() {
		return iniZ;
	}

	public void setIniZ(double iniZ) {
		this.iniZ = iniZ;
	}

	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
	}

	public double getMaxZ() {
		return maxZ;
	}

	public void setMaxZ(double maxZ) {
		this.maxZ = maxZ;
	}

	public double getMinZ() {
		return minZ;
	}

	public void setMinZ(double minZ) {
		this.minZ = minZ;
	}

	public double getMaxQ() {
		return maxQ;
	}

	public void setMaxQ(double maxQ) {
		this.maxQ = maxQ;
	}

	public double getMinQ() {
		return minQ;
	}

	public void setMinQ(double minQ) {
		this.minQ = minQ;
	}

	public double getMaxN() {
		return maxN;
	}

	public void setMaxN(double maxN) {
		this.maxN = maxN;
	}

	public double getMinN() {
		return minN;
	}

	public void setMinN(double minN) {
		this.minN = minN;
	}

	public double getMaxH() {
		return maxH;
	}

	public void setMaxH(double maxH) {
		this.maxH = maxH;
	}

	public double getMinH() {
		return minH;
	}

	public void setMinH(double minH) {
		this.minH = minH;
	}

	
	public String getZvcurveId() {
		return zvcurveId;
	}



	public void setZvcurveId(String zvcurveId) {
		this.zvcurveId = zvcurveId;
	}



	public String getFtcurveId() {
		return ftcurveId;
	}



	public void setFtcurveId(String ftcurveId) {
		this.ftcurveId = ftcurveId;
	}



	public double[] getQ() {
		return q;
	}



	public void setQ(double[] q) {
		this.q = q;
	}



	public double[] getRealQin() {
		return realQin;
	}



	public void setRealQin(double[] realQin) {
		this.realQin = new double[realQin.length];
		for (int i = 0; i < realQin.length; i++) {
			this.realQin[i]=realQin[i];// 2位小数
		}
	}



	public double[] getRealQout() {
		return realQout;
	}



	public void setRealQout(double[] realQout) {
		this.realQout = new double[realQout.length];
		for (int i = 0; i < realQout.length; i++) {
			this.realQout[i]=realQout[i];// 2位小数
		}
	}



	public List<DdsBRes> getListZV() {
		return listZV;
	}



	public void setListZV(List<DdsBRes> listZV) {
		this.listZV = listZV;
	}



	public List<DdsBRes> getListZdQ() {
		return listZdQ;
	}



	public void setListZdQ(List<DdsBRes> listZdQ) {
		this.listZdQ = listZdQ;
	}



	public double[] getDeltaQout() {
		return deltaQout;
	}



	public void setDeltaQout(double[] deltaQout) {
		this.deltaQout = deltaQout;
	}



	public double[] getPlanLevel() {
		return planLevel;
	}



	public void setPlanLevel(double[] planLevel) {
		this.planLevel = new double[planLevel.length];
		for (int i = 0; i < planLevel.length; i++) {
			this.planLevel[i]=(double)Math.round((planLevel[i])*100)/100;// 2位小数
		}
	}



	public double[] getRealLevel() {
		return realLevel;
	}



	public void setRealLevel(double[] realLevel) {
		//this.realLevel = realLevel;
		this.realLevel = new double[realLevel.length];
		for (int i = 0; i < realLevel.length; i++) {
			this.realLevel[i]=(double)Math.round((realLevel[i])*100)/100;// 2位小数
		}
	}

	public double getDeltaH() {
		return deltaH;
	}

	public void setDeltaH(double deltaH) {
		this.deltaH = deltaH;
	}

	public double getDeltaW() {
		return deltaW;
	}

	public void setDeltaW(double deltaW) {
		this.deltaW = deltaW;
	}
	
}

