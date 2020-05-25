package com.jsite.busi.szy.dispatch.dao;

import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.core.page.Page;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 常规调度方案信息表DAO接口
 * @author hjx
 * @version 2017-09-22
 */
@MyBatisDao
public interface DdsRdPDao extends CrudDao<DdsRdP> {
	Page<DdsRdP> listByCondition(@Param("type") String type,
                                 @Param("user") String user,
                                 @Param("start") Date start,
                                 @Param("end") Date end);

	List<DdsRdP> listByExample(@Param("obj") DdsRdP ddsRdP);

	String getDpplCdByProCd(@Param("proCd") String proCd);

	// 插入数据，返回自增主键
	Integer insertOne(DdsRdP ddsRdP);

	Integer updateSta(DdsRdP ddsRdP);
	Map<String,BigDecimal> selectSta(DdsRdP ddsRdP);

	//会商中根据调度类型查询方案
	public List<DdsRdP> listByMeeting(DdsRdP ddsRdP);
	
}