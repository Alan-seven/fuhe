package com.jsite.szy.dispatch.emergency.model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.midi.MidiChannel;

public class ExeControl {
	// 丁增加
	private double count;// 水力学模型调用次数
	private int num=0;
	/**
	 * 计算步长(s)
	 */
	private int step_time = 600;//600
	/**
	 * 亚时间步长(s)最大值10，最小值1
	 */
	private int sub__step_time=10;
	/**
	 * 水质步长(s)
	 */
	private int step_wtimg=100;
	/**
	 * 断面数
	 */
	private int sectionnum;
	/**
	 * 边界条件时刻点数
	 */
	private int boundary_timepointn;
	/**
	 * 计算步数
	 */
	private int step_n;
	/**
	 * 可运行exe相对于工程路径
	 */
	private String _exeFilePath;
	/**
	 * 输入文件夹路径
	 */
	private String _inFilePath;
	/**
	 * 输出文件夹路径
	 */
	private String _outFilePath;
	/**
	 * 工程编号
	 */
	private int _projn;
	/**
	 * 运行信息
	 */
	private String information;
	/**
	 * 计算区间总里程
	 */
	private double distsum;
	/**
	 * 程序进度
	 */
	private  double schedule;
	/**
	 * 溶质浓度单位转换系数:kg/m3 * trans= mg/L
	 */
	private double transtt=1000;
	/**
	 * 1D根目录
	 */
	private String root;
	/**
	 * 输出模式1:3600s,2:1800s,3:600s
	 */
	private int hn=3;
	
	/**
	 * 用户运行信息
	 */
	private String userId=null;

	DecimalFormat decimalFormat=new DecimalFormat("0.00");
	DecimalFormat pocessFormat=new DecimalFormat("0");
	public void set_exeFilePath(String exeFilePath) {
		this._exeFilePath = exeFilePath;
	}

	public String get_exeFilePath() {
		return _exeFilePath;
	}

	public void set_inFilePath(String inFilePath) {
		this._inFilePath = inFilePath;
	}

	public String get_inFilePath() {
		return _inFilePath;
	}

	public void set_outFilePath(String outFilePath) {
		this._outFilePath = outFilePath;
	}

	public String get_outFilePath() {
		return this._outFilePath;
	}

	public void set_step_time(int mystep_time) {
		this.setStep_time(mystep_time);
	}

