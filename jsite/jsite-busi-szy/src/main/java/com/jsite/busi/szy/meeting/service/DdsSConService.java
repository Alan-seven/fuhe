package com.jsite.busi.szy.meeting.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.meeting.dao.DdsSConDao;
import com.jsite.busi.szy.meeting.po.DdsSCon;
import com.jsite.manager.AbstractCrudService;

/**
 * 会商信息Service
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Service
@Transactional(readOnly = true)
public class DdsSConService extends AbstractCrudService<DdsSConDao, DdsSCon> {
	
	public DdsSCon findByName(DdsSCon entity){
		return this.dao.findByName(entity);
	}
}