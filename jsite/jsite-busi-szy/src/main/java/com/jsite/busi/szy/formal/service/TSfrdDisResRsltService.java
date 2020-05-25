package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdDisResRsltDao;
import com.jsite.busi.szy.formal.po.TSfrdDisResRslt;
import com.jsite.manager.AbstractCrudService;

/**
 * 水量调节计算水库结果Service
 * @author 水量调节计算水库结果
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdDisResRsltService extends AbstractCrudService<TSfrdDisResRsltDao, TSfrdDisResRslt> {
	
}