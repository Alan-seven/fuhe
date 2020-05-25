package com.jsite.busi.szy.evaluation.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.evaluation.dao.DdsWeRsywDao;
import com.jsite.busi.szy.evaluation.po.DdsWeRsyw;
import com.jsite.manager.AbstractCrudService;
/**
 * 水库年蓄水量表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWeRsywService extends AbstractCrudService<DdsWeRsywDao, DdsWeRsyw> {
	
}