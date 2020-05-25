package com.jsite.busi.szy.emergency.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdMedelDao;
import com.jsite.busi.szy.emergency.po.DdsEdMedel;
import com.jsite.manager.AbstractCrudService;

/**
 * 应急调度模型参数表Service
 * @author hjx
 * @version 2017-06-12
 */
@Service
@Transactional(readOnly = true)
public class DdsEdMedelService extends AbstractCrudService<DdsEdMedelDao, DdsEdMedel> {
	
}