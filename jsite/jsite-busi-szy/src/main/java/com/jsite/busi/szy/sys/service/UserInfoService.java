package com.jsite.busi.szy.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.dao.sys.DdsSysUserinfoDao;
import com.jsite.dao.sys.po.DdsSysUserinfo;
import com.jsite.dao.sys.po.User;
import com.jsite.manager.AbstractCrudService;


/**
 * 人员信息表Service
 * @author hjx
 * @version 2017-09-12
 */
@Service
@Transactional(readOnly = true)
public class UserInfoService extends AbstractCrudService<DdsSysUserinfoDao, DdsSysUserinfo> {
	
	/**
	 * 插入用户角色关联数据
	 * 
	 * @param user
	 * @return
	 */
	public ServiceResp saveUserDORole(DdsSysUserinfo ddsSysUserinfo){
		ServiceResp serviceResp = new ServiceResp();
		try {
			this.dao.deleteUserRole(ddsSysUserinfo);
			this.dao.saveUserDORole(ddsSysUserinfo);
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
		} catch (Exception e) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
		}
		return serviceResp;
	}
	
}