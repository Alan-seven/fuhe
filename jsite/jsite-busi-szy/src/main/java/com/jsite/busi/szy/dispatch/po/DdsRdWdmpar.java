package com.jsite.busi.szy.dispatch.po;

import com.jsite.dao.AbstractData;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
/**
 * 需水预测逐月分配系数表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdWdmpar extends AbstractData<DdsRdWdmpar> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String adCd;		// 用水单元代码
	private Integer month;		// 月份
	private Double pwmCoe;		// 生活分水比例
	private Double awmCoe;		// 农业分水比例
	private Double iwmCoe;		// 工业分水比例
    private Double lmyCoe;      // 林牧渔分水比例
	
	public DdsRdWdmpar() {
		super();
	}

	public DdsRdWdmpar(String id){
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
	public String getAdCd() {
		return adCd;
	}

	public void setAdCd(String adCd) {
		this.adCd = adCd;
	}
	
	@NotNull(message="月份不能为空")
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}
	
	public Double getPwmCoe() {
		return pwmCoe;
	}

	public void setPwmCoe(Double pwmCoe) {
		this.pwmCoe = pwmCoe;
	}
	
	public Double getAwmCoe() {
		return awmCoe;
	}

	public void setAwmCoe(Double awmCoe) {
		this.awmCoe = awmCoe;
	}
	
	public Double getIwmCoe() {
		return iwmCoe;
	}

	public void setIwmCoe(Double iwmCoe) {
		this.iwmCoe = iwmCoe;
	}

    public Double getLmyCoe() {
        return lmyCoe;
    }

    public void setLmyCoe(Double lmyCoe) {
        this.lmyCoe = lmyCoe;
    }
}