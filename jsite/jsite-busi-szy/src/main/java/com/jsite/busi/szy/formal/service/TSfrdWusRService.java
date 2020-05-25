package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdWusRDao;
import com.jsite.busi.szy.formal.po.TSfrdWusR;
import com.jsite.manager.AbstractCrudService;

/**
 * 调度区域实际用水结果Service
 * @author 调度区域实际用水结果
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdWusRService extends AbstractCrudService<TSfrdWusRDao, TSfrdWusR> {

}