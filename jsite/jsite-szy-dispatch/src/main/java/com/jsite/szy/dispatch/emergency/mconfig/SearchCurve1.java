package com.jsite.szy.dispatch.emergency.mconfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.jsite.core.config.Global;
import com.jsite.szy.dispatch.common.BasicData;
import com.jsite.szy.dispatch.common.SearchMethod;

public class SearchCurve1 {	
	
	// 文件名
    static String path = Global.getConfig("uploadFile")+"WEB-INF/classes/com/jsite/szy/dispatch/emergency/mconfig/CURVE.xls";
		
    public double[]Zs=null;
    public double[]VS=null;
    public double[]Zd=null;
    public double[]QS=null;
    
    public SearchCurve1(String rsNM){
    	 
		int co1 = 0,co2=0;
		if(rsNM.equals("洪门水库")){ 
			co1=2;co2=3;
		}
		if(rsNM.equals("廖坊水库")){
			co1=7;co2=8; 
		}
		if(rsNM.equals("江口水库")){
			co1=12;co2=13;
		}
		Zs=readDoubleNumber(path ,"CURVE",co1);//v0水位，v1库容 —— v0查v1  
		VS=readDoubleNumber(path ,"CURVE",co2);
		
		if(rsNM.equals("洪门水库")){
			co1=4;co2=5;
		}
		if(rsNM.equals("廖坊水库")){
			co1=9;co2=10;
		}
		if(rsNM.equals("江口水库")){
			co1=14;co2=15;
		}
		Zd=readDoubleNumber(path ,"CURVE",co1); //v0尾水位，v1下泄流量——v1查v0 
		QS=readDoubleNumber(path ,"CURVE",co2);
		
    }
	/**
	 * 通过水位查库容
	 * 
	 * @param DdsBRes
	 *            水库实体
	 * @param Z
	 *            水位
	 * @return
	 */

	public double getVfromZ(double Z) {
       
		int len = Zs.length;
		BasicData[] ZVserial = new BasicData[len];
		for(int i=0;i<len;i++){
			ZVserial[i]=new BasicData();
			ZVserial[i].setIndex(Zs[i]);//string 到 double
			ZVserial[i].setValue(VS[i]);
			//System.out.println(Zs[i]+","+VS[i]);
		}
		if (len != 0)
			return (SearchMethod.search(ZVserial, Z));
		else 
			return -1;
		
	}
	
	/**
	 * 通过库容查水位
	 * 
	 * @param DdsBRes
	 *            水库实体
	 * @param v
	 *            库容
	 * @return
	 */
	public double getZfromV(double V) {
		
		int len = Zs.length;
		BasicData[] ZVserial = new BasicData[len];
		for(int i=0;i<len;i++){
			ZVserial[i]=new BasicData();
			ZVserial[i].setIndex(Zs[i]);//string 到 double
			ZVserial[i].setValue(VS[i]);
		}
		if (len != 0)
			return (SearchMethod.searchValueToIndex(ZVserial, V));
		else 
			return -1;
		
	}
	
	/**
	 * 通过下泄流量查尾水位
	 * 
	 * @param DdsBRes
	 *            水库实体
	 * @param Z
	 *            下泄流量
	 * @return
	 */
	public double getZDfromQ(double Q) {
	
		int len = Zd.length;
		BasicData[] ZVserial = new BasicData[len];
		for(int i=0;i<len;i++){
			ZVserial[i]=new BasicData();
			ZVserial[i].setIndex(Zd[i]);//string 到 double
			ZVserial[i].setValue(QS[i]);
		}
		if (len != 0)
			return (SearchMethod.searchValueToIndex(ZVserial, Q));
		else 
			return -1;
		
	}
	
	public static double[] readDoubleNumber(String filename, String sheetname,
			int column) {

		double[] rainoff = null;
		Workbook wb;
		try {

			InputStream is1 = new FileInputStream(filename);
			wb = Workbook.getWorkbook(is1);
			Sheet sheet1 = wb.getSheet(sheetname);
			int rowth = sheet1.getRows();// 总行数
			int rowlen = 0;// 非空的总行数
			for (int i = 0; i < rowth; i++) {
				if (sheet1.getCell(column, i).getContents().equals("")) {
					break;
				}
				rowlen++;
			}
			/*System.out.println("" + rowth);
			System.out.println("" + rowlen);*/
			rainoff = new double[rowlen - 1];

			for (int i = 1; i < rowlen; i++) {
				if (sheet1.getCell(column, i).getContents().equals("")) {
					break;
				}
				rainoff[i - 1] = Double.parseDouble(sheet1.getCell(column, i)
						.getContents().trim());// 实测序列 此处第1列 ()

			}

		} catch (FileNotFoundException e) {
			System.out.println("读取文件失败");
		} catch (BiffException e) {
			System.out.println("声明失败");
		} catch (IOException e) {
			System.out.println("声明失败");
		}

		return rainoff;

	}
}
