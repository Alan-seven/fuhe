package com.jsite.busi.szy.emergency.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdEvaDetDao;
import com.jsite.busi.szy.emergency.po.DdsEdEvaDet;
import com.jsite.manager.AbstractCrudService;

/**
 * 应急调度方案结果评价详情表Service
 * @author hjx
 * @version 2017-06-08
 */
@Service
@Transactional(readOnly = true)
public class DdsEdEvaDetService extends AbstractCrudService<DdsEdEvaDetDao, DdsEdEvaDet> {
	
}