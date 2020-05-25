package com.jsite.busi.szy.meeting.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.meeting.dao.DdsSFactorDao;
import com.jsite.busi.szy.meeting.po.DdsSFactor;
import com.jsite.manager.AbstractCrudService;

/**
 * 会商方案评价指标Service
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Service
@Transactional(readOnly = true)
public class DdsSFactorService extends AbstractCrudService<DdsSFactorDao, DdsSFactor> {
	
}