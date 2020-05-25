package com.jsite.busi.szy.meeting.dao;

import com.jsite.busi.szy.meeting.po.DdsSCon;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 会商信息DAO接口
 * @author 徐旺旺
 * @version 2017-03-30
 */
@MyBatisDao
public interface DdsSConDao extends CrudDao<DdsSCon> {
	
	public DdsSCon findByName(DdsSCon entity);
}