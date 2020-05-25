package com.jsite.busi.szy.formal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.formal.dao.TSfrdProDao;
import com.jsite.busi.szy.formal.po.TSfrdPro;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;

/**
 * 常规方案Service
 * @author seven
 *
 */
@Service
@Transactional(readOnly = true)
public class TSfrdProService extends AbstractCrudService<TSfrdProDao,TSfrdPro>{

	/**
	 * 得到最新的方案编码序列号
	 * @param entity
	 * @return
	 */
	public String getOrderNum(TSfrdPro entity){
		TSfrdPro pro = dao.getOrderNum(entity);
		String regionCd = entity.getRegionCd();
		int num = Integer.parseInt(pro!=null?pro.getProCd().substring(16):"0");
		num = num+1;
		String proCd = regionCd+String.format("%0" + 4 + "d", num);
		return proCd;
	}
	
	/**
	 * 更新方案进度
	 * @param proCd
	 * @param schStat
	 * @return
	 */
	public ServiceResp updateStat(String proCd,String schStat) {
		ServiceResp serviceResp = new ServiceResp();
		try {
			TSfrdPro pro = dao.get(proCd);
			//如果已经走过了流程，就不更新方案状态
			if(Integer.parseInt(pro.getSchStat()) < Integer.parseInt(schStat)){
				pro.setSchStat(schStat);
				dao.update(pro);
			}
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
		} catch (Exception e) {
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
		}
		return serviceResp;
	}
	
	/**
	 * 查询方案是否重名
	 * @param entity
	 * @return
	 */
	public List<TSfrdPro> findByNm(TSfrdPro entity){
		return dao.findByNm(entity);
	}
	
}
