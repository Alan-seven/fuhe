package com.jsite.busi.szy.info.dao;

import com.jsite.busi.szy.info.po.DdsDStz;
import com.jsite.busi.szy.info.po.DdsDWarn;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 测站水位预警信息表DAO接口
 * @author hjx
 * @version 2017-04-27
 */
@MyBatisDao
public interface DdsDWarnDao  extends CrudDao<DdsDWarn> {

}
