package com.jsite.szy.dispatch.emergency.test;

import com.jsite.szy.dispatch.emergency.model.CalModel;
import com.jsite.szy.dispatch.emergency.model.ControlState;
import com.jsite.szy.dispatch.emergency.model.ModelCon;
import com.jsite.szy.dispatch.emergency.model.ModelResult;
import com.jsite.szy.dispatch.emergency.model.Reservior;
 
public class Test5LX_BJ {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         * 污染源信息表
         */
        //Date TM;// 污染发生时间
        //double DUR=3;// 污染物持续时间
        int RCD=5;//发生河道
        String UPSEC="03000001";//上监测断面ID-如：芦溪
        double LEN_UP=10; //起点距 = 距离上监测断面的距离+上断面的起点距  河段长度81.61
        double DA=1;// 污染量 kg
        int DA_TYPE=0;//污染物类型  0保守型物质、1挥发性物质 体现在降解系数不同
        
        /**
         *  方案基本信息表
         */
        //String PRO_CD; 
        int foreTime=12;//前沿时段：小时 ——数据库加
        //Date startTime;// 计算起始时间， 污染发生时间 >= startTime - foreTime
        int deltaT=1;//输入序列的时间间隔：1h
        int length=156;//计算总时段数，单位：h
        int accurTime=5;//污染发生时间 距离 计算起始时间的时段数 (TM-startTime)/deltaT
        int durTime=3; // 污染物持续时段数 DUR/deltaT
        
        
        /**
         * 方案模型参数信息——加
         */
        double r=0.33;// 按控制断面区间给
        double a=0;// 扩散系数
        double k=0.00001;// 衰减系数
        
        /**
         * 初始条件信息-水库相关的无用
         */
         double BG_CO=0;
         double[] BG_Z={90.5,61.5};//水库初始水位（水库运行方式界面）
         //double[] BG_CONC={0,0}; // 水库初始污染物浓度（新建方案界面）-暂时没用
         double[] BG_Q={0,0};// 测站初始流量（新建方案界面）-暂时没用

         double[] WQgoal={0.01,0.01,0.01,0.01,0.01}; // rcd=5时，有5个控制断面
        
