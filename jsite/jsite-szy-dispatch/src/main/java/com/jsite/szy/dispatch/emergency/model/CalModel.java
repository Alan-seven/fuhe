package com.jsite.szy.dispatch.emergency.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jsite.core.config.Global;
import com.jsite.szy.dispatch.emergency.mconfig.congfigModel;
import com.jsite.szy.dispatch.emergency.mconfig.modelResvior;
import com.jsite.szy.dispatch.emergency.mconfig.modelSection;
import com.jsite.szy.dispatch.emergency.vo.DdsEdEventVO;

public class CalModel {
    
	String path=Global.getConfig("edmodel");
	/**
	 * 模型计算统一入口:方案信息、污染源信息、初始条件、边界条件（水库，测站）、水库下泄;水库基本参数;断面基本参数(初始条件) 
	 * @throws IOException 
	 */
	public ModelResult  startModel( ModelCon conditions,Reservior[] reserviors,ControlState states[]) throws InterruptedException, IOException{
		//模型计算
		Date d1= new Date();
		
		int riverCode = conditions.getRCD();
		reserviors=setReservior(riverCode,reserviors);
		states = setStates(riverCode,states);
		
		// 计算结果类
		ModelResult mResult = new ModelResult();
		//System.out.println(states.length);
		ControlState[] realState= new ControlState[states.length];
		//realState=states.clone();
		for (int i = 0; i < states.length; i++) {
			realState[i] = new ControlState();
		}
		
		// 初始化exe输入、计算类
		ExeInput exeinput = new ExeInput();
		ExeControl myExeControl=new ExeControl();
		myExeControl.setInformation("正在初始化......");
		myExeControl.setHn(1);//1:3600s,2:1800s,3:600s-输出时间步长 20171125增加
		
		myExeControl.set_path(path);//设置路径
		myExeControl.setUserId(conditions.getPRO_CD(), mResult);
		
		if((riverCode==2)||(riverCode==4)||(riverCode==6)){
			myExeControl.setCount(2); // 输出计算进度用 有水库调用2次水动力
		}
		else{
			myExeControl.setCount(1); 
		}
		CalReservior calreservior=new CalReservior();
		
        // conditions的初水位、边界
		double[] BG_Z= conditions.getBG_Z();
		double [][] myboundary = conditions.getBoundry();//水库、支流边界、下边界
		int boundN = myboundary.length;
		// conditions的水库下泄(水库调度用)
		double [][] outflow = conditions.getOutflow();//原计划： 水库 0、水库1
		double [][] deltaflow = conditions.getDeltaflow();//加大量
		double [][] realflow =null;
		if(reserviors!=null){
			realflow = new double[reserviors.length][outflow[0].length];//调整后下泄：水库 0、水库1
		}
				
		//将conditions的方案信息(时间)、污染源信息    //比如有3个点源，前两个没有污染物，那么这个数组 前两列就是空值？ 点源个数设1，点源编号设3，只放一列数
	    int deltat=conditions.getDeltaT();
	    int fTime = conditions.getForeTime();
	    int allTime = conditions.getLength()+conditions.getForeTime();//总刻数
	    int accurTime = conditions.getAccurTime()+conditions.getForeTime();//污染发生时刻
	    int po_endTime = accurTime+conditions.getDurTime();//污染结束时刻
		//界面设置——基本信息
	    
		exeinput.setStates(states);// 输入时记得初始化**
		exeinput.setRiverCode(riverCode);//计算河段 4
		exeinput.setDeltaT(deltat); 
		exeinput.setLength(allTime);//计算时间(跨度)+1h--如38+1
		exeinput.settnum(allTime+1);//时序点数 如39——时刻
		double mytlength[]=new double[allTime+1];
		for (int i = 0; i < mytlength.length; i++) {
			mytlength[i]=i*3600*deltat;
		}
		exeinput.settlength(mytlength);//距离起始时间时刻点,单位s
		//界面设置——模型参数
		exeinput.setR(conditions.getR());//糙率 0.033
		if(riverCode==5) exeinput.setR(0.33);//河段5芦溪，时间步长设置100s才好，但是太慢，暂时这样
		exeinput.setSolvendkinds(1);//代码搞成可以算多种溶质的了
		double[] a=new double[1];
		double[] k=new double[1];
		// 界面的单位：  a扩散系数-cm2/s; k衰减系数-比例/天 
		a[0]=conditions.getA()/10000;
		k[0]=conditions.getK()/(24*3600);
		exeinput.setA(a);//扩散系数m2/s  0
		exeinput.setK(k);//降解系数/s  0.00000001
	
		
		/*
		RCD	Btype	Bname	Vtype	STCD	STNM
		1	干流上边界	沙子岭	流量	62405200	沙子岭
		1	干流下边界	南城	          水位	62405800	南城
		2	水库上边界	洪门入库	流量	62403400	洪门
		2	干流下边界	南城	          水位	62405800	南城

		4	水库上边界	廖坊入库	流量	62401300	廖坊
		4	支流入流	临水	          流量	62406600	娄家村（二）
		4	支流入流	东乡河	流量	62408600	马圩
		4	干流下边界	李家渡	水位	62402400	李家渡
		5	干流上边界	芦溪	          流量	62310700	芦溪
		5	干流下边界	彬江	          水位	62310920	彬江
		6	水库上边界	江口水库	流量	62311050	江口
		6	干流下边界	临江	          水位	62338750	(庙前)临江
	*/
				
		 /**
	     * 6个河段——设置支流、点源
	     */
		// 支流点源、污染源点源
		int[] trnum={0,0,0,2,0,0};//分别是rcd为1、2、3、4、5、6的支流边界个数
		int pnum = trnum[riverCode-1]+1;//点源个数 = 支流边界数+1
		String mypriver[]= new String[pnum];//点源所在河流-默认
		for (int i = 0; i < pnum; i++) {
			mypriver[i]="1";
		}
		
		exeinput.setpnum(pnum);
		exeinput.setpriver(mypriver);
		int[]solvendn={1};
		exeinput.setsolvendn(solvendn);//浓度入流点数
		String mysolvendq[][]=new String[1][1];
		mysolvendq[0][0]= Integer.toString(pnum);//最后一个点源是污染源
		exeinput.setsolvendq(mysolvendq);//浓度入流在点源上的编号,如第“3”个
		double myplength[] =new double[pnum];//点源里程
		double mypointQ[][]= new double[pnum][allTime+1];// 点源时序流量
		for (int i = 0; i < (allTime+1); i++) {
			mypointQ[pnum-1][i]=0.01;//假设一个很小的污染源的流量，其他点源流量在河段中具体设置
		}
		// 设置 支流起点距、污染源起点距，支流边界流量
		switch (riverCode) {
		case 4: // 1个水库、2个支流   myboundary有4组
			myplength[0] = 53.16;//廖坊坝-临水汇入点
			myplength[1] = 63.09;//廖坊坝-东乡河汇入点
			myplength[2] = conditions.getLEN_UP();
			mypointQ[0]= myboundary[1];
			mypointQ[1]= myboundary[2];
			break;
		default: // 河段1、2、3、5、6 有0个支流
			myplength[0] = conditions.getLEN_UP();
			break;
	    }
		exeinput.setplength(myplength);
		
	
		double mysolvendtimesity[][][]= new double[1][1][allTime+1];
		double avgC = conditions.getDA()*1000/(0.01*3600*conditions.getDurTime()*deltat);
		for (int i = 0; i < (allTime+1); i++) {
			if(i<accurTime) mysolvendtimesity[0][0][i]=0;//污染发生前浓度为0
			else if (i>=po_endTime) mysolvendtimesity[0][0][i]=0;
			else mysolvendtimesity[0][0][i]=avgC;//污染总量kg，持续时间h，流量0.01m³/s 计算浓度：mg/L(=g/m³)
		}
		
		exeinput.setsolvendtimesity(mysolvendtimesity);//浓度入流时序
		exeinput.setpointQ(mypointQ);//---要加支流的
	
		exeinput.setStagedischarge(false);//false下边界给定时序，true下边界给定水位流量关系曲线
		exeinput.setlowboundary(myboundary[boundN-1]);//下边界水位时序m		
		double[] BG_CO=new double[1];
		BG_CO[0]=conditions.getBG_CO();
		//控制性测站-初始流量、水位、浓度
		for (int i = 0; i < states.length; i++) {
			//exeinput.getStates()[i].setInitialCon(BG_CO);
			exeinput.getStates()[i].setInitialQ(myboundary[0][0]);
		}
		exeinput.getStates()[0].setInitialCon(BG_CO);// mg/L
		exeinput.getStates()[states.length-1].setInitialCon(BG_CO);
		
		/**
	     * 6个河段——水库调度(2和4有入库流量，6是给定水库末水位)
	     */
		if(riverCode==6){
		   //  江口
			reserviors[0].setIniZ(BG_Z[0]);//
			reserviors[0].setPlanLevel(myboundary[0]);//水位
			reserviors[0].setPlanQout(outflow[0]);

			for (int i = 0; i < deltaflow[0].length; i++) {
				realflow[0][i] = outflow[0][i] + deltaflow[0][i];
			}
			reserviors[0].setRealQout(realflow[0]);
			myExeControl.setInformation("水库调度计算......");
			reserviors[0] = calreservior.calINQSerial(reserviors[0], 1);// 计算原计划入库流量、调整后水位，并校验下泄流量
			myExeControl.setInformation("水库调度计算完成！");
			
			/* 2、计算水动力水质 */
			// 计划流量下水动力
			exeinput.setupboundary(reserviors[0].getPlanQout());//上边界流量时序 -江口出库
			myExeControl.RunExe(1,states.length,exeinput,mResult);//水利学计算程序运行 
			myExeControl.setOutControlState(states,exeinput,mResult);//断面值输出 exeinput.length 计算总时长
			// 加大流量下水动力
			exeinput.setupboundary(reserviors[0].getRealQout());//上边界流量时序 -江口出库
			myExeControl.RunExe(1,states.length,exeinput,mResult);
			myExeControl.setOutControlState(realState,exeinput,mResult);//断面值输出 
		}
		else if((riverCode==2)||(riverCode==4)){
			/* 1、计算水库调度 */
			// 洪门、廖坊
			reserviors[0].setIniZ(BG_Z[0]);//90.5
			reserviors[0].setPlanQin(myboundary[0]);//入库流量
			reserviors[0].setPlanQout(outflow[0]);
			reserviors[0].setRealQin(myboundary[0]);
			for (int i = 0; i < deltaflow[0].length; i++) {
				realflow[0][i] = outflow[0][i] + deltaflow[0][i];
			}
			reserviors[0].setRealQout(realflow[0]);
			myExeControl.setInformation("水库调度计算......");
			reserviors[0] = calreservior.calLevelSerial(reserviors[0], 1);// 计算原计划、调整后水位，并校验下泄流量
			myExeControl.setInformation("水库调度计算完成！");
			
			/* 2、计算水动力水质 */
			// 计划流量下水动力
			exeinput.setupboundary(reserviors[0].getPlanQout());//上边界流量时序 -廖坊出库
			myExeControl.RunExe(1,states.length,exeinput,mResult);//水利学计算程序运行 1-37
			myExeControl.setOutControlState(states,exeinput,mResult);//断面值输出 exeinput.length 计算总时长
			// 加大流量下水动力
			exeinput.setupboundary(reserviors[0].getRealQout());//上边界流量时序 -廖坊出库
			myExeControl.RunExe(1,states.length,exeinput,mResult);
			myExeControl.setOutControlState(realState,exeinput,mResult);//断面值输出 

		}
		else{// 其他 1和5 无水库
			//断面初始流量、水位、浓度。
			
			for(int i=0;i<states.length;i++) {
				//exeinput.getStates()[i].setInitialLevel(initialLevel[i]);		
				//exeinput.getStates()[i].setInitialQ(0);
			}
			
			// 计划流量下水动力
		    exeinput.setupboundary(myboundary[0]);//上边界流量时序 -廖坊出库
		    myExeControl.RunExe(1,states.length,exeinput,mResult);//水利学计算程序运行 1-37
		    myExeControl.setOutControlState(states,exeinput,mResult);//断面值输出 exeinput.length 计算总时长
        }
		//myExeControl.setInformation("正在解析计算结果......");
		
		
	    /**
	     * 结果存到ModelResult：
	     *  2、4、6有原计划、加大对比；其他 无加大下泄后的结果
	     */
		//Value的分级
		double pMax=0;
		double pMin=1000;
		
		if((riverCode==2)||(riverCode==6)||(riverCode==4)){
		// 结果处理：除去序列的预热期 set时间序列，再if判断断面类型-计算控制断面影响时段，然后addlist
		List<ControlState> listALL= new ArrayList<ControlState>();
        List<ControlState> listSEC=new ArrayList<ControlState>();
		List<GISData> listGIS=new ArrayList<GISData>();
		double[] pQ = new double[conditions.getLength()+1];
		double[] pZ = new double[conditions.getLength()+1];
		double[] pC = new double[conditions.getLength()+1];
		double[] rQ = new double[conditions.getLength()+1];
		double[] rZ = new double[conditions.getLength()+1];
		double[] rC = new double[conditions.getLength()+1];
		
		double[] WQgoal = conditions.getWQgoal();
		int consecN=0; // 控制断面计数
		String Sttp=null;
		double[] concentration = null;// 原计算污染物浓度     单位：毫克每升——states
		double[] realconcen = null;// 调整下泄后污染物浓度     单位：毫克每升——realState
		int infuenceTime; // 水质大于目标值的时间
		int realinfTime; // 水质大于目标值的时间
		for (int i = 0; i < states.length; i++) {
			// 去掉预热期的计算结果
			for(int j=0;j<pQ.length;j++){
				
				pQ[j] = states[i].getOutFlow()[fTime+j-1] ; // exe 输出不包括第一个点
				pZ[j] = states[i].getLevel()[fTime+j-1];
				pC[j] = states[i].getConcentration()[fTime+j-1];
				rQ[j] = realState[i].getOutFlow()[fTime+j-1]; //调整下泄后，模型计算时结果存在这些变量里了
				rZ[j] = realState[i].getLevel()[fTime+j-1];
				rC[j]= realState[i].getConcentration()[fTime+j-1];
			}
			states[i].setOutFlow(pQ);
			states[i].setLevel(pZ);
			states[i].setConcentration(pC);
			states[i].setRealFlow(rQ);
			states[i].setRealLevel(rZ);
			states[i].setRealconcen(rC);
			
			// 统计控制断面 受影响时间
			infuenceTime=0; 
			realinfTime=0; 
			Sttp = states[i].getStateType();
			if ((Sttp.equals("取水口") || Sttp.equals("测站"))&&(consecN < WQgoal.length)) {
				states[i].setControlValue(WQgoal[consecN]);// 水质目标
				concentration = states[i].getConcentration();
				realconcen = states[i].getRealconcen();
				for (int j = 0; j < concentration.length; j++) {
					if (concentration[j] > WQgoal[consecN])
						infuenceTime++;
					if (realconcen[j] > WQgoal[consecN])
						realinfTime++;
				}
				states[i].setInfuenceTime(infuenceTime);
				states[i].setRealinfTime(realinfTime);
				listSEC.add(states[i]);
				consecN++;
			}
			listALL.add(states[i]);
			
			
		}
		// 处理gis数据（不一定要）
		// 前面存时间序列，前台要求出planValue和realValue的max、min，用来做色彩分级
		 double planValue;
		 double realValue;
		 int fid;
		 GISData gisdata=null;
		 for (int t = 0; t < (conditions.getLength()+1); t++) {
			 //System.out.println("t="+t);
			for (int i = 0; i < states.length; i++) {
				gisdata = new GISData();
				planValue=states[i].getConcentration()[t];
				realValue=states[i].getRealconcen()[t];
				fid=states[i].getFID();
				//if((planValue>0||realValue>0)&&(fid>=0)){
				if(fid>=0){
					gisdata.setTime(Integer.toString(t*deltat));// t时刻，第t*deltat小时
					gisdata.setFid(fid);
					gisdata.setPlanValue(planValue);
					gisdata.setRealValue(realValue);
					listGIS.add(gisdata);
					// 顺便 保存 最大 最小值
					pMax=Math.max(pMax, planValue);
					pMax=Math.max(pMax, realValue);
					pMin=Math.min(pMin, planValue);
					pMin=Math.min(pMin, realValue);
					//System.out.println(planValue);
				}
		   }	
		 }
		 GISLegend legend =new GISLegend();
		 legend.setMax(pMax);
		 legend.setMin(pMin);
		 
		 double pd=(pMax-pMin)/5.0;
		 double pv=0;
		 double rv=0;
		 for (int i = 0; i < listGIS.size(); i++) {
			 pv=listGIS.get(i).getPlanValue();
			 if(pv<=0) listGIS.get(i).setpColor(0);
			 else if(pv<(pMin+pd)) listGIS.get(i).setpColor(1);
			 else if(pv<(pMin+2*pd)) listGIS.get(i).setpColor(2);
			 else if(pv<(pMin+3*pd)) listGIS.get(i).setpColor(3);
			 else if(pv<(pMin+4*pd)) listGIS.get(i).setpColor(4);
			 else listGIS.get(i).setpColor(5);
			 
			 rv=listGIS.get(i).getPlanValue();
			 if(rv<=0) listGIS.get(i).setpColor(0);
			 else if(rv<(pMin+pd)) listGIS.get(i).setpColor(1);
			 else if(rv<(pMin+2*pd)) listGIS.get(i).setrColor(2);
			 else if(rv<(pMin+3*pd)) listGIS.get(i).setrColor(3);
			 else if(rv<(pMin+4*pd)) listGIS.get(i).setrColor(4);
			 else listGIS.get(i).setrColor(5);
		 }
		 
		// 方案评价指标： 按加大下泄后统计
		int intakeNUM=0; //受影响取水口（个）
		double interTM=0; //最大中断时长（h）
		double deltaWA=0; //应急耗水量（万m³）-几个水库耗水总量
		double deltaHA=0; //水头损失（m）-几个水库平均水头损失
		for (int i = 0; i < listSEC.size(); i++) {
			Sttp = listSEC.get(i).getStateType();
			realinfTime = listSEC.get(i).getRealinfTime();
			if (Sttp.equals("取水口")&&(realinfTime>0)){
				intakeNUM++;
				if(realinfTime>interTM){
					
					interTM =realinfTime;
				}
			}
		}
		for (int i = 0; i < reserviors.length; i++) {
			deltaWA = deltaWA + reserviors[i].getDeltaW();
			deltaHA = deltaHA + reserviors[i].getDeltaH();
		} 
		deltaHA=deltaHA/reserviors.length;
		
		mResult.setInformation(myExeControl.getInformation());
		mResult.setReserviors(reserviors); 
		mResult.setListALL(listALL);
		mResult.setListSEC(listSEC);
		mResult.setListGIS(listGIS);
		mResult.setLegend(legend);
		mResult.setIntakeNUM(intakeNUM);//受影响取水口（个）
		mResult.setInterTM(interTM);//最大中断时长（h）
		mResult.setDeltaWA(deltaWA);//应急耗水量（万m³）
		mResult.setDeltaHA(deltaHA); //水头损失（m）
		
		}
		else{  // 没有和水库相关的量 riverCode==1和5

			// 结果处理：除去序列的预热期 set时间序列，再if判断断面类型-计算控制断面影响时段，然后addlist
			List<ControlState> listALL= new ArrayList<ControlState>();
	        List<ControlState> listSEC=new ArrayList<ControlState>();
			List<GISData> listGIS=new ArrayList<GISData>();
			double[] pQ = new double[conditions.getLength()+1];
			double[] pZ = new double[conditions.getLength()+1];
			double[] pC = new double[conditions.getLength()+1];
						
			double[] WQgoal = conditions.getWQgoal();
			int consecN=0; // 控制断面计数
			String Sttp=null;
			double[] concentration = null;// 原计算污染物浓度     单位：毫克每升——states
			int infuenceTime; // 水质大于目标值的时间
			for (int i = 0; i < states.length; i++) {
				// 去掉预热期的计算结果
				for(int j=0;j<pQ.length;j++){
					
					pQ[j] = states[i].getOutFlow()[fTime+j-1] ; // exe 输出不包括第一个点
					pZ[j] = states[i].getLevel()[fTime+j-1];
					pC[j] = states[i].getConcentration()[fTime+j-1];
				}
				states[i].setOutFlow(pQ);
				states[i].setLevel(pZ);
				states[i].setConcentration(pC);
				
				// 统计控制断面 受影响时间
				infuenceTime=0; 
				Sttp = states[i].getStateType();
				if ((Sttp.equals("取水口") || Sttp.equals("测站"))&&(consecN < WQgoal.length)) {
					states[i].setControlValue(WQgoal[consecN]);// 水质目标
					concentration = states[i].getConcentration();
					for (int j = 0; j < concentration.length; j++) {
						if (concentration[j] > WQgoal[consecN])
							infuenceTime++;
						
					}
					states[i].setInfuenceTime(infuenceTime);
					listSEC.add(states[i]);
					consecN++;
				}
				listALL.add(states[i]);
				
				
			}
			
			// 处理gis数据（不一定要）
			// 前面存时间序列，前台要求出planValue和realValue的max、min，用来做色彩分级
			 double planValue;
			 int fid;
			 GISData gisdata=null;
			 for (int t = 0; t < (conditions.getLength()+1); t++) {
				for (int i = 0; i < states.length; i++) {
					gisdata = new GISData();
					planValue=states[i].getConcentration()[t];
					fid=states[i].getFID();
					//if((planValue>0)&&(fid>=0)){
					if(fid>=0){
						gisdata.setTime(Integer.toString(t*deltat));// t时刻，第t*deltat小时
						gisdata.setFid(fid);
						gisdata.setPlanValue(planValue);
						listGIS.add(gisdata);
						// 顺便 保存 最大 最小值
						pMax=Math.max(pMax, planValue);
						pMin=Math.min(pMin, planValue);
					}
			   }	
			 }
			 GISLegend legend =new GISLegend();
			 legend.setMax(pMax);
			 legend.setMin(pMin);

			 // 颜色赋值

			 double pd=(pMax-pMin)/5.0;
			 double pv=0;
			 for (int i = 0; i < listGIS.size(); i++) {
				 pv=listGIS.get(i).getPlanValue();
				 if(pv<=0) listGIS.get(i).setpColor(0);
				 else if(pv<(pMin+pd)) listGIS.get(i).setpColor(1);
				 else if(pv<(pMin+2*pd)) listGIS.get(i).setpColor(2);
				 else if(pv<(pMin+3*pd)) listGIS.get(i).setpColor(3);
				 else if(pv<(pMin+4*pd)) listGIS.get(i).setpColor(4);
				 else listGIS.get(i).setpColor(5);
				 
			 }
			
			// 方案评价指标：
			int intakeNUM=0; //受影响取水口（个）
			double interTM=0; //最大中断时长（h）
			for (int i = 0; i < listSEC.size(); i++) {
				Sttp = listSEC.get(i).getStateType();
				infuenceTime = listSEC.get(i).getInfuenceTime();
				if (Sttp.equals("取水口")&&(infuenceTime>0)){
					intakeNUM++;
					if(infuenceTime>interTM){
						
						interTM =infuenceTime;
					}
				}
			}
			
			mResult.setInformation(myExeControl.getInformation());
			mResult.setReserviors(reserviors); 
			mResult.setListALL(listALL);
			mResult.setListSEC(listSEC);
			mResult.setListGIS(listGIS);
			mResult.setLegend(legend);
			mResult.setIntakeNUM(intakeNUM);
			mResult.setInterTM(interTM);
		}
		//myExeControl.setInformation("计算结果解析完成!");
		Date d2= new Date();
		long diff2 = (d2.getTime() - d1.getTime());
		System.out.println("返回计算结果："+diff2+"ms");
		// 2017.12.14加  结果都算完了以后 清除in和out的文件夹
		delResoultDir(path+conditions.getPRO_CD());
					
		return mResult;

	}
	
