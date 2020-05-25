package com.jsite.busi.szy.dispatch.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.dispatch.dao.CddsPRparDao;
import com.jsite.busi.szy.dispatch.po.CddsPRpar;
import com.jsite.manager.AbstractCrudService;

/**
 * 需水预测方案信息Service
 * @author 徐旺旺
 * @version 2017-04-20
 */
@Service
@Transactional(readOnly = true)
public class CddsPRparService extends AbstractCrudService<CddsPRparDao, CddsPRpar> {
	
}