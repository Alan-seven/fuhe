package com.jsite.busi.szy.dispatch.dao;

import com.jsite.busi.szy.dispatch.po.DdsRdDevpar;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 需水预测社会经济发展参数表DAO接口
 * @author hjx
 * @version 2017-09-22
 */
@MyBatisDao
public interface DdsRdDevparDao extends CrudDao<DdsRdDevpar>, BaseBatchDao<DdsRdDevpar> {
    List<DdsRdDevpar> selectByProCd(@Param("proCd") String proCd);
    int batchInsert(@Param("listData") List<DdsRdDevpar> list, @Param("proCd") String proCd);
    int batchUpdate(@Param("listData") List<DdsRdDevpar> list, @Param("proCd") String proCd);
    int deleteByProCd(@Param("proCd") String proCd);
}