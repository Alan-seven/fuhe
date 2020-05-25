package com.jsite.szy.dispatch.common;

import java.util.ArrayList;
import java.util.List;

public class SearchMethod {

	
	/**
	 * 
	 * @param source
	 *            数据源，按照从小到大排列
	 * @param data
	 * @param begin
	 *            数组的搜索范围
	 * @param end
	 * @return
	 */
	public static int halfSearch(double[] source, double data, int begin,
			int end) {
		int t = (begin + end) / 2;
		if (t == begin) {
			if (source[t] < data) {
				return end;
			} else {
				return begin;
			}
		} else {
			if (source[t] < data) {
				return halfSearch(source, data, t, end);
			} else if (source[t] == data) {
				return t;
			} else {
				return halfSearch(source, data, begin, t);
			}

		}
	}

	/**
	 * 通过index查value
	 * 
	 * @param source
	 *            查找的数据源，index值按照低到高排序
	 * @param data
	 * @return
	 */
	public static double search(BasicData[] source, double data) {
		int i = halfSearch(source, data, 0, source.length - 1);

		double x0 = source[i].getIndex();
		double y0 = source[i].getValue();
		if (i == 0) {
			return y0;
		} else if (i == (source.length - 1)) {
			if (x0 < data) {
				return y0;
			} else {
				double x1 = source[i - 1].getIndex();
				double y1 = source[i - 1].getValue();
				return LinearInterpolate(x0, y0, x1, y1, data);
			}
		} else {
			double x1 = source[i - 1].getIndex();
			double y1 = source[i - 1].getValue();
			return LinearInterpolate(x0, y0, x1, y1, data);
		}

	}

	/**
	 * 通过index查value2
	 * 
	 * @param source
	 *            查找的数据源，index值按照低到高排序
	 * @param data
	 * @return
	 */
	public static double searchValue2(BasicData[] source, double data) {
		int i = halfSearch(source, data, 0, source.length - 1);

		double x0 = source[i].getIndex();
		double y0 = source[i].getValue2();
		if (i == 0) {
			return y0;
		} else if (i == (source.length - 1)) {
			if (x0 < data) {
				return y0;
			} else {
				double x1 = source[i - 1].getIndex();
				double y1 = source[i - 1].getValue2();
				return LinearInterpolate(x0, y0, x1, y1, data);
			}
		} else {
			double x1 = source[i - 1].getIndex();
			double y1 = source[i - 1].getValue2();
			return LinearInterpolate(x0, y0, x1, y1, data);
		}

	}

	/**
	 * 通过value查index
	 * 
	 * @param source
	 *            value值从低往高排序
	 * @param data
	 * @return
	 */
	public static double searchValueToIndex(BasicData[] source, double data) {
		int i = halfSearchValueToIndex(source, data, 0, source.length - 1);

		double y0 = source[i].getIndex();
		double x0 = source[i].getValue();
		if (i == 0) {
			return y0;
		} else if (i == (source.length - 1)) {
			if (x0 < data) {
				return y0;
			} else {
				double y1 = source[i - 1].getIndex();
				double x1 = source[i - 1].getValue();
				return LinearInterpolate(x0, y0, x1, y1, data);
			}
		} else {
			double y1 = source[i - 1].getIndex();
			double x1 = source[i - 1].getValue();
			return LinearInterpolate(x0, y0, x1, y1, data);
		}

	}

	/**
	 * 通过value2查index
	 * 
	 * @param source
	 *            value值从低往高排序
	 * @param data
	 * @return
	 */
	public static double searchValue2ToIndex(BasicData[] source, double data) {
		int i = halfSearchValueToIndex(source, data, 0, source.length - 1);

		double y0 = source[i].getIndex();
		double x0 = source[i].getValue2();
		if (i == 0) {
			return x0;
		} else if (i == (source.length - 1)) {
			if (x0 < data) {
				return y0;
			} else {
				double y1 = source[i - 1].getIndex();
				double x1 = source[i - 1].getValue2();
				return LinearInterpolate(x0, y0, x1, y1, data);
			}
		} else {
			double y1 = source[i - 1].getIndex();
			double x1 = source[i - 1].getValue2();
			return LinearInterpolate(x0, y0, x1, y1, data);
		}

	}

	/**
	 * 通过index查value
	 * 
	 * @param source
	 * @param data
	 * @param begin
	 * @param end
	 * @return
	 */
	private static int halfSearch(BasicData[] source, double data, int begin,
			int end) {
		int t = (begin + end) / 2;
		if (t == begin) {
			if (source[t].getIndex() < data) {
				return end;
			} else {
				return begin;
			}
		} else {
			if (source[t].getIndex() < data) {
				return halfSearch(source, data, t, end);
			} else if (source[t].getIndex() == data) {
				return t;
			} else {
				return halfSearch(source, data, begin, t);
			}

		}
	}

