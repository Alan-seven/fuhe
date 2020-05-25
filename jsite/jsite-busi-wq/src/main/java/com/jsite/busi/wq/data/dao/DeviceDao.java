package com.jsite.busi.wq.data.dao;

import com.jsite.busi.wq.data.po.Device;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 设备信息DAO接口
 * @author 徐旺旺
 * @version 2017-04-09
 */
@MyBatisDao
public interface DeviceDao extends CrudDao<Device> {
	
}