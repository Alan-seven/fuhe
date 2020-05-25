package com.jsite.szy.dispatch.emergency.model;

import com.jsite.szy.dispatch.emergency.mconfig.SearchCurve1;


/**
 * @author Dxl
 *  水库运行计算
 */

public class CalReservior {

	/**
	 * 根据INQ计算运行水位过程
	 * 
	 */
	
	public Reservior calLevelSerial(Reservior Res, double detaT) {
		double deltaH=0;
		double deltaW=0;
		int len = Res.getRealQin().length;
		double[] Qout = new double[len];
		double[] level = new double[len + 1];// 初水位
		level[0] = Res.getIniZ();
		
		double[] h1 = new double[len];
		double[] h2 = new double[len];
		double V0=0;
		double V1=0;
		SearchCurve1 curve = new SearchCurve1(Res.stateNM);
		
		// 原计划
		for (int i = 1; i <= len; i++) {
			// 流量约束
			Qout[i - 1] = Math.min(Res.getPlanQout()[i - 1], Res.getMaxQ());
			Qout[i - 1] = Math.max(Res.getPlanQout()[i - 1], Res.getMinQ());
			V0 = curve.getVfromZ(level[i - 1]);// 初库容
			V1 = V0 + (Res.getPlanQin()[i - 1] - Qout[i - 1]) * detaT * 3600 / 1000000;// 万立方米;
			level[i] = curve.getZfromV(V1);// 末水位
			
			h1[i - 1] = (level[i-1]+level[i])/2 -curve.getZDfromQ( Qout[i - 1]);//
			deltaH += h1[i - 1];
		}
		Res.setPlanLevel(level);		
		Res.setPlanQout(Qout);

		
		deltaW = curve.getVfromZ(level[len]);//原末库容

		// 加大下泄后
		double[] rQout = new double[len];
		for (int i = 1; i <= len; i++) {
			// 流量约束
			rQout[i - 1] = Math.min(Res.getRealQout()[i - 1], Res.getMaxQ());
			rQout[i - 1] = Math.max(Res.getRealQout()[i - 1], Res.getMinQ());
			V0 = curve.getVfromZ(level[i - 1]);// 初库容
			V1 = V0 + (Res.getPlanQin()[i - 1] - rQout[i - 1]) * detaT * 3600 / 1000000;// 万立方米;
			level[i] = curve.getZfromV(V1);// 末水位
			h2[i - 1] = (level[i-1]+level[i])/2 -curve.getZDfromQ(rQout[i - 1]);
			deltaH -= h2[i - 1];
		}

		Res.setRealLevel(level);
		Res.setRealQout(rQout);
		Res.setDeltaH(deltaH/len);
	
		deltaW = deltaW-curve.getVfromZ(level[len]);
		Res.setDeltaW(deltaW); // 库容的减小量
		
		return Res;

	}

	/*
	 * 计算末水位 detaT单位：小时; 库容：百万立方米——曲线读数据库设置
	 */
	/*public double calZfromQinQout(Reservior Res, double detaT, double Z0,
			double Qin, double Qout) {
		double V0, Z1, V1 = 0;
		V0 = SearchCurve1.getVfromZ(Res.getListZV(), Z0);// 初库容
		V1 = V0 + (Qin - Qout) * detaT * 3600 / 1000000;// 万立方米;
		Z1 = SearchCurve1.getZfromV(Res.getListZV(), V1);// 末水位
		return Z1;

	} */
	
	/*
	 * 计算末水位 detaT单位：小时; 库容：百万立方米——曲线读excel
	 */
/*	public double calZfromQinQout(Reservior Res, double detaT, double Z0,
			double Qin, double Qout) {
		double V0, Z1, V1 = 0;
		V0 = SearchCurve1.getVfromZ(Res.stateNM, Res.getStateCD(),Z0);// 初库容
		V1 = V0 + (Qin - Qout) * detaT * 3600 / 1000000;// 万立方米;
		Z1 = SearchCurve1.getZfromV(Res.stateNM, Res.getStateCD(), V1);// 末水位
		return Z1;

	}*/
	
	/**
	 * 根据Z和OTQ计算运行INQ过程  
	 * 用于江口水库  上边界为水库水位
	 * 
	 */
	
	public Reservior calINQSerial(Reservior Res, double detaT) {
		double deltaH=0;
		double deltaW=0;
		int len = Res.getPlanLevel().length;
		double[] Qin = new double[len];//未知
		double[] Qout = new double[len];//--已知
		double[] level = Res.getPlanLevel();// 末水位-往后一时刻读(已知)
		
	
		SearchCurve1 curve = new SearchCurve1(Res.stateNM);
		
		double inZ = Res.getIniZ();
		double V0 = curve.getVfromZ(inZ);//初始库容
		double[] V1 = new double[len];		
		
		double[] h1 = new double[len];
		double[] h2 = new double[len];
		
		
		
		// 原计划
		for (int i = 0; i < len; i++) {
			// 流量约束
			Qout[i] = Math.min(Res.getPlanQout()[i], Res.getMaxQ());
			Qout[i] = Math.max(Res.getPlanQout()[i], Res.getMinQ());
			V1[i]= curve.getVfromZ(level[i]);
			if(i==0){
				Qin[i]=Qout[i]+(V1[i]-V0)/(detaT * 3600 / 1000000);
				h1[i] = (inZ+level[i])/2 -curve.getZDfromQ( Qout[i]);//
			}
			else{
				Qin[i]=Qout[i]+(V1[i]-V1[i-1])/(detaT * 3600 / 1000000);
				h1[i] = (level[i-1]+level[i])/2 -curve.getZDfromQ( Qout[i]);//
			}

			deltaH += h1[i];
		}
		//Res.setPlanLevel(level);	//计划水位 给定了	
		Res.setPlanQout(Qout);
		Res.setPlanQin(Qin); 

		
		deltaW = curve.getVfromZ(level[len-1]);//原末库容

		// 加大下泄后--入库不变
		double[] rQout = new double[len];
		double[] rLevel = new double[len];;
		for (int i = 0; i <len; i++) {
			// 流量约束
			rQout[i] = Math.min(Res.getRealQout()[i], Res.getMaxQ());
			rQout[i] = Math.max(Res.getRealQout()[i], Res.getMinQ());
			if(i==0){
				V1[i]= V0+(Qin[i]-rQout[i])*detaT * 3600 / 1000000;
				rLevel[i]= curve.getZfromV(V1[i]);// 末水位
				h2[i] = (inZ+rLevel[i])/2 -curve.getZDfromQ(rQout[i]);//
			}
			else{
				V1[i]= V1[i-1]+(Qin[i]-rQout[i])*detaT * 3600 / 1000000;
				rLevel[i]= curve.getZfromV(V1[i]);// 末水位
				h2[i] = (rLevel[i-1]+rLevel[i])/2 -curve.getZDfromQ(Qout[i]);//
			}
			deltaH -= h2[i];
		}

		Res.setRealLevel(rLevel);
		Res.setRealQout(rQout);
		Res.setRealQin(Qin);
		Res.setDeltaH(deltaH/len);
	
		deltaW = deltaW-curve.getVfromZ(rLevel[len-1]);
		Res.setDeltaW(deltaW); // 库容的减小量
		
		return Res;

	}
}
