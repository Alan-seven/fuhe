package com.jsite.busi.szy.emergency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdWqDataDao;
import com.jsite.busi.szy.emergency.po.DdsEdWqData;
import com.jsite.manager.AbstractCrudService;

/**
 * 应急事件水质监测Service
 * @author hjx
 * @version 2017-06-12
 */
@Service
@Transactional(readOnly = true)
public class DdsEdWqDataService extends AbstractCrudService<DdsEdWqDataDao, DdsEdWqData>{

}
