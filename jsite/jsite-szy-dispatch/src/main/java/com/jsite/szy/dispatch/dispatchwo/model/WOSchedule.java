package com.jsite.szy.dispatch.dispatchwo.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.jsite.szy.dispatch.dispatchwo.vo.WaterOptimumVOMap;
import com.wrms.core.scheme.SchemeTypeEnum;
import com.wrms.core.scheme.regular.SchemeRDispatchPara;
import com.wrms.core.scheme.regular.SchemeRDispatchResult;
import com.wrms.core.scheme.regular.SchemeRForcastResult;
import com.wrms.core.scheme.regular.SchemeRegularDispatch;
import com.wrms.core.scheme.regular.moudle.DispatchConstraintItem;
import com.wrms.core.scheme.regular.moudle.ForcastResultItem;
import com.wrms.core.subject.SubjectRegularDispatch;
import com.wrms.util.date.DateStyle;
import com.wrms.util.date.DateUtil;

import wrms.jiangxi.regular.RegulaSchemeController;
import wrms.jiangxi.regular.RegularExcute;
import wrms.jiangxi.regular.SchemeBean;
import wrms.jiangxi.regular.dispatch.WaterDispatchController;

public class WOSchedule {
	private SchemeBean bean;
	private WaterOptimumVOMap init;
	private WaterOptimumVOMap constraints;
	
	public WOSchedule() {
		bean = new SchemeBean();
		bean.setId("FHScheme0000001");
		bean.setType(SchemeTypeEnum.REGULAR_YEAR);
		bean.setName("抚河水量调度方案2017");
		bean.setTimeStart(DateUtil.StringToDate("2015-9-1",DateStyle.YYYY_MM_DD));
		bean.setTimeEnd(DateUtil.StringToDate("2016-1-1",DateStyle.YYYY_MM_DD));
		bean.setComment("抚河水量调度方案");
	}
	
	public WOSchedule(SchemeBean bean) {
		this.bean = bean;
	}
	
	public static void main(String[] args) {
		WOSchedule wo = new WOSchedule();
		try {
			wo.schedule();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sysLog(String text){
		System.out.println(text);
	}
	
	@SuppressWarnings("unchecked")
	public void fillForecast(SchemeRegularDispatch scheme, List<SchemeRForcastResult> list){
		LinkedHashMap<String, Object> fi = (LinkedHashMap<String, Object>) init.get("index3");
		ArrayList<Object> head = (ArrayList<Object>) fi.get("index1");
		List<LinkedHashMap<String, Object>> forecast = (List<LinkedHashMap<String, Object>>) fi.get("index2");
		
		
		for(int i=0;i<list.size();i++){
			SchemeRForcastResult single = list.get(i);
		//	LinkedHashMap<String, Object> lhm = queryItem(forecast, "index1", "");
			int flag = -1;
			for(int j=0;j<head.size();j++){
				if(single.getEntityName().equals(head.get(j).toString())){
					flag = j;
					break;
				}
			}
			if(flag >= 0){
				List<ForcastResultItem> array = single.getForcastResults();
				if(array != null && array.size()>0){
					for(int k=0;k<array.size();k++){
						ForcastResultItem temp = array.get(k);
						int month = getMonth(temp.getTimeStart());
						LinkedHashMap<String, Object> forecastItem = queryItem(forecast, "index1", month+"月");
						temp.setFocastValue(Double.parseDouble(forecastItem.get("index"+(3+flag)).toString()));
						sysLog("更改了站 "+temp.getEntityName()+" "+month+" 月的预报流量,值为"+temp.getFocastValue());
					}
				}
			}
		}
		
		
		scheme.setForcastResults(list);
	}
	
	public void fillParameters(SchemeRegularDispatch scheme, List<SchemeRDispatchPara> para){
		ELEMapping ele = new ELEMapping();
		
		List<LinkedHashMap<String, Object>> reservoirs = (List<LinkedHashMap<String, Object>>) init.get("index1");
		List<LinkedHashMap<String, Object>> cons = (List<LinkedHashMap<String, Object>>) constraints.get("index1");
		
		for(int i=0;i<para.size();i++){
			SchemeRDispatchPara single = para.get(i);			
			//更换水库水位
			LinkedHashMap<String, Object> initItem = queryItem(reservoirs, "index1", single.getEntityName());
			if(initItem != null){
				single.setLevelBegin((double) initItem.get("index2"));
				single.setLevelEnd((double) initItem.get("index3"));
				sysLog("更改了电站 "+single.getEntityName()+" 的初水位 "+single.getLevelBegin()+" 末水位 "+single.getLevelEnd());
			}
			//更换约束条件
			List<DispatchConstraintItem> itemCons = single.getDispatchConstraints();
			if(itemCons != null && itemCons.size()>0){
				for(int j=0;j<itemCons.size();j++){
					DispatchConstraintItem dcitem = itemCons.get(j);
					int month = getMonth(dcitem.getTimeStart());
					
					LinkedHashMap<String, Object> consItem = queryItem(cons, "index1", month+"月");
					if(consItem != null){
						int start = 1;
						while(consItem.get("index"+start+"_0") != null){
							if(consItem.get("index"+start+"_0").equals(dcitem.getEntityName())){
								dcitem.setLevelMax(Double.parseDouble(consItem.get("index"+start+"_1").toString()));
								dcitem.setLevelMin(Double.parseDouble(consItem.get("index"+start+"_2").toString()));
								dcitem.setOutflowMax(Double.parseDouble(consItem.get("index"+start+"_3").toString()));
								dcitem.setOutflowMin(Double.parseDouble(consItem.get("index"+start+"_4").toString()));
								dcitem.setOutputMax(Double.parseDouble(consItem.get("index"+start+"_5").toString()));
								dcitem.setOutputMin(Double.parseDouble(consItem.get("index"+start+"_6").toString()));
								sysLog("更改了电站 "+dcitem.getEntityName()+" "+month+" 月的约束条件");
								break;
							}
							start++;
						}
						
					}
				}
			}
		}
		scheme.setDispatchParas(para);
		sysLog("调度条件Fill End!");
	}
	
	public int getMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH)+1;
	}
	