	public int get_step_time() {
		return this.getStep_time();
	}
	/**
	 * 正则表达式判断是否为数字:正数
	 */
	Pattern pattern=Pattern.compile("[0-9]*");
	Matcher isNum;
	/**
	 * 
	 * @param up 计算上边界 小
	 * @param down 计算下边界 大
	 * @param mExeInput
	 * @throws InterruptedException
	 */
	public void RunExe(int up,int down, ExeInput mExeInput,ModelResult res) throws InterruptedException, IOException{
		//工程设置
		try{
		this.set_projn(mExeInput.getRiverCode(),mExeInput,res);//计算河段选择
		this.setSectionnum(mExeInput.getStates().length);//设置断面数
		this.InterpO(mExeInput,res);
		this.setStep_n(mExeInput.getLength()*3600/this.getStep_time());//计算步数
		this.set_calculate_conditions(up, down, mExeInput,res);//计算文件重置（前提：已赋值的mExeInput）
		this.setInformation("初始化完成！");
		//res.setInformation("初始化完成！");
		}catch (ArithmeticException e) {
			// TODO: handle exception
			//this.setInformation("错误！计算步长设置出错！");
			res.setInformation("错误！计算步长设置出错！");
		}catch(Exception e){
			res.setInformation("错误！计算河段选择出错！");
		}
		//res.setInformation("开始计算......");
		if (num == 0) {
			res.setInformation("开始水质模拟......");
		}
		else{
			res.setInformation("加大下泄后水质模拟......");
		}
		// 先清空输出文件夹
//		this.delAllFile(_outFilePath);
		this.delDirByCMD(_outFilePath);
		
		// 一个更好的方法
		try {
			String cmd =get_exeFilePath()+" "+getRoot()+getUserId()+"/";
			System.out.println("cmd= "+cmd);
			// 创建一个本机进程
			Process p = Runtime.getRuntime().exec(cmd);
			
			//输出交互
			BufferedInputStream in = new BufferedInputStream(p.getInputStream());
			BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			double temp;
			
			while ((lineStr = inBr.readLine()) != null){
				// 获得命令执行后在控制台的输出信息
				//判断是否为数字
				String temp1[]=lineStr.trim().split(" |\t");
				this.isNum=this.pattern.matcher(temp1[0]);
				if(isNum.matches()){//输出数字
					temp=Double.valueOf(lineStr);
					temp=temp/this.getStep_n();//程序运行进度
					res.setInformation("水力学计算中  进度："+pocessFormat.format(temp*100)+"%");
				}else{
					res.setInformation(lineStr);// 打印输出信息
				}
			}
				// 检查命令是否执行失败。
			if (p.waitFor() != 0) {
				if (p.exitValue() == 1)// p.exitValue()==0表示正常结束，1：非正常结束
					res.setInformation("错误！水动力计算出错!请检查！");
				else{
//					this.setInformation("水动力计算完成!");
				}
			}
			
			
			
			inBr.close();
			in.close();
				// 等待 Process 执行完毕再继续向下运行
				// p.waitFor();

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		num++;// 调用次数
	}
	

	/**
	 * 更新配置文件
	 * 
	 * @param myInput
	 */
	public void Update_iniFile(ExeInput myInput,ModelResult res) {
		int length = myInput.getLength();// 计算总时长 单位：h
		int steplength = this.getStep_time();// 步长 600s
		int pnum = myInput.getpnum(); // 点源个数
		String priver[] = myInput.getpriver();// 点源所在河流
		double plength[] = myInput.getplength();// 点源里程
		int solvendkinds=myInput.getSolvendkinds();//溶质种类
		int solvendn[] = myInput.getsolvendn();// 溶质入流点源数
		String solvendq[][] = myInput.getsolvendq();//溶质入流点源编号

		String s1 = new String();// 内容更新
		String filename = "fuheprojectset.txt";// 文件名称
		try {
			File f = new File(_inFilePath + "/" + filename);
			if (f.exists()) {
				// this.setInformation("文件存在");
			} else {
				res.setInformation("错误！文件fuheprojectset.txt不存在");
				f.createNewFile();//  不存在则创建
			}
			BufferedReader input = new BufferedReader(new FileReader(f));
			this.step_n = length * 60 * 60 / steplength;
			s1 += length * 60 * 60 / steplength + "\t" + steplength + "\t" + myInput.getR() + "\r\n";// 第一行
																								// 计算时间步数
																								// 步长
																								// 糙率
																								// 600
																								// 600
																								// 0.033
			s1 += pnum + "\r\n"; // 第二行 点源个数
			for (int i = 0; i < pnum; i++) {// 第三行开始写入点源信息
				s1 += priver[i] + "\t" + plength[i] + "\r\n"; // 1 42；点源i所在河流
																// 点源i里程
			}
			s1 += solvendkinds + "\r\n";// 溶质种类
			s1+=getSub__step_time()+ "\r\n";//亚时间步数
			for (int i = 0; i < solvendq.length; i++) {
				s1 += solvendn[i] + "\r\n";// 溶质i入流的点源个数
				s1 += myInput.getA()[i] + "\t" + myInput.getK()[i] + "\r\n";// 扩散系数，降解系数，水质步长
				for (int k = 0; k < solvendn[i]; k++) {
					s1 += solvendq[i][k] + "\t"; // 溶质i入流点源编号
				}
				s1 += "\r\n";
			}
			input.close();
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Update_InitCon(ExeInput myInput) {
		
		int pnum=this.getSectionnum();//断面数
		int solvn=myInput.getSolvendkinds();//溶质种类
		String s1 = new String();// 内容更新
		String filename = "fuheinitcon.txt";// 文件名称
		try {
			File f = new File(_inFilePath + "/" + filename);
			if (f.exists()) {
				// this.setInformation("文件存在");
			} else {
				//this.setInformation("错误！文件fuheinitcon.txt不存在");
				f.createNewFile();//  不存在则创建
			}
			for (int i = 0; i < pnum; i++) {
				for (int j = 0; j < solvn; j++) {
					s1 +=myInput.getStates()[i].getInitialCon()[j]+ "\t";
				}
				s1+="\r\n";
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新下边界水位流量关系
	 * @param myInput
	 */
	public void Update_Stagedischarge(ExeInput myInput,ModelResult res) {
		int stagepn=myInput.getStagepn();
		double stagep[][]=myInput.getStagep();
		if(stagepn!=stagep[0].length){
			res.setInformation("错误！水位流量关系输入错误！"+stagep.length);
		}
		
		String s1 = new String();// 内容更新
		String filename = "fuhestagedischarge.txt";// 文件名称
		try {
			File f = new File(_inFilePath + "/" + filename);
			if (f.exists()) {
				// this.setInformation("文件存在");
			} else {
				res.setInformation("错误！文件fuhestagedischarge.txt不存在");
				f.createNewFile();//  不存在则创建
			}
			BufferedReader input = new BufferedReader(new FileReader(f));
			s1 +=  stagepn+ "\r\n";// 第一行
			for (int i = 0; i < stagep[0].length; i++) {
				s1+=stagep[0][i]+"\t"+stagep[1][i]+"\r\n";
			}
			input.close();
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Update_Rrivernet(ExeInput myInput,ModelResult res) {
		int upboundarytype=0;//上边界条件类型0：流量
		int lowboundarytype;//下边界条件类型-1：水位，-2：水位流量关系曲线
		if(myInput.isStagedischarge()){//true水位流量关系
			lowboundarytype=-2;
		}
		else{
			lowboundarytype=-1;//false水位
		}
		String s1 = new String();// 内容更新
		String filename = "fuherivernet.txt";// 文件名称
		try {
			File f = new File(_inFilePath + "/" + filename);
			if (f.exists()) {
				// this.setInformation("文件存在");
			} else {
				res.setInformation("错误！文件fuheprojectset.txt不存在");
				f.createNewFile();//  不存在则创建
			}
			BufferedReader input = new BufferedReader(new FileReader(f));
			s1 +=  upboundarytype+"\t"+lowboundarytype+ "\r\n";// 第一行
			input.close();
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新点源时序文件
	 * 
	 * @param myInput
	 */
	public void Update_PointSourceTimeSiry(ExeInput myInput,ModelResult res) {
		int deltaT = myInput.getDeltaT();// 时段长度（时间间隔）1h
		int length = myInput.getLength();// 计算时长单位：h
		int pnum = myInput.getpnum(); // 点源个数
		int tnum = myInput.gettnum(); // 时序点数
		double tlength[] = myInput.gettlength();// 时刻点（距起始时刻秒数）
		double qtemp1[][] = myInput.getpointQ();// 点源时序流量(m3/s)

		String str = new String(); // 原有txt内容  
		String s1 = new String();// 内容更新
		String filename = "pointsourcetimesiry.txt";// 文件名称
		try {
			File f = new File(_inFilePath + "/" + filename);
			if (f.exists()) {
				// System.out.println("文件存在");
			} else {
				res.setInformation("错误！文件pointsourcetimesiry.txt不存在");
				f.createNewFile();//  不存在则创建
			}
			BufferedReader input = new BufferedReader(new FileReader(f));
			s1 += tnum + "\r\n";// 第一行 时序点数
			for (int i = 0; i < tnum; i++) {// 第二行开始写入点源时序信息
				s1 += tlength[i] / this.getStep_time() + "\t";// 0 200 100 50
																// ；时刻
																// 点源1流量（m3/s）
																// 点源2流量（m3/s）
																// 点源3流量（m3/s）
				for (int j = 0; j < pnum; j++) {
					s1 += qtemp1[j][i] + "\t";
				}
				s1 += "\r\n";
			}
			input.close();
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新边界文件
	 * 
	 * @param myInput
	 */
	public void Update_BoundaryCondition(ExeInput myInput,ModelResult res) {
		int deltaT = myInput.getDeltaT();// 时段长度（时间间隔）1h
		int length = myInput.getLength();// 单位：h
		int tnum = myInput.gettnum(); // 时序点数
		double tlength[] = myInput.gettlength();// 时刻点（距起始时刻秒数）
		double upboundary[] = myInput.getupboundary();// 流量上边界时序(m3/s)
		double lowboundary[] = myInput.getlowboundary();// 水位下边界时序(m)

		String s1 = new String();// 内容更新
		String filename = "boundarycondition.txt";// 文件名称
		try {
			File f = new File(_inFilePath + "/" + filename);
			if (f.exists()) {
				// System.out.println("文件存在");
			} else {
				res.setInformation("错误！文件boundarycondition.txt不存在");
				f.createNewFile();//  不存在则创建
			}
			BufferedReader input = new BufferedReader(new FileReader(f));
			s1 += tnum + "\r\n";// 第一行 时序点数
			if(!myInput.isStagedischarge()){
			for (int i = 0; i < tnum; i++) {// 第二行开始写入边界时序信息
				s1 += tlength[i] / this.getStep_time() + "\t" + upboundary[i] + "\t" + lowboundary[i] + "\r\n";// 0
																												// 400
																												// 35
																												// ；时刻
																												// 流量上边界（m3/s）
																												// 水位下边界（m）
			}
			}
			else{
				for (int i = 0; i < tnum; i++) {// 第二行开始写入边界时序信息
					s1 += tlength[i] / this.getStep_time() + "\t" + upboundary[i] + "\r\n";// 0
																													// 400
																													// 35
																													// ；时刻
																													// 流量上边界（m3/s）
																													// 水位下边界（m）
				}
			}
			input.close();
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新溶质入流时序文件
	 * 
	 * @param myInputOutput
	 */
	public void Update_Solvendtimesiry(ExeInput myInputOutput,ModelResult res) {
		int deltaT = myInputOutput.getDeltaT();// 时段长度（时间间隔）1h
		int length = myInputOutput.getLength();// 单位：h
		int tnum = myInputOutput.gettnum(); // 时序点数
		double tlength[] = myInputOutput.gettlength();// 时刻点（距起始时刻秒数）
		
		int solvendn[] = myInputOutput.getsolvendn();// 溶质入流点源数
		String solvendq[][] = myInputOutput.getsolvendq();// 溶质入流点源编号
		double solvendtimesity[][][] = myInputOutput.getsolvendtimesity();// 溶质入流时序数据，矩阵=点源数*时序点
		
		
		String str = new String(); // 原有txt内容  
		String s1 = new String();// 内容更新
		String filename = "solvendtimesiry.txt";// 文件名称
		try {
			File f = new File(_inFilePath + "/" + filename);
			if (f.exists()) {
				// System.out.println("文件存在");
			} else {
				res.setInformation("错误！文件solvendtimesiry.txt不存在");
				f.createNewFile();//  不存在则创建
			}
			BufferedReader input = new BufferedReader(new FileReader(f));
			// while ((str = input.readLine()) != null) { //按行读取txt
			// s1 += str + "\n";
			// }
			s1 += tnum + "\r\n";// 第一行 时序点数
			for (int i = 0; i < tnum; i++) {// 第二行开始写入 有溶质流入点源时序信息
				s1 += tlength[i] / this.getStep_time() + "\t";//
				for (int j2 = 0; j2 < solvendtimesity.length; j2++) {
					for (int j = 0; j < solvendn[j2]; j++) {
						s1 += solvendtimesity[j2][j][i]/transtt + "\t";
					}
				}
				s1 += "\r\n";
			}
			input.close();
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 提取距离开始计算时间time时刻的结果文件
	 * 
	 * @param time step_time=600s
	 *            
	 * @return
	 */
	public double[][] Output(ExeInput myInputOutput, int t) {
		int solvendkinds=myInputOutput.getSolvendkinds();//溶质种类
		int time = t; // 输出时刻
		if (time > myInputOutput.getLength()*3600/this.getStep_time()) {
			return null;
		}

		double resoult[][] = new double[this.getSectionnum()][3+solvendkinds];// 水位，流量，溶质1浓度，溶质2...，流速

		String str = new String(); // 原有txt内容
		String s1 = new String();// 内容更新
		int n = 0;// 下标记录
		String temp[];
		String filename = "time_step_" + time + ".txt";// 文件名称
		try {
			File f = new File(_outFilePath + "/" + filename);
			//将exe的输出在exerun中导入到eclipse控制台后，java程序会等待exe运行再执行下一步
			//如果不导出，则java调用exe执行的同时，会执行exe后面的java程序，造成文件的访问冲突和时间混乱
//			while (true) {// 等待exe程序生成文件
//				if (f.exists()) {
//					Thread.sleep(100);
//					break;
//				} else {
//					this.setInformation("文件" + f + "不存在");
//				}
//
//			}
			BufferedReader input = new BufferedReader(new FileReader(f));
			// 断面溶质
			for (int i = 0; i < this.getSectionnum(); i++) {
				str = input.readLine();
				s1 += str + "\r\n";
				temp = str.trim().split(" |\t");
				String temp1[] = new String[20];
				for (int sj = 0, si = 0; sj < temp.length; sj++) {// temp重组
					if (temp[sj].trim().isEmpty())
						continue;
					temp1[si] = temp[sj];
					si++;
				}
				/*if(temp1.length!=solvendkinds)
					this.setInformation("溶质解析错误，请核对溶质个数！");*/
				for (int j = 0; j < solvendkinds; j++) {
					if (!temp1[j].trim().isEmpty()) {
						resoult[i][2+j] = Double.parseDouble(temp1[j]);// 溶质浓度
						break;
					}
				}
			}
			str = input.readLine();// 上游入流量
			s1 += str + "\r\n";
			while (((str = input.readLine()) != null) && (n < this.getSectionnum())) { // 按行读取txt
				s1 += str + "\r\n";
				temp = str.trim().split(" |\t");// 字符串拆分
				String temp1[] = new String[20];
				for (int sj = 0, i = 0; sj < temp.length; sj++) {// temp重组
					if (temp[sj].trim().isEmpty())
						continue;
					temp1[i] = temp[sj];
					i++;
				}
				resoult[n][0] = Double.parseDouble(temp1[0]);// 水位
				resoult[n][1] = Double.parseDouble(temp1[1]);// 流量
				resoult[n][2+solvendkinds]=Double.parseDouble(temp1[6]);//流速
				n++;
			}
			s1 += str;// 最后一行
			input.close();
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resoult;
	}

	/**
	 * 
	 * @param myInputOutput
	 * @param myOutput
	 * @param targ
	 *            第targ个断面
	 * @return
	 */
	public double[][] OutputPoint(ExeInput myInputOutput, ExeOutput myOutput, int targ) {
		double time = myOutput.getdelt(); // 输出时间间隔
		if (time > myInputOutput.getLength()) {
			return null;
		}
		if (targ > this.getSectionnum()) {// 判断断面数正确
			return null;
		}

		// 构造输出时序
		int outtime[] = new int[(int) (myInputOutput.getLength() / myOutput.getdelt())];// 时刻数
		for (int i = 0; i < outtime.length; i++) {
			outtime[i] = (int) (time * 3600 / this.getStep_time()) * (i + 1);
		}

		double resoult[][] = new double[outtime.length][3];// 时序对应的：水位，流量，溶质浓度

		String str = new String(); // 原有txt内容  
		String s1 = new String();// 内容更新
		String temp[];

		for (int i = 0; i < outtime.length; i++) {
			String filename = "time_step_" + outtime[i] + ".txt";// 文件名称
			try {
				File f = new File(_outFilePath + "/" + filename);
				while (true) {// 等待exe程序生成文件
					if (f.exists()) {
						break;
					} else {
						// System.out.println("文件"+f+"不存在");
					}

				}
				// if (f.exists()) {
				// System.out.println("文件存在");
				// System.out.println(outtime[i]);
				// }
				// else {
				// System.out.println("文件不存在");
				// f.createNewFile();// 不存在则创建
				// }
				s1 = "";
				BufferedReader input = new BufferedReader(new FileReader(f));
				for (int j = 1; j < targ; j++) {// 吃掉不需要的行
					str = input.readLine();
					s1 += str + "\r\n";
				}
				str = input.readLine();// 溶质
				s1 += str + "\r\n";
				temp = str.trim().split(" |\t");
				for (int j = 0; j < temp.length; j++) {
					if (!temp[j].trim().isEmpty()) {
						resoult[i][2] = Double.parseDouble(temp[j]);
						break;
					}
				}
				for (int j = targ; j < this.sectionnum; j++) {
					str = input.readLine();// 吃掉剩余溶质
					s1 += str + "\r\n";
				}
				str = input.readLine();// 上游入流量
				s1 += str + "\r\n";
				for (int j = 1; j < targ; j++) {
					str = input.readLine();// 吃掉不需要的行
					s1 += str + "\r\n";
				}
				str = input.readLine();// 当前行
				s1 += str + "\r\n";
				temp = str.trim().split(" |\t");// 字符串拆分
				String temp1[] = new String[20];
				for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
					if (temp[sj].trim().isEmpty())
						continue; // 跳过空格
					temp1[ii] = temp[sj];
					ii++;
				}
				resoult[i][0] = Double.parseDouble(temp1[0]);// 水位
				resoult[i][1] = Double.parseDouble(temp1[1]);// 流量
				// resoult[i][2]=Double.parseDouble(temp1[2]);//-----------------------------浓度
				// s1+=tnum+"\r\n";//第一行 时序点数
				// for(int i=0;i<tnum;i++){//第二行开始写入点源时序信息
				// s1+=tlength[i]+"\t"+upboundary[i]+"\t"+lowboundary[i]+"\r\n";//0
				// 400 35 ；时刻 流量上边界（m3/s） 水位下边界（m）
				// }
				// 读剩余行
				while ((str = input.readLine()) != null) {
					s1 += str + "\r\n";
				}
				// System.out.println(s1);
				input.close();
				BufferedWriter output = new BufferedWriter(new FileWriter(f));
				output.write(s1);
				output.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resoult;

	}

	public ExeControl() {
		// TODO Auto-generated constructor stub
	}

	public int getSectionnum() {
		return sectionnum;
	}

	public void setSectionnum(int sectionnum) {
		this.sectionnum = sectionnum;
	}

	public boolean delAllFile(String path,ModelResult res) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				// delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
				// delFolder(path + "/" + tempList[i]);//再删除空文件夹
				//              flag = true;
			}
			//res.setInformation("删除第"+i+"个文件");
		}
		return flag;
	}
	
	public boolean delDirByCMD(String path) throws IOException, InterruptedException {
		File file = new File(path);
		if (file.isDirectory()) {
			String cmd = "cmd /c rd /s/q " + path.replace("/", "\\");
			Runtime.getRuntime().exec(cmd);
			System.out.println("delete");
		}
		try {
			String cmd = "cmd /c md " + path.replace("/", "\\");
			Process process = Runtime.getRuntime().exec(cmd);
			System.out.println("create2");
		} catch (SecurityException e) {
			// TODO: handle exception

		}
		return true;
	}

	/**
	 * 文件夹替换 用old替换new
	 * 
	 * @param oldPath
	 * @param newPath
	 * @throws IOException
	 */
	public void copyDir(String oldPath, String newPath,ModelResult res) throws IOException {
		File file = new File(oldPath);
		String[] filePath = file.list();
		if (!(new File(newPath)).exists()) {
			(new File(newPath)).mkdir();
		}
		// cmd实现
		final Runtime runtime1 = Runtime.getRuntime();
		try {
			String cmdstr = "xcopy " + oldPath.replace('/', '\\') + " " + newPath.replace('/', '\\');// 命令行格式调整
			final Process process=runtime1.exec(cmdstr);
			try{
				process.waitFor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block  
					e.printStackTrace();
					}
		} catch (final Exception e) {
			res.setInformation("获取工程文件失败!");
		}
		// 字节流实现
		// for (int i = 0; i < filePath.length; i++) {
		// if ((new File(oldPath + file.separator + filePath[i])).isDirectory())
		// {
		// copyDir(oldPath + file.separator + filePath[i], newPath +
		// file.separator + filePath[i]);
		// }
		// if (new File(oldPath + file.separator + filePath[i]).isFile()) {
		// //copyFile(oldPath + file.separator + filePath[i], newPath +
		// file.separator + filePath[i]);
		// }
		// }
	}

	/**
	 * 文件替换
	 * 
	 * @param oldPath
	 * @param newPath
	 * @throws IOException
	 */
	public static void copyFile(String oldPath, String newPath) throws IOException {
		File oldFile = new File(oldPath);
		File file = new File(newPath);
		FileInputStream in = new FileInputStream(oldFile);
		FileOutputStream out = new FileOutputStream(file);
		;

		byte[] buffer = new byte[2097152];

		while ((in.read(buffer)) != -1) {
			out.write(buffer);
		}
		in.close();
		out.close();

	}

	public int get_projn() {
		return _projn;
	}
	
	public void set_projn(int _projn,ExeInput mExeInput,ModelResult res) throws IOException, InterruptedException {
		this.setInformation("正在初始化......");
		if (_projn < 1 || _projn > 6) {
			this.setInformation("错误！工程编号设置错误！");
		}
		this._projn = _projn;
		this.InterpLevel(mExeInput,res);//初始水位流量插值
		// 清空输入文件夹
		this.delAllFile(_inFilePath,res);
		
		// 重建输入文件夹--20171213改了这里
		String projpath = getRoot()+"projs/proj" + _projn + "/in";
		System.out.println("proj_path= "+projpath);
		copyDir(projpath, _inFilePath,res);
	}

	public boolean setOutControlState(ControlState myOutControlState[], ExeInput myExeInput,ModelResult res) {
		boolean resoult = false;
		int hn=this.getHn();//输出模式，1:3600s,2:1800s,3:600s
		int hncontrol=0;
		switch (hn) {
		case 1:
			hncontrol=6;
			break;
		case 2:
			hncontrol=3;
			break;
		default:
			hncontrol=1;
			break;
		}
		int solvendkinds=myExeInput.getSolvendkinds();//溶质种类
		if (myOutControlState.length != this.sectionnum) {
			res.setInformation("错误！断面数量不匹配");
			return false;
		}
		double temp[][][] = new double[myExeInput.getLength()*(int)(3600/this.get_step_time())/hncontrol][myOutControlState.length][3+solvendkinds];// 每时刻的结果
		double trans[][][] = new double[myOutControlState.length][myExeInput.getLength()*(int)(3600/this.get_step_time())/hncontrol][3+solvendkinds];// 存储转化
		for (int i = 0; i < myExeInput.getLength()*(int)(3600/this.get_step_time())/hncontrol; i++) {// 计算总时长
			temp[i] = this.Output(myExeInput, i*hncontrol + 1);
			res.setInformation("正在解析计算结果  进度:" + pocessFormat.format(Double.valueOf(i)/(myExeInput.getLength()*3600/this.get_step_time())*hncontrol*100)+"%");
		}
		res.setInformation("计算结果解析完成!");
		for (int i = 0; i < trans.length; i++) {
			for (int j = 0; j < trans[i].length; j++) {
				for (int j2 = 0; j2 < trans[i][j].length; j2++) {
					trans[i][j][j2] = temp[j][i][j2];
				}
				/*trans[i][j][0] = temp[j][i][0];
				trans[i][j][1] = temp[j][i][1];
				trans[i][j][2] = temp[j][i][2];
				trans[i][j][3] = temp[j][i][3];*/
			}
		}
		double trans0[] = new double[myExeInput.getLength()*(int)(3600/this.get_step_time())/hncontrol];
		double trans1[] = new double[myExeInput.getLength()*(int)(3600/this.get_step_time())/hncontrol];
		double trans2[][] = new double[solvendkinds][myExeInput.getLength()*(int)(3600/this.get_step_time())/hncontrol];
		double trans3[] = new double[myExeInput.getLength()*(int)(3600/this.get_step_time())/hncontrol];
		for (int j = 0; j < myOutControlState.length; j++) {// 断面数
			for (int i = 0; i < trans0.length; i++) {
				trans0[i] = Double.valueOf(decimalFormat.format(trans[j][i][0]));
				trans1[i] = Double.valueOf(decimalFormat.format(trans[j][i][1]));
				for (int k = 0; k < solvendkinds; k++) {
					trans2[k][i] = trans[j][i][2+k]*this.transtt;
				}
				trans3[i] = Double.valueOf(decimalFormat.format(trans[j][i][2+solvendkinds]));
			}
			myOutControlState[j].setLevel(trans0);
			myOutControlState[j].setOutFlow(trans1);
			myOutControlState[j].setConcentration(trans2[0]);
			myOutControlState[j].setWaterSpeed(trans3);
		}
		return resoult;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
		//System.out.println(information);
	}

	/**
	 * 重建断面文件
	 * 
	 * @param up
	 *            上边界断面编号 小
	 * @param down
	 *            下边界断面编号 大
	 * @throws InterruptedException 
	 */
	public void Update_crosssection(int up, int down,ExeInput mExeInput,ModelResult res) throws InterruptedException {
		String str = new String(); // 原有txt内容
		String s1 = new String();// 内容更新
		String temp[];
		String temp1[] = new String[100];
		int nsectionsum = down - up + 1;// 新断面总数
		double ndist = 0;// 新断面里程变量
		int oldsectionsum;// 原有断面数

		String filename = "fuhecrosssection.txt";// 文件名称
		
		try {
			File f = new File(_inFilePath + "/" + filename);
			if(!f.exists()){
				System.out.println(f.toString());
				res.setInformation("错误！断面地形文件不存在，请检查！");
			}
			BufferedReader input=new BufferedReader(new FileReader(f));
			// 第一行
			str = input.readLine();// 1 8 fuhe 工程河流总数 工程河流总断面数 工程河流名称
			temp = str.trim().split(" |\t");// 解析河流信息
			for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
				if (temp[sj].trim().isEmpty())
					continue; // 跳过空格
				temp1[ii] = temp[sj];
				ii++;
			}
			oldsectionsum=Integer.parseInt(temp1[1]);//
			s1 += temp1[0] + "\t" + nsectionsum + "\t" + temp1[2] + "\r\n";
			// 第二行
			str = input.readLine();// 1 fuhe 8 河流编号 河流名称 河流断面总数
			temp = str.trim().split(" |\t");// 解析河流信息
			for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
				if (temp[sj].trim().isEmpty())
					continue; // 跳过空格
				temp1[ii] = temp[sj];
				ii++;
			}
			s1 += temp1[0] + "\t" + temp1[1] + "\t" + nsectionsum + "\r\n";

//			this.setSectionnum(nsectionsum);// 更新断面数

			int ni = 1;// 新断面编号
			// 第三行之后，按断面循环
			for (int i = 0; i < oldsectionsum; i++) {
				double pointn = 0;// 当前断面坐标点数
				// 前三行为信息行1
				str = input.readLine();// 1 cs 1 1-1 河流编号 xx 断面编号 断面名称
				temp = str.trim().split(" |\t");
				for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
					if (temp[sj].trim().isEmpty())
						continue; // 跳过空格
					temp1[ii] = temp[sj];
					ii++;
				}
				if (i >= (up - 1) && i <down) {// 所选断面
					s1 += temp1[0] + "\t" + temp1[1] + "\t" + ni + "\t" + temp1[3] + "\r\n";
					
					// 2
					str = input.readLine();// 300 41.3 41.3 断面坐标点数 距离上一个断面距离 里程
					temp = str.trim().split(" |\t");
					for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
						if (temp[sj].trim().isEmpty())
							continue; // 跳过空格
						temp1[ii] = temp[sj];
						ii++;
					}
					if (i == (up - 1)) { // 第一个断面设置
						temp1[1] = String.valueOf(0);
						temp1[2] = String.valueOf(0);
						ndist = 0;
					} else {
						ndist += Double.parseDouble(temp1[1]);// 里程更新
					}
					pointn = Integer.parseInt(temp1[0]);
					s1 += temp1[0] + "\t" + temp1[1] + "\t" + decimalFormat.format(ndist) + "\r\n";
					// 3
					str = input.readLine();// 37 600 .00 .0 .0 断面水位 断面流量 x x x------------------可提供初始值得输入
					temp = str.trim().split(" |\t");
					for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
						if (temp[sj].trim().isEmpty())
							continue; // 跳过空格
						temp1[ii] = temp[sj];
						ii++;
					}
					s1 += temp1[0]+"\t"+ decimalFormat.format(mExeInput.getStates()[ni-1].getInitialQ())+"\t"+".00	.0	.0"+ "\r\n";
					ni++;
				}
				else {
					str = input.readLine();
					temp = str.trim().split(" |\t");
					for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
						if (temp[sj].trim().isEmpty())
							continue; // 跳过空格
						temp1[ii] = temp[sj];
						ii++;
					}
					pointn = Integer.parseInt(temp1[0]);
					str = input.readLine();
				}
				// 断面坐标点，标准为一行十个数，x，z分开

				for (int j = 0; j < 2 * Math.ceil(pointn / 10.0); j++) {
					str = input.readLine();
					if (i >= (up - 1) && i <down) {// 所选断面
						s1 += str + "\r\n";
					}
				}
			}
			this.distsum = ndist;
			input.close();
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
			if(!f.renameTo(f)){
				res.setInformation("错误！文件fuhecrosssection.txt正在被其他程序操作！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Update_crosssection1(int up, int down,ExeInput mExeInput,ModelResult res) throws InterruptedException {
		String str = new String(); // 原有txt内容
		String s1 = new String();// 内容更新
		String temp[];
		String temp1[] = new String[100];
		int nsectionsum = down - up + 1;// 新断面总数
		double ndist = 0;// 新断面里程变量
		int oldsectionsum;// 原有断面数

		String filename = "fuhecrosssection.txt";// 文件名称
		
		try {
			File f = new File(_inFilePath + "/" + filename);
			if(!f.exists()){
				this.setInformation("错误！断面地形文件不存在，请检查！");
			}
			BufferedReader input=new BufferedReader(new FileReader(f));
			// 第一行
			str = input.readLine();// 1 8 fuhe 工程河流总数 工程河流总断面数 工程河流名称
			temp = str.trim().split(" |\t");// 解析河流信息
			for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
				if (temp[sj].trim().isEmpty())
					continue; // 跳过空格
				temp1[ii] = temp[sj];
				ii++;
			}
			oldsectionsum=Integer.parseInt(temp1[1]);//
			s1 += temp1[0] + "\t" + nsectionsum + "\t" + temp1[2] + "\r\n";
			// 第二行
			str = input.readLine();// 1 fuhe 8 河流编号 河流名称 河流断面总数
			temp = str.trim().split(" |\t");// 解析河流信息
			for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
				if (temp[sj].trim().isEmpty())
					continue; // 跳过空格
				temp1[ii] = temp[sj];
				ii++;
			}
			s1 += temp1[0] + "\t" + temp1[1] + "\t" + nsectionsum + "\r\n";

//			this.setSectionnum(nsectionsum);// 更新断面数

			int ni = 1;// 新断面编号
			// 第三行之后，按断面循环
			for (int i = 0; i < oldsectionsum; i++) {
				double pointn = 0;// 当前断面坐标点数
				// 前三行为信息行1
				str = input.readLine();// 1 cs 1 1-1 河流编号 xx 断面编号 断面名称
				temp = str.trim().split(" |\t");
				for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
					if (temp[sj].trim().isEmpty())
						continue; // 跳过空格
					temp1[ii] = temp[sj];
					ii++;
				}
				if (i >= (up - 1) && i <down) {// 所选断面
					s1 += temp1[0] + "\t" + temp1[1] + "\t" + ni + "\t" + temp1[3] + "\r\n";
					
					// 2
					str = input.readLine();// 300 41.3 41.3 断面坐标点数 距离上一个断面距离 里程
					temp = str.trim().split(" |\t");
					for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
						if (temp[sj].trim().isEmpty())
							continue; // 跳过空格
						temp1[ii] = temp[sj];
						ii++;
					}
					if (i == (up - 1)) { // 第一个断面设置
						temp1[1] = String.valueOf(0);
						temp1[2] = String.valueOf(0);
						ndist = 0;
					} else {
						ndist += Double.parseDouble(temp1[1]);// 里程更新
					}
					pointn = Integer.parseInt(temp1[0]);
					s1 += temp1[0] + "\t" + temp1[1] + "\t" + decimalFormat.format(ndist) + "\r\n";
					// 3
					str = input.readLine();// 37 600 .00 .0 .0 断面水位 断面流量 x x x------------------可提供初始值得输入
					temp = str.trim().split(" |\t");
					for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
						if (temp[sj].trim().isEmpty())
							continue; // 跳过空格
						temp1[ii] = temp[sj];
						ii++;
					}
					s1 += temp1[0]+"\t"+ decimalFormat.format(mExeInput.getStates()[ni-1].getInitialQ())+"\t"+".00	.0	.0"+ "\r\n";
					ni++;
				}
				else {
					str = input.readLine();
					temp = str.trim().split(" |\t");
					for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
						if (temp[sj].trim().isEmpty())
							continue; // 跳过空格
						temp1[ii] = temp[sj];
						ii++;
					}
					pointn = Integer.parseInt(temp1[0]);
					str = input.readLine();
				}
				// 断面坐标点，标准为一行十个数，x，z分开

				for (int j = 0; j < 2 * Math.ceil(pointn / 10.0); j++) {
					str = input.readLine();
					if (i >= (up - 1) && i <down) {// 所选断面
						s1 += str + "\r\n";
					}
				}
			}
			this.distsum = ndist;
			input.close();
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
			if(!f.renameTo(f)){
				this.setInformation("错误！文件fuhecrosssection.txt正在被其他程序操作！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置计算条件，并检查条件
	 * 
	 * @param up
	 *            计算上边界 编号小
	 * @param down
	 *            计算下边界 编号大
	 * @param mExeInput
	 * @throws InterruptedException 
	 */
	public void set_calculate_conditions(int up, int down, ExeInput mExeInput,ModelResult res) throws InterruptedException {
		//exeInput条件判断
		double a[]=mExeInput.getA();//扩散系数
		double k[]=mExeInput.getK();//降解系数
		double r=mExeInput.getR();//糙率
		if((mExeInput.getSolvendkinds()!=mExeInput.getA().length)||(mExeInput.getSolvendkinds()!=mExeInput.getK().length))
			res.setInformation("错误！扩散系数或降解系数与溶质种类不匹配，请检查");
		for (int i = 0; i < k.length; i++) {
			if (a[i] < 0 || a[i] > 1) {
				res.setInformation("错误！扩散系数超出范围，请检查！");
			}
			if (k[i] < 0 || k[i] > 1) {
				res.setInformation("错误！衰减系数超出范围，请检查！");
			}
/*			if (r < 0 || r > 1) {
				this.setInformation("糙率超出范围，请检查！");
			}*/
		}
		// 重建配置文件
		Update_iniFile(mExeInput,res);
		double plength[] = mExeInput.getplength();// 点源里程
		
		// 重建断面文件
		Update_crosssection(up, down,mExeInput,res);
		double max = plength[0];
		for (int i = 1; i < plength.length; i++) {
			if (plength[i] > max) {
				max = plength[i];
			}
		}
		if (max > this.distsum) {
			res.setInformation("错误！点源里程超过计算区间总里程！");
		}

		// 重建边界条件
		Update_BoundaryCondition(mExeInput,res);

		// 重建点源时序文件
		Update_PointSourceTimeSiry(mExeInput,res);

		// 重建溶质入流文件
		Update_Solvendtimesiry(mExeInput,res);
		//重建河流结构文件
		Update_Rrivernet(mExeInput,res);
		//
		//重建下边界水位流量关系
		if(mExeInput.isStagedischarge()){
			Update_Stagedischarge(mExeInput,res);
		}
		//更新初始浓度文件
		Update_InitCon(mExeInput);


	}
	/**
	 * 水位初始化
	 * @param mExeInput
	 */
	
	public void InterpLevel(ExeInput mExeInput,ModelResult res) {
		
		//按断面形状计算初始水位
		String str = new String(); // 原有txt内容
		String s1 = new String();// 内容更新
		String tempst=new String();//每个断面块
		String tempst2=new String();//断面块处理
		String temp[];
		String temp1[] = new String[100];
		int oldsectionsum=1;// 原有断面数
		int nxy=0;//断面坐标对数
		String filename = "fuhecrosssection.txt";// 文件名称
		
		try {
			File f = new File(root+ "projs/proj"+_projn+ "/" +"in/"+ filename);//修改proj中断面
			if(!f.exists()){
				System.out.println("水位处  文件路径="+f.toString());
				res.setInformation("错误！断面地形文件不存在，请检查！");
			}
			BufferedReader input=new BufferedReader(new FileReader(f));
			//前两行
			//1 包含断面数
			s1=input.readLine();
			str+=s1+"\r\n";
			temp = s1.trim().split(" |\t");// 解析
			for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
				if (temp[sj].trim().isEmpty())
					continue; // 跳过空格
				temp1[ii] = temp[sj];
				ii++;
			}
			oldsectionsum=Integer.parseInt(temp1[1]);//断面数
			double initL[]=new double[oldsectionsum];//初始水位
			//2
			s1=input.readLine();
			str+=s1+"\r\n";
			//断面循环
			for (int i = 0; i < oldsectionsum; i++) {
				tempst="";//初始化断面块
				tempst2="";
				double mean=0;//高程均值
				//1
				s1=input.readLine();
				tempst+=s1+"\r\n";
//				str+=s1+"\r\n";
				//2 包含坐标点数
				s1=input.readLine();
				tempst+=s1+"\r\n";
//				str+=s1+"\r\n";
				temp = s1.trim().split(" |\t");// 解析
				for (int sj = 0, ii = 0; sj < temp.length; sj++) {// temp重组
					if (temp[sj].trim().isEmpty())
						continue; // 跳过空格
					temp1[ii] = temp[sj];
					ii++;
				}
				nxy=Integer.parseInt(temp1[0]);//
				//3
				s1=input.readLine();
				tempst+=s1+"\r\n";
				//x
				for (int j = 0; j <Math.ceil(nxy / 10.0); j++) {
					s1=input.readLine();
					tempst+=s1+"\r\n";
				}
				//z
				for (int j = 0; j <Math.ceil(nxy / 10.0); j++) {
					s1=input.readLine();
					tempst+=s1+"\r\n";
//					str+=s1+"\r\n";
					temp = s1.trim().split(" |\t");// 解析
					int ii=0,sj=0;
					for (; sj < temp.length; sj++) {// temp重组
						if (temp[sj].trim().isEmpty())
							continue; // 跳过空格
						temp1[ii] = temp[sj];
						ii++;
					}
					for (int j2 = 0; j2 < ii; j2++) {
						mean+=Double.parseDouble(temp1[j2]);
					}
				}
				initL[i]=mean/nxy;
				//更新初始水位，重组断面块
				String[] tempp;
				tempp=tempst.trim().split("\r\n");
				temp=tempp[2].trim().split(" |\t");
				int ii=0,sj=0;
				for (; sj < temp.length; sj++) {// temp重组
					if (temp[sj].trim().isEmpty())
						continue; // 跳过空格
					temp1[ii] = temp[sj];
					ii++;
				}
				//1
				tempst2+=tempp[0]+"\r\n";
				//2
				tempst2+=tempp[1]+"\r\n";
				//3
				tempst2+=decimalFormat.format(mean/nxy)+"\t"+temp1[1]+"\t"+temp1[2]+"\t"+temp1[3]+"\t"+temp1[4]+"\r\n";
				//4,5
				for (int j = 0; j <2*Math.ceil(nxy / 10.0); j++) {
					tempst2+=tempp[j+3]+"\r\n";
				}
				
				str+=tempst2;
			}
			input.close();
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(str);
			output.close();
			if(!f.renameTo(f)){
				res.setInformation("错误！文件fuhecrosssection.txt正在被其他程序操作！");
			}

		} catch (Exception e) {
			// TODO: handle exception
			this.setInformation(e.toString());
			res.setInformation("错误！初始化水位失败"); 
		}
		
	}
	
	
	/**
	 * 初始化流量、浓度
	 */
	public void InterpO(ExeInput mExeInput,ModelResult res) {
		double initQ[]=new double[this.sectionnum];//初始流量
		int solvendkinds=mExeInput.getSolvendkinds();//溶质种类
		double initC[][]=new double[this.sectionnum][solvendkinds];//初始浓度
		
		for (int i = 0; i < initC.length; i++) {
			for (int j = 0; j < solvendkinds; j++) {
				if(mExeInput.getStates()[i].getInitialCon()!=null)
					if(num==0)
					    initC[i][j]=mExeInput.getStates()[i].getInitialCon()[j]/this.transtt;	
					else
						initC[i][j]=mExeInput.getStates()[i].getInitialCon()[j];//第二次不用除以1000了-20171125丁加	
			}
			initQ[i]=mExeInput.getStates()[i].getInitialQ();
		}
		
		for (int i = 0; i < initQ.length;) {
			if(i==initQ.length-1)break;
			if(initQ[i]!=0){
				for (int j = i; j < initQ.length; j++) {
					if((initQ[j]!=0)&&(i!=j)){
						double wid=(initQ[j]-initQ[i])/(j-i);
						for (int k = i+1; k < j; k++) {
							initQ[k]=initQ[i]+(k-i)*wid;
						}
						i=j;
						continue;
					}
					if(j==initQ.length-1){
						double wid=(initQ[j]-initQ[i])/(j-i);
						for (int k = i+1; k < j; k++) {
							initQ[k]=initQ[i]+(k-i)*wid;
						}
						i=j;
					}
						
				}
				continue;
			}
			i++;
		}

		for (int k = 0; k < solvendkinds; k++) {
			for (int i = 0; i < initC.length;) {
				if(i==initC.length-1)break;
				if(initC[i][k]!=0){
					for (int j = i; j < initC.length; j++) {
						if((initC[j][k]!=0)&&(i!=j)){
							double wid=(initC[j][k]-initC[i][k])/(j-i);
							for (int kk = i+1; kk < j; kk++) {
								initC[kk][k]=initC[i][k]+(kk-i)*wid;
							}
							i=j;
							continue;
						}
						if(j==initC.length-1){
							double wid=(initC[j][k]-initC[i][k])/(j-i);
							for (int kk = i+1; kk < j; kk++) {
								initC[kk][k]=initC[i][k]+(kk-i)*wid;
							}
							i=j;
						}
							
					}
					continue;
				}
				i++;
			}
		}
		
		for (int i = 0; i < initC.length; i++) {
			for (int j = 0; j < initC.length; j++) {
				mExeInput.getStates()[i].setInitialCon(initC[i]);
			}			
			mExeInput.getStates()[i].setInitialQ(initQ[i]);
		}
	}
	public void set_path(String path) {
		//set_exeFilePath(path + "Console1.exe");
		//set_inFilePath(path + "1D/in");
		//set_outFilePath(path + "1D/out"); // 
		setRoot(path);
	}

	public int getStep_time() {
		return step_time;
	}

	public void setStep_time(int step_time) {
		this.step_time = step_time;
	}

	public int getBoundary_timepointn() {
		return boundary_timepointn;
	}

	public void setBoundary_timepointn(int boundary_timepointn) {
		this.boundary_timepointn = boundary_timepointn;
	}

	public int getStep_n() {
		return step_n;
	}

	public void setStep_n(int step_n) {
		this.step_n = step_n;
	}

	public double getSchedule() {
		return schedule;
	}

	public void setSchedule(double schedule) {
		this.schedule = schedule;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}
	public int getSub__step_time() {
		return sub__step_time;
	}

	public void setSub__step_time(int sub__step_time) {
		if(sub__step_time>10||sub__step_time<1)
			this.setInformation("错误！亚时间步长范围应为：1~10");
		else
			this.sub__step_time = sub__step_time;
	}
	public int getHn() {
		return hn;
	}

	public void setHn(int hn) {
		this.hn = hn;
	}
	
	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId,ModelResult res) throws IOException {
		this.userId = userId;
		
		//set_exeFilePath(getRoot() + getUserId()+"/Console1.exe");// 备用
		set_exeFilePath(getRoot() +"1D/Console1.exe");
		set_inFilePath(getRoot() + getUserId()+"/in");
		set_outFilePath(getRoot() + getUserId()+"/out");
		System.out.println("exe_path= "+get_exeFilePath());
		System.out.println("in_path= "+get_inFilePath());
		System.out.println("out_path= "+get_outFilePath());
		
		
		File file=new File(getRoot()+getUserId());
		if (!file.isDirectory()){	//文件夹不存在
			//exe复制
			//copyDir(getRoot()+"1D", getRoot()+getUserId(),res);// 备用
			//in out 创建
			String cmd = "cmd /c md " + (getRoot()+getUserId()+"/in").replace("/", "\\");
			Runtime.getRuntime().exec(cmd);
			cmd = "cmd /c md " + (getRoot()+getUserId()+"/out").replace("/", "\\");
			Runtime.getRuntime().exec(cmd);
		}
	}

}
