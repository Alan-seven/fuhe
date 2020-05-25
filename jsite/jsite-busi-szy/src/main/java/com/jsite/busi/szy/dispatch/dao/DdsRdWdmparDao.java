package com.jsite.busi.szy.dispatch.dao;

import com.jsite.busi.szy.dispatch.po.DdsRdWdmpar;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 需水预测逐月分配系数表DAO接口
 * @author hjx
 * @version 2017-09-22
 */
@MyBatisDao
public interface DdsRdWdmparDao extends CrudDao<DdsRdWdmpar>, BaseBatchDao<DdsRdWdmpar> {
    List<DdsRdWdmpar> selectByProCd(@Param("proCd") String proCd);
    int batchInsert(@Param("listData") List<DdsRdWdmpar> list, @Param("proCd") String proCd);
    int batchUpdate(@Param("listData") List<DdsRdWdmpar> list, @Param("proCd") String proCd);
    int deleteByProCd(@Param("proCd") String proCd);
}