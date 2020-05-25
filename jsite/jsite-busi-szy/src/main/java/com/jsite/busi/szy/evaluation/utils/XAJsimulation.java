package com.jsite.busi.szy.evaluation.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class XAJsimulation {

	public List<Double> getXAJsimulation(long n_time, Map map ,Map paramMap) {

//		// 固定参数最小值
//		double K = 0.7d;// 蒸发皿系数
//		double C = 0.1d;// 深层蒸散发系数
//		double IMP = 0.03d;// 不透水面积比重
//		double WUM = 15d;// 上层张力水容量
//		double WLM = 60d;// 下层张力水容量
//		double WDM = 90d;// 深层张力水容量
//		double B = 0.4d;// 蓄水容量曲线指数
//		double SM = 75d;// 流域平均自由水蓄水容量
//		double EX = 1.2d;// 自由水蓄水容量曲线指数
//		double KG = 0.36d;// 自由水中地下水出流系数
//		double KSS = 0.34d;// 自由水中壤中流出流系数
//		double KKG = 0.995d;// 地下水消退系数
//		double KKSS = 0.9d;// 壤中流消退系数
//		double[] UH = {0.3, 0.6, 0.1};// 无因次单位线常数
//		double F = 1225;


		// 固定参数最小值
		double K =(double)paramMap.get("K");// 蒸发皿系数
		double C = (double)paramMap.get("C");// 深层蒸散发系数
		double IMP = (double)paramMap.get("IMP");// 不透水面积比重
		double WUM = (double)paramMap.get("WUM");// 上层张力水容量
		double WLM = (double)paramMap.get("WLM");// 下层张力水容量
		double WDM = (double)paramMap.get("WDM");// 深层张力水容量
		double B = (double)paramMap.get("B");// 蓄水容量曲线指数
		double SM = (double)paramMap.get("SM");// 流域平均自由水蓄水容量
		double EX = (double)paramMap.get("EX");// 自由水蓄水容量曲线指数
		double KG = (double)paramMap.get("KG");// 自由水中地下水出流系数
		double KSS = (double)paramMap.get("KSS");// 自由水中壤中流出流系数
		double KKG = (double)paramMap.get("KKG");// 地下水消退系数
		double KKSS = (double)paramMap.get("KKSS");// 壤中流消退系数
		double[] UH = (double[])paramMap.get("UH");// 无因次单位线常数
		double F = (double)paramMap.get("F");



		List<Double> P = (List<Double>) map.get("P");
		List<Double> E = (List<Double>) map.get("E");

		List<Double> xaj = getXAJ(P, E, UH, n_time, F, K, C, IMP, WUM, WLM, WDM, B, SM, EX, KG, KSS, KKG, KKSS);
		return xaj;
	}

	public List<Double> getXAJ(List<Double> P, List<Double> EI, double UH[], long Nday, double F, double K, double C,
							   double IMP, double WUM, double WLM, double WDM, double B, double SM, double EX, double KG, double KSS,
							   double KKG, double KKSS) {
		/*---------- 初始状态 ----------*/

		double WU = 0d;
		double WL = 70d;
		double WD = 80d;
		double W;
		double FR = 0.1d;
		double S = 20d;
		double QRSS0 = 40d;
		double QRG0 = 20d;
		W = WU + WL + WD;
		double EM;
		double PE;
		double A;
		double WM;
		double WWMM;
		double EU, EL, ED;
		double SSM, AU, KSSD, KGD;
		WM = WUM + WLM + WDM;
		KSSD = (1d - (1d - (KG + KSS))) / (1d + KG / KSS);
		KGD = KSSD * KG / KSS;

		List<Double> E = new ArrayList<>();
		List<Double> R = new ArrayList<>();
		List<Double> RS = new ArrayList<>();
		List<Double> RSS = new ArrayList<>();
		List<Double> RG = new ArrayList<>();
		List<Double> QS = new ArrayList<>();
		List<Double> QSS = new ArrayList<>();
		List<Double> QG = new ArrayList<>();
		List<Double> Q = new ArrayList<>();

		for (int i = 0; i < Nday + 2; i++) {
			QS.add(0d);
		}
		for (int i = 0; i < Nday; i++) {
			E.add(0d);
			R.add(0d);
			RS.add(0d);
			RSS.add(0d);
			RG.add(0d);
			QS.add(0d);
			QSS.add(0d);
			QG.add(0d);
			Q.add(0d);
		}



		/*---------- 产流计算 ----------*/

		for (int i = 0; i < Nday; i++) {
			EM = K * EI.get(i);
			PE = P.get(i) - EM;
			// 蒸发计算
			WWMM = (1 + B) * WM;
			A = WWMM * (1 - Math.pow(1d - W / WM, 1 / (1d + B)));
			if (PE > 0) {
				E.set(i, EM);
				if ((PE + A) >= WWMM) {
					R.set(i, PE - (WM - W));
				} else {
					R.set(i, PE - (WM - W) + WM * Math.pow((1d - (PE + A) / WWMM), 1d + B));
				}
				EU = EM;
				EL = 0d;
				ED = 0d;
			} // if(PE>0)
			else {
				R.set(i, 0d);
				WU = WU + P.get(i);
				if (WU >= EM) {
					EU = EM;
					EL = 0d;
					ED = 0d;
				} else {
					EU = WU;
					if (WL / WLM >= C) {
						EL = (EM - EU) * WL / WLM;
						ED = 0d;
					} else if (WL >= C * (EM - EU)) {
						EL = C * (EM - EU);
						ED = 0d;
					} else {
						EL = WL;
						ED = C * (EM - EU) - EL;
					}

				}
			}
			E.set(i, EU + EL + ED);
			// 产流量计算
			SSM = (1d + EX) * SM;
			AU = SSM * (1d - Math.pow(1d - S / SM, 1d / (1d + EX)));
			if (PE > 0) {
				FR = R.get(i) / PE;
				if ((PE + AU) < SSM) {
					RS.set(i, FR * (PE - SM + S + SM * Math.pow(1d - (PE + AU) / SSM, EX + 1d)));
					RSS.set(i, (SM - SM * Math.pow(1d - (PE + AU) / SSM, 1d + EX)) * KSSD * FR);
					RG.set(i, (SM - SM * Math.pow(1d - (PE + AU) / SSM, 1d + EX)) * KGD * FR);
					S = (1d - KSSD - KGD) * (SM - SM * Math.pow(1d - (PE + AU) / SSM, 1d + EX));
				} else {
					RS.set(i, (PE - SM + S) * FR);
					RSS.set(i, S * KSSD * FR);
					RG.set(i, S * KGD * FR);
					S = (1d - KSSD - KGD) * SM;
				}
			} else {
				RS.set(i, 0d);
				RSS.set(i, S * KSSD * FR);
				RG.set(i, S * KGD * FR);
				S = (1d - KSSD - KGD) * S;
			}
			RS.set(i, RS.get(i) * (1d - IMP) + P.get(i) * IMP);

			// 蓄水计算
			WU = WU + P.get(i) - EU;
			if (WU >= WUM) {
				WL = WL - EL + (WU - WUM);
				WU = WUM;
				if (WL >= WLM) {
					WD = WD - ED + (WL - WLM);
					WL = WLM;
					if (WD >= WDM)
						WD = WDM;
				} else
					WD = WD - ED;
			} else
				WL = WL - EL;
			W = WU + WL + WD;
			FR = 1d - Math.pow(1d - W / WM, B / (1d + B));

		} // for(i=0;i<Nday;i++)


		// 汇流计算
		for (int i = 0; i < Nday; i++) {
			for (int j = 0; j < 3; j++) {
				QS.set(i + j, QS.get(i + j) + UH[j] * RS.get(i) * F / (3.6d * 240d));
			}
			if (i == 0) {
				QSS.set(i, QRSS0 * KKSS + RSS.get(i) * (1d - KKSS) * F / (3.6d * 240d));
				QG.set(i, QRG0 * KKG + RG.get(i) * (1d - KKG) * F / (3.6d * 240d));
			} else {
				QSS.set(i, QSS.get(i - 1) * KKSS + RSS.get(i) * (1d - KKSS) * F / (3.6d * 240d));
				QG.set(i, QG.get(i - 1) * KKG + RG.get(i) * (1d - KKG) * F / (3.6d * 240d));
			}


			DecimalFormat df = new DecimalFormat("#.0");
			double q = Double.parseDouble(df.format(QS.get(i) + QSS.get(i) + QG.get(i)));
			Q.set(i, q);
		}
		return Q;
	}
}
