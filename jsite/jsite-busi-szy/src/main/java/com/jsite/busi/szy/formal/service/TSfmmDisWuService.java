package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfmmDisWuDao;
import com.jsite.busi.szy.formal.po.TSfmmDisWu;
import com.jsite.manager.AbstractCrudService;

/**
 * 水量分配用水系数初始化参数表Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfmmDisWuService extends AbstractCrudService< TSfmmDisWuDao,   TSfmmDisWu>{

}
