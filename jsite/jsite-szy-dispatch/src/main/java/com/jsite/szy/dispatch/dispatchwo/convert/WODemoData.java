package com.jsite.szy.dispatch.dispatchwo.convert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsite.busi.szy.dispatch.po.DdsRdIfres;
import com.jsite.busi.szy.dispatch.po.DdsRdWares;
import com.jsite.busi.szy.dispatch.po.DdsRdWdcons;
import com.jsite.busi.szy.dispatch.po.DdsRdWdinit;
import com.jsite.szy.dispatch.dispatchwo.model.WOConditionHolder;
import com.wrms.core.scheme.regular.SchemeRAllocationResult;
import com.wrms.core.scheme.regular.SchemeRDispatchPara;
import com.wrms.core.scheme.regular.SchemeRForcastResult;
import com.wrms.core.scheme.regular.moudle.AllocationResult;
import com.wrms.core.scheme.regular.moudle.AllocationResultItem;
import com.wrms.core.scheme.regular.moudle.DispatchConstraintItem;
import com.wrms.core.scheme.regular.moudle.ForcastResultItem;

public class WODemoData {
	/*protected DdsRdWdinitService DDS_RD_WDINIT;
	protected DdsRdWdconsService DDS_RD_WDCONS;
	protected DdsRdIfresService DDS_RD_IFRES;
	protected DdsRdWamresService DDS_RD_WAMRES;
	protected DdsRdWdmparService DDS_RD_WDMPAR;
	protected DdsRdWdresService DDS_RD_WDRES;*/
	WODisplayConvert woDisplayConvert;
	
	protected final String schemeId = "FH_default_01";
	
	public WODemoData() {
		woDisplayConvert = new WODisplayConvert();
	}
	
	public void allocateFill(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/jsite/szy/dispatch/dispatchwo/model/dispatchdemo.xml");
		WOConditionHolder woch = (WOConditionHolder) context.getBean("demo");
		context.close();
		
		List<SchemeRAllocationResult> data = woch.getAllocation();
		
		List<DdsRdWares> list = new ArrayList<DdsRdWares>();
		for(int i=0;i<data.size();i++){
			SchemeRAllocationResult single = data.get(i);
			System.out.println(single);
			DdsRdWares drw1_0 = new DdsRdWares();
			drw1_0.setProCd(schemeId);
			drw1_0.setRegCd(single.getEntityId());
			drw1_0.setRsTp(0);
			drw1_0.setTotRs(single.getDeclareWater());
			drw1_0.setMonth(0);
			list.add(drw1_0);
			DdsRdWares drw1_1 = new DdsRdWares();
			drw1_1.setProCd(schemeId);
			drw1_1.setRegCd(single.getEntityId());
			drw1_1.setRsTp(1);
			drw1_1.setTotRs(single.getAllocatedWater());
			drw1_1.setMonth(0);
			list.add(drw1_1);
			List<AllocationResult> child1 = single.getAllocationResults();
			if(child1 != null && child1.size()>0){
				for(int j=0;j<child1.size();j++){
					AllocationResult ar = child1.get(j);
					
					List<AllocationResultItem> declare = ar.getDeclareWaters();
					if(declare != null && declare.size()>0){
						for(int k=0;k<declare.size();k++){
							AllocationResultItem item = declare.get(k);
							DdsRdWares drw2_0 = new DdsRdWares();
							drw2_0.setProCd(schemeId);
							drw2_0.setRegCd(item.getEntityId());
							drw2_0.setRsTp(0);
							drw2_0.setBt(item.getTimeStart());
							drw2_0.setEt(item.getTimeEnd());
							drw2_0.setYear(getTime(item.getTimeStart(), Calendar.YEAR));
							drw2_0.setMonth(getMonth(item.getTimeStart()));
						//	drw2_0.setDedade(getTime(item.getTimeStart(), Cal));
							drw2_0.setDRs(item.getD_RS());
							drw2_0.setURs(item.getU_RS());
							drw2_0.setBhRs(item.getBH_RS());
							drw2_0.setShRs(item.getSH_RS());
							drw2_0.setPwirRs(item.getPWIR_RS());
							drw2_0.setPdirRs(item.getPDIR_RS());
							drw2_0.setPvirRs(item.getPVIR_RS());
							drw2_0.setFiRs(item.getFI_RS());
							drw2_0.setAiRs(item.getAI_RS());
							drw2_0.setMfishRs(item.getMFISH_RS());
							drw2_0.setIndRs(item.getIND_RS());
							drw2_0.setNindRs(item.getNIND_RS());
							drw2_0.setTotRs(item.getTOT_RS());
							list.add(drw2_0);
						}
					}
					
					
					List<AllocationResultItem> allocate = ar.getAllocatedWaters();
					if(allocate != null && allocate.size()>0){
						for(int k=0;k<allocate.size();k++){
							AllocationResultItem item = allocate.get(k);
							DdsRdWares drw2_0 = new DdsRdWares();
							drw2_0.setProCd(schemeId);
							drw2_0.setRegCd(item.getEntityId());
							drw2_0.setRsTp(1);
							drw2_0.setBt(item.getTimeStart());
							drw2_0.setEt(item.getTimeEnd());
							drw2_0.setYear(getTime(item.getTimeStart(), Calendar.YEAR));
							drw2_0.setMonth(getMonth(item.getTimeStart()));
							drw2_0.setDRs(item.getD_RS());
							drw2_0.setURs(item.getU_RS());
							drw2_0.setBhRs(item.getBH_RS());
							drw2_0.setShRs(item.getSH_RS());
							drw2_0.setPwirRs(item.getPWIR_RS());
							drw2_0.setPdirRs(item.getPDIR_RS());
							drw2_0.setPvirRs(item.getPVIR_RS());
							drw2_0.setFiRs(item.getFI_RS());
							drw2_0.setAiRs(item.getAI_RS());
							drw2_0.setMfishRs(item.getMFISH_RS());
							drw2_0.setIndRs(item.getIND_RS());
							drw2_0.setNindRs(item.getNIND_RS());
							drw2_0.setTotRs(item.getTOT_RS());
							list.add(drw2_0);
						}
					}
					
					
					
				}
				
			}
		}
		
		System.out.println(list.size());
		
		woDisplayConvert.setAllocateList(list);
		
		/*for(DdsRdWamres obj: list){
			System.out.println("插入 "+obj);
			ServiceResp res = DDS_RD_WAMRES.save(obj);
			System.out.println(res.getMsg());
		}*/
	}
	
