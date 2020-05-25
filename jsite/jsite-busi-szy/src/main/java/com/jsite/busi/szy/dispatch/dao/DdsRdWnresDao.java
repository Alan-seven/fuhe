package com.jsite.busi.szy.dispatch.dao;

import com.jsite.busi.szy.dispatch.po.DdsRdWnres;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 需水预测结果表DAO接口
 * @author hjx
 * @version 2017-09-22
 */
@MyBatisDao
public interface DdsRdWnresDao extends CrudDao<DdsRdWnres>, BaseBatchDao<DdsRdWnres> {
    List<DdsRdWnres> selectByProCdAndMonth(@Param("proCd") String proCd, @Param("monthList") List<Integer> monthList);
    List<DdsRdWnres> selectByYearProCd(@Param("proCd") String proCd);
    List<DdsRdWnres> selectByMonthProCd(@Param("proCd") String proCd);
    int batchInsert(@Param("listData") List<DdsRdWnres> list, @Param("proCd") String proCd);
    int batchUpdate(@Param("listData") List<DdsRdWnres> list, @Param("proCd") String proCd);
    int deleteByProCd(@Param("proCd") String proCd);
}