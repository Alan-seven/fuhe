package com.jsite.busi.szy.dispatch.dao;

import com.jsite.busi.szy.dispatch.po.DdsRdWun;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 需水预测用水定额表DAO接口
 * @author hjx
 * @version 2017-09-22
 */
@MyBatisDao
public interface DdsRdWunDao extends CrudDao<DdsRdWun>, BaseBatchDao<DdsRdWun> {
    List<DdsRdWun> selectByProCd(@Param("proCd") String proCd);
    int batchInsert(@Param("listData") List<DdsRdWun> list, @Param("proCd") String proCd);
    int batchUpdate(@Param("listData") List<DdsRdWun> list, @Param("proCd") String proCd);
    int deleteByProCd(@Param("proCd") String proCd);
}