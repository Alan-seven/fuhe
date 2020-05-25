package com.jsite.busi.szy.evaluation.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.evaluation.dao.DdsWeDaparamDao;
import com.jsite.busi.szy.evaluation.po.DdsWeDaparam;
import com.jsite.manager.AbstractCrudService;

/**
 * 废污水排放率表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWeDaparamService extends AbstractCrudService<DdsWeDaparamDao, DdsWeDaparam> {
	
}