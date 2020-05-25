package com.jsite.busi.szy.emergency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsMRsvrDao;
import com.jsite.busi.szy.emergency.po.DdsMRsvr;
import com.jsite.core.mapper.JsonMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;
import com.jsite.manager.constraints.ValidateUtils;
import com.jsite.manager.constraints.Violation;

/**
 * 应急调度水库调节设置初始条件Service
 * @author hjx
 * @version 2017-07-10
 */
@Service
@Transactional(readOnly = true)
public class DdsMRsvrService extends AbstractCrudService<DdsMRsvrDao, DdsMRsvr> {
	
	public DdsMRsvr getByRcd(DdsMRsvr ddsMRsvr){
		return this.dao.getByRcd(ddsMRsvr);
	}
	
	public ServiceResp removeAll(DdsMRsvr entity){
		ServiceResp serviceResp = new ServiceResp();
		List<Violation> violations = ValidateUtils.validate(entity);
		if (violations.size() > 0) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_2);
			serviceResp.setMsg(JsonMapper.toJsonString(violations));
		} else {
			try {
				dao.removeAll(entity);
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
			} catch (Exception e) {
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
			}
		}
		return serviceResp;
	}
}