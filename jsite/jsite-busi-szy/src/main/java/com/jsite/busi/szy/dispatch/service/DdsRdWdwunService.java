package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.dispatch.custom.BatchSupportedService;
import com.jsite.busi.szy.dispatch.dao.DdsRdWdwunDao;
import com.jsite.busi.szy.dispatch.po.DdsRdWdwun;

@Service
@Transactional(readOnly = true)
public class DdsRdWdwunService extends BatchSupportedService<DdsRdWdwunDao, DdsRdWdwun> {

}
