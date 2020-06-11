package com.jsite.busi.szy.formal.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdWsaRsltDao;
import com.jsite.busi.szy.formal.po.TSfrdWsaInitcond;
import com.jsite.busi.szy.formal.po.TSfrdWsaRslt;
import com.jsite.busi.szy.formal.po.TSfrdWsaWt;
import com.jsite.busi.szy.formal.po.TSfrdWtrplanInitcond;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;

/**
 * 可供水量计算结果Service
 * @author 可供水量计算结果
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdWsaRsltService extends AbstractCrudService<TSfrdWsaRsltDao, TSfrdWsaRslt> {

	/**
	 * 保存计算结果
	 * @param initcond 申报水量
	 * @param wt	用水参数
	 * @param condList 用水系数
	 * @return
	 */
	public ServiceResp saveResult(TSfrdWtrplanInitcond initcond,TSfrdWsaWt wt,List<TSfrdWsaInitcond>  condList){
		ServiceResp serviceResp = new ServiceResp();
		Float indw = (initcond.getWw())*(wt.getIndWt());
		Float agrw = (initcond.getWw())*(wt.getAgrWt());
		Float lifw = (initcond.getWw())*(wt.getLifWt());
		Float fafrw = (initcond.getWw())*(wt.getFafrWt());
		
		//保存计算结果
		TSfrdWsaRslt rslt = new TSfrdWsaRslt();
		rslt.setProCd(initcond.getProCd());
		rslt.setEnCd(initcond.getEnCd());
		dao.remove(rslt);
		for(TSfrdWsaInitcond cond : condList){
			rslt.setTm(cond.getTm());
			rslt.setIndw(getRslt(3,indw * (cond.getIndr())));
			rslt.setAgrw(getRslt(3, agrw * (cond.getAgrr())));
			rslt.setLifw(getRslt(3, lifw * (cond.getLifr())));
			rslt.setFafrw(getRslt(3, fafrw * (cond.getFafrr())));
			try {
				dao.save(rslt);
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
			} catch (Exception e) {
				logger.error(e.getCause().getMessage());
				e.printStackTrace();
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
			}
		}
		
		return serviceResp;
	}
	
	/**
	 * 保留三位小数
	 * @param newScale
	 * @param target
	 * @return
	 */
	public double getRslt(int newScale,double target){
		BigDecimal b = new BigDecimal(target);
		return b.setScale(newScale, BigDecimal.ROUND_HALF_UP).doubleValue();        
	}
	
}