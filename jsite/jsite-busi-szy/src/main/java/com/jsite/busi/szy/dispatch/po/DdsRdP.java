package com.jsite.busi.szy.dispatch.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.jsite.dao.AbstractData;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;
/**
 * 常规调度方案信息表Entity
 * @author hjx
 * @version 2017-09-22
 */
public class DdsRdP extends AbstractData<DdsRdP> {
	
	private static final long serialVersionUID = 1L;
	private String proCd;		// 方案ID
	private String proTp;		// 方案类型
	private String proNm;		// 方案名称
	private String subCd;		// 专题代码
	private String rvCd;		// 河流代码
	private Integer yr;		// 年份
	private Integer dpCyc;		// 调度周期
	private Date bgDt;		// 起始时间
	private Date edDt;		// 终止时间
	private String producer;		// 制作人
	private Date crDt;		// 制作时间
	private String dpplCd;		// 父方案ID
	private Integer pubSta;		// 发布状态
	private Date pubDate;		// 发布时间
	private Integer sta;		// 完成状态
	private Integer evaSta;		// 评价状态
	private String evaContext;		// 评价内容
	private Date ts;		// 时间戳
	private String nt;		// 方案描述
	private String river;		// 河流标识
    private Integer byr; // 基准年

    private List<DdsRdEva> list = Lists.newArrayList();

    public DdsRdP() {
		super();
	}

	public DdsRdP(String id){
		super(id);
	}

	@Length(min=1, max=13, message="方案ID长度必须介于 1 和 13 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=0, max=10, message="方案类型长度必须介于 0 和 10 之间")
	public String getProTp() {
		return proTp;
	}

	public void setProTp(String proTp) {
		this.proTp = proTp;
	}
	
	@Length(min=0, max=64, message="方案名称长度必须介于 0 和 64 之间")
	public String getProNm() {
		return proNm;
	}

	public void setProNm(String proNm) {
		this.proNm = proNm;
	}
	
	@Length(min=0, max=8, message="专题代码长度必须介于 0 和 8 之间")
	public String getSubCd() {
		return subCd;
	}

	public void setSubCd(String subCd) {
		this.subCd = subCd;
	}
	
	@Length(min=0, max=12, message="河流代码长度必须介于 0 和 12 之间")
	public String getRvCd() {
		return rvCd;
	}

	public void setRvCd(String rvCd) {
		this.rvCd = rvCd;
	}
	
	public Integer getYr() {
		return yr;
	}

	public void setYr(Integer yr) {
		this.yr = yr;
	}
	
	public Integer getDpCyc() {
		return dpCyc;
	}

	public void setDpCyc(Integer dpCyc) {
		this.dpCyc = dpCyc;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBgDt() {
		return bgDt;
	}

	public void setBgDt(Date bgDt) {
		this.bgDt = bgDt;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEdDt() {
		return edDt;
	}

	public void setEdDt(Date edDt) {
		this.edDt = edDt;
	}
	
	@Length(min=0, max=64, message="制作人长度必须介于 0 和 64 之间")
	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCrDt() {
		return crDt;
	}

	public void setCrDt(Date crDt) {
		this.crDt = crDt;
	}
	
	@Length(min=0, max=13, message="父方案ID长度必须介于 0 和 13 之间")
	public String getDpplCd() {
		return dpplCd;
	}

	public void setDpplCd(String dpplCd) {
		this.dpplCd = dpplCd;
	}
	
	public Integer getPubSta() {
		return pubSta;
	}

	public void setPubSta(Integer pubSta) {
		this.pubSta = pubSta;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	
	public Integer getSta() {
		return sta;
	}

	public void setSta(Integer sta) {
		this.sta = sta;
	}
	
	public Integer getEvaSta() {
		return evaSta;
	}

	public void setEvaSta(Integer evaSta) {
		this.evaSta = evaSta;
	}
	
	@Length(min=0, max=256, message="评价内容长度必须介于 0 和 256 之间")
	public String getEvaContext() {
		return evaContext;
	}

	public void setEvaContext(String evaContext) {
		this.evaContext = evaContext;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}
	
	@Length(min=0, max=256, message="方案描述长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}

	public List<DdsRdEva> getList() {
		return list;
	}

	public void setList(List<DdsRdEva> list) {
		this.list = list;
	}

    public Integer getByr() {
        return byr;
    }

    public void setByr(Integer byr) {
        this.byr = byr;
    }
}