package com.jsite.busi.szy.dispatch.po;

/**
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-10-10 16:37
 */
public class WaData {
    private String wrcsCd;  // 用水区域编号
    private String wrcsNm;  // 用水区域名称

    public String getWrcsCd() {
        return wrcsCd;
    }

    public void setWrcsCd(String wrcsCd) {
        this.wrcsCd = wrcsCd.trim();
    }

    public String getWrcsNm() {
        return wrcsNm;
    }

    public void setWrcsNm(String wrcsNm) {
        this.wrcsNm = wrcsNm.trim();
    }
}
