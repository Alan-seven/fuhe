package com.jsite.busi.szy.formal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdWsaWtDao;
import com.jsite.busi.szy.formal.po.TSfmmWsaWt;
import com.jsite.busi.szy.formal.po.TSfrdPro;
import com.jsite.busi.szy.formal.po.TSfrdWsaWt;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;

/**
 * 需水预测用水权重指标Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfrdWsaWtService extends AbstractCrudService<TSfrdWsaWtDao,TSfrdWsaWt>{

	@Autowired
	private TSfmmWsaWtService tSfmmWsaWtService;
	@Autowired
	private TSfrdProService tSfrdProService;
	
	/**
	 * 根据方案编码查询用水参数
	 * @param proCd
	 * @return
	 */
	public List<TSfrdWsaWt> listByProCd(String proCd){
		TSfrdWsaWt wsawt = new TSfrdWsaWt();
		wsawt.setProCd(proCd);
		List<TSfrdWsaWt> list = dao.list(wsawt);
		if(list.size() <= 0){
			initSave(proCd);
			list = dao.list(wsawt);
		}
		return list;
	}
	
	public ServiceResp initSave(String proCd){
		ServiceResp serviceResp = new ServiceResp();
		TSfrdWsaWt wt = new TSfrdWsaWt();
		wt.setProCd(proCd);
		dao.remove(wt);
		TSfrdPro pro = tSfrdProService.get(proCd);
		TSfmmWsaWt wsawt = new TSfmmWsaWt();
		wsawt.setYr(Integer.parseInt(pro.getYear()));
		wsawt.setRate(0.95f);
		List<TSfmmWsaWt> list = tSfmmWsaWtService.list(wsawt);
		
		try{
			for(TSfmmWsaWt entity : list){
				wt.setEnCd(entity.getEnCd());
				wt.setIndWt(entity.getIndwt());
				wt.setAgrWt(entity.getAgrwt());
				wt.setLifWt(entity.getLifwt());
				wt.setFafrWt(entity.getFafrwt());
				dao.save(wt);
			}
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
		} catch (Exception e) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
		}
		return serviceResp;
	}
	
	/**
	 * 得到实体对应的用水参数
	 * @param proCd
	 * @param enCd
	 * @return
	 */
	public TSfrdWsaWt getEntity(String proCd,String enCd){
		TSfrdWsaWt wsawt = new TSfrdWsaWt();
		wsawt.setProCd(proCd);
		wsawt.setEnCd(enCd);
		return dao.get(wsawt);
	}
}
