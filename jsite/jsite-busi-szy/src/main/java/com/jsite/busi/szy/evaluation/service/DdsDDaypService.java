package com.jsite.busi.szy.evaluation.service;

import com.jsite.busi.szy.evaluation.dao.DdsDDaypDao;
import com.jsite.busi.szy.evaluation.po.*;
import com.jsite.busi.szy.evaluation.utils.DataPoint;
import com.jsite.busi.szy.evaluation.utils.RegressionLine;
import com.jsite.busi.szy.evaluation.utils.XAJsimulation;
import com.jsite.manager.AbstractCrudService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 向靖
 * 创建时间：2017-10-12 17:54
 */
@Service
@Transactional(readOnly = true)
public class DdsDDaypService extends AbstractCrudService<DdsDDaypDao, DdsDDayp> {
    private final String START_TIME = "-1-1";
    private final String END_TIME = "-12-31";

    @Autowired
    private DdsDDaypDao ddsDDaypDao;

    public String getSecCd(String stationName) {
        return ddsDDaypDao.getSecCd(stationName);
    }

    public List<Map> getForecastToXun(String stationName, Date date, HttpServletRequest request) throws Exception {
        List<Map> returnMap = new ArrayList<>();
        //求所有年的旬平均值
        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));

        double p = 0.0d;
        if ("廖坊".equals(stationName)) {
            p = division(getForecast("南丰", year)) + division(getForecast("沙子岭", year));
        } else if ("李家渡".equals(stationName)) {
            p = division(getForecast("廖家湾", year) * 0.561) + division(getForecast("娄家村", year) * 1.619);
        } else {
            p = division(getForecast(stationName, year)); //p
        }

        //旬
        Map<String, List<String>> xunMap = getNextAll(date, p, stationName);
        List<String> pList = xunMap.get("pList");
        List<String> xunList = xunMap.get("xunList");
        List<Double> p2List = getXunP2List(stationName, date);
        List<Double> p4List = getXunP4List(stationName, date);


        for (int i = 0; i < pList.size(); i++) {
            Map map = new HashMap();
            double p1 = division(Double.parseDouble(pList.get(i)));
            double p2 = p2List.get(i);
            double p4 = p4List.get(i);

            if (stationName.equals("李家渡")) {
                List<Map<String, Double>> LJDXun = getMapLJDXun();
                for (Map<String, Double> maps : LJDXun) {
                    if (maps.get(xunList.get(i)) != null) {
                        p1 = division(p1 + maps.get(xunList.get(i)));
                        p2 = division(p2 + maps.get(xunList.get(i)));
                        p4 = division(p4 + maps.get(xunList.get(i)));
                    }
                }
            }
//            Map<String, BigDecimal> p2Map = ddsDDaypDao.getXunAvgYear((getStartAndEnd(plusDays(date, i))[0]), (getStartAndEnd(plusDays(date, i))[1]), stationName, (year - 1));
//            double p2 = division(p2Map==null?0:Double.parseDouble(p2Map.get("P_XUN").toString()));//去年的旬的结果
            double p3 = division(p1 - p2);
            double p5 = 0d;
            if (p4 != 0) {
                p5 = division((p1 - p4) / p4 * 100d);
            }
            map.put("month", xunList.get(i));
            map.put("p1", String.valueOf(division(p1)));//预报结果月或者旬
            map.put("p2", String.valueOf(division(p2)));//去年的结果
            map.put("p3", String.valueOf(division(p3)));//p1-p2
            map.put("p4", String.valueOf(division(p4)));//所有的平均值
            map.put("p5", p5 + "");//p1-p4
            map.put("p6", getP6(p5));//丰，平，枯
            returnMap.add(map);
        }

        return returnMap;
    }


    public String getP6(double p5) {
        if (p5 > 20) {
            return "特丰";
        } else if (p5 > 10) {
            return "偏丰";
        } else if (p5 > -10) {
            return "平水";
        } else if (p5 > -20) {
            return "偏枯";
        } else {
            return "特枯";
        }
    }

    public String[] getStartAndEnd(Date date) {
        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        String startTime;
        String endTime;
        if (dayOfMonth <= 10) {
            startTime = month + "-00";
            endTime = month + "-10";
        } else if (dayOfMonth <= 20) {
            startTime = month + "-10";
            endTime = month + "-20";
        } else {
            startTime = month + "-20";
            endTime = month + "-" + days(year, month);
        }
        startTime = formatStr(startTime);
        endTime = formatStr(endTime);

        String[] strs = new String[2];
        strs[0] = startTime;
        strs[1] = endTime;
        return strs;
    }

    public List<Map> getForecastToMonth(Double forecast, String date, String stationName, HttpServletRequest request) throws Exception {
        List<Map> returnMap = new ArrayList<>();
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]) + 1;
        if (month == 13) {
            month = 1;
            year = year + 1;
        }
        //tempL

        List<Map> tempL = getForcastData(stationName, year, request);
        for (int i = month; i < 13; i++) {
            String key = i + "月";
            for (Map tempMap : tempL) {
                if (tempMap.get("month").toString().equals(key)) {
                    double p1 = division(Double.parseDouble(tempMap.get("p1").toString()));
                    if (i == month) {
                        p1 = division(forecast);
                    }
                    /**
                     * 计算方法
                     */
                    double p2 = division(Double.parseDouble(tempMap.get("p2").toString()));
                    double p3 = division(p1 - p2);
                    double p4 = division(Double.parseDouble(tempMap.get("p4").toString()));
                    double p5 = 0d;
                    if (p4 != 0) {
                        p5 = division((p1 - p4) / p4 * 100d);
                    }
                    tempMap.put("month", key);

                    tempMap.put("p1", String.valueOf(division(p1)));
                    tempMap.put("p2", String.valueOf(division(p2)));
                    tempMap.put("p3", String.valueOf(division(p3)));
                    tempMap.put("p4", String.valueOf(division(p4)));
                    tempMap.put("p5", p5 + "");
                    tempMap.put("p6", getP6(p5));
                    returnMap.add(tempMap);
                }
            }
        }
        return returnMap;
    }

    //得到南丰前5个旬的降水数据
    public double[] getNf_forcastBefor5Xun(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;

        String timeStr1, timeStr2, timeStr3, timeStr4, timeStr5, timeStr6;
        if (month == 2) {
            if (day <= 10) {
                timeStr1 = year - 1 + "-12-10";
                timeStr2 = year - 1 + "-12-20";
                timeStr3 = year - 1 + "-12-31";
                timeStr4 = year + "-01-10";
                timeStr5 = year + "-01-20";
                timeStr6 = year + "-01-31";

            } else if (day <= 20) {
                timeStr1 = year - 1 + "-12-20";
                timeStr2 = year - 1 + "-12-31";
                timeStr3 = year + "-01-10";
                timeStr4 = year + "-01-20";
                timeStr5 = year + "-01-31";
                timeStr6 = year + "-02-10";
            } else {
                timeStr1 = year - 1 + "-12-31";
                timeStr2 = year + "-01-10";
                timeStr3 = year + "-01-20";
                timeStr4 = year + "-01-31";
                timeStr5 = year + "-02-10";
                timeStr6 = year + "-02-20";
            }

        } else if (month == 1) {
            if (day <= 10) {
                timeStr1 = year - 1 + "-11-10";
                timeStr2 = year - 1 + "-11-20";
                timeStr3 = year - 1 + "-11-30";
                timeStr4 = year - 1 + "-12-10";
                timeStr5 = year - 1 + "-12-20";
                timeStr6 = year - 1 + "-12-31";

            } else if (day <= 20) {
                timeStr1 = year - 1 + "-11-20";
                timeStr2 = year - 1 + "-11-30";
                timeStr3 = year - 1 + "-12-10";
                timeStr4 = year - 1 + "-12-20";
                timeStr5 = year - 1 + "-12-31";
                timeStr6 = year + "-01-10";
            } else {
                timeStr1 = year - 1 + "-11-30";
                timeStr2 = year - 1 + "-12-10";
                timeStr3 = year - 1 + "-12-20";
                timeStr4 = year - 1 + "-12-31";
                timeStr5 = year + "-01-10";
                timeStr6 = year + "-01-20";
            }
        } else {
            if (day <= 10) {
                timeStr1 = year + "-" + (month - 2) + "-10";
                timeStr2 = year + "-" + (month - 2) + "-20";
                timeStr3 = year + "-" + (month - 2) + "-" + days(year, month - 2);
                timeStr4 = year + "-" + (month - 1) + "-10";
                timeStr5 = year + "-" + (month - 1) + "-20";
                timeStr6 = year + "-" + (month - 1) + "-" + days(year, month - 1);
            } else if (day <= 20) {
                timeStr1 = year + "-" + (month - 2) + "-20";
                timeStr2 = year + "-" + (month - 2) + "-" + days(year, month - 2);
                timeStr3 = year + "-" + (month - 1) + "-10";
                timeStr4 = year + "-" + (month - 1) + "-20";
                timeStr5 = year + "-" + (month - 1) + "-" + days(year, month - 1);
                timeStr6 = year + "-" + month + "-10";
            } else {
                timeStr1 = year + "-" + (month - 2) + "-" + days(year, month - 2);
                ;
                timeStr2 = year + "-" + (month - 1) + "-10";
                timeStr3 = year + "-" + (month - 1) + "-20";
                timeStr4 = year + "-" + (month - 1) + "-" + days(year, month - 1);
                timeStr5 = year + "-" + (month - 1) + "-10";
                timeStr6 = year + "-" + (month - 1) + "-20";
            }

        }
        double[] nf_xun = new double[5];
        Map x0 = ddsDDaypDao.getForcast_nf_xun(formatStr(timeStr1), formatStr(timeStr2));
        Map x1 = ddsDDaypDao.getForcast_nf_xun(formatStr(timeStr2), formatStr(timeStr3));
        Map x2 = ddsDDaypDao.getForcast_nf_xun(formatStr(timeStr3), formatStr(timeStr4));
        Map x3 = ddsDDaypDao.getForcast_nf_xun(formatStr(timeStr4), formatStr(timeStr5));
        Map x4 = ddsDDaypDao.getForcast_nf_xun(formatStr(timeStr5), formatStr(timeStr6));

        nf_xun[0] = x0 == null ? addDeafultOneXunU(dateStrToXun(timeStr2),"南丰") : division(Double.parseDouble(x0.get("P_XUN").toString()));
        nf_xun[1] = x1 == null ? addDeafultOneXunU(dateStrToXun(timeStr3),"南丰") : division(Double.parseDouble(x1.get("P_XUN").toString()));
        nf_xun[2] = x2 == null ? addDeafultOneXunU(dateStrToXun(timeStr4),"南丰") : division(Double.parseDouble(x2.get("P_XUN").toString()));
        nf_xun[3] = x3 == null ? addDeafultOneXunU(dateStrToXun(timeStr5),"南丰") : division(Double.parseDouble(x3.get("P_XUN").toString()));
        nf_xun[4] = x4 == null ? addDeafultOneXunU(dateStrToXun(timeStr6),"南丰") : division(Double.parseDouble(x4.get("P_XUN").toString()));
        return nf_xun;
    }

    //运用线性回归计算,返回南丰当前旬
    public double getData(double[] data) {
        RegressionLine line = new RegressionLine();
        for (int i = 0; i < data.length; i++) {
            line.addDataPoint(new DataPoint(i + 1, data[i]));
        }
        //①选取不同的旬，线性拟合方程是不同；②如果遇到预测降水量（x6）小于0的情况，则认为x6为前两年降水量的平均值，即x6=(x5+x4)*0.5。
        double nf_xun = line.getValue(6);
        if (nf_xun < 0) {
            nf_xun = (data[3] + data[4]) / 2;
        }
        double result = division(0.28 * nf_xun + 9.0265);
        return result;
    }

    public double getxun1(Date date) {
        return getData(getNf_forcastBefor5Xun(date));
    }

    public double getxun2(Date date) {
        double[] before5Xun = getNf_forcastBefor5Xun(date);
        double[] new5 = new double[5];
        for (int i = 0; i < 4; i++) {
            new5[i] = before5Xun[i];
        }
        new5[4] = getxun1(date);
        return getData(new5);
    }

    public double getxun3(Date date) {
        double[] befor5Xun = getNf_forcastBefor5Xun(date);
        double[] new5 = new double[5];
        for (int i = 0; i < 3; i++) {
            new5[i] = befor5Xun[i];
        }
        new5[3] = getxun1(date);
        new5[4] = getxun2(date);
        return getData(new5);
    }

    public String formatStr(String str) {

        String[] split = str.split("-");
        String fmStr = "";
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() == 1) {
                split[i] = "0" + split[i];
            }
            fmStr += split[i] + "-";
        }

        return fmStr.substring(0, fmStr.length() - 1);
    }

    private String dateStrToXun(String dateStr){
        String[] split = dateStr.split("-");
        String month = split[1];
        int day = Integer.parseInt(split[2]);
        if(day == 10){
            return month+"月上";
        }else if(day == 20) {
            return month + "月中";
        }else{
            return month +"月下";
        }


    }


    public int days(int year, int month) {
        int days = 0;
        if (month != 2) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;

            }
        } else {
            // 闰年
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                days = 29;
            else
                days = 28;

        }
        return days;
    }


    public Map<String, List<String>> getNextAll(Date date, double result, String stationName) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        String startTime = null;
        if (dayOfMonth <= 10) {
            if (month > 1) {
                startTime = formatStr(year + "-" + (month - 1) + "-" + days(year, month - 1));
            } else {
                startTime = formatStr((year - 1) + "-12-31");
            }
        } else if (dayOfMonth <= 20) {
            startTime = formatStr(year + "-" + month + "-10");
        } else {
            startTime = formatStr(year + "-" + month + "-20");
        }

        List<String> nextXunList = getNextXunList(startTime);
        Map<String, List<String>> next3More = getNext3More(date, result, stationName);
        List<String> pList = next3More.get("pList");
        Map<String, List<String>> resultMap = new HashMap<>();

        if ("洪门".equals(stationName)) {
            if (nextXunList.size() >= 3) {
                pList.set(0, getxun1(date) + "");
                pList.set(1, getxun2(date) + "");
                pList.set(2, getxun3(date) + "");
            } else if (nextXunList.size() == 2) {
                pList.set(0, getxun1(date) + "");
                pList.set(1, getxun2(date) + "");
            } else if (nextXunList.size() == 1) {
                pList.set(0, getxun1(date) + "");
            }
            resultMap.put("xunList", nextXunList);
            resultMap.put("pList", pList);
            return resultMap;
        }

        if ("李家渡".equals(stationName)) {

            for (int i = 0; i < (nextXunList.size() < 3 ? nextXunList.size() : 3); i++) {
                pList.set(0, division(
                        Double.parseDouble(getNext3More(plusDays(date, i), getForcastToXun("廖家湾", plusDays(date, i)), stationName).get("pList").get(0))
                                * 0.680095305 +
                                Double.parseDouble(getNext3More(plusDays(date, i), getForcastToXun("娄家村", plusDays(date, i)), stationName).get("pList").get(0))
                                        * 1.489469784) + "");
            }
            resultMap.put("xunList", nextXunList);
            resultMap.put("pList", pList);
            return resultMap;
        }

        if ("廖坊".equals(stationName)) {
            if (nextXunList.size() >= 3) {
                pList.set(0, (
                        Double.parseDouble(getNext3More(plusDays(date, 0), getForcastToXun("南丰", plusDays(date, 0)), stationName).get("pList").get(0))
                                + getxun1(date)) + "");
                pList.set(1, (
                        Double.parseDouble(getNext3More(plusDays(date, 1), getForcastToXun("南丰", plusDays(date, 1)), stationName).get("pList").get(0))
                                + getxun2(date)) + "");
                pList.set(2, (
                        Double.parseDouble(getNext3More(plusDays(date, 2), getForcastToXun("南丰", plusDays(date, 2)), stationName).get("pList").get(0))
                                + getxun2(date)) + "");
            } else if (nextXunList.size() == 2) {
                pList.set(0, (
                        Double.parseDouble(getNext3More(plusDays(date, 0), getForcastToXun("南丰", plusDays(date, 0)), stationName).get("pList").get(0))
                                + getxun1(date)) + "");
                pList.set(1, (
                        Double.parseDouble(getNext3More(plusDays(date, 1), getForcastToXun("南丰", plusDays(date, 1)), stationName).get("pList").get(0))
                                + getxun2(date)) + "");
            } else if (nextXunList.size() == 1) {
                pList.set(0, (
                        Double.parseDouble(getNext3More(plusDays(date, 0), getForcastToXun("南丰", plusDays(date, 0)), stationName).get("pList").get(0))
                                + getxun1(date)) + "");
            }
            resultMap.put("xunList", nextXunList);
            resultMap.put("pList", pList);
            return resultMap;
        }


        for (int i = 0; i < (nextXunList.size() < 3 ? nextXunList.size() : 3); i++) {

            Map<String, List<String>> next3More1 = getNext3More(plusDays(date, i), getForcastToXun(stationName, plusDays(date, i)), stationName);
            if (stationName.equals("洪门")) {
                pList.set(i,
                        next3More1.get("pList") == null ? "0" : 3.4049 * Double.parseDouble(next3More1.get("pList").get(0).toString()) + ""
                );
            } else {
                pList.set(i,
                        next3More1.get("pList") == null ? "0" : Double.parseDouble(next3More1.get("pList").get(0).toString()) + ""
                );
            }

        }

        resultMap.put("xunList", nextXunList);
        resultMap.put("pList", pList);
        return resultMap;
    }


    public Date plusDays(Date date, int xuns) {
        try {
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, xuns * 10);
            if (calendar.get(Calendar.DAY_OF_MONTH) == 31) {
                calendar.add(Calendar.DATE, 1);
            }
            String format = sdFormat.format(calendar.getTime());
            return sdFormat.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //得到剩下的所有的旬
    public List<String> getNextXunList(String start) {
        String startXun = getFromatXun(start);
        List<String> xunList = getXunLists();
        List<String> nextxunList = new ArrayList<>();
        boolean flag = false;
        boolean flag1 = false;
        String[] startX = startXun.split("年");
        int year = Integer.parseInt(startX[0]);//1988
        String mxun = startX[1];//1月下
        for (int j = 0; j < xunList.size(); j++) {
            if (xunList.get(j).equals(mxun)) {
                flag = true;
            }
            if (flag) {
                nextxunList.add(xunList.get(j));
            }
        }
        return nextxunList;
    }

    public Map<String, List<String>> getNext3More(Date date, double result, String areaName) {

        DecimalFormat df = new DecimalFormat("#.0");
        /***茅洲站**/
        Map<String, Double> MZMap = new HashMap<String, Double>();
        MZMap.put("1月上", Double.parseDouble(df.format(result * 0.010795435 * 360 / 10)));
        MZMap.put("1月中", Double.parseDouble(df.format(result * 0.013162171 * 360 / 10)));
        MZMap.put("1月下", Double.parseDouble(df.format(result * 0.013454125 * 360 / 10)));
        MZMap.put("2月上", Double.parseDouble(df.format(result * 0.01695358 * 360 / 10)));
        MZMap.put("2月中", Double.parseDouble(df.format(result * 0.021101485 * 360 / 10)));
        MZMap.put("2月下", Double.parseDouble(df.format(result * 0.026021348 * 360 / 10)));
        MZMap.put("3月上", Double.parseDouble(df.format(result * 0.029044941 * 360 / 10)));
        MZMap.put("3月中", Double.parseDouble(df.format(result * 0.032930085 * 360 / 10)));
        MZMap.put("3月下", Double.parseDouble(df.format(result * 0.046953487 * 360 / 10)));
        MZMap.put("4月上", Double.parseDouble(df.format(result * 0.050849069 * 360 / 10)));
        MZMap.put("4月中", Double.parseDouble(df.format(result * 0.05356308 * 360 / 10)));
        MZMap.put("4月下", Double.parseDouble(df.format(result * 0.045163368 * 360 / 10)));
        MZMap.put("5月上", Double.parseDouble(df.format(result * 0.051511055 * 360 / 10)));
        MZMap.put("5月中", Double.parseDouble(df.format(result * 0.047026039 * 360 / 10)));
        MZMap.put("5月下", Double.parseDouble(df.format(result * 0.041027662 * 360 / 10)));
        MZMap.put("6月上", Double.parseDouble(df.format(result * 0.040072645 * 360 / 10)));
        MZMap.put("6月中", Double.parseDouble(df.format(result * 0.0637769 * 360 / 10)));
        MZMap.put("6月下", Double.parseDouble(df.format(result * 0.048317824 * 360 / 10)));
        MZMap.put("7月上", Double.parseDouble(df.format(result * 0.059177255 * 360 / 10)));
        MZMap.put("7月中", Double.parseDouble(df.format(result * 0.028289031 * 360 / 10)));
        MZMap.put("7月下", Double.parseDouble(df.format(result * 0.018458504 * 360 / 10)));
        MZMap.put("8月上", Double.parseDouble(df.format(result * 0.019943716 * 360 / 10)));
        MZMap.put("8月中", Double.parseDouble(df.format(result * 0.022124863 * 360 / 10)));
        MZMap.put("8月下", Double.parseDouble(df.format(result * 0.015910251 * 360 / 10)));
        MZMap.put("9月上", Double.parseDouble(df.format(result * 0.023376331 * 360 / 10)));
        MZMap.put("9月中", Double.parseDouble(df.format(result * 0.015062863 * 360 / 10)));
        MZMap.put("9月下", Double.parseDouble(df.format(result * 0.016177529 * 360 / 10)));
        MZMap.put("10月上", Double.parseDouble(df.format(result * 0.016204634 * 360 / 10)));
        MZMap.put("10月中", Double.parseDouble(df.format(result * 0.018183063 * 360 / 10)));
        MZMap.put("10月下", Double.parseDouble(df.format(result * 0.016239678 * 360 / 10)));
        MZMap.put("11月上", Double.parseDouble(df.format(result * 0.016360107 * 360 / 10)));
        MZMap.put("11月中", Double.parseDouble(df.format(result * 0.013662096 * 360 / 10)));
        MZMap.put("11月下", Double.parseDouble(df.format(result * 0.015151705 * 360 / 10)));
        MZMap.put("12月上", Double.parseDouble(df.format(result * 0.011369332 * 360 / 10)));
        MZMap.put("12月中", Double.parseDouble(df.format(result * 0.012471951 * 360 / 10)));
        MZMap.put("12月下", Double.parseDouble(df.format(result * 0.010112795 * 360 / 10)));

        /****** 洪门以上来水预报 *********/
        Map<String, Double> HMMap = new HashMap<String, Double>();
        HMMap.put("1月上", Double.parseDouble(df.format(result * 0.011162 * 360 / 10)));
        HMMap.put("1月中", Double.parseDouble(df.format(result * 0.009885 * 360 / 10)));
        HMMap.put("1月下", Double.parseDouble(df.format(result * 0.009635 * 360 / 10)));
        HMMap.put("2月上", Double.parseDouble(df.format(result * 0.016279 * 360 / 10)));
        HMMap.put("2月中", Double.parseDouble(df.format(result * 0.017589 * 360 / 10)));
        HMMap.put("2月下", Double.parseDouble(df.format(result * 0.025466 * 360 / 10)));
        HMMap.put("3月上", Double.parseDouble(df.format(result * 0.028793 * 360 / 10)));
        HMMap.put("3月中", Double.parseDouble(df.format(result * 0.033228 * 360 / 10)));
        HMMap.put("3月下", Double.parseDouble(df.format(result * 0.036355 * 360 / 10)));
        HMMap.put("4月上", Double.parseDouble(df.format(result * 0.06278 * 360 / 10)));
        HMMap.put("4月中", Double.parseDouble(df.format(result * 0.055458 * 360 / 10)));
        HMMap.put("4月下", Double.parseDouble(df.format(result * 0.055016 * 360 / 10)));
        HMMap.put("5月上", Double.parseDouble(df.format(result * 0.058833 * 360 / 10)));
        HMMap.put("5月中", Double.parseDouble(df.format(result * 0.055832 * 360 / 10)));
        HMMap.put("5月下", Double.parseDouble(df.format(result * 0.050186 * 360 / 10)));
        HMMap.put("6月上", Double.parseDouble(df.format(result * 0.046174 * 360 / 10)));
        HMMap.put("6月中", Double.parseDouble(df.format(result * 0.081587 * 360 / 10)));
        HMMap.put("6月下", Double.parseDouble(df.format(result * 0.053758 * 360 / 10)));
        HMMap.put("7月上", Double.parseDouble(df.format(result * 0.04055 * 360 / 10)));
        HMMap.put("7月中", Double.parseDouble(df.format(result * 0.024605 * 360 / 10)));
        HMMap.put("7月下", Double.parseDouble(df.format(result * 0.017791 * 360 / 10)));
        HMMap.put("8月上", Double.parseDouble(df.format(result * 0.014993 * 360 / 10)));
        HMMap.put("8月中", Double.parseDouble(df.format(result * 0.016734 * 360 / 10)));
        HMMap.put("8月下", Double.parseDouble(df.format(result * 0.015967 * 360 / 10)));
        HMMap.put("9月上", Double.parseDouble(df.format(result * 0.017256 * 360 / 10)));
        HMMap.put("9月中", Double.parseDouble(df.format(result * 0.01531 * 360 / 10)));
        HMMap.put("9月下", Double.parseDouble(df.format(result * 0.016734 * 360 / 10)));
        HMMap.put("10月上", Double.parseDouble(df.format(result * 0.013052 * 360 / 10)));
        HMMap.put("10月中", Double.parseDouble(df.format(result * 0.013027 * 360 / 10)));
        HMMap.put("10月下", Double.parseDouble(df.format(result * 0.014859 * 360 / 10)));
        HMMap.put("11月上", Double.parseDouble(df.format(result * 0.014944 * 360 / 10)));
        HMMap.put("11月中", Double.parseDouble(df.format(result * 0.012166 * 360 / 10)));
        HMMap.put("11月下", Double.parseDouble(df.format(result * 0.014671 * 360 / 10)));
        HMMap.put("12月上", Double.parseDouble(df.format(result * 0.011267 * 360 / 10)));
        HMMap.put("12月中", Double.parseDouble(df.format(result * 0.009513 * 360 / 10)));
        HMMap.put("12月下", Double.parseDouble(df.format(result * 0.008548 * 360 / 10)));

        /****** 廖家湾以上来水预报 *********/
        Map<String, Double> LJWMap = new HashMap<String, Double>();
        LJWMap.put("1月上", Double.parseDouble(df.format(result * 0.01119539 * 360 / 10)));
        LJWMap.put("1月中", Double.parseDouble(df.format(result * 0.012905182 * 360 / 10)));
        LJWMap.put("1月下", Double.parseDouble(df.format(result * 0.013314642 * 360 / 10)));
        LJWMap.put("2月上", Double.parseDouble(df.format(result * 0.015965593 * 360 / 10)));
        LJWMap.put("2月中", Double.parseDouble(df.format(result * 0.019603171 * 360 / 10)));
        LJWMap.put("2月下", Double.parseDouble(df.format(result * 0.021145146 * 360 / 10)));
        LJWMap.put("3月上", Double.parseDouble(df.format(result * 0.027720569 * 360 / 10)));
        LJWMap.put("3月中", Double.parseDouble(df.format(result * 0.028111374 * 360 / 10)));
        LJWMap.put("3月下", Double.parseDouble(df.format(result * 0.039261281 * 360 / 10)));
        LJWMap.put("4月上", Double.parseDouble(df.format(result * 0.044440269 * 360 / 10)));
        LJWMap.put("4月中", Double.parseDouble(df.format(result * 0.047293373 * 360 / 10)));
        LJWMap.put("4月下", Double.parseDouble(df.format(result * 0.046839837 * 360 / 10)));
        LJWMap.put("5月上", Double.parseDouble(df.format(result * 0.047311886 * 360 / 10)));
        LJWMap.put("5月中", Double.parseDouble(df.format(result * 0.048134051 * 360 / 10)));
        LJWMap.put("5月下", Double.parseDouble(df.format(result * 0.042491042 * 360 / 10)));
        LJWMap.put("6月上", Double.parseDouble(df.format(result * 0.049893389 * 360 / 10)));
        LJWMap.put("6月中", Double.parseDouble(df.format(result * 0.072165433 * 360 / 10)));
        LJWMap.put("6月下", Double.parseDouble(df.format(result * 0.065126585 * 360 / 10)));
        LJWMap.put("7月上", Double.parseDouble(df.format(result * 0.047742581 * 360 / 10)));
        LJWMap.put("7月中", Double.parseDouble(df.format(result * 0.032345731 * 360 / 10)));
        LJWMap.put("7月下", Double.parseDouble(df.format(result * 0.023993054 * 360 / 10)));
        LJWMap.put("8月上", Double.parseDouble(df.format(result * 0.021896589 * 360 / 10)));
        LJWMap.put("8月中", Double.parseDouble(df.format(result * 0.023631453 * 360 / 10)));
        LJWMap.put("8月下", Double.parseDouble(df.format(result * 0.018517997 * 360 / 10)));
        LJWMap.put("9月上", Double.parseDouble(df.format(result * 0.018517997 * 360 / 10)));
        LJWMap.put("9月中", Double.parseDouble(df.format(result * 0.01528404 * 360 / 10)));
        LJWMap.put("9月下", Double.parseDouble(df.format(result * 0.014501698 * 360 / 10)));
        LJWMap.put("10月上", Double.parseDouble(df.format(result * 0.014349498 * 360 / 10)));
        LJWMap.put("10月中", Double.parseDouble(df.format(result * 0.014479556 * 360 / 10)));
        LJWMap.put("10月下", Double.parseDouble(df.format(result * 0.01544134 * 360 / 10)));
        LJWMap.put("11月上", Double.parseDouble(df.format(result * 0.015687664 * 360 / 10)));
        LJWMap.put("11月中", Double.parseDouble(df.format(result * 0.014185378 * 360 / 10)));
        LJWMap.put("11月下", Double.parseDouble(df.format(result * 0.015278546 * 360 / 10)));
        LJWMap.put("12月上", Double.parseDouble(df.format(result * 0.013184409 * 360 / 10)));
        LJWMap.put("12月中", Double.parseDouble(df.format(result * 0.011805954 * 360 / 10)));
        LJWMap.put("12月下", Double.parseDouble(df.format(result * 0.01185158 * 360 / 10)));

        /****** 娄家村以上来水预报 *********/
        Map<String, Double> LJCMap = new HashMap<String, Double>();
        LJCMap.put("1月上", Double.parseDouble(df.format(result * 0.010404 * 360 / 10)));
        LJCMap.put("1月中", Double.parseDouble(df.format(result * 0.013067 * 360 / 10)));
        LJCMap.put("1月下", Double.parseDouble(df.format(result * 0.014786 * 360 / 10)));
        LJCMap.put("2月上", Double.parseDouble(df.format(result * 0.016422 * 360 / 10)));
        LJCMap.put("2月中", Double.parseDouble(df.format(result * 0.022598 * 360 / 10)));
        LJCMap.put("2月下", Double.parseDouble(df.format(result * 0.02362 * 360 / 10)));
        LJCMap.put("3月上", Double.parseDouble(df.format(result * 0.029611 * 360 / 10)));
        LJCMap.put("3月中", Double.parseDouble(df.format(result * 0.031959 * 360 / 10)));
        LJCMap.put("3月下", Double.parseDouble(df.format(result * 0.043245 * 360 / 10)));
        LJCMap.put("4月上", Double.parseDouble(df.format(result * 0.048761 * 360 / 10)));
        LJCMap.put("4月中", Double.parseDouble(df.format(result * 0.052325 * 360 / 10)));
        LJCMap.put("4月下", Double.parseDouble(df.format(result * 0.050964 * 360 / 10)));
        LJCMap.put("5月上", Double.parseDouble(df.format(result * 0.049316 * 360 / 10)));
        LJCMap.put("5月中", Double.parseDouble(df.format(result * 0.047376 * 360 / 10)));
        LJCMap.put("5月下", Double.parseDouble(df.format(result * 0.041821 * 360 / 10)));
        LJCMap.put("6月上", Double.parseDouble(df.format(result * 0.047735 * 360 / 10)));
        LJCMap.put("6月中", Double.parseDouble(df.format(result * 0.077628 * 360 / 10)));
        LJCMap.put("6月下", Double.parseDouble(df.format(result * 0.062175 * 360 / 10)));
        LJCMap.put("7月上", Double.parseDouble(df.format(result * 0.045817 * 360 / 10)));
        LJCMap.put("7月中", Double.parseDouble(df.format(result * 0.026277 * 360 / 10)));
        LJCMap.put("7月下", Double.parseDouble(df.format(result * 0.018006 * 360 / 10)));
        LJCMap.put("8月上", Double.parseDouble(df.format(result * 0.019324 * 360 / 10)));
        LJCMap.put("8月中", Double.parseDouble(df.format(result * 0.020997 * 360 / 10)));
        LJCMap.put("8月下", Double.parseDouble(df.format(result * 0.019084 * 360 / 10)));
        LJCMap.put("9月上", Double.parseDouble(df.format(result * 0.024381 * 360 / 10)));
        LJCMap.put("9月中", Double.parseDouble(df.format(result * 0.014885 * 360 / 10)));
        LJCMap.put("9月下", Double.parseDouble(df.format(result * 0.014666 * 360 / 10)));
        LJCMap.put("10月上", Double.parseDouble(df.format(result * 0.012376 * 360 / 10)));
        LJCMap.put("10月中", Double.parseDouble(df.format(result * 0.011437 * 360 / 10)));
        LJCMap.put("10月下", Double.parseDouble(df.format(result * 0.013304 * 360 / 10)));
        LJCMap.put("11月上", Double.parseDouble(df.format(result * 0.015222 * 360 / 10)));
        LJCMap.put("11月中", Double.parseDouble(df.format(result * 0.013321 * 360 / 10)));
        LJCMap.put("11月下", Double.parseDouble(df.format(result * 0.014376 * 360 / 10)));
        LJCMap.put("12月上", Double.parseDouble(df.format(result * 0.01146 * 360 / 10)));
        LJCMap.put("12月中", Double.parseDouble(df.format(result * 0.011106 * 360 / 10)));
        LJCMap.put("12月下", Double.parseDouble(df.format(result * 0.010145 * 360 / 10)));

        /******沙子岭*********/
        Map<String, Double> SZLMap = new HashMap<String, Double>();
        SZLMap.put("1月上", Double.parseDouble(df.format(result * 0.012222921 * 360 / 10)));
        SZLMap.put("1月中", Double.parseDouble(df.format(result * 0.015552773 * 360 / 10)));
        SZLMap.put("1月下", Double.parseDouble(df.format(result * 0.016739669 * 360 / 10)));
        SZLMap.put("2月上", Double.parseDouble(df.format(result * 0.022418307 * 360 / 10)));
        SZLMap.put("2月中", Double.parseDouble(df.format(result * 0.025655823 * 360 / 10)));
        SZLMap.put("2月下", Double.parseDouble(df.format(result * 0.025103733 * 360 / 10)));
        SZLMap.put("3月上", Double.parseDouble(df.format(result * 0.028018075 * 360 / 10)));
        SZLMap.put("3月中", Double.parseDouble(df.format(result * 0.042982208 * 360 / 10)));
        SZLMap.put("3月下", Double.parseDouble(df.format(result * 0.051080807 * 360 / 10)));
        SZLMap.put("4月上", Double.parseDouble(df.format(result * 0.052225383 * 360 / 10)));
        SZLMap.put("4月中", Double.parseDouble(df.format(result * 0.046250503 * 360 / 10)));
        SZLMap.put("4月下", Double.parseDouble(df.format(result * 0.040560323 * 360 / 10)));
        SZLMap.put("5月上", Double.parseDouble(df.format(result * 0.049653453 * 360 / 10)));
        SZLMap.put("5月中", Double.parseDouble(df.format(result * 0.043340008 * 360 / 10)));
        SZLMap.put("5月下", Double.parseDouble(df.format(result * 0.057844388 * 360 / 10)));
        SZLMap.put("6月上", Double.parseDouble(df.format(result * 0.044680798 * 360 / 10)));
        SZLMap.put("6月中", Double.parseDouble(df.format(result * 0.082717282 * 360 / 10)));
        SZLMap.put("6月下", Double.parseDouble(df.format(result * 0.045979267 * 360 / 10)));
        SZLMap.put("7月上", Double.parseDouble(df.format(result * 0.030616936 * 360 / 10)));
        SZLMap.put("7月中", Double.parseDouble(df.format(result * 0.023801417 * 360 / 10)));
        SZLMap.put("7月下", Double.parseDouble(df.format(result * 0.019825216 * 360 / 10)));
        SZLMap.put("8月上", Double.parseDouble(df.format(result * 0.022726092 * 360 / 10)));
        SZLMap.put("8月中", Double.parseDouble(df.format(result * 0.030007137 * 360 / 10)));
        SZLMap.put("8月下", Double.parseDouble(df.format(result * 0.02757371 * 360 / 10)));
        SZLMap.put("9月上", Double.parseDouble(df.format(result * 0.021048663 * 360 / 10)));
        SZLMap.put("9月中", Double.parseDouble(df.format(result * 0.01266921 * 360 / 10)));
        SZLMap.put("9月下", Double.parseDouble(df.format(result * 0.010532026 * 360 / 10)));
        SZLMap.put("10月上", Double.parseDouble(df.format(result * 0.015748986 * 360 / 10)));
        SZLMap.put("10月中", Double.parseDouble(df.format(result * 0.010605125 * 360 / 10)));
        SZLMap.put("10月下", Double.parseDouble(df.format(result * 0.013881114 * 360 / 10)));
        SZLMap.put("11月上", Double.parseDouble(df.format(result * 0.011661213 * 360 / 10)));
        SZLMap.put("11月中", Double.parseDouble(df.format(result * 0.012821179 * 360 / 10)));
        SZLMap.put("11月下", Double.parseDouble(df.format(result * 0.01107065 * 360 / 10)));
        SZLMap.put("12月上", Double.parseDouble(df.format(result * 0.007815821 * 360 / 10)));
        SZLMap.put("12月中", Double.parseDouble(df.format(result * 0.006992496 * 360 / 10)));
        SZLMap.put("12月下", Double.parseDouble(df.format(result * 0.007577288 * 360 / 10)));

        /*********南丰************/
        Map<String, Double> NFMap = new HashMap<String, Double>();
        NFMap.put("1月上", Double.parseDouble(df.format(result * 0.008379781 * 360 / 10)));
        NFMap.put("1月中", Double.parseDouble(df.format(result * 0.008074924 * 360 / 10)));
        NFMap.put("1月下", Double.parseDouble(df.format(result * 0.011554474 * 360 / 10)));
        NFMap.put("2月上", Double.parseDouble(df.format(result * 0.015776965 * 360 / 10)));
        NFMap.put("2月中", Double.parseDouble(df.format(result * 0.023149795 * 360 / 10)));
        NFMap.put("2月下", Double.parseDouble(df.format(result * 0.019239823 * 360 / 10)));
        NFMap.put("3月上", Double.parseDouble(df.format(result * 0.016271622 * 360 / 10)));
        NFMap.put("3月中", Double.parseDouble(df.format(result * 0.019351263 * 360 / 10)));
        NFMap.put("3月下", Double.parseDouble(df.format(result * 0.042247812 * 360 / 10)));
        NFMap.put("4月上", Double.parseDouble(df.format(result * 0.031773964 * 360 / 10)));
        NFMap.put("4月中", Double.parseDouble(df.format(result * 0.042770642 * 360 / 10)));
        NFMap.put("4月下", Double.parseDouble(df.format(result * 0.040824766 * 360 / 10)));
        NFMap.put("5月上", Double.parseDouble(df.format(result * 0.047731492 * 360 / 10)));
        NFMap.put("5月中", Double.parseDouble(df.format(result * 0.041840115 * 360 / 10)));
        NFMap.put("5月下", Double.parseDouble(df.format(result * 0.061182827 * 360 / 10)));
        NFMap.put("6月上", Double.parseDouble(df.format(result * 0.068484424 * 360 / 10)));
        NFMap.put("6月中", Double.parseDouble(df.format(result * 0.09095396 * 360 / 10)));
        NFMap.put("6月下", Double.parseDouble(df.format(result * 0.092411058 * 360 / 10)));
        NFMap.put("7月上", Double.parseDouble(df.format(result * 0.032728006 * 360 / 10)));
        NFMap.put("7月中", Double.parseDouble(df.format(result * 0.027318689 * 360 / 10)));
        NFMap.put("7月下", Double.parseDouble(df.format(result * 0.023358606 * 360 / 10)));
        NFMap.put("8月上", Double.parseDouble(df.format(result * 0.019249644 * 360 / 10)));
        NFMap.put("8月中", Double.parseDouble(df.format(result * 0.017803464 * 360 / 10)));
        NFMap.put("8月下", Double.parseDouble(df.format(result * 0.02192174 * 360 / 10)));
        NFMap.put("9月上", Double.parseDouble(df.format(result * 0.02779823 * 360 / 10)));
        NFMap.put("9月中", Double.parseDouble(df.format(result * 0.019779574 * 360 / 10)));
        NFMap.put("9月下", Double.parseDouble(df.format(result * 0.013161748 * 360 / 10)));
        NFMap.put("10月上", Double.parseDouble(df.format(result * 0.019772856 * 360 / 10)));
        NFMap.put("10月中", Double.parseDouble(df.format(result * 0.012693125 * 360 / 10)));
        NFMap.put("10月下", Double.parseDouble(df.format(result * 0.010699379 * 360 / 10)));
        NFMap.put("11月上", Double.parseDouble(df.format(result * 0.010971483 * 360 / 10)));
        NFMap.put("11月中", Double.parseDouble(df.format(result * 0.01281406 * 360 / 10)));
        NFMap.put("11月下", Double.parseDouble(df.format(result * 0.018509758 * 360 / 10)));
        NFMap.put("12月上", Double.parseDouble(df.format(result * 0.009840237 * 360 / 10)));
        NFMap.put("12月中", Double.parseDouble(df.format(result * 0.009810843 * 360 / 10)));
        NFMap.put("12月下", Double.parseDouble(df.format(result * 0.009748849 * 360 / 10)));


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        String startTime = null;
        if (dayOfMonth <= 10) {
            if (month > 1) {
                startTime = formatStr(year + "-" + (month - 1) + "-" + days(year, month - 1));
            } else {
                startTime = formatStr((year - 1) + "-12-31");
            }
        } else if (dayOfMonth <= 20) {
            startTime = formatStr(year + "-" + month + "-10");
        } else {
            startTime = formatStr(year + "-" + month + "-20");
        }
        List<String> nextXunList = getNextXunList(startTime);

        Map<String, List<String>> resultMap = new HashMap<>();
        ArrayList<String> pList = new ArrayList<>();
        for (int i = 0; i < nextXunList.size(); i++) {
            if ("洪门".equals(areaName)) {
                Double value = HMMap.get(nextXunList.get(i));
                pList.add(value.toString());
            } else if ("南丰".equals(areaName) || "廖坊".equals(areaName)) {
                Double value = NFMap.get(nextXunList.get(i));
                pList.add(value.toString());
            } else if ("廖家湾".equals(areaName)) {
                Double value = LJWMap.get(nextXunList.get(i));
                pList.add(value.toString());
            } else if ("娄家村".equals(areaName)) {
                Double value = LJCMap.get(nextXunList.get(i));
                pList.add(value.toString());
            } else if ("李家渡".equals(areaName)) {
                Double value = division(LJWMap.get(nextXunList.get(i)) * 0.680095305 + LJCMap.get(nextXunList.get(i)) * 1.489469784);
                pList.add(value.toString());
            } else if ("沙子岭".equals(areaName)) {
                Double value = SZLMap.get(nextXunList.get(i));
                pList.add(value.toString());
            } else if ("茅洲".equals(areaName)) {
                Double value = MZMap.get(nextXunList.get(i));
                pList.add(value.toString());
            }
        }
        resultMap.put("xunList", nextXunList);
        resultMap.put("pList", pList);
        return resultMap;
    }

    public List<Map> getNextMonth(String stationName, Date date, HttpServletRequest request) throws Exception {
        double p = 0.0d;
        List<String> mlist = new ArrayList<String>();
        if (stationName.equals("李家渡")) {
            p = Double.parseDouble(getForcastToMonth("廖家湾", date).get("plist").get(0)) * 0.561 + 1.619 * Double.parseDouble(getForcastToMonth("娄家村", date).get("plist").get(0));
            mlist = getForcastToMonth("廖家湾", date).get("mlist");
        } else if (stationName.equals("廖坊")) {
            double p_hm = 0.0d;
            double p_nf = Double.parseDouble(getForcastToMonth("南丰", date).get("plist").get(0));
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
            int year = Integer.parseInt(df.format(date).split("-")[0]);
            int month = Integer.parseInt(df.format(date).split("-")[1]);
            List<Map> hmMap = getForcastData("洪门", year, request);
            for (Map tempMap : hmMap) {
                if (tempMap.get("month").equals(month + "月")) {
                    p_hm = Double.parseDouble(tempMap.get("p1").toString());
                    break;
                }
            }
            p = 1.4935 * (p_nf + p_hm);
            mlist = getForcastToMonth("南丰", date).get("mlist");
        } else if ("茅洲".equals(stationName)) {
            p = 9.2752 * Double.parseDouble(getForcastToMonth(stationName, date).get("plist").get(0));
            mlist = getForcastToMonth(stationName, date).get("mlist");
        } else {
            p = Double.parseDouble(getForcastToMonth(stationName, date).get("plist").get(0));
            mlist = getForcastToMonth(stationName, date).get("mlist");
        }
        return getForecastToMonth(p, mlist.get(mlist.size() - 1), stationName, request);
    }


    /**
     * @param stationName 月的统计模型的计算方法
     * @param date
     * @return Map<String,List<String>> "pList:对应的结果,mList：剩下月份的集合[年-月]" 单位：亿m3
     * @throws Exception
     */
    public Map<String, List<String>> getForcastToMonth(String stationName, Date date) throws Exception {
        Map<String, List<String>> returnMap = new HashMap();
        Map map = new HashMap();
        int monthNum = 3;
        double a = 0, b0 = 0, b1 = 0;
        List<Double> aList = new ArrayList<>();
        List<Double> bList = new ArrayList<>();
        //u降水 。Q径流
        if (stationName.equals("南丰")) {
            map.put("U", new ArrayList() {{
                add("62424900");
            }});
            map.put("Q", new ArrayList() {{
                add("62405400");
            }});
            monthNum = 3;
            a = -0.22522;
            b0 = 0.43531;
            b1 = -0.14559;
            aList.add(-1.27769);
            aList.add(3.02009);
            aList.add(-3.35733);
            aList.add(2.61619);
            bList.add(-0.00904);
            bList.add(0.52797);
            bList.add(-0.03199);
            bList.add(0.54918);
        } else if (stationName.equals("廖家湾")) {
            map.put("U", new ArrayList() {{
                add("62423400");
                add("62424900");
                add("62426900");
            }});
            map.put("Q", new ArrayList() {{
                add("62401800");
            }});
            monthNum = 3;
            a = 0.01355;
            b0 = 1.43737;
            b1 = 0.0298;
            aList.add(-1.08635);
            aList.add(2.09097);
            aList.add(-2.09926);
            aList.add(2.094675);
            bList.add(-0.11356);
            bList.add(-0.00465);
            bList.add(0.12014);
            bList.add(0.84902);
        } else if (stationName.equals("娄家村")) {
            map.put("U", new ArrayList() {{
                add("62436700");
            }});
            map.put("Q", new ArrayList() {{
                add("62406600");
            }});
            monthNum = 3;
            a = -0.03484;
            b0 = 0.41411;
            b1 = -0.03714;
            aList.add(-2.00333);
            aList.add(4.06239);
            aList.add(-4.18292);
            aList.add(3.1233);
            bList.add(0.3013);
            bList.add(-0.07435);
            bList.add(0.05925);
            bList.add(0.28587);

        } else if (stationName.equals("沙子岭")) {
            map.put("U", new ArrayList() {{
                add("62423400");
            }});
            map.put("Q", new ArrayList() {{
                add("62405200");
            }});
            monthNum = 3;
            a = 0.01834;
            b0 = 0.18841;
            b1 = 0.00556;
            aList.add(-1.54538);
            aList.add(3.0339);
            aList.add(-2.89593);
            aList.add(2.40735);
            bList.add(-0.02265);
            bList.add(0.00701);
            bList.add(0.16914);
            bList.add(0.65852);
        } else if (stationName.equals("茅洲")) {
            map.put("U", new ArrayList() {{
                add("62337420");
            }});
            map.put("Q", new ArrayList() {{
                add("62310700");
            }});
            monthNum = 5;
            a = 0.01294;
            b0 = 0.04539;
            b1 = 0.00123;
            aList.add(-1.57281);
            aList.add(3.17866);
            aList.add(-3.25313);
            aList.add(3.3646);
            aList.add(-3.48013);
            aList.add(2.76309);
            bList.add(0.0228);
            bList.add(-0.05334);
            bList.add(-0.04344);
            bList.add(0.10352);
            bList.add(0.19664);
            bList.add(0.33225);

        }
        List<String> mlist = getMonthList(stationName, date, monthNum + 1);
        List<String> mlistAll = getMonthList(stationName, date, 0);

        List<String> plist = new ArrayList<String>();
        map.put("startDate", mlistAll.get(0));
        map.put("endDate", mlistAll.get(mlistAll.size() - 1));
        List<Map> monthListAll = new ArrayList<>();
        if ("廖家湾".equals(stationName)) {//廖家湾 90年以前3个数累加，90年后两个数累加
            List<Map> allList = ddsDDaypDao.getForcastToMonth(map);
            boolean flag = false;
            for (int i = 0; i < allList.size(); i++) {
                Map allMap = allList.get(i);
                Map hashMap = new HashMap();
                hashMap.put("Q", allMap.get("Q"));
                hashMap.put("MONTH", allMap.get("MON"));
                if ((allMap.get("MON").toString()).equals("1990-01"))
                    flag = true;
                double Uljw = allMap.get("U") == null ? 0d : Double.parseDouble(allMap.get("U").toString());
                if (!flag) {
                    hashMap.put("U", Uljw / 3);
                } else {
                    hashMap.put("U", Uljw / 2);
                }
                monthListAll.add(hashMap);
            }
        } else {
            List<Map> forcastToMonth = ddsDDaypDao.getForcastToMonth(map);
            for(Map mapn : forcastToMonth){
                Map newMap = new HashMap();
                newMap.put("Q",mapn.get("Q"));
                newMap.put("U",mapn.get("U"));
                newMap.put("MONTH",mapn.get("MON"));
                monthListAll.add(newMap);
            }
        }
        List<Map> monthListAll1 = addDefaultValue(monthListAll, stationName,"U",0);
        List<Map> results = new ArrayList<>();
        double returnData = 0.0;
        double U = 0.0;
        double Q = 0.0;
        double tempU = 0.0d;
        double tempQ = 0.0d;
        double F = 0.0d;
        double Y = 0.0d;
        for (int i = 0; i < monthListAll1.size(); i++) {
            Map newMap = new HashMap();
            newMap.put("U", monthListAll1.get(i).get("U") == null ? 0 : monthListAll1.get(i).get("U"));
            newMap.put("Q", monthListAll1.get(i).get("Q") == null ? 0 : monthListAll1.get(i).get("Q"));
            tempU += Double.parseDouble(monthListAll1.get(i).get("U").toString());
            newMap.put("U1", tempU);
            tempQ += Double.parseDouble(monthListAll1.get(i).get("Q").toString());
            newMap.put("Q1", tempQ);
            if (i >= monthListAll1.size() - monthNum - 1) {
                results.add(newMap);
            }
        }
        for (int i = 0; i < results.size(); i++) {
            F = (-1) * a * Double.parseDouble(results.get(i).get("Q1").toString()) + b0 * Double.parseDouble(results.get(i).get("U").toString()) + b1 * Double.parseDouble(results.get(i).get("U1").toString());
            if (i == 0) {
                Y = Double.parseDouble(results.get(i).get("Q1").toString());
            } else {
                Y = 0.5 * (Double.parseDouble(results.get(i).get("Q1").toString()) + Double.parseDouble(results.get(i - 1).get("Q1").toString()));
            }
            Q += (aList.get(i) * Y + bList.get(i) * F);
        }
        returnData = division(Math.abs(Q - Double.parseDouble(results.get(results.size() - 1).get("Q1").toString())));
        plist.add(String.valueOf(returnData));
        returnMap.put("mlist", mlist);
        returnMap.put("plist", plist);
        return returnMap;

    }

//            Result result = new Result();
//            Map month = monthList.get(i);
//            result.setU(division2(new BigDecimal(month.get("U").toString())));
//            result.setQ(division2(new BigDecimal(month.get("Q").toString())));
//            //步骤一：降水、径流一次累加
//            result.setU1(getU += division2(new BigDecimal(month.get("U").toString())));
//            result.setQ1(getQ += division2(new BigDecimal(month.get("Q").toString())));
//            //步骤2：参数F计算,参数F的计算公式为：F(i)=-a*Q1(i)+b0*U(i)+b1*U1(i),
//            result.setF(-a * getQ + b0 * division2(new BigDecimal(month.get("U").toString())) + b1 * getU);
//            //步骤3：参数Y计算，Y的计算法则如下： 当i=1时， Y(1)=Q1(1) 当i>1时， Y(i)= 0.5*(Q1(i)+Q1(i-1))lt);
//            if (i == 0) {
//                result.setY(getQ);
//            } else {
//                result.setY(0.5 * (getQ + resultMap.get(monthList.get(i - 1).get("MON").toString()).getQ1()));
//            }
//            resultMap.put(month.get("MON").toString(), result);
//            returnData += aList.get(i) * result.getY();
//            returnData += bList.get(i) * result.getF();
//        }
//        returnData = Math.abs(returnData - resultMap.get(monthList.get(monthList.size() - 1).get("MON").toString()).getQ1());

//                Liaojiawan liaojiawan = new Liaojiawan();
//                int startYear = year - (int) liaojiawan.getP() - 1;
//                double tempU = 0.0;
//                double tempQ = 0.0;
//                double Y = 0.0d;
//                double F = 0.0d;
//                double Q = 0.0d;
//                List<Map> results = new ArrayList<>();
//                for (int i = 1980; i < year; i++) {
//                    Map map = new HashMap();
//                    String key = String.valueOf(i);
//                    map.put("U", (division2(ddsDDaypDao.getForcast_ljw(i + START_TIME, i + END_TIME).get("U"))));
//                    map.put("Q", (division2(ddsDDaypDao.getForcast_ljw(i + START_TIME, i + END_TIME).get("Q"))));
//                    tempU += division2(ddsDDaypDao.getForcast_ljw(i + START_TIME, i + END_TIME).get("U"));
//                    map.put("U1", tempU);
//                    tempQ += division2(ddsDDaypDao.getForcast_ljw(i + START_TIME, i + END_TIME).get("Q"));
//                    map.put("Q1", tempQ);
//                    if (i >= startYear) {
//                        results.add(map);
//                    }
//                }
//                for (int i = 0; i < results.size(); i++) {
//                    F = (-1) * liaojiawan.getPa() * Double.parseDouble(results.get(i).get("Q1").toString()) + liaojiawan.getPb0() * Double.parseDouble(results.get(i).get("U").toString()) + liaojiawan.getPb1() * Double.parseDouble(results.get(i).get("U1").toString());
//                    if (i == 0) {
//                        Y = Double.parseDouble(results.get(i).get("Q1").toString());
//                    } else {
//                        Y = 0.5 * (Double.parseDouble(results.get(i).get("Q1").toString()) + Double.parseDouble(results.get(i - 1).get("Q1").toString()));
//                    }
//                    Q += (liaojiawan.getA().get(i) * Y + liaojiawan.getB().get(i) * F);
//                }
//                returnData = division(Math.abs(Q - Double.parseDouble(results.get(results.size() - 1).get("Q1").toString())));
//                return returnData;





    /*
     * @param stationName
     * @param date
     * @return 旬的统计模型
     * @throws Exception
     */
//    public double getForcastToXun(String stationName, Date date) throws Exception {
//        Map map = new HashMap();
//        int xunNum = 0;
//        double a = 0, b0 = 0, b1 = 0;
//        List<Double> aList = new ArrayList<>();
//        List<Double> bList = new ArrayList<>();
//        //u降水 。Q径流
//        if (stationName.equals("南丰")) {
//            map.put("U", new ArrayList() {{
//                add("62424900");
//            }});
//            map.put("Q", new ArrayList() {{
//                add("62405400");
//            }});
//            xunNum = 3;
//            a = -0.04096;
//            b0 =12.7141;
//            b1 =-0.74735;
//            aList.add(-1.06246);
//            aList.add(2.07835);
//            aList.add(-2.24196);
//            aList.add(2.22309);
//            bList.add(0.33452);
//            bList.add(0.11708);
//            bList.add(-0.00362);
//            bList.add(0.64402);
//
//        } else if (stationName.equals("廖家湾")) {
//            map.put("U", new ArrayList() {{
//                add("62423400");
//                add("62424900");
//                add("62426900");
//                add("62425600");
//            }});
//            map.put("Q", new ArrayList() {{
//                add("62401800");
//            }});
//            xunNum = 3;
//            a = 0.00811;
//            b0 =3.55682;
//            b1 =0.05254;
//            aList.add(-1.40453);
//            aList.add(2.50023);
//            aList.add(-2.38716);
//            aList.add(2.29125);
//            bList.add(0.0632);
//            bList.add(-0.05997);
//            bList.add(0.07757);
//            bList.add(0.66691);
//
//        } else if (stationName.equals("娄家村")) {
//            map.put("U", new ArrayList() {{
//                add("62436700");
//            }});
//            map.put("Q", new ArrayList() {{
//                add("62406600");
//            }});
//            xunNum = 3;
//            a = -0.00867;
//            b0 =0.58321;
//            b1 =-0.026;
//            aList.add(-2.37397);
//            aList.add(4.42551);
//            aList.add(-4.12838);
//            aList.add(3.07668);
//            bList.add(0.05025);
//            bList.add(0.21597);
//            bList.add(0.1442);
//            bList.add(-0.0026);
//
//        } else if (stationName.equals("沙子岭")) {
//            map.put("U", new ArrayList() {{
//                add("62423400");
//            }});
//            map.put("Q", new ArrayList() {{
//                add("62405200");
//            }});
//            xunNum = 3;
//            a = 0.01425;
//            b0 = 0.4201;
//            b1 = 0.01261;
//            aList.add(-0.82664);
//            aList.add(1.33351);
//            aList.add(-1.55854);
//            aList.add(2.05148);
//            bList.add(0.08149);
//            bList.add(-0.11563);
//            bList.add(-0.00971);
//            bList.add(0.72109);
//        }else if(stationName .equals("茅洲")){
//            map.put("U", new ArrayList() {{
//                add("62337420");
//            }});
//            map.put("Q", new ArrayList() {{
//                add("62310700");
//            }});
//            xunNum = 48;
//            a = 0.01193;
//            b0 =0.11569;
//            b1 =0.00308;
//
//            aList.add(1.29919);
//            aList.add(-2.60674);
//            aList.add(2.40205);
//            aList.add(-2.27116);
//            aList.add(2.31036);
//            aList.add(-2.08417);
//            aList.add(1.86789);
//            aList.add(-1.87006);
//            aList.add(1.76221);
//            aList.add(-1.56459);
//            aList.add(1.45673);
//            aList.add(-1.26803);
//            aList.add(0.89202);
//            aList.add(-0.83612);
//            aList.add(1.10526);
//            aList.add(-1.19169);
//            aList.add(1.39181);
//            aList.add(-1.64799);
//            aList.add(1.7165);
//            aList.add(-1.58822);
//            aList.add(1.34491);
//            aList.add(-1.20241);
//            aList.add(1.17061);
//            aList.add(-1.22885);
//            aList.add(1.18658);
//            aList.add(-1.16181);
//            aList.add(1.24647);
//            aList.add(-1.18528);
//            aList.add(1.3628);
//            aList.add(-1.68312);
//            aList.add(1.70884);
//            aList.add(-1.78446);
//            aList.add(1.97001);
//            aList.add(-2.16247);
//            aList.add(2.23799);
//            aList.add(-2.04542);
//            aList.add(1.99007);
//            aList.add(-2.04185);
//            aList.add(1.9321);
//            aList.add(-1.98165);
//            aList.add(2.19422);
//            aList.add(-2.26882);
//            aList.add(2.1892);
//            aList.add(-2.17114);
//            aList.add(2.03609);
//            aList.add(-2.04922);
//            aList.add(1.71419);
//            aList.add(-1.32502);
//            aList.add(1.73199);
//
//            bList.add(-0.06858);
//            bList.add(-0.13727);
//            bList.add(-0.18974);
//            bList.add(-0.11141);
//            bList.add(0.03256);
//            bList.add(0.06966);
//            bList.add(0.05156);
//            bList.add(-0.07777);
//            bList.add(-0.04675);
//            bList.add(-0.06567);
//            bList.add(-0.02825);
//            bList.add(0.01541);
//            bList.add(-0.02149);
//            bList.add(-0.07436);
//            bList.add(0.17138);
//            bList.add(0.0949);
//            bList.add(0.06417);
//            bList.add(0.03958);
//            bList.add(0.05592);
//            bList.add(0.18416);
//            bList.add(-0.05576);
//            bList.add(0.05011);
//            bList.add(-0.01858);
//            bList.add(-0.12607);
//            bList.add(-0.12048);
//            bList.add(-0.01811);
//            bList.add(0.02605);
//            bList.add(0.09352);
//            bList.add(0.17859);
//            bList.add(-0.07339);
//            bList.add(-0.04605);
//            bList.add(-0.04593);
//            bList.add(0.05364);
//            bList.add(-0.1048);
//            bList.add(-0.00326);
//            bList.add(0.1098);
//            bList.add(0.10541);
//            bList.add(-0.06443);
//            bList.add(-0.04047);
//            bList.add(-0.0631);
//            bList.add(0.06196);
//            bList.add(0.02755);
//            bList.add(-0.08135);
//            bList.add(-0.01926);
//            bList.add(-0.05571);
//            bList.add(-0.0955);
//            bList.add(-0.09879);
//            bList.add(0.08732);
//            bList.add(0.85949);
//        }
//
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
//        String startTime = null;
//        String endTime = null;
//        String str = "";
//        if (dayOfMonth <= 10) {
//            if (month == 1) {
//                endTime = year - 1 + "-12-31";
//            } else {
//                endTime = year + "-" + (month - 1) + "-" + days(year, month - 1);
//            }
//
//        } else if (dayOfMonth <= 20) {
//            endTime = year + "-" + month + "-10";
//        } else {
//            endTime = year + "-" + month + "-20";
//        }
//        map.put("startDate", "1980-01-01");
//        map.put("endDate", endTime);
//        List<Map> dayList = ddsDDaypDao.getForcastToDayMap(map);
//        List<String> getXunList = getFormatXunList("1979-12-31",endTime);
//        double returnData = 0.0;
//        double Y = 0.0d;
//        double F = 0.0d;
//        double Q = 0.0d;
//        double tempQ = 0.0d;
//        double tempU = 0.0d;
//        List<Map> results = new ArrayList<>();
//        for (int i = 0; i < getXunList.size(); i++) {
//            double xunQ = 0.0;
//            double xunU = 0.0;
//            String xun = getXunList.get(i);//XUN =xx年1月上
//            for (int j = 0; j < dayList.size(); j++) {
//                String dayToxun = dayList.get(j) == null || dayList.get(j).get("mon") == null ? "0" : dayList.get(j).get("mon").toString();//dayToxun 1999-01-01 //11
//                String[] strs = dayToxun.split("-");
//                if(!dayToxun.equals("0")&& (xun!=null)) {
//                    if (Integer.parseInt(xun.split("年")[1].split("月")[0]) == Integer.parseInt(strs[1]) && (Integer.parseInt(xun.split("年")[0]) == Integer.parseInt(strs[0]))) {
//                        if ((xun.indexOf("上") != -1) && Integer.parseInt(strs[2]) <= 10) { //上旬
//                            xunU += (division2(new BigDecimal(dayList.get(j) == null || dayList.get(j).get("U") == null ? "0" : dayList.get(j).get("U").toString())));
//                            xunQ += (division2(new BigDecimal(dayList.get(j) == null || dayList.get(j).get("Q") == null ? "0" : dayList.get(j).get("Q").toString())));
//                        } else if ((xun.indexOf("中") != -1) && Integer.parseInt(strs[2]) > 10 && Integer.parseInt(strs[2]) <= 20 && (Integer.parseInt(xun.split("年")[0]) == Integer.parseInt(strs[0]))) {//中旬
//                            xunU += (division2(new BigDecimal(dayList.get(j) == null || dayList.get(j).get("U") == null ? "0" : dayList.get(j).get("U").toString())));
//                            xunQ += (division2(new BigDecimal(dayList.get(j) == null || dayList.get(j).get("Q") == null ? "0" : dayList.get(j).get("Q").toString())));
//                        } else if ((xun.indexOf("下") != -1) && Integer.parseInt(strs[2]) > 20 && Integer.parseInt(strs[2]) <= days(Integer.parseInt(strs[0]), Integer.parseInt(strs[1])) && (Integer.parseInt(xun.split("年")[0]) == Integer.parseInt(strs[0]))) {//下旬
//                            xunU += (division2(new BigDecimal(dayList.get(j) == null || dayList.get(j).get("U") == null ? "0" : dayList.get(j).get("U").toString())));
//                            xunQ += (division2(new BigDecimal(dayList.get(j) == null || dayList.get(j).get("Q") == null ? "0" : dayList.get(j).get("Q").toString())));
//                        }
//
//                    }
//                }
//
//            }
//            Map newMap = new HashMap();
//            newMap.put("XUN", xun);
//            newMap.put("U", xunU);
//            newMap.put("Q", xunQ / 10);
//            tempU += Double.parseDouble(newMap.get("U").toString());
//            newMap.put("U1", tempU);
//            tempU += Double.parseDouble(newMap.get("Q").toString());
//            newMap.put("Q1", tempQ);
//            if (i >= getXunList.size() - xunNum - 1) {
//                results.add(newMap);
//            }
//        }
//        for (int i = 0; i < results.size(); i++) {
//            F = (-1) * a * Double.parseDouble(results.get(i).get("Q1").toString()) + b0* Double.parseDouble(results.get(i).get("U").toString()) + b1 * Double.parseDouble(results.get(i).get("U1").toString());
//            if (i == 0) {
//                Y = Double.parseDouble(results.get(i).get("Q1").toString());
//            } else {
//                Y = 0.5 * (Double.parseDouble(results.get(i).get("Q1").toString()) + Double.parseDouble(results.get(i - 1).get("Q1").toString()));
//            }
//            Q += (aList.get(i) * Y + bList.get(i) * F);
//        }
//
//        returnData = division(Math.abs(Q - Double.parseDouble(results.get(results.size() - 1).get("Q1").toString())));
//        /**计算公式？？*/
//        returnData = division(returnData*365/10);
//        return returnData;

//    }


    public double getForcastToXun(String stationName, Date date) throws Exception {
        Map map = new HashMap();
        int xunNum = 0;
        double a = 0, b0 = 0, b1 = 0;
        List<Double> aList = new ArrayList<>();
        List<Double> bList = new ArrayList<>();
        //u降水 。Q径流
        if (stationName.equals("南丰")) {
            map.put("U", new ArrayList() {{
                add("62424900");
            }});
            map.put("Q", new ArrayList() {{
                add("62405400");
            }});
            xunNum = 36;
            a = -0.04096;
            b0 = 12.714;
            b1 = -0.747;
//            xunNum = 3;
//            a = -0.04063;
//            b0 =1.26382;
//            b1 =-0.07356;
//
//            aList.add(-1.04363);
//            aList.add(2.04334);
//            aList.add(-2.18444);
//            aList.add(2.1816);
//            bList.add(0.32995);
//            bList.add(0.13076);
//            bList.add(0.02482);
//            bList.add(0.65871);
            aList.add(0.297);
            aList.add(-1.18);
            aList.add(1.99);
            aList.add(-3.121);
            aList.add(4.237);
            aList.add(-4.865);
            aList.add(5.372);
            aList.add(-5.783);
            aList.add(5.76);
            aList.add(-5.344);
            aList.add(5.251);
            aList.add(-5.05);
            aList.add(4.864);
            aList.add(-4.898);
            aList.add(5.23);
            aList.add(-5.614);
            aList.add(5.519);
            aList.add(-5.307);
            aList.add(5.031);

            aList.add(-4.587);
            aList.add(4.235);
            aList.add(-4.446);
            aList.add(4.813);
            aList.add(-4.661);
            aList.add(4.176);
            aList.add(-3.323);
            aList.add(2.905);
            aList.add(-2.78);
            aList.add(3.152);
            aList.add(-3.37);
            aList.add(3.19);
            aList.add(-2.899);
            aList.add(2.523);
            aList.add(-2.321);
            aList.add(2.825);
            aList.add(-3.11);
            aList.add(2.295);

            bList.add(-0.069);
            bList.add(-0.233);
            bList.add(-0.032);
            bList.add(-0.522);
            bList.add(-0.089);
            bList.add(-0.309);
            bList.add(0.044);
            bList.add(-0.214);
            bList.add(-0.086);
            bList.add(0.167);
            bList.add(-0.001);
            bList.add(-0.02);

            bList.add(-0.204);
            bList.add(0.173);
            bList.add(0.039);
            bList.add(-0.09);
            bList.add(-0.18);
            bList.add(0.106);
            bList.add(-0.102);
            bList.add(-0.06);
            bList.add(-0.12);
            bList.add(-0.182);
            bList.add(-0.123);
            bList.add(-0.068);
            bList.add(0.013);

            bList.add(0.224);
            bList.add(0.074);
            bList.add(0.293);
            bList.add(0.392);
            bList.add(0.399);
            bList.add(0.246);
            bList.add(0.368);
            bList.add(0.142);
            bList.add(0.322);
            bList.add(0.39);
            bList.add(-0.017);
            bList.add(0.433);

        } else if (stationName.equals("廖家湾")) {
            map.put("U", new ArrayList() {{
                add("62423400");
                add("62424900");
                add("62426900");
                add("62425600");
            }});
            map.put("Q", new ArrayList() {{
                add("62401800");
            }});
//            xunNum = 3;
//            a = 0.00811;
//            b0 =3.55682;
//            b1 =0.05254;
//            aList.add(-1.40453);
//            aList.add(2.50023);
//            aList.add(-2.38716);
//            aList.add(2.29125);
//            bList.add(0.0632);
//            bList.add(-0.05997);
//            bList.add(0.07757);
//            bList.add(0.66691);


            xunNum = 36;
            a = -0.00811;
            b0 = 3.557;
            b1 = 0.053;
            aList.add(1.237);
            aList.add(-2.537);
            aList.add(2.676);
            aList.add(-2.93);
            aList.add(2.956);
            aList.add(-2.73);
            aList.add(2.685);
            aList.add(-2.725);
            aList.add(2.82);
            aList.add(-2.908);
            aList.add(2.957);
            aList.add(-2.876);
            aList.add(2.836);
            aList.add(-2.909);
            aList.add(2.948);
            aList.add(-2.97);
            aList.add(3.037);
            aList.add(-3.168);
            aList.add(3.188);

            aList.add(-3.232);
            aList.add(3.329);
            aList.add(-3.466);
            aList.add(3.522);
            aList.add(-3.493);
            aList.add(3.495);
            aList.add(-3.538);
            aList.add(3.432);
            aList.add(-3.387);
            aList.add(3.488);
            aList.add(-3.384);
            aList.add(3.145);
            aList.add(-2.964);
            aList.add(2.785);
            aList.add(-2.632);
            aList.add(2.388);
            aList.add(-2.328);
            aList.add(2.252);

            bList.add(-0.034);
            bList.add(0.001);
            bList.add(0.094);
            bList.add(-0.057);
            bList.add(-0.023);
            bList.add(0.077);
            bList.add(0.004);
            bList.add(0.056);
            bList.add(0.077);
            bList.add(0.033);
            bList.add(0.041);
            bList.add(0.048);

            bList.add(0.021);
            bList.add(0.05);
            bList.add(0.024);
            bList.add(0.064);
            bList.add(0.022);
            bList.add(0.01);
            bList.add(-0.051);
            bList.add(-0.054);
            bList.add(-0.03);
            bList.add(-0.092);
            bList.add(-0.072);
            bList.add(-0.039);
            bList.add(0.018);

            bList.add(-0.157);
            bList.add(-0.095);
            bList.add(0.008);
            bList.add(0.01);
            bList.add(-0.026);
            bList.add(-0.058);
            bList.add(-0.056);
            bList.add(0.061);
            bList.add(0.077);
            bList.add(-0.049);
            bList.add(0.064);
            bList.add(0.602);

        } else if (stationName.equals("娄家村")) {
            map.put("U", new ArrayList() {{
                add("62436700");
            }});
            map.put("Q", new ArrayList() {{
                add("62406600");
            }});

//            xunNum = 3;
//            a = -0.00867;
//            b0 =0.58321;
//            b1 =-0.026;
//            aList.add(-2.37397);
//            aList.add(4.42551);
//            aList.add(-4.12838);
//            aList.add(3.07668);
//            bList.add(0.05025);
//            bList.add(0.21597);
//            bList.add(0.1442);
//            bList.add(-0.0026);

            xunNum = 36;
            a = -0.00867;
            b0 = 0.583;
            b1 = -0.026;

            aList.add(1.52);
            aList.add(-3.215);
            aList.add(3.306);
            aList.add(-3.398);
            aList.add(3.524);
            aList.add(-3.581);
            aList.add(3.74);
            aList.add(-3.951);
            aList.add(4.085);
            aList.add(-4.11);
            aList.add(4.16);
            aList.add(-4.117);
            aList.add(4.16);
            aList.add(-4.216);
            aList.add(4.238);
            aList.add(-4.372);
            aList.add(4.498);
            aList.add(-4.646);
            aList.add(4.807);

            aList.add(-4.902);
            aList.add(4.965);
            aList.add(-5.032);
            aList.add(5.133);
            aList.add(-5.165);
            aList.add(5.05);
            aList.add(-4.85);
            aList.add(4.708);
            aList.add(-4.687);
            aList.add(4.67);
            aList.add(-4.645);
            aList.add(4.529);
            aList.add(-4.308);
            aList.add(4.075);
            aList.add(-4.06);
            aList.add(4.015);
            aList.add(-3.778);
            aList.add(2.848);

            bList.add(0.064);
            bList.add(0.098);
            bList.add(0.161);
            bList.add(0.139);
            bList.add(0.34);
            bList.add(0.076);
            bList.add(0.194);
            bList.add(-0.129);
            bList.add(-0.062);
            bList.add(-0.207);
            bList.add(0.104);
            bList.add(-0.193);

            bList.add(0.148);
            bList.add(-0.019);
            bList.add(0.016);
            bList.add(0.606);
            bList.add(-0.141);
            bList.add(0.131);
            bList.add(-0.2);
            bList.add(0.184);
            bList.add(-0.02);
            bList.add(-0.274);
            bList.add(0.153);
            bList.add(-0.018);
            bList.add(-0.152);

            bList.add(0.268);
            bList.add(0.016);
            bList.add(0.14);
            bList.add(-0.274);
            bList.add(-0.024);
            bList.add(0.173);
            bList.add(-0.142);
            bList.add(0.009);
            bList.add(-0.15);
            bList.add(-0.05);
            bList.add(-0.035);
            bList.add(-0.4);

        } else if (stationName.equals("沙子岭")) {
            map.put("U", new ArrayList() {{
                add("62423400");
            }});
            map.put("Q", new ArrayList() {{
                add("62405200");
            }});
//            xunNum = 3;
//            a = 0.01425;
//            b0 =0.4201;
//            b1 =0.01261;
//            aList.add(-0.82664);
//            aList.add(1.33351);
//            aList.add(-1.55854);
//            aList.add(2.05148);
//            bList.add(0.08149);
//            bList.add(-0.11563);
//            bList.add(-0.00971);
//            bList.add(0.72109);


            xunNum = 30;
            a = -0.03484;
            b0 = 0.414;
            b1 = -0.037;
            aList.add(0.099);
            aList.add(-0.258);
            aList.add(0.313);
            aList.add(-0.302);
            aList.add(0.253);
            aList.add(-0.214);
            aList.add(0.298);
            aList.add(-0.406);
            aList.add(0.297);
            aList.add(-0.216);
            aList.add(0.254);
            aList.add(-0.317);
            aList.add(0.351);
            aList.add(-0.569);
            aList.add(0.841);
            aList.add(-0.935);
            aList.add(1.06);
            aList.add(-0.869);
            aList.add(0.723);

            aList.add(-0.739);
            aList.add(0.791);
            aList.add(-1.005);
            aList.add(1.012);
            aList.add(-0.872);
            aList.add(0.869);
            aList.add(-0.972);
            aList.add(1.039);
            aList.add(-1.02);
            aList.add(1.076);
            aList.add(-1.201);
            aList.add(1.234);
            aList.add(-1.198);
            aList.add(1.2);
            aList.add(-1.347);
            aList.add(1.496);
            aList.add(-1.42);
            aList.add(1.314);

            aList.add(-1.393);
            aList.add(1.312);
            aList.add(-1.319);
            aList.add(1.446);
            aList.add(-1.218);
            aList.add(1.14);
            aList.add(-1.336);
            aList.add(1.295);
            aList.add(-1.349);
            aList.add(1.228);
            aList.add(-1.445);
            aList.add(1.977);

            bList.add(-0.069);
            bList.add(-0.093);
            bList.add(-0.092);
            bList.add(-0.063);
            bList.add(-0.022);
            bList.add(0.001);
            bList.add(0.091);
            bList.add(-0.111);
            bList.add(-0.092);
            bList.add(-0.021);
            bList.add(-0.078);
            bList.add(-0.097);
            bList.add(-0.028);
            bList.add(-0.026);
            bList.add(0.122);
            bList.add(0.034);
            bList.add(0.188);
            bList.add(0.173);
            bList.add(0.033);
            bList.add(0.026);
            bList.add(0.108);
            bList.add(-0.095);
            bList.add(-0.017);
            bList.add(0.023);
            bList.add(-0.001);
            bList.add(-0.053);
            bList.add(0d);
            bList.add(0.039);
            bList.add(0.05);
            bList.add(0.024);
            bList.add(0.041);
            bList.add(0.015);
            bList.add(0.014);
            bList.add(-0.091);
            bList.add(0.013);
            bList.add(0.05);
            bList.add(0.067);
            bList.add(-0.112);
            bList.add(-0.102);
            bList.add(-0.034);
            bList.add(0.034);
            bList.add(0.116);
            bList.add(0.046);
            bList.add(-0.127);
            bList.add(0.054);
            bList.add(-0.007);
            bList.add(-0.101);
            bList.add(-0.029);
            bList.add(0.627);
        } else if (stationName.equals("茅洲")) {
            map.put("U", new ArrayList() {{
                add("62337420");
            }});
            map.put("Q", new ArrayList() {{
                add("62310700");
            }});
            xunNum = 36;
            a = 0.00734;
            b0 = 0.10916;
            b1 = 0.00201;
//
//            aList.add(-1.41684);
//            aList.add(2.65326);
//            aList.add(-2.62605);
//            aList.add(2.3508);
//            aList.add(-2.08493);
//            aList.add(2.12364);
//            bList.add(-0.0262);
//            bList.add(-0.04342);
//            bList.add(-0.06247);
//            bList.add(-0.0485);
//            bList.add(0.05503);
//            bList.add(0.67629);
            aList.add(1.29919);
            aList.add(-2.60674);
            aList.add(2.40205);
            aList.add(-2.27116);
            aList.add(2.31036);
            aList.add(-2.08417);
            aList.add(1.86789);
            aList.add(-1.87006);
            aList.add(1.76221);
            aList.add(-1.56459);
            aList.add(1.45673);
            aList.add(-1.26803);
            aList.add(0.89202);
            aList.add(-0.83612);
            aList.add(1.10526);
            aList.add(-1.19169);
            aList.add(1.39181);
            aList.add(-1.64799);
            aList.add(1.7165);
            aList.add(-1.58822);
            aList.add(1.34491);
            aList.add(-1.20241);
            aList.add(1.17061);
            aList.add(-1.22885);
            aList.add(1.18658);
            aList.add(-1.16181);
            aList.add(1.24647);
            aList.add(-1.18528);
            aList.add(1.3628);
            aList.add(-1.68312);
            aList.add(1.70884);
            aList.add(-1.78446);
            aList.add(1.97001);
            aList.add(-2.16247);
            aList.add(2.23799);
            aList.add(-2.04542);
            aList.add(1.99007);
            aList.add(-2.04185);
            aList.add(1.9321);
            aList.add(-1.98165);
            aList.add(2.19422);
            aList.add(-2.26882);
            aList.add(2.1892);
            aList.add(-2.17114);
            aList.add(2.03609);
            aList.add(-2.04922);
            aList.add(1.71419);
            aList.add(-1.32502);
            aList.add(1.73199);

            bList.add(-0.06858);
            bList.add(-0.13727);
            bList.add(-0.18974);
            bList.add(-0.11141);
            bList.add(0.03256);
            bList.add(0.06966);
            bList.add(0.05156);
            bList.add(-0.07777);
            bList.add(-0.04675);
            bList.add(-0.06567);
            bList.add(-0.02825);
            bList.add(0.01541);
            bList.add(-0.02149);
            bList.add(-0.07436);
            bList.add(0.17138);
            bList.add(0.0949);
            bList.add(0.06417);
            bList.add(0.03958);
            bList.add(0.05592);
            bList.add(0.18416);
            bList.add(-0.05576);
            bList.add(0.05011);
            bList.add(-0.01858);
            bList.add(-0.12607);
            bList.add(-0.12048);
            bList.add(-0.01811);
            bList.add(0.02605);
            bList.add(0.09352);
            bList.add(0.17859);
            bList.add(-0.07339);
            bList.add(-0.04605);
            bList.add(-0.04593);
            bList.add(0.05364);
            bList.add(-0.1048);
            bList.add(-0.00326);
            bList.add(0.1098);
            bList.add(0.10541);
            bList.add(-0.06443);
            bList.add(-0.04047);
            bList.add(-0.0631);
            bList.add(0.06196);
            bList.add(0.02755);
            bList.add(-0.08135);
            bList.add(-0.01926);
            bList.add(-0.05571);
            bList.add(-0.0955);
            bList.add(-0.09879);
            bList.add(0.08732);
            bList.add(0.85949);
        }


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        String startTime = null;
        String endTime = null;
        String str = "";
        if (dayOfMonth <= 10) {
            if (month == 1) {
                startTime = year - 2 + "-12-31";
                endTime = year - 1 + "-12-31";
                str = year - 2 + "年12月中";
            } else {
                startTime = year - 1 + "-" + (month - 1) + "-" + days(year - 1, month - 1);
                endTime = year + "-" + (month - 1) + "-" + days(year, month - 1);
                str = year - 1 + "年" + (month - 1) + "月中";
            }

        } else if (dayOfMonth <= 20) {
            startTime = year - 1 + "-" + month + "-10";
            endTime = year + "-" + month + "-10";
            str = year - 1 + "年" + month + "月上";
        } else {
            startTime = year - 1 + "-" + month + "-20";
            endTime = year + "-" + month + "-20";
            str = year - 1 + "年" + month + "月中";
        }


        List<String> getXunList1 = getFormatXunList(startTime);
        List<String> getXunList = new ArrayList<String>();
        getXunList.add(str);
        for (int i = 0; i < getXunList1.size(); i++) {
            getXunList.add(getXunList1.get(i));
        }
        //startTime = formatStr(startTime);
        String[] split = startTime.split("-");
        if (Integer.parseInt(split[2]) == 10) {
            startTime = formatStr(split[0] + "-" + split[1] + "-" + 01);
        } else if (Integer.parseInt(split[2]) == 20) {
            startTime = formatStr(split[0] + "-" + split[1] + "-" + 10);
        } else {
            startTime = formatStr(split[0] + "-" + (Integer.parseInt(split[1]) - 1) + "-" + 01);
        }

        endTime = formatStr(endTime);
        List<Map> dayList = new ArrayList<>();
        if (stationName.equals("娄家村")) {
            dayList = ddsDDaypDao.getForcastToDayljc(startTime, endTime);
        } else {
            dayList = ddsDDaypDao.getForcastToDay(startTime, endTime, stationName);//返回每一天的 u，q,
        }
        List<Map> xunList = new ArrayList<>(); //Map{"1988年1月上","Q","U"}
        Map<String, Result> resultMap = new HashMap<>();
        double returnData = 0.0;
        double getU = 0.0;
        double getQ = 0.0;
        for (int i = 0; i < getXunList.size(); i++) {
            double xunQ = 0.0;
            double xunU = 0.0;
            Map xunMap = new HashMap();
            String xun = getXunList.get(i);//XUN =1月上
            for (int j = 0; j < dayList.size(); j++) {
                String dayToxun = dayList.get(j).get("DDAY").toString();//dayToxun 1999-01-01 //11
                String[] strs = dayToxun.split("-");
                double U0 = dayList.get(j).get("U") == null ? 0 : division2(new BigDecimal(dayList.get(j).get("U").toString()));
                double Q0 = dayList.get(j).get("Q") == null ? 0 : division2(new BigDecimal(dayList.get(j).get("Q").toString()));
                if (Integer.parseInt(xun.split("年")[1].split("月")[0]) == Integer.parseInt(strs[1]) && (Integer.parseInt(xun.split("年")[0]) == Integer.parseInt(strs[0]))) {
                    if ((xun.indexOf("上") != -1) && Integer.parseInt(strs[2]) <= 10) { //上旬
                        xunU += U0;  //
                        xunQ += Q0;
                    } else if ((xun.indexOf("中") != -1) && Integer.parseInt(strs[2]) > 10 && Integer.parseInt(strs[2]) <= 20 && (Integer.parseInt(xun.split("年")[0]) == Integer.parseInt(strs[0]))) {//中旬
                        xunU += U0;  //
                        xunQ += Q0;
                    } else if ((xun.indexOf("下") != -1) && Integer.parseInt(strs[2]) > 20 && Integer.parseInt(strs[2]) <= days(Integer.parseInt(strs[0]), Integer.parseInt(strs[1])) && (Integer.parseInt(xun.split("年")[0]) == Integer.parseInt(strs[0]))) {//下旬
                        xunU += U0;  //
                        xunQ += Q0;
                    }

                }
            }
            if(xunU == 0.0d){
                xunU = addDeafultOneXunU(xun,stationName);
            }
            if(xunQ == 0.0d){
                xunQ = addDeafultOneXunQ(xun,stationName);
            }else{
                xunQ = xunQ/10;
            }
            xunMap.put("XUN", xun);
            xunMap.put("U", xunU);
            xunMap.put("Q", xunQ);
            xunList.add(xunMap);
            Result result = new Result();
            Map xunMaps = xunList.get(i);
            result.setU(division2(new BigDecimal(xunMaps.get("U").toString())));
            result.setQ(division2(new BigDecimal(xunMaps.get("Q").toString())));
            //步骤一：降水、径流一次累加
            result.setU1(getU += division2(new BigDecimal(xunMaps.get("U").toString())));
            result.setQ1(getQ += division2(new BigDecimal(xunMaps.get("Q").toString())));
            //步骤2：参数F计算,参数F的计算公式为：F(i)=-a*Q1(i)+b0*U(i)+b1*U1(i),
            result.setF(-a * getQ + b0 * division2(new BigDecimal(xunMaps.get("U").toString())) + b1 * getU);
            //步骤3：参数Y计算，Y的计算法则如下： 当i=1时， Y(1)=Q1(1) 当i>1时， Y(i)= 0.5*(Q1(i)+Q1(i-1))lt);
            if (i == 0) {
                result.setY(getQ);
            } else {
                result.setY(0.5 * (getQ + resultMap.get(xunList.get(i - 1).get("XUN").toString()).getQ1()));
            }
            resultMap.put(xunMaps.get("XUN").toString(), result);
            returnData += aList.get(i) * result.getY();
            returnData += bList.get(i) * result.getF();
        }
        returnData = Math.abs(returnData - resultMap.get(xunList.get(xunList.size() - 1).get("XUN").toString()).getQ1());
        /**计算公式？？*/
        returnData = division(returnData);
        if (stationName.equals("茅洲")) {
            return 9.1616 * returnData;
        }
        return returnData;

    }


    /**
     * @param stationName
     * @param year
     * @return 单位 :m3/s
     * @throws Exception
     */
    public List<Map> getForcastData(String stationName, int year, HttpServletRequest request) throws Exception {

        List<Map> dataMap = new ArrayList<>();
        if (stationName.equals("廖家湾") || stationName.equals("娄家村") || stationName.equals("沙子岭") || stationName.equals("茅洲")) {
            double q = 0.0d;

            q = getForecast(stationName, year);

            dataMap = getForecast(stationName, year, q);
        } else if (stationName.equals("李家渡")) {
            double q = 0.0d;
            double q1 = getForecast("廖家湾", year);
            double q2 = getForecast("娄家村", year);


            q = division(0.132434114 * q2 + 1.452983344 * q1 - 50.87939052);


            List<Map> tempList = getForecast(stationName, year, q);
            for (int i = 0; i < tempList.size(); i++) {
                Map<String, String> tempMap = new HashMap();
                double p1 = division(Double.parseDouble(tempList.get(i).get("p1").toString()) + getLJDMonth().get(i));
                double p2 = division(Double.parseDouble(tempList.get(i).get("p2").toString()) + getLJDMonth().get(i));
                double p4 = division(Double.parseDouble(tempList.get(i).get("p4").toString()) + getLJDMonth().get(i));
                double p3 = division(p1 - p2);
                tempMap.put("month", tempList.get(i).get("month").toString());
                tempMap.put("p1", p1 + "");
                tempMap.put("p2", p2 + "");
                tempMap.put("p3", p3 + "");
                tempMap.put("p4", p4 + "");
                double p5 = 0d;
                if (p4 != 0) {
                    p5 = division((p1 - p4) / p4 * 100);
                }
                tempMap.put("p5", p5 + "");
                tempMap.put("p6", getP6(p5));
                dataMap.add(tempMap);
            }


        } else if (stationName.equals("洪门")) {
            double q = 0.0;
            double q_nf_year = 0.0d;
            /*
            *运用线性回归计算南丰前5年降水量曲线
            */
            double[] qx = new double[5];
            for (int i = 0; i < 5; i++) {
                qx[i] = getForecast_nf_year(year + i - 5);
            }
            RegressionLine line = new RegressionLine();
            for (int i = 0; i < qx.length; i++) {
                line.addDataPoint(new DataPoint(i + 1, qx[i]));
            }
            q_nf_year = line.getValue(6);
            //如果遇到预测降水量（P6）小于0的情况，则认为P6为前两年降水量的平均值，即P6=(P5+P4)*0.5。
            if (q_nf_year < 0) {
                q_nf_year = (getForecast_nf_year(year - 2) + getForecast_nf_year(year - 1)) / 2;
            }


            q = 3.4049 * (0.0179 * q_nf_year - 6.581);


//            List<Map> tempList = getForecast("南丰", year, q);
            List<Map> tempList = getForecast("洪门", year, q);
            for (int i = 0; i < tempList.size(); i++) {
                Map<String, String> tempMap = new HashMap();
                double p1 = division(Double.parseDouble(tempList.get(i).get("p1").toString()));
                double p2 = division(getHMP2YearList(year - 1).get(i));
                double p4 = division(getHMP4YearList().get(i));
                tempMap.put("month", tempList.get(i).get("month").toString());
                tempMap.put("p1", String.valueOf(division(Double.parseDouble(tempList.get(i).get("p1").toString()))));
                tempMap.put("p2", p2 + "");
                tempMap.put("p3", String.valueOf(division(Double.parseDouble(tempList.get(i).get("p3").toString()))));
                tempMap.put("p4", p4 + "");
                double p5 = 0d;
                if (p4 != 0) {
                    p5 = division((p1 - p4) / p4 * 100);
                }
                tempMap.put("p5", p5 + "");
                tempMap.put("p6", getP6(p5));
                dataMap.add(tempMap);
            }

        } else if (stationName.equals("廖坊")) {
            double q_nf = getForecast("沙子岭", year) * 2.283;
//            List<Map> tempList = getForecast("沙子岭", year, q_nf);
            List<Map> tempList = getForecast("南丰", year, q_nf);
            List<Map> tempList2 = getForcastData("洪门", year, request);
            for (int i = 0; i < tempList.size(); i++) {
                Map<String, String> tempMap = new HashMap();
                double p1 = division(1.4935 * (Double.parseDouble(tempList.get(i).get("p1").toString()) + Double.parseDouble(tempList2.get(i).get("p1").toString())));
//                double p2 = division(1.495 * (getHMP2YearList(year - 1).get(i) + Double.parseDouble(tempList.get(i).get("p1").toString())));
                double p4 = getLFP4YearList().get(i);
                tempMap.put("month", tempList.get(i).get("month").toString());
                tempMap.put("p1", p1 + "");
                tempMap.put("p2", String.valueOf(division(1.4935 * (Double.parseDouble(tempList.get(i).get("p2").toString()) + Double.parseDouble(tempList2.get(i).get("p2").toString())))));
                tempMap.put("p3", String.valueOf(division(Double.parseDouble(tempList.get(i).get("p3").toString()) + Double.parseDouble(tempList2.get(i).get("p3").toString()))));
                tempMap.put("p4", p4 + "");
                double p5 = 0d;
                if (p4 != 0) {
                    p5 = division((p1 - p4) / p4 * 100);
                }
                tempMap.put("p5", p5 + "");
                tempMap.put("p6", getP6(p5));
                dataMap.add(tempMap);
            }

        } else if (stationName.equals("南丰")) {
            double q_nf = 0.0d;


            q_nf = getForecast("沙子岭", year) * 2.283;


//            List<Map> tempList = getForecast("沙子岭", year, q_nf);
            List<Map> tempList = getForecast("南丰", year, q_nf);

            for (int i = 0; i < tempList.size(); i++) {
                Map<String, String> tempMap = new HashMap();
                tempMap.put("month", tempList.get(i).get("month").toString());
                tempMap.put("p1", String.valueOf(division(Double.parseDouble(tempList.get(i).get("p1").toString()))));
                tempMap.put("p2", String.valueOf(division(Double.parseDouble(tempList.get(i).get("p2").toString()))));
                tempMap.put("p3", String.valueOf(division(Double.parseDouble(tempList.get(i).get("p3").toString()))));
                tempMap.put("p4", String.valueOf(division(Double.parseDouble(tempList.get(i).get("p4").toString()))));
//                double p1 = division(Double.parseDouble(tempList.get(i).get("p1").toString()));
//                double p4 = division(Double.parseDouble(tempList.get(i).get("p4").toString()));
                tempMap.put("p5", tempList.get(i).get("p5").toString());
                tempMap.put("p6", tempList.get(i).get("p6").toString());
                dataMap.add(tempMap);

            }
        } else if (stationName.equals("沙子岭")) {
            double q = 0.0d;

            q = getForecast("沙子岭", year);
//            List<Map> tempList = getForecast("沙子岭1", year, q);
            List<Map> tempList = getForecast("沙子岭", year, q);
            for (int i = 0; i < tempList.size(); i++) {
                Map<String, String> tempMap = new HashMap();
                tempMap.put("month", tempList.get(i).get("month").toString());
                tempMap.put("p1", String.valueOf(division(Double.parseDouble(tempList.get(i).get("p1").toString()))));
                tempMap.put("p2", String.valueOf(division(Double.parseDouble(tempList.get(i).get("p2").toString()))));
                tempMap.put("p3", String.valueOf(division(Double.parseDouble(tempList.get(i).get("p3").toString()))));
                tempMap.put("p4", String.valueOf(division(Double.parseDouble(tempList.get(i).get("p4").toString()))));
                tempMap.put("p5", tempList.get(i).get("p5").toString());
                tempMap.put("p6", tempList.get(i).get("p6").toString());
                dataMap.add(tempMap);
            }
        }
        return dataMap;
    }

    public List<Map> getAvgToYear(String stationName) {
        List<Map> temp = ddsDDaypDao.getAvgToYear(stationName);
        for (Map tempMap : temp) {
            tempMap.put("stationName", stationName);
            tempMap.put("AVQ", division2(new BigDecimal(tempMap.get("AVQ").toString())));
        }
        return temp;
    }

    public Map<String, Double> getAvgToMonth(String stationName, String year) {
        List<Map> temp = new ArrayList<>();
        if (stationName.equals("茅洲")) {
            List<Map> mapList = ddsDDaypDao.getAvgToMonth(stationName);
            for (Map map : mapList) {
                double avq = Double.parseDouble(map.get("AVQ").toString());
                map.put("AVQ", 7.9582 * avq + 12.563);
                temp.add(map);
            }
        } else {
            temp = ddsDDaypDao.getAvgToMonth(stationName);
        }
        Map<String, Double> returnMap = new HashMap<>();
        for (Map tempMap : temp) {
            if (tempMap.get("year").equals(year)) {
                double p = (tempMap == null || tempMap.get("AVQ") == null ? 0.0d : Double.parseDouble(tempMap.get("AVQ").toString()));
                returnMap.put(tempMap.get("month").toString(), division(p));
            }
        }
        Set<String> set = returnMap.keySet();
        for(int i =0;i<12;i++) {
            boolean flag = false;
            for (String s : set) {

                if(Integer.parseInt(formatStrNum(s)) == (i+1) && returnMap.get(s)!=0.0d){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                String str ="";
                if(i<9){
                    str = "0"+(i+1);
                }else{
                    str = (i+1)+"";
                }
                returnMap.put(str,getDefaultMonthQ(stationName,i));
            }
        }
        return returnMap;
    }

    public List<Double> getAvgToMonth_con(String stationName, String year) {
        List<Map> temp = ddsDDaypDao.getAvgToMonth(stationName);
        List<Double> returnList = new LinkedList<>();
        for (Map tempMap : temp) {
            if (tempMap.get("year").equals(year)) {
                double p = (tempMap == null || tempMap.get("AVQ") == null||Double.parseDouble(tempMap.get("AVQ").toString()) == 0.0d) ? getDefaultMonthQ(stationName,Integer.parseInt(tempMap.get("month").toString())) : Double.parseDouble(tempMap.get("AVQ").toString());
                returnList.add(division(p));
            }
        }
        return returnList;
    }

    public List<Double> getAvg() {
        List<Map> temp = ddsDDaypDao.getAvg();
        List<Double> returnList = new LinkedList<>();
        for (Map tempMap : temp) {
            returnList.add(division2(new BigDecimal(tempMap.get("AVQ").toString())));
        }
        return returnList;
    }

    public List<Map> getStationInfo(String river) {
        List<Map> temp = new ArrayList<>();
        if ("02".equals(river)) {
            temp = ddsDDaypDao.getStationInfo();
        } else {
            Map map = new HashMap();
            map.put("stationName", "茅洲");
            map.put("stationNum", "62310700");
            map.put("startTime", "1980");
            map.put("endTime", "2017");
            temp.add(map);
        }
        for (Map tempMap : temp) {
            tempMap.put("stationType", "水文站");
        }
        return temp;
    }

    public double division2(BigDecimal bd) {
        if (bd == null) {
            return 0.0;
        } else {
            double returnDouble = Double.parseDouble(bd.setScale(1, BigDecimal.ROUND_HALF_UP).toString());
            return returnDouble;
        }
    }

    public double division(double d) {
        BigDecimal bd = new BigDecimal(d);
        double returnDouble = Double.parseDouble(bd.setScale(1, BigDecimal.ROUND_HALF_UP).toString());
        return returnDouble;
    }

    //    public Double getForecastToMonth(String station,List<Map> monthList,double a,double b0,double b1,List<Double> aList,List<Double> bList) {
//
//    }
    //南丰年降雨量
    public Double getForecast_nf_year(int year) {
        double nf_p_year = 0.0d;
        Map<String, BigDecimal> map = getYearRunoffQandU("南丰", year);
        if (map == null) {
            return 0.0;
        }
        nf_p_year = (map.get("U") == null) ? 0 : Double.parseDouble(map.get("U").toString());
        return nf_p_year;
    }

    /**
     * @param station
     * @param year
     * @return 单位 亿m3
     */
    public Double getForecast(String station, int year) {
        Map<String, Result> resultMap = new HashMap<>();
        double returnData = 0.0;

        if ("洪门".equals(station) || "南丰".equals(station)) {

            double q = 0.0;
            double q_nf_year = 0.0d;
            /*
            *运用线性回归计算南丰前5年降水量曲线
            */
            double[] qx = new double[5];
            for (int i = 0; i < 5; i++) {
                qx[i] = getForecast_nf_year(year + i - 5);
            }
            RegressionLine line = new RegressionLine();
            for (int i = 0; i < qx.length; i++) {
                line.addDataPoint(new DataPoint(i + 1, qx[i]));
            }
            q_nf_year = line.getValue(6);
            //如果遇到预测降水量（P6）小于0的情况，则认为P6为前两年降水量的平均值，即P6=(P5+P4)*0.5。
            if (q_nf_year < 0) {
                q_nf_year = (getForecast_nf_year(year - 2) + getForecast_nf_year(year - 2)) / 2;
            }
            q = 3.4049 * (0.0179 * q_nf_year - 6.581);

            if ("洪门".equals(station)) {
                return q;
            }
            if ("南丰".equals(station)) {
                return getForecast("沙子岭", year);
            }
        }


        //步骤一：降水、径流一次累加
        if (station.equals("廖家湾")) {
            Liaojiawan liaojiawan = new Liaojiawan();
            int startYear = year - (int) liaojiawan.getP() - 1;
            double tempU = 0.0;
            double tempQ = 0.0;
            double Y = 0.0d;
            double F = 0.0d;
            double Q = 0.0d;
            List<Map> results = new ArrayList<>();
            for (int i = 1980; i < year; i++) {
                Map map = new HashMap();
                String key = String.valueOf(i);
                map.put("U", division2((BigDecimal) (getYearRunoffQandU(station, i).get("U"))));
                map.put("Q", division2((BigDecimal) (getYearRunoffQandU(station, i).get("Q"))));
                tempU += division2((BigDecimal) (getYearRunoffQandU(station, i).get("U")));
                map.put("U1", tempU);
                tempQ += division2((BigDecimal) (getYearRunoffQandU(station, i).get("Q")));
                map.put("Q1", tempQ);
                if (i >= startYear) {
                    results.add(map);
                }
            }
            for (int i = 0; i < results.size(); i++) {
                F = (-1) * liaojiawan.getPa() * Double.parseDouble(results.get(i).get("Q1").toString()) + liaojiawan.getPb0() * Double.parseDouble(results.get(i).get("U").toString()) + liaojiawan.getPb1() * Double.parseDouble(results.get(i).get("U1").toString());
                if (i == 0) {
                    Y = Double.parseDouble(results.get(i).get("Q1").toString());
                } else {
                    Y = 0.5 * (Double.parseDouble(results.get(i).get("Q1").toString()) + Double.parseDouble(results.get(i - 1).get("Q1").toString()));
                }
                Q += (liaojiawan.getA().get(i) * Y + liaojiawan.getB().get(i) * F);
            }
            returnData = division(Math.abs(Q - Double.parseDouble(results.get(results.size() - 1).get("Q1").toString())));
            return returnData;
//            Liaojiawan liaojiawan = new Liaojiawan();
//            int startYear = year - (int) liaojiawan.getP();
//            double tempU = 0.0;
//            double tempQ = 0.0;
//            for (int i = startYear; i <= year; i++) {
//                Result result = new Result();
//                String key = String.valueOf(i);
//                result.setU(division2(ddsDDaypDao.getForcast_ljw(i + START_TIME, i + END_TIME).get("U")));//降雨量
//                result.setQ(division2(ddsDDaypDao.getForcast_ljw(i + START_TIME, i + END_TIME).get("Q")));//径流量
//                result.setU1(tempU += division2(ddsDDaypDao.getForcast_ljw(i + START_TIME, i + END_TIME).get("U")));
//                result.setQ1(tempQ += division2(ddsDDaypDao.getForcast_ljw(i + START_TIME, i + END_TIME).get("Q")));
////                步骤2：参数F计算,参数F的计算公式为：F(i)=-a*Q1(i)+b0*U(i)+b1*U1(i),
//                result.setF(-liaojiawan.getPa() * tempQ + liaojiawan.getPb0() * division2(ddsDDaypDao.getForcast_ljw(i + START_TIME, i + END_TIME).get("U")) + liaojiawan.getPb1() * tempU);
//                //步骤3：参数Y计算，Y的计算法则如下： 当i=1时， Y(1)=Q1(1) 当i>1时， Y(i)= 0.5*(Q1(i)+Q1(i-1))lt);
//                if (i == startYear) result.setY(tempQ);
//                else result.setY(0.5 * (tempQ + resultMap.get(String.valueOf(i - 1)).getQ1()));
//                resultMap.put(key, result);
//            }
//            returnData += liaojiawan.getA1() * resultMap.get(String.valueOf(startYear)).getY();
//            returnData += liaojiawan.getA2() * resultMap.get(String.valueOf(startYear + 1)).getY();
//            returnData += liaojiawan.getA3() * resultMap.get(String.valueOf(startYear + 2)).getY();
//            returnData += liaojiawan.getA4() * resultMap.get(String.valueOf(startYear + 3)).getY();
//            returnData += liaojiawan.getA5() * resultMap.get(String.valueOf(startYear + 4)).getY();
//            returnData += liaojiawan.getA6() * resultMap.get(String.valueOf(startYear + 5)).getY();
//            returnData += liaojiawan.getA7() * resultMap.get(String.valueOf(startYear + 6)).getY();
//            returnData += liaojiawan.getA8() * resultMap.get(String.valueOf(startYear + 7)).getY();
//            returnData += liaojiawan.getA9() * resultMap.get(String.valueOf(startYear + 8)).getY();
//            returnData += liaojiawan.getB1() * resultMap.get(String.valueOf(startYear)).getF();
//            returnData += liaojiawan.getB2() * resultMap.get(String.valueOf(startYear + 1)).getF();
//            returnData += liaojiawan.getB3() * resultMap.get(String.valueOf(startYear + 2)).getF();
//            returnData += liaojiawan.getB4() * resultMap.get(String.valueOf(startYear + 3)).getF();
//            returnData += liaojiawan.getB5() * resultMap.get(String.valueOf(startYear + 4)).getF();
//            returnData += liaojiawan.getB6() * resultMap.get(String.valueOf(startYear + 5)).getF();
//            returnData += liaojiawan.getB7() * resultMap.get(String.valueOf(startYear + 6)).getF();
//            returnData += liaojiawan.getB8() * resultMap.get(String.valueOf(startYear + 7)).getF();
//            returnData += liaojiawan.getB9() * resultMap.get(String.valueOf(startYear + 8)).getF();
//            returnData = Math.abs(returnData - resultMap.get(String.valueOf(startYear + 8)).getQ1());
//            returnData = division(returnData );
            //          return returnData;
        } else if (station.equals("沙子岭")) {
            Shaziling shaziling = new Shaziling();
            int startYear = year - (int) shaziling.getP() - 1;
            double tempU = 0.0;
            double tempQ = 0.0;
            double Y = 0.0d;
            double F = 0.0d;
            double Q = 0.0d;
            List<Map> results = new ArrayList<>();
            for (int i = 1980; i < year; i++) {
                Map map = new HashMap();
                String key = String.valueOf(i);
                map.put("U", division2((BigDecimal) (getYearRunoffQandU(station, i).get("U"))));
                map.put("Q", division2((BigDecimal) (getYearRunoffQandU(station, i).get("Q"))));
                tempU += division2((BigDecimal) (getYearRunoffQandU(station, i).get("U")));
                map.put("U1", tempU);
                tempQ += division2((BigDecimal) (getYearRunoffQandU(station, i).get("Q")));
                map.put("Q1", tempQ);
                if (i >= startYear) {
                    results.add(map);
                }
            }
            for (int i = 0; i < results.size(); i++) {
                F = (-1) * shaziling.getPa() * Double.parseDouble(results.get(i).get("Q1").toString()) + shaziling.getPb0() * Double.parseDouble(results.get(i).get("U").toString()) + shaziling.getPb1() * Double.parseDouble(results.get(i).get("U1").toString());
                if (i == 0) {
                    Y = Double.parseDouble(results.get(i).get("Q1").toString());
                } else {
                    Y = 0.5 * (Double.parseDouble(results.get(i).get("Q1").toString()) + Double.parseDouble(results.get(i - 1).get("Q1").toString()));
                }
                Q += (shaziling.getA().get(i) * Y + shaziling.getB().get(i) * F);
            }
            returnData = division(Math.abs(Q - Double.parseDouble(results.get(results.size() - 1).get("Q1").toString())));
            return returnData;
        } else if (station.equals("娄家村")) {
            Loujiacun loujiacun = new Loujiacun();
            int startYear = year - (int) loujiacun.getP() - 1;
            double tempU = 0.0;
            double tempQ = 0.0;
            double Y = 0.0d;
            double F = 0.0d;
            double Q = 0.0d;
            List<Map> results = new ArrayList<>();
            for (int i = 1980; i < year; i++) {
                Map map = new HashMap();
                String key = String.valueOf(i);
                map.put("U", division2((BigDecimal) (getYearRunoffQandU(station, i).get("U"))));
                map.put("Q", division2((BigDecimal) (getYearRunoffQandU(station, i).get("Q"))));
                tempU += division2((BigDecimal) (getYearRunoffQandU(station, i).get("U")));
                map.put("U1", tempU);
                tempQ += division2((BigDecimal) (getYearRunoffQandU(station, i).get("Q")));
                map.put("Q1", tempQ);
                if (i >= startYear) {
                    results.add(map);
                }
            }
            for (int i = 0; i < results.size(); i++) {
                F = (-1) * loujiacun.getPa() * Double.parseDouble(results.get(i).get("Q1").toString()) + loujiacun.getPb0() * Double.parseDouble(results.get(i).get("U").toString()) + loujiacun.getPb1() * Double.parseDouble(results.get(i).get("U1").toString());
                if (i == 0) {
                    Y = Double.parseDouble(results.get(i).get("Q1").toString());
                } else {
                    Y = 0.5 * (Double.parseDouble(results.get(i).get("Q1").toString()) + Double.parseDouble(results.get(i - 1).get("Q1").toString()));
                }
                Q += (loujiacun.getA().get(i) * Y + loujiacun.getB().get(i) * F);
            }
            returnData = division(Math.abs(Q - Double.parseDouble(results.get(results.size() - 1).get("Q1").toString())));
            return returnData;
        } else if (station.equals("茅洲")) {
            Maozhou mz = new Maozhou();
            int startYear = year - (int) mz.getP() - 1;
            double tempU = 0.0;
            double tempQ = 0.0;
            double Y = 0.0d;
            double F = 0.0d;
            double Q = 0.0d;
            List<Map> results = new ArrayList<>();
            for (int i = 1980; i < year; i++) {
                Map map = new HashMap();
                map.put("U", (division2(ddsDDaypDao.getForcast_mz(i + START_TIME, i + END_TIME).get("U"))));
                map.put("Q", (division2(ddsDDaypDao.getForcast_mz(i + START_TIME, i + END_TIME).get("Q"))));
                tempU += division2(ddsDDaypDao.getForcast_mz(i + START_TIME, i + END_TIME).get("U"));
                map.put("U1", tempU);
                tempQ += division2(ddsDDaypDao.getForcast_mz(i + START_TIME, i + END_TIME).get("Q"));
                map.put("Q1", tempQ);
                if (i >= startYear) {
                    results.add(map);
                }
            }
            for (int i = 0; i < results.size(); i++) {
                F = (-1) * mz.getPa() * Double.parseDouble(results.get(i).get("Q1").toString()) + mz.getPb0() * Double.parseDouble(results.get(i).get("U").toString()) + mz.getPb1() * Double.parseDouble(results.get(i).get("U1").toString());
                if (i == 0) {
                    Y = Double.parseDouble(results.get(i).get("Q1").toString());
                } else {
                    Y = 0.5 * (Double.parseDouble(results.get(i).get("Q1").toString()) + Double.parseDouble(results.get(i - 1).get("Q1").toString()));
                }
                Q += (mz.getA().get(i) * Y + mz.getB().get(i) * F);
            }
            returnData = division(Math.abs(Q - Double.parseDouble(results.get(results.size() - 1).get("Q1").toString())));
            returnData = 7.9582 * returnData + 12.563;
            return returnData;
        }
//            Loujiacun loujiacun = new Loujiacun();
//            int startYear = year - (int) loujiacun.getP();
//            double tempU = 0.0;
//            double tempQ = 0.0;
//            for (int i = startYear; i <= year; i++) {
//                Result result = new Result();
//                String key = String.valueOf(i);
//                result.setU(division2(ddsDDaypDao.getForcast_ljc(i + START_TIME, i + END_TIME).get("U")));
//                result.setQ(division2(ddsDDaypDao.getForcast_ljc(i + START_TIME, i + END_TIME).get("Q")));
//                result.setU1(tempU += division2(ddsDDaypDao.getForcast_ljc(i + START_TIME, i + END_TIME).get("U")));
//                result.setQ1(tempQ += division2(ddsDDaypDao.getForcast_ljc(i + START_TIME, i + END_TIME).get("Q")));
////                步骤2：参数F计算,参数F的计算公式为：F(i)=-a*Q1(i)+b0*U(i)+b1*U1(i),
//                result.setF(-loujiacun.getPa() * tempQ + loujiacun.getPb0() * division2(ddsDDaypDao.getForcast_ljc(i + START_TIME, i + END_TIME).get("U")) + loujiacun.getPb1() * tempU);
//                //步骤3：参数Y计算，Y的计算法则如下： 当i=1时， Y(1)=Q1(1) 当i>1时， Y(i)= 0.5*(Q1(i)+Q1(i-1))lt);
//                if (i == startYear) result.setY(tempQ);
//                else result.setY(0.5 * (tempQ + resultMap.get(String.valueOf(i - 1)).getQ1()));
//                resultMap.put(key, result);
//            }
//            returnData += loujiacun.getA1() * resultMap.get(String.valueOf(startYear)).getY();
//            returnData += loujiacun.getA2() * resultMap.get(String.valueOf(startYear + 1)).getY();
//            returnData += loujiacun.getA3() * resultMap.get(String.valueOf(startYear + 2)).getY();
//            returnData += loujiacun.getA4() * resultMap.get(String.valueOf(startYear + 3)).getY();
//            returnData += loujiacun.getA5() * resultMap.get(String.valueOf(startYear + 4)).getY();
//            returnData += loujiacun.getA6() * resultMap.get(String.valueOf(startYear + 5)).getY();
//            returnData += loujiacun.getB1() * resultMap.get(String.valueOf(startYear)).getF();
//            returnData += loujiacun.getB2() * resultMap.get(String.valueOf(startYear + 1)).getF();
//            returnData += loujiacun.getB3() * resultMap.get(String.valueOf(startYear + 2)).getF();
//            returnData += loujiacun.getB4() * resultMap.get(String.valueOf(startYear + 3)).getF();
//            returnData += loujiacun.getB5() * resultMap.get(String.valueOf(startYear + 4)).getF();
//            returnData += loujiacun.getB6() * resultMap.get(String.valueOf(startYear + 5)).getF();
//            returnData = Math.abs(returnData - resultMap.get(String.valueOf(startYear + 5)).getQ1());
//            returnData = division(returnData);
//            return returnData;
//    }
        return 0.0;
    }

    /**
     * @param station
     * @param year
     * @param returnData 单位：m3/s
     * @return
     */
    public List<Map> getForecast(String station, int year, double returnData) {
        year = year - 1;
        Map<String, Double> lastYear = new HashMap<>();
        if (!station.equals("洪门") && !station.equals("廖坊")) {
            lastYear = getAvgToMonth(station, String.valueOf(year));
        }
        List<Double> avgYear = getAvg();
        List<Map> returnList = new ArrayList<>();
        if (station.equals("廖家湾")) {
            if (returnData <= 64.6) {
                List<Double> foreP = new ArrayList<Double>() {{
                    add(0.014);
                    add(0.017);
                    add(0.081);
                    add(0.15);
                    add(0.201);
                    add(0.105);
                    add(0.079);
                    add(0.045);
                    add(0.039);
                    add(0.077);
                    add(0.114);
                    add(0.08);
                }};
                returnList = getYearData(returnData, foreP, lastYear, avgYear, "枯水");
            } else if (64.6 < returnData && returnData < 113.8) {
                List<Double> foreP = new ArrayList<Double>() {{
                    add(0.033);
                    add(0.095);
                    add(0.06);
                    add(0.062);
                    add(0.201);
                    add(0.245);
                    add(0.091);
                    add(0.048);
                    add(0.05);
                    add(0.053);
                    add(0.034);
                    add(0.029);
                }};
                returnList = getYearData(returnData, foreP, lastYear, avgYear, "平水");
            } else if (113.8 <= returnData) {
                List<Double> foreP = new ArrayList<Double>() {{
                    add(0.048);
                    add(0.053);
                    add(0.07);
                    add(0.18);
                    add(0.158);
                    add(0.152);
                    add(0.064);
                    add(0.086);
                    add(0.055);
                    add(0.026);
                    add(0.061);
                    add(0.046);
                }};
                returnList = getYearData(returnData, foreP, lastYear, avgYear, "丰水");
            }
        } else if (station.equals("李家渡")) {
            if (returnData <= 85.1) {
                List<Double> foreP = new ArrayList<Double>() {{
                    add(0.025);
                    add(0.008);
                    add(0.109);
                    add(0.167);
                    add(0.117);
                    add(0.325);
                    add(0.115);
                    add(0.062);
                    add(0.032);
                    add(0.005);
                    add(0.009);
                    add(0.028);
                }};
                returnList = getYearData(returnData, foreP, lastYear, avgYear, "枯水");
            } else if (85.1 < returnData && returnData < 160.9) {
                List<Double> foreP = new ArrayList<Double>() {{
                    add(0.048);
                    add(0.051);
                    add(0.077);
                    add(0.135);
                    add(0.140);
                    add(0.274);
                    add(0.144);
                    add(0.073);
                    add(0.015);
                    add(0.023);
                    add(0.009);
                    add(0.010);
                }};
                returnList = getYearData(returnData, foreP, lastYear, avgYear, "平水");
            } else if (160.9 <= returnData) {
                List<Double> foreP = new ArrayList<Double>() {{
                    add(0.035);
                    add(0.074);
                    add(0.113);
                    add(0.204);
                    add(0.195);
                    add(0.213);
                    add(0.094);
                    add(0.016);
                    add(0.019);
                    add(0.015);
                    add(0.009);
                    add(0.013);
                }};
                returnList = getYearData(returnData, foreP, lastYear, avgYear, "丰水");
            }
        } else if (station.equals("娄家村")) {
            if (returnData <= 44.3) {
                List<Double> foreP = new ArrayList<Double>() {{
                    add(0.022);
                    add(0.054);
                    add(0.116);
                    add(0.160);
                    add(0.103);
                    add(0.201);
                    add(0.101);
                    add(0.063);
                    add(0.037);
                    add(0.036);
                    add(0.082);
                    add(0.026);
                }};
                returnList = getYearData(returnData, foreP, lastYear, avgYear, "枯水");
            } else if (44.3 < returnData && returnData < 62.8) {
                List<Double> foreP = new ArrayList<Double>() {{
                    add(0.022);
                    add(0.043);
                    add(0.141);
                    add(0.331);
                    add(0.128);
                    add(0.085);
                    add(0.031);
                    add(0.037);
                    add(0.024);
                    add(0.045);
                    add(0.084);
                    add(0.030);
                }};
                returnList = getYearData(returnData, foreP, lastYear, avgYear, "平水");
            } else if (62.8 <= returnData) {
                List<Double> foreP = new ArrayList<Double>() {{
                    add(0.054);
                    add(0.051);
                    add(0.083);
                    add(0.133);
                    add(0.143);
                    add(0.254);
                    add(0.137);
                    add(0.058);
                    add(0.025);
                    add(0.032);
                    add(0.015);
                    add(0.014);
                }};
                returnList = getYearData(returnData, foreP, lastYear, avgYear, "丰水");
            }
        } else if (station.equals("南丰")) {
            List<Double> foreP = new ArrayList<Double>() {{
                add(0.033);
                add(0.039);
                add(0.083);
                add(0.109);
                add(0.157);
                add(0.212);
                add(0.102);
                add(0.068);
                add(0.054);
                add(0.038);
                add(0.055);
                add(0.049);
            }};
            returnList = getYearData(returnData, foreP, lastYear, avgYear, "");
        } else if (station.equals("洪门")) {
            List<Double> foreP = new ArrayList<Double>() {{
                add(0.031);
                add(0.054);
                add(0.101);
                add(0.171);
                add(0.168);
                add(0.180);
                add(0.084);
                add(0.049);
                add(0.049);
                add(0.042);
                add(0.041);
                add(0.030);
            }};
            returnList = getYearData(returnData, foreP, lastYear, avgYear, "");
        } else if (station.equals("沙子岭")) {
            List<Double> foreP = new ArrayList<Double>() {{
                add(0.038);
                add(0.053);
                add(0.095);
                add(0.127);
                add(0.148);
                add(0.182);
                add(0.094);
                add(0.073);
                add(0.061);
                add(0.048);
                add(0.044);
                add(0.038);
            }};
            returnList = getYearData(returnData, foreP, lastYear, avgYear, "");
        } else if (station.equals("茅洲")) {
            List<Double> foreP = new ArrayList<Double>() {{
                add(0.037593212);
                add(0.063472324);
                add(0.11021158);
                add(0.149919675);
                add(0.139352987);
                add(0.152517492);
                add(0.104534139);
                add(0.057780889);
                add(0.054742391);
                add(0.050682162);
                add(0.045277849);
                add(0.0339153);
            }};
            returnList = getYearData(returnData, foreP, lastYear, avgYear, "");
        }
        return returnList;
    }

    public List<Map> getYearData(double forecast, List<Double> foreP, Map<String, Double> lastYear, List<Double> avgYear, String type) {
        List<Map> returnList = new LinkedList<>();
        Map<String, String> tempMap_all = new HashMap();
        double tempForecast = 0.0;
        double templastYear = 0.0;
        double tempP3 = 0.0;
        double tempAvgYear = 0.0;
        double tempP5 = 0.0;
        for (int i = 0; i < avgYear.size(); i++) {
            Map<String, String> tempMap = new HashMap();
            String tempMonth = (i + 1) + "月";
            String lastYearI = i < 9 ? String.valueOf("0" + (i + 1)) : String.valueOf((i + 1));
            double p1 = foreP.get(i) * forecast * 365 / 30;
            double p2 = (lastYear.get(lastYearI) == null)||(lastYear.get(lastYearI) == 0.0d) ? 0.0d : lastYear.get(lastYearI);
            double p3 = p1 - p2;
            double p4 = avgYear.get(i);
            double p5 = 0d;
            if (p4 != 0d) {
                p5 = division((p1 - p4) / p4 * 100d);
            }
            tempForecast += p1;
            templastYear += p2;
            tempP3 += p3;
            tempAvgYear += p4;
            tempMap.put("month", tempMonth);
            tempMap.put("p1", String.valueOf(division(p1)));
            tempMap.put("p2", String.valueOf(division(p2)));
            tempMap.put("p3", String.valueOf(division(p3)));
            tempMap.put("p4", String.valueOf(division(p4)));
            tempMap.put("p5", p5 + "");
            tempMap.put("p6", getP6(p5));
            returnList.add(tempMap);
        }
        tempMap_all.put("month", "全年");
        tempMap_all.put("p1", String.valueOf(division(tempForecast / 12)));
        tempMap_all.put("p2", String.valueOf(division(templastYear / 12)));
        tempMap_all.put("p3", String.valueOf(division(tempP3 / 12)));
        if (tempAvgYear != 0) {
            tempP5 = division(((tempForecast - tempAvgYear) / tempAvgYear) * 100d);
        }
        tempMap_all.put("p4", String.valueOf(division(tempAvgYear / 12)));
        tempMap_all.put("p5", tempP5 + "");
        tempMap_all.put("p6", getP6(tempP5));
        returnList.add(tempMap_all);
        return returnList;
    }


    public List<String> getMonthList(String stationName, Date date, int num) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String endDates[] = sdf.format(date).split("-");
        String endDate = "";
        String beginDate = "";
        if ((Integer.parseInt(endDates[1]) > 1)) {
            endDate = formatStr(endDates[0] + "-" + (Integer.parseInt(endDates[1]) - 1));
        } else {
            endDate = formatStr((Integer.parseInt(endDates[0]) - 1) + "-12");
        }
        List<String> monthList = new ArrayList();
        if (num != 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - num - 1);
            beginDate = sdf.format(calendar.getTime());

        } else {
            if ("南丰".equals(stationName)) {
                beginDate = "2004-12";
            } else {
                beginDate = "1979-12";
            }
        }

        getMonths(monthList, beginDate, endDate);
        return monthList;
    }

    public List<String> getXunLists() {
        List<String> xunList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 1) {
                    xunList.add(i + "月上");
                }
                if (j == 2) {
                    xunList.add(i + "月中");
                }
                if (j == 3) {
                    xunList.add(i + "月下");
                }
            }
        }
        return xunList;
    }

    public String getFromatXun(String startTime) {
        String[] split = startTime.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        String xun = null;
        if (day == 10) {
            xun = year + "年" + month + "月中";
        } else if (day == 20) {
            xun = year + "年" + month + "月下";
        } else {
            if (Integer.parseInt(split[1]) == 12) {
                xun = year + 1 + "年1月上";
            } else {
                xun = year + "年" + (month + 1) + "月上";
            }
        }
        return xun;
    }

