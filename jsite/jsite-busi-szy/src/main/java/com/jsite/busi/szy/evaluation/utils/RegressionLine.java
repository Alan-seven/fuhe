package com.jsite.busi.szy.evaluation.utils;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 胡周
 * 创建时间：2017-10-30 17:54
 */
public class RegressionLine {

	    /** sum of x */  
	    private double sumX;  
	  
	    /** sum of y */  
	    private double sumY;  
	  
	    /** sum of x*x */  
	    private double sumXX;  
	  
	    /** sum of x*y */  
	    private double sumXY;  
	  
	    /** sum of y*y */  
	    private double sumYY;  
	  
	    /** sum of yi-y */  
	    private double sumDeltaY;  
	  
	    /** sum of sumDeltaY^2 */  
	    private double sumDeltaY2;

		/** 误差 */
		private double sse;
	  
	    private double sst;  
	  
	    private double E;  
	  
	    private String[] xy;  
	  
	    private ArrayList listX;  
	  
	    private ArrayList listY;  
	  
	    private int XMin, XMax, YMin, YMax;  
	  
	    /** line coefficient a0 */  
	    private double a0;  
	  
	    /** line coefficient a1 */  
	    private double a1;  
	  
	    /** number of data points */  
	    private int pn;  
	  
	    /** true if coefficients valid */  
	    private boolean coefsValid;  
	  
	    /** 
	     * Constructor. 
	     */  
	    public RegressionLine() {  
	        XMax = 0;  
	        YMax = 0;  
	        pn = 0;  
	        xy = new String[2];  
	        listX = new ArrayList();  
	        listY = new ArrayList();  
	    }  
	  
	    /** 
	     * Constructor. 
	     *  
	     * @param data 
	     *            the array of data points 
	     */  
	    public RegressionLine(DataPoint data[]) {  
	        pn = 0;  
	        xy = new String[2];  
	        listX = new ArrayList();  
	        listY = new ArrayList();  
	        for (int i = 0; i < data.length; ++i) {  
	            addDataPoint(data[i]);  
	        }  
	    }  
	  
	    /** 
	     * Return the current number of data points. 
	     *  
	     * @return the count 
	     */  
	    public int getDataPointCount() {  
	        return pn;  
	    }  
	  
	    /** 
	     * Return the coefficient a0. 
	     *  
	     * @return the value of a0 
	     */  
	    public double getA0() {  
	        validateCoefficients();  
	        return a0;  
	    }  
	  
	    /** 
	     * Return the coefficient a1. 
	     *  
	     * @return the value of a1 
	     */  
	    public double getA1() {  
	        validateCoefficients();  
	        return a1;  
	    }  
	  
	    /** 
	     * Return the sum of the x values. 
	     *  
	     * @return the sum 
	     */  
	    public double getSumX() {  
	        return sumX;  
	    }  
	  
	    /** 
	     * Return the sum of the y values. 
	     *  
	     * @return the sum 
	     */  
	    public double getSumY() {  
	        return sumY;  
	    }  
	  
	    /** 
	     * Return the sum of the x*x values. 
	     *  
	     * @return the sum 
	     */  
	    public double getSumXX() {  
	        return sumXX;  
	    }  
	  
	    /** 
	     * Return the sum of the x*y values. 
	     *  
	     * @return the sum 
	     */  
	    public double getSumXY() {  
	        return sumXY;  
	    }  
	  
	    public double getSumYY() {  
	        return sumYY;  
	    }  
	  
	    public int getXMin() {  
	        return XMin;  
	    }  
	  
	    public int getXMax() {  
	        return XMax;  
	    }  
	  
	    public int getYMin() {  
	        return YMin;  
	    }  
	  
	    public int getYMax() {  
	        return YMax;  
	    }  
	  
