package com.jsite.szy.dispatch.emergency.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jsite.busi.szy.info.dao.DdsBResDao;
import com.jsite.busi.szy.info.dao.DdsDrRiverDao;
import com.jsite.busi.szy.info.po.DdsBRes;
import com.jsite.busi.szy.info.po.DdsDrRiver;
import com.jsite.busi.szy.info.po.DdsDrRsvr;
import com.jsite.busi.szy.info.service.DdsDrRsvrService;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring-context.xml"})  
public class TestUnit {
	    @Resource DdsDrRiverDao ddsDrRiverDao;  //
	    @Resource DdsDrRsvrService ddsDrRsvrService; 
	    @Test 
	    public void getListTest(){  
	    	
	    	DdsDrRiver ddsDrRiver=new DdsDrRiver();
	    	/*62405200	沙子岭
	    	62405400 	南丰
	    	62405800	南城
	    	62401800 	廖家湾
	    	62406600 	娄家村(二)
	    	62408600 	马圩
	    	62402400 	李家渡
	    	62402600 	焦  石
	    	62402800 	柴埠口
	    	62403400 	洪门
	    	62401300	廖坊
	    	62401350	廖坊坝下*                   
	    	62310700	芦溪                   
	    	62336856	虹桥                    
	    	62310800	棚下(生态)                   
	    	62310900	宜春                   
	    	62310920	彬江                   
	    	62311200	新余                   
	    	62311470	孔目江
	    	62337940	罗坊                   
	    	62338750	(庙前)临江
	    	62310650	山口岩
	    	623R7605    	江口*/


	    	ddsDrRiver.setStcd("62338750");
	    	ddsDrRiver.setStartTime("2016-04-01 9:00");
	    	ddsDrRiver.setEndTime("2016-04-04 9:00");
	    	
	    	
			//List<DdsDrRiver> list1=ddsDrRiverDao.listRcdByFirst(ddsDrRiver);
			
			//List<DdsDrRiver> list2=ddsDrRiverDao.listRcdByTwo(ddsDrRiver);
			
			//List<DdsDrRiver> list3=ddsDrRiverDao.listRcdByFour(ddsDrRiver);
			
			//List<DdsBRes> listZV =ddsBResDao.findByZV(res);//水位库容
			//List<DdsBRes> listZdQ =ddsBResDao.findByZQ(res);//尾水位-下泄流量
		   
		 /*  System.out.println(list3.size());
		   for(int i=0;i<list3.size();i++){
			   System.out.println(list3.get(i).getInq()+"   "+list3.get(i).getInq1()+"   "+list3.get(i).getQ()+"  "+list3.get(i).getQ1()+"  "+list3.get(i).getZ());
		   }*/
	    	//DdsDrRsvr ddsDrRsvr = new DdsDrRsvr();
	    	//List<DdsDrRsvr> Rsvr=ddsDrRsvrService.listByStcd(ddsDrRsvr);// 水库水情
	    	
	    	List<DdsDrRiver> Rsvr=ddsDrRiverDao.listByStcd(ddsDrRiver); // 河道水情
	    	System.out.println(Rsvr.size());
			   for(int i=0;i<Rsvr.size();i++){
				   System.out.println(Rsvr.get(i).getQ());
			  }
		   
	    }  
	    
	   
}
