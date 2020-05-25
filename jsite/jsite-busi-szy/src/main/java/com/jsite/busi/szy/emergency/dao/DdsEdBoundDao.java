package com.jsite.busi.szy.emergency.dao;

import com.jsite.busi.szy.emergency.po.DdsEdBound;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 应急调度边界条件DAO接口
 * @author hjx
 * @version 2017-06-12
 */
@MyBatisDao
public interface DdsEdBoundDao extends CrudDao<DdsEdBound> {

	public int removeAll(DdsEdBound ddsEdBound);
	
}