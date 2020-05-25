package com.jsite.szy.dispatch.dispatchwo.data;

import java.util.ArrayList;
import java.util.List;

import com.jsite.busi.szy.dispatch.po.DdsRdWdres;
import com.jsite.szy.dispatch.dispatchwo.vo.WaterOptimumVOMap;

public class WOSection {
	private List<DdsRdWdres> data;
	
	public WOSection() {
		data = new ArrayList<>();
	}
	
	public void add(DdsRdWdres single){
		data.add(single);
	}
	
	public List<WaterOptimumVOMap> statistics(){
		return null;
	}
	
	public List<WaterOptimumVOMap> single(){
		return null;
	}
}
