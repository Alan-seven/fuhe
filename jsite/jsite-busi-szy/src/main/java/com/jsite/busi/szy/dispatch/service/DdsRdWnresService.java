package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.dispatch.dao.DdsRdWnresDao;
import com.jsite.busi.szy.dispatch.po.DdsRdWnres;

/**
 * 需水预测结果表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdWnresService extends AbstractCrudService<DdsRdWnresDao, DdsRdWnres> {
	
}