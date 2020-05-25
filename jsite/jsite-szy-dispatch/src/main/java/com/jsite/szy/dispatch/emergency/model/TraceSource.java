package com.jsite.szy.dispatch.emergency.model;

import java.text.DecimalFormat;
import java.util.Arrays;

public class TraceSource {

	private static int NP = 300;//1000;
	private static int GEN = 50;//100 ;// 代数
	private int timelen;// s
	private static int TIME = 50;
	private static double Xmin = 0;
	private static double Xmax;
	private static double Tmin = 0;
	private static double Tmax = 2.5;// 小时
	private static double CF = 0.6;// [0.5,1]
	private static double CR = 0.9;// [0.8,1]

	private double[] x;
	private double[] x1;
	private double[] x2;
	private double[] t;
	private double[] t1;
	private double[] t2;

	private double[] c;
	private double[] ci;
	private double[] p;
	
	private double u;
	private double Dx;
	private double k;
	private double[] result;
	private double[][] results;
	private double[][] outresult;
	private double m0;
	
	// 界面展示
	private double startTime; // 发生时间（以模拟时间起始时间为0时刻，startTime为距离模拟起始时间的秒数）
	private double distance;// 发生地点距离上断面距离（m）
	private double lastTime; // 持续时间（s）
	private double M; //污染物质量区间(kg)
	private String progress; 
	
	public void dea() {
		setResults(new double[GEN][3]);
		setOutresult(new double[3][2]);
		for (int j = 0; j < TIME; j++) {
			initpopulation();
			set_Result(new double[3]);
			p = new double[c.length];
			ci = new double[c.length];
			m0=0;
			get_Result()[0] = 1.0;
			for (int i = 0; i < GEN; i++) {
				variation();
				intersect();
				select();
				if (get_Result()[0] < 0.005)
					break;
			}
			for (int i = 0; i < c.length; i++) {
				if (c[i] != 0) {
					m0+=ci[i] * 1000000.0 / c[i];
//					setM0(getM0() + ci[i] * 1000.0 / c[i]);
					//System.out.println(ci[i]);
				}
			}
			getResults()[j][0]=result[1];//距离
			getResults()[j][1]=result[2];//时间
			getResults()[j][2]=m0;//质量
//			System.out.println(get_Result()[0] + " " + get_Result()[1] + " " + get_Result()[2] + " " + getM0() + " 计算进度:" + j*100.0/TIME+"%");
//			System.out.println(get_Result()[0] + " " + getResults()[j][0] + " " + getResults()[j][1] + " " + getResults()[j][2] + " 计算进度:" + j*100.0/TIME+"%");
			//System.out.println(" 计算进度:" + (j+1)*100.0/TIME+"%");
			progress= "计算进度:"+(j+1)*100.0/TIME+"%";
		}
		//区间结果输出
		double d[]=new double[TIME];
		double t[]=new double[TIME];
		double m[]=new double[TIME];
		for (int i = 0; i < m.length; i++) {
			d[i]=results[i][0];
			t[i]=results[i][1];
			m[i]=results[i][2];
		}
		Arrays.sort(d);
		Arrays.sort(t);
		Arrays.sort(m);
		outresult[0][0]=d[TIME/4];outresult[0][1]=d[3*TIME/4];
		outresult[1][0]=t[TIME/4];outresult[1][1]=t[3*TIME/4];
		outresult[2][0]=m[TIME/4];outresult[2][1]=m[3*TIME/4];
		
		distance=(outresult[0][0]+outresult[0][1])/2;//距离
		lastTime=(outresult[1][0]+outresult[1][1])/2;; // 持续时间（s）
		M=(outresult[2][0]+outresult[2][1])/2;; //污染
		
		// 找出下游污染发生时间
		double max=0;
		double min=0;
		for (int i = 0; i < c.length; i++) {
			max=Math.max(max, c[i]);
			min=Math.min(min, c[i]);
		}
		double avg=(max+min)/2;
		int st=0;
		if(avg>0){
			for (int i = 0; i < c.length; i++) {
			if((c[i]>0)&&(10*c[i]>=avg)){
				st=i;
				break;
			   }
		    }
		}
		
		startTime=st*timelen-(Xmax-distance)/u; //(s) 下游监测到污染的时间-发生地点到下游的传播时间
	}

	/**
	 * 种群初始化
	 */
	public void initpopulation() {
		// 初始化空间
		x = new double[NP];
		x1 = new double[NP];
		x2 = new double[NP];
		t = new double[NP];
		t1 = new double[NP];
		t2 = new double[NP];
		// 初始化种群
		for (int i = 0; i < x.length; i++) {
			x[i] = Xmin + (getXmax() - Xmin) * Math.random();
			t[i] = Tmin + (Tmax - Tmin) * 3600 * Math.random();// 转换成s、
			x1[i] = x[i];
			t1[i] = t[i];
			// System.out.println(x[i]);
			// System.out.println(t[i]);
		}
		// System.out.println("--------------------------------------");

	}

