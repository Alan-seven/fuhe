package com.jsite.busi.szy.emergency.dao;

import com.jsite.busi.szy.emergency.po.DdsEdInit;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;


/**
 * 应急调度初始条件DAO接口
 * @author hjx
 * @version 2017-06-12
 */
@MyBatisDao
public interface DdsEdInitDao extends CrudDao<DdsEdInit> {
	
	public int removeAll(DdsEdInit ddsEdInit);
}