package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.dispatch.custom.BatchSupportedService;
import com.jsite.busi.szy.dispatch.dao.DdsRdWdinithisDao;
import com.jsite.busi.szy.dispatch.po.DdsRdWdinithis;

/**
 * 水量调度初始条件表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdWdinithisService extends BatchSupportedService<DdsRdWdinithisDao, DdsRdWdinithis> {
	
}