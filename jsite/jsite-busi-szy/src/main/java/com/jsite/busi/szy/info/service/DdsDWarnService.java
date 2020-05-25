package com.jsite.busi.szy.info.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.info.dao.DdsDStzDao;
import com.jsite.busi.szy.info.dao.DdsDWarnDao;
import com.jsite.busi.szy.info.po.DdsDStz;
import com.jsite.busi.szy.info.po.DdsDWarn;
import com.jsite.manager.AbstractCrudService;

/**
 * 测站水位预警信息表Service
 * @author hjx
 * @version 2017-04-27
 */
@Service
@Transactional(readOnly = true)
public class DdsDWarnService extends AbstractCrudService<DdsDWarnDao, DdsDWarn> {

}
