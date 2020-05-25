package com.jsite.busi.wq.data.dao;

import com.jsite.busi.wq.data.po.WqOutStatis;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 水质超标统计DAO接口
 * @author 徐旺旺
 * @version 2017-04-09
 */
@MyBatisDao
public interface WqOutStatisDao extends CrudDao<WqOutStatis> {
	
}