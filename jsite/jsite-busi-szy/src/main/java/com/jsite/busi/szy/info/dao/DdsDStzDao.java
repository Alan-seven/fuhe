package com.jsite.busi.szy.info.dao;

import com.jsite.dao.mybatis.MyBatisDao;

import java.util.List;

import com.jsite.busi.szy.info.po.DdsDStz;
import com.jsite.dao.CrudDao;

/**
 * 测站水位监测信息表DAO接口
 * @author hjx
 * @version 2017-04-27
 */
@MyBatisDao
public interface DdsDStzDao extends CrudDao<DdsDStz> {
	
	public List<DdsDStz> listDayZ(DdsDStz ddsDStz);
	
	public List<DdsDStz> listByStcd(DdsDStz ddsDStz);
}