package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.po.TSfrdDisSectRslt;
import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.formal.dao.TSfrdDisSectRsltDao;


/**
 * 水量调节计算河道断面结果Service
 * @author 水量调节计算河道断面结果
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdDisSectRsltService extends AbstractCrudService<TSfrdDisSectRsltDao, TSfrdDisSectRslt> {

}