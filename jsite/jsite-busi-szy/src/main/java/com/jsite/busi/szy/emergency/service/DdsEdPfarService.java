package com.jsite.busi.szy.emergency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdPfarDao;
import com.jsite.busi.szy.emergency.po.DdsEdPfar;
import com.jsite.manager.AbstractCrudService;

/**
 * 应急调度预报参数表Service
 * @author hjx
 * @version 2017-06-08
 */
@Service
@Transactional(readOnly = true)
public class DdsEdPfarService extends AbstractCrudService<DdsEdPfarDao, DdsEdPfar> {
	
}