package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdWtrplanVerInitcondDao;
import com.jsite.busi.szy.formal.po.TSfrdWtrplanVerInitcond;
import com.jsite.manager.AbstractCrudService;

/**
 * 用水计划核定初始条件Service
 * @author 用水计划核定初始条件
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdWtrplanVerInitcondService extends AbstractCrudService<TSfrdWtrplanVerInitcondDao, TSfrdWtrplanVerInitcond> {

}