package com.jsite.szy.dispatch.info.vo;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBStatVO extends PageVO{
	
	private String stcd;		// 测站代码
	private String stNm;		// 测站名称
	private String stTp;		// 测站类别
	private String loc;		// 所在地
	private float lgtd;		// 经度
	private float lttd;		// 纬度
	private String stbk;		// 测站岸别
	private String flowDir;		// 水流流向
	private String datTp;		// 基面类型
	private float datElev;		// 基面高程
	private float modBasVal;		// 修正基值
	private float modPara;		// 修正参数
	private String monTpA;		// 监测方式A
	private String monTpB;		// 监测方式B
	private String estStYm;		// 设站年月
	private String runCond;		// 运行状况
	private String engManCd;		// 管理单位代码
	private String pinYinCd;		// 拼音码
	private String ts;		// 时间戳
	private String nt;		// 备注
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
	private String itemZ;	//河道水位施测项目    0--不施测  1---施测
	private String itemP;	//雨量施测项目    0--不施测  1---施测
	private String itemR;	//水库施测项目    0--不施测  1---施测
	private String itemQ;	//河道流量施测项目    0--不施测  1---施测
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	public DdsBStatVO() {
		super();
	}

	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	public String getStNm() {
		return stNm;
	}

	public void setStNm(String stNm) {
		this.stNm = stNm;
	}
	
	public String getStTp() {
		return stTp;
	}

	public void setStTp(String stTp) {
		this.stTp = stTp;
	}
	
	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	public String getStbk() {
		return stbk;
	}

	public void setStbk(String stbk) {
		this.stbk = stbk;
	}
	
	public String getFlowDir() {
		return flowDir;
	}

	public void setFlowDir(String flowDir) {
		this.flowDir = flowDir;
	}
	
	public String getDatTp() {
		return datTp;
	}

	public void setDatTp(String datTp) {
		this.datTp = datTp;
	}
	
	public float getDatElev() {
		return datElev;
	}

	public void setDatElev(float datElev) {
		this.datElev = datElev;
	}
	
	public float getModBasVal() {
		return modBasVal;
	}

	public void setModBasVal(float modBasVal) {
		this.modBasVal = modBasVal;
	}
	
	public float getModPara() {
		return modPara;
	}

	public void setModPara(float modPara) {
		this.modPara = modPara;
	}
	
	public String getMonTpA() {
		return monTpA;
	}

	public void setMonTpA(String monTpA) {
		this.monTpA = monTpA;
	}
	
	public String getMonTpB() {
		return monTpB;
	}

	public void setMonTpB(String monTpB) {
		this.monTpB = monTpB;
	}
	
	public String getEstStYm() {
		return estStYm;
	}

	public void setEstStYm(String estStYm) {
		this.estStYm = estStYm;
	}
	
	public String getRunCond() {
		return runCond;
	}

	public void setRunCond(String runCond) {
		this.runCond = runCond;
	}
	
	public String getEngManCd() {
		return engManCd;
	}

	public void setEngManCd(String engManCd) {
		this.engManCd = engManCd;
	}
	
	public String getPinYinCd() {
		return pinYinCd;
	}

	public void setPinYinCd(String pinYinCd) {
		this.pinYinCd = pinYinCd;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}
	
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

	public float getLgtd() {
		return lgtd;
	}

	public void setLgtd(float lgtd) {
		this.lgtd = lgtd;
	}

	public float getLttd() {
		return lttd;
	}

	public void setLttd(float lttd) {
		this.lttd = lttd;
	}

	public String getItemZ() {
		return itemZ;
	}

	public void setItemZ(String itemZ) {
		this.itemZ = itemZ;
	}

	public String getItemP() {
		return itemP;
	}

	public void setItemP(String itemP) {
		this.itemP = itemP;
	}

	public String getItemR() {
		return itemR;
	}

	public void setItemR(String itemR) {
		this.itemR = itemR;
	}

	public String getItemQ() {
		return itemQ;
	}

	public void setItemQ(String itemQ) {
		this.itemQ = itemQ;
	}
	
}