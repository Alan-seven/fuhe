package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdRelDataitemRsltDao;
import com.jsite.busi.szy.formal.po.TSfrdRelDataitemRslt;
import com.jsite.manager.AbstractCrudService;

/**
 * 常规调度结果与模型输出关系Service
 * @author 常规调度结果与模型输出关系
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdRelDataitemRsltService extends AbstractCrudService<TSfrdRelDataitemRsltDao, TSfrdRelDataitemRslt> {

	
}