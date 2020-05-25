package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdWtrplanRsltDao;
import com.jsite.busi.szy.formal.po.TSfrdWtrplanRslt;
import com.jsite.manager.AbstractCrudService;

/**
 * 用水计划结果Service
 * @author 用水计划结果
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdWtrplanRsltService extends AbstractCrudService<TSfrdWtrplanRsltDao, TSfrdWtrplanRslt> {

	
}