package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.dispatch.dao.DdsRdWaresDao;
import com.jsite.busi.szy.dispatch.po.DdsRdWares;
import com.jsite.manager.AbstractCrudService;

/**
 * 水量分配表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdWaresService extends AbstractCrudService<DdsRdWaresDao, DdsRdWares> {
	
}