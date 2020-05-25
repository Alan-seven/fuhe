package com.jsite.busi.szy.formal.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdWsaInitcondDao;
import com.jsite.busi.szy.formal.po.TSfmmDisWu;
import com.jsite.busi.szy.formal.po.TSfmmEnB;
import com.jsite.busi.szy.formal.po.TSfrdDisWu;
import com.jsite.busi.szy.formal.po.TSfrdPro;
import com.jsite.busi.szy.formal.po.TSfrdWsaInitcond;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;

/**
 * 需水预测逐月用水系数初始条件Service
 * @author 需水预测逐月用水系数初始条件
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdWsaInitcondService extends AbstractCrudService<TSfrdWsaInitcondDao, TSfrdWsaInitcond> {

	@Autowired
	private TSfrdProService tSfrdProService;
	
	@Autowired
	private TSfmmEnBService tSfmmEnBService;
	
	@Autowired
	private TSfmmDisWuService tSfmmDisWuService;
	
	/**
	 * 根据方案编码查询逐月用水系数
	 * @param proCd
	 * @return
	 */
	public List<TSfrdWsaInitcond> listByProCd(String proCd){
		TSfrdWsaInitcond initcond = new TSfrdWsaInitcond();
		initcond.setProCd(proCd);
		List<TSfrdWsaInitcond> list = dao.list(initcond);
		if(list.size() <= 0){
			initSave(proCd);
			list = dao.list(initcond);
		}
		return list;
	}
	
	/**
	 * 逐月分水系数初始化
	 * @param proCd
	 * @return
	 */
	public ServiceResp initSave(String proCd){
		ServiceResp serviceResp = new ServiceResp();
		TSfrdPro pro = tSfrdProService.get(proCd);
		TSfmmEnB enb = new TSfmmEnB();
		enb.setRegionCd("000000F090500001");
		enb.setEnTp("12");
		List<TSfmmEnB> enbList = tSfmmEnBService.list(enb);
		List<TSfmmDisWu> wuList = tSfmmDisWuService.list(new TSfmmDisWu());
		
		TSfrdWsaInitcond initcond = new TSfrdWsaInitcond();
		initcond.setProCd(proCd);
		dao.remove(initcond);
		for(TSfmmEnB entity : enbList){
			initcond.setEnCd(entity.getEnCd());
			Calendar cal = Calendar.getInstance();
			cal.clear();
			cal.setTime(pro.getBgDt());
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			for(TSfmmDisWu diswu : wuList){
				cal.set(Calendar.MONTH, diswu.getMnth()-1 );
				initcond.setTm(cal.getTime());
				//复制数据
				initcond.setAgrr((double)diswu.getAgrWusWt());
				initcond.setLifr((double)diswu.getLifWusWt());
				initcond.setFafrr((double)diswu.getFafrWusWt());
				initcond.setIndr((double)diswu.getIndWusWt());
				try {
					dao.save(initcond);
					serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
					serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
				} catch (Exception e) {
					serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
					serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
				}
			}
		}
		return serviceResp;
	}
	
	/**
	 * 根据方案编码查询逐月用水系数
	 * @param proCd
	 * @return
	 */
	public List<TSfrdWsaInitcond> listParams(String proCd ,String enCd){
		TSfrdWsaInitcond initcond = new TSfrdWsaInitcond();
		initcond.setProCd(proCd);
		initcond.setEnCd(enCd);
		return dao.list(initcond);
	}
	
}