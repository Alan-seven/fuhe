package com.jsite.busi.szy.info.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.info.dao.DdsDrPptnDao;
import com.jsite.busi.szy.info.po.DdsDrPptn;
import com.jsite.manager.AbstractCrudService;

/**
 * 仪器设备基本信息Service
 * @author 徐旺旺
 * @version 2017-03-21
 */
@Service
@Transactional(readOnly = true)
public class DdsDrPptnService extends AbstractCrudService<DdsDrPptnDao, DdsDrPptn> {

	/**
	 * 根据测站编码和开始时间结束时间查询监测数据 每天降雨量
	 * @param ddsDrPptn
	 * @return
	 */
	public List<DdsDrPptn> listByStcd(DdsDrPptn ddsDrPptn){
		return this.dao.listByStcd(ddsDrPptn);
	}
	

	/**
	 * 根据测站编码和开始时间结束时间查询监测数据
	 * @param ddsDrPptn
	 * @return
	 */
	public List<DdsDrPptn> listHourByStcd(DdsDrPptn ddsDrPptn){
		return this.dao.listHourByStcd(ddsDrPptn);
	}
	
	/**
	 * 获取测站最新记录时间
	 * @param ddsDrPptn
	 * @return
	 */
	public DdsDrPptn findMaxTime(DdsDrPptn ddsDrPptn){
		return this.dao.findMaxTime(ddsDrPptn);
	}
}