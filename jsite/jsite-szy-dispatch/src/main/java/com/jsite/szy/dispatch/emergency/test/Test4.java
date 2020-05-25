package com.jsite.szy.dispatch.emergency.test;

import com.jsite.szy.dispatch.emergency.model.CalModel;
import com.jsite.szy.dispatch.emergency.model.ControlState;
import com.jsite.szy.dispatch.emergency.model.ModelCon;
import com.jsite.szy.dispatch.emergency.model.ModelResult;
import com.jsite.szy.dispatch.emergency.model.Reservior;

public class Test4 {

	 public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        /**
	         * 污染源信息表
	         */
	        //Date TM;// 污染发生时间
	        //double DUR=3;// 污染物持续时间
	        int RCD=4;//发生河道
	        String UPSEC="02000001";//上监测断面ID-如：廖坊坝
	        double LEN_UP=80; //起点距 = 距离上监测断面的距离+上断面的起点距
	        double DA=10300;// 污染量 kg
	        int DA_TYPE=0;//污染物类型  0保守型物质、1挥发性物质 体现在降解系数不同
	        
	        /**
	         *  方案基本信息表
	         */
	        //String PRO_CD; 
	        int foreTime=24;//前沿时段：小时 ——数据库加
	        //Date startTime;// 计算起始时间， 污染发生时间 >= startTime - foreTime
	        int deltaT=1;//输入序列的时间间隔：1h
	        int length=48;//计算总时段数，单位：h
	        int accurTime=19;//污染发生时间 距离 计算起始时间的时段数 (TM-startTime)/deltaT
	        int durTime=1; // 污染物持续时段数 DUR/deltaT
	        
	        
	        /**
	         * 方案模型参数信息——加
	         */
	        double r=0.03;// 按控制断面区间给
	        double a=0.33;// 扩散系数
	        double k=0.0001;// 衰减系数
	        
	        /**
	         * 初始条件信息
	         */
	         double BG_CO=0;
	         double[] BG_Z={60.92, 99.06};//水库初始水位（水库运行方式界面）
	         //double[] BG_CONC={0,0}; // 水库初始污染物浓度（新建方案界面）-暂时没用
	         double[] BG_Q={0,0};// 测站初始流量（新建方案界面）-暂时没用

	         double[] WQgoal={0.01,0.01,0.01,0.01,0.01,0.01,0.01}; // rcd=4时，有5个控制断面
	        
	        /**
	         * 方案边界条件信息表 
	         */
	         double[][]boundry=new double[4][foreTime+length+1]; //根据模型配置的顺序，每一个边界存一个数组-界面传
	         //预热期输入读历史实际值
	         for(int i=0;i<foreTime;i++){
	             boundry[0][i]=498;//廖坊入库
	             boundry[1][i]=260;//娄家村汇入
	             boundry[2][i]=30.8;//马圩汇入
	             boundry[3][i]=25.44;//李家渡水位
	            }
	         // 模拟期输入从界面设置获取
	         for(int i=foreTime;i<boundry[0].length;i++){
	             boundry[0][i]=498;//廖坊入库
	             boundry[1][i]=270;//娄家村汇入
	             boundry[2][i]=30.8;//马圩汇入
	             boundry[3][i]=25.44;//李家渡水位
	            }
	            
	        /**
	         * 水库调节信息表
	         */
	         double[][]outflow=new double[1][foreTime+length+1]; //原计划
	         double[][]deltaflow=new double[1][foreTime+length+1]; //加大量
	         for(int i=0;i<foreTime;i++){
	             outflow[0][i]=408;//廖坊出库
	             deltaflow[0][i]=30;//廖坊加大出库
	            }
	         // 模拟期输入从界面设置获取
	         for(int i=foreTime;i<outflow[0].length;i++){
	             outflow[0][i]=408;//廖坊出库
	             deltaflow[0][i]=30;//廖坊加大出库
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
