package com.jsite.busi.wq.data.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.wq.data.dao.DataDao;
import com.jsite.busi.wq.data.po.Data;
import com.jsite.manager.AbstractCrudService;

/**
 * @author 徐旺旺
 * @version 2017-04-09
 */
@Service
@Transactional(readOnly = true)
public class DataService extends AbstractCrudService<DataDao, Data> {
}