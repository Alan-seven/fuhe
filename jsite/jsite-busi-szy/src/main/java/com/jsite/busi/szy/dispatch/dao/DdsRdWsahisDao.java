package com.jsite.busi.szy.dispatch.dao;

import com.jsite.busi.szy.dispatch.po.DdsRdWsahis;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

import java.util.List;

/**
 * 可供水量计算表DAO接口
 * @author hjx
 * @version 2017-09-22
 */
@MyBatisDao
public interface DdsRdWsahisDao extends CrudDao<DdsRdWsahis> {
    List<DdsRdWsahis> selectAll();
	
}