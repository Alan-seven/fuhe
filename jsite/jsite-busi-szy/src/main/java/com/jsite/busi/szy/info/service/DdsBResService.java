package com.jsite.busi.szy.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.info.dao.DdsBResDao;
import com.jsite.busi.szy.info.po.DdsBRes;
import com.jsite.core.page.Page;
import com.jsite.dao.sys.UserDao;
import com.jsite.manager.AbstractCrudService;

/**
 * 仪器设备基本信息Service
 * @author 徐旺旺
 * @version 2017-03-17
 */
@Service
@Transactional(readOnly = true)
public class DdsBResService extends AbstractCrudService<DdsBResDao, DdsBRes> {
	
	@Autowired
	private DdsBResDao ddsBResDao;
	
	public List<DdsBRes> findByZV(DdsBRes ddsBRes) {
		List<DdsBRes> list = ddsBResDao.findByZV(ddsBRes);
		return list;
	}
	
	public List<DdsBRes> findByZQ(DdsBRes ddsBRes) {
		List<DdsBRes> list = ddsBResDao.findByZQ(ddsBRes);
		return list;
	}
	
}