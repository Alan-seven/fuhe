package com.jsite.busi.szy.evaluation.po;

import com.jsite.dao.AbstractData;
import java.sql.Time;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 向靖
 * 创建时间：2017-10-12 17:58
 */
public class DdsDDayq extends AbstractData<DdsDDayq> {
    private String stcd;
    private Time dt;
    private Long avq;
    private String avqrcd;

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

    public Long getAvq() {
        return avq;
    }

    public void setAvq(Long avq) {
        this.avq = avq;
    }

    public String getAvqrcd() {
        return avqrcd;
    }

    public void setAvqrcd(String avqrcd) {
        this.avqrcd = avqrcd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DdsDDayq ddsDDayq = (DdsDDayq) o;

        if (stcd != null ? !stcd.equals(ddsDDayq.stcd) : ddsDDayq.stcd != null) return false;
        if (dt != null ? !dt.equals(ddsDDayq.dt) : ddsDDayq.dt != null) return false;
        if (avq != null ? !avq.equals(ddsDDayq.avq) : ddsDDayq.avq != null) return false;
        if (avqrcd != null ? !avqrcd.equals(ddsDDayq.avqrcd) : ddsDDayq.avqrcd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stcd != null ? stcd.hashCode() : 0;
        result = 31 * result + (dt != null ? dt.hashCode() : 0);
        result = 31 * result + (avq != null ? avq.hashCode() : 0);
        result = 31 * result + (avqrcd != null ? avqrcd.hashCode() : 0);
        return result;
    }
}
