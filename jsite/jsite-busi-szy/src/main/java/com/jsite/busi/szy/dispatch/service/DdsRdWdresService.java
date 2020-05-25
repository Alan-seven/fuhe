package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.dispatch.custom.BatchSupportedService;
import com.jsite.busi.szy.dispatch.dao.DdsRdWdresDao;
import com.jsite.busi.szy.dispatch.po.DdsRdWdres;

/**
 * 水量调度结果表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdWdresService extends BatchSupportedService<DdsRdWdresDao, DdsRdWdres> {
	
}