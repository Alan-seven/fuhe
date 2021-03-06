package com.jsite.busi.szy.evaluation.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.evaluation.dao.DdsWeSwparamDao;
import com.jsite.busi.szy.evaluation.po.DdsWeSwparam;
import com.jsite.manager.AbstractCrudService;

/**
 * 地表水计算参数表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWeSwparamService extends AbstractCrudService<DdsWeSwparamDao, DdsWeSwparam> {
	
}