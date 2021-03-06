package com.jsite.busi.szy.dispatch.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;
/**
 * 水量分配表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdWares extends AbstractData<DdsRdWares> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String regCd;		// 用水单元ID
	private Integer rsTp;		// 分配类型
	private Date bt;
	private Date et;
	private Integer year;
	private Integer month;		// 月份
	private Integer dedade;
	private Double dRs;		// 城镇生活分水
	private Double uRs;		// 农村生活分水
	private Double bhRs;		// 大牲畜分水
	private Double shRs;		// 小牲畜分水
	private Double pwirRs;		// 水田灌溉分水
	private Double pdirRs;		// 水浇地灌溉分水
	private Double pvirRs;		// 菜田灌溉分水
	private Double fiRs;		// 林果地灌溉分水
	private Double aiRs;		// 草场灌溉分水
	private Double mfishRs;		// 鱼塘补水分水
	private Double indRs;		// 火核工业分水
	private Double nindRs;		// 非火核工业分水
	private Double totRs;		// 总计
    private String xun;
	
	public DdsRdWares() {
		super();
	}

	public DdsRdWares(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=16, message="用水单元ID长度必须介于 1 和 16 之间")
	public String getRegCd() {
		return regCd;
	}

	public void setRegCd(String regCd) {
		this.regCd = regCd;
	}
	
	@NotNull(message="分配类型不能为空")
	public Integer getRsTp() {
		return rsTp;
	}

	public void setRsTp(Integer rsTp) {
		this.rsTp = rsTp;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBt() {
		return bt;
	}

	public void setBt(Date bt) {
		this.bt = bt;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEt() {
		return et;
	}

	public void setEt(Date et) {
		this.et = et;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDedade() {
		return dedade;
	}

	public void setDedade(Integer dedade) {
		this.dedade = dedade;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}
	
	public Double getDRs() {
		return dRs;
	}

	public void setDRs(Double dRs) {
		this.dRs = dRs;
	}
	
	public Double getURs() {
		return uRs;
	}

	public void setURs(Double uRs) {
		this.uRs = uRs;
	}
	
	public Double getBhRs() {
		return bhRs;
	}

	public void setBhRs(Double bhRs) {
		this.bhRs = bhRs;
	}
	
	public Double getShRs() {
		return shRs;
	}

	public void setShRs(Double shRs) {
		this.shRs = shRs;
	}
	
	public Double getPwirRs() {
		return pwirRs;
	}

	public void setPwirRs(Double pwirRs) {
		this.pwirRs = pwirRs;
	}
	
	public Double getPdirRs() {
		return pdirRs;
	}

	public void setPdirRs(Double pdirRs) {
		this.pdirRs = pdirRs;
	}
	
	public Double getPvirRs() {
		return pvirRs;
	}

	public void setPvirRs(Double pvirRs) {
		this.pvirRs = pvirRs;
	}
	
	public Double getFiRs() {
		return fiRs;
	}

	public void setFiRs(Double fiRs) {
		this.fiRs = fiRs;
	}
	
	public Double getAiRs() {
		return aiRs;
	}

	public void setAiRs(Double aiRs) {
		this.aiRs = aiRs;
	}
	
	public Double getMfishRs() {
		return mfishRs;
	}

	public void setMfishRs(Double mfishRs) {
		this.mfishRs = mfishRs;
	}
	
	public Double getIndRs() {
		return indRs;
	}

	public void setIndRs(Double indRs) {
		this.indRs = indRs;
	}
	
	public Double getNindRs() {
		return nindRs;
	}

	public void setNindRs(Double nindRs) {
		this.nindRs = nindRs;
	}
	
	public Double getTotRs() {
		return totRs;
	}

	public void setTotRs(Double totRs) {
		this.totRs = totRs;
	}

    public String getXun() {
        return xun;
    }

    public void setXun(String xun) {
        this.xun = xun;
    }
}