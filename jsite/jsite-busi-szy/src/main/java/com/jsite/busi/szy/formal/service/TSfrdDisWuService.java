package com.jsite.busi.szy.formal.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdDisWuDao;
import com.jsite.busi.szy.formal.po.TSfmmDisWu;
import com.jsite.busi.szy.formal.po.TSfmmEnB;
import com.jsite.busi.szy.formal.po.TSfrdDisWu;
import com.jsite.busi.szy.formal.po.TSfrdPro;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.manager.AbstractCrudService;

import net.sf.cglib.beans.BeanMap;

/**
 * 水量分配用水系数Service
 * @author 
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdDisWuService extends AbstractCrudService<TSfrdDisWuDao,TSfrdDisWu>{
	
	@Autowired
	private TSfrdProService tSfrdProService;
	
	@Autowired
	private TSfmmEnBService tSfmmEnBService;
	
	@Autowired
	private TSfmmDisWuService tSfmmDisWuService;
	
	/**
	 * 根据实体代码分组
	 * @param entity
	 * @return
	 */
	public List<TSfrdDisWu> listByEncd(String proCd){
		TSfrdDisWu entity = new TSfrdDisWu();
		entity.setProCd(proCd);
		List<TSfrdDisWu> list = dao.listByEncd(entity);
		if(list.size() <= 0){
			initSave(proCd);
			list = dao.listByEncd(entity);
		}
		return list;
	}
	
	/**
	 * 初始化用水系数，回归系数
	 * @param proCd
	 * @return
	 */
	public ServiceResp initSave(String proCd){
		ServiceResp serviceResp = new ServiceResp();
		TSfmmEnB enb = new TSfmmEnB();
		enb.setRegionCd("000000F090500001");
		enb.setEnTp("12");
		List<TSfmmEnB> enbList = tSfmmEnBService.list(enb);
		List<TSfmmDisWu> wuList = tSfmmDisWuService.list(new TSfmmDisWu());
		
		TSfrdPro pro = tSfrdProService.get(proCd);
		TSfrdDisWu wu = new TSfrdDisWu();
		wu.setProCd(proCd);
		dao.remove(wu);
		for(TSfmmEnB entity : enbList){
			wu.setEnCd(entity.getEnCd());
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
				wu.setTm(cal.getTime());
				//回归系数
				wu.setIndReWt(diswu.getIndReWt());
				wu.setAgrReWt(diswu.getAgrReWt());
				wu.setLifReWt(diswu.getLifReWt());
				wu.setFafrReWt(diswu.getFafrReWt());
				//用水系数
				wu.setIndWusWt(diswu.getIndWusWt());
				wu.setAgrWusWt(diswu.getAgrWusWt());
				wu.setLifWusWt(diswu.getLifWusWt());
				wu.setFafrWusWt(diswu.getFafrWusWt());
				
				try {
					dao.save(wu);
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
	
}
