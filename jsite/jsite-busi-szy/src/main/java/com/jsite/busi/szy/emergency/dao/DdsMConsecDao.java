package com.jsite.busi.szy.emergency.dao;

import java.util.List;

import com.jsite.busi.szy.emergency.po.DdsMConsec;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 模型控制断面表DAO接口
 * @author hjx
 * @version 2017-07-05
 */
@MyBatisDao
public interface DdsMConsecDao extends CrudDao<DdsMConsec> {
	
	public List<DdsMConsec> listParams(DdsMConsec ddsMConsec);
	
}