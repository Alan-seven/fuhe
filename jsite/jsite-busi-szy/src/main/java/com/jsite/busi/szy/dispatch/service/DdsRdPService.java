package com.jsite.busi.szy.dispatch.service;

import com.jsite.busi.szy.dispatch.dao.DdsRdPDao;
import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.core.service.RespCode;
import com.jsite.manager.AbstractCrudService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 常规调度方案信息表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdPService extends AbstractCrudService<DdsRdPDao, DdsRdP> {

    @Autowired
    private DdsRdPDao ddsRdPDao;

    public Map<String, Object> saveOne(DdsRdP ddsRdP) {
        Integer id = ddsRdPDao.insertOne(ddsRdP);
        Map<String, Object> msg = new HashMap<>();
        if (id != null) {
            msg.put("code", RespCode.SERVICE_RESP_ERROR_CODE_1);
            msg.put("msg", RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
            msg.put("id", ddsRdP.getProCd());
        } else {
            msg.put("code", RespCode.SERVICE_RESP_ERROR_CODE_0);
            msg.put("msg", RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
        }
        return msg;
    }

    public int updateSta(DdsRdP ddsRdP) {
        return ddsRdPDao.updateSta(ddsRdP);
    }
    public int selectSta(DdsRdP ddsRdP) {
        return Integer.parseInt(ddsRdPDao.selectSta(ddsRdP).get("STA").toString());
    }
    
    //会商中根据调度类型查询方案
	public List<DdsRdP> listByMeeting(DdsRdP ddsRdP){
		return this.dao.listByMeeting(ddsRdP);
	}
}