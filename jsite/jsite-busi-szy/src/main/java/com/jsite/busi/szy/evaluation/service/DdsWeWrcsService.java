package com.jsite.busi.szy.evaluation.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.evaluation.dao.DdsWeWrcsDao;
import com.jsite.busi.szy.evaluation.po.DdsWeWrcs;
import com.jsite.manager.AbstractCrudService;

/**
 * 水资源评价水库基本信息表Service
 * @author hjx
 * @version 2017-09-14
 */
@Service
@Transactional(readOnly = true)
public class DdsWeWrcsService extends AbstractCrudService<DdsWeWrcsDao, DdsWeWrcs> {
	
}