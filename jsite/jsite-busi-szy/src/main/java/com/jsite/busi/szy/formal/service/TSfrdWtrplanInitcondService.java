package com.jsite.busi.szy.formal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdWtrplanInitcondDao;
import com.jsite.busi.szy.formal.po.TSfmmEnB;
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
	private TSfmmEnBService tSfmmEnBService;
	
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
		TSfmmEnB enb = new TSfmmEnB();
		enb.setRegionCd("000000F090500001");
		enb.setEnTp("12");
		List<TSfmmEnB> enbList = tSfmmEnBService.list(enb);
		TSfrdWtrplanInitcond initcond = new TSfrdWtrplanInitcond();
		initcond.setProCd(proCd);
		initcond.setPlaSrc("3");
		initcond.setIsFnsh("0");
		try {
			for(TSfmmEnB entity : enbList){
				initcond.setEnCd(entity.getEnCd());
				if("112000023".equals(entity.getEnCd())){
					initcond.setWw(14435.5f);
				}else if("112000024".equals(entity.getEnCd())){
					initcond.setWw(21857.2f);
				}else if("112000025".equals(entity.getEnCd())){
					initcond.setWw(23343.7f);
				}else if("112000026".equals(entity.getEnCd())){
					initcond.setWw(14143f);
				}else if("112000027".equals(entity.getEnCd())){
					initcond.setWw(3054.3f);
				}else if("112000028".equals(entity.getEnCd())){
					initcond.setWw(17585.7f);
				}else if("112000029".equals(entity.getEnCd())){
					initcond.setWw(67575.4f);
				}else if("112000030".equals(entity.getEnCd())){
					initcond.setWw(15641.7f);
				}else if("112000031".equals(entity.getEnCd())){
					initcond.setWw(20817.7f);
				}else if("112000032".equals(entity.getEnCd())){
					initcond.setWw(9416.1f);
				}else if("112000033".equals(entity.getEnCd())){
					initcond.setWw(18354.2f);
				}else if("112000034".equals(entity.getEnCd())){
					initcond.setWw(121427.1f);
				}
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