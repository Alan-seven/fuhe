package com.jsite.busi.szy.dispatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.dispatch.dao.CddsDDwdpDao;
import com.jsite.busi.szy.dispatch.po.CddsDDwdp;
import com.jsite.dao.CrudDao;
import com.jsite.manager.AbstractCrudService;


/**
 * 生活需水基础数据Service
 * @author 徐旺旺
 * @version 2017-04-19
 */
@Service
@Transactional(readOnly = true)
public class CddsDDwdpService extends AbstractCrudService<CddsDDwdpDao, CddsDDwdp> {
	
}