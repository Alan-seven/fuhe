package com.jsite.busi.szy.dispatch.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;
/**
 * 需水预测社会经济发展参数表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdDevpar extends AbstractData<DdsRdDevpar> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String adCd;		// 行政区划代码
	private Double totPopGr;		// 总人口增长率
	private Double dPopGr;		// 城市人口增长率
    private Double bhGr;		// 大牲畜增长率
	private Double shGr;		// 小牲畜增长率
	private Double irraGr;		// 农田有效灌溉面积增长率
	private Double pwirraGr;		// 水田有效灌溉面积增长率
	private Double pdirraGr;		// 水浇地有效灌溉面积增长率
	private Double pvirraGr;		// 菜田有效灌溉面积增长率
	private Double fiaGr;		// 林果地有效灌溉面积增长率
	private Double aiaGr;		// 草地有效灌溉面积增长率
	private Double fishaGr;		// 鱼塘补水面积增长率
	private Double indGr;		// 火（核）电工业工业增加值增长率
	private Double nindGr;		// 非火（核）电工业工业增加值增长率
	
	public DdsRdDevpar() {
		super();
	}

	public DdsRdDevpar(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=6, message="行政区划代码长度必须介于 1 和 6 之间")
	public String getAdCd() {
		return adCd;
	}

	public void setAdCd(String adCd) {
		this.adCd = adCd;
	}
	
	public Double getTotPopGr() {
		return totPopGr;
	}

	public void setTotPopGr(Double totPopGr) {
		this.totPopGr = totPopGr;
	}

    public Double getdPopGr() {
        return dPopGr;
    }

    public void setdPopGr(Double dPopGr) {
        this.dPopGr = dPopGr;
    }
	
	public Double getBhGr() {
		return bhGr;
	}

	public void setBhGr(Double bhGr) {
		this.bhGr = bhGr;
	}
	
	public Double getShGr() {
		return shGr;
	}

	public void setShGr(Double shGr) {
		this.shGr = shGr;
	}
	
	public Double getIrraGr() {
		return irraGr;
	}

	public void setIrraGr(Double irraGr) {
		this.irraGr = irraGr;
	}
	
	public Double getPwirraGr() {
		return pwirraGr;
	}

	public void setPwirraGr(Double pwirraGr) {
		this.pwirraGr = pwirraGr;
	}
	
	public Double getPdirraGr() {
		return pdirraGr;
	}

	public void setPdirraGr(Double pdirraGr) {
		this.pdirraGr = pdirraGr;
	}
	
	public Double getPvirraGr() {
		return pvirraGr;
	}

	public void setPvirraGr(Double pvirraGr) {
		this.pvirraGr = pvirraGr;
	}
	
	public Double getFiaGr() {
		return fiaGr;
	}

	public void setFiaGr(Double fiaGr) {
		this.fiaGr = fiaGr;
	}
	
	public Double getAiaGr() {
		return aiaGr;
	}

	public void setAiaGr(Double aiaGr) {
		this.aiaGr = aiaGr;
	}
	
	public Double getFishaGr() {
		return fishaGr;
	}

	public void setFishaGr(Double fishaGr) {
		this.fishaGr = fishaGr;
	}
	
	public Double getIndGr() {
		return indGr;
	}

	public void setIndGr(Double indGr) {
		this.indGr = indGr;
	}
	
	public Double getNindGr() {
		return nindGr;
	}

	public void setNindGr(Double nindGr) {
		this.nindGr = nindGr;
	}
	
}