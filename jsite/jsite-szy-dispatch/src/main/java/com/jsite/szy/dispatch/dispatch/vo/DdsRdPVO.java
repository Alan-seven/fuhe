package com.jsite.szy.dispatch.dispatch.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-09-25 15:37
 */
public class DdsRdPVO {
    private String proCd;		// 方案ID
    private String proNm;   // 方案名称
    private Date crDt;  // 创建时间
    private Date bgDt;		// 起始时间
    private Date edDt;		// 终止时间
    private String producer;		// 制作人
    private Integer sta;		// 完成状态
    private String nt;		// 方案描述

    public String getProCd() {
        return proCd;
    }

    public void setProCd(String proCd) {
        this.proCd = proCd;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getBgDt() {
        return bgDt;
    }

    public void setBgDt(Date bgDt) {
        this.bgDt = bgDt;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getEdDt() {
        return edDt;
    }

    public void setEdDt(Date edDt) {
        this.edDt = edDt;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getSta() {
        return sta;
    }

    public void setSta(Integer sta) {
        this.sta = sta;
    }

    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    public String getProNm() {
        return proNm;
    }

    public void setProNm(String proNm) {
        this.proNm = proNm;
    }
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getCrDt() {
        return crDt;
    }

    public void setCrDt(Date crDt) {
        this.crDt = crDt;
    }
}