        /**
         * 方案边界条件信息表 
         */
         double[][]boundry=new double[2][foreTime+length+1]; //根据模型配置的顺序，每一个边界存一个数组-界面传
         double up[]={7.10,7.14,7.17,7.21,7.25,7.29,7.32,7.36,7.40,7.43,7.47,7.51,7.55,7.58,7.62,7.66,7.69,7.73,7.77,7.80,7.84,7.88,7.92,7.95,7.99,8.18,8.36,8.55,8.74,8.93,9.11,9.30,9.49,9.67,9.86,10.05,10.24,10.42,10.61,10.80,10.98,11.17,11.36,11.54,11.73,11.92,12.11,12.29,12.48,12.36,12.24,12.12,12.00,11.88,11.76,11.64,11.52,11.40,11.28,11.16,11.04,10.92,10.80,10.68,10.56,10.44,10.32,10.20,10.08,9.96,9.84,9.72,9.60,9.79,9.98,10.17,10.36,10.55,10.74,10.93,11.12,11.31,11.50,11.69,11.88,12.07,12.26,12.45,12.64,12.83,13.02,13.21,13.40,13.59,13.78,13.97,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.16,14.08,14.00,13.92,13.84,13.76,13.68,13.60,13.52,13.44,13.36,13.28,13.20,13.12,13.04,12.96,12.88,12.80,12.72,12.64,12.56,12.48,12.40,12.32,12.24,14.83,17.42,20.01,22.60,25.19,27.78,30.37,32.96,35.55,38.14,40.73,43.32,45.91,48.50,51.09,53.68,56.27,58.86,61.45,64.04,66.63,69.22,71.81,74.40};
         double down[]={64.92,64.92,64.92,64.92,64.91,64.91,64.91,64.91,64.91,64.91,64.90,64.90,64.90,64.90,64.90,64.90,64.89,64.89,64.89,64.89,64.89,64.89,64.88,64.88,64.88,64.91,64.95,64.98,65.01,65.05,65.08,65.11,65.15,65.18,65.21,65.25,65.28,65.31,65.35,65.38,65.41,65.45,65.48,65.51,65.55,65.58,65.61,65.65,65.68,65.66,65.64,65.63,65.61,65.59,65.57,65.55,65.53,65.52,65.50,65.48,65.46,65.44,65.42,65.41,65.39,65.37,65.35,65.33,65.31,65.30,65.28,65.26,65.24,65.23,65.22,65.21,65.21,65.20,65.19,65.18,65.17,65.16,65.15,65.14,65.13,65.13,65.12,65.11,65.10,65.09,65.08,65.07,65.06,65.06,65.05,65.04,65.03,65.03,65.03,65.03,65.03,65.03,65.04,65.04,65.04,65.04,65.04,65.04,65.04,65.04,65.04,65.04,65.04,65.04,65.05,65.05,65.05,65.05,65.05,65.05,65.05,65.05,65.05,65.05,65.05,65.05,65.06,65.06,65.06,65.06,65.06,65.06,65.06,65.06,65.06,65.06,65.06,65.06,65.07,65.07,65.07,65.07,65.07,65.07,65.07,65.06,65.05,65.04,65.03,65.02,65.01,64.99,64.98,64.97,64.96,64.95,64.94,64.93,64.92,64.91,64.90,64.89,64.87,64.86,64.85,64.84,64.83,64.82,64.81};
         //预热期输入读历史实际值
         for(int i=0;i<foreTime;i++){
             boundry[0][i]=up[i];//芦溪流量  13
             boundry[1][i]=down[i];//彬江水位  65
            }
         // 模拟期输入从界面设置获取
         for(int i=foreTime;i<boundry[0].length;i++){
        	 boundry[0][i]=up[i];//芦溪流量
             boundry[1][i]=down[i];//彬江水位
            }
            
        /**
         * 水库调节信息表-无用
         */
         double[][]outflow=new double[2][foreTime+length+1]; //原计划
         double[][]deltaflow=new double[2][foreTime+length+1]; //加大量
         for(int i=0;i<foreTime;i++){
             outflow[0][i]=175;//洪门出库
             outflow[1][i]=441;//廖坊出库
             deltaflow[0][i]=0;//洪门加大出库
             deltaflow[1][i]=0;//廖坊加大出库
            }
         // 模拟期输入从界面设置获取
         for(int i=foreTime;i<outflow[0].length;i++){
             outflow[0][i]=175;//洪门出库
             outflow[1][i]=441;//廖坊出库
             deltaflow[0][i]=10;//洪门加大出库
             deltaflow[1][i]=20;//廖坊加大出库
            }
        
         ModelCon conditions=new ModelCon();
         conditions.setRCD(RCD);
         conditions.setDA(DA);
         conditions.setDA_TYPE(DA_TYPE); 
         conditions.setLEN_UP(LEN_UP);
         conditions.setDeltaT(deltaT);
         conditions.setForeTime(foreTime);
         conditions.setAccurTime(accurTime);
         conditions.setDurTime(durTime);
         conditions.setLength(length); 
         conditions.setA(a);
         conditions.setR(r);
         conditions.setK(k);
         conditions.setBG_CO(BG_CO);
         conditions.setBG_Q(BG_Q);
         conditions.setBG_Z(BG_Z);
         conditions.setWQgoal(WQgoal); 
         conditions.setBoundry(boundry);
         conditions.setOutflow(outflow);
         conditions.setDeltaflow(deltaflow);
         
         ModelResult mResult = new ModelResult();
         CalModel calmodel=new CalModel();
         Reservior[] reserviors=null;
         ControlState states[]=null;
         try {
            mResult = calmodel.startModel(conditions,reserviors,states);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}