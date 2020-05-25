package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.dispatch.custom.BatchSupportedService;
import com.jsite.busi.szy.dispatch.dao.DdsRdWdinitDao;
import com.jsite.busi.szy.dispatch.po.DdsRdWdinit;

/**
 * 水量调度初始条件表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdWdinitService extends BatchSupportedService<DdsRdWdinitDao, DdsRdWdinit> {
	
}