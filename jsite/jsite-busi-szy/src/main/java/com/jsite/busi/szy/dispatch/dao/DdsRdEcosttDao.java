package com.jsite.busi.szy.dispatch.dao;

import com.jsite.busi.szy.dispatch.po.DdsRdEcostt;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 需水预测社会经济表DAO接口
 * @author hjx
 * @version 2017-09-22
 */
@MyBatisDao
public interface DdsRdEcosttDao extends CrudDao<DdsRdEcostt>, BaseBatchDao<DdsRdEcostt> {
	List<DdsRdEcostt> selectByProCd(@Param("proCd") String proCd);
    int batchInsert(@Param("listData") List<DdsRdEcostt> list, @Param("proCd") String proCd);
    int batchUpdate(@Param("listData") List<DdsRdEcostt> list, @Param("proCd") String proCd);
    int deleteByProCd(@Param("proCd") String proCd);
}