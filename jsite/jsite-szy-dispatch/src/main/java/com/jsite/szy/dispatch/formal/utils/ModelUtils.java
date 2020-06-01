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
	public static List<TSfrdDisWusRslt> getParamList(ResultEntity result,TSfrdPro pro,int index,String enCd){
		List<TSfrdDisWusRslt> list = Lists.newArrayList();
		try{
			for(int i = 0 ; i < 12;i++){
				TSfrdDisWusRslt wus = new TSfrdDisWusRslt();
				wus.setProCd(pro.getProCd());
				wus.setEnCd(enCd);
				wus.setRsltTp("1");
				wus.setStDt(getMonthDay(pro.getBgDt(), i, pro.getProTp()));
				wus.setInw(result.getInflowTotal()!=null ? result.getInflowTotal().get(index)[i]:null);
				wus.setWu(result.getConsumptionTotal()!=null ? result.getConsumptionTotal().get(index)[i]:null);
				wus.setDchgw(result.getOutflowTotal() !=null? result.getOutflowTotal().get(index)[i]:null);
				wus.setWat(result.getWaterRequirement()!=null ?result.getWaterRequirement().get(index)[i]:null);
				wus.setPlanw(result.getWaterRequirementPlan() !=null ? result.getWaterRequirementPlan().get(index)[i]:null);
				wus.setDwR(result.getWaterRequirementFillRates() !=null ? result.getWaterRequirementFillRates().get(index)[i]:null);
				wus.setIndw(result.getIndustrialWaterRequirement() !=null ? result.getIndustrialWaterRequirement().get(index)[i]:null);
				wus.setAgrw(result.getAgriculturalWaterRequirement() !=null ? result.getAgriculturalWaterRequirement().get(index)[i]:null);
				wus.setLifw(result.getDomesticWaterRequirement() !=null ? result.getDomesticWaterRequirement().get(index)[i]:null);
				wus.setFafrw(result.getForestryWaterRequirement() !=null ? result.getForestryWaterRequirement().get(index)[i]:null);
				wus.setPlanindw(result.getIndustrialWaterRequirementPlan() !=null ? result.getIndustrialWaterRequirementPlan().get(index)[i]:null);
				wus.setPlanagrw(result.getAgriculturalWaterRequirementPlan() !=null ? result.getAgriculturalWaterRequirementPlan().get(index)[i]:null);
				wus.setLifw(result.getDomesticWaterRequirementPlan() !=null ? result.getDomesticWaterRequirementPlan().get(index)[i]:null);
				wus.setFafrw(result.getForestryWaterRequirementPlan()!=null ? result.getForestryWaterRequirementPlan().get(index)[i]:null);
				list.add(wus);
			}
		}catch(Exception e){
			e.printStackTrace();
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
