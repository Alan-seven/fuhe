package com.jsite.szy.dispatch.emergency.mconfig;

import java.util.Date;
import java.util.List;

import com.jsite.busi.szy.emergency.po.DdsEdGis;
import com.jsite.busi.szy.emergency.po.DdsEdRes;

/**
 * 组装地图数据时刻一对多数据
 * @author admin
 *
 */
public class EDGisData {

	private String dt;	
	private Integer time;    // 时刻值：0、1、2h
	private List<DdsEdGis> data;//按照主键分组后，封装
	private List<DdsEdRes> dataRes;//按照主键分组后，封装
	
	private Integer fid;//图层编号
	private Double wq;//水质
	
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public List<DdsEdGis> getData() {
		return data;
	}
	public void setData(List<DdsEdGis> data) {
		this.data = data;
	}
	public List<DdsEdRes> getDataRes() {
		return dataRes;
	}
	public void setDataRes(List<DdsEdRes> dataRes) {
		this.dataRes = dataRes;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Double getWq() {
		return wq;
	}
	public void setWq(Double wq) {
		this.wq = wq;
	}
	
}
