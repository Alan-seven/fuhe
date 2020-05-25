package com.jsite.busi.szy.formal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdWsaWtDao;
import com.jsite.busi.szy.formal.po.TSfmmEnB;
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
	private TSfmmEnBService tSfmmEnBService;
	
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
		TSfmmEnB enb = new TSfmmEnB();
		enb.setRegionCd("000000F090500001");
		enb.setEnTp("12");
		List<TSfmmEnB> enbList = tSfmmEnBService.list(enb);
		TSfrdWsaWt wt = new TSfrdWsaWt();
		wt.setProCd(proCd);
		dao.remove(wt);
		try{
			for(TSfmmEnB entity : enbList){
				if("112000023".equals(entity.getEnCd())){
					wt.setEnCd(entity.getEnCd());
					wt.setIndWt(0.021f);
					wt.setAgrWt(0.83f);
					wt.setLifWt(0.082f);
					wt.setFafrWt(0.067f);
					dao.save(wt);
				}else if("112000024".equals(entity.getEnCd())){
					wt.setEnCd(entity.getEnCd());
					wt.setIndWt(0.05f);
					wt.setAgrWt(0.643f);
					wt.setLifWt(0.087f);
					wt.setFafrWt(0.22f);
					dao.save(wt);
				}else if("112000025".equals(entity.getEnCd())){
					wt.setEnCd(entity.getEnCd());
					wt.setIndWt(0.032f);
					wt.setAgrWt(0.714f);
					wt.setLifWt(0.076f);
					wt.setFafrWt(0.178f);
					dao.save(wt);
				}else if("112000026".equals(entity.getEnCd())){
					wt.setEnCd(entity.getEnCd());
					wt.setIndWt(0.054f);
					wt.setAgrWt(0.782f);
					wt.setLifWt(0.117f);
					wt.setFafrWt(0.047f);
					dao.save(wt);
				}else if("112000027".equals(entity.getEnCd())){
					wt.setEnCd(entity.getEnCd());
					wt.setIndWt(0.077f);
					wt.setAgrWt(0.823f);
					wt.setLifWt(0.077f);
					wt.setFafrWt(0.023f);
					dao.save(wt);
				}else if("112000028".equals(entity.getEnCd())){
					wt.setEnCd(entity.getEnCd());
					wt.setIndWt(0.028f);
					wt.setAgrWt(0.799f);
					wt.setLifWt(0.076f);
					wt.setFafrWt(0.097f);
					dao.save(wt);
				}else if("112000029".equals(entity.getEnCd())){
					wt.setEnCd(entity.getEnCd());
					wt.setIndWt(0.232f);
					wt.setAgrWt(0.624f);
					wt.setLifWt(0.09f);
					wt.setFafrWt(0.054f);
					dao.save(wt);
				}else if("112000030".equals(entity.getEnCd())){
					wt.setEnCd(entity.getEnCd());
					wt.setIndWt(0.05f);
					wt.setAgrWt(0.81f);
					wt.setLifWt(0.07f);
					wt.setFafrWt(0.07f);
					dao.save(wt);
				}else if("112000031".equals(entity.getEnCd())){
					wt.setEnCd(entity.getEnCd());
					wt.setIndWt(0.157f);
					wt.setAgrWt(0.761f);
					wt.setLifWt(0.08f);
					wt.setFafrWt(0.002f);
					dao.save(wt);
				}else if("112000032".equals(entity.getEnCd())){
					wt.setEnCd(entity.getEnCd());
					wt.setIndWt(0.017f);
					wt.setAgrWt(0.789f);
					wt.setLifWt(0.114f);
					wt.setFafrWt(0.08f);
					dao.save(wt);
				}else if("112000033".equals(entity.getEnCd())){
					wt.setEnCd(entity.getEnCd());
					wt.setIndWt(0.017f);
					wt.setAgrWt(0.85f);
					wt.setLifWt(0.107f);
					wt.setFafrWt(0.026f);
					dao.save(wt);
				}else if("112000034".equals(entity.getEnCd())){
					wt.setEnCd(entity.getEnCd());
					wt.setIndWt(0.318f);
					wt.setAgrWt(0.554f);
					wt.setLifWt(0.089f);
					wt.setFafrWt(0.039f);
					dao.save(wt);
				}
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
