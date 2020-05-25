package com.jsite.szy.dispatch.emergency.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 应急事件溯源信息表Entity
 * @author hjx
 * @version 2017-06-07
 */
public class DdsEdSourceVO extends PageVO{

	private String evenCd;		// 事件ID
	private Date begt;		// 起始时间
	private Date edt;		// 结束时间
	private String tscale;		// 时间尺度
	private String upsec;		// 上监测断面ID
	private String downsec;		// 下监测断面ID
	private Double lgtd;		// 污染物经度
	private Double lttd;		// 污染物纬度
	private Date tm;		// 污染物发生时间
	private Integer dur;		// 污染物持续时间
	private Double da;		// 污染量
	private Integer daType;		// 污染物类型 0--保守型物质  1--挥发性物质
	private Integer method;		//溯源方式   0--保守型模拟  2--人工手动填写
	private Double lenUp ;		//距上监测断面里程1km
	private Double lenDown ;		//距下监测断面里程1km
	private String loc;		// 位置
	
	private Double z;			//水位
	private Double q;			//平均流速
	
	private String river; //河流标识  后续需要配置到系统管理中 
	private Double bgConc;		//物质初始浓度
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	public DdsEdSourceVO() {
		super();
	}

	@Length(min=1, max=8, message="事件ID长度必须介于 1 和 8 之间")
	public String getEvenCd() {
		return evenCd;
	}

	public void setEvenCd(String evenCd) {
		this.evenCd = evenCd;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBegt() {
		return begt;
	}

	public void setBegt(Date begt) {
		this.begt = begt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEdt() {
		return edt;
	}

	public void setEdt(Date edt) {
		this.edt = edt;
	}
	
	@Length(min=0, max=2, message="时间尺度长度必须介于 0 和 2 之间")
	public String getTscale() {
		return tscale;
	}

	public void setTscale(String tscale) {
		this.tscale = tscale;
	}
	
	@Length(min=0, max=8, message="上监测断面ID长度必须介于 0 和 8 之间")
	public String getUpsec() {
		return upsec;
	}

	public void setUpsec(String upsec) {
		this.upsec = upsec;
	}
	
	@Length(min=0, max=8, message="下监测断面ID长度必须介于 0 和 8 之间")
	public String getDownsec() {
		return downsec;
	}

	public void setDownsec(String downsec) {
		this.downsec = downsec;
	}
	
	public Double getLgtd() {
		return lgtd;
	}

	public void setLgtd(Double lgtd) {
		this.lgtd = lgtd;
	}
	
	public Double getLttd() {
		return lttd;
	}

	public void setLttd(Double lttd) {
		this.lttd = lttd;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}
	
	public Integer getDur() {
		return dur;
	}

	public void setDur(Integer dur) {
		this.dur = dur;
	}
	
	public Double getDa() {
		return da;
	}

	public void setDa(Double da) {
		this.da = da;
	}
	
	public Integer getDaType() {
		return daType;
	}

	public void setDaType(Integer daType) {
		this.daType = daType;
	}

	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	public Double getLenUp() {
		return lenUp;
	}

	public void setLenUp(Double lenUp) {
		this.lenUp = lenUp;
	}

	@Length(min=0, max=100, message="位置长度必须介于 0 和 100 之间")
	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public Double getQ() {
		return q;
	}

	public void setQ(Double q) {
		this.q = q;
	}

	public Double getLenDown() {
		return lenDown;
	}

	public void setLenDown(Double lenDown) {
		this.lenDown = lenDown;
	}

	public Double getBgConc() {
		return bgConc;
	}

	public void setBgConc(Double bgConc) {
		this.bgConc = bgConc;
	}
	
}
