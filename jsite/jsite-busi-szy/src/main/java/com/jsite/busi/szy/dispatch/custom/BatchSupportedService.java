package com.jsite.busi.szy.dispatch.custom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jsite.core.mapper.JsonMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.dao.AbstractBase;
import com.jsite.manager.AbstractCrudService;
import com.jsite.manager.constraints.ValidateUtils;
import com.jsite.manager.constraints.Violation;

/**
 * Service扩展 batch supported
 */
@Transactional(readOnly = true)
public abstract class BatchSupportedService<D extends BatchSupportedDAO<T>, T extends AbstractBase<T>> extends AbstractCrudService<D, T> {
	@Transactional(readOnly = false)
	public ServiceResp saveBatch(List<T> list) {
		ServiceResp serviceResp = new ServiceResp();
		List<Violation> violations = ValidateUtils.validate(list);
		if (violations.size() > 0) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_2);
			serviceResp.setMsg(JsonMapper.toJsonString(violations));
		} else {
			try {
				dao.saveBatch(list);
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
			} catch (Exception e) {
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
			}
		}
		return serviceResp;
	}
	
	public List<T> listIn(List<T> entity) {
		if(entity == null || entity.size() == 0){
			return new ArrayList<>();
		}
		return dao.listIn(entity);
	}
}
