package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.dispatch.dao.DdsRdWamresDao;
import com.jsite.busi.szy.dispatch.po.DdsRdWamres;

/**
 * 水量分配月表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdWamresService extends AbstractCrudService<DdsRdWamresDao, DdsRdWamres> {
	
}