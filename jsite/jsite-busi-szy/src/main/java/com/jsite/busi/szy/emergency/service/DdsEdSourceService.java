package com.jsite.busi.szy.emergency.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdSourceDao;
import com.jsite.busi.szy.emergency.po.DdsEdSource;
import com.jsite.manager.AbstractCrudService;

/**
 * 应急事件溯源信息表Service
 * @author hjx
 * @version 2017-06-07
 */
@Service
@Transactional(readOnly = true)
public class DdsEdSourceService extends AbstractCrudService<DdsEdSourceDao, DdsEdSource> {
	
}