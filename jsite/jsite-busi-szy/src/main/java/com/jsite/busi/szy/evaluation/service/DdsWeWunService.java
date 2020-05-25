package com.jsite.busi.szy.evaluation.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.evaluation.dao.DdsWeWunDao;
import com.jsite.busi.szy.evaluation.po.DdsWeWun;
import com.jsite.manager.AbstractCrudService;
/**
 * 用水定额及参数表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWeWunService extends AbstractCrudService<DdsWeWunDao, DdsWeWun> {
	
}