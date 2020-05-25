package com.jsite.busi.szy.dispatch.service;

import com.jsite.busi.szy.dispatch.dao.DdsRdWsaDao;
import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.busi.szy.dispatch.po.DdsRdWsa;
import com.jsite.core.service.ServiceResp;
import com.jsite.manager.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 可供水量计算表Service
 * @author hjx
 * @version 2017-09-22
 */
@Service
@Transactional(readOnly = true)
public class DdsRdWsaService extends AbstractCrudService<DdsRdWsaDao, DdsRdWsa> {

    @Autowired
    private DdsRdPService ddsRdPService;

    public ServiceResp saveOrUpdate(String proCd, DdsRdWsa data) {
        data.setProCd(proCd);
        DdsRdWsa exist = this.get(data);
        ServiceResp msg;
        if (exist != null) {
            msg = this.update(data);
        } else {
            msg = this.save(data);
            // 更新方案状态
            DdsRdP ddsRdP = new DdsRdP();
            ddsRdP.setProCd(proCd);
            ddsRdP.setSta(1);
            ddsRdPService.updateSta(ddsRdP);
        }
        return msg;
    }

}