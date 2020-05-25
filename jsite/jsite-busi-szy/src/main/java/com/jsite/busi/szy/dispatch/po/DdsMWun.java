package com.jsite.busi.szy.dispatch.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 用水定额表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsMWun extends AbstractData<DdsMWun> {
	
	private static final long serialVersionUID = 1L;
	private String adCd;		// 行政区划代码
	private Double dWun;		// 城市生活用水定额
	private Double rWun;		// 农村生活用水定额
	private Double bhWun;		// 大牲畜用水定额
	private Double shWun;		// 小牲畜用水定额
	private Double irrWun;		// 农田综合灌溉定额
	private Double pwirWun;		// 水田灌溉定额
	private Double pdIrWun;		// 水浇地灌溉定额
	private Double pvIrWun;		// 菜田灌溉定额
	private Double fiWun;		// 林果地综合灌溉定额
	private Double aiWun;		// 草地综合灌溉定额
	private Double mfishWat;		// 鱼塘补水需水定额
	private Double indWun;		// 火（核）电工业工业增加值用水定额
	private Double nindWun;		// 非火（核）电工业工业增加值用水定额
	
	public DdsMWun() {
		super();
	}

	public DdsMWun(String id){
		super(id);
	}

	@Length(min=1, max=6, message="行政区划代码长度必须介于 1 和 6 之间")
	public String getAdCd() {
		return adCd;
	}

	public void setAdCd(String adCd) {
		this.adCd = adCd;
	}
	
	public Double getDWun() {
		return dWun;
	}

	public void setDWun(Double dWun) {
		this.dWun = dWun;
	}
	
	public Double getRWun() {
		return rWun;
	}

	public void setRWun(Double rWun) {
		this.rWun = rWun;
	}
	
	public Double getBhWun() {
		return bhWun;
	}

	public void setBhWun(Double bhWun) {
		this.bhWun = bhWun;
	}
	
	public Double getShWun() {
		return shWun;
	}

	public void setShWun(Double shWun) {
		this.shWun = shWun;
	}
	
	public Double getIrrWun() {
		return irrWun;
	}

	public void setIrrWun(Double irrWun) {
		this.irrWun = irrWun;
	}
	
	public Double getPwirWun() {
		return pwirWun;
	}

	public void setPwirWun(Double pwirWun) {
		this.pwirWun = pwirWun;
	}
	
	public Double getPdIrWun() {
		return pdIrWun;
	}

	public void setPdIrWun(Double pdIrWun) {
		this.pdIrWun = pdIrWun;
	}
	
	public Double getPvIrWun() {
		return pvIrWun;
	}

	public void setPvIrWun(Double pvIrWun) {
		this.pvIrWun = pvIrWun;
	}
	
	public Double getFiWun() {
		return fiWun;
	}

	public void setFiWun(Double fiWun) {
		this.fiWun = fiWun;
	}
	
	public Double getAiWun() {
		return aiWun;
	}

	public void setAiWun(Double aiWun) {
		this.aiWun = aiWun;
	}
	
	public Double getMfishWat() {
		return mfishWat;
	}

	public void setMfishWat(Double mfishWat) {
		this.mfishWat = mfishWat;
	}
	
	public Double getIndWun() {
		return indWun;
	}

	public void setIndWun(Double indWun) {
		this.indWun = indWun;
	}
	
	public Double getNindWun() {
		return nindWun;
	}

	public void setNindWun(Double nindWun) {
		this.nindWun = nindWun;
	}
	
}