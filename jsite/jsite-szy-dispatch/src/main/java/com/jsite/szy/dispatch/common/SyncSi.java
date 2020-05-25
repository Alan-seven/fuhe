package com.jsite.szy.dispatch.common;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.jsite.busi.szy.sys.service.DeptInfoService;
import com.jsite.busi.szy.sys.service.UserInfoService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.spring.SpringContextHolder;
import com.jsite.dao.sys.po.DeptInfo;

import cn.com.dhcc.uums.service.uums.DepInfo;
import cn.com.dhcc.uums.service.uums.UserInfo;
import cn.com.dhcc.uums.service.uums.UumsServiceImplService;
import cn.com.dhcc.uums.service.uums.UumsServiceImplServiceLocator;
import cn.com.dhcc.uums.service.uums.UumsServiceImplServiceSoapBindingStub;

/**
 * 从支撑平台中同步部门信息和用户信息
 * @author admin
 *
 */
public class SyncSi implements Job{

	private static DeptInfoService ddsSysDepinfoService = SpringContextHolder.getBean(DeptInfoService.class);
	private static  UserInfoService ddsSysUserinfoService = SpringContextHolder.getBean(UserInfoService.class);
	private int n1;
	
	
	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	/**
	 * 从支撑平台中同步部门信息
	 * @throws RemoteException 
	 */
	public void syncDept() {
		try {
			UumsServiceImplService uumsService =  new UumsServiceImplServiceLocator();
			UumsServiceImplServiceSoapBindingStub binding = (UumsServiceImplServiceSoapBindingStub)uumsService.getUumsServiceImplPort();
			DepInfo[] depInfo = binding.getDepInfoList();
			//判断部门信息是否为空
			if(null!=depInfo){
				for(DepInfo info : depInfo){
					DeptInfo entity = new DeptInfo();
					entity = BeanMapper.map(info, entity.getClass());
					if(StringUtils.isNotBlank(entity.getDepCode())){
						DeptInfo di = ddsSysDepinfoService.get(entity.getDepCode());
						if(null!=di){
							//更新系统部门信息
							ddsSysDepinfoService.update(entity);
						}else{
							//保存系统部门信息
							ddsSysDepinfoService.save(entity);
						}
					}
				}
			}
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 同步用户信息
	 */
	public void syncUser(){
		try {
			UumsServiceImplService uumsService =  new UumsServiceImplServiceLocator();
			UumsServiceImplServiceSoapBindingStub binding = (UumsServiceImplServiceSoapBindingStub)uumsService.getUumsServiceImplPort();
			UserInfo[] userInfo = binding.getUserInfoList();
			if(null!=userInfo){
				for(UserInfo info : userInfo){
					com.jsite.dao.sys.po.DdsSysUserinfo entity = new com.jsite.dao.sys.po.DdsSysUserinfo();
					entity = BeanMapper.map(info, entity.getClass());
					if(StringUtils.isNotBlank(entity.getUserCode())){
						com.jsite.dao.sys.po.DdsSysUserinfo ui = ddsSysUserinfoService.get(entity.getUserCode());
						if(null != ui){
							//更新系统用户信息
							ddsSysUserinfoService.update(entity);
						}else{
							//保存系统用户信息
							ddsSysUserinfoService.save(entity);
						}
					}
				}
			}
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(JobExecutionContext context) {
		try {
			syncDept();
			syncUser();
		} catch (Exception e) {
		   e.printStackTrace();
		}
	}

}
