package com.jsite.busi.wq.data.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.wq.data.dao.WqOutStatisDao;
import com.jsite.busi.wq.data.po.WqOutStatis;
import com.jsite.manager.AbstractCrudService;

/**
 * 水质超标统计Service
 * @author 徐旺旺
 * @version 2017-04-09
 */
@Service
@Transactional(readOnly = true)
public class WqOutStatisService extends AbstractCrudService<WqOutStatisDao, WqOutStatis> {
	
}