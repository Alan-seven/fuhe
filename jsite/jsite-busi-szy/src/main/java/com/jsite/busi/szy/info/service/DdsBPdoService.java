package com.jsite.busi.szy.info.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.info.dao.DdsBPdoDao;
import com.jsite.busi.szy.info.po.DdsBPdo;
import com.jsite.manager.AbstractCrudService;

/**
 * 入河排污口基本信息表Service
 * @author hjx
 * @version 2017-04-26
 */
@Service
@Transactional(readOnly = true)
public class DdsBPdoService extends AbstractCrudService<DdsBPdoDao, DdsBPdo> {
	
}