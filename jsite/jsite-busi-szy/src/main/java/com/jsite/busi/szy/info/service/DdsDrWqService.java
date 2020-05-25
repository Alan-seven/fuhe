package com.jsite.busi.szy.info.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.info.dao.DdsDrWqDao;
import com.jsite.busi.szy.info.po.DdsDrWq;
import com.jsite.manager.AbstractCrudService;

/**
 * 水质信息Service
 * @author 徐旺旺
 * @version 2017-03-21
 */
@Service
@Transactional(readOnly = true)
public class DdsDrWqService extends AbstractCrudService<DdsDrWqDao, DdsDrWq> {
	
	public List<DdsDrWq> listByStcd(DdsDrWq ddsDrWq){
		return this.dao.listByStcd(ddsDrWq);
	}
}