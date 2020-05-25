package com.jsite.busi.szy.emergency.dao;

import java.util.List;

import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 应急方案信息表DAO接口
 * @author hjx
 * @version 2017-06-07
 */
@MyBatisDao
public interface DdsEdPDao extends CrudDao<DdsEdP> {
	
	public int updateSta(DdsEdP entity);
	
	public List<DdsEdP> listSz(DdsEdP entity);
	
	public List<DdsEdP> listDispatch(DdsEdP entity);
	
	public DdsEdP findByProNm(DdsEdP entity);
	
}