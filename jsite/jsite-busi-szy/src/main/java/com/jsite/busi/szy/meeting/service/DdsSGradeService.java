package com.jsite.busi.szy.meeting.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.meeting.dao.DdsSGradeDao;
import com.jsite.busi.szy.meeting.po.DdsSGrade;
import com.jsite.manager.AbstractCrudService;

/**
 * 会商方案专家打分Service
 * @author 徐旺旺
 * @version 2017-03-30
 */
@Service
@Transactional(readOnly = true)
public class DdsSGradeService extends AbstractCrudService<DdsSGradeDao, DdsSGrade> {
	
	/**
	 * 根据会商ID，获取会商设置的相关专家人员信息
	 * @param ddsSGrade
	 * @return
	 */
	public List<DdsSGrade> getExpByConid(DdsSGrade ddsSGrade){
		return dao.getExpByConid(ddsSGrade);
	}
	
	/**
	 * 根据会商ID,获取会商设置的方案列表
	 * @param ddsSGrade
	 * @return
	 */
	public List<DdsSGrade> getProByConid(DdsSGrade ddsSGrade){
		return dao.getProByConid(ddsSGrade);
	}
}