	    /** 
	     * Add a new data point: Update the sums. 
	     *  
	     * @param dataPoint 
	     *            the new data point 
	     */  
	    public void addDataPoint(DataPoint dataPoint) {  
	        sumX += dataPoint.x;  
	        sumY += dataPoint.y;  
	        sumXX += dataPoint.x * dataPoint.x;  
	        sumXY += dataPoint.x * dataPoint.y;  
	        sumYY += dataPoint.y * dataPoint.y;  
	  
	        if (dataPoint.x > XMax) {  
	            XMax = (int) dataPoint.x;  
	        }  
	        if (dataPoint.y > YMax) {  
	            YMax = (int) dataPoint.y;  
	        }

			// 把每个点的具体坐标存入ArrayList中，备用
	  
	        xy[0] = (int) dataPoint.x + "";  
	        xy[1] = (int) dataPoint.y + "";  
	        if (dataPoint.x != 0 && dataPoint.y != 0) {  
	            System.out.print(xy[0] + ",");  
	            System.out.println(xy[1]);  
	  
	            try {  
	                // System.out.println("n:"+n);  
	                listX.add(pn, xy[0]);  
	                listY.add(pn, xy[1]);  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	  
	            /* 
	             * System.out.println("N:" + n); System.out.println("ArrayList 
	             * listX:"+ listX.get(n)); System.out.println("ArrayList listY:"+ 
	             * listY.get(n)); 
	             */  
	        }  
	        ++pn;  
	        coefsValid = false;  
	    }  
	  
	    /** 
	     * Return the value of the regression line function at x. (Implementation of 
	     * Evaluatable.) 
	     *  
	     * @param x 
	     *            the value of x 
	     * @return the value of the function at x 
	     */  
	    public double at(int x) {  
	        if (pn < 2)  
	            return Double.NaN;  
	  
	        validateCoefficients();  
	        return a0 + a1 * x;  
	    }  
	  
	    /** 
	     * Reset. 
	     */  
	    public void reset() {  
	        pn = 0;  
	        sumX = sumY = sumXX = sumXY = 0;  
	        coefsValid = false;  
	    }

		/**
		 * Validate the coefficients. 计算方程系数 y=ax+b 中的a
		 */
	    private void validateCoefficients() {  
	        if (coefsValid)  
	            return;  
	  
	        if (pn >= 2) {  
	            double xBar = (double) sumX / pn;  
	            double yBar = (double) sumY / pn;  
	  
	            a1 = (double) ((pn * sumXY - sumX * sumY) / (pn * sumXX - sumX  
	                    * sumX));  
	            a0 = (double) (yBar - a1 * xBar);  
	        } else {  
	            a0 = a1 = Double.NaN;  
	        }  
	  
	        coefsValid = true;  
	    }

		/**
		 * 返回误差
		 */
	    public double getR() {
			// 遍历这个list并计算分母
	        for (int i = 0; i < pn - 1; i++) {  
	            double Yi = (double) Integer.parseInt(listY.get(i).toString());  
	            double Y = at(Integer.parseInt(listX.get(i).toString()));  
	            double deltaY = Yi - Y;  
	            double deltaY2 = deltaY * deltaY;  
	            /* 
	             * System.out.println("Yi:" + Yi); System.out.println("Y:" + Y); 
	             * System.out.println("deltaY:" + deltaY); 
	             * System.out.println("deltaY2:" + deltaY2); 
	             */  
	  
	            sumDeltaY2 += deltaY2;  
	            // System.out.println("sumDeltaY2:" + sumDeltaY2);  
	  
	        }  
	  
	        sst = sumYY - (sumY * sumY) / pn;  
	        // System.out.println("sst:" + sst);  
	        E = 1 - sumDeltaY2 / sst;  
	  
	        return round(E, 4);  
	    }

		// 用于实现精确的四舍五入
	    public double round(double v, int scale) {  
	  
	        if (scale < 0) {  
	            throw new IllegalArgumentException(  
	                    "The scale must be a positive integer or zero");  
	        }  
	  
	        BigDecimal b = new BigDecimal(Double.toString(v));  
	        BigDecimal one = new BigDecimal("1");  
	        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();  
	  
	    }  
	  
	    public double getValue(double num){
	    	 BigDecimal   b   =   new   BigDecimal(getA1() * num + getA0());  
	    	 return  b.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();
	    }
}
