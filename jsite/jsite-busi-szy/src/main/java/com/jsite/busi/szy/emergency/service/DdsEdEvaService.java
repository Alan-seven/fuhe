package com.jsite.busi.szy.emergency.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdEvaDao;
import com.jsite.busi.szy.emergency.po.DdsEdEva;
import com.jsite.manager.AbstractCrudService;

/**
 * 应急调度方案结果评价表Service
 * @author hjx
 * @version 2017-06-08
 */
@Service
@Transactional(readOnly = true)
public class DdsEdEvaService extends AbstractCrudService<DdsEdEvaDao, DdsEdEva> {

	public DdsEdEva getMaxMIn(DdsEdEva ddsEdEva){
		return dao.getMaxMIn(ddsEdEva);
	}
	
}