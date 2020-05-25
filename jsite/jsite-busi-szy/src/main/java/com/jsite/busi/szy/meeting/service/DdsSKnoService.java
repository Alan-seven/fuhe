package com.jsite.busi.szy.meeting.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.meeting.dao.DdsSKnoDao;
import com.jsite.busi.szy.meeting.po.DdsSKno;
import com.jsite.manager.AbstractCrudService;

/**
 * 会商知识库Service
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Service
@Transactional(readOnly = true)
public class DdsSKnoService extends AbstractCrudService<DdsSKnoDao, DdsSKno> {
	
	/**
	 * 判断标题是否存在
	 * @param entity
	 * @return
	 */
	public DdsSKno findByTitle(DdsSKno entity){
		return this.dao.findByTitle(entity);
	}
	
}