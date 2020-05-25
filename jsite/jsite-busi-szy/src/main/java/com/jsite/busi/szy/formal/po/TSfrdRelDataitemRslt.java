package com.jsite.busi.szy.formal.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;


/**
 * 常规调度结果与模型输出关系Entity
 * @author 常规调度结果与模型输出关系
 * @version 2020-03-17
 */
public class TSfrdRelDataitemRslt extends AbstractData<TSfrdRelDataitemRslt> {
	
	private static final long serialVersionUID = 1L;
	private String enTp;		// 实体类型
	private String dtTblNm;		// 成果表名
	private String rsltNmLst;		// 成果字段名
	private String dataitemCdLst;		// 数据项序列
	private Date ts;		// 时间戳
	private String nt;		// 备注
	
	public TSfrdRelDataitemRslt() {
		super();
	}

	public TSfrdRelDataitemRslt(String id){
		super(id);
	}
	@NotNull(message="实体类型不能为空")
	@Length(min=1, max=2, message="实体类型长度必须介于 1 和 2 之间")
	public String getEnTp() {
		return enTp;
	}

	public void setEnTp(String enTp) {
		this.enTp = enTp;
	}
	@NotNull(message="成果表名不能为空")
	@Length(min=1, max=100, message="成果表名长度必须介于 1 和 100 之间")
	public String getDtTblNm() {
		return dtTblNm;
	}

	public void setDtTblNm(String dtTblNm) {
		this.dtTblNm = dtTblNm;
	}
	
	@Length(min=1, max=1024, message="成果字段名长度必须介于 1 和 1024 之间")
	public String getRsltNmLst() {
		return rsltNmLst;
	}

	public void setRsltNmLst(String rsltNmLst) {
		this.rsltNmLst = rsltNmLst;
	}
	
	@Length(min=1, max=1024, message="数据项序列长度必须介于 1 和 1024 之间")
	public String getDataitemCdLst() {
		return dataitemCdLst;
	}

	public void setDataitemCdLst(String dataitemCdLst) {
		this.dataitemCdLst = dataitemCdLst;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}