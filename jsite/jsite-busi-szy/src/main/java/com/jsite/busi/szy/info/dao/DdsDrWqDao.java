package com.jsite.busi.szy.info.dao;

import java.util.List;

import com.jsite.busi.szy.info.po.DdsDrWq;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 水质信息DAO接口
 * @author 徐旺旺
 * @version 2017-03-21
 */
@MyBatisDao
public interface DdsDrWqDao extends CrudDao<DdsDrWq> {
	
	public List<DdsDrWq> listByStcd(DdsDrWq ddsDrWq);
	
}