package com.jsite.busi.szy.info.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 仪器设备基本信息Entity
 * 
 * @author 徐旺旺
 * @version 2017-03-17
 */
public class DdsBRes extends AbstractData<DdsBRes> {

	private static final long serialVersionUID = 1L;
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

	public DdsBRes() {
		super();
	}

	public DdsBRes(String id) {
		super(id);
	}

	@Length(min = 1, max = 12, message = "水库代码长度必须介于 1 和 12 之间")
	public String getResCd() {
		return resCd;
	}

	public void setResCd(String resCd) {
		this.resCd = resCd;
	}

	@Length(min = 0, max = 100, message = "水库名称长度必须介于 0 和 100 之间")
	public String getResNm() {
		return resNm;
	}

	public void setResNm(String resNm) {
		this.resNm = resNm;
	}

	@Length(min = 0, max = 200, message = "所在地长度必须介于 0 和 200 之间")
	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Length(min = 0, max = 6, message = "建成年月长度必须介于 0 和 6 之间")
	public String getCompYm() {
		return compYm;
	}

	public void setCompYm(String compYm) {
		this.compYm = compYm;
	}

	@Length(min = 0, max = 1, message = "工程规模长度必须介于 0 和 1 之间")
	public String getProjScal() {
		return projScal;
	}

	public void setProjScal(String projScal) {
		this.projScal = projScal;
	}

	@Length(min = 0, max = 2, message = "基面类型长度必须介于 0 和 2 之间")
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

	@Length(min = 0, max = 1, message = "水库调节方式长度必须介于 0 和 1 之间")
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

	@Length(min = 0, max = 256, message = "水库枢纽建筑物组成长度必须介于 0 和 256 之间")
	public String getRhcc() {
		return rhcc;
	}

	public void setRhcc(String rhcc) {
		this.rhcc = rhcc;
	}

	@Length(min = 0, max = 1, message = "运行状况长度必须介于 0 和 1 之间")
	public String getRunCond() {
		return runCond;
	}

	public void setRunCond(String runCond) {
		this.runCond = runCond;
	}

	@Length(min = 0, max = 9, message = "管理单位代码长度必须介于 0 和 9 之间")
	public String getEngManCd() {
		return engManCd;
	}

	public void setEngManCd(String engManCd) {
		this.engManCd = engManCd;
	}

	@Length(min = 0, max = 256, message = "供水范围长度必须介于 0 和 256 之间")
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

	@Length(min = 0, max = 256, message = "备注长度必须介于 0 和 256 之间")
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

	@Length(min = 0, max = 10, message = "水位库容曲线id长度必须介于 0 和 10 之间")
	public String getZvcurveId() {
		return zvcurveId;
	}

	public void setZvcurveId(String zvcurveId) {
		this.zvcurveId = zvcurveId;
	}

	@Length(min = 0, max = 10, message = "下泄尾水曲线id长度必须介于 0 和 10 之间")
	public String getFtcurveId() {
		return ftcurveId;
	}

	public void setFtcurveId(String ftcurveId) {
		this.ftcurveId = ftcurveId;
	}

	@Length(min = 0, max = 10, message = "水头预想出力曲线id长度必须介于 0 和 10 之间")
	public String getWhcurveId() {
		return whcurveId;
	}

	public void setWhcurveId(String whcurveId) {
		this.whcurveId = whcurveId;
	}

	@Length(min = 0, max = 10, message = "水位泄流能力曲线id长度必须介于 0 和 10 之间")
	public String getZfcurveId() {
		return zfcurveId;
	}

	public void setZfcurveId(String zfcurveId) {
		this.zfcurveId = zfcurveId;
	}

	@Length(min = 0, max = 10, message = "入库流量水头损失曲线id长度必须介于 0 和 10 之间")
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