	/**
	 * 变异
	 */
	public void variation() {
		// 均匀抽样三个个体
		int[] var = new int[3];// 存取序号
		double vx, vt;
		for (int i = 0; i < NP; i++) {
			while (true) {
				while (true) {
					for (int j = 0; j < var.length; j++) {
						var[j] = (int) (Math.random() * NP);
						// System.out.println(var[j]);
					}

					if ((var[0] != var[1]) && (var[0] != var[2]) && (var[1] != var[2]) && (var[0] != i) && (var[1] != i)
							&& (var[2] != i))
						break;
				}

				// 变异计算

				vx = x[var[0]] + CF * (x[var[2]] - x[var[1]]);
				x1[i] = vx;
				if (vx >= Xmin && vx <= getXmax())
					break;

			}
			// System.out.println(x1[i]);
		}
		// System.out.println("--------------------------------");
		for (int i = 0; i < NP; i++) {
			while (true) {
				while (true) {
					for (int j = 0; j < var.length; j++) {
						var[j] = (int) (Math.random() * NP);
						// System.out.println(var[j]);
					}

					if ((var[0] != var[1]) && (var[0] != var[2]) && (var[1] != var[2]) && (var[0] != i) && (var[1] != i)
							&& (var[2] != i))
						break;
				}

				// 变异计算

				vt = x[var[0]] + CF * (x[var[2]] - x[var[1]]);
				x1[i] = vt;
				if (vt >= Xmin && vt <= getXmax())
					break;
			}
			// System.out.println(x1[i]);
		}
	}

	public void intersect() {

		double i = Math.random();
		double j = Math.random();
		for (int k = 0; k < t.length; k++) {

			if (i < CR || j > 0.5) {
				x2[k] = x1[k];
				t2[k] = t1[k];
			} else {
				x2[k] = x[k];
				t2[k] = t[k];
			}
			// System.out.println(x2[k]);
		}

	}

	public void select() {
		double f1, f2;
		for (int i = 0; i < NP; i++) {
			f1 = fitness(x[i], t[i]);
			f2 = fitness(x2[i], t2[i]);
			if (f1 >= f2) {
				x[i] = x2[i];
				t[i] = t2[i];
			}
			if ((f1 < f2) && (f1 < get_Result()[0])) {
				get_Result()[0] = f1;
				get_Result()[1] = x[i];
				get_Result()[2] = t[i];
				for (int j = 0; j < c.length; j++) {
					ci[j] = p[j];
				}
			} else if ((f2 <= f1) && (f2 < get_Result()[0])) {
				get_Result()[0] = f2;
				get_Result()[1] = x2[i];
				get_Result()[2] = t2[i];
				for (int j = 0; j < c.length; j++) {
					ci[j] = p[j];
				}
			}

		}
	}

	public double fitness(double xx, double tt) {
		double f;
		double cmean = 0;
		double pmean = 0;
		double temp1 = 0;
		double temp2 = 0;
		double temp3 = 0;
		double r = 0;

		for (int i = 0; i < c.length; i++) {
			p[i] = 1 / (Math.sqrt(4 * Math.PI * getDx() * (Tmax*3600+i * getTimelen() - tt)))
					* Math.exp(-Math.pow((getXmax() - xx - getU() * (Tmax*3600+i * getTimelen() - tt)), 2.0)
							/ (4 * getDx() * (Tmax*3600+i * getTimelen() - tt)
									- getK() * (Tmax*3600+i * getTimelen() - tt)));
			// System.out.println(p[i]);
		}

		for (int i = 0; i < c.length; i++) {
			cmean += c[i] / c.length;
			pmean += p[i] / c.length;
		}
		for (int i = 0; i < c.length; i++) {
			temp1 += (c[i] - cmean) * (p[i] - pmean);
			temp2 += Math.pow((c[i] - cmean), 2.0);
			temp3 += Math.pow((p[i] - pmean), 2.0);
		}
		r = temp1 / (Math.sqrt(temp2) * Math.sqrt(temp3));
		f = Math.abs(1 - r);

		return f;
	}

	public void setC(double[] c) {
		this.c = c;
	}

	public double[] get_Result() {
		return result;
	}

	public void set_Result(double[] result) {
		this.result = result;
	}

	public double getM0() {
		return m0;
	}

	public void setM0(double m0) {
		this.m0 = m0;
	}

	public double getU() {
		return u;
	}

	public void setU(double u) {
		this.u = u;
	}

	public double getDx() {
		return Dx;
	}

	public void setDx(double dx) {
		Dx = dx;
	}

	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
	}

	public double[][] getResults() {
		return results;
	}

	public void setResults(double[][] results) {
		this.results = results;
	}

	public double[][] getOutresult() {
		return outresult;
	}

	public void setOutresult(double[][] outresult) {
		this.outresult = outresult;
	}

	public static double getXmax() {
		return Xmax;
	}

	public void setXmax(double xmax) {
		Xmax = xmax;
	}

	public int getTimelen() {
		return timelen;
	}

	public void setTimelen(int timelen) {
		this.timelen = timelen;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getLastTime() {
		return lastTime;
	}

	public void setLastTime(double lastTime) {
		this.lastTime = lastTime;
	}

	public double getM() {
		return M;
	}

	public void setM(double m) {
		M = m;
	}

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

}
