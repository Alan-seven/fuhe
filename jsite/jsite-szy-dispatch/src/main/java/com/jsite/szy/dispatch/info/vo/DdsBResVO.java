package com.jsite.szy.dispatch.info.vo;

import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;

/**
 * 仪器设备基本信息Entity
 * 
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBResVO extends PageVO {

	private String resCd; // 水库代码
	private String resNm; // 水库名称
	private String loc; // 所在地
	private String compYm; // 建成年月
	private String projScal; // 工程规模
	private String datTp; // 基面类型
	private float catA; // 集水面积
	private float desFz; // 设计洪水位
	private float totV; // 总库容
	private float frscV; // 调洪库容
	private float normWz; // 正常蓄水位
	private float cfZ; // 校核洪水位
	private float utilV; // 兴利库容
	private float fsZ; // 防洪限制水位
	private float fsZV; // 防洪限制水位库容
	private float deadZ; // 死水位
	private float deadV; // 死库容
	private String resRegTp; // 水库调节方式
	private float minDisc; // 最小下泄流量
	private float stEndLen; // 发电引水口至尾水口河道长度
	private String rhcc; // 水库枢纽建筑物组成
	private String runCond; // 运行状况
	private String engManCd; // 管理单位代码
	private String wsReg; // 供水范围
	private String ts; // 时间戳
	private String nt; // 备注
	private float lttd; // 坝址经度
	private float lgtd; // 坝址纬度
	private String zvcurveId; // 水位库容曲线id
	private String ftcurveId; // 下泄尾水曲线id
	private String whcurveId; // 水头预想出力曲线id
	private String zfcurveId; // 水位泄流能力曲线id
	private String iqwhcurveId; // 入库流量水头损失曲线id

	private String v0;		// v0
	private String v1;		// v1
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	public DdsBResVO() {
		super();
	}

	public String getResCd() {
		return resCd;
	}

	public void setResCd(String resCd) {
		this.resCd = resCd;
	}

	public String getResNm() {
		return resNm;
	}

	public void setResNm(String resNm) {
		this.resNm = resNm;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getCompYm() {
		return compYm;
	}

	public void setCompYm(String compYm) {
		this.compYm = compYm;
	}

	public String getProjScal() {
		return projScal;
	}

	public void setProjScal(String projScal) {
		this.projScal = projScal;
	}

	public String getDatTp() {
		return datTp;
	}

	public void setDatTp(String datTp) {
		this.datTp = datTp;
	}

	public float getCatA() {
		return catA;
	}

	public void setCatA(float catA) {
		this.catA = catA;
	}

	public float getDesFz() {
		return desFz;
	}

	public void setDesFz(float desFz) {
		this.desFz = desFz;
	}

	public float getTotV() {
		return totV;
	}

	public void setTotV(float totV) {
		this.totV = totV;
	}

	public float getFrscV() {
		return frscV;
	}

	public void setFrscV(float frscV) {
		this.frscV = frscV;
	}

	public float getNormWz() {
		return normWz;
	}

	public void setNormWz(float normWz) {
		this.normWz = normWz;
	}

	public float getCfZ() {
		return cfZ;
	}

	public void setCfZ(float cfZ) {
		this.cfZ = cfZ;
	}

	public float getUtilV() {
		return utilV;
	}

	public void setUtilV(float utilV) {
		this.utilV = utilV;
	}

	public float getFsZ() {
		return fsZ;
	}

	public void setFsZ(float fsZ) {
		this.fsZ = fsZ;
	}

	public float getFsZV() {
		return fsZV;
	}

	public void setFsZV(float fsZV) {
		this.fsZV = fsZV;
	}

	public float getDeadZ() {
		return deadZ;
	}

	public void setDeadZ(float deadZ) {
		this.deadZ = deadZ;
	}

	public float getDeadV() {
		return deadV;
	}

	public void setDeadV(float deadV) {
		this.deadV = deadV;
	}

	public String getResRegTp() {
		return resRegTp;
	}

	public void setResRegTp(String resRegTp) {
		this.resRegTp = resRegTp;
	}

	public float getMinDisc() {
		return minDisc;
	}

	public void setMinDisc(float minDisc) {
		this.minDisc = minDisc;
	}

	public float getStEndLen() {
		return stEndLen;
	}

	public void setStEndLen(float stEndLen) {
		this.stEndLen = stEndLen;
	}

	public String getRhcc() {
		return rhcc;
	}

	public void setRhcc(String rhcc) {
		this.rhcc = rhcc;
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

	public String getWsReg() {
		return wsReg;
	}

	public void setWsReg(String wsReg) {
		this.wsReg = wsReg;
	}

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

	public float getLttd() {
		return lttd;
	}

	public void setLttd(float lttd) {
		this.lttd = lttd;
	}

	public float getLgtd() {
		return lgtd;
	}

	public void setLgtd(float lgtd) {
		this.lgtd = lgtd;
	}

	public String getZvcurveId() {
		return zvcurveId;
	}

	public void setZvcurveId(String zvcurveId) {
		this.zvcurveId = zvcurveId;
	}

	public String getFtcurveId() {
		return ftcurveId;
	}

	public void setFtcurveId(String ftcurveId) {
		this.ftcurveId = ftcurveId;
	}

	public String getWhcurveId() {
		return whcurveId;
	}

	public void setWhcurveId(String whcurveId) {
		this.whcurveId = whcurveId;
	}

	public String getZfcurveId() {
		return zfcurveId;
	}

	public void setZfcurveId(String zfcurveId) {
		this.zfcurveId = zfcurveId;
	}

	public String getIqwhcurveId() {
		return iqwhcurveId;
	}

	public void setIqwhcurveId(String iqwhcurveId) {
		this.iqwhcurveId = iqwhcurveId;
	}

	public String getV0() {
		return v0;
	}

	public void setV0(String v0) {
		this.v0 = v0;
	}

	public String getV1() {
		return v1;
	}

	public void setV1(String v1) {
		this.v1 = v1;
	}
	
}