	/**
	 * 通过value查index
	 * 
	 * @param source
	 * @param data
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int halfSearchValueToIndex(double[] source, double data,
			int begin, int end) {
		int t = (begin + end) / 2;
		if (t == begin) {
			if (source[t] < data) {
				return end;
			} else {
				return begin;
			}
		} else {
			if (source[t] < data) {
				return halfSearchValueToIndex(source, data, t, end);
			} else if (source[t] == data) {
				return t;
			} else {
				return halfSearchValueToIndex(source, data, begin, t);
			}

		}
	}

	/**
	 * 通过value查index
	 * 
	 * @param source
	 * @param data
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int halfSearchValueToIndex(BasicData[] source, double data,
			int begin, int end) {
		int t = (begin + end) / 2;
		if (t == begin) {
			if (source[t].getValue() < data) {
				return end;
			} else {
				return begin;
			}
		} else {
			if (source[t].getValue() < data) {
				return halfSearchValueToIndex(source, data, t, end);
			} else if (source[t].getValue() == data) {
				return t;
			} else {
				return halfSearchValueToIndex(source, data, begin, t);
			}

		}
	}

	/**
	 * 通过value2查index
	 * 
	 * @param source
	 * @param data
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int halfSearchValue2ToIndex(BasicData[] source, double data,
			int begin, int end) {
		int t = (begin + end) / 2;
		if (t == begin) {
			if (source[t].getValue2() < data) {
				return end;
			} else {
				return begin;
			}
		} else {
			if (source[t].getValue2() < data) {
				return halfSearchValue2ToIndex(source, data, t, end);
			} else if (source[t].getValue2() == data) {
				return t;
			} else {
				return halfSearchValue2ToIndex(source, data, begin, t);
			}

		}
	}
	/**
	 * 线性插值，不考虑分母为0
	 * 
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 * @return
	 */
	public static double LinearInterpolate(double x0, double y0, double x1,
			double y1, double x2) {
		if ((x1 - x0) == 0) {
			return (y1 + y0) / 2;
		} else {
			return (x2 - x0) * (y1 - y0) / (x1 - x0) + y0;
		}
	}

	/**
	 * 冒泡排序 从小到大
	 * 
	 * @param array
	 * @return
	 */
	public static double[] BubbleSort(double[] array) {
		double temp;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++)
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
		}

		return array;
	}

	/**
	 * 找最大值所在位置
	 * 
	 * @param value
	 * @return
	 */
	public static int findMax(double[] value) {
		int k = 0;
		double max = value[0];
		for (int i = 1; i < value.length; i++) {
			if (value[i] > max) {
				k = i;
				max = value[i];
			}
		}
		return k;
	}

	/**
	 * 找最小值所在位置
	 * 
	 * @param value
	 * @return
	 */
	public static int findMin(double[] value) {
		int k = 0;
		double min = value[0];
		for (int i = 1; i < value.length; i++) {
			if (value[i] < min) {
				k = i;
				min = value[i];
			}
		}
		return k;
	}

	/**
	 * 最小二乘法曲线拟合
	 * 
	 * @param x
	 *            实型一维数组，长度为 n ,存放给定 n 个数据点的　X　坐标
	 * @param y
	 *            实型一维数组，长度为 n ,存放给定 n 个数据点的　Y　坐标
	 * @param m
	 *            拟合多项式的项数，即拟合多项式的最高次数为 m-1. 要求 m<=n 且m<=20。若 m>n 或 m>20
	 *            ，则本函数自动按 m=min{n,20} 处理. 返回拟合曲线 的系数a[]
	 * 
	 * @return
	 */
	public static double[] PolyFit(double x[], double y[], int m) {
		int i, j, k;
		int n = x.length;
		double z, p, c, g, q = 0, d1, d2;
		double a[] = new double[m];
		double[] s = new double[20];
		double[] t = new double[20];
		double[] b = new double[20];
		double[] dt = new double[3];
		for (i = 0; i <= m - 1; i++) {
			a[i] = 0.0;
		}
		if (m > n) {
			m = n;
		}
		if (m > 20) {
			m = 20;
		}
		z = 0.0;
		for (i = 0; i <= n - 1; i++) {
			z = z + x[i] / (1.0 * n);
		}
		b[0] = 1.0;
		d1 = 1.0 * n;
		p = 0.0;
		c = 0.0;
		for (i = 0; i <= n - 1; i++) {
			p = p + (x[i] - z);
			c = c + y[i];
		}
		c = c / d1;
		p = p / d1;
		a[0] = c * b[0];
		if (m > 1) {
			t[1] = 1.0;
			t[0] = -p;
			d2 = 0.0;
			c = 0.0;
			g = 0.0;
			for (i = 0; i <= n - 1; i++) {
				q = x[i] - z - p;
				d2 = d2 + q * q;
				c = c + y[i] * q;
				g = g + (x[i] - z) * q * q;
			}
			c = c / d2;
			p = g / d2;
			q = d2 / d1;
			d1 = d2;
			a[1] = c * t[1];
			a[0] = c * t[0] + a[0];
		}
		for (j = 2; j <= m - 1; j++) {
			s[j] = t[j - 1];
			s[j - 1] = -p * t[j - 1] + t[j - 2];
			if (j >= 3)
				for (k = j - 2; k >= 1; k--) {
					s[k] = -p * t[k] + t[k - 1] - q * b[k];
				}
			s[0] = -p * t[0] - q * b[0];
			d2 = 0.0;
			c = 0.0;
			g = 0.0;
			for (i = 0; i <= n - 1; i++) {
				q = s[j];
				for (k = j - 1; k >= 0; k--) {
					q = q * (x[i] - z) + s[k];
				}
				d2 = d2 + q * q;
				c = c + y[i] * q;
				g = g + (x[i] - z) * q * q;
			}
			c = c / d2;
			p = g / d2;
			q = d2 / d1;
			d1 = d2;
			a[j] = c * s[j];
			t[j] = s[j];
			for (k = j - 1; k >= 0; k--) {
				a[k] = c * s[k] + a[k];
				b[k] = t[k];
				t[k] = s[k];
			}
		}
		dt[0] = 0.0;
		dt[1] = 0.0;
		dt[2] = 0.0;
		for (i = 0; i <= n - 1; i++) {
			q = a[m - 1];
			for (k = m - 2; k >= 0; k--) {
				q = a[k] + q * (x[i] - z);
			}
			p = q - y[i];
			if (Math.abs(p) > dt[2]) {
				dt[2] = Math.abs(p);
			}
			dt[0] = dt[0] + p * p;
			dt[1] = dt[1] + Math.abs(p);
		}
		return a;
	}

}
