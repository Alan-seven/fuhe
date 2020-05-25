package com.jsite.busi.wq.data.dao;

import com.jsite.busi.wq.data.po.DataRevised;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 数据校正DAO接口
 * @author 徐旺旺
 * @version 2017-04-09
 */
@MyBatisDao
public interface DataRevisedDao extends CrudDao<DataRevised> {
	
}