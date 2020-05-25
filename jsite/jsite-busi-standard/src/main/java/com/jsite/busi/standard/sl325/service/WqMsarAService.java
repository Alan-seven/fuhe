package com.jsite.busi.standard.sl325.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.standard.sl325.dao.WqMsarADao;
import com.jsite.busi.standard.sl325.po.WqMsarA;
import com.jsite.manager.AbstractCrudService;

/**
 * 单表生成Service
 * 
 * @author 徐旺旺
 * @version 2017-03-02
 */
@Service
@Transactional(readOnly = true)
public class WqMsarAService extends AbstractCrudService<WqMsarADao, WqMsarA> {

}