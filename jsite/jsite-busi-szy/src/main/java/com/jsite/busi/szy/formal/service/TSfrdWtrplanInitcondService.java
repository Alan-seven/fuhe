package com.jsite.busi.szy.formal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdWtrplanInitcondDao;
import com.jsite.busi.szy.formal.po.TSfmmWsaWt;
import com.jsite.busi.szy.formal.po.TSfrdPro;
import com.jsite.busi.szy.formal.po.TSfrdWtrplanInitcond;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;

/**
 * 需水预测申报水量Service
 * @author 需水预测申报水量
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdWtrplanInitcondService extends AbstractCrudService<TSfrdWtrplanInitcondDao, TSfrdWtrplanInitcond> {

	@Autowired
	private TSfmmWsaWtService tSfmmWsaWtService;
	@Autowired
	private TSfrdProService tSfrdProService;
	
	/**
	 * 查询实体对应的申报水量
	 * @param proCd
	 * @param enCd
	 * @return
	 */
	public TSfrdWtrplanInitcond getEntity(String proCd,String enCd){
		TSfrdWtrplanInitcond plan = new TSfrdWtrplanInitcond();
		plan.setProCd(proCd);
		plan.setEnCd(enCd);
		return dao.get(plan);
	}
	
	/**
	 * 根据方案编码查询
	 * @param proCd
	 * @return
	 */
	public List<TSfrdWtrplanInitcond> listByProCd(String proCd){
		TSfrdWtrplanInitcond plan = new TSfrdWtrplanInitcond();
		plan.setProCd(proCd);
		List<TSfrdWtrplanInitcond> list = dao.list(plan);
		if(list.size() <= 0){
			initSave(proCd);
			list = dao.list(plan);
		}
		return list;
	}
	
	public ServiceResp initSave(String proCd){
		ServiceResp serviceResp = new ServiceResp();
		TSfrdWtrplanInitcond initcond = new TSfrdWtrplanInitcond();
		initcond.setProCd(proCd);
		initcond.setPlaSrc("3");
		initcond.setIsFnsh("0");
		TSfrdPro pro = tSfrdProService.get(proCd);
		TSfmmWsaWt wsawt = new TSfmmWsaWt();
		wsawt.setYr(Integer.parseInt(pro.getYear()));
		wsawt.setRate(0.95f);
		List<TSfmmWsaWt> list = tSfmmWsaWtService.list(wsawt);
		try {
			for(TSfmmWsaWt entity : list){
				initcond.setEnCd(entity.getEnCd());
				initcond.setWw(entity.getTotalw());
				dao.save(initcond);
			}
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
		} catch (Exception e) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
		}
		return serviceResp;
	}
}