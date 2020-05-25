package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.dispatch.dao.DdsMWunDao;
import com.jsite.busi.szy.dispatch.po.DdsMWun;
import com.jsite.manager.AbstractCrudService;

/**
 * 用水定额表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsMWunService extends AbstractCrudService<DdsMWunDao, DdsMWun> {
	
}