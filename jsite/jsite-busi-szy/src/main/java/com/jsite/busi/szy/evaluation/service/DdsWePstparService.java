package com.jsite.busi.szy.evaluation.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.evaluation.dao.DdsWePstparDao;
import com.jsite.busi.szy.evaluation.po.DdsWePstpar;
import com.jsite.manager.AbstractCrudService;

/**
 * 降水代表站权重表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWePstparService extends AbstractCrudService<DdsWePstparDao, DdsWePstpar> {
	
}