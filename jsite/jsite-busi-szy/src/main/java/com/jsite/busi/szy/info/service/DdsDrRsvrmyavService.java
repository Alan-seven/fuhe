package com.jsite.busi.szy.info.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.info.dao.DdsDrRsvrmyavDao;
import com.jsite.busi.szy.info.po.DdsDrRsvrmyav;
import com.jsite.manager.AbstractCrudService;

/**
 * 水库 水位、入库流量、出库流量年月旬均值系列表Service
 * @author hjx
 * @version 2017-11-30
 */
@Service
@Transactional(readOnly = true)
public class DdsDrRsvrmyavService extends AbstractCrudService<DdsDrRsvrmyavDao, DdsDrRsvrmyav>{

}
