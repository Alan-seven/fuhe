package com.jsite.busi.szy.emergency.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdBoundDao;
import com.jsite.busi.szy.emergency.dao.DdsEdGisLegendDao;
import com.jsite.busi.szy.emergency.po.DdsEdBound;
import com.jsite.busi.szy.emergency.po.DdsEdGisLegend;
import com.jsite.manager.AbstractCrudService;

/**
 * 应急调度地图色彩分级Service
 * @author hjx
 * @version 2017-10-30
 */
@Service
@Transactional(readOnly = true)
public class DdsEdGisLegendService extends AbstractCrudService<DdsEdGisLegendDao, DdsEdGisLegend>{

}
