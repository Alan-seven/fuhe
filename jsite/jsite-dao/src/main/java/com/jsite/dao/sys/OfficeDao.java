package com.jsite.dao.sys;

import com.jsite.dao.TreeDao;
import com.jsite.dao.mybatis.MyBatisDao;
import com.jsite.dao.sys.po.Office;

/**
 * 机构DAO接口
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
}
