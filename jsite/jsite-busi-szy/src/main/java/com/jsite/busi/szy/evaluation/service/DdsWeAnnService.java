package com.jsite.busi.szy.evaluation.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.evaluation.dao.DdsWeAnnDao;
import com.jsite.busi.szy.evaluation.po.DdsWeAnn;
import com.jsite.manager.AbstractCrudService;

/**
 * 多年平均信息表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWeAnnService extends AbstractCrudService<DdsWeAnnDao, DdsWeAnn> {
	
}