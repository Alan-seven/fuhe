package com.jsite.busi.szy.emergency.dao;

import com.jsite.busi.szy.emergency.po.DdsMRsvr;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 应急调度水库调节设置初始条件DAO接口
 * @author hjx
 * @version 2017-07-10
 */
@MyBatisDao
public interface DdsMRsvrDao extends CrudDao<DdsMRsvr> {
	
	public DdsMRsvr getByRcd(DdsMRsvr ddsMRsvr);
	
	public int removeAll(DdsMRsvr ddsMRsvr);
}