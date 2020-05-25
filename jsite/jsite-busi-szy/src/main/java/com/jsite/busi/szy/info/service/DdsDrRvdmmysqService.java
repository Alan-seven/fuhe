package com.jsite.busi.szy.info.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.info.dao.DdsDrRvdmmysqDao;
import com.jsite.busi.szy.info.po.DdsDrRvdmmysq;
import com.jsite.manager.AbstractCrudService;

/**
 * 水位流量年月旬均值系列表Service
 * @author hjx
 * @version 2017-11-30
 */
@Service
@Transactional(readOnly = true)
public class DdsDrRvdmmysqService extends AbstractCrudService<DdsDrRvdmmysqDao, DdsDrRvdmmysq>{

}
