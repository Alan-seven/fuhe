package com.jsite.busi.szy.info.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.info.dao.DdsDStmqDao;
import com.jsite.busi.szy.info.po.DdsDStmq;

/**
 * 测站实测流量信息表Service
 * @author hjx
 * @version 2017-04-27
 */
@Service
@Transactional(readOnly = true)
public class DdsDStmqService extends AbstractCrudService<DdsDStmqDao, DdsDStmq> {
	
	public List<DdsDStmq> listDayQ(DdsDStmq ddsDStmq){
		return dao.listDayQ(ddsDStmq);
	}
	
	public List<DdsDStmq> listByStcd(DdsDStmq ddsDStmq){
		return dao.listByStcd(ddsDStmq);
	}
	
}