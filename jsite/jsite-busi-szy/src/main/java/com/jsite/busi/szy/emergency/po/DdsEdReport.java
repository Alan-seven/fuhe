package com.jsite.busi.szy.emergency.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;


/**
 * 应急事件处置报告表Entity
 * @author hjx
 * @version 2017-06-08
 */
public class DdsEdReport extends AbstractData<DdsEdReport> {
	
	private static final long serialVersionUID = 1L;
	private String evenCd;		// 事件ID
	private String repCd;		// 报表ID
	private String orgNm;		// 单位名称
	private Integer repNum;		// 事件期数
	private Date repTime;		// 时间
	private String evenInfo;		// 基本情况
	private Date evenTm;		// 发生时间
	private String cause;		// 事件发生原因
	private String udsect;		// 上下游断面位置说明
	private String pol;		// 主要污染物
	private String mpItem;		// 监测项目
	private String mpFre;		// 监测频次
	private String rangIhd;		// 污染影像范围
	private String ihdDes;		// 损失和影像情况
	private String mainMt;		// 已采取措施
	private String mtSug;		// 减轻危害措施建议
	private String nt;		// 备注
	
	public DdsEdReport() {
		super();
	}

	public DdsEdReport(String id){
		super(id);
	}

	@Length(min=1, max=8, message="事件ID长度必须介于 1 和 8 之间")
	public String getEvenCd() {
		return evenCd;
	}

	public void setEvenCd(String evenCd) {
		this.evenCd = evenCd;
	}
	
	@Length(min=1, max=8, message="报表ID长度必须介于 1 和 8 之间")
	public String getRepCd() {
		return repCd;
	}

	public void setRepCd(String repCd) {
		this.repCd = repCd;
	}
	
	@Length(min=0, max=64, message="单位名称长度必须介于 0 和 64 之间")
	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}
	
	public Integer getRepNum() {
		return repNum;
	}

	public void setRepNum(Integer repNum) {
		this.repNum = repNum;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRepTime() {
		return repTime;
	}

	public void setRepTime(Date repTime) {
		this.repTime = repTime;
	}
	
	@Length(min=0, max=256, message="基本情况长度必须介于 0 和 256 之间")
	public String getEvenInfo() {
		return evenInfo;
	}

	public void setEvenInfo(String evenInfo) {
		this.evenInfo = evenInfo;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEvenTm() {
		return evenTm;
	}

	public void setEvenTm(Date evenTm) {
		this.evenTm = evenTm;
	}
	
	@Length(min=0, max=256, message="事件发生原因长度必须介于 0 和 256 之间")
	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
	
	@Length(min=0, max=256, message="上下游断面位置说明长度必须介于 0 和 256 之间")
	public String getUdsect() {
		return udsect;
	}

	public void setUdsect(String udsect) {
		this.udsect = udsect;
	}
	
	@Length(min=0, max=64, message="主要污染物长度必须介于 0 和 64 之间")
	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}
	
	@Length(min=0, max=64, message="监测项目长度必须介于 0 和 64 之间")
	public String getMpItem() {
		return mpItem;
	}

	public void setMpItem(String mpItem) {
		this.mpItem = mpItem;
	}
	
	@Length(min=0, max=64, message="监测频次长度必须介于 0 和 64 之间")
	public String getMpFre() {
		return mpFre;
	}

	public void setMpFre(String mpFre) {
		this.mpFre = mpFre;
	}
	
	@Length(min=0, max=64, message="污染影像范围长度必须介于 0 和 64 之间")
	public String getRangIhd() {
		return rangIhd;
	}

	public void setRangIhd(String rangIhd) {
		this.rangIhd = rangIhd;
	}
	
	@Length(min=0, max=256, message="损失和影像情况长度必须介于 0 和 256 之间")
	public String getIhdDes() {
		return ihdDes;
	}

	public void setIhdDes(String ihdDes) {
		this.ihdDes = ihdDes;
	}
	
	@Length(min=0, max=256, message="已采取措施长度必须介于 0 和 256 之间")
	public String getMainMt() {
		return mainMt;
	}

	public void setMainMt(String mainMt) {
		this.mainMt = mainMt;
	}
	
	@Length(min=0, max=256, message="减轻危害措施建议长度必须介于 0 和 256 之间")
	public String getMtSug() {
		return mtSug;
	}

	public void setMtSug(String mtSug) {
		this.mtSug = mtSug;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}