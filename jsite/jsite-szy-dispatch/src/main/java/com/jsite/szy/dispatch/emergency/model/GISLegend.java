package com.jsite.szy.dispatch.emergency.model;

public class GISLegend {
	 // 求出planValue和realValue的综合的max、min，分5级,用来做色彩分级、图例用，
	
	/* // 组装listGIS的时候，我顺便给GISData颜色赋值了
	 double pd=(pMax-pMin)/5.0;
	 double pv=0;
	 for (int i = 0; i < listGIS.size(); i++) {
		 pv=listGIS.get(i).getPlanValue();
		 if(pv<(pMin+pd)) listGIS.get(i).setrColor(1);
		 else if(pv<(pMin+2*pd)) listGIS.get(i).setrColor(2);
		 else if(pv<(pMin+3*pd)) listGIS.get(i).setrColor(3);
		 else if(pv<(pMin+4*pd)) listGIS.get(i).setrColor(4);
		 else listGIS.get(i).setrColor(5);
	*/
	
	double Max;
	double Min;
	
	public double getMax() {
		return Max;
	}
	public void setMax(double pMax) {
		this.Max = pMax;
	}
	public double getMin() {
		return Min;
	}
	public void setMin(double pMin) {
		this.Min = pMin;
	}
	
}
