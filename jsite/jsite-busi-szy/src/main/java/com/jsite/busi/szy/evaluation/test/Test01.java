package com.jsite.busi.szy.evaluation.test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 胡周
 * 创建时间：10:38
 */
public class Test01 {

    public List<String> getXunLists(){
        List<String> xunList = new ArrayList<>();
        for(int i=1;i<=12;i++){
            for(int j=1;j<=3;j++){
                if(j==1){
                    xunList.add(i+"月上");
                }
                if(j==2){
                    xunList.add(i+"月中");
                }
                if(j==3){
                    xunList.add(i+"月下");
                }
            }
        }
        return xunList;
    }

    public String getFromatXun(String startTime){
        String[] split = startTime.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        String xun = null;
        if(day == 10){
            xun = year+"年"+month+"月中";
        }else if(day == 20){
            xun = year+"年"+month+"月下";
        }else{
            if(Integer.parseInt(split[1]) == 12) {
                xun =  year+1+"年1月上";
            }else{
                xun = year+"年"+(month+1)+"月上";
            }
        }
        return xun;
    }

    public List<String> getFormatXunList(String start){
        String startXun = getFromatXun(start);
        List<String> xunList = getXunLists();
        List<String> ftXunList = new ArrayList<>();
        boolean flag = false;
        boolean flag1 = false;
        String[] startX = startXun.split("年");
        int year = Integer.parseInt(startX[0]);//1988
        String mxun = startX[1];//1月下
            for(int j=0;j<xunList.size();j++){
                if(xunList.get(j).equals(mxun)){
                    flag= true;
                }
                if(flag){
                    ftXunList.add(year+"年"+xunList.get(j));
                }
            }
            for(int k=0;k<xunList.size();k++){
                if(xunList.get(k).equals(mxun)){
                    flag1= true;
                }
                if(!flag1){
                    ftXunList.add(year+1+"年"+xunList.get(k));
                }
            }
        return ftXunList;
    }


    public List<String> getNextXunList(String start){
        String startXun = getFromatXun(start);
        List<String> xunList = getXunLists();
        List<String> nextxunList = new ArrayList<>();
        boolean flag = false;
        boolean flag1 = false;
        String[] startX = startXun.split("年");
        int year = Integer.parseInt(startX[0]);//1988
        String mxun = startX[1];//1月下
        for(int j=0;j<xunList.size();j++){
            if(xunList.get(j).equals(mxun)){
                flag= true;
            }
            if(flag){
                nextxunList.add(xunList.get(j));
            }
        }
        return nextxunList;
    }


    @Test
    public void test1(){
        List<String> formatXunList = getNextXunList("1988-01-31");
        for(int i=0;i<formatXunList.size();i++){
            System.out.println(formatXunList.get(i)+"----->"+i);
        }
    }


    public Date  plusDays1(Date date, int xuns){
        try {
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, xuns*10);
            if(calendar.get(Calendar.DAY_OF_MONTH)==31){
                calendar.add(Calendar.DATE, 1);
            }
            String format1 = sdFormat.format(calendar.getTime());
            return sdFormat.parse(format1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test02() throws Exception{
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 36);
        String format = sdFormat.format(calendar.getTime());
        Date parse = sdFormat.parse(format);
        System.out.println(sdFormat.format(plusDays1(parse,2)));

    }
}
