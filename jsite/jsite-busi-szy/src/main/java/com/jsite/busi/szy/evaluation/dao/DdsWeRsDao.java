package com.jsite.busi.szy.evaluation.dao;

import com.jsite.busi.szy.evaluation.po.DdsWeRs;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 水库蓄水动态评价表DAO接口
 * @author hjx
 * @version 2017-09-14
 */
@MyBatisDao
public interface DdsWeRsDao extends CrudDao<DdsWeRs> {

    List<Map> listAllToMap_name(@Param("regCds") List<String> regCds);
	
}