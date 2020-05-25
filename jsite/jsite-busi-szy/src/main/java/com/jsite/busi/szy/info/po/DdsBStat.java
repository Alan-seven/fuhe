package com.jsite.busi.szy.info.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBStat extends AbstractData<DdsBStat> {
	
	private static final long serialVersionUID = 1L;
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
	
	private String itemZ;	//河道水位施测项目    0--不施测  1---施测
	private String itemP;	//雨量施测项目    0--不施测  1---施测
	private String itemR;	//水库施测项目    0--不施测  1---施测
	private String itemQ;	//河道流量施测项目    0--不施测  1---施测
	
	public DdsBStat() {
		super();
	}

	public DdsBStat(String id){
		super(id);
	}

	@Length(min=1, max=8, message="测站代码长度必须介于 1 和 8 之间")
	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	
	@Length(min=1, max=100, message="测站名称长度必须介于 1 和 100 之间")
	public String getStNm() {
		return stNm;
	}

	public void setStNm(String stNm) {
		this.stNm = stNm;
	}
	
	@Length(min=0, max=2, message="测站类别长度必须介于 0 和 2 之间")
	public String getStTp() {
		return stTp;
	}

	public void setStTp(String stTp) {
		this.stTp = stTp;
	}
	
	@Length(min=0, max=200, message="所在地长度必须介于 0 和 200 之间")
	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	@Length(min=0, max=1, message="测站岸别长度必须介于 0 和 1 之间")
	public String getStbk() {
		return stbk;
	}

	public void setStbk(String stbk) {
		this.stbk = stbk;
	}
	
	@Length(min=0, max=1, message="水流流向长度必须介于 0 和 1 之间")
	public String getFlowDir() {
		return flowDir;
	}

	public void setFlowDir(String flowDir) {
		this.flowDir = flowDir;
	}
	
	@Length(min=0, max=2, message="基面类型长度必须介于 0 和 2 之间")
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
	
	@Length(min=0, max=1, message="监测方式A长度必须介于 0 和 1 之间")
	public String getMonTpA() {
		return monTpA;
	}

	public void setMonTpA(String monTpA) {
		this.monTpA = monTpA;
	}
	
	@Length(min=0, max=1, message="监测方式B长度必须介于 0 和 1 之间")
	public String getMonTpB() {
		return monTpB;
	}

	public void setMonTpB(String monTpB) {
		this.monTpB = monTpB;
	}
	
	@Length(min=0, max=6, message="设站年月长度必须介于 0 和 6 之间")
	public String getEstStYm() {
		return estStYm;
	}

	public void setEstStYm(String estStYm) {
		this.estStYm = estStYm;
	}
	
	@Length(min=0, max=1, message="运行状况长度必须介于 0 和 1 之间")
	public String getRunCond() {
		return runCond;
	}

	public void setRunCond(String runCond) {
		this.runCond = runCond;
	}
	
	@Length(min=1, max=9, message="管理单位代码长度必须介于 1 和 9 之间")
	public String getEngManCd() {
		return engManCd;
	}

	public void setEngManCd(String engManCd) {
		this.engManCd = engManCd;
	}
	
	@Length(min=0, max=4, message="拼音码长度必须介于 0 和 4 之间")
	public String getPinYinCd() {
		return pinYinCd;
	}

	public void setPinYinCd(String pinYinCd) {
		this.pinYinCd = pinYinCd;
	}
	
	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
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