package com.jsite.szy.dispatch.dispatchwo.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.busi.szy.dispatch.service.DdsRdPService;
import com.wrms.util.date.DateStyle;
import com.wrms.util.date.DateUtil;

public class TestPlan {
	private DdsRdP plan;
	
	public TestPlan(String schemeId, DdsRdPService DDS_RD_P) {
		if(DDS_RD_P == null)demoPlan(schemeId);
		else {
			DdsRdP ddsRdP = new DdsRdP();
			ddsRdP.setProCd(schemeId);
			DdsRdP item = DDS_RD_P.get(ddsRdP);
			
			if(item == null){
				System.out.println("方案查询失败，更换为显示测试数据......");
				demoPlan(schemeId);
			}
			else{
				plan = new DdsRdP();
				BeanUtils.copyProperties(item, plan);
				plan.setProCd(schemeId);
				plan.setProTp(item.getProTp());
				plan.setProNm(item.getProNm());				
				plan.setBgDt(smoothDateDown(item.getBgDt(), item.getProTp().indexOf("3") >= 0));
				plan.setEdDt(smoothDateDown(item.getEdDt(), item.getProTp().indexOf("3") >= 0));
				plan.setNt(item.getNt());
				plan.setRvCd(item.getRvCd());
			}
		}
	}
	
	/**
	 * 特殊处理结束时间至1号 11号 21号，向下取
	 * @param date
	 * @return
	 */
	public Date smoothDateDown(Date date, boolean isxun){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if(isxun){
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			if(day < 11)calendar.set(Calendar.DAY_OF_MONTH, 1);
			else if(day < 21)calendar.set(Calendar.DAY_OF_MONTH, 11);
			else calendar.set(Calendar.DAY_OF_MONTH, 21);
		}
		else{
			calendar.set(Calendar.DAY_OF_MONTH, 1);
		}
		return calendar.getTime();
	}
	
	/**
	 * 特殊处理结束时间至1号 11号 21号，向上取
	 * @param date
	 * @return
	 */
	public Date smoothDateUp(Date date, boolean isxun){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if(isxun){
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			if(day > 21){
				calendar.add(Calendar.MONTH, 1);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
			}
			else if(day < 21 && day > 11)calendar.set(Calendar.DAY_OF_MONTH, 21);
			else if(day < 11 && day > 1)calendar.set(Calendar.DAY_OF_MONTH, 11);
		}
		else{
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			if(day > 1){
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				calendar.add(Calendar.MONTH, 1);
			}
		}
		return calendar.getTime();
	}
	
	/*public TestPlan(String schemeId) {
		demoPlan(schemeId);
	}*/
	
	public void demoPlan(String schemeId){
		if(schemeId.toLowerCase().indexOf("month") >= 0){
			monthDemo(schemeId);
		}
		else if(schemeId.toLowerCase().indexOf("xun") >= 0){
			xunDemo(schemeId);
		}
		else {
			yearDemo(schemeId);
		}
	}
	
	public void yearDemo(String schemeId){
		plan = new DdsRdP();
		plan.setProCd(schemeId);
		plan.setProNm("抚河水量年调度方案2017");
		plan.setBgDt(DateUtil.StringToDate("2015-1-1",DateStyle.YYYY_MM_DD));
		plan.setEdDt(DateUtil.StringToDate("2016-1-1",DateStyle.YYYY_MM_DD));
		plan.setProTp("1");
		plan.setNt("抚河水量调度方案");
	}
	
	public void monthDemo(String schemeId){
		plan = new DdsRdP();
		plan.setProCd(schemeId);
		plan.setProNm("抚河水量月调度方案2017");
		plan.setBgDt(DateUtil.StringToDate("2015-8-1",DateStyle.YYYY_MM_DD));
		plan.setEdDt(DateUtil.StringToDate("2016-1-1",DateStyle.YYYY_MM_DD));
		plan.setProTp("2");
		plan.setNt("抚河水量调度方案");
	}
	
	public void xunDemo(String schemeId){
		plan = new DdsRdP();
		plan.setProCd(schemeId);
		plan.setProNm("抚河水量旬调度方案2017");
		plan.setBgDt(DateUtil.StringToDate("2015-8-1",DateStyle.YYYY_MM_DD));
		plan.setEdDt(DateUtil.StringToDate("2016-1-1",DateStyle.YYYY_MM_DD));
		plan.setProTp("3");
		plan.setNt("抚河水量调度方案");
	}
	
	protected Date beginTime(Date time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.set(Calendar.YEAR, 2017);
		return calendar.getTime();
	}
	
	protected Date endTime(Date time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse("2018-01-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public DdsRdP getPlan() {
		return plan;
	}

	public void setPlan(DdsRdP plan) {
		this.plan = plan;
	}
	
	
}
