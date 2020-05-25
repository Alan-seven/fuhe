package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.dispatch.dao.DdsRdWunDao;
import com.jsite.busi.szy.dispatch.po.DdsRdWun;

/**
 * 需水预测用水定额表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdWunService extends AbstractCrudService<DdsRdWunDao, DdsRdWun> {
	
}