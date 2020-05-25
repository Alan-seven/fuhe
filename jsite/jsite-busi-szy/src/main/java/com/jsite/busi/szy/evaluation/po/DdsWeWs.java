package com.jsite.busi.szy.evaluation.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 供水量评价表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeWs extends AbstractData<DdsWeWs> {
	
	private static final long serialVersionUID = 1L;
	private String yr;		// 评价年份
	private String regCd;		// 分区代码
	private Long regType;		// 分区类型
	private Double wspWs;		// 地表水蓄水
	private Double lpWs;		// 地表水提水
	private Double wdWs;		// 地表水引水
	private Double inWs;		// 跨流域调水调入量
	private String inBsNm;		// 跨流域调水调入水流域名
	private Double osWs;		// 地表水非工程供水量
	private Double sgWs;		// 浅层地下水供水量
	private Double dgWs;		// 深层地下水供水量
	private Double braGwWs;		// 微咸地下水供水量
	private Double sewReu;		// 污水处理回用量
	private Double cpWs;		// 雨水利用供水量
	private Double sdWs;		// 海水淡化供水量
	private Double seaDirWu;		// 海水直接利用量
	private Date dt;		// 评价时间
	private String nt;		// 备注
    private Double under;
    private Double other;

	public DdsWeWs() {
		super();
	}

	public DdsWeWs(String id){
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
	
	public Double getWspWs() {
		return wspWs;
	}

	public void setWspWs(Double wspWs) {
		this.wspWs = wspWs;
	}
	
	public Double getLpWs() {
		return lpWs;
	}

	public void setLpWs(Double lpWs) {
		this.lpWs = lpWs;
	}
	
	public Double getWdWs() {
		return wdWs;
	}

	public void setWdWs(Double wdWs) {
		this.wdWs = wdWs;
	}
	
	public Double getInWs() {
		return inWs;
	}

	public void setInWs(Double inWs) {
		this.inWs = inWs;
	}
	
	@Length(min=0, max=60, message="跨流域调水调入水流域名长度必须介于 0 和 60 之间")
	public String getInBsNm() {
		return inBsNm;
	}

	public void setInBsNm(String inBsNm) {
		this.inBsNm = inBsNm;
	}
	
	public Double getOsWs() {
		return osWs;
	}

	public void setOsWs(Double osWs) {
		this.osWs = osWs;
	}
	
	public Double getSgWs() {
		return sgWs;
	}

	public void setSgWs(Double sgWs) {
		this.sgWs = sgWs;
	}
	
	public Double getDgWs() {
		return dgWs;
	}

	public void setDgWs(Double dgWs) {
		this.dgWs = dgWs;
	}
	
	public Double getBraGwWs() {
		return braGwWs;
	}

	public void setBraGwWs(Double braGwWs) {
		this.braGwWs = braGwWs;
	}
	
	public Double getSewReu() {
		return sewReu;
	}

	public void setSewReu(Double sewReu) {
		this.sewReu = sewReu;
	}
	
	public Double getCpWs() {
		return cpWs;
	}

	public void setCpWs(Double cpWs) {
		this.cpWs = cpWs;
	}
	
	public Double getSdWs() {
		return sdWs;
	}

	public void setSdWs(Double sdWs) {
		this.sdWs = sdWs;
	}
	
	public Double getSeaDirWu() {
		return seaDirWu;
	}

	public void setSeaDirWu(Double seaDirWu) {
		this.seaDirWu = seaDirWu;
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

    public Double getUnder() {
        return under;
    }

    public void setUnder(Double under) {
        this.under = under;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }
}