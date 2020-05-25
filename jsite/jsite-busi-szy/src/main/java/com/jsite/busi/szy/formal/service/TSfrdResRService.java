package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdResRDao;
import com.jsite.busi.szy.formal.po.TSfrdResR;
import com.jsite.manager.AbstractCrudService;

/**
 * 水库实际调节过程Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfrdResRService extends AbstractCrudService<TSfrdResRDao,   TSfrdResR> {

}
