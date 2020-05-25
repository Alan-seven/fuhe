package com.jsite.busi.szy.emergency.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsMSectboundryDao;
import com.jsite.busi.szy.emergency.po.DdsMSectboundry;
import com.jsite.manager.AbstractCrudService;

/**
 * 河段模型断面表Service
 * @author hjx
 * @version 2017-06-12
 */
@Service
@Transactional(readOnly = true)
public class DdsMSectboundryService extends AbstractCrudService<DdsMSectboundryDao, DdsMSectboundry> {
	
}