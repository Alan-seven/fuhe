package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.dispatch.dao.DdsRdEcosttDao;
import com.jsite.busi.szy.dispatch.po.DdsRdEcostt;

/**
 * 需水预测社会经济表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdEcosttService extends AbstractCrudService<DdsRdEcosttDao, DdsRdEcostt> {
	
}