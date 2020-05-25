package com.jsite.busi.szy.emergency.dao;

import com.jsite.busi.szy.emergency.po.DdsEdRsv;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 应急调度水库调节方式DAO接口
 * @author hjx
 * @version 2017-06-12
 */
@MyBatisDao
public interface DdsEdRsvDao extends CrudDao<DdsEdRsv> {
	
	public int updateExq(DdsEdRsv ddsEdRsv);
	
	public int removeAll(DdsEdRsv ddsEdRsv);
	
	/**
	 * 把方案空值对象  加大值数据 设为0
	 * @param ddsEdRsv
	 * @return
	 */
	public int updateDefault(DdsEdRsv ddsEdRsv);
}