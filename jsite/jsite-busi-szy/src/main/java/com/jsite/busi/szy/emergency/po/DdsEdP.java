package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;


/**
 * 应急方案信息表Entity
 * @author hjx
 * @version 2017-06-07
 */
public class DdsEdP extends AbstractData<DdsEdP> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String evenCd;		// 事件ID
	private String proTp;		// 方案类型
	private String proNm;		// 方案名称
	private Date pubDt;		// 发布时间
	private Date bgDt;		// 起始时间
	private Date edDt;		// 终止时间
	private String rgTp;		// 时段类型
	private Integer rgLg;		// 时段长度
	private String producer;		// 制作人
	private Date crDt;		// 制作时间
	private Integer sta;		// 状态
	private String evaSta;		// 评价状态
	private Date ts;		// 时间戳
	private String nt;		// 备注
	private Double bgco = 0.1 ;	//物质初始浓度
	//事件列表
	private String evenNm;		// 事件名称
	private String evenTp;		// 事件类型
	private Date hapDt;		// 发生时间
	private Integer rcd	;		//发生河道编号
	
	private String startTime;
	private String endTime;
	
	private Integer forTime;	//预热期
	//溯源表信息
	private Integer daType;		// 污染物类型
	
	private String loc;		// 位置
	private String upsec;		// 上监测断面ID
	private Double lenUp ;		//距上监测断面里程1km
	private Date tm;		// 污染物发生时间
	private Double da;		// 污染量
	private Integer dur;		// 污染物持续时间
	private Date begt;		// 起始时间
	private Date edt;		// 结束时间
	private String tscale;		// 时间尺度
	
	private List<DdsEdEva> list;
	private String score;		//得分
	private Map<String,Object> keys;
	
	public DdsEdP() {
		super();
	}

	public DdsEdP(String id){
		super(id);
	}

	public Map<String, Object> getKeys() {
		return keys;
	}

	public void setKeys(Map<String, Object> keys) {
		this.keys = keys;
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=8, message="事件ID长度必须介于 1 和 8 之间")
	public String getEvenCd() {
		return evenCd;
	}

	public void setEvenCd(String evenCd) {
		this.evenCd = evenCd;
	}
	
	@Length(min=0, max=10, message="方案类型长度必须介于 0 和 10 之间")
	public String getProTp() {
		return proTp;
	}

	public void setProTp(String proTp) {
		this.proTp = proTp;
	}
	
	@Length(min=0, max=60, message="方案名称长度必须介于 0 和 60 之间")
	public String getProNm() {
		return proNm;
	}

	public void setProNm(String proNm) {
		this.proNm = proNm;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPubDt() {
		return pubDt;
	}

	public void setPubDt(Date pubDt) {
		this.pubDt = pubDt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBgDt() {
		return bgDt;
	}

	public void setBgDt(Date bgDt) {
		this.bgDt = bgDt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEdDt() {
		return edDt;
	}

	public void setEdDt(Date edDt) {
		this.edDt = edDt;
	}
	
	@Length(min=0, max=10, message="时段类型长度必须介于 0 和 10 之间")
	public String getRgTp() {
		return rgTp;
	}

	public void setRgTp(String rgTp) {
		this.rgTp = rgTp;
	}
	
	public Integer getRgLg() {
		return rgLg;
	}

	public void setRgLg(Integer rgLg) {
		this.rgLg = rgLg;
	}
	
	@Length(min=0, max=64, message="制作人长度必须介于 0 和 64 之间")
	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCrDt() {
		return crDt;
	}

	public void setCrDt(Date crDt) {
		this.crDt = crDt;
	}
	
	public Integer getSta() {
		return sta;
	}

	public void setSta(Integer sta) {
		this.sta = sta;
	}
	
	@Length(min=0, max=100, message="评价状态长度必须介于 0 和 100 之间")
	public String getEvaSta() {
		return evaSta;
	}

	public void setEvaSta(String evaSta) {
		this.evaSta = evaSta;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

	public String getEvenNm() {
		return evenNm;
	}

	public void setEvenNm(String evenNm) {
		this.evenNm = evenNm;
	}

	public String getEvenTp() {
		return evenTp;
	}

	public void setEvenTp(String evenTp) {
		this.evenTp = evenTp;
	}

	public Date getHapDt() {
		return hapDt;
	}

	public void setHapDt(Date hapDt) {
		this.hapDt = hapDt;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getForTime() {
		return forTime;
	}

	public void setForTime(Integer forTime) {
		this.forTime = forTime;
	}

	public List<DdsEdEva> getList() {
		return list;
	}

	public void setList(List<DdsEdEva> list) {
		this.list = list;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Integer getDaType() {
		return daType;
	}

	public void setDaType(Integer daType) {
		this.daType = daType;
	}

	public int getRcd() {
		return rcd;
	}

	public void setRcd(int rcd) {
		this.rcd = rcd;
	}

	public String getUpsec() {
		return upsec;
	}

	public void setUpsec(String upsec) {
		this.upsec = upsec;
	}

	public Double getLenUp() {
		return lenUp;
	}

	public void setLenUp(Double lenUp) {
		this.lenUp = lenUp;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}

	public Double getDa() {
		return da;
	}

	public void setDa(Double da) {
		this.da = da;
	}

	public Integer getDur() {
		return dur;
	}

	public void setDur(Integer dur) {
		this.dur = dur;
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

	public String getTscale() {
		return tscale;
	}

	public void setTscale(String tscale) {
		this.tscale = tscale;
	}

	public Double getBgco() {
		return bgco;
	}

	public void setBgco(Double bgco) {
		this.bgco = bgco;
	}

}