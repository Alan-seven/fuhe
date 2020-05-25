package com.jsite.busi.szy.meeting.dao;

import com.jsite.busi.szy.meeting.po.DdsSRes;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 会商材料DAO接口
 * @author 徐旺旺
 * @version 2017-03-30
 */
@MyBatisDao
public interface DdsSResDao extends CrudDao<DdsSRes> {
	
	public DdsSRes getByResId(String resId);
	
	public int updateByResId(DdsSRes ddsSRes);
	
}