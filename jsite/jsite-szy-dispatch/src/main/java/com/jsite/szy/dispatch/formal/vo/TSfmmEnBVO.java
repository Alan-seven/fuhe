package com.jsite.szy.dispatch.formal.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;

/**
 * 实体基本信息VO
 * @author seven
 *
 */
public class TSfmmEnBVO extends PageVO{

	@ApiModelProperty(value = "调度区域代码")
	private String regionCd;
	@ApiModelProperty(value = "实体代码")
	private String enCd;
	@ApiModelProperty(value = "实体名称")
	private String enNm;
	@ApiModelProperty(value = "实体类型")
	private String enTp;
	@ApiModelProperty(value = "实体节点ID序列")
	private String nodeLst;
	@ApiModelProperty(value = "基面代码")
	private String datCd;
	@ApiModelProperty(value = "冻结基面修正值")
	private Float datumMod;
	@ApiModelProperty(value = "时间戳")
	private Date ts;
	@ApiModelProperty(value = "备注")
	private String nt;
	
	@NotNull(message="调度区域代码不能为空")
	@Length(min=1, max=16, message="调度区域代码标识长度必须介于 1 和 16 之间")
	public String getRegionCd() {
		return regionCd;
	}
	public void setRegionCd(String regionCd) {
		this.regionCd = regionCd;
	}
	@NotNull(message="实体代码不能为空")
	@Length(min=1, max=9, message="实体代码标识长度必须介于 1 和 9 之间")
	public String getEnCd() {
		return enCd;
	}
	public void setEnCd(String enCd) {
		this.enCd = enCd;
	}
	@NotNull(message="实体名称不能为空")
	@Length(min=1, max=80, message="实体名称标识长度必须介于 1 和 80 之间")
	public String getEnNm() {
		return enNm;
	}
	public void setEnNm(String enNm) {
		this.enNm = enNm;
	}
	@NotNull(message="实体类型不能为空")
	@Length(min=1, max=2, message="实体类型标识长度必须介于 1 和 2 之间")
	public String getEnTp() {
		return enTp;
	}
	public void setEnTp(String enTp) {
		this.enTp = enTp;
	}
	@NotNull(message="实体节点ID序列不能为空")
	@Length(min=1, max=512, message="实体节点ID序列标识长度必须介于 1 和 512 之间")
	public String getNodeLst() {
		return nodeLst;
	}
	public void setNodeLst(String nodeLst) {
		this.nodeLst = nodeLst;
	}
	@Length(min=0, max=9, message="基面代码标识长度必须介于 0 和 9 之间")
	public String getDatCd() {
		return datCd;
	}
	public void setDatCd(String datCd) {
		this.datCd = datCd;
	}
	public Float getDatumMod() {
		return datumMod;
	}
	public void setDatumMod(Float datumMod) {
		this.datumMod = datumMod;
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
