package com.jsite.busi.szy.dispatch.service;

import com.jsite.busi.szy.dispatch.dao.*;
import com.jsite.busi.szy.dispatch.po.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-10-10 17:30
 */
@Service
@Transactional(readOnly = true)
public class WaterPredDataService {

    @Autowired
    private DdsRdPService ddsRdPService;

    @Autowired
    private WaterPredDao waterPredDao;

    @Autowired
    private DdsRdEcosttDao ddsRdEcosttDao;

    @Autowired
    private DdsRdDevparDao ddsRdDevparDao;

    @Autowired
    private DdsRdWunDao ddsRdWunDao;

    @Autowired
    private DdsRdWuparDao ddsRdWuparDao;

    @Autowired
    private DdsRdWdmparDao ddsRdWdmparDao;

    @Autowired
    private DdsRdWnresDao ddsRdWnresDao;

    /**
     * 获取分区数据
     * @return
     */
    public List<FqArea> getFqData(String river) {
        List<String> adCds = DispatchDefault.SUB_CD_TO_AD_CDS_MAP.get(river);
        return waterPredDao.selectFqData(adCds);
    }

    /**
     * 保存或更新需水预测数据
     * @param proCd 方案编号
     * @param p1 需水预测社会经济
     * @param p2 需水预测社会经济发展参数
     * @param p3 用水定额
     * @param p4 用水参数
     * @param p5 逐月分配系数
     * @param p6 预测结果（年)
     * @param p7 预测结果 (逐月)
     * @return
     */
    public Boolean saveOrUpdate(String proCd,
                             List<DdsRdEcostt> p1,
                             List<DdsRdDevpar> p2,
                             List<DdsRdWun> p3,
                             List<DdsRdWupar> p4,
                             List<DdsRdWdmpar> p5,
                             List<DdsRdWnres> p6,
                             List<DdsRdWnres> p7) {
        DdsRdEcostt d1 = new DdsRdEcostt();
        d1.setProCd(proCd);
        List<DdsRdEcostt> e1List = ddsRdEcosttDao.list(d1);
        int num;
        if (e1List.size() > 0) {
            num = ddsRdEcosttDao.batchUpdate(p1, proCd);
        } else {
            num = ddsRdEcosttDao.batchInsert(p1, proCd);
        }

        DdsRdDevpar d2 = new DdsRdDevpar();
        d2.setProCd(proCd);
        List<DdsRdDevpar> e2List = ddsRdDevparDao.list(d2);
        int num2;
        if (e2List.size() > 0) {
            num = ddsRdDevparDao.batchUpdate(p2, proCd);
        } else {
            num = ddsRdDevparDao.batchInsert(p2, proCd);
        }

        DdsRdWun d3 = new DdsRdWun();
        d3.setProCd(proCd);
        List<DdsRdWun> e3List = ddsRdWunDao.list(d3);
        int num3;
        if (e2List.size() > 0) {
            num = ddsRdWunDao.batchUpdate(p3, proCd);
        } else {
            num = ddsRdWunDao.batchInsert(p3, proCd);
        }

        DdsRdWupar d4 = new DdsRdWupar();
        d4.setProCd(proCd);
        List<DdsRdWupar> e4List = ddsRdWuparDao.list(d4);
        int num4;
        if (e4List.size() > 0) {
            num = ddsRdWuparDao.batchUpdate(p4, proCd);
        } else {
            num = ddsRdWuparDao.batchInsert(p4, proCd);
        }

        DdsRdWdmpar d5 = new DdsRdWdmpar();
        d5.setProCd(proCd);
        List<DdsRdWdmpar> e5List = ddsRdWdmparDao.list(d5);
        int num5;
        if (e5List.size() > 0) {
            num = ddsRdWdmparDao.batchUpdate(p5, proCd);
        } else {
            num = ddsRdWdmparDao.batchInsert(p5, proCd);
        }

        DdsRdWnres d6 = new DdsRdWnres();
        d6.setProCd(proCd);
        p6.addAll(p7);
        List<DdsRdWnres> e6List = ddsRdWnresDao.list(d6);
        int num6;
        if (e6List.size() > 0) {
            num = ddsRdWnresDao.batchUpdate(p6, proCd);
        } else {
            num = ddsRdWnresDao.batchInsert(p6, proCd);
            // 更新方案状态
            DdsRdP ddsRdP = new DdsRdP();
            ddsRdP.setProCd(proCd);
            ddsRdP.setSta(2);
            ddsRdPService.updateSta(ddsRdP);
        }

        return true;
    }

    /**
     * 获取方案的需水预测数据
     * @param proCd
     * @return
     */
    public Map<String, Object> selectDataByProCd(String proCd) {
        // 需水预测社会经济
        List<DdsRdEcostt> p1List = ddsRdEcosttDao.selectByProCd(proCd);
        // 需水预测社会经济发展参数
        List<DdsRdDevpar> p2List = ddsRdDevparDao.selectByProCd(proCd);
        // 用水定额
        List<DdsRdWun> p3List = ddsRdWunDao.selectByProCd(proCd);
        // 用水参数
        List<DdsRdWupar> p4List = ddsRdWuparDao.selectByProCd(proCd);
        // 逐月分配系数
        List<DdsRdWdmpar> p5List = ddsRdWdmparDao.selectByProCd(proCd);
        // 预测结果（年)
        List<DdsRdWnres> p6List = ddsRdWnresDao.selectByYearProCd(proCd);
        // 预测结果 (逐月)
        List<DdsRdWnres> p7List = ddsRdWnresDao.selectByMonthProCd(proCd);

        Map<String, Object> result = null;
        List<Map<String, Object>> p0List = new ArrayList<>();
        if (p3List.size() > 0) {
            result = new HashMap<>();
            for (DdsRdWun d : p3List) {
                Map<String, Object> t = new HashMap<>();
                t.put("adCd", d.getAdCd());
                t.put("tw", 0);
                p0List.add(t);
            }
            result.put("p0", p0List);
            result.put("p1", p1List);
            result.put("p2", p2List);
            result.put("p3", p3List);
            result.put("p4", p4List);
            result.put("p5", p5List);
            result.put("p6", p6List);
            result.put("p7", p7List);
        }
        return result;
    }

}
