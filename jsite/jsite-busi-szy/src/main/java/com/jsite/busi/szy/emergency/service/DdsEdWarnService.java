package com.jsite.busi.szy.emergency.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdConstDao;
import com.jsite.busi.szy.emergency.dao.DdsEdWarnDao;
import com.jsite.busi.szy.emergency.po.DdsEdConst;
import com.jsite.busi.szy.emergency.po.DdsEdWarn;
import com.jsite.manager.AbstractCrudService;

/**
 * 预警信息Service
 * @author hjx
 * @version 2017-10-09
 */
@Service
@Transactional(readOnly = true)
public class DdsEdWarnService extends AbstractCrudService<DdsEdWarnDao, DdsEdWarn>{
	
}
