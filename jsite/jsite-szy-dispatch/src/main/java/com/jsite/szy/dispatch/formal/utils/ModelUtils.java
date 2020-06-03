package com.jsite.szy.dispatch.formal.utils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.jsite.busi.szy.formal.po.TSfrdDisWusRslt;
import com.jsite.busi.szy.formal.po.TSfrdPro;
import com.jsite.busi.szy.formal.po.TSfrdRsvrRslt;

import waterDispatch.entity.ResultEntity;

/**
 * 方案模型管理类
 * @author seven
 *
 */
public class ModelUtils {
	
	/**
	 * 根据日期获取对应月份
	 * @param tm
	 * @return
	 */
	public static int getMonth(Date tm) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(tm);
		return cal.get(Calendar.MONTH);
	}
	
	
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
				wus.setInw(result.getInflowTotal()!=null ? getScale(3, result.getInflowTotal().get(index)[i]) : null);
				wus.setWu(result.getConsumptionTotal()!=null ? getScale(3, result.getConsumptionTotal().get(index)[i]) : null);
				wus.setDchgw(result.getOutflowTotal() !=null? getScale(3, result.getOutflowTotal().get(index)[i]) : null);
				wus.setWat(result.getWaterRequirement()!=null ? getScale(3, result.getWaterRequirement().get(index)[i]) : null);
				wus.setPlanw(result.getWaterRequirementPlan() !=null ? getScale(3, result.getWaterRequirementPlan().get(index)[i]) : null);
				wus.setRwr(result.getWaterRequirementFillRates() !=null ? getScale(3, result.getWaterRequirementFillRates().get(index)[i]) : null);
				wus.setIndw(result.getIndustrialWaterRequirement() !=null ? getScale(3, result.getIndustrialWaterRequirement().get(index)[i]) : null);
				wus.setAgrw(result.getAgriculturalWaterRequirement() !=null ? getScale(3, result.getAgriculturalWaterRequirement().get(index)[i]) : null);
				wus.setLifw(result.getDomesticWaterRequirement() !=null ? getScale(3, result.getDomesticWaterRequirement().get(index)[i]) : null);
				wus.setFafrw(result.getForestryWaterRequirement() !=null ? getScale(3, result.getForestryWaterRequirement().get(index)[i]) : null);
				wus.setPlanindw(result.getIndustrialWaterRequirementPlan() !=null ? getScale(3, result.getIndustrialWaterRequirementPlan().get(index)[i]) : null);
				wus.setPlanagrw(result.getAgriculturalWaterRequirementPlan() !=null ? getScale(3, result.getAgriculturalWaterRequirementPlan().get(index)[i]) : null);
				wus.setPlanlifw(result.getDomesticWaterRequirementPlan() !=null ? getScale(3, result.getDomesticWaterRequirementPlan().get(index)[i]) : null);
				wus.setPlanfafrw(result.getForestryWaterRequirementPlan()!=null ? getScale(3, result.getForestryWaterRequirementPlan().get(index)[i]) : null);
				list.add(wus);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 得到廖坊水库计算结果数据
	 * @param result
	 * @param pro
	 * @param enCd
	 * @return
	 */
	public static List<TSfrdRsvrRslt> getLFRsvrList(ResultEntity result,TSfrdPro pro,String enCd){
		List<TSfrdRsvrRslt> list = Lists.newArrayList();
		try{
			for(int i = 0 ; i < 12;i++){
				TSfrdRsvrRslt rslt = new TSfrdRsvrRslt();
				rslt.setProCd(pro.getProCd());
				rslt.setEnCd(enCd);
				rslt.setTm(getMonthDay(pro.getBgDt(), i, pro.getProTp()));
				rslt.setInflow(result.getLFSKinflowTotal() !=null ? getScale(3, result.getLFSKinflowTotal()[i]) : null);
				rslt.setOutflow(result.getLFSKoutflowTotal() !=null ? getScale(3, result.getLFSKoutflowTotal()[i]) : null);
				rslt.setZ(result.getLFSKlevel() !=null ? getScale(2, result.getLFSKlevel()[i]) : null);
				list.add(rslt);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 得到廖坊水库计算结果数据
	 * @param result
	 * @param pro
	 * @param enCd
	 * @return
	 */
	public static List<TSfrdRsvrRslt> getHMRsvrList(ResultEntity result,TSfrdPro pro,String enCd){
		List<TSfrdRsvrRslt> list = Lists.newArrayList();
		try{
			for(int i = 0 ; i < 12;i++){
				TSfrdRsvrRslt rslt = new TSfrdRsvrRslt();
				rslt.setProCd(pro.getProCd());
				rslt.setEnCd(enCd);
				rslt.setTm(getMonthDay(pro.getBgDt(), i, pro.getProTp()));
				rslt.setInflow(result.getHMSKinflowTotal() !=null ? getScale(3, result.getHMSKinflowTotal()[i]) : null);
				rslt.setOutflow(result.getHMSKoutflowTotal() !=null ? getScale(3, result.getHMSKoutflowTotal()[i]) : null);
				rslt.setZ(result.getHMSKlevel() !=null ? getScale(2, result.getHMSKlevel()[i]) : null);
				list.add(rslt);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static Double getScale(int newScale,Double target){
		if(null == target){
			return null ;
		}
		BigDecimal b = new BigDecimal(target);
		return b.setScale(newScale, BigDecimal.ROUND_HALF_UP).doubleValue();   
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
	
	public static void main(String[] args){
		System.out.println(getMonth(new Date()));
	}
	
}
