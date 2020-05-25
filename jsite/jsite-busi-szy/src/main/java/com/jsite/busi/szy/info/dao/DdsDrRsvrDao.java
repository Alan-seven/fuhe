package com.jsite.busi.szy.info.dao;

import java.util.List;

import com.jsite.busi.szy.info.po.DdsDrRsvr;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 水库水情表DAO接口
 * @author hjx
 * @version 2017-04-27
 */
@MyBatisDao
public interface DdsDrRsvrDao extends CrudDao<DdsDrRsvr> {
	
	/**
	 * 根据测站编码 和监测开始时间和结束时间查询单站数据
	 * @param ddsDrRsvr
	 * @return
	 */
	public List<DdsDrRsvr> listByStcd(DdsDrRsvr ddsDrRsvr);
	
	public List<DdsDrRsvr> findNewData(DdsDrRsvr ddsDrRsvr);
	
	/**
	 * 获取测站最新记录时间
	 * @param ddsDrPptn
	 * @return
	 */
	public DdsDrRsvr findMaxTime(DdsDrRsvr ddsDrRsvr);
}