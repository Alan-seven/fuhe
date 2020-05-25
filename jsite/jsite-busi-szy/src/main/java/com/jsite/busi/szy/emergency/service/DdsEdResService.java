package com.jsite.busi.szy.emergency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdResDao;
import com.jsite.busi.szy.emergency.po.DdsEdRes;
import com.jsite.core.mapper.JsonMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;
import com.jsite.manager.constraints.ValidateUtils;
import com.jsite.manager.constraints.Violation;

/**
 * 应急调度方案结果表Service
 * @author hjx
 * @version 2017-06-08
 */
@Service
@Transactional(readOnly = true)
public class DdsEdResService extends AbstractCrudService<DdsEdResDao, DdsEdRes> {
	
	public List<DdsEdRes> listTree(DdsEdRes ddsEdRes){
		return dao.listTree(ddsEdRes);
	}
	
	public ServiceResp removeAll(DdsEdRes entity){
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
	
	public ServiceResp insertBatch(List<DdsEdRes> ddsEdRes)throws Exception{
		ServiceResp serviceResp = new ServiceResp();
		List<Violation> violations = ValidateUtils.validate(ddsEdRes);
		if (violations.size() > 0) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_2);
			serviceResp.setMsg(JsonMapper.toJsonString(violations));
		} else {
			try{
				int num = this.dao.insertBatch(ddsEdRes);
				if(num==ddsEdRes.size()){
					serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
					serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
				}else{
					serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
					serviceResp.setMsg("保存计算结果出错！");
				}
			}catch (Exception e) {
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg("保存应急调度方案结果边界数据出错！");
			}
				
		}
		return serviceResp;
	}
	
	public List<DdsEdRes> findTimeBySecId(DdsEdRes ddsEdRes){
		return this.dao.findTimeBySecId(ddsEdRes);
	}
}