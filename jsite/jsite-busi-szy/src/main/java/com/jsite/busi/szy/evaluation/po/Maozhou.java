package com.jsite.busi.szy.evaluation.po;

import java.util.ArrayList;
import java.util.List;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 胡周
 * 创建时间：22:14
 */
public class Maozhou {

        public   double p=6;
        public   double pa=-0.3329;
        public   double pb0=0.00528;
        public   double pb1=-0.00221;

        private static List<Double> A = new ArrayList<Double>();
        private static List<Double> B = new ArrayList<Double>();
;
        public   double A1=	5.997;
        public   double A2=	-11.81793;
        public   double A3=	12.54603;
        public   double A4=	-11.18235;
        public   double A5=	6.57053;
        public   double A6=	-5.05188;
        public   double A7=	3.9395;

        public   double B1=	-0.51224;
        public   double B2=	0.2097;
        public   double B3=	1.9296;
        public   double B4=	2.22695;
        public   double B5=	-1.47844;
        public   double B6=	-0.49586;
        public   double B7=	-1.67088;


        public List<Double> getA(){
            if(A==null ||A.size()==0){
                A.add(A1);A.add(A2);A.add(A3);A.add(A4);A.add(A5);A.add(A6);A.add(A7);
            }
            return A;
        }

        public List<Double> getB(){
            if(B==null || B.size()==0){
                B.add(B1);B.add(B2);B.add(B3);B.add(B4);B.add(A5);B.add(A6);B.add(A7);
            }
            return B;
        }


        public double getP() {
            return p;
        }

        public void setP(double p) {
            this.p = p;
        }

        public double getPa() {
            return pa;
        }

        public void setPa(double pa) {
            this.pa = pa;
        }

        public double getPb0() {
            return pb0;
        }

        public void setPb0(double pb0) {
            this.pb0 = pb0;
        }

        public double getPb1() {
            return pb1;
        }

        public void setPb1(double pb1) {
            this.pb1 = pb1;
        }

        public double getA1() {
            return A1;
        }

        public void setA1(double a1) {
            A1 = a1;
        }

        public double getA2() {
            return A2;
        }

        public void setA2(double a2) {
            A2 = a2;
        }

        public double getA3() {
            return A3;
        }

        public void setA3(double a3) {
            A3 = a3;
        }

        public double getA4() {
            return A4;
        }

        public void setA4(double a4) {
            A4 = a4;
        }

        public double getB1() {
            return B1;
        }

        public void setB1(double b1) {
            B1 = b1;
        }

        public double getB2() {
            return B2;
        }

        public void setB2(double b2) {
            B2 = b2;
        }

        public double getB3() {
            return B3;
        }

        public void setB3(double b3) {
            B3 = b3;
        }

        public double getB4() {
            return B4;
        }

        public void setB4(double b4) {
            B4 = b4;
        }



}
