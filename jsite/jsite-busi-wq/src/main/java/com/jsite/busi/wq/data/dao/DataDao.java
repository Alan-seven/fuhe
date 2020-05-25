package com.jsite.busi.wq.data.dao;

import com.jsite.busi.wq.data.po.Data;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * @author 徐旺旺
 * @version 2017-04-09
 */
@MyBatisDao
public interface DataDao extends CrudDao<Data> {
	
}