package com.jsite.busi.szy.emergency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsMRiverDao;
import com.jsite.busi.szy.emergency.po.DdsMRiver;
import com.jsite.manager.AbstractCrudService;


/**
 * 河流概化河段表Service
 * @author hjx
 * @version 2017-06-12
 */
@Service
@Transactional(readOnly = true)
public class DdsMRiverService extends AbstractCrudService<DdsMRiverDao, DdsMRiver> {

}