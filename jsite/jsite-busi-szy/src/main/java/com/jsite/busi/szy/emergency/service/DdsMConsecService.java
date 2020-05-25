package com.jsite.busi.szy.emergency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsMConsecDao;
import com.jsite.busi.szy.emergency.po.DdsMConsec;
import com.jsite.manager.AbstractCrudService;

/**
 * 模型控制断面表Service
 * @author hjx
 * @version 2017-07-05
 */
@Service
@Transactional(readOnly = true)
public class DdsMConsecService extends AbstractCrudService<DdsMConsecDao, DdsMConsec> {
	
	public List<DdsMConsec> listParams(DdsMConsec ddsMConsec){
		return dao.listParams(ddsMConsec);
	}
}