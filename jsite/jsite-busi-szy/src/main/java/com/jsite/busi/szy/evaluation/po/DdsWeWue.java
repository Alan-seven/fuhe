package com.jsite.busi.szy.evaluation.po;

import com.jsite.dao.AbstractData;
import java.sql.Time;
/*import javax.persistence.*;*/

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 向靖
 * 创建时间：2017-10-10 10:48
 */
/*@Entity
@Table(name = "DDS_WE_WUE", schema = "JIANGXI", catalog = "")*/
public class DdsWeWue  extends AbstractData<DdsWeWue> {
    private static final long serialVersionUID = 1L;
    private String yr;
    private String regCd;
    private Long regType;
    private String adCd;
    private String wrzCd;
    private Double indIncWw;
    private Double indWwDecp;
    private Double gdpWw;
    private Double agrWwEff;
    private Time dt;
    private String nt;
    private Double gdpWwDecp;

    public String getYr() {
        return yr;
    }

    public void setYr(String yr) {
        this.yr = yr;
    }

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

    public String getAdCd() {
        return adCd;
    }

    public void setAdCd(String adCd) {
        this.adCd = adCd;
    }

    public String getWrzCd() {
        return wrzCd;
    }

    public void setWrzCd(String wrzCd) {
        this.wrzCd = wrzCd;
    }

    public Double getIndIncWw() {
        return indIncWw;
    }

    public void setIndIncWw(Double indIncWw) {
        this.indIncWw = indIncWw;
    }

    public Double getIndWwDecp() {
        return indWwDecp;
    }

    public void setIndWwDecp(Double indWwDecp) {
        this.indWwDecp = indWwDecp;
    }

    public Double getGdpWw() {
        return gdpWw;
    }

    public void setGdpWw(Double gdpWw) {
        this.gdpWw = gdpWw;
    }

    public Double getAgrWwEff() {
        return agrWwEff;
    }

    public void setAgrWwEff(Double agrWwEff) {
        this.agrWwEff = agrWwEff;
    }

    public Time getDt() {
        return dt;
    }

    public void setDt(Time dt) {
        this.dt = dt;
    }

    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    public Double getGdpWwDecp() {
        return gdpWwDecp;
    }

    public void setGdpWwDecp(Double gdpWwDecp) {
        this.gdpWwDecp = gdpWwDecp;
    }
}
