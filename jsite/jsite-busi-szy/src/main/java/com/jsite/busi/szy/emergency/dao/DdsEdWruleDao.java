package com.jsite.busi.szy.emergency.dao;

import java.util.List;

import com.jsite.busi.szy.emergency.po.DdsEdWrule;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 告警规则表DAO接口
 * @author hjx
 * @version 2017-06-08
 */
@MyBatisDao
public interface DdsEdWruleDao extends CrudDao<DdsEdWrule> {
	
	/**
	 * 根据测站分组
	 * @param ddsEdWrule
	 * @return
	 */
	public List<DdsEdWrule> listGroupByIn(DdsEdWrule ddsEdWrule);
}