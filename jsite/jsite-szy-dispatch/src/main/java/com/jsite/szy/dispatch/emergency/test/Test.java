package com.jsite.szy.dispatch.emergency.test;
	
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;

import com.jsite.szy.dispatch.emergency.model.ControlState;
import com.jsite.szy.dispatch.emergency.model.ExeControl;
import com.jsite.szy.dispatch.emergency.model.ExeInput;
import com.jsite.szy.dispatch.emergency.model.ExeOutput;

import jxl.Workbook;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
	
public class Test {
		
	public static void main(String[] args) throws IOException, InterruptedException{
		//-------------------所有对exeinput的设置替代实际输入myexeinput
        //初始化
        ExeInput mExeInput=new ExeInput();            
        ExeOutput myExeOutput=new ExeOutput();
        ExeControl myExeControl=new ExeControl();
        //设置路径
        myExeControl.set_path("src/main/java/com/jsite/szy/dispatch/emergency/model/");
        
        //界面设置
        mExeInput.setLength(38);//计算时间(跨度)h
        mExeInput.setRiverCode(4);//计算河段
        mExeInput.setR(0.033);//糙率
        //mExeInput.setA(0);//扩散系数m3/s
       // mExeInput.setK(0.00000001);//降解系数/s
        
        
        ControlState states[]=new ControlState[37];//输入计算断面，还需要和断面地形文件匹配
        for (int i = 0; i < states.length; i++) {
            states[i]=new ControlState();
        }
        mExeInput.setStates(states);
        
        //实测值设置
        mExeInput.setpnum(3);//点源个数
        String mypriver[]={"1","1","1"};
        mExeInput.setpriver(mypriver);//点源所在河流
        double myplength[]={48.16,53.16,54.16};//不准确
        mExeInput.setplength(myplength);//点源里程
        //mExeInput.setsolvendn(1);//浓度入流点数
        String mysolvendq[]={"3"};
        //mExeInput.setsolvendq(mysolvendq);//浓度入流在点源上的编号
        
        mExeInput.settnum(39);//时序点数
        double mytlength[]=new double[39];
        for (int i = 0; i < mytlength.length; i++) {
            mytlength[i]=i*3600;
        }
        mExeInput.settlength(mytlength);//距离起始时间时刻点,单位s
        
        double myupboundary[]={400,400,400,400,400,400,450,450,450,450,450,450,444,444,444,444,444,444,468,468,468,468,468,468,468,468,468,468,459,459,459,459,459,459,459,459,459,459,459};
        for(int i=0;i<38;i++){
            myupboundary[i]=myupboundary[i]-200;
        }
        
        
        mExeInput.setupboundary(myupboundary);//上边界流量时序m3/s
        
        double mylowboundary[]={23.16,23.21,23.26,23.31,23.42,23.5,23.57,23.58,23.62,23.64,23.74,23.76,23.76,23.77,23.76,23.76,23.76,23.76,23.76,23.75,23.75,23.74,23.76,23.77,23.78,23.8,23.81,23.82,23.82,23.83,23.84,23.84,23.84,23.86,23.87,23.87,23.88,23.88,23.88};
        mExeInput.setlowboundary(mylowboundary);//下边界水位时序m
        
        double mypointQ[][]={
                {4.08,4.08,3.87,3.87,3.66,3.66,3.66,3.66,3.66,3.66,3.66,3.45,3.25,3.25,3.25,3.45,3.45,3.45,3.45,3.45,3.45,3.45,3.45,3.45,3.45,3.45,3.25,3.25,3.25,3.25,3.25,3.25,3.05,3.05,3.05,3.05,3.05,3.05,3.05},
                {116,116,116,116,116,104,104,104,104,104,97.1,95.3,95.3,95.3,95.3,95.3,95.3,95.3,95.3,95.3,110,110,110,110,110,106,106,95.3,95.3,95.3,476,476,476,476,476,476,476,476,476},
                {4.58,4.58,4.37,4.37,4.16,4.16,4.16,4.16,4.16,4.16,4.16,3.95,3.75,3.75,3.75,3.95,3.95,3.95,3.95,3.95,3.95,3.95,3.95,3.95,3.95,3.95,3.75,3.75,3.75,3.75,3.75,3.75,3.55,3.55,3.55,3.55,3.55,3.55,3.55}};
        mExeInput.setpointQ(mypointQ);//点源时序流量
        
        double mysolvendtimesity[][]={{1011.50,1011.00,1010.20,107.00,107.90,107.30,105.40,106.80,106.50,106.90,107.80,9.10,11.40,7.80,9.00,7.20,6.80,5.40,6.50,6.70,7.10,7.10,8.10,8.20,9.60,8.70,8.30,8.10,8.10,7.70,7.00,6.70,7.20,7.00,7.30,7.90,7.80,7.90,8.20}};
        //mExeInput.setsolvendtimesity(mysolvendtimesity);//入流浓度时序
        
        //断面初始流量、水位、浓度。
        //mExeInput.getStates()[0].setInitialLevel(50);        mExeInput.getStates()[0].setInitialQ(400);        mExeInput.getStates()[0].setInitialCon(1);
        //mExeInput.getStates()[5].setInitialLevel(46);        mExeInput.getStates()[5].setInitialQ(400);        mExeInput.getStates()[5].setInitialCon(0.5);
        //mExeInput.getStates()[36].setInitialLevel(25);        mExeInput.getStates()[36].setInitialQ(400);        mExeInput.getStates()[36].setInitialCon(0);
        
        //水利学计算程序运行
       // myExeControl.RunExe(1,37,mExeInput);
        
        
        //输出文件
        ControlState myOutControlState[]=new ControlState[myExeControl.getSectionnum()];//断面数
        //输出对象创建
        for (int i = 0; i < myOutControlState.length; i++) {
            myOutControlState[i]=new ControlState();
        }
        
        
        //按断面输出
        myExeOutput.setStates(myOutControlState);//在输出对象中创建断面
       // myExeControl.setOutControlState(myExeOutput.getStates(),mExeInput);//断面值输出
        
 
        
        
        //结果存到根目录下txt，并打印出来看看
        File file=new File("resoult.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        String str=new String();
        FileWriter fileWriter=new FileWriter(file.getName());//非追加写入
        for (int i = 0; i < myOutControlState.length; i++) {//断面数
            System.out.println("断面号：-------------------------------------------------"+(i+1));
            str+="断面号：--------------------------------------------------------------"+(i+1)+"\r\n";
            for (int j = 0; j < myOutControlState[i].getLevel().length; j++) {//时序
                System.out.println(myOutControlState[i].getLevel()[j]+"   "+myOutControlState[i].getOutFlow()[j]+"   "+myOutControlState[i].getConcentration()[j]);
                str+=myOutControlState[i].getLevel()[j]+" "+myOutControlState[i].getOutFlow()[j]+" "+myOutControlState[i].getConcentration()[j]+"\r\n";
            }
        }
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        bufferedWriter.write(str);
        bufferedWriter.close();
        
        double x[][]=new double [myOutControlState[0].getLevel().length][myOutControlState.length*3];
        for (int i = 0; i < myOutControlState.length; i++) {//断面数
            
            for (int j = 0; j < myOutControlState[i].getLevel().length; j++){
                x[j][3*i]=myOutControlState[i].getLevel()[j];
                x[j][3*i+1]=myOutControlState[i].getOutFlow()[j];
                x[j][3*i+2]=myOutControlState[i].getConcentration()[j];
            }
            
        
        }
        
        write("F:/公司项目/6抚河调度/4.1我的工作梳理/应急调度交互对接/result-2.xls",1,"0",0,0,x);
        
        
         
	}
	
	public static  void write(String filename,int sheetindex,String sheetname,int row1,int column1,double[][] x) //从表的第row1行column列开始写
	{
		try //读相应文件，若存在则在其中创建新的sheet页
		{
			Workbook wb = Workbook.getWorkbook( new File( filename ));
			// 打开一个文件的副本，并且指定数据写回到原文件
			WritableWorkbook book = Workbook.createWorkbook( new File( filename ),wb);
			// 生成名为sheetname的工作表，sheetindex为页编号，0表示这是第一页
			String[] name=book.getSheetNames();
			int k;
			/*for(k=0;k<name.length;k++)
			{
				if(sheetname.equals(name[k]))
				{
					sheetname=sheetname+"(复件)";
					k=0;
				}
			}*/
			WritableSheet sheet = book.createSheet( sheetname , sheetindex );
			WritableCellFormat formater =new WritableCellFormat();
			formater.setAlignment(jxl.format.Alignment.CENTRE);		//设置单元格对齐方式；
			// 将定义好的单元格添加到工作表中
			
			for(int i=0;i<x.length;i++)	
				for(int j=0;j<x[0].length;j++)
				{
					jxl.write.Number number = new jxl.write.Number( j+column1 , i+row1 , x[i][j]);//第i行第j列				
					sheet.addCell(number);
				}
			
			// 写入数据并关闭文件
			book.write();
			book.close();
			System.out.println("OK!");
		
		} catch (Exception e) //若文件不存在，则创建新的文件，并建立相应sheet页；
		{
			try
			{
				WritableWorkbook book = Workbook.createWorkbook( new File( filename ));
				
				WritableSheet sheet = book.createSheet( sheetname , 0 );
				WritableCellFormat formater =new WritableCellFormat();
				formater.setAlignment(jxl.format.Alignment.CENTRE);		//设置单元格对齐方式；
				// 将定义好的单元格添加到工作表中
				
				for(int i=0;i<x.length;i++)	
					for(int j=0;j<x[0].length;j++)
					{
						jxl.write.Number number = new jxl.write.Number( j+column1 , i+row1 , x[i][j]);//第i行第j列				
						sheet.addCell(number);
					}
				
				
				// 写入数据并关闭文件
				book.write();
				book.close();
				System.out.println("OK!");
			}
		    catch (Exception e1)
		    {
			    System.out.println(e1);
		    }
		}
	}
	
}
