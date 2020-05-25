package com.jsite.busi.szy.dispatch.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;
/**
 * 可供水量计算表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdWsa extends AbstractData<DdsRdWsa> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private Double ecoQ;		// 生态基流
	private Double inq;		// 天然来水量
	private Double totV;		// 水库蓄变量
	private Double reqW;		// 最大用水需求
	private Double uCe;		// 用水消耗系数
	private Double maxYrWs;		// 最大供水能力
	private Double swr;		// 地表水资源量
	private Double minRivWat;		// 河道最小环境需水量
	private Double fDq;		// 洪水弃水量
	private Double tq;		// 外调水量
	private Double cCea;		// 折算系数a
	private Double cCeb;		// 折算系数b
	private Double indCta;		// 用水总量控制指标
	private Double maxSl;		// 可供水量
	private Double resultsP;		// 正算法结果
	private Double resultsD;		// 倒算法结果
	private Double resultsEm;		// 经验公式法结果
	
	public DdsRdWsa() {
		super();
	}

    public DdsRdWsa(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}

    public Double getEcoQ() {
        return ecoQ;
    }

    public void setEcoQ(Double ecoQ) {
        this.ecoQ = ecoQ;
    }

    public Double getInq() {
        return inq;
    }

    public void setInq(Double inq) {
        this.inq = inq;
    }

    public Double getTotV() {
        return totV;
    }

    public void setTotV(Double totV) {
        this.totV = totV;
    }

    public Double getReqW() {
        return reqW;
    }

    public void setReqW(Double reqW) {
        this.reqW = reqW;
    }

    public Double getuCe() {
        return uCe;
    }

    public void setuCe(Double uCe) {
        this.uCe = uCe;
    }

    public Double getMaxYrWs() {
        return maxYrWs;
    }

    public void setMaxYrWs(Double maxYrWs) {
        this.maxYrWs = maxYrWs;
    }

    public Double getSwr() {
        return swr;
    }

    public void setSwr(Double swr) {
        this.swr = swr;
    }

    public Double getMinRivWat() {
        return minRivWat;
    }

    public void setMinRivWat(Double minRivWat) {
        this.minRivWat = minRivWat;
    }

    public Double getfDq() {
        return fDq;
    }

    public void setfDq(Double fDq) {
        this.fDq = fDq;
    }

    public Double getTq() {
        return tq;
    }

    public void setTq(Double tq) {
        this.tq = tq;
    }

    public Double getcCea() {
        return cCea;
    }

    public void setcCea(Double cCea) {
        this.cCea = cCea;
    }

    public Double getcCeb() {
        return cCeb;
    }

    public void setcCeb(Double cCeb) {
        this.cCeb = cCeb;
    }

    public Double getIndCta() {
        return indCta;
    }

    public void setIndCta(Double indCta) {
        this.indCta = indCta;
    }

    public Double getMaxSl() {
        return maxSl;
    }

    public void setMaxSl(Double maxSl) {
        this.maxSl = maxSl;
    }

    public Double getResultsP() {
        return resultsP;
    }

    public void setResultsP(Double resultsP) {
        this.resultsP = resultsP;
    }

    public Double getResultsD() {
        return resultsD;
    }

    public void setResultsD(Double resultsD) {
        this.resultsD = resultsD;
    }

    public Double getResultsEm() {
        return resultsEm;
    }

    public void setResultsEm(Double resultsEm) {
        this.resultsEm = resultsEm;
    }
}