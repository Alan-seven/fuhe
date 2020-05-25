package com.jsite.busi.szy.meeting.dao;

import com.jsite.busi.szy.meeting.po.DdsSPro;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 会商方案DAO接口
 * @author 徐旺旺
 * @version 2017-03-30
 */
@MyBatisDao
public interface DdsSProDao extends CrudDao<DdsSPro> {
	
	public int removeAll(DdsSPro ddsSPro);
}