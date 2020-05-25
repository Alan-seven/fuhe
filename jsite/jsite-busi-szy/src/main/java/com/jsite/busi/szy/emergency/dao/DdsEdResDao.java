package com.jsite.busi.szy.emergency.dao;

import java.util.List;

import com.jsite.busi.szy.emergency.po.DdsEdRes;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 应急调度方案结果表DAO接口
 * @author hjx
 * @version 2017-06-08
 */
@MyBatisDao
public interface DdsEdResDao extends CrudDao<DdsEdRes> {
	
	public List<DdsEdRes> listTree(DdsEdRes ddsEdRes);
	
	public int removeAll(DdsEdRes ddsEdRes);
	
	public int insertBatch(List<DdsEdRes> ddsEdRes);
	
	public List<DdsEdRes> findTimeBySecId(DdsEdRes ddsEdRes);
}