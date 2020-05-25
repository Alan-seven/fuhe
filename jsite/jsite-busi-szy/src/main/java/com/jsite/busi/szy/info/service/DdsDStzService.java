package com.jsite.busi.szy.info.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.info.dao.DdsDStzDao;
import com.jsite.busi.szy.info.po.DdsDStz;

/**
 * 测站水位监测信息表Service
 * @author hjx
 * @version 2017-04-27
 */
@Service
@Transactional(readOnly = true)
public class DdsDStzService extends AbstractCrudService<DdsDStzDao, DdsDStz> {
	
	public List<DdsDStz> listDayZ(DdsDStz ddsDStz){
		return dao.listDayZ(ddsDStz);
	}
	
	public List<DdsDStz> listByStcd(DdsDStz ddsDStz){
		return dao.listByStcd(ddsDStz);
	}
}