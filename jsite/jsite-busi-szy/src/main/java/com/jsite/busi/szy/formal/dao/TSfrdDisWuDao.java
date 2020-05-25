package com.jsite.busi.szy.formal.dao;

import java.util.List;

import com.jsite.busi.szy.formal.po.TSfrdDisWu;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 水量分配用水系数DAO接口
 * @author 
 * @version 2020-03-17
 */
@MyBatisDao
public interface TSfrdDisWuDao extends CrudDao<TSfrdDisWu>{

	/**
	 * 根据实体代码分组
	 * @param entity
	 * @return
	 */
	public List<TSfrdDisWu> listByEncd(TSfrdDisWu entity);
}
