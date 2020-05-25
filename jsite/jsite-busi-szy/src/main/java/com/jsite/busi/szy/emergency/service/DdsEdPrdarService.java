package com.jsite.busi.szy.emergency.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdPrdarDao;
import com.jsite.busi.szy.emergency.po.DdsEdPrdar;
import com.jsite.manager.AbstractCrudService;

/**
 * 应急调度水库时段参数表Service
 * @author hjx
 * @version 2017-06-08
 */
@Service
@Transactional(readOnly = true)
public class DdsEdPrdarService extends AbstractCrudService<DdsEdPrdarDao, DdsEdPrdar> {
	
}