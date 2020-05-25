package org.jsite.si;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.jasig.cas.client.util.AssertionHolder;

import cn.com.dhcc.uums.service.uums.UserInfo;
import cn.com.dhcc.uums.service.uums.UumsServiceImplService;
import cn.com.dhcc.uums.service.uums.UumsServiceImplServiceLocator;
import cn.com.dhcc.uums.service.uums.UumsServiceImplServiceSoapBindingStub;

public class CasUtils {

	/**
	 * 获取当前登录账号信息
	 * @return
	 */
	public static String getUserCode(){
		String userCode = AssertionHolder.getAssertion().getPrincipal().getName();
		return userCode;
	}
	
	/**
	 * 从单点登录接口获取用户信息
	 * @return
	 */
	public static UserInfo getCurrentUser(){
		try {
			String userCode = getUserCode();
			UumsServiceImplService uumsService =  new UumsServiceImplServiceLocator();
			UumsServiceImplServiceSoapBindingStub binding = (UumsServiceImplServiceSoapBindingStub)uumsService.getUumsServiceImplPort();
			UserInfo[] ui = binding.getUserListByProperty("userCode", userCode);
			if( ui != null && ui.length > 0){
				return ui[0];
			}
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (cn.com.dhcc.uums.service.uums.ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
