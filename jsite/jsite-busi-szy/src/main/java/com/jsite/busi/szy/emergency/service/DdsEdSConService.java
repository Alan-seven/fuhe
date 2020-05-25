package com.jsite.busi.szy.emergency.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdSConDao;
import com.jsite.busi.szy.emergency.po.DdsEdSCon;
import com.jsite.manager.AbstractCrudService;

/**
 * 应急调度追踪溯源断面设置Service
 * @author hjx
 * @version 2017-06-12
 */
@Service
@Transactional(readOnly = true)
public class DdsEdSConService extends AbstractCrudService<DdsEdSConDao, DdsEdSCon>{

	
}
