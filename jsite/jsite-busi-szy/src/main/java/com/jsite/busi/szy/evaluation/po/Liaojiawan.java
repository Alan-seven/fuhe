package com.jsite.busi.szy.evaluation.po;

import java.util.ArrayList;
import java.util.List;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 向靖
 * 创建时间：2017-10-11 15:41
 */
public  class Liaojiawan {
    public  double p=3;
    public  double pa=0.02442;
    public  double pb0=0.14693;
    public  double pb1=0.00532;
    public  double A1=-2.43804;
    public  double A2=4.15517;
    public  double A3=-3.23147;
    public  double A4=2.51462;
    public  double B1=0.69584;
    public  double B2=-0.39088;
    public  double B3=-0.11654;
    public  double B4=0.27721;

    private static List<Double> A = new ArrayList<Double>();
    private static List<Double> B = new ArrayList<Double>();

    public List<Double> getA(){
        if(A==null ||A.size()==0){
            A.add(A1);A.add(A2);A.add(A3);A.add(A4);
        }
        return A;
    }

    public List<Double> getB(){
        if(B==null || B.size()==0){
            B.add(B1);B.add(B2);B.add(B3);B.add(B4);
        }
        return B;
    }



    public  double getP() {
        return p;
    }

    public  void setP(double p) {
        this.p = p;
    }

    public  double getPa() {
        return pa;
    }

    public  void setPa(double pa) {
        this.pa = pa;
    }

    public  double getPb0() {
        return pb0;
    }

    public  void setPb0(double pb0) {
        this.pb0 = pb0;
    }

    public  double getPb1() {
        return pb1;
    }

    public  void setPb1(double pb1) {
        this.pb1 = pb1;
    }

    public  double getA1() {
        return A1;
    }

    public  void setA1(double a1) {
        A1 = a1;
    }

    public  double getA2() {
        return A2;
    }

    public  void setA2(double a2) {
        A2 = a2;
    }

    public  double getA3() {
        return A3;
    }

    public  void setA3(double a3) {
        A3 = a3;
    }

    public  double getA4() {
        return A4;
    }

    public  void setA4(double a4) {
        A4 = a4;
    }

    public  double getB1() {
        return B1;
    }

    public  void setB1(double b1) {
        B1 = b1;
    }

    public  double getB2() {
        return B2;
    }

    public  void setB2(double b2) {
        B2 = b2;
    }

    public  double getB3() {
        return B3;
    }

    public  void setB3(double b3) {
        B3 = b3;
    }

    public  double getB4() {
        return B4;
    }

    public  void setB4(double b4) {
        B4 = b4;
    }

}
