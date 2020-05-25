package com.jsite.busi.szy.dispatch.po;

import com.jsite.dao.AbstractData;

import java.util.List;

/**
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-10-09 14:54
 * 用水分区对应的用水单元的信息实体
 */
public class FqArea extends AbstractData<FqArea> {
    private String adCd; // 用水单元编号
    private String adNm; // 用水单元名称
    private List<WaData> waList;

    public String getAdCd() {
        return adCd;
    }

    public void setAdCd(String adCd) {
        this.adCd = adCd.trim();
    }

    public String getAdNm() {
        return adNm;
    }

    public void setAdNm(String adNm) {
        this.adNm = adNm.trim();
    }

    public List<WaData> getWaList() {
        return waList;
    }

    public void setWaList(List<WaData> waList) {
        this.waList = waList;
    }
}
