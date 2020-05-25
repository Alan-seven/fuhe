package com.jsite.szy.dispatch.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsite.busi.szy.info.dao.DdsBResDao;
import com.jsite.busi.szy.info.po.DdsBRes;

public class SearchCurve {	

	/**
	 * 通过水位查库容
	 * 
	 * @param rsNM
	 *            水库名称
	 * @param rsCD
	 *            水库代码
	 * @param Z
	 *            水位
	 * @return
	 */

	public static double getVfromZ(List<DdsBRes> listZV, double Z) {
		int len = listZV.size();
		BasicData[] ZVserial = new BasicData[len];
		for(int i=0;i<len;i++){
			ZVserial[i]=new BasicData();
			ZVserial[i].setIndex(Double.parseDouble(listZV.get(i).getV0()));//string 到 double
			ZVserial[i].setValue(Double.parseDouble(listZV.get(i).getV1()));
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
	public static  double getZfromV(List<DdsBRes> listZV, double V) {
		//v0水位，v1库容 —— v1查v0
		int len = listZV.size();
		BasicData[] ZVserial = new BasicData[len];
		for(int i=0;i<len;i++){
			ZVserial[i]=new BasicData();
			ZVserial[i].setIndex(Double.parseDouble(listZV.get(i).getV0()));//string 到 double
			ZVserial[i].setValue(Double.parseDouble(listZV.get(i).getV1()));
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
	public static double getZDfromQ(List<DdsBRes> listZdQ,double Q) {
        //v0尾水位，v1下泄流量——v1查v0
		int len = listZdQ.size();
		BasicData[] ZVserial = new BasicData[len];
		for(int i=0;i<len;i++){
			ZVserial[i]=new BasicData();
			ZVserial[i].setIndex(Double.parseDouble(listZdQ.get(i).getV0())-0.5);//string 到 double
			ZVserial[i].setValue(Double.parseDouble(listZdQ.get(i).getV1()));
		}
		if (len != 0)
			return (SearchMethod.searchValueToIndex(ZVserial, Q));
		else 
			return -1;
		
	}
	

	
}
