package com.jsite.szy.dispatch.emergency.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.jsite.szy.dispatch.emergency.model.ExeControl;
import com.jsite.szy.dispatch.emergency.model.ExeInput;

public class MovingAverage {
	/**
	 * 二维数组滑动
	 * @param srcData	源数组
	 * @param destData	结果数组
	 * @param movingLength 滑动长度
	 */
	public static void movingAverage(double[][] srcData,double[][] destData,int movingLength) {
		for (int i = 0; i < srcData.length; i++) {
			movingOneAverage(srcData[i], destData[i], 10);
		}
	}
	/**
	 * 一维数组滑动
	 * @param srcData
	 * @param destDate
	 * @param movingLength
	 */
	static void movingOneAverage(double[] srcData,double[] destDate,int movingLength) {
		int total=srcData.length;
		if (total<=movingLength) {
			return;
		}
		for (int i = 0; i < destDate.length; i++) {
			destDate[i]=movingAction(srcData, i, i+movingLength,movingLength);
		}
	}
	/**
	 * 
	 * @param srcData
	 * @param start    滑动开始位置
	 * @param end      滑动结束位置
	 * @param movingLength    滑动长度
	 * @return
	 */
	static double movingAction(double[] srcData,int start,int end,int movingLength) {
		double sum=0;
		int length=srcData.length;
		if (end>length) {
			end=length;
			start=end-movingLength;
		}
		for (int i = start; i < end; i++) {
			sum+=srcData[i];
		}
		return sum/movingLength;
	}
	
	static void BlackTool(ExeInput mExeInput,ExeControl mExeControl,int movingLength) {
		String path=mExeControl.get_outFilePath();
		int step=mExeInput.getLength()*3600/mExeControl.getStep_time();
		int crossNum=mExeControl.getSectionnum();
		int polutNum=mExeInput.getSolvendkinds();
		double[][] srcData=new double[polutNum][crossNum];
		double[][] destData=new double[polutNum][crossNum];
		double[][] tempt;
		String str = "";
		String s1 = "";
		for (int i = 0; i < step; i++) {
			tempt=mExeControl.Output(mExeInput, i+1);
			for (int j = 2; j < 2+polutNum; j++) {	//kinds
				for (int j2 = 0; j2 < crossNum; j2++) {	//cross
					srcData[j-2][j2]=tempt[j2][j];
				}
			}
			MovingAverage.movingAverage(srcData, destData, movingLength);
			str="";
			s1="";
			str=str.trim();
			s1=s1.trim();
			String filename = "time_step_" + (i+1) + ".txt";
			try {
				File f = new File(path + "/" + filename);
				BufferedReader input = new BufferedReader(new FileReader(f));
				// 断面溶质
				for (int i1 = 0; i1 < crossNum; i1++) {
					str = input.readLine();
					for (int j = 0; j < polutNum; j++) {
						if (polutNum==1) {
							s1+="  "+Double.toString(destData[j][i1]);
						}
						else {
							if(j==(polutNum-1))
								s1+=Double.toString(destData[j][i1]);
							else
								s1+=Double.toString(destData[j][i1])+"\t";
						}
					}
					s1+="\r\n";
				}
				for (int j = 0; j < crossNum+1; j++) {
					str=input.readLine();
					s1+=str+"\r\n";
				}
				str=input.readLine();
				s1+=str;
				input.close();
				BufferedWriter output = new BufferedWriter(new FileWriter(f));
				output.write(s1);
				output.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
