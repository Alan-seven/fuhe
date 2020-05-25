package com.jsite.busi.szy.evaluation.po;

import com.jsite.dao.AbstractData;
import java.sql.Time;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 向靖
 * 创建时间：2017-10-12 17:58
 */
public class DdsDDayp extends AbstractData<DdsDDayp> {
    private String stcd;
    private Time dt;
    private Long p;
    private String prcd;

    public String getStcd() {
        return stcd;
    }

    public void setStcd(String stcd) {
        this.stcd = stcd;
    }

    public Time getDt() {
        return dt;
    }

    public void setDt(Time dt) {
        this.dt = dt;
    }

    public Long getP() {
        return p;
    }

    public void setP(Long p) {
        this.p = p;
    }

    public String getPrcd() {
        return prcd;
    }

    public void setPrcd(String prcd) {
        this.prcd = prcd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DdsDDayp ddsDDayp = (DdsDDayp) o;

        if (stcd != null ? !stcd.equals(ddsDDayp.stcd) : ddsDDayp.stcd != null) return false;
        if (dt != null ? !dt.equals(ddsDDayp.dt) : ddsDDayp.dt != null) return false;
        if (p != null ? !p.equals(ddsDDayp.p) : ddsDDayp.p != null) return false;
        if (prcd != null ? !prcd.equals(ddsDDayp.prcd) : ddsDDayp.prcd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stcd != null ? stcd.hashCode() : 0;
        result = 31 * result + (dt != null ? dt.hashCode() : 0);
        result = 31 * result + (p != null ? p.hashCode() : 0);
        result = 31 * result + (prcd != null ? prcd.hashCode() : 0);
        return result;
    }
}
