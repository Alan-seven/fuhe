package com.jsite.busi.szy.evaluation.dao;

import com.jsite.busi.szy.evaluation.po.DdsWeWs;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 供水量评价表DAO接口
 * @author hjx
 * @version 2017-09-14
 */
@MyBatisDao
public interface DdsWeWsDao extends CrudDao<DdsWeWs> {
    List<Map> listAllToMap(@Param("regCds") List<String> regCds);
}