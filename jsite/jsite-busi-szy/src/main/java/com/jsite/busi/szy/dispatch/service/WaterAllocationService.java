package com.jsite.busi.szy.dispatch.service;

import com.jsite.busi.szy.dispatch.dao.DdsRdPDao;
import com.jsite.busi.szy.dispatch.dao.DdsRdWaresDao;
import com.jsite.busi.szy.dispatch.dao.DdsRdWnresDao;
import com.jsite.busi.szy.dispatch.dao.DdsRdWsaDao;
import com.jsite.busi.szy.dispatch.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-10-26 10:25
 */
@Service
@Transactional(readOnly = true)
public class WaterAllocationService {

    @Autowired
    private DdsRdWsaDao ddsRdWsaDao;

    @Autowired
    private DdsRdWnresDao ddsRdWnresDao;

    @Autowired
    private DdsRdWaresDao ddsRdWaresDao;

    @Autowired
    private DdsRdPService ddsRdPService;

    @Autowired
    private DdsRdPDao ddsRdPDao;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static final String TYPE_YEAR = "year";
    private static final String TYPE_MONTH = "month";
    private static final String TYPE_XUN = "xun";
    private static final String TYPE_TOP_XUN = "t";
    private static final String TYPE_MIDDLE_XUN = "m";
    private static final String TYPE_LAST_XUN = "d";
    private static final int T_MONTH = 1;
    private static final int M_MONTH = 11;
    private static final int D_MONTH = 21;


    private static final Map<String, String[]> XUN_CODE_MAP = new HashMap<String, String[]>(){
        {
            put(TYPE_TOP_XUN, new String[]{"01", "11"});
            put(TYPE_MIDDLE_XUN, new String[]{"11", "21"});
            put(TYPE_LAST_XUN, new String[]{"21", "01"});
        }
    };

    /**
     * 获取页面默认的数据
     * @param proCd 方案编号
     * @param type 类型 year | month | xun
     * @return
     */
    public WaterAllocationData getDefaultData(String proCd, String type) {
//        List<DdsRdWares> fpResults = ddsRdWaresDao.listByProCd(proCd);
        WaterAllocationData waData = new WaterAllocationData();
        DdsRdP p0 = new DdsRdP();
        p0.setProCd(proCd);
        DdsRdP solution = ddsRdPDao.get(p0);
        String xsProCd = proCd;
        List<Integer> monthList = new ArrayList<>();
        int startMonth = 0;
        int endMonth = 0;

        Calendar start = Calendar.getInstance();
        start.setTime(solution.getBgDt());
        Calendar end = Calendar.getInstance();
        end.setTime(solution.getEdDt());
        if (TYPE_MONTH.equals(type) || TYPE_XUN.equals(type)) {
            startMonth = start.get(Calendar.MONTH) + 1;
            endMonth = end.get(Calendar.MONTH) + 1;
            if (startMonth >= endMonth) {
                endMonth += 12;
            }
            monthList = getMonthList(startMonth, endMonth);
            xsProCd = ddsRdPDao.getDpplCdByProCd(proCd).trim();
        } else if (TYPE_YEAR.equals(type)) {
            startMonth = 1;
            endMonth = 13;
            monthList = getMonthList(1, 13);
        }

        waData.setStartMonth(startMonth);
        waData.setEndMonth(endMonth);
        DdsRdWsa p1 = new DdsRdWsa();
        p1.setProCd(xsProCd);
        DdsRdWsa ddsRdWsa = ddsRdWsaDao.get(p1);
        // 可供水量数据，这里是获取年的
        waData.setWsResult(ddsRdWsa);

        // 需水数据
        List<DdsRdWnres> xsResults = ddsRdWnresDao.selectByProCdAndMonth(xsProCd, monthList);
        if (TYPE_XUN.equals(type)) {
            xsResults = setXunXsData(waData, xsResults, start);
        }
        // 合计
        sumXsResults(xsResults);
        waData.setXsResults(xsResults);

        if (TYPE_MONTH.equals(type) || TYPE_XUN.equals(type)) {
            List<Integer> yearMonths = getMonthList(1, 13);
            // 年需水数据
            List<DdsRdWnres> yearXsResults = ddsRdWnresDao.selectByProCdAndMonth(xsProCd, yearMonths);
            sumXsResults(yearXsResults);
            double totalYear = 0.0;
            double totalMx = 0.0;
            for (DdsRdWnres d : yearXsResults) {
                totalYear += d.getTotWat();
            }
            for (DdsRdWnres d : xsResults) {
                totalMx += d.getTotWat();
            }
            waData.setMxMaxSl(ddsRdWsa.getMaxSl() * (totalMx / totalYear));
        }
//        List<DdsRdWares> fpResults2 = ddsRdWaresDao.selectByProCdAndMonth(proCd, monthList);
//        waData.setFqResults(fpResults2);

        return waData;
    }

