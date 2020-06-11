package com.jsite.busi.szy.formal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.jsite.busi.szy.formal.dao.TSfrdIfRsltDao;
import com.jsite.busi.szy.formal.po.TSfrdIfRslt;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.manager.AbstractCrudService;
/**
 * 来水预报计算结果Service
 * @author 来水预报计算结果
 * @version 2020-03-17
 */
@Service
@Transactional(readOnly = true)
public class TSfrdIfRsltService extends AbstractCrudService<TSfrdIfRsltDao, TSfrdIfRslt> {

	/**
	 * 保存模型计算结果
	 * @param json
	 * @param proCd
	 * @param enCd
	 * @param pre_time
	 * @return
	 */
	public ServiceResp saveResult(JSONArray json,String proCd,String enCd,String pre_time){
		 ServiceResp serviceResp = new ServiceResp();
		 TSfrdIfRslt rslt = new TSfrdIfRslt();
	        rslt.setProCd(proCd);
	        rslt.setEnCd(enCd);
			if(json.size() > 1){
				//删除历史预报结果数据
				dao.remove(rslt);
				//当前方案径流总量
				Double target = json.getDouble(0);
				rslt.setForW(target);
				rslt.setStat("0");
				//当前方案径流过程
				JSONArray records = JSONArray.parseArray(json.get(1).toString());
				for(int i = 0 ; i < records.size(); i++){
					Double values = records.getDouble(i);;
		        	rslt.setRelW(values);
		        	int month = i+1;
		        	String str = month < 10?"-0":"-";
		        	String dt = pre_time.substring(0, 4)+str+month+"-01";
		        	rslt.setStDt(DateUtils.parseDate(dt));
		        	try {
						dao.save(rslt);
						serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
						serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
					} catch (Exception e) {
						e.printStackTrace();
						logger.error(e.getCause().getMessage());
						serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
						serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
					}
				}
			}else{
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg("run-off-forecast计算结果错误，请联系模型开发人员");
			}
		return serviceResp;
		
	}
}