	public LinkedHashMap<String, Object> queryItem(List<LinkedHashMap<String, Object>> list, String field, String value){
		if(list != null && list.size()>0){
			for(int i=0;i<list.size();i++){
				LinkedHashMap<String, Object> single = list.get(i);
				String text = (String) single.get(field);
				if(text.equals(value))return single;
			}
		}
		return null;
	}
	
	public List<SchemeRDispatchResult> schedule() throws IOException{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/jsite/szy/dispatch/dispatchwo/model/dispatchdemo.xml");
		WOConditionHolder woch = (WOConditionHolder) context.getBean("demo");
		context.close();
		
		
		Resource resource = new ClassPathResource("com/jsite/szy/dispatch/dispatchwo/model/FH0001.xml");
		if (resource.isReadable()){
			InputStream is = resource.getInputStream();  
			RegularExcute re = new RegularExcute(is);
			is.close();
			
			SubjectRegularDispatch normalDispatch = re.getNormalDispatch();
			RegulaSchemeController schemeController = new RegulaSchemeController(normalDispatch);
			SchemeRegularDispatch scheme = schemeController.newScheme(bean);
			
			fillForecast(scheme, woch.getForecast());
		//	scheme.setForcastResults(woch.getForecast());
			scheme.setDemandResults(woch.getDemand());
			scheme.setAllocationResults(woch.getAllocation());
			
			List<SchemeRDispatchPara> para = woch.getDispatchPara();
			fillParameters(scheme, para);
		//	scheme.setDispatchParas(para);
			
			
			
			
			WaterDispatchController dispatchController = new WaterDispatchController(normalDispatch);
			List<SchemeRDispatchResult> dispatchResults = dispatchController.execute(scheme, scheme.getForcastResults(), scheme.getAllocationResults(), scheme.getDispatchParas());
			
			
			
			System.out.println(dispatchResults);
			
			return dispatchResults;
		}
		else throw new RuntimeException("不可读的配置文件");
	}

	public SchemeBean getBean() {
		return bean;
	}

	public void setBean(SchemeBean bean) {
		this.bean = bean;
	}

	public WaterOptimumVOMap getInit() {
		return init;
	}

	public void setInit(WaterOptimumVOMap init) {
		this.init = init;
	}

	public WaterOptimumVOMap getConstraints() {
		return constraints;
	}

	public void setConstraints(WaterOptimumVOMap constraints) {
		this.constraints = constraints;
	}
	
	
}
