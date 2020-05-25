package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.dispatch.dao.DdsRdIfresDao;
import com.jsite.busi.szy.dispatch.po.DdsRdIfres;

/**
 * 来水预报结果表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdIfresService extends AbstractCrudService<DdsRdIfresDao, DdsRdIfres> {
	
}