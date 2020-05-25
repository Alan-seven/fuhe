package com.jsite.busi.szy.emergency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdReportDao;
import com.jsite.busi.szy.emergency.po.DdsEdReport;
import com.jsite.manager.AbstractCrudService;

/**
 * 应急事件处置报告表Service
 * @author hjx
 * @version 2017-06-08
 */
@Service
@Transactional(readOnly = true)
public class DdsEdReportService extends AbstractCrudService<DdsEdReportDao, DdsEdReport> {
	
}