	public void forecastFill(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/jsite/szy/dispatch/dispatchwo/model/dispatchdemo.xml");
		WOConditionHolder woch = (WOConditionHolder) context.getBean("demo");
		context.close();
		
		List<DdsRdIfres> slip = new ArrayList<DdsRdIfres>();
		
		List<SchemeRForcastResult> data = woch.getForecast();
		
		
		for(int i=0;i<data.size();i++){
			SchemeRForcastResult single = data.get(i);
			List<ForcastResultItem> pack = single.getForcastResults();
			if(pack != null && pack.size()>0){
				for(int j=0;j<pack.size();j++){
					ForcastResultItem fri = pack.get(j);
					DdsRdIfres ifre = new DdsRdIfres();
					ifre.setProCd(schemeId);
					ifre.setSecCd(fri.getEntityId());
					ifre.setBgtm(new java.sql.Date(fri.getTimeStart().getTime()));
					ifre.setEdtm(new java.sql.Date(fri.getTimeEnd().getTime()));
					ifre.setMonth(getMonth(fri.getTimeStart()));
					ifre.setForW(fri.getFocastValue());
					ifre.setLyW(fri.getLastYearValue());
					ifre.setLyRt(fri.getYearOnyear());
					ifre.setAnnW(fri.getAverageAnnualValue());
					ifre.setAnoV(fri.getAnomalyValue());
					ifre.setConcl(fri.getConclusion());
					slip.add(ifre);
				}				
			}			
		}
		
		woDisplayConvert.setForcastList(slip);
		/*for(DdsRdIfres obj: slip){
			System.out.println("插入 "+obj);
			ServiceResp res = DDS_RD_IFRES.save(obj);
			System.out.println(res.getMsg());
		}*/
	}
	
	public int getMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH)+1;
	}
	
	public int getTime(Date date, int col){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(col);
	}
	
	public void defaultFill(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/jsite/szy/dispatch/dispatchwo/model/dispatchdemo.xml");
		WOConditionHolder woch = (WOConditionHolder) context.getBean("demo");
		context.close();
		
		List<SchemeRDispatchPara> data = woch.getDispatchPara();
		
		List<DdsRdWdinit> initList = new ArrayList<DdsRdWdinit>();
		List<DdsRdWdcons> consList = new ArrayList<DdsRdWdcons>();
		
		
		for(int i=0;i<data.size();i++){
			SchemeRDispatchPara para = data.get(i);
			DdsRdWdinit temp = new DdsRdWdinit();
			temp.setProCd(schemeId);
			temp.setWceId(para.getEntityId());
			temp.setWceTp(para.getType());
			temp.setBgz(para.getLevelBegin());
			temp.setEdz(para.getLevelEnd());
			/*temp.setInq(para.get);
			temp.setBq(bq);
			temp.setMnq(para.get);
			temp.setMxq(mxq);
			temp.setEg(para.get);*/
		//	wdinit.save(temp);
			initList.add(temp);
			
			List<DispatchConstraintItem> cons = para.getDispatchConstraints();
			if(cons != null && cons.size()>0){
				for(int k=0;k<cons.size();k++){
					DispatchConstraintItem item = cons.get(k);
					DdsRdWdcons con = new DdsRdWdcons();
					con.setProCd(schemeId);
					con.setWceId(item.getEntityId());
					con.setBgt(item.getTimeStart());
					con.setEdt(item.getTimeEnd());
					con.setZmx(item.getLevelMax());
					con.setZmn(item.getLevelMin());
					con.setQmx(item.getOutflowMax());
					con.setQmn(item.getOutflowMin());
					con.setNmx(item.getOutputMax());
					con.setNmn(item.getOutputMin());
				//	wdcon.save(con);
					consList.add(con);
				}
			}
			
		}
		
		woDisplayConvert.setInitList(initList);
		woDisplayConvert.setConsList(consList);
		/*for(DdsRdWdinit obj: initList){
			System.out.println("插入 "+obj);
			ServiceResp res = DDS_RD_WDINIT.save(obj);
			System.out.println(res.getMsg());
		}
		for(DdsRdWdcons obj: consList){
			System.out.println("插入 "+obj);
			ServiceResp res = DDS_RD_WDCONS.save(obj);
			System.out.println(res.getMsg());
		}*/
	}

	public WODisplayConvert getWoDisplayConvert() {
		return woDisplayConvert;
	}

	public void setWoDisplayConvert(WODisplayConvert woDisplayConvert) {
		this.woDisplayConvert = woDisplayConvert;
	}
}