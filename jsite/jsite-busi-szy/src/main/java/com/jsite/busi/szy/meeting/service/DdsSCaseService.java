package com.jsite.busi.szy.meeting.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.meeting.dao.DdsSCaseDao;
import com.jsite.busi.szy.meeting.po.DdsSCase;
import com.jsite.manager.AbstractCrudService;

/**
 * 历史案例Service
 * @author hjx
 * @version 2017-07-26
 */
@Service
@Transactional(readOnly = true)
public class DdsSCaseService extends AbstractCrudService<DdsSCaseDao, DdsSCase>{

}
