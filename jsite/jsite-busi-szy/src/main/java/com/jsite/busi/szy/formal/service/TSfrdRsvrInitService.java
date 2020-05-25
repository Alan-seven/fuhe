package com.jsite.busi.szy.formal.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdRsvrInitDao;
import com.jsite.busi.szy.formal.po.TSfmmDisWu;
import com.jsite.busi.szy.formal.po.TSfmmEnB;
import com.jsite.busi.szy.formal.po.TSfrdPro;
import com.jsite.busi.szy.formal.po.TSfrdRsvrInit;
import com.jsite.busi.szy.formal.po.TSfrdWsaInitcond;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;

/**
 * 水库初始化Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfrdRsvrInitService extends AbstractCrudService<TSfrdRsvrInitDao,   TSfrdRsvrInit> {

	@Autowired
	private TSfmmEnBService tSfmmEnBService;
	
	public List<TSfrdRsvrInit> listByProCd(String proCd){
		TSfrdRsvrInit init = new TSfrdRsvrInit();
		init.setProCd(proCd);
		List<TSfrdRsvrInit> list = dao.list(init);
		if(list.size() <= 0){
			initSave(proCd);
			list = dao.list(init);
		}
		return list;
	}
	
	public ServiceResp initSave(String proCd){
		ServiceResp serviceResp = new ServiceResp();
		TSfmmEnB enb = new TSfmmEnB();
		enb.setRegionCd("000000F090500001");
		enb.setEnTp("02");
		List<TSfmmEnB> enbList = tSfmmEnBService.list(enb);
		
		TSfrdRsvrInit init = new TSfrdRsvrInit();
		init.setProCd(proCd);
		dao.remove(init);
		for(TSfmmEnB entity : enbList){
			init.setEnCd(entity.getEnCd());
			if("102000002".equals(entity.getEnCd())){//廖坊
				init.setStz(61.43f);
				init.setStv(96.1f);
				init.setEdz(61.54f);
				init.setEdv(98.7f);
			}else if("102000000".equals(entity.getEnCd())){
				init.setStz(96.05f);
				init.setStv(316.4f);
				init.setEdz(97.57f);
				init.setEdv(393.241f);
			}
			try {
				dao.save(init);
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
