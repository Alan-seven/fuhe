package com.jsite.busi.szy.emergency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdPsarDao;
import com.jsite.busi.szy.emergency.po.DdsEdPsar;
import com.jsite.manager.AbstractCrudService;

/**
 * ]应急调度断面参数表Service
 * @author hjx
 * @version 2017-06-08
 */
@Service
@Transactional(readOnly = true)
public class DdsEdPsarService extends AbstractCrudService<DdsEdPsarDao, DdsEdPsar> {
	
}