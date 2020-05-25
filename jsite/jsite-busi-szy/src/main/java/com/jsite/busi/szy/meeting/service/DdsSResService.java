package com.jsite.busi.szy.meeting.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.meeting.dao.DdsSResDao;
import com.jsite.busi.szy.meeting.po.DdsSRes;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;

/**
 * 会商材料Service
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Service
@Transactional(readOnly = true)
public class DdsSResService extends AbstractCrudService<DdsSResDao, DdsSRes> {
	
	public DdsSRes getByResId(String resId){
		return dao.getByResId(resId);
	}
	
	public ServiceResp updateByResId(DdsSRes ddsSRes){
		ServiceResp serviceResp = new ServiceResp();
		try {
			dao.update(ddsSRes);
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
		} catch (Exception e) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
		}
		return serviceResp;
	}
	
}