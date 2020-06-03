package com.jsite.busi.szy.formal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdRsvrRsltDao;
import com.jsite.busi.szy.formal.po.TSfrdRsvrRslt;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;

/**
 * 水库计算结果Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfrdRsvrRsltService extends AbstractCrudService<TSfrdRsvrRsltDao, TSfrdRsvrRslt>{

	public ServiceResp saveAll(List<TSfrdRsvrRslt> list){
		ServiceResp serviceResp = new ServiceResp();
		dao.remove(list.get(0));
		for(TSfrdRsvrRslt entity : list){
			try {
				dao.save(entity);
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
			}
		}
		return serviceResp;
	}
	
}
