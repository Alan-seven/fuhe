package com.jsite.busi.wq.data.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.wq.data.dao.ItmDao;
import com.jsite.busi.wq.data.po.Itm;
import com.jsite.manager.AbstractCrudService;

/**
 * 指标信息Service
 * 
 * @author 徐旺旺
 * @version 2017-04-09
 */
@Service
@Transactional(readOnly = true)
public class ItmService extends AbstractCrudService<ItmDao, Itm> {
}