package com.jsite.dao.sys;

import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import com.jsite.dao.sys.po.DeptInfo;

/**
 * 部门信息表DAO接口
 * @author hjx
 * @version 2017-09-12
 */
@MyBatisDao
public interface DeptInfoDao extends CrudDao<DeptInfo> {
	
}