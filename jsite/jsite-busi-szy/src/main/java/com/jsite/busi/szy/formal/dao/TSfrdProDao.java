package com.jsite.busi.szy.formal.dao;

import java.util.List;

import com.jsite.busi.szy.formal.po.TSfrdPro;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
/**
 * 调度方案DAO
 * @author seven
 *
 */
@MyBatisDao
public interface TSfrdProDao extends CrudDao<TSfrdPro>{

	public TSfrdPro getOrderNum(TSfrdPro entity);
	
	public int updateStat(TSfrdPro entity);
	
	/**
	 * 查询方案是否重名
	 * @param entity
	 * @return
	 */
	public List<TSfrdPro> findByNm(TSfrdPro entity);
}
