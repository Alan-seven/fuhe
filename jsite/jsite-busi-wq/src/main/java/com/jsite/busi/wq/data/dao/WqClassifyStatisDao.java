package com.jsite.busi.wq.data.dao;

import com.jsite.busi.wq.data.po.WqClassifyStatis;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 水质分类统计DAO接口
 * @author 徐旺旺
 * @version 2017-04-09
 */
@MyBatisDao
public interface WqClassifyStatisDao extends CrudDao<WqClassifyStatis> {
	
}