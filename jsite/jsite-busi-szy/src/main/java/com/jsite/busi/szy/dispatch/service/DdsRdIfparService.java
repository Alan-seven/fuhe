package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.dispatch.dao.DdsRdIfparDao;
import com.jsite.busi.szy.dispatch.po.DdsRdIfpar;

/**
 * 来水预报参数表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdIfparService extends AbstractCrudService<DdsRdIfparDao, DdsRdIfpar> {
	
}