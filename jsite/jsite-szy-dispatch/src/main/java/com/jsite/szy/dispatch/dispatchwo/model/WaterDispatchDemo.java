package com.jsite.szy.dispatch.dispatchwo.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.wrms.core.scheme.SchemeTypeEnum;
import com.wrms.core.scheme.regular.SchemeRAllocationResult;
import com.wrms.core.scheme.regular.SchemeRDemandResult;
import com.wrms.core.scheme.regular.SchemeRDispatchResult;
import com.wrms.core.scheme.regular.SchemeRForcastResult;
import com.wrms.core.scheme.regular.SchemeRegularDispatch;
import com.wrms.core.scheme.regular.moudle.DispatchResultItem;
import com.wrms.core.subject.SubjectRegularDispatch;
import com.wrms.core.timeseries.TimeSeries;
import com.wrms.util.date.DateStyle;
import com.wrms.util.date.DateUtil;

import wrms.jiangxi.regular.RegulaSchemeController;
import wrms.jiangxi.regular.RegularExcute;
import wrms.jiangxi.regular.SchemeBean;
import wrms.jiangxi.regular.allocation.WaterAllocationController;
import wrms.jiangxi.regular.demand.WaterDemandController;
import wrms.jiangxi.regular.dispatch.WaterDispatchController;
import wrms.jiangxi.regular.forcast.LongTermForcastController;

public class WaterDispatchDemo {

	public List<SchemeRDispatchResult> dispatch() throws IOException {
		// TODO 自动生成的构造函数存根
		
		//-------------------初始化时间序列(需要在后台读取数据库)--------------------
		List<TimeSeries> timeSeries = new ArrayList<TimeSeries>();
		String[] names = new String[]{"栋背","林坑","峡江","外洲"};
		String[] stcdQ = new String[]{"62301300","62307550","62301800","62302250"};//流量站点
		String[] stcdP = new String[]{"62329760","62330200","62335980","62340760"};//雨量站点
		
		
		for(int i=0;i<names.length;i++) {
			
		//	Object[][] dataP = ExcelTool.read07Excel("data/inflow/"+names[i]+".xlsx", names[i]+"旬降雨量");
		//	Object[][] dataQ = ExcelTool.read07Excel("data/inflow/"+names[i]+".xlsx", names[i]+"旬径流量");
			TimeSeries seriesQ = new TimeSeries();
			TimeSeries seriesP = new TimeSeries();
			seriesQ.setStcd(stcdQ[i]);
			seriesQ.setName(names[i]+"站-流量");

			seriesP.setStcd(stcdP[i]);
			seriesP.setName(names[i]+"站-降雨");
			/*
			for(int j=1;j<dataQ.length;j++) {
				int year = (int) Math.rint((double)dataQ[j][0]);
				for(int k=0;k<36;k++){

					int month = k/3+1;
					int day = k%3*10+1;
					String  time= year+"-"+month+"-"+day;

					Date d = DateUtil.StringToDate(time,DateStyle.YYYY_MM_DD);
					SeriesValue valueQ = new SeriesValue();
					valueQ.setTime(d);
					valueQ.setValue((double)dataQ[k][k+1]);
					seriesQ.getValues().add(valueQ);
					
					SeriesValue valueP = new SeriesValue();
					valueP.setTime(d);
					valueP.setValue((double)dataP[k][k+1]);
					seriesP.getValues().add(valueP);
//					System.out.println(valueP);
				}
			}*/
			timeSeries.add(seriesP);
			timeSeries.add(seriesQ);
			System.out.println(names[i]+"录入成功!");
		}

		
		//--------------------初始化一个方案--------------------
		InputStream is = this.getClass().getResourceAsStream("FH0001.xml");
		RegularExcute re = new RegularExcute(is);
		is.close();
		SubjectRegularDispatch normalDispatch = re.getNormalDispatch();
		
		RegulaSchemeController schemeController = new RegulaSchemeController(normalDispatch);	
		SchemeBean  bean = new SchemeBean();
		bean.setId("FHScheme0000001");
		bean.setType(SchemeTypeEnum.REGULAR_YEAR);
		bean.setName("抚河水量调度方案2017");
		bean.setTimeStart(DateUtil.StringToDate("2015-1-1",DateStyle.YYYY_MM_DD));
		bean.setTimeEnd(DateUtil.StringToDate("2016-1-1",DateStyle.YYYY_MM_DD));
		bean.setComment("抚河水量调度方案");
		SchemeRegularDispatch scheme = schemeController.newScheme(bean);
		
		
		
		//准备预报数据
		LongTermForcastController controller = new LongTermForcastController(normalDispatch,timeSeries);
		//得到预报结果
		List<SchemeRForcastResult> fResult = controller.executeYear(scheme, scheme.getForcastParas());
		scheme.setForcastResults(fResult);
		
		
		//准备需水预测数据
		WaterDemandController waterDemandController = new WaterDemandController(normalDispatch);
		//要传入一个SchemeRegularDispatch scheme 和    List<SchemeRDemandPara> demandParas
		List<SchemeRDemandResult> dResult = waterDemandController.execute(scheme,scheme.getDemandParas());
		scheme.setDemandResults(dResult);
		
		//准备水量分配数据
		WaterAllocationController waterAllocationController = new WaterAllocationController(normalDispatch);
		scheme.getAvailableWaterSupply().setMax_sl(120);
		List<SchemeRAllocationResult> aResults = waterAllocationController.execute(scheme.getAvailableWaterSupply(), scheme.getDemandResults());
		scheme.setAllocationResults(aResults);
		
		
		
		
		//------------------看这里--------------------------
		WaterDispatchController dispatchController = new WaterDispatchController(normalDispatch);
		List<SchemeRDispatchResult> dispatchResults = dispatchController.execute(scheme, scheme.getForcastResults(), scheme.getAllocationResults(), scheme.getDispatchParas());
		
		
		
		System.out.println(dispatchResults);
		
		return dispatchResults;
	}
	
	@Test
	public void readDispatch() throws IOException{
		List<SchemeRDispatchResult> result = dispatch();
		int len = result.size();
		for(int i=0;i<len;i++){
			SchemeRDispatchResult single = result.get(i);
			
			String id = single.getEntityId();
			String name = single.getEntityName();
			System.out.print(single.getEntityId()+"\t"+single.getEntityName()+"\t");
			
			
			if(id.equals("CA000005")){
				System.out.println("沙子岭");
				List<DispatchResultItem> sets = single.getDispatchResults();
				for(int j=0;j<sets.size();j++){
					DispatchResultItem dri = sets.get(j);
					System.out.println(dri.getOutflow()+"--"+dri.getInflow());
				}					
			}
			else if(id.equals("765503F0905201")){
				System.out.println("南城-盱江");
				List<DispatchResultItem> sets = single.getDispatchResults();
				for(int j=0;j<sets.size();j++){
					DispatchResultItem dri = sets.get(j);
					System.out.println(dri.getAllocatedWater()+"--"+dri.getSuppliedWater());
				}
			}
			else if(id.equals("783944000000")){
				System.out.println("洪门水库");
				List<DispatchResultItem> sets = single.getDispatchResults();
				for(int j=0;j<sets.size();j++){
					DispatchResultItem dri = sets.get(j);
					System.out.println(dri.getAllocatedWater()+"--"+dri.getSuppliedWater());
				}
			}
			
		}
	}
}
