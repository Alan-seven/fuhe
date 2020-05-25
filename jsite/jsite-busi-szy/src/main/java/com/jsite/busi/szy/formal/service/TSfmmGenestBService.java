package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfmmGenestBDao;
import com.jsite.busi.szy.formal.po.TSfmmGenestB;
import com.jsite.manager.AbstractCrudService;

/**
 * 概化测站基本信息Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfmmGenestBService extends AbstractCrudService< TSfmmGenestBDao,   TSfmmGenestB> {

}
