package com.jsite.busi.szy.emergency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdRsvDao;
import com.jsite.busi.szy.emergency.po.DdsEdRsv;
import com.jsite.core.mapper.JsonMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;
import com.jsite.manager.constraints.ValidateUtils;
import com.jsite.manager.constraints.Violation;

/**
 * 应急调度水库调节方式Service
 * @author hjx
 * @version 2017-06-12
 */
@Service
@Transactional(readOnly = true)
public class DdsEdRsvService extends AbstractCrudService<DdsEdRsvDao, DdsEdRsv> {
	
	/**
	 * 修改方案对象的加大值数据
	 * @param ddsEdRsv
	 * @return
	 */
	public ServiceResp updateExq(DdsEdRsv ddsEdRsv){
		ServiceResp serviceResp = new ServiceResp();
		try {
			dao.updateExq(ddsEdRsv);
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
		} catch (Exception e) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
		}
		return serviceResp;
	}
	
	//删除方案对象的所有数据
	public ServiceResp removeAll(DdsEdRsv entity){
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
	
	/**
	 * 把方案空值对象  加大值数据 设为0
	 * @param ddsEdRsv
	 * @return
	 */
	public ServiceResp updateDefault(DdsEdRsv ddsEdRsv){
		ServiceResp serviceResp = new ServiceResp();
		try {
			dao.updateDefault(ddsEdRsv);
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
		} catch (Exception e) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
		}
		return serviceResp;
	}
}