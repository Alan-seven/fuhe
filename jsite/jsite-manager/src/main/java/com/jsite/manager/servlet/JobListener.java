package com.jsite.manager.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

public class JobListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//Scheduler job = (Scheduler) SpringContextHolder.getBean("quartzScheduler");
		  try {  
	            Scheduler sched =  new StdSchedulerFactory().getScheduler();  
	            if (!sched.isShutdown()) {  
	                sched.shutdown();  
	            }  
	        } catch (Exception e) {  
	        	JobExecutionException jobException =  new JobExecutionException(e); 
				jobException.setRefireImmediately(true);
				jobException.setUnscheduleAllTriggers(true);  
	            throw new RuntimeException(e);  
	            
	        }  
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}
