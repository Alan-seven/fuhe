package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdDisWusRsltDao;
import com.jsite.busi.szy.formal.po.TSfrdDisWusRslt;
import com.jsite.manager.AbstractCrudService;

/**
 * 水量调节计算用水单元结果Service
 * @author 水量调节计算用水单元结果
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdDisWusRsltService extends AbstractCrudService<TSfrdDisWusRsltDao, TSfrdDisWusRslt> {
	
}