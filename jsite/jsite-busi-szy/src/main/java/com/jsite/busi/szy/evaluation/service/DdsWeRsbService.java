package com.jsite.busi.szy.evaluation.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.evaluation.dao.DdsWeRsbDao;
import com.jsite.busi.szy.evaluation.po.DdsWeRsb;
import com.jsite.manager.AbstractCrudService;

/**
 * 水资源评价水库基本信息表2Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWeRsbService extends AbstractCrudService<DdsWeRsbDao, DdsWeRsb> {
	
}