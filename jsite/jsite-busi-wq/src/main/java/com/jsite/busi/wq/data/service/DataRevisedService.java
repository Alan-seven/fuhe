package com.jsite.busi.wq.data.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.wq.data.dao.DataRevisedDao;
import com.jsite.busi.wq.data.po.DataRevised;
import com.jsite.manager.AbstractCrudService;

/**
 * 数据校正Service
 * 
 * @author 徐旺旺
 * @version 2017-04-09
 */
@Service
@Transactional(readOnly = true)
public class DataRevisedService extends AbstractCrudService<DataRevisedDao, DataRevised> {

}