package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdDisAdRsltDao;
import com.jsite.busi.szy.formal.po.TSfrdDisAdRslt;
import com.jsite.manager.AbstractCrudService;

/**
 * 水量调节计算行政区划统计结果Service
 * @author 水量调节计算行政区划统计结果
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdDisAdRsltService extends AbstractCrudService<TSfrdDisAdRsltDao, TSfrdDisAdRslt> {

}