package com.jsite.busi.szy.emergency.dao;

import com.jsite.busi.szy.emergency.po.DdsEdEva;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 应急调度方案结果评价表DAO接口
 * @author hjx
 * @version 2017-06-08
 */
@MyBatisDao
public interface DdsEdEvaDao extends CrudDao<DdsEdEva> {
	
	public DdsEdEva getMaxMIn(DdsEdEva ddsEdEva);
}