package com.jsite.busi.szy.info.dao;

import java.util.List;

import com.jsite.busi.szy.info.po.DdsDrPptn;
import com.jsite.busi.szy.info.po.DdsDrRiver;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 河道水情表DAO接口
 * @author hjx
 * @version 2017-06-08
 */
@MyBatisDao
public interface DdsDrRiverDao extends CrudDao<DdsDrRiver> {
	
	/**
	 * 根据测站编码 和监测开始时间和结束时间查询单站数据
	 * @param ddsDrRiver
	 * @return
	 */
	public List<DdsDrRiver> listByStcd(DdsDrRiver ddsDrRiver);
	
	public List<DdsDrRiver> findNewData(DdsDrRiver ddsDrRiver);

	/**
	 * 获取测站最新记录时间
	 * @param ddsDrPptn
	 * @return
	 */
	public DdsDrRiver findMaxTime(DdsDrRiver ddsDrRiver);
}