package com.jsite.busi.szy.emergency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdGisDao;
import com.jsite.busi.szy.emergency.po.DdsEdGis;
import com.jsite.core.mapper.JsonMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;
import com.jsite.manager.constraints.ValidateUtils;
import com.jsite.manager.constraints.Violation;

/**
* 应急调度模型计算地图结果DAO接口Service
* @author hjx
* @version 2017-06-12
*/
@Service
@Transactional(readOnly = true)
public class DdsEdGisService extends AbstractCrudService<DdsEdGisDao, DdsEdGis>{

	public ServiceResp removeAll(DdsEdGis entity){
		ServiceResp serviceResp = new ServiceResp();
		try {
			dao.removeAll(entity);
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
		} catch (Exception e) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
		}
		return serviceResp;
	}
	
	public List<DdsEdGis> findTime(DdsEdGis ddsEdGis){
		return this.dao.findTime(ddsEdGis);
	}
	
	//批量插入
	public ServiceResp insertBatch(List<DdsEdGis> listData)throws Exception{
		ServiceResp serviceResp = new ServiceResp();
		List<Violation> violations = ValidateUtils.validate(listData);
		if (violations.size() > 0) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_2);
			serviceResp.setMsg(JsonMapper.toJsonString(violations));
		} else {
				int num = this.dao.insertBatch(listData);
				if(num==listData.size()){
					serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
					serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
				}else{
					serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
					serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
				}
		}
		return serviceResp;
	}
}
