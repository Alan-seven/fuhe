package com.jsite.busi.szy.emergency.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.emergency.dao.DdsEdPrarDao;
import com.jsite.busi.szy.emergency.po.DdsEdPrar;

/**
 * 应急调度水库参数表Service
 * @author hjx
 * @version 2017-06-08
 */
@Service
@Transactional(readOnly = true)
public class DdsEdPrarService extends AbstractCrudService<DdsEdPrarDao, DdsEdPrar> {
	
}