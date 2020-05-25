package com.jsite.busi.szy.emergency.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.emergency.dao.DdsEdPDao;
import com.jsite.busi.szy.emergency.dao.DdsMRsvDao;
import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.emergency.po.DdsMRsv;
import com.jsite.core.mapper.JsonMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;
import com.jsite.manager.constraints.ValidateUtils;
import com.jsite.manager.constraints.Violation;

/**
 * 应急方案信息表Service
 * @author hjx
 * @version 2017-06-07
 */
@Service
@Transactional(readOnly = true)
public class DdsEdPService extends AbstractCrudService<DdsEdPDao, DdsEdP> {
	
	@Autowired
	private DdsEdPDao ddsEdPDao;
	
	@Autowired
	private DdsMRsvDao ddsMRsvDao;

	public ServiceResp updateSta(DdsEdP entity) {
		ServiceResp serviceResp = new ServiceResp();
		List<Violation> violations = ValidateUtils.validate(entity);
		if (violations.size() > 0) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_2);
			serviceResp.setMsg(JsonMapper.toJsonString(violations));
		} else {
			try {
				ddsEdPDao.updateSta(entity);
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
			} catch (Exception e) {
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
			}
		}
		return serviceResp;
	}
	
	/**
	 * 水质模拟  -- 无水库参与调度
	 * @param entity
	 * @return
	 */
	public List<DdsEdP> listSz(DdsEdP entity){
		List<DdsEdP> edplist = this.dao.listSz(entity);
		List<DdsEdP> list = new ArrayList<DdsEdP>();
		for(DdsEdP vo : edplist){
			DdsMRsv rsv = new DdsMRsv();
			rsv.setRcd(vo.getRcd());
			List<DdsMRsv> rsvlist =  ddsMRsvDao.list(rsv);
			if(null==rsvlist||rsvlist.size()<=0){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * 水量调度  有水库参与调度
	 * @param ddsEdPVO
	 * @param response
	 * @return
	 */
	public List<DdsEdP> listDispatch(DdsEdP entity){
		List<DdsEdP> edplist = this.dao.listDispatch(entity);
		List<DdsEdP> list = new ArrayList<DdsEdP>();
		for(DdsEdP vo : edplist){
			DdsMRsv rsv = new DdsMRsv();
			rsv.setRcd(vo.getRcd());
			List<DdsMRsv> rsvlist =  ddsMRsvDao.list(rsv);
			if(null!=rsvlist && rsvlist.size()>0){
				list.add(vo);
			}
		}
		return list;
	}
	
	/**
	 * 判断方案名称是否存在
	 * @param entity
	 * @return
	 */
	public DdsEdP findByProNm(DdsEdP entity){
		return this.dao.findByProNm(entity);
	}
}