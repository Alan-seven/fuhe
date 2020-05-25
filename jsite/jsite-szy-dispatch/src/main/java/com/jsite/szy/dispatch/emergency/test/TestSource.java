package com.jsite.szy.dispatch.emergency.test;

import java.text.DecimalFormat;
import java.util.Date;

import com.jsite.szy.dispatch.emergency.model.TraceSource;


public class TestSource {
	public static void main(String[] args) {
		
		//初始化
		TraceSource dea = new TraceSource();
		
		//条件设置
		
		//监测断面浓度序列（mg/L）,时间间隔300s
		dea.setTimelen(3600);//监测浓度时间间隔(s)
		double cc[]={2.5, 3.5, 4.5, 5.5, 6.0, 6.5};
		dea.setC(cc);//浓度序列设置
		
		dea.setXmax(94700);//监测断面距上边界断面距离(m)
		
		dea.setU(0.8);//平均流速(m/s)
		dea.setDx(6.4);//扩散系数(m2/min)
		dea.setK(0.001);//衰减系数(/min)
		
		
		//模型计算
		Date start= new Date();
		dea.dea();
		Date end= new Date();
		long diff = (end.getTime() - start.getTime())/1000;
		//结果输出
		double result[][];
		
		//显示两位小数
		DecimalFormat decimalFormat=new DecimalFormat("0.00");
		result=dea.getOutresult();
		System.out.println(
		"污染源距离监测断面距离区间(m):["+decimalFormat.format(result[0][0])+"-"+decimalFormat.format(result[0][1])+"]\t"
		+"污染持续时间区间(s):["+decimalFormat.format(result[1][0])+"-"+decimalFormat.format(result[1][1])+"]\t"
		+"污染物质量区间(kg):["+decimalFormat.format(result[2][0])+"-"+decimalFormat.format(result[2][1])+"]\n");
		
		System.out.println(
		"污染发生时 距离0时刻的时间(m):["+decimalFormat.format(dea.getStartTime())+"]\t"
		+"污染源距离监测断面距离区间(m):["+decimalFormat.format(dea.getDistance())+"]\t"
		+"污染持续时间区间(s):["+decimalFormat.format(dea.getLastTime())+"]\t"
		+"污染物质量区间(kg):["+decimalFormat.format(dea.getM())+"]\n");
		System.out.println(dea.getProgress());
	}
}