	/**
	 * 根据RCD设置参与水库、河道断面、控制断面的参数
	 */
	public ControlState[]  setStates(int RCD,ControlState states[]){
		
		List<modelSection> list=congfigModel.getmodelSection(RCD+"");
		int n=0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getFid()<0){
				n++;
			}
			else{
				continue;
			}	
		}
		states = new ControlState[list.size()-n];
		int m=0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getFid()>=0){
				states[m] = new ControlState();
				states[m].setStateType(list.get(i).getType());
				states[m].setStateID(list.get(i).getSecID());
				states[m].setStateName(list.get(i).getName());
				states[m].setFID(list.get(i).getFid());
				states[m].setQtype("0");//原计划
				m++;
			}
			
		}
		return states; 
		
	}
	
	public Reservior[] setReservior(int RCD,Reservior[] reserviors){
		//List<modelResvior> lr=congfigModel.getmodelResvior(RCD+"");
		//reserviors=new Reservior[lr.size()];
		switch (RCD) { 
		case 1://砂子岭-南城
			reserviors=null;
			break;
		case 2://洪门-南城
			reserviors=new Reservior[1];
			reserviors[0]=new Reservior("洪门水库");  
			break; 
		case 3:
			break;
		case 4://廖坊-李家渡
			reserviors=new Reservior[1];
			reserviors[0]=new Reservior("廖坊水库"); 
			break;
		case 5:
			break;
		case 6://江口-临江
			reserviors=new Reservior[1];
			reserviors[0]=new Reservior("江口水库");  
			break;
		default:
			break;
		}
		
		
		return reserviors; 
		
	}
	public static boolean delResoultDir(String path) throws IOException {
		File file = new File(path);
		
		if (file.isDirectory()) {
			String cmd = "cmd /c rd /s/q " + path.replace("/", "\\");
			Runtime.getRuntime().exec(cmd);
			System.out.println("delete");
			return true;
		}
		return false;
	}
}