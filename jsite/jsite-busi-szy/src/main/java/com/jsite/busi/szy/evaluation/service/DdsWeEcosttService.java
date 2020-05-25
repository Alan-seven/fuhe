package com.jsite.busi.szy.evaluation.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.evaluation.dao.DdsWeEcosttDao;
import com.jsite.busi.szy.evaluation.po.DdsWeEcostt;
import com.jsite.manager.AbstractCrudService;

/**
 * 经济社会指标信息表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWeEcosttService extends AbstractCrudService<DdsWeEcosttDao, DdsWeEcostt> {
	
}