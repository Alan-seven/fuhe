package com.jsite.busi.szy.dispatch.dao;

import com.jsite.busi.szy.dispatch.po.DdsRdWupar;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 需水预测用水参数表DAO接口
 * @author hjx
 * @version 2017-09-22
 */
@MyBatisDao
public interface DdsRdWuparDao extends CrudDao<DdsRdWupar>, BaseBatchDao<DdsRdWupar> {
    List<DdsRdWupar> selectByProCd(@Param("proCd") String proCd);
    int batchInsert(@Param("listData") List<DdsRdWupar> list, @Param("proCd") String proCd);
    int batchUpdate(@Param("listData") List<DdsRdWupar> list, @Param("proCd") String proCd);
    int deleteByProCd(@Param("proCd") String proCd);
}