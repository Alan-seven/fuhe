package com.jsite.dao.sys;

import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import com.jsite.dao.sys.po.Log;

/**
 * 日志DAO接口
 */
@MyBatisDao
public interface LogDao extends CrudDao<Log> {

}
