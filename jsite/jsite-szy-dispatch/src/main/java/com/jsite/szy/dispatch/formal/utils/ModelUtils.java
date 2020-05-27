package com.jsite.szy.dispatch.formal.utils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.jsite.busi.szy.formal.po.TSfrdDisWusRslt;
import com.jsite.busi.szy.formal.po.TSfrdPro;

import waterDispatch.entity.ResultEntity;

/**
 * 方案模型管理类
 * @author seven
 *
 */
public class ModelUtils {
	
	/**
	 * 根据方案类型，起始日期，组装时间
	 * @param bgDt
	 * @param mth
	 * @param proTp
	 * @return
	 */
	public static Date getMonthDay(Date bgDt,int mth,String proTp){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(bgDt);
		if("Y".equals(proTp)){
			cal.set(Calendar.MONTH, mth);
		}
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	/**
	 * 获取行政区数据
	 * @param result
	 * @param pro
	 * @param index
	 * @return
	 */
	public static List<TSfrdDisWusRslt> getParamList(ResultEntity result,TSfrdPro pro,int index){
		List<TSfrdDisWusRslt> list = Lists.newArrayList();
		for(int i = 0 ; i < 12;i++){
			TSfrdDisWusRslt wus = new TSfrdDisWusRslt();
			wus.setProCd(pro.getProCd());
			wus.setEnCd("112000023");
			wus.setStDt(getMonthDay(pro.getBgDt(), index, pro.getProTp()));
			wus.setInw(result.getInflowTotal().get(index)[i]);
			wus.setWu(result.getConsumptionTotal().get(index)[i]);
			wus.setDchgw(result.getOutflowTotal().get(index)[i]);
			wus.setWat(result.getWaterRequirement().get(index)[i]);
			wus.setPlanw(result.getWaterRequirementPlan().get(index)[i]);
			wus.setDwR(result.getWaterRequirementFillRates().get(index)[i]);
			wus.setIndw(result.getIndustrialWaterRequirement().get(index)[i]);
			wus.setAgrw(result.getAgriculturalWaterRequirement().get(index)[i]);
			wus.setLifw(result.getDomesticWaterRequirement().get(index)[i]);
			wus.setFafrw(result.getForestryWaterRequirement().get(index)[i]);
			wus.setPlanindw(result.getIndustrialWaterRequirementPlan().get(index)[i]);
			wus.setPlanagrw(result.getAgriculturalWaterRequirementPlan().get(index)[i]);
			wus.setLifw(result.getDomesticWaterRequirementPlan().get(index)[i]);
			wus.setFafrw(result.getForestryWaterRequirementPlan().get(index)[i]);
			list.add(wus);
		}
		return list;
	}

	/**
	 * 获取数据精度处理数据
	 * @param newScale
	 * @param target
	 * @return
	 */
	public static double getRslt(int newScale,double target){
		BigDecimal b = new BigDecimal(target);
		return b.setScale(newScale, BigDecimal.ROUND_HALF_UP).doubleValue();        
	}
	
}
