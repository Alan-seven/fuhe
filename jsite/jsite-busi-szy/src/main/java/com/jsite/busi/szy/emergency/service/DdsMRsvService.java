package com.jsite.busi.szy.emergency.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsMRsvDao;
import com.jsite.busi.szy.emergency.po.DdsMRsv;
import com.jsite.manager.AbstractCrudService;
/**
 * 河段模型水库表Service
 * @author hjx
 * @version 2017-06-12
 */
@Service
@Transactional(readOnly = true)
public class DdsMRsvService extends AbstractCrudService<DdsMRsvDao, DdsMRsv> {
	
}