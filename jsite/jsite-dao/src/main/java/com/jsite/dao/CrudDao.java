package com.jsite.dao;

import java.util.List;

import com.jsite.dao.exception.DaoException;

/**
 * DAO支持类实现
 * @param <T>
 */
public interface CrudDao<T> extends BaseDao {

	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id) throws DaoException;
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity) throws DaoException;
	
	/**
	 * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
	 * @param entity
	 * @return
	 */
	public List<T> list(T entity) throws DaoException;
	
	/**
	 * 查询所有数据列表
	 * @param entity
	 * @return
	 */
	public List<T> listAll(T entity) throws DaoException;
	
	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
	public int save(T entity) throws DaoException;
	
	/**
	 * 更新数据
	 * @param entity
	 * @return
	 */
	public int update(T entity) throws DaoException;
	
	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * @param entity
	 * @return
	 */
	public int remove(T entity) throws DaoException;
	
}