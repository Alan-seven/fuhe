package com.jsite.szy.dispatch.dispatchwo.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 常规水量调度统计工具
 * @author ferry
 *
 */
public class WOStatistics {
	private List<Double> data;
	
	public WOStatistics() {
		data = new ArrayList<>();
	}
	
	public WOStatistics(double[] array) {
		data = new ArrayList<>();
		for(int i=0;i<array.length;i++){
			data.add(array[i]);
		}
	}
	
	public void add(Double value){
		data.add(value);
	}
	
	public int count(){
		return data.size();
	}
	
	public double sum(){
		double sum = 0;
		for(Double value: data){
			sum += value;
		}
		return sum;
	}
	
	public double average(){
		return sum()/count();
	}
}
