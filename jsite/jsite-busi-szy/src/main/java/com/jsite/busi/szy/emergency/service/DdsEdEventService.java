package com.jsite.busi.szy.emergency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdEventDao;
import com.jsite.busi.szy.emergency.po.DdsEdEvent;
import com.jsite.manager.AbstractCrudService;

/**
 * 应急事件信息表Service
 * @author hjx
 * @version 2017-06-07
 */
@Service
@Transactional(readOnly = true)
public class DdsEdEventService extends AbstractCrudService<DdsEdEventDao, DdsEdEvent> {

	/**
	 * 根据事件名称判断事件是否存在
	 * @param ddsEdEvent
	 * @return
	 */
	public List<DdsEdEvent> findByEvenNm(DdsEdEvent ddsEdEvent){
		return this.dao.findByEvenNm(ddsEdEvent);
	}
	
}