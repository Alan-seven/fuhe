package com.jsite.busi.szy.formal.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

import javax.validation.constraints.NotNull;

/**
 * 用水计划核定结果Entity
 * @author 用水计划核定结果
 * @version 2020-03-17
 */
public class TSfrdWtrplanVerRslt extends AbstractData<TSfrdWtrplanVerRslt> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案代码
	private String enCd;		// 实体代码
	private Date stDt;		// 起始时间
	private Date edDt;		// 终止时间
	private Double awWw;		// 水田灌溉年取用水量(万m3)
	private Double adWw;		// 水浇地灌溉年取用水量(万m3)
	private Double avWw;		// 菜田灌溉年取用水量(万m3)
	private Double irrGwWw;		// 农田灌溉年总取用地下水量(万m3)
	private Double fiWw;		// 林果灌溉年取用水量(万m3)
	private Double aiWw;		// 草场灌溉年取用水量(万m3)
	private Double fishWu;		// 鱼塘补水用水量(万m3)
	private Double rhWw;		// 牲畜用水年取用水量(万m3)
	private Double ffGwWw;		// 林牧渔畜年总取用地下水量(万m3)
	private Double ieWw;		// 直流式火（核）电工业年取用水量 (万m3)
	private Double ixeWw;		// 循环式火（核）电工业年取用水量 (万m3)
	private Double ioWw;		// 国有及规模以上工业年取用水量(万m3)
	private Double icWw;		// 规模以下工业年取用水量(万m3)
	private Double indGwWw;		// 工业年取用地下水量(万m3)
	private Double pbldWw;		// 城镇建筑业年取用水量(万m3)
	private Double psrvWw;		// 城镇服务业年取用水量(万m3)
	private Double pGwWw;		// 城镇公共年取用地下水量(万m3)
	private Double duWw;		// 城镇居民生活年取用水量(万m3)
	private Double drWw;		// 农村居民生活年取用水量(万m3)
	private Double dGwWw;		// 居民生活年总取用地下水量(万m3)
	private Double euWw;		// 城镇环境水用水量(万m3)
	private Double erWw;		// 农村环境年取用水量(万m3)
	private Double eGwWw;		// 生态环境年取用地下水量(万m3)
	private Double lifWw;		// 生活用水量(万m3)
	private Double agrWw;		// 农业用水量(万m3)
	private Double indWw;		// 工业用水量(万m3)
	private Double ecoWw;		// 生态用水量(万m3)
	private Double totW;		// 总水量(万m3)
	private Date ts;		// 时间戳
	private String nt;		// 备注
	
	public TSfrdWtrplanVerRslt() {
		super();
	}

	public TSfrdWtrplanVerRslt(String id){
		super(id);
	}
	@NotNull(message="方案代码不能为空")
	@Length(min=1, max=20, message="方案代码长度必须介于 1 和 20 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=9, message="实体代码长度必须介于 1 和 9 之间")
	public String getEnCd() {
		return enCd;
	}

	public void setEnCd(String enCd) {
		this.enCd = enCd;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="起始时间不能为空")
	public Date getStDt() {
		return stDt;
	}

	public void setStDt(Date stDt) {
		this.stDt = stDt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="终止时间不能为空")
	public Date getEdDt() {
		return edDt;
	}

	public void setEdDt(Date edDt) {
		this.edDt = edDt;
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
	
	public Double getLifWw() {
		return lifWw;
	}

	public void setLifWw(Double lifWw) {
		this.lifWw = lifWw;
	}
	
	public Double getAgrWw() {
		return agrWw;
	}

	public void setAgrWw(Double agrWw) {
		this.agrWw = agrWw;
	}
	
	public Double getIndWw() {
		return indWw;
	}

	public void setIndWw(Double indWw) {
		this.indWw = indWw;
	}
	
	public Double getEcoWw() {
		return ecoWw;
	}

	public void setEcoWw(Double ecoWw) {
		this.ecoWw = ecoWw;
	}
	
	public Double getTotW() {
		return totW;
	}

	public void setTotW(Double totW) {
		this.totW = totW;
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