//    public List<String> getFormatXunList(String start,String end) {
//        String startXun = getFromatXun(formatStr(start));//1980年1月上
//        String endXun = getFromatXun(end);
//        List<String> xunList = getXunLists();//1月上 到12月下
//        String[] startX = startXun.split("年");
//        String[] endX = endXun.split("年");
//        int startYear = Integer.parseInt(startX[0]);//1988
//        int endYear = Integer.parseInt(endX[0]);//1988
//        String startMonth = startX[1];//1月下
//        String endMonth = endX[1];
//        List<String> fmtXunList =  new ArrayList<>();
//        boolean flag = false;
//        for(int i=0;i<=endYear-startYear;i++){
//            if(startYear+i < endYear)  {
//                for(String xuns :xunList){
//                    fmtXunList.add((startYear+i)+"年"+xuns);
//                }
//            }
//            if(startYear + i == endYear) {
//                for (int j = 0; j < xunList.size(); j++) {
//                    if (xunList.get(j).equals(startMonth)) {
//                        flag = true;
//                    }
//                    if (xunList.get(j).equals(endMonth)) {
//                        flag = false;
//                    }
//                    if (flag) {
//                        fmtXunList.add((startYear+i) + "年" + xunList.get(j));
//                    }
//
//                }
//            }
//        }
//        return fmtXunList;
//    }

    public List<String> getFormatXunList(String start) {
        String startXun = getFromatXun(formatStr(start));
        List<String> xunList = getXunLists();
        List<String> ftXunList = new ArrayList<>();
        boolean flag = false;
        boolean flag1 = false;
        String[] startX = startXun.split("年");
        int year = Integer.parseInt(startX[0]);//1988
        String mxun = startX[1];//1月下
        for (int j = 0; j < xunList.size(); j++) {
            if (xunList.get(j).equals(mxun)) {
                flag = true;
            }
            if (flag) {
                ftXunList.add(year + "年" + xunList.get(j));
            }
        }
        for (int k = 0; k < xunList.size(); k++) {
            if (xunList.get(k).equals(mxun)) {
                flag1 = true;
            }
            if (!flag1) {
                ftXunList.add(year + 1 + "年" + xunList.get(k));
            }
        }

        return ftXunList;
    }


    public List<String> getMonths(List<String> monthList, String beginDate, String endDate) {
        String[] endTime = endDate.split("-");
        int endYear = Integer.parseInt(endTime[0]);
        int endMonth = Integer.parseInt(endTime[1]);
        String[] beginTime = beginDate.split("-");
        int beginYear = Integer.parseInt(beginTime[0]);
        int beginMonth = Integer.parseInt(beginTime[1]);

        if (endYear == beginYear) {
            for (int i = 1; i <= endMonth - beginMonth; i++) {
                monthList.add(formatString(beginYear + "-" + (beginMonth + i)));
            }
        } else {
            int n = endYear - beginYear;

            for (int i = 1; i <= 12 - beginMonth; i++) {
                monthList.add(formatString(beginYear + "-" + (beginMonth + i)));
            }
            for (int k = 1; k < n; k++) {
                for (int m = 1; m <= 12; m++) {
                    monthList.add(formatString((beginYear + k) + "-" + m));
                }
            }
            for (int j = 1; j <= endMonth; j++) {
                monthList.add(formatString(endYear + "-" + j));
            }
        }
        return monthList;
    }


    public String formatString(String str) {
        if (str.length() != 7) {
            StringBuffer bf = new StringBuffer();
            String[] strings = str.split("-");
            bf.append(strings[0]);
            bf.append("-0");
            bf.append(strings[1]);
            return bf.toString();
        }
        return str;
    }


    /************************************************************************************************************/
    /************************************************************************************************************/
    /*****************************************水文模型************************************************************/
    /************************************************************************************************************/
    /************************************************************************************************************/
    /************************************************************************************************************/

    ///***********水文模型（年）*********************////
    public List<Map> getForecastYear_sw(String stationName, int year) throws Exception {
        List<Map> dataMap = new ArrayList<>();
        List<Map> p2List = new ArrayList<>();
        List<Map> p4List = new ArrayList<>();

        List<Double> p1List = runoffYeartoMonth_sw(stationName, year);
        if ("廖坊".equals(stationName)) {
            List<Map> p2Nf = ddsDDaypDao.getYearAllQ(year - 1 + "", year + "", "南丰");
            p2Nf = addDefaultValue(p2Nf,"南丰",null,1);
            List<Map> p2Hm = getMapHMP2YearList(year - 1);
            for (int i = 0; i < p2Nf.size(); i++) {
                Map map = new HashMap();
                map.put("MONTH", p2Nf.get(i).get("MONTH"));
                int k = Integer.parseInt(p2Nf.get(i).get("MONTH").toString());
                map.put("Q", Double.parseDouble(p2Nf.get(i).get("Q").toString())+Double.parseDouble(p2Hm.get(k-1).get("Q").toString()));
                p2List.add(map);
            }

            p4List = getMapLFP4YearList();

        } else if ("洪门".equals(stationName)) {
            boolean flag = true;
            if(p1List != null) {
                for(double d : p1List){
                    if(d == 0d){
                        flag = false;
                        break;
                    }
                }
            }else{
                flag = false;
            }
            if(!flag){
                p1List = getHMP2YearList(year);
                p1List.remove(p1List.size()-1);
            }
            p2List = getMapHMP2YearList(year - 1);
            p4List = getMapHMP4YearList();
        } else if ("李家渡".equals(stationName)) {
            List<Map> p22List = ddsDDaypDao.getYearAllQ(year - 1 + "", year + "", "廖家湾");
            List<Map> p21List = ddsDDaypDao.getYearAllQ(year - 1 + "", year + "", "娄家村");
            p22List = addDefaultValue(p22List,"廖家湾",null,1);
            p21List = addDefaultValue(p21List,"娄家村",null,1);
            List<Map> p40List = ddsDDaypDao.getYearAllQ("1980", year + "", stationName);
            for (int i = 0; i < p40List.size(); i++) {
                double p20 = Double.parseDouble(p22List.get(i).get("Q").toString())* 0.821 +
                        + Double.parseDouble(p21List.get(i).get("Q").toString()) * 0.963 +
                        getLJDMonth().get(i);
                double p40 = Double.parseDouble(p40List.get(i).get("Q").toString()) + getLJDMonth().get(i);
                Map map2 = new HashMap();
                Map map4 = new HashMap();
                map2.put("MONTH", p40List.get(i).get("MONTH"));
                map4.put("MONTH", p40List.get(i).get("MONTH"));
                map2.put("Q", p20);
                map4.put("Q", p40);
                p2List.add(map2);
                p4List.add(map4);
            }


        } else {
            p2List = ddsDDaypDao.getYearAllQ(year - 1 + "", year + "", stationName);
            p4List = ddsDDaypDao.getYearAllQ("1980", year + "", stationName);
        }
        if(!"李家渡".equals(stationName)) {
            p2List = addDefaultValue(p2List, stationName, null, 1);
            p4List = addDefaultValue(p4List, stationName, null, 1);
        }
        double p1_all = 0.0d;
        double p2_all = 0.0d;
        double p4_all = 0.0d;
        for (int i = 0; i < p1List.size(); i++) {
            p1_all += p1List.get(i);
        }
        for (int i = 0; i < p2List.size(); i++) {
            p2_all += Double.parseDouble(p2List.size() == 0 || p2List.get(i).get("Q") == null ? "0" : p2List.get(i).get("Q").toString());
        }
        for (int i = 0; i < p4List.size(); i++) {
            p4_all += Double.parseDouble(p4List.size() == 0 ? "0" : p4List.get(i).get("Q").toString());
        }
        //1-12月
        for (int i = 0; i < p1List.size(); i++) {
            Map<String, String> tempMap = new HashMap();
            tempMap.put("month", (i + 1) + "月");
            double p1 = division(p1List.get(i));
            tempMap.put("p1", p1 + "");
            double p2 = 0.0;
            for (Map map : p2List) {
                if(map.size() == 1){
                    p2 = Double.parseDouble(p2List.get(i).get("Q").toString());
                }else {
                    if (map.get("MONTH") != null && Integer.parseInt((formatStrNum(map.get("MONTH").toString()))) == (i + 1)) {
                        if (map.get("Q") != null) {
                            p2 = Double.parseDouble(map.get("Q").toString());
                        }
                    }
                }
            }
            tempMap.put("p2", division(p2) + "");
            tempMap.put("p3", division(p1 - p2) + "");
            double p4 = division(Double.parseDouble(p4List.size() == 0 ? "0" : p4List.get(i).get("Q").toString()));
            tempMap.put("p4", division(p4) + "");
            double p5 = 0;
            if (p4 != 0) {
                p5 = division((p1 - p4) / p4 * 100d);
            }
            tempMap.put("p5", p5 + "");
            tempMap.put("p6", getP6(p5));
            dataMap.add(tempMap);
        }
        //全年
        Map<String, String> tempMap = new HashMap();
        tempMap.put("month", "全年");
        tempMap.put("p1", division(p1_all / 12) + "");
        tempMap.put("p2", division(p2_all / 12) + "");
        tempMap.put("p3", division((p1_all - p2_all) / 12) + "");
        tempMap.put("p4", division(p4_all / 12) + "");
        double p5 = 0;
        if (p4_all != 0) {
            p5 = division(((p1_all - p4_all) / p4_all) * 100d);
        }
        tempMap.put("p5", p5 + "");
        tempMap.put("p6", getP6((p1_all - p4_all) / p4_all * 100d));
        dataMap.add(tempMap);

        return dataMap;
    }

    ///****年降水量（单位：mmm）(数据库查询)
    public double getReportYear(String stationName, int year) {
        double p = 0.0d;
        Map map = getYearRunoffQandU(stationName, year);
        if (map == null || map.get("U") == null) {
            return p;
        }
        return division2((BigDecimal) map.get("U"));//年降雨量
    }

    //****年降雨量（用前5年预报下一年）
    public double getForcastNextYear(String stationName, int year) {
        double p_next = 0;
        double p5[] = new double[5];
        //沙子岭、洪门、娄家村、廖家湾用线性回归计算
        RegressionLine line = new RegressionLine();
        if ("沙子岭".equals(stationName) || "洪门".equals(stationName) || "娄家村".equals(stationName) || "廖家湾".equals(stationName) || "茅洲".equals(stationName)) {
            for (int i = 0; i < 5; i++) {
                p5[i] = getReportYear(stationName, year + i - 5);
                line.addDataPoint(new DataPoint(i + 1, p5[i]));
            }
            p_next = line.getValue(6);
            //如果遇到预测降水量（P6）小于0的情况，则认为P6为前两年降水量的平均值，即P6=(P5+P4)*0.5。
            if (p_next < 0) {
                p_next = (p5[4] + p5[3]) / 2;
            }
        }
        return p_next;
    }

    //******年径流量计算*********//

    /**
     * @param stationName
     * @param year        预报的年份
     * @return
     */
    public double getRunoffYear_sw(String stationName, int year) {
        double R = 0.0d;//年径流量 （单位亿m3）
        Map map = new HashMap();
        if ("沙子岭".equals(stationName)) {
            map.put("P", getForcastNextYear(stationName, year));
            map.put("E", 1087.4);
            map.put("W", 1.814);
            map.put("F", 1225);
            return runoffModelYear_sw(map);
        } else if ("南丰".equals(stationName)) {
            //V南丰=2.283* V沙子岭
            return 2.238 * getRunoffYear_sw("沙子岭", year);
        } else if ("洪门".equals(stationName)) {
            map.put("P", getForcastNextYear(stationName, year));
            map.put("E", 1087.4);
            map.put("W", 1.581);
            map.put("F", 618);
            return 3.4049 * runoffModelYear_sw(map);
        } else if ("廖家湾".equals(stationName)) {
            map.put("P", getForcastNextYear(stationName, year));
            map.put("E", 1087.4);
            map.put("W", 1.743);
            map.put("F", 8723);
            return runoffModelYear_sw(map);
        } else if ("娄家村".equals(stationName)) {
            map.put("P", getForcastNextYear(stationName, year));
            map.put("E", 1087.4);
            map.put("W", 1.832);
            map.put("F", 4969);
            return runoffModelYear_sw(map);
        } else if ("李家渡".equals(stationName)) {
            return getRunoffYear_sw("廖家湾", year) * 0.821 +
                    getRunoffYear_sw("娄家村", year) * 0.963;
        } else if ("廖坊".equals(stationName)) {
            return getRunoffYear_sw("南丰", year) +
                    getRunoffYear_sw("洪门", year);
        } else if ("娄家村".equals(stationName)) {
            map.put("P", getForcastNextYear(stationName, year));
            map.put("E", 1087.4);
            map.put("W", 1.832);
            map.put("F", 4969);
            return runoffModelYear_sw(map);
        } else if ("茅洲".equals(stationName)) {
            map.put("P", getForcastNextYear(stationName, year));
            map.put("E", 1087.4);
            map.put("W", 1.509);
            map.put("F", 331);
            return 7.9582 * runoffModelYear_sw(map) + 12.563;
        }
        return 0.0;
    }


    //水文模型（年尺度）计算公式
    public Double runoffModelYear_sw(Map map) {
        double V = 0.0d;//径流（单位亿m3）
        double R = 0.0d;//径流（单位 mm/）
        double P = Double.parseDouble(map.get("P").toString());//降水
        double E = Double.parseDouble(map.get("E").toString());//蒸发能力
        double W = Double.parseDouble(map.get("W").toString());//模型参数
        double F = Double.parseDouble(map.get("F").toString());//控制面积
        R = E * (Math.pow((1d + Math.pow((P / E), W)), (1d / W)) - 1d);
        V = R * F * 0.00001;
        return V;
    }

    //************将年径流量分配到各月(单位：m3/s)**********//
    public List<Double> runoffYeartoMonth_sw(String station, int year) {
        List<Double> resultList = new ArrayList<>();
        double runoffYear = getRunoffYear_sw(station, year);
        if (station.equals("沙子岭")) {
            List<Double> foreP = new ArrayList<Double>() {{
                add(0.038);
                add(0.053);
                add(0.095);
                add(0.127);
                add(0.148);
                add(0.182);
                add(0.094);
                add(0.073);
                add(0.061);
                add(0.048);
                add(0.044);
                add(0.038);
            }};
            for (int i = 0; i < 12; i++) {
                resultList.add(runoffYear * foreP.get(i) * 100000000 / 30 / 24 / 3600);
            }
        } else if (station.equals("南丰")) {
            List<Double> foreP = new ArrayList<Double>() {{
                add(0.033);
                add(0.039);
                add(0.083);
                add(0.109);
                add(0.157);
                add(0.212);
                add(0.102);
                add(0.068);
                add(0.054);
                add(0.038);
                add(0.055);
                add(0.049);
            }};
            for (int i = 0; i < 12; i++) {
                resultList.add(runoffYear * foreP.get(i) * 100000000 / 30 / 24 / 3600);
            }
        } else if (station.equals("洪门")) {
            List<Double> foreP = new ArrayList<Double>() {{
                add(0.031);
                add(0.054);
                add(0.101);
                add(0.171);
                add(0.168);
                add(0.180);
                add(0.084);
                add(0.049);
                add(0.049);
                add(0.042);
                add(0.041);
                add(0.030);
            }};
            for (int i = 0; i < 12; i++) {
                resultList.add(runoffYear * foreP.get(i) * 100000000 / 30 / 24 / 3600);
            }
        }
        //将南城站的结果与洪门站相加即可再乘以系数
        else if (station.equals("廖坊")) {
            List<Double> hmLists = runoffYeartoMonth_sw("洪门", year);
            List<Double> nfLists = runoffYeartoMonth_sw("南丰", year);
            for (int i = 0; i < 12; i++) {
                resultList.add(1.49358 * (hmLists.get(i) + nfLists.get(i)));
            }
        } else if (station.equals("廖家湾")) {
            List<Double> foreP = new ArrayList<Double>() {{
                add(0.038);
                add(0.050);
                add(0.099);
                add(0.130);
                add(0.144);
                add(0.190);
                add(0.104);
                add(0.065);
                add(0.050);
                add(0.043);
                add(0.047);
                add(0.041);
            }};
            for (int i = 0; i < 12; i++) {
                resultList.add(runoffYear * foreP.get(i) * 100000000 / 30 / 24 / 3600);
            }
        } else if (station.equals("娄家村")) {
            List<Double> foreP = new ArrayList<Double>() {{
                add(0.038);
                add(0.054);
                add(0.108);
                add(0.143);
                add(0.147);
                add(0.188);
                add(0.092);
                add(0.06);
                add(0.050);
                add(0.036);
                add(0.045);
                add(0.039);
            }};
            for (int i = 0; i < 12; i++) {
                resultList.add(runoffYear * foreP.get(i) * 100000000 / 30 / 24 / 3600);
            }
        } else if (station.equals("李家渡")) {
            List<Double> foreP = new ArrayList<Double>() {{
                add(0.033);
                add(0.035);
                add(0.114);
                add(0.145);
                add(0.157);
                add(0.216);
                add(0.095);
                add(0.048);
                add(0.036);
                add(0.025);
                add(0.042);
                add(0.039);
            }};
            for (int i = 0; i < 12; i++) {
                resultList.add((runoffYear * foreP.get(i) * 100000000 / 30 / 24 / 3600) + getLJDMonth().get(i));
            }
        } else if (station.equals("茅洲")) {
            List<Double> foreP = new ArrayList<Double>() {{
                add(0.037593212);
                add(0.063472324);
                add(0.11021158);
                add(0.149919675);
                add(0.139352987);
                add(0.152517492);
                add(0.104534139);
                add(0.057780889);
                add(0.054742391);
                add(0.050682162);
                add(0.045277849);
                add(0.0339153);
            }};
            for (int i = 0; i < 12; i++) {
                resultList.add(runoffYear * foreP.get(i) * 100000000 / 30 / 24 / 3600);
            }
        }
        return resultList;
    }


    ///**********************************************///
    ///***********水文模型（月）*********************////
    public List<Map> getForecastMonth_sw(String station, Date date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String time = sdf.format(date);
        int year = Integer.parseInt(time.split("-")[0]);
        String month = time.split("-")[1];

        double p1 = 0.0d;//预报结果p1
        if ("沙子岭".equals(station) || "娄家村".equals(station) || "廖家湾".equals(station)) {
            p1 = getRunoffMonth_sw(station, date);
        } else if ("李家渡".equals(station)) {
            p1 = getRunoffMonth_sw("廖家湾", date) * 0.561 + getRunoffMonth_sw("娄家村", date) * 0.561;
        } else if ("南丰".equals(station)) {
            p1 = getRunoffMonth_sw(station, date);
        } else if ("廖坊".equals(station)) {
            p1 = (getRunoffMonth_sw("南丰", date) + getRunoffMonth_sw("洪门", date)) * 1.4935;
        } else if ("茅洲".equals(station)) {
            p1 = getRunoffMonth_sw(station, date) * 9.2752;
        } else if ("洪门".equals(station)) {
            p1 = 3.4049 * getRunoffMonth_sw(station, date);
        }
        //只预报当月结果，其余的用年度预报结果
        List<Map> lists = getForecastYear_sw(station, year);
        List<Map> resultLists = new ArrayList<>();

        for (int i = 0; i < lists.size(); i++) {
            String monthStr = lists.get(i).get("month").toString();
            if (!monthStr.equals("全年")) {
                if (Integer.parseInt(month) == Integer.parseInt(monthStr.split("月")[0])) {
                    lists.get(i).put("p1", division(p1) + "");
                    resultLists.add(lists.get(i));
                } else if ((Integer.parseInt(monthStr.split("月")[0])) > Integer.parseInt(month)) {
                    resultLists.add(lists.get(i));
                }
            }
        }
        return resultLists;
    }


    //************计算径流量（月）******************************//
    public double getRunoffMonth_sw(String station, Date date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String endTime = sdf.format(date);
        int year = Integer.parseInt(endTime.split("-")[0]);
        int month = Integer.parseInt(endTime.split("-")[1]);

        List<Map> mapList = getPMonth(endTime, station);////选取1980年1月至1990年5月，逐月的降水和径流数据
        List<Double> EP = new ArrayList<>();
        EP.add(41.2);
        EP.add(58.4);
        EP.add(84.7);
        EP.add(109.9);
        EP.add(121.6);
        EP.add(169.7);
        EP.add(144.8);
        EP.add(107.1);
        EP.add(82.0);
        EP.add(54.1);
        EP.add(41.7);
        EP.add(36.1);
        int days = days(year, month);
        //参数：
        double C = 0.0d, S0 = 0.0d, SC = 0.0d, F = 0.0d;
        if ("沙子岭".equals(station)) {
            C = 0.87;
            S0 = 300;
            SC = 800;
            F = 1225;
        } else if ("南丰".equals(station)) {
            C = 0.86;
            S0 = 280;
            SC = 1405;
            F = 2909;
        } else if ("洪门".equals(station)) {
            C = 1.49;
            S0 = 280;
            SC = 1485;
            F = 618;
        } else if ("廖家湾".equals(station)) {
            C = 0.81;
            S0 = 260;
            SC = 1485;
            F = 8723;
        } else if ("娄家村".equals(station)) {
            C = 0.97;
            S0 = 280;
            SC = 1085;
            F = 4969;
        } else if ("茅洲".equals(station)) {
            C = 0.87;
            S0 = 300;
            SC = 800;
            F = 1225;
        }
        double Pi = getForcastNextMonth(station, date);
        return runoffModelMonth_sw(mapList, C, S0, SC, EP, F, Pi, days);
    }

    //****月降雨量预测（选取前5年相同的月降水量）
    public double getForcastNextMonth(String stationName, Date date) {
        double p_next = 0;
        double p5[] = new double[5];
        //沙子岭、洪门、娄家村、廖家湾用线性回归计算
        RegressionLine line = new RegressionLine();
        if ("沙子岭".equals(stationName) ||
                "南丰".equals(stationName) ||
                "娄家村".equals(stationName) ||
                "洪门".equals(stationName) ||
                "廖家湾".equals(stationName) ||
                "茅洲".equals(stationName)) {
            List<Map> maps = getReportMonth(date, stationName);
            for (int i = 0; i < 5; i++) {
                if (maps.size() - 1 < i) {
                    p5[i] = 0.0d;
                } else {
                    if (maps == null || maps.get(i) == null || maps.get(i).get("P") == null) {
                        p5[i] = 0;
                    } else {
                        p5[i] = Double.parseDouble(maps.get(i).get("P").toString());
                    }
                }
                line.addDataPoint(new DataPoint(i + 1, p5[i]));
            }
            p_next = line.getValue(6);
            //如果遇到预测降水量（P6）小于0的情况，则认为P6为前两年降水量的平均值，即P6=(P5+P4)*0.5。
            if (p_next < 0) {
                p_next = (p5[4] + p5[3]) / 2;
            }
        }
        return p_next;
    }

    //月降雨量查询（数据库）
    public List<Map> getReportMonth(Date date, String stationName) {
        List<Map> mapList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String time = sdf.format(date);
        int year = Integer.parseInt(time.split("-")[0]);
        String month = time.split("-")[1];
        String start = (year - 5) + "";
        String end = year + "";
        if ("廖家湾".equals(stationName)) {
            List<Map> list1 = ddsDDaypDao.getsw_month(start, end, month, "沙子岭");
            List<Map> list2 = ddsDDaypDao.getsw_month(start, end, month, "南丰");
            List<Map> list3 = ddsDDaypDao.getsw_month(start, end, month, "洪门");
            if (list1 != null) {
                for (int i = 0; i < list1.size(); i++) {
                    Map hashMap = new HashMap();
                    if (list3.size() > i) {
                        double v1 = Double.parseDouble(list1.get(i).get("P").toString());
                        double v2 = list2.size() > i ? 0 : Double.parseDouble(list2.get(i).get("P").toString());
                        double v3 = Double.parseDouble(list3.get(i).toString());
                        hashMap.put("MONTH", list1.get(i).get("MONTH"));
                        hashMap.put("P", (v1 + v2 + v3) / 3);
                    } else {
                        double v1 = Double.parseDouble(list1.get(i).get("P").toString());
                        double v2 = list2.size() > i ? 0 : Double.parseDouble(list2.get(i).get("P").toString());
                        hashMap.put("MONTH", list1.get(i).get("MONTH"));
                        hashMap.put("P", (v1 + v2) / 2);
                    }
                    mapList.add(hashMap);
                }
            }

        } else {
            mapList = ddsDDaypDao.getsw_month(start, end, month, stationName);

        }
        return addDefaultValueOneMonth(mapList,stationName,"P");
    }



    /*
     * @param mapList 选取1980年1月至1990年5月，逐月的降水和径流数据
     * @param C  模型参数：C= 0.87，
     * @param S0 S0=300（t=0时刻的S值）
     * @param SC SC=800。
     * @param EP 对于EPt的取值，根据月份来确定
     * @param F  沙子岭站控制面积F=1225km2
     * @param days 这个月的天数
     * @param Pi 预测的降雨量
     * @return  水文模型（月尺度）计算公式(直接返回m3/s)
     */
    public double runoffModelMonth_sw(List<Map> mapList, double C, double S0, double SC, List<Double> EP, double F, double Pi, int days) {
        List<Double> Et = new ArrayList<>();
        double Q = 0.0d;
        double S = 0.0d;
        double V = 0.0d;
        double E = 0.0d;
        for (int i = 0; i < mapList.size(); i++) {
            double P = Double.parseDouble(mapList.get(i).get("U") == null ? "0" : mapList.get(i).get("U").toString());
            String datei = mapList.get(i).get("MONTH").toString();
            int j = Integer.parseInt(datei.split("-")[1]) - 1;
            E = C * EP.get(j) * Math.tanh(P / EP.get(j));
            //当t=0时，Q1=(S0+P1-E1) ×tanh[(S0+P1-E1)/SC]
            if (i == 0) {
                Q = (S0 + P - E) * Math.tanh((S0 + P - E) / SC);
                //S1=S0+P1-E1-Q1
                S = S0 + P - E - Q;
            } else {
                Q = (S + P - E) * Math.tanh((S + P - E) / SC);
                S = S + P - E - Q;
            }
        }

        Q = (S + Pi - E) * Math.tanh((S + Pi - E) / SC);
        V = Q * F * 1000 / 24 / 60 / 60 / days;
        return V;
    }

    //选取1980年1月至1990年5月，逐月的降水和径流数据
    public List<Map> getPMonth(String endTime, String station) {
        String startTime = "1980-01";
        List<Map> mapList = new ArrayList<>();
        if (!"廖家湾".equals(station)) {
            mapList = ddsDDaypDao.getsw_monthAll(startTime, endTime, station);
        } else if ("廖家湾".equals(station)) {
            mapList = ddsDDaypDao.getsw_monthAllLJW(startTime, endTime);
        }
        return addDefaultValue(mapList,station,"P",0);
    }


    /****************************水文模型 旬尺度******************/
    public List<Map> getForcastXun_sw(String stationName, Date date) throws Exception {
        Map<String, List<String>> xunP1List = getXunP1List_sw(stationName, date);
        List<String> p1List = xunP1List.get("p1List");
        List<String> xunList = xunP1List.get("xunList");
        List<Double> p2List = getXunP2List(stationName, date);
        List<Double> p4List = getXunP4List(stationName, date);

        List list = new ArrayList();
        for (int i = 0; i < xunList.size(); i++) {
            Map tempMap = new HashMap();
            tempMap.put("month", xunList.get(i));
            double p1 = Double.parseDouble(p1List.get(i));
            tempMap.put("p1", division(p1) + "");
            double p2 = p2List.get(i);
            tempMap.put("p2", division(p2) + "");
            double p3 = p1 - p2;
            tempMap.put("p3", division(p3) + "");
            double p4 = p4List.get(i);
            double p5 = 0.0d;
            if (p4 != 0) {
                p5 = division((p1 - p4) / p4 * 100d);
            }
            tempMap.put("p4", division(p4) + "");

            tempMap.put("p5", p5 + "");
            list.add(tempMap);
            tempMap.put("p6", getP6(p5));
        }
        return list;
    }

    public List<Double> getXunP2List(String stationName, Date date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int year = Integer.parseInt(sdf.format(date).split("-")[0]);
        List<String> nextXunList = getNextXunList(getStartTime(date));
        List<Double> p2List = new ArrayList<>();
        if (!stationName.equals("廖坊")) {
            if (!stationName.equals("洪门")) {
                for (int i = 0; i < nextXunList.size(); i++) {
                    List<String> xunTime = getXunTime((year - 1) + "年" + nextXunList.get(i));
                    BigDecimal q = ddsDDaypDao.getOneXunQ(xunTime.get(0), xunTime.get(1), stationName);
                    double p2 = 0.0d;
                    if ("茅洲".equals(stationName)) {
                        p2 = q == null ? 0d : q.doubleValue() * 9.1616d;
                    }else {
                        p2 = q == null ? addDeafultOneXunQ(nextXunList.get(i), stationName) : q.doubleValue();
                    }
                    p2List.add(p2);
                }
            } else {//洪门
                for (int i = 0; i < nextXunList.size(); i++) {
                    List<Map<String, Double>> HMP2List = getMapHMP2XunList(year - 1);
                    double p2 = 0;
                    for (Map<String, Double> map : HMP2List) {
                        if (map.get(nextXunList.get(i)) != null) {
                            p2 = map.get(nextXunList.get(i));
                        }
                    }
                    p2List.add(p2);
                }
            }
        } else {//廖坊
            for (int i = 0; i < nextXunList.size(); i++) {
                List<String> xunTime = getXunTime((year - 1) + "年" + nextXunList.get(i));
                BigDecimal q1 = ddsDDaypDao.getOneXunQ(xunTime.get(0), xunTime.get(1), "南丰");
                double p21 = q1 == null ? 0d : q1.doubleValue();
                List<Map<String, Double>> HMP2List = getMapHMP2XunList(year - 1);
                double p22 = 0;
                for (Map<String, Double> map : HMP2List) {
                    if (map.get(nextXunList.get(i)) != null) {
                        p22 = map.get(nextXunList.get(i));
                    }
                }
                p2List.add((p21 + p22) * 1.4935);
            }

        }
        return p2List;
    }

    public List<Double> getXunP4List(String stationName, Date date) throws Exception {
        List<String> nextXunList = getNextXunList(getStartTime(date));
        double p4 = 0.0d;
        List<Double> p4List = new ArrayList<>();
        for (int i = 0; i < nextXunList.size(); i++) {
            if ("洪门".equals(stationName)) {
                List<Map<String, Double>> maplist = getMapHMP4XunList();
                for (Map<String, Double> map : maplist) {
                    if (map.get(nextXunList.get(i)) != null) {
                        p4 = map.get(nextXunList.get(i));
                    }
                }
            } else if ("廖坊".equals(stationName)) {
                List<Map<String, Double>> maplist = getMapLFP4XunList();
                for (Map<String, Double> map : maplist) {
                    if (map.get(nextXunList.get(i)) != null) {
                        p4 = map.get(nextXunList.get(i));
                    }
                }
            } else {

                List<String> xunTimeAll = getXunTimeAll(nextXunList.get(i));
                BigDecimal q = ddsDDaypDao.getAllXunQ(xunTimeAll.get(0), xunTimeAll.get(1), stationName);
                if ("茅洲".equals(stationName)) {
                    p4 = q == null ? 0d : q.doubleValue() * 9.1616d;
                } else {
                    p4 = q == null ? addDeafultOneXunQ(nextXunList.get(i),stationName) : q.doubleValue();
                }
            }
            p4List.add(p4);
        }
        return p4List;
    }

    private String getStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        String startTime = null;
        if (dayOfMonth <= 10) {
            if (month > 1) {
                startTime = formatStr(year + "-" + (month - 1) + "-" + days(year, month - 1));
            } else {
                startTime = formatStr((year - 1) + "-12-31");
            }
        } else if (dayOfMonth <= 20) {
            startTime = formatStr(year + "-" + month + "-10");
        } else {
            startTime = formatStr(year + "-" + month + "-20");
        }
        return startTime;

    }

    public Map<String, List<String>> getXunP1List_sw(String stationName, Date date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);
        int year = Integer.parseInt(sdf.format(date).split("-")[0]);
        double q_year = getRunoffYear_sw(stationName, year);//年径流预报数据
        Map<String, List<String>> next3More = getNext3More(date, q_year, stationName);
        List<String> pList = next3More.get("pList");
        List<String> xunList = next3More.get("xunList");
        pList.remove(0);//移除前三个
        pList.remove(0);
        pList.remove(0);
        Map map = new HashMap();
        if ("沙子岭".equals(stationName) || "南丰".equals(stationName) || "廖家湾".equals(stationName) || "娄家村".equals(stationName)) {
            List<Double> next3XunQ = getNext3XunQ(stationName, dateStr);
            pList.add(0, next3XunQ.get(0).toString());
            pList.add(1, next3XunQ.get(1).toString());
            pList.add(2, next3XunQ.get(2).toString());
            map.put("p1List", pList);
            map.put("xunList", xunList);
        } else if ("廖坊".equals(stationName)) {
            List<Double> Q1 = getNext3XunQ("南丰", dateStr);
            List<Double> Q2 = getNext3XunQ("洪门", dateStr);
            pList.add(0, (1.493 * (Q1.get(0) + Q2.get(0))) + "");
            pList.add(1, (1.493 * (Q1.get(1) + Q2.get(1))) + "");
            pList.add(2, (1.493 * (Q1.get(2) + Q2.get(2))) + "");
            map.put("p1List", pList);
            map.put("xunList", xunList);
        } else if ("李家渡".equals(stationName)) {
            List<Double> Q1 = getNext3XunQ("廖家湾", dateStr);
            List<Double> Q2 = getNext3XunQ("娄家村", dateStr);
            pList.add(0, (0.680095305 * Q1.get(0) + 1.489469784 * Q2.get(0)) + "");
            pList.add(1, (0.680095305 * Q1.get(1) + 1.489469784 * Q2.get(1)) + "");
            pList.add(2, (0.680095305 * Q1.get(2) + 1.489469784 * Q2.get(2)) + "");
            map.put("p1List", pList);
            map.put("xunList", xunList);
        } else if ("茅洲".equals(stationName)) {
            List<Double> next3XunQ = getNext3XunQ(stationName, dateStr);
            pList.add(0, (9.1616 * next3XunQ.get(0)) + "");
            pList.add(1, (9.1616 * next3XunQ.get(1)) + "");
            pList.add(2, (9.1616 * next3XunQ.get(2)) + "");
            map.put("p1List", pList);
            map.put("xunList", xunList);

        }

        return map;
    }


    public List<Double> getNext3XunQ(String stationName, String date) {

        Map<String, Double> eMap = new HashMap();
        eMap.put("1月上", 11.9d);
        eMap.put("1月中", 10.9d);
        eMap.put("1月下", 13d);
        eMap.put("2月上", 13.4d);
        eMap.put("2月中", 15.1d);
        eMap.put("2月下", 12.7d);
        eMap.put("3月上", 19d);
        eMap.put("3月中", 17.7d);
        eMap.put("3月下", 21.6d);
        eMap.put("4月上", 24.6d);
        eMap.put("4月中", 28.2d);
        eMap.put("4月下", 31.9d);
        eMap.put("5月上", 34.2d);
        eMap.put("5月中", 36.1d);
        eMap.put("5月下", 39.6d);
        eMap.put("6月上", 38.9d);
        eMap.put("6月中", 36.9d);
        eMap.put("6月下", 45.8d);
        eMap.put("7月上", 52.8d);
        eMap.put("7月中", 56.6d);
        eMap.put("7月下", 60.3d);
        eMap.put("8月上", 51d);
        eMap.put("8月中", 46.1d);
        eMap.put("8月下", 47.8d);
        eMap.put("9月上", 39.4d);
        eMap.put("9月中", 35.4d);
        eMap.put("9月下", 32.3d);
        eMap.put("10月上", 29.5d);
        eMap.put("10月中", 27.1d);
        eMap.put("10月下", 25.4d);
        eMap.put("11月上", 21.5d);
        eMap.put("11月中", 17.1d);
        eMap.put("11月下", 15.5d);
        eMap.put("12月上", 14.7d);
        eMap.put("12月中", 12.9d);
        eMap.put("12月下", 14.1d);

        List<String> xunList = getFormatXunList2(date, 36);
        List<Double> plist = new ArrayList<>();
        List<Double> elist = new ArrayList<>();
        for (int i = 0; i < xunList.size(); i++) {
            List<String> xunTime = getXunTime(xunList.get(i));
            BigDecimal u = ddsDDaypDao.getOneXunU(xunTime.get(0), xunTime.get(1), stationName);

            String xunStr = xunList.get(i).split("年")[1];
            double u0 = u == null ? addDeafultOneXunU(xunStr,stationName) : u.doubleValue();
            plist.add(u0);
            elist.add(eMap.get(xunStr));
        }
        List<Double> uLastXun = getULastXun(stationName, date);
        double u = uLastXun.get(0);
        double u1 = uLastXun.get(1);
        double u2 = uLastXun.get(2);
        String xun = getFromatXun2(date);
        String xuns = xun.split("年")[1];
        plist.add(u);
        elist.add(eMap.get(xuns));
        Map map = new HashMap();
        map.put("P", plist);
        map.put("E", elist);
        double xunReportQ = getXunReportQ(stationName, plist.size(), map);


        //resultMap1已经得到了 ，为了少查两次数据库，就手写map2 和map 3
        //移除第一个元素，增加新元素
        plist.remove(0);
        elist.remove(0);
        plist.add(u1);
        String xun1 = getFromatXun2(plusDaysStr(date, 1));
        String xuns1 = xun1.split("年")[1];
        elist.add(eMap.get(xuns1));
        double xunReportQ1 = getXunReportQ(stationName, plist.size(), map);

        plist.remove(0);
        elist.remove(0);
        plist.add(u2);
        String xun2 = getFromatXun2(plusDaysStr(date, 2));
        String xuns2 = xun2.split("年")[1];
        elist.add(eMap.get(xuns2));
        double xunReportQ2 = getXunReportQ(stationName, plist.size(), map);

        List<Double> list = new ArrayList<>();
        list.add(xunReportQ);
        list.add(xunReportQ1);
        list.add(xunReportQ2);
        return list;
    }

    public String plusDaysStr(String date, int xuns) {
        try {
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdFormat.parse(date));
            calendar.add(Calendar.DATE, xuns * 10);
            if (calendar.get(Calendar.DAY_OF_MONTH) == 31) {
                calendar.add(Calendar.DATE, 1);
            }
            String format1 = sdFormat.format(calendar.getTime());
            return format1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public double getXunReportQ(String name, int time, Map map) {
        Map paramMap = new HashMap();
        double K = 0.0d;
        double C = 0.0d;
        double IMP = 0.0d;
        double WUM = 0.0d;
        double WLM = 0.0d;
        double WDM = 0.0d;
        double B = 0.0d;
        double SM = 0.0d;
        double EX = 0.0d;
        double KG = 0.0d;
        double KSS = 0.0d;
        double KKG = 0.0d;
        double KKSS = 0.0d;
        double[] UH = new double[3];
        double F = 0.0d;

        if ("沙子岭".equals(name)) {
            K = 0.7d;
            C = 0.1d;
            IMP = 0.03d;
            WUM = 15d;
            WLM = 60d;
            WDM = 90d;
            B = 0.4;
            SM = 75d;
            EX = 1.2;
            KG = 0.36;
            KSS = 0.34;
            KKG = 0.995;
            KKSS = 0.9;
            UH[0] = 0.3;
            UH[1] = 0.6;
            UH[2] = 0.1;
            F = 1225;
        } else if ("南丰".equals(name)) {
            K = 0.7;
            C = 0.2;
            IMP = 0.01;
            WUM = 20d;
            WLM = 85d;
            WDM = 90d;
            B = 0.4;
            SM = 70d;
            EX = 1;
            KG = 0.32;
            KSS = 0.28;
            KKG = 0.95;
            KKSS = 0.68;
            UH[0] = 0.3;
            UH[1] = 0.6;
            UH[2] = 0.1;
            F = 2909d;
        } else if ("廖家湾".equals(name)) {
            K = 0.8;
            C = 0.8;
            IMP = 0.01;
            WUM = 50d;
            WLM = 90d;
            WDM = 100d;
            B = 0.4;
            SM = 70d;
            EX = 1d;
            KG = 0.32;
            KSS = 0.38;
            KKG = 0.95;
            KKSS = 0.68;
            UH[0] = 0.3;
            UH[1] = 0.6;
            UH[2] = 0.1;
            F = 8723d;

        } else if ("娄家村".equals(name)) {
            K = 0.8;
            C = 0.8;
            IMP = 0.01;
            WUM = 50d;
            WLM = 90d;
            WDM = 100d;
            B = 0.4;
            SM = 70d;
            EX = 1d;
            KG = 0.32;
            KSS = 0.38;
            KKG = 0.95;
            KKSS = 0.68;
            UH[0] = 0.3;
            UH[1] = 0.6;
            UH[2] = 0.1;
            F = 4969d;
        } else if ("茅洲".equals(name)) {
            K = 0.7;
            C = 0.2;
            IMP = 0.01;
            WUM = 40;
            WLM = 90;
            WDM = 100;
            B = 0.4;
            SM = 70;
            EX = 1;
            KG = 0.32;
            KSS = 0.38;
            KKG = 0.9;
            KKSS = 0.68;
            UH[0] = 0.3;
            UH[1] = 0.6;
            UH[2] = 0.1;
            F = 331;
        } else {
            return 0.0d;
        }

        paramMap.put("K", K);// 蒸发皿系数
        paramMap.put("C", C);// 深层蒸散发系数
        paramMap.put("IMP", IMP);// 不透水面积比重
        paramMap.put("WUM", WUM);// 上层张力水容量
        paramMap.put("WLM", WLM);// 下层张力水容量
        paramMap.put("WDM", WDM);// 深层张力水容量
        paramMap.put("B", B);// 蓄水容量曲线指数
        paramMap.put("SM", SM);// 流域平均自由水蓄水容量
        paramMap.put("EX", EX);// 自由水蓄水容量曲线指数
        paramMap.put("KG", KG);// 自由水中地下水出流系数
        paramMap.put("KSS", KSS);// 自由水中壤中流出流系数
        paramMap.put("KKG", KKG);// 地下水消退系数
        paramMap.put("KKSS", KKSS);// 壤中流消退系数
        paramMap.put("UH", UH);// 无因次单位线常数
        paramMap.put("F", F);

        List<Double> xaj = new XAJsimulation().getXAJsimulation(time, map, paramMap);
        return xaj.get(xaj.size() - 1);
    }


    //计算出预报旬的降雨量
    public List<Double> getULastXun(String stationName, String date) {
        List<String> xunList5 = getFormatXunList2(date, 5);
        double[] u = new double[5];

        for (int i = 0; i < xunList5.size(); i++) {
            List<String> xunTime = getXunTime(xunList5.get(i));
            String xunStr = xunList5.get(i).split("年")[1];
            BigDecimal u0 = ddsDDaypDao.getOneXunU(xunTime.get(0), xunTime.get(1), stationName);
            u[i] = u0 == null ? addDeafultOneXunU(xunStr,stationName) : u0.doubleValue();
        }

        RegressionLine line = new RegressionLine();
        for (int i = 0; i < u.length; i++) {
            line.addDataPoint(new DataPoint(i + 1, u[i]));
        }
        //①选取不同的旬，线性拟合方程是不同；②如果遇到预测降水量（x6）小于0的情况，则认为x6为前两年降水量的平均值，即x6=(x5+x4)*0.5。
        double u_next1 = line.getValue(6);
        if (u_next1 < 0) {
            u_next1 = (u[3] + u[4]) / 2;
        }
        double u_next2 = line.getValue(7);
        if (u_next2 < 0) {
            u_next2 = (u_next1 + u[4]) / 2;
        }
        double u_next3 = line.getValue(8);
        if (u_next3 < 0) {
            u_next3 = (u_next2 + u_next1) / 2;
        }

        List<Double> list = new ArrayList();
        list.add(u_next1);
        list.add(u_next2);
        list.add(u_next3);
        return list;
    }

    private List<String> getXunTime(String xun) {
        List<String> list = new ArrayList<>();
        String year = xun.split("年")[0];
        int month = Integer.parseInt(xun.split("年")[1].split("月")[0]);
        String xun1 = xun.split("年")[1].split("月")[1];
        String start = "";
        String end = "";
        if ("上".equals(xun1)) {
            start = "01";
            end = "11";
            list.add(formatStr(year + "-" + month + "-" + start));
            list.add(formatStr(year + "-" + month + "-" + end));
        } else if ("中".equals(xun1)) {
            start = "11";
            end = "21";
            list.add(formatStr(year + "-" + month + "-" + start));
            list.add(formatStr(year + "-" + month + "-" + end));
        } else if ("下".equals(xun1)) {
            start = "21";
            end = "01";
            list.add(formatStr(year + "-" + month + "-" + start));
            list.add(formatStr(year + "-" + (month + 1) + "-" + end));
        }
        return list;
    }

    private List<String> getXunTimeAll(String xun) {
        List<String> list = new ArrayList<>();
        int month = Integer.parseInt(xun.split("月")[0]);
        String xun1 = xun.split("月")[1];
        String start = "";
        String end = "";
        if ("上".equals(xun1)) {
            start = "01";
            end = "11";
            list.add(formatStr(month + "-" + start));
            list.add(formatStr(month + "-" + end));

        } else if ("中".equals(xun1)) {
            start = "11";
            end = "21";
            list.add(formatStr(month + "-" + start));
            list.add(formatStr(month + "-" + end));

        } else if ("下".equals(xun1)) {
            if (month != 12) {
                start = "21";
                end = "01";
                list.add(formatStr(month + "-" + start));
                list.add(formatStr((month + 1) + "-" + end));
            } else {
                list.add("12-01");
                list.add("12-31");
            }
        }
        return list;
    }


    public String getFromatXun2(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        String xun = null;
        if (day >= 1 && day < 10) {
            xun = year + "年" + month + "月上";
        } else if (day >= 10 && day < 20) {
            xun = year + "年" + month + "月中";
        } else {
            xun = year + "年" + (month + 1) + "月上";
        }
        return xun;
    }


    public List<String> getFormatXunList2(String date, int num) {
        String startXun = getFromatXun2(date);
        List<String> xunList = getXunLists();
        List<String> ftXunList = new ArrayList<>();
        String[] startX = startXun.split("年");
        int year = Integer.parseInt(startX[0]);//1988
        String mxun = startX[1];//1月下
        int m = 0;
        for (int j = 0; j < xunList.size(); j++) {
            if (xunList.get(j).equals(mxun)) {
                m = j;
            }
        }
        if (m > num) {
            for (int i = 0; i < xunList.size(); i++) {
                if (i >= m - num && i < m) {
                    ftXunList.add(year + "年" + xunList.get(i));
                }
            }
        }

        if (m < num) {

            for (int i = 0; i < xunList.size(); i++) {
                if (i >= xunList.size() - (num - m)) {
                    ftXunList.add((year - 1) + "年" + xunList.get(i));
                }
            }

            for (int j = 0; j < xunList.size(); j++) {
                if (j < m) {
                    ftXunList.add(year + "年" + xunList.get(j));
                }
            }
        }


        return ftXunList;
    }


    public List<Map<String,String>> getRunInfoLast(String stationName, String proCd) {
        List<Map<String,String>> resultList = new ArrayList();
        List<Map> mapList = ddsDDaypDao.getRunInfoLast(stationName, proCd);
        if (mapList != null) {
            boolean flag = false;
            for (Map map : mapList) {
                Date date = (java.sql.Timestamp) map.get("TIME");
                SimpleDateFormat sdf = new SimpleDateFormat("dd");
                int day = Integer.parseInt(sdf.format(date));
                if (day != 1) {
                    flag = true;
                }
            }
            if (flag) {
                //xun
                for (Map map : mapList) {
                    Date date = (java.sql.Timestamp) map.get("TIME");
                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
                    String strs = sdf.format(date);
                    int month = Integer.parseInt(strs.split("-")[0]);
                    int day = Integer.parseInt(strs.split("-")[1]);
                    Map resultMap = new HashMap();
                    String p0 = "";
                    if (day == 1) {
                        p0 = month + "月上";
                    } else if (day == 10) {
                        p0 = month + "月中";
                    } else {
                        p0 = month + "月下";
                    }
                    Integer n = Integer.parseInt(map.get("CONCL").toString());
                    String p6 = "";
                    if (n == null) {
                        p6 = "";
                    } else if (n == 1) {
                        p6 = "特丰";
                    } else if (n == 2) {
                        p6 = "偏丰";
                    } else if (n == 3) {
                        p6 = "平水";
                    } else if (n == 4) {
                        p6 = "偏枯";
                    } else if (n == 5) {
                        p6 = "特枯";
                    }
                    resultMap.put("month", p0);
                    resultMap.put("p1", map.get("P1").toString());
                    resultMap.put("p2", map.get("P2").toString());
                    resultMap.put("p3", map.get("P3").toString());
                    resultMap.put("p4", map.get("P4").toString());
                    resultMap.put("p5", map.get("P5").toString());
                    resultMap.put("p6", p6);
                    resultList.add(resultMap);

                }
            } else {
                //year,month
                for (Map map : mapList) {
                    Date date = (java.sql.Timestamp) map.get("TIME");
                    SimpleDateFormat sdf = new SimpleDateFormat("MM");
                    int month = Integer.parseInt(sdf.format(date));
                    Map resultMap = new HashMap();
                    Integer n = Integer.parseInt(map.get("CONCL").toString());
                    String p6 = "";
                    if (n == null) {
                        p6 = "";
                    } else if (n == 1) {
                        p6 = "特丰";
                    } else if (n == 2) {
                        p6 = "偏丰";
                    } else if (n == 3) {
                        p6 = "平水";
                    } else if (n == 4) {
                        p6 = "偏枯";
                    } else if (n == 5) {
                        p6 = "特枯";
                    }
                    resultMap.put("month", month + "月");
                    resultMap.put("p1", map.get("P1").toString());
                    resultMap.put("p2", map.get("P2").toString());
                    resultMap.put("p3", map.get("P3").toString());
                    resultMap.put("p4", map.get("P4").toString());
                    resultMap.put("p5", map.get("P5").toString());
                    resultMap.put("p6", p6);
                    resultList.add(resultMap);
                }

            }
        }

        return formatList(resultList);
    }

    private List<Map<String,String>> formatList(List<Map<String,String>> list){
        Collections.sort(list, new Comparator<Map<String, String>>(){
            public int compare(Map<String, String> o1, Map<String, String> o2) {
//                String name1 =(String)o1.get("id");//name1是从你list里面拿出来的一个
//                String name2= (String)o2.get("id"); //name1是从你list里面拿出来的第二个name
                int i1 = Integer.parseInt(o1.get("month").toString().split("月")[0]);
                int i2 = Integer.parseInt(o2.get("month").toString().split("月")[0]);
                if(i1<i2){
                    return -1;
                }else if(i1>i2){
                    return 1;
                }else{
                    String str1 = (o1.get("month").toString().split("月")[1]);
                    String str2 = (o1.get("month").toString().split("月")[1]);
                    int j1 = getXunNum(str1);
                    int j2 = getXunNum(str2);
                    if(j1<j2){
                        return -1;
                    }else{
                        return 1;
                    }
                }
            }
        });
         return list;
    }

    private int getXunNum(String str){
        if(str.contains("上")){
            return 1;
        }else if(str.contains("中")){
            return 2;
        }else if (str.contains("下")){
            return 3;
        }else{
            return 0;
        }
    }


    private List<Map> readExcelValue(Workbook wb) {
        List<Map> dataLst = new ArrayList<Map>();
        /** 得到第一个shell */
        Sheet sheet = wb.getSheetAt(0);
        /** 得到Excel的行数 */
        int totalRows = sheet.getPhysicalNumberOfRows();
        /** 得到Excel的列数 */
        int totalCells = 0;
        if (totalRows >= 1 && sheet.getRow(0) != null) {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        /** 循环Excel的行 */
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            /** 循环Excel的列 */
            boolean flag = true;
            Map map = new HashMap();
            for (int c = 0; c < totalCells; c++) {
                flag = true;
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if (c == 0) {
                        if (cell != null) {
                            String station = cell.getStringCellValue();
                            if (station.contains("以上")) {
                                station = station.split("以上")[0];
                            } else if (station.contains("南城")) {
                                station = "南丰";
                            }
                            map.put("station", station);
                        } else {
                            flag = false;
                        }
                    } else if (c == 1) {
                        if (cell != null) {
                            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                                map.put("p1", cell.getNumericCellValue());
                            } else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                                map.put("time", cell.getStringCellValue());
                            }
                        } else {
                            flag = false;
                        }
                    } else if (c == 2) {
                        if (cell != null) {
                            map.put("p1", cell.getNumericCellValue());
                        }
                    }
                } else {
                    flag = false;
                }
            }
            if (flag) {
                dataLst.add(map);
            }
        }
        return dataLst;
    }


    public List<Map> getExcelInfo(MultipartFile Mfile) {

//        //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
//        CommonsMultipartFile cf= (CommonsMultipartFile)Mfile; //获取本地存储路径
//        File file = new  File("D:\\fileupload");
//        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
//        if (!file.exists()) file.mkdirs();
//        //新建一个文件
//        File file1 = new File("D:\\fileupload\\" + new Date().getTime() + ".xls");
//        //将上传的文件写入新建的文件中
        //初始化客户信息的集合
        List<Map> customerList = new ArrayList<Map>();
        //初始化输入流
        InputStream is = null;
        Workbook wb = null;

        try {
            is = Mfile.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //当excel是2003时
            wb = new HSSFWorkbook(is);
            //当excel是2007时
            if (wb == null) {
                wb = new XSSFWorkbook(is);
            }
            //读取Excel里面客户的信息
            customerList = readExcelValue(wb);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return customerList;
    }


    /*
    public List<Map> getUploadExcelInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Map> customerList = (List<Map>) session.getAttribute("excelInfo");
//        //初始化输入流
//        FileInputStream is = null;
//    try{
//        Workbook wb = null;
//        File path=new File("D:\\fileupload\\");
//        //列出该目录下所有文件和文件夹
//        File[] files = path.listFiles();
//        //按照文件最后修改日期倒序排序
//        Arrays.sort(files, new Comparator<File>() {
//            @Override
//            public int compare(File file1, File file2) {
//                return (int)(file2.lastModified()-file1.lastModified());
//            }
//        });
//
//            //根据新建的文件实例化输入流
//            is = new FileInputStream(files[0]);
//            //根据excel里面的内容读取客户信息
//            //当excel是2003时
//            wb = new HSSFWorkbook(is);
//            //当excel是2007时
//            //wb = new XSSFWorkbook(is);
//            //读取Excel里面客户的信息
//            customerList=readExcelValue(wb);
//            is.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        } finally{
//            if(is !=null)
//            {
//                try{
//                    is.close();
//                }catch(IOException e){
//                    is = null;
//                    e.printStackTrace();
//                }
//            }
//        }
        return customerList;
    }


    private Integer getP1Type(HttpServletRequest request) {
        List<Map> mapList = getUploadExcelInfo(request);
        if (mapList != null) {
            for (Map map : mapList) {
                String time = map.get("time").toString();
                if (time.indexOf("月") == -1) {
                    return 0;//年
                } else if (time.indexOf("上") == -1 && time.indexOf("中") == -1 && time.indexOf("下") == -1) {
                    return 1;//月
                } else {
                    return 2;//旬
                }
            }

        }
        return null;
    }
*/

    private Map getYearRunoffQandU(String name, int year) {
        Map<String, BigDecimal> map = new HashMap<>();
        if ("沙子岭".equals(name)) {
            map = ddsDDaypDao.getYearBySTCD("62405200", "62423400", year);
            //u降水 。Q径流
            if(map == null){map = new HashMap<>();};
            if (map == null || map.get("Q") == null || map.get("Q").intValue() == 0.0d) {
                map.put("Q", new BigDecimal(42.1));
            }
            if (map == null || map.get("U") == null || map.get("U").intValue() == 0.0d) {
                map.put("U", new BigDecimal(1787));
            }
        } else if ("娄家村".equals(name)) {
            map = ddsDDaypDao.getYearBySTCD("62406600", "62436700", year);
            if(map == null){map = new HashMap<>();};
            //u降水 。Q径流
            if (map == null || map.get("Q") == null || map.get("Q").intValue() == 0.0d) {
                map.put("Q", new BigDecimal(166.1));
            }
            if (map == null || map.get("U") == null || map.get("U").intValue() == 0.0d) {
                map.put("U", new BigDecimal(1766));
            }

        } else if ("南丰".equals(name)) {
            map = ddsDDaypDao.getYearBySTCD("62405400", "62424900", year);
            if(map == null){map = new HashMap<>();};
            //u降水 。Q径流
            if (map == null || map.get("Q") == null || map.get("Q").doubleValue() == 0.0d) {
                map.put("Q", new BigDecimal(90.4));
            }
            if (map == null || map.get("U") == null || map.get("U").doubleValue() == 0.0d) {
                map.put("U", new BigDecimal(1709));
            }

        } else if ("洪门".equals(name)) {
            map = ddsDDaypDao.getYearBySTCD("62403200", "62426900", year);
        } else if ("廖家湾".equals(name)) {
            Map<String, BigDecimal> map1 = ddsDDaypDao.getYearBySTCD("62401800", null, year);
            BigDecimal Q = (map1 == null || (map1.get("Q") == null) || (map1.get("Q").doubleValue() == 0.0d)) ? new BigDecimal(287.2) : map1.get("Q");
            Map<String, BigDecimal> map2 = ddsDDaypDao.getYearBySTCD("62405200", "62423400", year);
            if (map2 == null || map2.get("U") == null || map2.get("U").intValue() == 0.0d) {
                map2.put("U", new BigDecimal(1787));
            }
            Map<String, BigDecimal> map3 = ddsDDaypDao.getYearBySTCD("62405400", "62424900", year);
            if (map3 == null || map3.get("U") == null || map3.get("U").intValue() == 0.0d) {
                map3.put("U", new BigDecimal(1709));
            }

            Map<String, BigDecimal> map4 = ddsDDaypDao.getYearBySTCD("62403200", "62426900", year);

            BigDecimal U2 = map2 == null || map2.get("U") == null ? new BigDecimal(0) : map2.get("U");
            BigDecimal U3 = map3 == null || map3.get("U") == null ? new BigDecimal(0) : map3.get("U");
            BigDecimal U4 = map4 == null || map4.get("U") == null ? new BigDecimal(0) : map4.get("U");
            double U0 = 0.0d;
            if (map4 == null || map3 == null || map2 == null) {
                U0 = (U2.doubleValue() + U3.doubleValue() + U4.doubleValue()) / 2;
            } else {
                U0 = (U2.doubleValue() + U3.doubleValue() + U4.doubleValue()) / 3;
            }
            BigDecimal U = new BigDecimal(U0);
            map.put("Q", Q);
            map.put("U", U);
        } else if ("李家渡".equals(name)) {
            map = ddsDDaypDao.getYearBySTCD("62402400", null, year);
        }
        return map;
    }


    private List<Double> getHMP4YearList() {
        List<Double> list = new ArrayList<>();
        list.add(32.3);
        list.add(48.2);
        list.add(82.3);
        list.add(126.9);
        list.add(154.1);
        list.add(189.3);
        list.add(97d);
        list.add(59.8);
        list.add(44.7);
        list.add(37.4);
        list.add(33.5);
        list.add(29.4);
        list.add(77.9);
        return list;
    }

    private List<Double> getHMP2YearList(int year) {
        double p = 0.0d;
        if (getYearRunoffQandU("南丰", year) != null && getYearRunoffQandU("南丰", year).get("U") != null) {
            p = Double.parseDouble(getYearRunoffQandU("南丰", year).get("U").toString());
        }
        double p0 = p * 0.014 * 3.4049 * 365;
        List<Double> list = new ArrayList<>();
        list.add(p0 * 0.031 / 31);
        list.add(p0 * 0.054 / 28);
        list.add(p0 * 0.101 / 31);
        list.add(p0 * 0.171 / 30);
        list.add(p0 * 0.168 / 31);
        list.add(p0 * 0.18 / 30);
        list.add(p0 * 0.084 / 31);
        list.add(p0 * 0.049 / 31);
        list.add(p0 * 0.049 / 30);
        list.add(p0 * 0.042 / 31);
        list.add(p0 * 0.041 / 30);
        list.add(p0 * 0.03 / 31);
        list.add(p0 / 365);
        return list;
    }


    private List<Double> getLFP4YearList() {
        List<Double> list = new ArrayList<>();
        list.add(65.2);
        list.add(115.3);
        list.add(176.6);
        list.add(327.6);
        list.add(256.8);
        list.add(538d);
        list.add(199.8);
        list.add(121.3);
        list.add(121.7);
        list.add(96.4);
        list.add(111.1);
        list.add(92.6);
        list.add(185.2);
        return list;
    }

    private List<Map> getMapHMP2YearList(int year) {
        List<Map> list = new ArrayList<>();
        List<Double> p2List = getHMP2YearList(year);
        for (int i = 0; i < p2List.size() - 1; i++) {
            Map map = new HashMap();
            map.put("Q", p2List.get(i));
            list.add(map);
        }
        return list;
    }

    private List<Map> getMapLFP4YearList() {
        List<Map> list = new ArrayList<>();
        List<Double> p4List = getLFP4YearList();
        for (int i = 0; i < p4List.size() - 1; i++) {
            Map map = new HashMap();
            map.put("Q", p4List.get(i));
            list.add(map);
        }
        return list;
    }

    private List<Map> getMapHMP4YearList() {
        List<Map> list = new ArrayList<>();
        List<Double> p4List = getHMP4YearList();
        for (int i = 0; i < p4List.size() - 1; i++) {
            Map map = new HashMap();
            map.put("Q", p4List.get(i));
            list.add(map);
        }
        return list;
    }

    private List<Map<String, Double>> getMapHMP2XunList(int year) {
        double p = 0.0d;
        if (getYearRunoffQandU("南丰", year) != null && getYearRunoffQandU("南丰", year).get("U") != null) {
            p = Double.parseDouble(getYearRunoffQandU("南丰", year).get("U").toString());
        }
        double p0 = p * 0.014 * 3.4049 * 365 / 10;
        List<Double> list = new ArrayList<>();
        list.add(0.011162 * p0);
        list.add(0.009885 * p0);
        list.add(0.009635 * p0);
        list.add(0.016279 * p0);
        list.add(0.017589 * p0);
        list.add(0.025466 * p0);
        list.add(0.028793 * p0);
        list.add(0.033228 * p0);
        list.add(0.036355 * p0);
        list.add(0.06278 * p0);
        list.add(0.055458 * p0);
        list.add(0.055016 * p0);
        list.add(0.058833 * p0);
        list.add(0.055832 * p0);
        list.add(0.050186 * p0);
        list.add(0.046174 * p0);
        list.add(0.081587 * p0);
        list.add(0.053758 * p0);
        list.add(0.04055 * p0);
        list.add(0.024605 * p0);
        list.add(0.017791 * p0);
        list.add(0.014993 * p0);
        list.add(0.016734 * p0);
        list.add(0.015967 * p0);
        list.add(0.017256 * p0);
        list.add(0.01531 * p0);
        list.add(0.016734 * p0);
        list.add(0.013052 * p0);
        list.add(0.013027 * p0);
        list.add(0.014859 * p0);
        list.add(0.014944 * p0);
        list.add(0.012166 * p0);
        list.add(0.014671 * p0);
        list.add(0.011267 * p0);
        list.add(0.009513 * p0);
        list.add(0.008548 * p0);

        List<String> xunLists = getXunLists();
        List<Map<String, Double>> p2List = new ArrayList<>();
        for (int i = 0; i < xunLists.size(); i++) {
            Map map = new HashMap();
            map.put(xunLists.get(i), list.get(i));
            p2List.add(map);
        }
        return p2List;
    }

    private List<Map<String, Double>> getMapHMP4XunList() {
        List<Double> list = new ArrayList<>();
        list.add(9.4);
        list.add(8.3);
        list.add(8.1);
        list.add(13.7);
        list.add(14.8);
        list.add(21.4);
        list.add(24.2);
        list.add(27.9);
        list.add(30.6);
        list.add(52.8);
        list.add(46.6);
        list.add(46.3);
        list.add(49.5);
        list.add(47.0);
        list.add(42.2);
        list.add(38.8);
        list.add(68.6);
        list.add(45.2);
        list.add(34.1);
        list.add(20.7);
        list.add(15.0);
        list.add(12.6);
        list.add(14.1);
        list.add(13.4);
        list.add(14.5);
        list.add(12.9);
        list.add(14.1);
        list.add(11.0);
        list.add(11.0);
        list.add(12.5);
        list.add(12.6);
        list.add(10.2);
        list.add(12.3);
        list.add(9.5);
        list.add(8.0);
        list.add(7.2);

        List<String> xunLists = getXunLists();
        List<Map<String, Double>> p4List = new ArrayList<>();
        for (int i = 0; i < xunLists.size(); i++) {
            Map map = new HashMap();
            map.put(xunLists.get(i), list.get(i));
            p4List.add(map);
        }
        return p4List;
    }

    private List<Map<String, Double>> getMapLFP4XunList() {

        List<Double> list = new ArrayList<>();
        list.add(71.2);
        list.add(63.0);
        list.add(61.4);
        list.add(94.9);
        list.add(102.5);
        list.add(148.5);
        list.add(155.1);
        list.add(178.9);
        list.add(195.8);
        list.add(356.1);
        list.add(314.6);
        list.add(312.1);
        list.add(274.9);
        list.add(260.9);
        list.add(234.5);
        list.add(410.6);
        list.add(725.4);
        list.add(478.0);
        list.add(293.0);
        list.add(177.8);
        list.add(128.6);
        list.add(114.4);
        list.add(127.7);
        list.add(121.8);
        list.add(127.8);
        list.add(113.4);
        list.add(123.9);
        list.add(92.2);
        list.add(92.0);
        list.add(105.0);
        list.add(119.2);
        list.add(97.1);
        list.add(117.0);
        list.add(106.7);
        list.add(90.1);
        list.add(81.0);

        List<String> xunLists = getXunLists();
        List<Map<String, Double>> p4List = new ArrayList<>();
        for (int i = 0; i < xunLists.size(); i++) {
            Map map = new HashMap();
            map.put(xunLists.get(i), list.get(i));
            p4List.add(map);
        }
        return p4List;

    }

    private List<Double> getLJDMonth() {
        List<Double> list = new ArrayList<>();
        list.add(42.8);
        list.add(71.4);
        list.add(146.2);
        list.add(191.7);
        list.add(200.4);
        list.add(285.3);
        list.add(121.8);
        list.add(61.3);
        list.add(47.6);
        list.add(32.2);
        list.add(55.0);
        list.add(49.3);
        list.add(1305.1);
        return list;
    }

    private List<Map<String, Double>> getMapLJDXun() {
        List<String> xunLists = getXunLists();
        List<Double> list = getLJDXun();
        List<Map<String, Double>> p4List = new ArrayList<>();
        for (int i = 0; i < xunLists.size(); i++) {
            Map map = new HashMap();
            map.put(xunLists.get(i), list.get(i));
            p4List.add(map);
        }
        return p4List;


    }

    private List<Double> getLJDXun() {
        List<Double> list = new ArrayList<>();
        list.add(35.2);
        list.add(43.5);
        list.add(49.6);
        list.add(54.2);
        list.add(77.5);
        list.add(82.5);
        list.add(121.7);
        list.add(130.6);
        list.add(186.5);
        list.add(184.0);
        list.add(199.4);
        list.add(191.7);
        list.add(212.5);
        list.add(214.3);
        list.add(174.4);
        list.add(205.1);
        list.add(334.7);
        list.add(316.3);
        list.add(199.4);
        list.add(104.7);
        list.add(61.3);
        list.add(58.5);
        list.add(71.3);
        list.add(54.1);
        list.add(75.1);
        list.add(33.7);
        list.add(34.2);
        list.add(29.5);
        list.add(28.4);
        list.add(38.8);
        list.add(52.0);
        list.add(53.2);
        list.add(59.9);
        list.add(55.3);
        list.add(49.0);
        list.add(43.6);
        return list;
    }

    public List<Map> getImportDataYear(String station, List<Map> jsonList, int year) {
        List<Map> dataMap = new ArrayList<>();
        for (Map map : jsonList) {
            if (map.get("station").toString().contains(station)) {
                double value = Double.parseDouble(map.get("p1").toString());
                List<Map> tempList = getForecast(station, year, value);
                for (int i = 0; i < tempList.size(); i++) {
                    Map<String, String> tempMap = new HashMap();
                    double p1 = division(Double.parseDouble(tempList.get(i).get("p1").toString()) + getLJDMonth().get(i));
                    double p2 = division(Double.parseDouble(tempList.get(i).get("p2").toString()) + getLJDMonth().get(i));
                    double p4 = division(Double.parseDouble(tempList.get(i).get("p4").toString()) + getLJDMonth().get(i));
                    double p3 = division(p1 - p2);
                    tempMap.put("month", tempList.get(i).get("month").toString());
                    tempMap.put("p1", p1 + "");
                    tempMap.put("p2", p2 + "");
                    tempMap.put("p3", p3 + "");
                    tempMap.put("p4", p4 + "");
                    double p5 = 0d;
                    if (p4 != 0) {
                        p5 = division((p1 - p4) / p4 * 100);
                    }
                    tempMap.put("p5", p5 + "");
                    tempMap.put("p6", getP6(p5));
                    dataMap.add(tempMap);
                }
            }
        }
        return dataMap;
    }


    public List<Map> getFormatImport(String station, List<Map> jsonList) {
        List<Map> dataMap = new ArrayList<>();
        for (Map map : jsonList) {
            if (map.get("station").toString().contains(station)) {
                if (map.get("p1") != null) {
                    Map temp = new HashMap();
                    temp.put("month", map.get("time"));
                    temp.put("p1", map.get("p1"));
                    dataMap.add(temp);
                }
            }
        }
        return dataMap;
    }

    private List<Map> addDefaultValueOneMonth(List<Map>mapList,String station,String P) {
        List<Map> list = new ArrayList<>();
        List<Map> mapListU = defaultValueU().get(station);
        for (int i = 0; i < mapList.size(); i++) {
            Map map = mapList.get(i);
            if (map.get(P) == null || Double.parseDouble(map.get(P).toString()) == 0d) {
                if (station.equals("沙子岭") || station.equals("南丰") || station.equals("娄家村")) {
                    for (Map map1 : mapListU) {
                        if (map1.get(parseStr(map.get("MONTH").toString())) != null) {
                            map.put(P, map1.get(parseStr(map.get("MONTH").toString())));
                            break;
                        }
                    }
                } else {
                    map.put(P, 0.0d);
                }
            }
            list.add(map);
        }
        return list;
    }

    //空值补数据
    //1，Q    2 U
    private List<Map> addDefaultValue(List<Map> monthListAll, String station,String P,int num) {
        List<Map> list = new ArrayList<>();
        List<Map> mapListQ = defaultValueQ().get(station);
        List<Map> mapListU = defaultValueU().get(station);

        for (int i = 0; i<monthListAll.size() ;i++) {
            Map map = monthListAll.get(i);
            if(num ==0 || num ==1) {
                if (map.get("Q") == null || Double.parseDouble(map.get("Q").toString()) == 0d) {
                    if (station.equals("沙子岭") || station.equals("南丰") || station.equals("廖家湾") || station.equals("娄家村")) {
                        for (Map map1 : mapListQ) {
                            if (map1.get(parseStr(map.get("MONTH").toString())) != null) {
                                map.put("Q", map1.get(parseStr(map.get("MONTH").toString())));
                                break;
                            }
                        }
                    } else {
                        map.put("Q", 0.0d);
                    }
                }
            }
            if (num == 0 || num ==2) {
                if (map.get(P) == null||Double.parseDouble(map.get(P).toString())==0d) {
                    if (station.equals("沙子岭") || station.equals("南丰") || station.equals("娄家村")) {
                        for (Map map1 : mapListU) {
                            if (map1.get(parseStr(map.get("MONTH").toString())) != null) {
                                map.put(P, map1.get(parseStr(map.get("MONTH").toString())));
                                break;
                            }
                        }
                    } else {
                        map.put(P, 0.0d);
                    }
                }
            }
            list.add(map);
        }
        List<Map> resultList = new ArrayList();
        if(list.size()<12) {
            if (num == 1) {
                for (int i = 0; i < 12; i++) {
                    boolean flag = false;
                    for (Map listMap : list) {
                        if (Integer.parseInt(formatStrNum(listMap.get("MONTH").toString())) == (i + 1) && Double.parseDouble(listMap.get("Q").toString()) != 0d) {
                            flag = true;
                            resultList.add(listMap);
                            break;
                        }
                    }
                    if (!flag) {
                        double Q = getDefaultMonthQ(station, i);
                        Map hashMap = new HashMap();
                        hashMap.put("MONTH", i < 9 ? "0" + (i + 1) : (i + 1) + "");
                        hashMap.put("Q", Q + "");
                        resultList.add(hashMap);
                    }
                }

            }
            if (num == 2) {
                for (int i = 0; i < 12; i++) {
                    boolean flag = false;
                    for (Map listMap : list) {
                        if (Integer.parseInt(formatStrNum(listMap.get("MONTH").toString())) == (i + 1) && Double.parseDouble(listMap.get(P).toString()) != 0d) {
                            flag = true;
                            resultList.add(listMap);
                            break;
                        }
                    }
                    if (!flag) {
                        double U = getDefaultMonthU(station, i);
                        Map hashMap = new HashMap();
                        hashMap.put("MONTH", i < 9 ? "0" + (i + 1) : (i + 1) + "");
                        hashMap.put(P, U + "");
                        resultList.add(hashMap);
                    }
                }

            }

            if (num == 0) {
                for (int i = 0; i < 12; i++) {
                    double reP = 0.0d;
                    double reQ = 0.0d;
                    boolean flaga = false;
                    boolean flagb = false;
                    boolean flagc = false;
                    for (Map listMap : list) {
                        if (Integer.parseInt(formatStrNum(listMap.get("MONTH").toString())) == (i + 1)) {
                            flaga = true;
                            if((Double.parseDouble(listMap.get(P).toString()) != 0d) &&(Double.parseDouble(listMap.get("Q").toString()) != 0d)){
                                flagb = true;
                                flagc = true;
                                resultList.add(listMap);
                                break;
                            }else {
                                if (Double.parseDouble(listMap.get(P).toString()) != 0d) {
                                    flagb = true;
                                    reP = Double.parseDouble(listMap.get(P).toString());
                                }
                                if (Double.parseDouble(listMap.get("Q").toString()) != 0d) {
                                    flagc = true;
                                    reQ = Double.parseDouble(listMap.get("Q").toString());
                                }
                            }
                        }
                    }
                    if ((!flagc && !flagb)||!flaga) {
                        double Q = getDefaultMonthQ(station, i);
                        double U = getDefaultMonthU(station, i);
                        Map hashMap = new HashMap();
                        hashMap.put("MONTH", i < 9 ? "0" + (i + 1) : (i + 1) + "");
                        hashMap.put(P, U + "");
                        hashMap.put("Q", Q + "");
                        resultList.add(hashMap);
                    } else if (flagb && !flagc) {
                        double Q = getDefaultMonthQ(station, i);
                        Map hashMap = new HashMap();
                        hashMap.put("MONTH", i < 9 ? "0" + (i + 1) : (i + 1) + "");
                        hashMap.put(P, reP + "");
                        hashMap.put("Q", Q + "");
                        resultList.add(hashMap);
                    }else if(flagc && !flagb){
                        double p = getDefaultMonthQ(station, i);
                        Map hashMap = new HashMap();
                        hashMap.put("MONTH", i < 9 ? "0" + (i + 1) : (i + 1) + "");
                        hashMap.put("Q", reQ + "");
                        hashMap.put(p, p + "");
                        resultList.add(hashMap);
                    }
                }
            }
        }else{
            resultList = list;
        }
        return resultList;
    }


    private String formatStrNum(String str){
        if(str.contains("月")) {
            String[] spits = str.split("月");
            int month = Integer.parseInt(spits[0]);
            return month+"";
        }else if(str.contains("-")){
            String[] strs = str.split("-");
            int month = Integer.parseInt(strs[1]);
            return month+"";
        }else{
            return str;
        }
    }
    private Map<String,List<Map>> defaultValueQ() {

        double[] szl = {
                19.2,
                28.8,
                49.6,
                66.0,
                73.4,
                91.0,
                46.3,
                36.6,
                31.5,
                25.2,
                20.5,
                17.2
        };
        double[] nf = {
                35.2,
                45.4,
                88.4,
                120.0,
                167.2,
                233.7,
                108.3,
                72.0,
                59.6,
                40.9,
                61.0,
                52.4
        };
        double[] ljw = {
                129.4,
                193.5,
                330.8,
                478.4,
                475.0,
                646.2,
                355.7,
                220.1,
                181.9,
                153.1,
                155.9,
                127.0,
        };
        double[] ljc = {
                76.9,
                123.6,
                211.1,
                304.0,
                276.1,
                374.9,
                177.8,
                118.6,
                107.8,
                74.4,
                85.8,
                65.2
        };

        List<Map> szlQ = new ArrayList<>();
        List<Map> nfQ = new ArrayList<>();
        List<Map> ljwQ = new ArrayList<>();
        List<Map> ljcQ = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Map szlmap = new HashMap();
            szlmap.put(i + "月", szl[i]);
            szlQ.add(szlmap);
            Map nfmap = new HashMap();
            nfmap.put(i + "月", nf[i]);
            nfQ.add(nfmap);
            Map ljwmap = new HashMap();
            ljwmap.put(i + "月", ljw[i]);
            ljwQ.add(ljwmap);
            Map ljcmap = new HashMap();
            ljcmap.put(i + "月", ljc[i]);
            ljcQ.add(ljcmap);
        }
        Map<String,List<Map>> resultMap = new HashMap();
        resultMap.put("沙子岭", szlQ);
        resultMap.put("南丰", nfQ);
        resultMap.put("廖家湾", ljwQ);
        resultMap.put("娄家村", ljcQ);
        return resultMap;
    }

    private Map<String,List<Map>> defaultValueU() {

        double[] szl = {
                79.8,
                126.1,
                218.8,
                249.2,
                270.4,
                310.8,
                133.1,
                144.0,
                79.3,
                72.1,
                63.7,
                40.1

        };
        double[] nf = {
                77.5,
                116.3,
                203.9,
                248.2,
                248.1,
                303.2,
                130.1,
                126.7,
                77.3,
                73.3,
                65.6,
                39.2

        };
        double[] ljc = {
                80.0,
                120.1,
                210.7,
                256.4,
                256.3,
                313.2,
                134.4,
                130.9,
                79.9,
                75.7,
                67.8,
                40.5
        };

        List<Map> szlU = new ArrayList<>();
        List<Map> nfU = new ArrayList<>();
        List<Map> ljcU = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Map szlmap = new HashMap();
            szlmap.put(i + "月", szl[i]);
            szlU.add(szlmap);
            Map nfmap = new HashMap();
            nfmap.put(i + "月", nf[i]);
            nfU.add(nfmap);
            Map ljcmap = new HashMap();
            ljcmap.put(i + "月", ljc[i]);
            ljcU.add(ljcmap);
        }
        Map<String,List<Map>> resultMap = new HashMap();
        resultMap.put("沙子岭", szlU);
        resultMap.put("南丰", nfU);
        resultMap.put("娄家村", ljcU);
        return resultMap;
    }

    private double addDeafultOneXunU(String xunStr,String station){
        xunStr = parseStr(xunStr);
        if (station.equals("沙子岭")||station.equals("南丰")||station.equals("娄家村")){
            List<Map> mapList = defaultXunU().get(station);
            for(Map map:mapList){
                if(map.get(xunStr)!=null){
                    return Double.parseDouble(map.get(xunStr).toString());
                }
            }
        }
        return 0.0d;
    }

    private double addDeafultOneXunQ(String xunStr,String station){
        xunStr = parseStr(xunStr);
        if (station.equals("沙子岭")||station.equals("南丰")||station.equals("娄家村")||station.equals("廖家湾")){
            List<Map> mapList = defaultXunQ().get(station);
            for(Map map:mapList){
                if(map.get(xunStr)!=null){
                    return Double.parseDouble(map.get(xunStr).toString());
                }
            }
        }
        return 0.0d;
    }

    private Map<String,List<Map>> defaultXunU(){
        double[] szl = {
                21.9,
                27.9,
                30.0,
                40.2,
                46.0,
                39.9,
                50.2,
                77.0,
                91.6,
                93.6,
                82.9,
                72.7,
                89.0,
                77.7,
                103.7,
                80.1,
                148.3,
                82.4,
                54.9,
                42.7,
                35.5,
                40.7,
                53.8,
                49.4,
                37.7,
                22.7,
                18.9,
                28.2,
                19.0,
                24.9,
                20.9,
                23.0,
                19.8,
                14.0,
                12.5,
                13.6
        };
        double[] nf = {
                19.2,
                26.9,
                31.4,
                37.0,
                44.3,
                35.0,
                50.7,
                64.3,
                89.0,
                89.7,
                80.8,
                77.8,
                92.9,
                75.0,
                80.3,
                80.8,
                149.4,
                73.0,
                55.7,
                39.2,
                35.2,
                32.2,
                51.8,
                42.6,
                37.9,
                21.9,
                17.6,
                29.1,
                19.6,
                24.6,
                25.4,
                19.0,
                21.1,
                13.9,
                12.2,
                13.1
        };
        double[] ljc = {
                19.8,
                27.8,
                32.5,
                38.3,
                45.8,
                36.1,
                52.3,
                66.5,
                91.9,
                92.6,
                83.5,
                80.4,
                95.9,
                77.4,
                82.9,
                83.5,
                154.4,
                75.4,
                57.6,
                40.5,
                36.4,
                33.3,
                53.5,
                44.0,
                39.1,
                22.6,
                18.1,
                30.1,
                20.2,
                25.4,
                26.3,
                19.6,
                21.8,
                14.4,
                12.6,
                13.6
        };
        List<Map> szlU = new ArrayList<>();
        List<Map> nfU = new ArrayList<>();
        List<Map> ljcU = new ArrayList<>();
        List<String> xunLists = getXunLists();
        for (int i = 0; i < xunLists.size(); i++) {
            Map szlmap = new HashMap();
            szlmap.put(xunLists.get(i), szl[i]);
            szlU.add(szlmap);
            Map nfmap = new HashMap();
            nfmap.put(xunLists.get(i), nf[i]);
            nfU.add(nfmap);
            Map ljcmap = new HashMap();
            ljcmap.put(xunLists.get(i), ljc[i]);
            ljcU.add(ljcmap);
        }
        Map<String,List<Map>> resultMap = new HashMap();
        resultMap.put("沙子岭", szlU);
        resultMap.put("南丰", nfU);
        resultMap.put("娄家村", ljcU);
        return resultMap;
    }

    private Map<String,List<Map>> defaultXunQ(){
        double[] szl = {
                17.8,
                19.2,
                20.5,
                24.2,
                30.4,
                32.4,
                42.1,
                44.4,
                61.1,
                66.8,
                64.9,
                66.3,
                78.3,
                68.6,
                73.2,
                76.3,
                112.9,
                84.0,
                61.1,
                45.6,
                33.6,
                38.5,
                37.4,
                34.1,
                40.4,
                28.3,
                25.7,
                25.7,
                24.9,
                25.0,
                21.6,
                18.8,
                20.9,
                18.5,
                16.7,
                16.6
        };
        double[] nf = {
                31.2,
                35.0,
                38.9,
                40.2,
                50.3,
                45.9,
                92.4,
                80.9,
                91.5,
                101.7,
                127.8,
                130.5,
                130.3,
                166.9,
                200.9,
                169.9,
                243.7,
                287.4,
                144.5,
                104.6,
                78.9,
                67.8,
                77.8,
                70.5,
                78.3,
                52.0,
                48.6,
                50.1,
                38.9,
                34.5,
                38.3,
                85.7,
                59.0,
                50.4,
                55.2,
                51.5

        };
        double[] ljc = {
                62.4,
                78.4,
                88.7,
                98.5,
                135.5,
                140.1,
                177.6,
                191.7,
                259.4,
                292.4,
                313.8,
                305.7,
                295.8,
                284.1,
                250.8,
                286.3,
                465.6,
                372.9,
                274.8,
                157.6,
                108.0,
                115.9,
                125.9,
                114.5,
                146.2,
                89.3,
                88.0,
                74.2,
                68.6,
                79.8,
                91.3,
                79.9,
                86.2,
                68.7,
                66.6,
                60.8
        };
        double[] ljw = {
                115.9,
                133.6,
                137.9,
                165.3,
                203.0,
                217.0,
                287.1,
                291.1,
                406.6,
                460.2,
                489.8,
                485.1,
                490.0,
                498.5,
                440.0,
                516.7,
                747.4,
                674.5,
                494.4,
                335.0,
                248.5,
                226.8,
                244.7,
                191.8,
                237.2,
                158.3,
                150.2,
                148.6,
                150.0,
                159.9,
                162.5,
                146.9,
                158.2,
                136.5,
                122.3,
                122.7
        };

        List<Map> szlQ = new ArrayList<>();
        List<Map> nfQ = new ArrayList<>();
        List<Map> ljcQ = new ArrayList<>();
        List<Map> ljwQ = new ArrayList<>();
        List<String> xunLists = getXunLists();
        for (int i = 0; i < xunLists.size(); i++) {
            Map szlmap = new HashMap();
            szlmap.put(xunLists.get(i), szl[i]);
            szlQ.add(szlmap);
            Map nfmap = new HashMap();
            nfmap.put(xunLists.get(i), nf[i]);
            nfQ.add(nfmap);
            Map ljcmap = new HashMap();
            ljcmap.put(xunLists.get(i), ljc[i]);
            ljcQ.add(ljcmap);
            Map ljwmap = new HashMap();
            ljwmap.put(xunLists.get(i), ljc[i]);
            ljwQ.add(ljwmap);

        }
        Map<String,List<Map>> resultMap = new HashMap();
        resultMap.put("沙子岭", szlQ);
        resultMap.put("南丰", nfQ);
        resultMap.put("娄家村", ljcQ);
        resultMap.put("廖家湾", ljwQ);
        return resultMap;
    }

    public double getDefaultMonthQ(String stationName,int i) {
        double[] szl = {
                19.2,
                28.8,
                49.6,
                66.0,
                73.4,
                91.0,
                46.3,
                36.6,
                31.5,
                25.2,
                20.5,
                17.2
        };
        double[] nf = {
                35.2,
                45.4,
                88.4,
                120.0,
                167.2,
                233.7,
                108.3,
                72.0,
                59.6,
                40.9,
                61.0,
                52.4
        };
        double[] ljw = {
                129.4,
                193.5,
                330.8,
                478.4,
                475.0,
                646.2,
                355.7,
                220.1,
                181.9,
                153.1,
                155.9,
                127.0,
        };
        double[] ljc = {
                76.9,
                123.6,
                211.1,
                304.0,
                276.1,
                374.9,
                177.8,
                118.6,
                107.8,
                74.4,
                85.8,
                65.2
        };
        if (stationName.equals("沙子岭")) {
            return szl[i];
        } else if (stationName.equals("南丰")) {
            return nf[i];
        } else if (stationName.equals("廖家湾")) {
            return ljw[i];
        } else if (stationName.equals("娄家村")) {
            return ljc[i];
        } else {
            return 0.0d;
        }
    }

    private String parseStr(String str){
        if(str.contains("月")){
            String[] spits = str.split("月");
            int month = Integer.parseInt(spits[0]);
            if(spits.length==1){
                return month +"月";
            }else{
                return month +"月"+ spits[1];
            }
        }else if(str.contains("-")){
            String[] strs = str.split("-");
            int month = Integer.parseInt(strs[1]);
            return month+"月";
        }else{
            return Integer.parseInt(str)+"月";
        }
    }

    public double getDefaultMonthU(String stationName,int i){
        double[] szl = {
                79.8,
                126.1,
                218.8,
                249.2,
                270.4,
                310.8,
                133.1,
                144.0,
                79.3,
                72.1,
                63.7,
                40.1

        };
        double[] nf = {
                77.5,
                116.3,
                203.9,
                248.2,
                248.1,
                303.2,
                130.1,
                126.7,
                77.3,
                73.3,
                65.6,
                39.2

        };
        double[] ljc = {
                80.0,
                120.1,
                210.7,
                256.4,
                256.3,
                313.2,
                134.4,
                130.9,
                79.9,
                75.7,
                67.8,
                40.5
        };
        if (stationName.equals("沙子岭")) {
            return szl[i];
        } else if (stationName.equals("南丰")) {
            return nf[i];
        } else if (stationName.equals("娄家村")) {
            return ljc[i];
        } else {
            return 0.0d;
        }
    }

}
