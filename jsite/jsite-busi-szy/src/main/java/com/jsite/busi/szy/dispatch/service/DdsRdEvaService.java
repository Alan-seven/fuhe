package com.jsite.busi.szy.dispatch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.dispatch.dao.DdsRdEvaDao;
import com.jsite.busi.szy.dispatch.po.DdsRdEva;

/**
 * 水量调度结果评价表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdEvaService extends AbstractCrudService<DdsRdEvaDao, DdsRdEva> {
	
	//获取批量方案中指标的最大值最小值
		public DdsRdEva getMaxMIn(DdsRdEva ddsRdEva){
			return this.dao.getMaxMIn(ddsRdEva);
		}
}