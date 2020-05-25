package com.jsite.busi.szy.dispatch.po;

import com.jsite.dao.AbstractData;

/**
 * 可供水量计算表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdWsahis extends AbstractData<DdsRdWsahis> {

	private static final long serialVersionUID = 1L;
	private Integer year;		// 年份
	private Double mwsc;		// 最大供水能力
	private Double swr;		// 地表水资源量
	private Double nr;		// 天然径流量
    private String river;   // 河流代码

	public DdsRdWsahis() {
		super();
	}

    public DdsRdWsahis(String id){
		super(id);
	}

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getMwsc() {
        return mwsc;
    }

    public void setMwsc(Double mwsc) {
        this.mwsc = mwsc;
    }

    public Double getSwr() {
        return swr;
    }

    public void setSwr(Double swr) {
        this.swr = swr;
    }

    public Double getNr() {
        return nr;
    }

    public void setNr(Double nr) {
        this.nr = nr;
    }

    public String getRiver() {
        return river;
    }

    public void setRiver(String river) {
        this.river = river;
    }
}