package com.jsite.busi.szy.dispatch.po;

import com.jsite.dao.AbstractData;
/**
 * 需水预测用水参数表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdWupar extends AbstractData<DdsRdWupar> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String adCd;		// 行政区划代码
	private Double dWsLr;		// 城市供水漏损率
	private Double crwsR;		// 乡镇集中供水率
	private Double crwsLr;		// 乡镇集中供水漏损率
    private Double indLr;
    private Double pdirR;
    private Double pwirR;
    private Double pvirR;
    private Double fiR;
    private Double aiR;

	public DdsRdWupar() {
		super();
	}

	public DdsRdWupar(String id){
		super(id);
	}

    public String getProCd() {
        return proCd;
    }

    public void setProCd(String proCd) {
        this.proCd = proCd;
    }

    public String getAdCd() {
        return adCd;
    }

    public void setAdCd(String adCd) {
        this.adCd = adCd;
    }

    public Double getdWsLr() {
        return dWsLr;
    }

    public void setdWsLr(Double dWsLr) {
        this.dWsLr = dWsLr;
    }

    public Double getCrwsR() {
        return crwsR;
    }

    public void setCrwsR(Double crwsR) {
        this.crwsR = crwsR;
    }

    public Double getCrwsLr() {
        return crwsLr;
    }

    public void setCrwsLr(Double crwsLr) {
        this.crwsLr = crwsLr;
    }

    public Double getIndLr() {
        return indLr;
    }

    public void setIndLr(Double indLr) {
        this.indLr = indLr;
    }

    public Double getPdirR() {
        return pdirR;
    }

    public void setPdirR(Double pdirR) {
        this.pdirR = pdirR;
    }

    public Double getPwirR() {
        return pwirR;
    }

    public void setPwirR(Double pwirR) {
        this.pwirR = pwirR;
    }

    public Double getPvirR() {
        return pvirR;
    }

    public void setPvirR(Double pvirR) {
        this.pvirR = pvirR;
    }

    public Double getFiR() {
        return fiR;
    }

    public void setFiR(Double fiR) {
        this.fiR = fiR;
    }

    public Double getAiR() {
        return aiR;
    }

    public void setAiR(Double aiR) {
        this.aiR = aiR;
    }
}