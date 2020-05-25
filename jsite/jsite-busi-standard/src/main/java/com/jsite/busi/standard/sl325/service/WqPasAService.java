package com.jsite.busi.standard.sl325.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.standard.sl325.dao.WqPasADao;
import com.jsite.busi.standard.sl325.po.WqPasA;
import com.jsite.manager.AbstractCrudService;

/**
 * 水质分类标准Service
 * @author 徐旺旺
 * @version 2017-03-13
 */
@Service
@Transactional(readOnly = true)
public class WqPasAService extends AbstractCrudService<WqPasADao, WqPasA> {
	
}