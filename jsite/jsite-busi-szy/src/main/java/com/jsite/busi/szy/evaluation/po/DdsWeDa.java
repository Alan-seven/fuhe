package com.jsite.busi.szy.evaluation.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 废污水排放量评价表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeDa extends AbstractData<DdsWeDa> {
	
	private static final long serialVersionUID = 1L;
	private String yr;		// 评价年份
	private String regCd;		// 分区代码
	private Long regType;		// 分区类型
	private Double townLifeDa;		// 城镇居民生活污水排放量
	private Double indSewDa;		// 工业废水排放量
	private Double bldDa;		// 建筑业废水排放量
	private Double srvDa;		// 第三产业废水排放量
	private Double ieyDa;		// 火电厂直流式冷却水排放量
	private Double imyDa;		// 矿坑排放量
	private Double rivDa;		// 入河排放量
	private Date dt;		// 评价时间
	private String nt;		// 备注
    private Double area;
	
	public DdsWeDa() {
		super();
	}

	public DdsWeDa(String id){
		super(id);
	}

	@Length(min=1, max=4, message="评价年份长度必须介于 1 和 4 之间")
	public String getYr() {
		return yr;
	}

	public void setYr(String yr) {
		this.yr = yr;
	}
	
	@Length(min=1, max=14, message="分区代码长度必须介于 1 和 14 之间")
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
	
	public Double getTownLifeDa() {
		return townLifeDa;
	}

	public void setTownLifeDa(Double townLifeDa) {
		this.townLifeDa = townLifeDa;
	}
	
	public Double getIndSewDa() {
		return indSewDa;
	}

	public void setIndSewDa(Double indSewDa) {
		this.indSewDa = indSewDa;
	}
	
	public Double getBldDa() {
		return bldDa;
	}

	public void setBldDa(Double bldDa) {
		this.bldDa = bldDa;
	}
	
	public Double getSrvDa() {
		return srvDa;
	}

	public void setSrvDa(Double srvDa) {
		this.srvDa = srvDa;
	}
	
	public Double getIeyDa() {
		return ieyDa;
	}

	public void setIeyDa(Double ieyDa) {
		this.ieyDa = ieyDa;
	}
	
	public Double getImyDa() {
		return imyDa;
	}

	public void setImyDa(Double imyDa) {
		this.imyDa = imyDa;
	}
	
	public Double getRivDa() {
		return rivDa;
	}

	public void setRivDa(Double rivDa) {
		this.rivDa = rivDa;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}