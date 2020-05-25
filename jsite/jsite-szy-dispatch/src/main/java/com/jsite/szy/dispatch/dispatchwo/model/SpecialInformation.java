package com.jsite.szy.dispatch.dispatchwo.model;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsite.busi.szy.dispatch.po.DdsRdIfres;
import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.busi.szy.dispatch.po.DdsRdWares;
import com.jsite.szy.dispatch.dispatchwo.convert.WODisplayConvert;

public class SpecialInformation {
	private WODisplayConvert wodc;
	
	public SpecialInformation(String path) {
		ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext(path);
		wodc = (WODisplayConvert) context1.getBean("data");
		context1.close();
	}
	
	public List<DdsRdIfres> loadSpecialForecastList(DdsRdP scheme){
		sysLog("检测到数据库中不包含来水预报数据，将使用特例数据替代...");
		List<DdsRdIfres> list = wodc.getForcastList(scheme);
		return list;
	}
	
	public List<DdsRdWares> loadSpecialAllocateList(DdsRdP scheme){
		sysLog("检测到数据库中不包含水量分配数据，将使用特例数据替代...");
		List<DdsRdWares> list = wodc.getAllocateList(scheme);
		return list;
	}
	
	public void sysLog(String text){
		System.out.println(text);
	}
}
