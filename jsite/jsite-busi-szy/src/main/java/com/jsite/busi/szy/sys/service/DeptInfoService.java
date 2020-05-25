package com.jsite.busi.szy.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.dao.sys.DeptInfoDao;
import com.jsite.dao.sys.po.DeptInfo;
import com.jsite.manager.AbstractCrudService;

/**
 * 部门信息表Service
 * @author hjx
 * @version 2017-09-12
 */
@Service
@Transactional(readOnly = true)
public class DeptInfoService extends AbstractCrudService<DeptInfoDao, DeptInfo> {
	
}