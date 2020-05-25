package com.jsite.szy.dispatch.common;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jsite.busi.szy.info.dao.DdsBResDao;
import com.jsite.busi.szy.info.po.DdsBRes;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:spring-context.xml"})  
public class TestUnit {
	    @Resource DdsBResDao ddsBResDao;  
     
	    @Test 
	    public void getListTest(){  
	    	
	    	DdsBRes res= new DdsBRes();
			//res.setZvcurveId("02zv02");//廖坊水库
			res.setResNm("廖坊水库");
			res.setResCd("1");
			
			//res.setResNm("洪门水库");
			//res.setResCd("2");
			
			List<DdsBRes> listZV =ddsBResDao.findByZV(res);//水位库容
			List<DdsBRes> listZdQ =ddsBResDao.findByZQ(res);//尾水位-下泄流量
	       
	      
		   System.out.println((SearchCurve.getVfromZ(listZV,52.1)));// 52.1,4.16;52.2,4.31 //// 52.1,520;52.2,575
		   System.out.println((SearchCurve.getZfromV(listZV,4.16)));
		   System.out.println((SearchCurve.getZDfromQ(listZdQ,520)));
	    }  
	    
	  
}