    public boolean checkSaveData(String proCd) {
        List<DdsRdWares> fpResults = ddsRdWaresDao.listByProCd(proCd);
        if (fpResults != null && fpResults.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 设置旬需水数据
     * 从月需水中取1/3
     * @param data List<DdsRdWnres>
     * @param start Calendar
     * @return List<DdsRdWnres>
     */
    private List<DdsRdWnres> setXunXsData(WaterAllocationData waData,
                                          List<DdsRdWnres> data,
                                          Calendar start) {
        int day = start.get(Calendar.DAY_OF_MONTH);
        int month = start.get(Calendar.MONTH) + 1;
        List<String> firstMonthXun = new ArrayList<>();
        if (T_MONTH == day) {
            firstMonthXun.add(TYPE_TOP_XUN);
            firstMonthXun.add(TYPE_MIDDLE_XUN);
            firstMonthXun.add(TYPE_LAST_XUN);
        } else if (M_MONTH == day) {
            firstMonthXun.add(TYPE_MIDDLE_XUN);
            firstMonthXun.add(TYPE_LAST_XUN);
        } else if (D_MONTH == day) {
            firstMonthXun.add(TYPE_LAST_XUN);
        }
        waData.setFirstMonthXun(firstMonthXun);
        return parseXunXSData(data, month, firstMonthXun);
    }

    public List<Integer> getMonthList(Integer start, Integer end) {
        List<Integer> monthList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            monthList.add(i);
        }
        return monthList;
    }

    /**
     * 转换月数据为旬数据
     * @param data
     * @return
     */
    public List<DdsRdWnres> parseXunXSData(List<DdsRdWnres> data,
                                           int firstMonth,
                                           List<String> firstMonthXun) {
        List<DdsRdWnres> parseData = new ArrayList<>();
        for (DdsRdWnres d : data) {
            if (d.getMonth() == firstMonth) {
                for (String xun : firstMonthXun) {
                    parseData.add(setXunXSResults(d, xun));
                }
            } else {
                parseData.add(setXunXSResults(d, TYPE_TOP_XUN)); // 上旬
                parseData.add(setXunXSResults(d, TYPE_MIDDLE_XUN)); // 中旬
                parseData.add(setXunXSResults(d, TYPE_LAST_XUN)); // 下旬
            }
        }
        return parseData;
    }

    /**
     * 设置旬数据，为每月的1/3
     * @param d
     * @param type t | m | d
     * @return
     */
    public DdsRdWnres setXunXSResults(DdsRdWnres d, String type) {
        DdsRdWnres d2 = new DdsRdWnres();
        double division = 3.0;
        d2.setRegCd(d.getRegCd());
        d2.setMonth(d.getMonth());
        d2.setdWat(div(d.getdWat(), division));
        d2.setuWat(div(d.getuWat(), division));
        d2.setBhWat(div(d.getBhWat(), division));
        d2.setShWat(div(d.getShWat(), division));
        d2.setPwirWat(div(d.getPwirWat(), division));
        d2.setPdirWat(div(d.getPdirWat(), division));
        d2.setPvirWat(div(d.getPvirWat(), division));
        d2.setFiWat(div(d.getFiWat(), division));
        d2.setAiWat(div(d.getAiWat(), division));
        d2.setFishWat(div(d.getFishWat(), division));
        d2.setIndWat(div(d.getIndWat(), division));
        d2.setNindWat(div(d.getNindWat(), division));
        Double total = sumXsItems(d2);
        d2.setTotWat(total);
        d2.setXun(type);
        return d2;
    }

    /**
     * 配水数据没有时，设置为需水的数据
     * @param xsResults 需水的数据
     * @return 配水数据
     */
    public List<DdsRdWares> setDefaultFpResults(List<DdsRdWnres> xsResults) {
        List<DdsRdWares> fpResults = new ArrayList<>();
        for (DdsRdWnres d : xsResults) {
            DdsRdWares d2 = parseXsToFp(d);
            d.setTotWat(d2.getTotRs());
            fpResults.add(d2);
        }
        return fpResults;
    }

    /**
     * 转换需水数据为配水表的实体数据
     * @param d 需水数据
     * @return
     */
    public DdsRdWares parseXsToFp(DdsRdWnres d) {
        DdsRdWares d2 = new DdsRdWares();
        d2.setRegCd(d.getRegCd());
        d2.setMonth(d.getMonth());
        d2.setDRs(d.getdWat());
        d2.setURs(d.getuWat());
        d2.setBhRs(d.getBhWat());
        d2.setShRs(d.getShWat());
        d2.setPwirRs(d.getPwirWat());
        d2.setPdirRs(d.getPdirWat());
        d2.setPvirRs(d.getPvirWat());
        d2.setFiRs(d.getFiWat());
        d2.setAiRs(d.getAiWat());
        d2.setMfishRs(d.getFishWat());
        d2.setIndRs(d.getIndWat());
        d2.setNindRs(d.getNindWat());
        d2.setXun(d.getXun());
        Double total = sumXsItems(d);
        d2.setTotRs(total);
        return d2;
    }

    /**
     * 除法
     * @param v1 被除数
     * @param v2 除数
     * @return
     */
    public static Double div(Double v1, Double v2) {
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.divide(b2, 3, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }

    /**
     * 水量分配模型计算
     * @param data 计算数据
     * @return 分配水数据
     */
    public WaterAllocationData calc(WaterAllocationData data, String proCd, String type) {
        List<DdsRdWares> fpResults = setDefaultFpResults(data.getXsResults());
        data.setFqResults(fpResults);
        // 获取年的需水数据进行计算
        List<DdsRdWnres> xsResults = data.getXsResults();
        List<Integer> monthList = getMonthList(1, 13);
        if (TYPE_MONTH.equals(type) || TYPE_XUN.equals(type)) {
            proCd = ddsRdPDao.getDpplCdByProCd(proCd).trim();
            xsResults = ddsRdWnresDao.selectByProCdAndMonth(proCd, monthList);
        }
        sumXsResults(xsResults);
        // 可供水量
        double availableWater = data.getWsResult().getMaxSl() * 10000;
        // 总需水量
        double totalXs = 0.0;
        // 累加求和
        for (DdsRdWnres d : xsResults) {
            totalXs += d.getTotWat();
        }
        // 分配折减
        if (availableWater < totalXs) {
            // 按总量等比例的方式折减
            double rate = totalXs / availableWater;
            for(DdsRdWares d: data.getFqResults()){
                // 计算需要折减的水量
                double discount = d.getTotRs() * (1 - rate);
                // 总量上折减至农业灌溉
                // 减水田
                double nongye = d.getPwirRs();
                BigDecimal totalDis = new BigDecimal(nongye + discount);
                d.setPwirRs(totalDis.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                d.setTotRs(sumFpItems(d));
            }
        }
        return data;
    }

    /**
     * 更新或保存水量分配数据
     * @param data 数据
     * @param proCd 方案编号
     * @param type 类型 year | month | xun
     * @return
     */
    public Boolean saveOrUpdate(WaterAllocationData data, String proCd, String type) {
        List<DdsRdWares> parseData = parseUpdateData(data, proCd, type);
        List<DdsRdWares> fpResults = ddsRdWaresDao.listByProCd(proCd);
        if (fpResults.size() > 0) { // 更新
            // 一次批量更新数据太多的话，会报错!!!!!!!
            // 大于100条时，分次进行更新
            int j = parseData.size() / 100;
            if (j > 0) {
                for (int i = 1; i <= j; i++) {
                    List<DdsRdWares> tempData = parseData.subList(100 * (i - 1), 100 * i);
                    ddsRdWaresDao.batchUpdateWithDate(tempData, proCd);
                }
            }
            List<DdsRdWares> tempData = parseData.subList(100 * j, parseData.size());
            ddsRdWaresDao.batchUpdateWithDate(tempData, proCd);
            ddsRdWaresDao.batchUpdateWithoutDate(data.getTotalResults(), proCd);
        } else {    // 插入
            ddsRdWaresDao.batchInsertWithDate(parseData, proCd);
            ddsRdWaresDao.batchInsertWithoutDate(data.getTotalResults(), proCd);
            // 更新方案状态
            DdsRdP ddsRdP = new DdsRdP();
            ddsRdP.setProCd(proCd);
            ddsRdP.setSta(3);
            ddsRdPService.updateSta(ddsRdP);
        }
        return true;
    }

    /**
     * 转换配水数据，添加开始和结束时间
     * @param data
     * @param proCd
     * @param type
     * @return
     */
    public List<DdsRdWares> parseUpdateData(WaterAllocationData data, String proCd, String type) {
        DdsRdP p0 = new DdsRdP();
        p0.setProCd(proCd);
        DdsRdP solution = ddsRdPDao.get(p0);
        Calendar cal = Calendar.getInstance();
        cal.setTime(solution.getBgDt());
        int year = cal.get(Calendar.YEAR);
        List<DdsRdWares> parseData = new ArrayList<>();
        // 需水->配水
        for (DdsRdWnres d : data.getXsResults()) {
            DdsRdWares d2 = parseXsToFp(d);
            d2.setRsTp(0);
            List<Date> dates = getBtAndEt(year, d2.getMonth(), d.getXun());
            d2.setBt(dates.get(0));
            d2.setEt(dates.get(1));
            parseData.add(d2);
        }
        // 分配水
        for (DdsRdWares d : data.getFqResults()) {
            d.setRsTp(1);
            List<Date> dates = getBtAndEt(year, d.getMonth(), d.getXun());
            d.setBt(dates.get(0));
            d.setEt(dates.get(1));
        }
        parseData.addAll(data.getFqResults());
        return parseData;
    }

    /**
     * 开始和结束时间
     * @param year 当前方案的年份
     * @param month 数据的月份
     * @param xun t | m | d 分别为上旬，中旬和下旬
     * @return [startDate, endDate]
     */
    public List<Date> getBtAndEt(int year, int month, String xun) {
        List<Date> dates = new ArrayList<>();
        try {
            String startMonth = month >= 10 ? String.valueOf(month) :
                    "0" + String.valueOf(month);
            Date start;
            Date end;
            Calendar startCal = Calendar.getInstance();
            if (xun != null) {
                start = sdf.parse(String.valueOf(year) + "-" +
                        startMonth + "-" + XUN_CODE_MAP.get(xun)[0] + " 00:00:00");
                if (TYPE_LAST_XUN.equals(xun)) {
                    startCal.setTime(sdf.parse(String.valueOf(year) + "-" +
                            startMonth + "-01 00:00:00"));
                    startCal.add(Calendar.MONTH, 1);
                    end = startCal.getTime();
                } else {
                    end = sdf.parse(String.valueOf(year) + "-" +
                            startMonth + "-" + XUN_CODE_MAP.get(xun)[1] + " 00:00:00");
                }
            } else {
                start = sdf.parse(String.valueOf(year) + "-" +
                        startMonth + "-01 00:00:00");
                startCal.setTime(start);
                startCal.add(Calendar.MONTH, 1);
                end = startCal.getTime();
            }
            dates.add(start);
            dates.add(end);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dates;
    }

    public void sumFpResults(List<DdsRdWares> fpResults) {
        Double total = 0.0;
        for (DdsRdWares d : fpResults) {
            total = sumFpItems(d);
            d.setTotRs(total);
        }
    }

    public void sumXsResults(List<DdsRdWnres> xsResults) {
        Double total = 0.0;
        for (DdsRdWnres d : xsResults) {
            total = sumXsItems(d);
            d.setTotWat(total);
        }
    }

    // 统计每条总需水
    public static Double sumXsItems(DdsRdWnres d) {
        Double total =  d.getdWat() + d.getuWat() + d.getBhWat() + d.getShWat() + d.getPwirWat() +
                d.getPdirWat() + d.getPvirWat() + d.getFiWat() + d.getAiWat() + d.getFishWat() +
                d.getIndWat() + d.getNindWat();
        BigDecimal b = new BigDecimal(total);
        return b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    // 统计每条总配水
    public static Double sumFpItems(DdsRdWares d) {
        Double total = d.getDRs() + d.getURs() + d.getBhRs() + d.getShRs() + d.getPwirRs() +
                d.getPdirRs() + d.getPvirRs() + d.getFiRs() + d.getAiRs() + d.getMfishRs() +
                d.getIndRs() + d.getNindRs();
        BigDecimal b = new BigDecimal(total);
        return b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
