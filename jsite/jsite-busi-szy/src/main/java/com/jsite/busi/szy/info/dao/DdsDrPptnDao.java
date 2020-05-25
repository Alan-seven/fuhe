package com.jsite.busi.szy.info.dao;

import java.util.List;

import com.jsite.busi.szy.info.po.DdsDrPptn;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;

/**
 * 降水量DAO接口
 * @author 徐旺旺
 * @version 2017-03-21
 */
@MyBatisDao
public interface DdsDrPptnDao extends CrudDao<DdsDrPptn> {
	
	/**
	 * 获取测站日降雨量
	 * @param ddsDrPptn
	 * @return
	 */
	public List<DdsDrPptn> listByStcd(DdsDrPptn ddsDrPptn);
	
	/**
	 * 获取测站小时降雨量
	 * @param ddsDrPptn
	 * @return
	 */
	public List<DdsDrPptn> listHourByStcd(DdsDrPptn ddsDrPptn);
	
	/**
	 * 获取测站最新记录时间
	 * @param ddsDrPptn
	 * @return
	 */
	public DdsDrPptn findMaxTime(DdsDrPptn ddsDrPptn);
}