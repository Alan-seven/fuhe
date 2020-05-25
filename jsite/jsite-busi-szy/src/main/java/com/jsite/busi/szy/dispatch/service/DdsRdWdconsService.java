package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.dispatch.custom.BatchSupportedService;
import com.jsite.busi.szy.dispatch.dao.DdsRdWdconsDao;
import com.jsite.busi.szy.dispatch.po.DdsRdWdcons;

/**
 * 水量调度约束条件表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdWdconsService extends BatchSupportedService<DdsRdWdconsDao, DdsRdWdcons> {
	
}