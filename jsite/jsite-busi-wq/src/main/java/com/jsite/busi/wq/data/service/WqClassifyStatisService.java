package com.jsite.busi.wq.data.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.wq.data.dao.WqClassifyStatisDao;
import com.jsite.busi.wq.data.po.WqClassifyStatis;
import com.jsite.manager.AbstractCrudService;

/**
 * 水质分类统计Service
 * @author 徐旺旺
 * @version 2017-04-09
 */
@Service
@Transactional(readOnly = true)
public class WqClassifyStatisService extends AbstractCrudService<WqClassifyStatisDao, WqClassifyStatis> {
	
}