package com.jsite.busi.szy.meeting.dao;

import com.jsite.busi.szy.meeting.po.DdsSFactorw;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 *	会商方案评价规则表Dao
 * @author hjx
 * @version 2017-07-20
 */
@MyBatisDao
public interface DdsSFactorwDao extends CrudDao<DdsSFactorw>{

	public int removeAll(DdsSFactorw ddsSFactorw);
	
	public int updateScoreMax(DdsSFactorw entity);
	
	public int updateScoreMin(DdsSFactorw entity);
	
	public int updateWeight(DdsSFactorw entity);
}
