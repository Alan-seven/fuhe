package com.jsite.busi.szy.evaluation.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 用水量评价表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeWu extends AbstractData<DdsWeWu> {
	
	private static final long serialVersionUID = 1L;
	private String yr;		// 评价年份
	private String regCd;		// 分区代码
	private Long regType;		// 分区类型
	private Double awWw;		// 水田灌溉年取用水量
	private Double adWw;		// 水浇地灌溉年取用水量
	private Double avWw;		// 菜田灌溉年取用水量
	private Double irrGwWw;		// 农田灌溉年取用地下水量
	private Double fiWw;		// 林果灌溉年取用水量
	private Double aiWw;		// 草场灌溉年取用水量
	private Double fishWu;		// 鱼塘补水用水量
	private Double rhWw;		// 牲畜用水年取用水量
	private Double ffGwWw;		// 林牧渔畜年取用地下水量
	private Double ieWw;		// 直流式火电年取用水量
	private Double ixeWw;		// 循环式火电年取用水量
	private Double ioWw;		// 国有及规模以上年取用水量
	private Double icWw;		// 规模以下年取用水量
	private Double indGwWw;		// 工业年取用地下水量
	private Double pbldWw;		// 城镇建筑业年取用水量
	private Double psrvWw;		// 城镇服务业年取用水量
	private Double pGwWw;		// 城镇公共取用地下水量
	private Double duWw;		// 城镇居民生活年取用水量
	private Double drWw;		// 农村居民生活年取用水量
	private Double dGwWw;		// 居民生活年取用地下水量
	private Double euWw;		// 城镇环境年取用水量
	private Double erWw;		// 农村环境年取用水量
	private Double eGwWw;		// 生态环境年取用地下水量
	private Double totW;		// 总用水量
	private Date dt;		// 评价时间
	private String nt;		// 备注
	
	public DdsWeWu() {
		super();
	}

	public DdsWeWu(String id){
		super(id);
	}

	@Length(min=1, max=4, message="评价年份长度必须介于 1 和 4 之间")
	public String getYr() {
		return yr;
	}

	public void setYr(String yr) {
		this.yr = yr;
	}
	
	@Length(min=1, max=14, message="分区代码长度必须介于 1 和 14 之间")
	public String getRegCd() {
		return regCd;
	}

	public void setRegCd(String regCd) {
		this.regCd = regCd;
	}
	
	public Long getRegType() {
		return regType;
	}

	public void setRegType(Long regType) {
		this.regType = regType;
	}
	
	public Double getAwWw() {
		return awWw;
	}

	public void setAwWw(Double awWw) {
		this.awWw = awWw;
	}
	
	public Double getAdWw() {
		return adWw;
	}

	public void setAdWw(Double adWw) {
		this.adWw = adWw;
	}
	
	public Double getAvWw() {
		return avWw;
	}

	public void setAvWw(Double avWw) {
		this.avWw = avWw;
	}
	
	public Double getIrrGwWw() {
		return irrGwWw;
	}

	public void setIrrGwWw(Double irrGwWw) {
		this.irrGwWw = irrGwWw;
	}
	
	public Double getFiWw() {
		return fiWw;
	}

	public void setFiWw(Double fiWw) {
		this.fiWw = fiWw;
	}
	
	public Double getAiWw() {
		return aiWw;
	}

	public void setAiWw(Double aiWw) {
		this.aiWw = aiWw;
	}
	
	public Double getFishWu() {
		return fishWu;
	}

	public void setFishWu(Double fishWu) {
		this.fishWu = fishWu;
	}
	
	public Double getRhWw() {
		return rhWw;
	}

	public void setRhWw(Double rhWw) {
		this.rhWw = rhWw;
	}
	
	public Double getFfGwWw() {
		return ffGwWw;
	}

	public void setFfGwWw(Double ffGwWw) {
		this.ffGwWw = ffGwWw;
	}
	
	public Double getIeWw() {
		return ieWw;
	}

	public void setIeWw(Double ieWw) {
		this.ieWw = ieWw;
	}
	
	public Double getIxeWw() {
		return ixeWw;
	}

	public void setIxeWw(Double ixeWw) {
		this.ixeWw = ixeWw;
	}
	
	public Double getIoWw() {
		return ioWw;
	}

	public void setIoWw(Double ioWw) {
		this.ioWw = ioWw;
	}
	
	public Double getIcWw() {
		return icWw;
	}

	public void setIcWw(Double icWw) {
		this.icWw = icWw;
	}
	
	public Double getIndGwWw() {
		return indGwWw;
	}

	public void setIndGwWw(Double indGwWw) {
		this.indGwWw = indGwWw;
	}
	
	public Double getPbldWw() {
		return pbldWw;
	}

	public void setPbldWw(Double pbldWw) {
		this.pbldWw = pbldWw;
	}
	
	public Double getPsrvWw() {
		return psrvWw;
	}

	public void setPsrvWw(Double psrvWw) {
		this.psrvWw = psrvWw;
	}
	
	public Double getPGwWw() {
		return pGwWw;
	}

	public void setPGwWw(Double pGwWw) {
		this.pGwWw = pGwWw;
	}
	
	public Double getDuWw() {
		return duWw;
	}

	public void setDuWw(Double duWw) {
		this.duWw = duWw;
	}
	
	public Double getDrWw() {
		return drWw;
	}

	public void setDrWw(Double drWw) {
		this.drWw = drWw;
	}
	
	public Double getDGwWw() {
		return dGwWw;
	}

	public void setDGwWw(Double dGwWw) {
		this.dGwWw = dGwWw;
	}
	
	public Double getEuWw() {
		return euWw;
	}

	public void setEuWw(Double euWw) {
		this.euWw = euWw;
	}
	
	public Double getErWw() {
		return erWw;
	}

	public void setErWw(Double erWw) {
		this.erWw = erWw;
	}
	
	public Double getEGwWw() {
		return eGwWw;
	}

	public void setEGwWw(Double eGwWw) {
		this.eGwWw = eGwWw;
	}
	
	public Double getTotW() {
		return totW;
	}

	public void setTotW(Double totW) {
		this.totW = totW;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}