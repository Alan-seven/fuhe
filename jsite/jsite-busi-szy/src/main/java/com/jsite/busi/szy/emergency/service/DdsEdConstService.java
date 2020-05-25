package com.jsite.busi.szy.emergency.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdConstDao;
import com.jsite.busi.szy.emergency.po.DdsEdConst;
import com.jsite.manager.AbstractCrudService;

/**
 * 应急调度约束条件表Service
 * @author hjx
 * @version 2017-06-12
 */
@Service
@Transactional(readOnly = true)
public class DdsEdConstService extends AbstractCrudService<DdsEdConstDao, DdsEdConst> {
	
}