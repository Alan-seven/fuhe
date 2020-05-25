package com.jsite.busi.wq.data.dao;

import com.jsite.busi.wq.data.po.DataStatis;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 监测数据统计DAO接口
 * @author 徐旺旺
 * @version 2017-04-09
 */
@MyBatisDao
public interface DataStatisDao extends CrudDao<DataStatis> {
	
}