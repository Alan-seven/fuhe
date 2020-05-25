package com.jsite.busi.szy.meeting.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.meeting.dao.DdsSExpDao;
import com.jsite.busi.szy.meeting.po.DdsSExp;
import com.jsite.manager.AbstractCrudService;

/**
 * 专家信息Service
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Service
@Transactional(readOnly = true)
public class DdsSExpService extends AbstractCrudService<DdsSExpDao, DdsSExp> {
	
}