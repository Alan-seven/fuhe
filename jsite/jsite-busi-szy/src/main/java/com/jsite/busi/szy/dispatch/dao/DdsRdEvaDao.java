package com.jsite.busi.szy.dispatch.dao;

import com.jsite.busi.szy.dispatch.po.DdsRdEva;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 水量调度结果评价表DAO接口
 * @author hjx
 * @version 2017-09-22
 */
@MyBatisDao
public interface DdsRdEvaDao extends CrudDao<DdsRdEva> {
	
	//获取批量方案中指标的最大值最小值
	public DdsRdEva getMaxMIn(DdsRdEva ddsRdEva);
	
}