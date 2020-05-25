package com.jsite.busi.szy.info.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.info.dao.DdsBWqstDao;
import com.jsite.busi.szy.info.po.DdsBWqst;
import com.jsite.manager.AbstractCrudService;

/**
 * 仪器设备基本信息Service
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Service
@Transactional(readOnly = true)
public class DdsBWqstService extends AbstractCrudService<DdsBWqstDao, DdsBWqst> {
	
}