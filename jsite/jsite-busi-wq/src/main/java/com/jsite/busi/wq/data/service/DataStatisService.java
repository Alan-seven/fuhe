package com.jsite.busi.wq.data.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.wq.data.dao.DataStatisDao;
import com.jsite.busi.wq.data.po.DataStatis;
import com.jsite.manager.AbstractCrudService;

/**
 * 监测数据统计Service
 * @author 徐旺旺
 * @version 2017-04-09
 */
@Service
@Transactional(readOnly = true)
public class DataStatisService extends AbstractCrudService<DataStatisDao, DataStatis> {
	
}