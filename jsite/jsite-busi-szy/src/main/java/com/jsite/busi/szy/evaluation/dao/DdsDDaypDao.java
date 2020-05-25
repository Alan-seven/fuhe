package com.jsite.busi.szy.evaluation.dao;

import com.jsite.busi.szy.evaluation.po.DdsDDayp;
import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 向靖
 * 创建时间：2017-10-12 17:55
 */
@MyBatisDao
public interface DdsDDaypDao extends CrudDao<DdsDDayp>{
//    Map<String,BigDecimal> getForcast_ljw(String start, String end);
//    Map<String,BigDecimal> getForcast_szl(String start, String end);
//    Map<String,BigDecimal> getForcast_ljd(String start, String end);
//    Map<String,BigDecimal> getForcast_ljc(String start, String end);
    Map<String,BigDecimal> getForcast_mz(String start, String end);

    Map<String,BigDecimal> getYearBySTCD(String QSTCD,String USTCD,int year);

    List<Map> getStationInfo();
    List<Map> getAvgToMonth(String stationName);
    List<Map> getAvgToYear(String stationName);
    List<Map> getAvg();
    String getSecCd(String stationName);
    List<Map> getForcastToMonth(Map map);
//    List<Map> getForcastToDayMap(Map map);


    //
//    Map<String,BigDecimal> getForcast_nf_year(int year);
    Map<String,BigDecimal> getForcast_nf_xun(String start,String end);
//    Map<String,BigDecimal> getXunAvg(String start,String end,String stationName);
//    Map<String,BigDecimal> getXunAvgYear(String start,String end,String stationName,int year);
    List<Map> getForcastToDay(String start,String end,String stationName);
    List<Map> getForcastToDayljc(String start,String end);


    //得到所有年降水平均值
//    Map<String,Double> getAvgP(String name);

    List<Map> getsw_month(String start,String end,String month,String station);
    List<Map> getsw_monthAll(String start,String end,String station);
    List<Map> getsw_monthAllLJW(String start,String end);
//    List<Map> getsw_monthljw(String start,String end,String month);

    //得到Q
    List<Map> getYearAllQ(String start,String end,String station);
//    Map<String,BigDecimal> getMonthAllQ(String start,String end,String month,String station);
//    List<Map> getYearLFAllQ(String start,String end);

    //从预报结果表中查询已经预报的数据
    List<Map> getRunInfoLast(String stationName, String proCd);


    BigDecimal getOneXunU(String start,String end,String station);
    BigDecimal getOneXunQ(String start,String end,String station);
    BigDecimal getAllXunQ(String start,String end,String station);

}
