package com.jsite.busi.szy.meeting.dao;

import java.util.List;

import com.jsite.busi.szy.meeting.po.DdsSGrade;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 会商方案专家打分DAO接口
 * @author 徐旺旺
 * @version 2017-03-30
 */
@MyBatisDao
public interface DdsSGradeDao extends CrudDao<DdsSGrade> {
	
	public List<DdsSGrade> getExpByConid(DdsSGrade ddsSGrade);
	public List<DdsSGrade> getProByConid(DdsSGrade ddsSGrade);
}