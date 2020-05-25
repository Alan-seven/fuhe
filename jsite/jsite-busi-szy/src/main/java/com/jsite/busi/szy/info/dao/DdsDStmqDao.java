package com.jsite.busi.szy.info.dao;

import com.jsite.dao.mybatis.MyBatisDao;

import java.util.List;

import com.jsite.busi.szy.info.po.DdsDStmq;
import com.jsite.dao.CrudDao;

/**
 * 测站实测流量信息表DAO接口
 * @author hjx
 * @version 2017-04-27
 */
@MyBatisDao
public interface DdsDStmqDao extends CrudDao<DdsDStmq> {
	
	public List<DdsDStmq> listDayQ(DdsDStmq ddsDStmq);
	
	public List<DdsDStmq> listByStcd(DdsDStmq ddsDStmq);
}