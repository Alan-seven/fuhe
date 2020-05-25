package com.jsite.busi.szy.info.dao;

import java.util.List;

import com.jsite.busi.szy.info.po.DdsBRes;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 仪器设备基本信息DAO接口
 * @author 徐旺旺
 * @version 2017-03-17
 */
@MyBatisDao
public interface DdsBResDao extends CrudDao<DdsBRes> {
	
	public List<DdsBRes> findByZV(DdsBRes ddsBRes);
	
	public List<DdsBRes> findByZQ(DdsBRes ddsBRes);
	
}