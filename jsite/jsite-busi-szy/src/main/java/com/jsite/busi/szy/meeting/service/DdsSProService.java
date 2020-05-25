package com.jsite.busi.szy.meeting.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.po.DdsEdRsv;
import com.jsite.busi.szy.meeting.dao.DdsSProDao;
import com.jsite.busi.szy.meeting.po.DdsSPro;
import com.jsite.core.mapper.JsonMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;
import com.jsite.manager.constraints.ValidateUtils;
import com.jsite.manager.constraints.Violation;

/**
 * 会商方案Service
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Service
@Transactional(readOnly = true)
public class DdsSProService extends AbstractCrudService<DdsSProDao, DdsSPro> {

	public ServiceResp removeAll(DdsSPro entity){
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