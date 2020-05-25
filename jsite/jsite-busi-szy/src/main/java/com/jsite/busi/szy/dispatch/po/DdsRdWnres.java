package com.jsite.busi.szy.dispatch.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;
/**
 * 需水预测结果表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdWnres extends AbstractData<DdsRdWnres> {
    private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String regCd;		// 用水单元代码
	private Integer month;		// 月份
	private Double dWat;		// 城镇居民需水量
	private Double uWat;		// 农村居民需水量
	private Double bhWat;		// 大牲畜需水量
	private Double shWat;		// 小牲畜需水量
	private Double pwirWat;		// 水田灌溉需水量
	private Double pdirWat;		// 水浇地灌溉需水量
	private Double pvirWat;		// 菜田灌溉需水量
    private Double fiWat;		// 林果灌溉需水量
	private Double aiWat;		// 草场灌溉需水量
	private Double fishWat;		// 鱼塘补水需水量
	private Double indWat;		// 火核需水量
	private Double nindWat;		// 非火核需水量
    private Double totWat;      // 总需水
    private String xun;
	
	public DdsRdWnres() {
		super();
	}

	public DdsRdWnres(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=13, message="用水单元代码长度必须介于 1 和 13 之间")
	public String getRegCd() {
		return regCd;
	}

	public void setRegCd(String regCd) {
		this.regCd = regCd;
	}
	
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

    public Double getdWat() {
        return dWat;
    }

    public void setdWat(Double dWat) {
        this.dWat = dWat;
    }

    public Double getuWat() {
        return uWat;
    }

    public void setuWat(Double uWat) {
        this.uWat = uWat;
    }

	public Double getBhWat() {
		return bhWat;
	}

	public void setBhWat(Double bhWat) {
		this.bhWat = bhWat;
	}
	
	public Double getShWat() {
		return shWat;
	}

	public void setShWat(Double shWat) {
		this.shWat = shWat;
	}
	
	public Double getPwirWat() {
		return pwirWat;
	}

	public void setPwirWat(Double pwirWat) {
		this.pwirWat = pwirWat;
	}
	
	public Double getPdirWat() {
		return pdirWat;
	}

	public void setPdirWat(Double pdirWat) {
		this.pdirWat = pdirWat;
	}
	
	public Double getPvirWat() {
		return pvirWat;
	}

	public void setPvirWat(Double pvirWat) {
		this.pvirWat = pvirWat;
	}
	
	public Double getFiWat() {
		return fiWat;
	}

	public void setFiWat(Double fiWat) {
		this.fiWat = fiWat;
	}
	
	public Double getAiWat() {
		return aiWat;
	}

	public void setAiWat(Double aiWat) {
		this.aiWat = aiWat;
	}
	
	public Double getFishWat() {
		return fishWat;
	}

	public void setFishWat(Double fishWat) {
		this.fishWat = fishWat;
	}
	
	public Double getIndWat() {
		return indWat;
	}

	public void setIndWat(Double indWat) {
		this.indWat = indWat;
	}
	
	public Double getNindWat() {
		return nindWat;
	}

	public void setNindWat(Double nindWat) {
		this.nindWat = nindWat;
	}

    public Double getTotWat() {
        return totWat;
    }

    public void setTotWat(Double totWat) {
        this.totWat = totWat;
    }

    public String getXun() {
        return xun;
    }

    public void setXun(String xun) {
        this.xun = xun;
    }
}