package com.jsite.busi.szy.dispatch.custom;

import java.util.List;

import com.jsite.dao.CrudDao;
import com.jsite.dao.exception.DaoException;
import com.jsite.dao.mybatis.MyBatisDao;

@MyBatisDao
public interface BatchSupportedDAO<T> extends CrudDao<T>{
	public int saveBatch(List<T> list) throws DaoException;
	
	public List<T> listIn(List<T> list) throws DaoException;
}
