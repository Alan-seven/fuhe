package com.jsite.busi.szy.formal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdDisWusRsltDao;
import com.jsite.busi.szy.formal.po.TSfrdDisWusRslt;
import com.jsite.core.mapper.JsonMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;
import com.jsite.manager.constraints.ValidateUtils;
import com.jsite.manager.constraints.Violation;

/**
 * 水量调节计算用水单元结果Service
 * @author 水量调节计算用水单元结果
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdDisWusRsltService extends AbstractCrudService<TSfrdDisWusRsltDao, TSfrdDisWusRslt> {
	
	public ServiceResp saveAll(List<TSfrdDisWusRslt> list){
		ServiceResp serviceResp = new ServiceResp();
		for(TSfrdDisWusRslt entity : list){
			try {
				dao.save(entity);
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
			} catch (Exception e) {
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
			}
		}
		return serviceResp;
	}
	
	public ServiceResp remove(TSfrdDisWusRslt entity) {
		ServiceResp serviceResp = new ServiceResp();
		try {
			dao.remove(entity);
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
		} catch (Exception e) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
		}
		return serviceResp;
	}
	
}