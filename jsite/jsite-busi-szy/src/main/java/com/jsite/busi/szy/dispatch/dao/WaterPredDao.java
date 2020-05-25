package com.jsite.busi.szy.dispatch.dao;

import com.jsite.busi.szy.dispatch.po.FqArea;
import com.jsite.dao.mybatis.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-10-10 17:08
 */
@MyBatisDao
public interface WaterPredDao {
    List<FqArea> selectFqData(@Param("adCds") List<String> adCds);
}
