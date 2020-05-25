package com.jsite.busi.szy.emergency.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.emergency.dao.DdsEdWruleDao;
import com.jsite.busi.szy.emergency.po.DdsEdWrule;

/**
 * 告警规则表Service
 * @author hjx
 * @version 2017-06-08
 */
@Service
@Transactional(readOnly = true)
public class DdsEdWruleService extends AbstractCrudService<DdsEdWruleDao, DdsEdWrule> {
	
	/**
	 * 根据测站分组
	 * @param ddsEdWrule
	 * @return
	 */
	public List<DdsEdWrule> listGroupByIn(DdsEdWrule ddsEdWrule){
		return this.dao.listGroupByIn(ddsEdWrule);
	}
	
}