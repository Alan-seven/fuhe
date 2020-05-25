package com.jsite.busi.szy.evaluation.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

/**
 * 耗水量评价表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeSstt extends AbstractData<DdsWeSstt> {
	
	private static final long serialVersionUID = 1L;
	private String yr;		// 评价年份
	private String regCd;		// 分区代码
	private Long regType;		// 分区类型
	private Double awWuR;		// 水田灌溉耗水率
	private Double awWuW;		// 水田灌溉耗水量
	private Double adWuR;		// 水浇地灌溉耗水率
	private Double adWuW;		// 水浇地灌溉耗水量
	private Double avWuR;		// 菜田灌溉耗水率
	private Double avWuW;		// 菜田灌溉耗水量
	private Double ffWuR;		// 林牧渔业灌溉耗水率
	private Double ffWuW;		// 林牧渔业灌溉耗水量
	private Double hdWuR;		// 牲畜耗水率
	private Double hdWuW;		// 牲畜耗水量
	private Double ieWuR;		// 直流式火电工业耗水率
	private Double ieWuW;		// 直流式火电工业耗水量
	private Double ixeWuR;		// 循环式火电工业耗水率
	private Double ixeWuW;		// 循环式火电工业耗水量
	private Double ioWuR;		// 非火电工业耗水率
	private Double ioWuW;		// 非火电工业耗水量
	private Double bldWuR;		// 建筑业耗水率
	private Double bldWuW;		// 建筑业耗水量
	private Double srvWuR;		// 服务业耗水率
	private Double srvWuW;		// 服务业耗水量
	private Double dWuR;		// 城镇生活耗水率
	private Double dWuW;		// 城镇生活耗水量
	private Double rWuR;		// 农村生活耗水率
	private Double rWuW;		// 农村生活耗水量
	private Double deWuR;		// 城镇生态耗水率
	private Double deWuW;		// 城镇生态耗水量
	private Double reWuR;		// 农村生态耗水率
	private Double reWuW;		// 农村生态耗水量
	private Double totWcR;		// 总耗水率
	private Double totWc;		// 总耗水量
	private Date dt;		// 评价时间
	private String nt;		// 备注
	
	public DdsWeSstt() {
		super();
	}

	public DdsWeSstt(String id){
		super(id);
	}

	@Length(min=1, max=4, message="评价年份长度必须介于 1 和 4 之间")
	public String getYr() {
		return yr;
	}

	public void setYr(String yr) {
		this.yr = yr;
	}
	
	@Length(min=1, max=13, message="分区代码长度必须介于 1 和 13 之间")
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
	
	public Double getAwWuR() {
		return awWuR;
	}

	public void setAwWuR(Double awWuR) {
		this.awWuR = awWuR;
	}
	
	public Double getAwWuW() {
		return awWuW;
	}

	public void setAwWuW(Double awWuW) {
		this.awWuW = awWuW;
	}
	
	public Double getAdWuR() {
		return adWuR;
	}

	public void setAdWuR(Double adWuR) {
		this.adWuR = adWuR;
	}
	
	public Double getAdWuW() {
		return adWuW;
	}

	public void setAdWuW(Double adWuW) {
		this.adWuW = adWuW;
	}
	
	public Double getAvWuR() {
		return avWuR;
	}

	public void setAvWuR(Double avWuR) {
		this.avWuR = avWuR;
	}
	
	public Double getAvWuW() {
		return avWuW;
	}

	public void setAvWuW(Double avWuW) {
		this.avWuW = avWuW;
	}
	
	public Double getFfWuR() {
		return ffWuR;
	}

	public void setFfWuR(Double ffWuR) {
		this.ffWuR = ffWuR;
	}
	
	public Double getFfWuW() {
		return ffWuW;
	}

	public void setFfWuW(Double ffWuW) {
		this.ffWuW = ffWuW;
	}
	
	public Double getHdWuR() {
		return hdWuR;
	}

	public void setHdWuR(Double hdWuR) {
		this.hdWuR = hdWuR;
	}
	
	public Double getHdWuW() {
		return hdWuW;
	}

	public void setHdWuW(Double hdWuW) {
		this.hdWuW = hdWuW;
	}
	
	public Double getIeWuR() {
		return ieWuR;
	}

	public void setIeWuR(Double ieWuR) {
		this.ieWuR = ieWuR;
	}
	
	public Double getIeWuW() {
		return ieWuW;
	}

	public void setIeWuW(Double ieWuW) {
		this.ieWuW = ieWuW;
	}
	
	public Double getIxeWuR() {
		return ixeWuR;
	}

	public void setIxeWuR(Double ixeWuR) {
		this.ixeWuR = ixeWuR;
	}
	
	public Double getIxeWuW() {
		return ixeWuW;
	}

	public void setIxeWuW(Double ixeWuW) {
		this.ixeWuW = ixeWuW;
	}
	
	public Double getIoWuR() {
		return ioWuR;
	}

	public void setIoWuR(Double ioWuR) {
		this.ioWuR = ioWuR;
	}
	
	public Double getIoWuW() {
		return ioWuW;
	}

	public void setIoWuW(Double ioWuW) {
		this.ioWuW = ioWuW;
	}
	
	public Double getBldWuR() {
		return bldWuR;
	}

	public void setBldWuR(Double bldWuR) {
		this.bldWuR = bldWuR;
	}
	
	public Double getBldWuW() {
		return bldWuW;
	}

	public void setBldWuW(Double bldWuW) {
		this.bldWuW = bldWuW;
	}
	
	public Double getSrvWuR() {
		return srvWuR;
	}

	public void setSrvWuR(Double srvWuR) {
		this.srvWuR = srvWuR;
	}
	
	public Double getSrvWuW() {
		return srvWuW;
	}

	public void setSrvWuW(Double srvWuW) {
		this.srvWuW = srvWuW;
	}
	
	public Double getDWuR() {
		return dWuR;
	}

	public void setDWuR(Double dWuR) {
		this.dWuR = dWuR;
	}
	
	public Double getDWuW() {
		return dWuW;
	}

	public void setDWuW(Double dWuW) {
		this.dWuW = dWuW;
	}
	
	public Double getRWuR() {
		return rWuR;
	}

	public void setRWuR(Double rWuR) {
		this.rWuR = rWuR;
	}
	
	public Double getRWuW() {
		return rWuW;
	}

	public void setRWuW(Double rWuW) {
		this.rWuW = rWuW;
	}
	
	public Double getDeWuR() {
		return deWuR;
	}

	public void setDeWuR(Double deWuR) {
		this.deWuR = deWuR;
	}
	
	public Double getDeWuW() {
		return deWuW;
	}

	public void setDeWuW(Double deWuW) {
		this.deWuW = deWuW;
	}
	
	public Double getReWuR() {
		return reWuR;
	}

	public void setReWuR(Double reWuR) {
		this.reWuR = reWuR;
	}
	
	public Double getReWuW() {
		return reWuW;
	}

	public void setReWuW(Double reWuW) {
		this.reWuW = reWuW;
	}
	
	public Double getTotWcR() {
		return totWcR;
	}

	public void setTotWcR(Double totWcR) {
		this.totWcR = totWcR;
	}
	
	public Double getTotWc() {
		return totWc;
	}

	public void setTotWc(Double totWc) {
		this.totWc = totWc;
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
	
}