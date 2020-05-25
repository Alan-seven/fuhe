package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdRsvrRsltDao;
import com.jsite.busi.szy.formal.po.TSfrdRsvrRslt;
import com.jsite.manager.AbstractCrudService;

/**
 * 水库计算结果Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfrdRsvrRsltService extends AbstractCrudService<TSfrdRsvrRsltDao, TSfrdRsvrRslt>{

}
