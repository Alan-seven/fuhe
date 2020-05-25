package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdWtrplanVerRsltDao;
import com.jsite.busi.szy.formal.po.TSfrdWtrplanVerRslt;
import com.jsite.manager.AbstractCrudService;

/**
 * 用水计划核定结果Service
 * @author 用水计划核定结果
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdWtrplanVerRsltService extends AbstractCrudService<TSfrdWtrplanVerRsltDao, TSfrdWtrplanVerRslt> {

	
}