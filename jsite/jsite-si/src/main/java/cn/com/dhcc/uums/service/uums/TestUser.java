package cn.com.dhcc.uums.service.uums;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.junit.Test;

import junit.framework.TestCase;

public class TestUser extends TestCase {

	@Test 
	public void testUser(){
		try {
			UumsServiceImplService uumsService =  new UumsServiceImplServiceLocator();
			UumsServiceImplServiceSoapBindingStub binding = (UumsServiceImplServiceSoapBindingStub)uumsService.getUumsServiceImplPort();
			UserInfo[] userInfo = binding.getUserInfoList();
			if(null!=userInfo){
				for(UserInfo info : userInfo){
					System.out.println(info.getUserCode()+"----"+info.getUserName());
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
	
	@Test
	public void testUnit(){
		/*try {
			UumsServiceImplService uumsService =  new UumsServiceImplServiceLocator();
			UumsServiceImplServiceSoapBindingStub binding = (UumsServiceImplServiceSoapBindingStub)uumsService.getUumsServiceImplPort();
			DepInfo[] depInfo = binding.getDepInfoList();
			//判断部门信息是否为空
			if(null!=depInfo){
				for(DepInfo info : depInfo){
					System.out.println(info.getDepCode()+"----"+info.getDepName());
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
		}*/
	}
}
