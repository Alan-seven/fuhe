package com.jsite.busi.szy.emergency.dao;

import java.util.List;

import com.jsite.busi.szy.emergency.po.DdsEdEvent;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 应急事件信息表DAO接口
 * @author hjx
 * @version 2017-06-07
 */
@MyBatisDao
public interface DdsEdEventDao extends CrudDao<DdsEdEvent> {
	
	public List<DdsEdEvent> findByEvenNm(DdsEdEvent ddsEdEvent);
	
}