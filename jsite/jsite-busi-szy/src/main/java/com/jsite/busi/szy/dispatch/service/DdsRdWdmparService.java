package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.dispatch.dao.DdsRdWdmparDao;
import com.jsite.busi.szy.dispatch.po.DdsRdWdmpar;

/**
 * 需水预测逐月分配系数表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdWdmparService extends AbstractCrudService<DdsRdWdmparDao, DdsRdWdmpar> {
	
}