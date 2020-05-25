package com.jsite.busi.szy.evaluation.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.evaluation.dao.DdsWeSsttDao;
import com.jsite.busi.szy.evaluation.po.DdsWeSstt;
import com.jsite.manager.AbstractCrudService;

/**
 * 耗水量评价表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWeSsttService extends AbstractCrudService<DdsWeSsttDao, DdsWeSstt> {
	
}