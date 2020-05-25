package com.jsite.busi.szy.dispatch.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.dispatch.dao.DdsMDevDao;
import com.jsite.busi.szy.dispatch.po.DdsMDev;
import com.jsite.manager.AbstractCrudService;

/**
 * 社会经济发展参数表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsMDevService extends AbstractCrudService<DdsMDevDao, DdsMDev> {
	
}