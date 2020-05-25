package com.jsite.szy.dispatch.info.vo;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 入河排污口基本信息表Entity
 * @author hjx
 * @version 2017-04-26
 */
public class DdsBPdoVO extends PageVO {
	
	private String pdoCd;		// 入河排污口代码
	private String pdoNm;		// 入河排污口名称
	private String wdpcCd;		// 排污许可证代码
	private String addr;		// 地址
	private String pdoTp;		// 入河排污口性质
	private Date compDt;		// 建成日期
	private String emisTp;		// 排放方式
	private String inRvTp;		// 入河方式
	private String dwbNm;		// 排入水体名称
	private String wfzCd;		// 排入水功能区名称
	private Double desPollCap;	// 设计日排污能力
	private String pdoSize;		// 排污口管径
	private String runCond;		// 运行状况
	private String engManCd;		// 管理单位代码
	private Date ts;		// 时间戳
	private String nt;		// 备注
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	public DdsBPdoVO() {
		super();
	}

	@Length(min=1, max=12, message="入河排污口代码长度必须介于 1 和 12 之间")
	public String getPdoCd() {
		return pdoCd;
	}

	public void setPdoCd(String pdoCd) {
		this.pdoCd = pdoCd;
	}
	
	@Length(min=0, max=100, message="入河排污口名称长度必须介于 0 和 100 之间")
	public String getPdoNm() {
		return pdoNm;
	}

	public void setPdoNm(String pdoNm) {
		this.pdoNm = pdoNm;
	}
	
	@Length(min=0, max=18, message="排污许可证代码长度必须介于 0 和 18 之间")
	public String getWdpcCd() {
		return wdpcCd;
	}

	public void setWdpcCd(String wdpcCd) {
		this.wdpcCd = wdpcCd;
	}
	
	@Length(min=0, max=100, message="地址长度必须介于 0 和 100 之间")
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Length(min=0, max=1, message="入河排污口性质长度必须介于 0 和 1 之间")
	public String getPdoTp() {
		return pdoTp;
	}

	public void setPdoTp(String pdoTp) {
		this.pdoTp = pdoTp;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCompDt() {
		return compDt;
	}

	public void setCompDt(Date compDt) {
		this.compDt = compDt;
	}
	
	@Length(min=0, max=1, message="排放方式长度必须介于 0 和 1 之间")
	public String getEmisTp() {
		return emisTp;
	}

	public void setEmisTp(String emisTp) {
		this.emisTp = emisTp;
	}
	
	@Length(min=0, max=1, message="入河方式长度必须介于 0 和 1 之间")
	public String getInRvTp() {
		return inRvTp;
	}

	public void setInRvTp(String inRvTp) {
		this.inRvTp = inRvTp;
	}
	
	@Length(min=0, max=100, message="排入水体名称长度必须介于 0 和 100 之间")
	public String getDwbNm() {
		return dwbNm;
	}

	public void setDwbNm(String dwbNm) {
		this.dwbNm = dwbNm;
	}
	
	@Length(min=0, max=14, message="排入水功能区名称长度必须介于 0 和 14 之间")
	public String getWfzCd() {
		return wfzCd;
	}

	public void setWfzCd(String wfzCd) {
		this.wfzCd = wfzCd;
	}
	
	public Double getDesPollCap() {
		return desPollCap;
	}

	public void setDesPollCap(Double desPollCap) {
		this.desPollCap = desPollCap;
	}
	
	@Length(min=0, max=20, message="排污口管径长度必须介于 0 和 20 之间")
	public String getPdoSize() {
		return pdoSize;
	}

	public void setPdoSize(String pdoSize) {
		this.pdoSize = pdoSize;
	}
	
	@Length(min=0, max=1, message="运行状况长度必须介于 0 和 1 之间")
	public String getRunCond() {
		return runCond;
	}

	public void setRunCond(String runCond) {
		this.runCond = runCond;
	}
	
	@Length(min=0, max=9, message="管理单位代码长度必须介于 0 和 9 之间")
	public String getEngManCd() {
		return engManCd;
	}

	public void setEngManCd(String engManCd) {
		this.engManCd = engManCd;
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
	
}