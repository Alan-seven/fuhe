package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfmmRegionBDao;
import com.jsite.busi.szy.formal.po.TSfmmRegionB;
import com.jsite.manager.AbstractCrudService;

/**
 * 常规调度区域Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfmmRegionBService extends AbstractCrudService<TSfmmRegionBDao, TSfmmRegionB> {

}
