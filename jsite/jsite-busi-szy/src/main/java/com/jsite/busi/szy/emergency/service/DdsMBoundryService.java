package com.jsite.busi.szy.emergency.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsMBoundryDao;
import com.jsite.busi.szy.emergency.po.DdsMBoundry;
import com.jsite.manager.AbstractCrudService;

/**
 * 河流模型边界表Service
 * @author hjx
 * @version 2017-06-12
 */
@Service
@Transactional(readOnly = true)
public class DdsMBoundryService extends AbstractCrudService<DdsMBoundryDao, DdsMBoundry> {
	
}