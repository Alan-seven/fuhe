package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.dispatch.dao.CddsPRwdpDao;
import com.jsite.busi.szy.dispatch.po.CddsPRwdp;
import com.jsite.manager.AbstractCrudService;

/**
 * 居民需水计算Service
 * @author 徐旺旺
 * @version 2017-04-19
 */
@Service
@Transactional(readOnly = true)
public class CddsPRwdpService extends AbstractCrudService<CddsPRwdpDao, CddsPRwdp> {
	
}