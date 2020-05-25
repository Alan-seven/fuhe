package com.jsite.busi.wq.data.dao;

import com.jsite.busi.wq.data.po.Itm;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 指标信息DAO接口
 * @author 徐旺旺
 * @version 2017-04-09
 */
@MyBatisDao
public interface ItmDao extends CrudDao<Itm> {
	
}