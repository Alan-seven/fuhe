package com.jsite.busi.szy.formal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfmmEnBDao;
import com.jsite.busi.szy.formal.po.TSfmmEnB;
import com.jsite.manager.AbstractCrudService;

/**
 * 实体基本信息Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfmmEnBService extends AbstractCrudService< TSfmmEnBDao,   TSfmmEnB> {

	/**
	 * 根据调度区域，类型查询
	 * @param regionCd
	 * @param enTp
	 * @return
	 */
	public List<TSfmmEnB> listByEnTp(String regionCd,String enTp){
		TSfmmEnB entity = new TSfmmEnB();
		entity.setRegionCd(regionCd);
		entity.setEnTp(enTp);
		return this.dao.list(entity);
	}
}
