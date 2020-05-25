package com.jsite.busi.szy.formal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfmmEnBDao;
import com.jsite.busi.szy.formal.dao.TSfrdIfInitcondDao;
import com.jsite.busi.szy.formal.po.TSfmmEnB;
import com.jsite.busi.szy.formal.po.TSfrdIfInitcond;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;

/**
 * 来水预报初始条件Service
 * @author 来水预报初始条件
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdIfInitcondService extends AbstractCrudService<TSfrdIfInitcondDao, TSfrdIfInitcond> {

	@Autowired
	private TSfmmEnBService tSfmmEnBService;
	
	public List<TSfrdIfInitcond> list(TSfrdIfInitcond entity){
		List<TSfrdIfInitcond> list =  dao.list(entity);
		if(list.size() <= 0){
			initSave(entity.getProCd());
			list =  dao.list(entity);
		}
		return list;
	}
	
	/**
	 * 初始化来水预测基础数据
	 * @param proCd
	 * @return
	 */
	public ServiceResp initSave(String proCd){
		ServiceResp serviceResp = new ServiceResp();
		TSfmmEnB enb = new TSfmmEnB();
		enb.setRegionCd("000000F090500001");
		enb.setEnTp("05");
		List<TSfmmEnB> enbList = tSfmmEnBService.list(enb);
		TSfrdIfInitcond initcond = new TSfrdIfInitcond();
		initcond.setProCd(proCd);
		for(TSfmmEnB entity : enbList){
			initcond.setEnCd(entity.getEnCd());
			initcond.setForPattern("0");
			//代表未完成
			initcond.setIfFreq(0);
			initcond.setIsFnsh("0");
			try {
				dao.save(initcond);
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