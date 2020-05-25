package com.jsite.busi.szy.emergency.dao;

import java.util.List;

import com.jsite.busi.szy.emergency.po.DdsEdGis;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 *应急调度模型计算地图结果DAO接口
 * @author hjx
 * @version 2017-06-12
 */
@MyBatisDao
public interface DdsEdGisDao extends CrudDao<DdsEdGis>{

	public int removeAll(DdsEdGis ddsEdGis);
	
	public List<DdsEdGis> findTime(DdsEdGis ddsEdGis);
	
	//批量插入
	public int insertBatch(List<DdsEdGis> listData);
	
}