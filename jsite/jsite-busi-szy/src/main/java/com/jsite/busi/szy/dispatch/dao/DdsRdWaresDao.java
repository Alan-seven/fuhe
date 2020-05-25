package com.jsite.busi.szy.dispatch.dao;

import com.jsite.busi.szy.dispatch.po.DdsRdWares;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 水量分配表DAO接口
 * @author hjx
 * @version 2017-09-22
 */
@MyBatisDao
public interface DdsRdWaresDao extends CrudDao<DdsRdWares>, BaseBatchDao<DdsRdWares> {
    List<DdsRdWares> selectByProCdAndMonth(@Param("proCd") String proCd, @Param("monthList") List<Integer> monthList);
    int batchInsertWithDate(@Param("listData") List<DdsRdWares> list, @Param("proCd") String proCd);
    int batchUpdateWithDate(@Param("listData") List<DdsRdWares> list, @Param("proCd") String proCd);
    int batchInsertWithoutDate(@Param("listData") List<DdsRdWares> list, @Param("proCd") String proCd);
    int batchUpdateWithoutDate(@Param("listData") List<DdsRdWares> list, @Param("proCd") String proCd);
	List<DdsRdWares> listByProCd(@Param("proCd") String proCd);
}