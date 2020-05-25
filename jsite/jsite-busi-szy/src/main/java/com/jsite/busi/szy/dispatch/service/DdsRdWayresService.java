package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.dispatch.dao.DdsRdWayresDao;
import com.jsite.busi.szy.dispatch.po.DdsRdWayres;

/**
 * 水量分配年表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdWayresService extends AbstractCrudService<DdsRdWayresDao, DdsRdWayres> {
	
}