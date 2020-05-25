package com.jsite.busi.szy.evaluation.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 水资源评价水库基本信息表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeWrcs extends AbstractData<DdsWeWrcs> {
	
	private static final long serialVersionUID = 1L;
	private String regCd;		// reg_cd
	private String regNm;		// reg_nm
	private String adCd;		// ad_cd
	private String wrzCd;		// wrz_cd
	private Double area;		// area
	private Double adW;		// ad_w
	private Double wrzW;		// wrz_w
	private String nt;		// nt
    private String regType;
    private String river;
	
	public DdsWeWrcs() {
		super();
	}

	public DdsWeWrcs(String id){
		super(id);
	}

	@Length(min=1, max=13, message="reg_cd长度必须介于 1 和 13 之间")
	public String getRegCd() {
		return regCd;
	}

	public void setRegCd(String regCd) {
		this.regCd = regCd;
	}
	
	@Length(min=0, max=128, message="reg_nm长度必须介于 0 和 128 之间")
	public String getRegNm() {
		return regNm;
	}

	public void setRegNm(String regNm) {
		this.regNm = regNm;
	}
	
	@Length(min=1, max=6, message="ad_cd长度必须介于 1 和 6 之间")
	public String getAdCd() {
		return adCd;
	}

	public void setAdCd(String adCd) {
		this.adCd = adCd;
	}
	
	@Length(min=1, max=7, message="wrz_cd长度必须介于 1 和 7 之间")
	public String getWrzCd() {
		return wrzCd;
	}

	public void setWrzCd(String wrzCd) {
		this.wrzCd = wrzCd;
	}
	
	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}
	
	public Double getAdW() {
		return adW;
	}

	public void setAdW(Double adW) {
		this.adW = adW;
	}
	
	public Double getWrzW() {
		return wrzW;
	}

	public void setWrzW(Double wrzW) {
		this.wrzW = wrzW;
	}
	
	@Length(min=0, max=256, message="nt长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public String getRiver() {
        return river;
    }

    public void setRiver(String river) {
        this.river = river;
    }
}