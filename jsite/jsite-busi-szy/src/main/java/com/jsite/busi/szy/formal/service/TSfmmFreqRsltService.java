package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfmmFreqRsltDao;
import com.jsite.busi.szy.formal.po.TSfmmFreqRslt;
import com.jsite.manager.AbstractCrudService;

/**
 * 水文测站频率来水成果信息Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfmmFreqRsltService extends AbstractCrudService< TSfmmFreqRsltDao,   TSfmmFreqRslt> {

}
