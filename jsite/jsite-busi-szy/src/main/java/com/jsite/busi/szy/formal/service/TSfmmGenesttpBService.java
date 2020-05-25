package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfmmGenesttpBDao;
import com.jsite.busi.szy.formal.po.TSfmmGenesttpB;
import com.jsite.manager.AbstractCrudService;

/**
 * 概化测站类型信息Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfmmGenesttpBService extends AbstractCrudService<TSfmmGenesttpBDao,  TSfmmGenesttpB> {

}
