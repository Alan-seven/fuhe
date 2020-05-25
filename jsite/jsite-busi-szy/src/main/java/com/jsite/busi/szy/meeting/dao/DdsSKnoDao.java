package com.jsite.busi.szy.meeting.dao;

import com.jsite.busi.szy.meeting.po.DdsSKno;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 会商知识库DAO接口
 * @author 徐旺旺
 * @version 2017-03-30
 */
@MyBatisDao
public interface DdsSKnoDao extends CrudDao<DdsSKno> {
	
	public DdsSKno findByTitle(DdsSKno entity);
}