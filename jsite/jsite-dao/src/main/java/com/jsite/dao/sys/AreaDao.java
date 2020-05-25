package com.jsite.dao.sys;

import com.jsite.dao.TreeDao;
import com.jsite.dao.mybatis.MyBatisDao;
import com.jsite.dao.sys.po.Area;

/**
 * 区域DAO接口
 */
@MyBatisDao
public interface AreaDao extends TreeDao<Area> {
	
}
