package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfmmWsaWtDao;
import com.jsite.busi.szy.formal.po.TSfmmWsaWt;
import com.jsite.manager.AbstractCrudService;

/**
 *  需水预测基准参数信息表Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfmmWsaWtService extends AbstractCrudService< TSfmmWsaWtDao,   TSfmmWsaWt>{

}
