package com.jsite.szy.dispatch.formal.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

import io.swagger.annotations.ApiModelProperty;

/**
 * 来水预报初始条件表
 * @author seven
 *
 */
public class TSfrdIfInitcondVO extends PageVO{
	@ApiModelProperty(value = "方案代码")
	private String proCd;		// 方案代码
	@ApiModelProperty(value = "实体代码")
	private String enCd;		// 实体代码
	@ApiModelProperty(value = "预报方式")
	private String forPattern;		// 预报方式
	@ApiModelProperty(value = "是否完成")
	private String isFnsh;		// 是否完成
	@ApiModelProperty(value = "请求代码")
	private String reqCd;		// 请求代码
	@ApiModelProperty(value = "水雨情库预报成果信息")
	private String forInfo;		// 水雨情库预报成果信息
	@ApiModelProperty(value = "上传的文件名")
	private String fileNm;		// 上传的文件名
	@ApiModelProperty(value = "采用来水频率")
	private Integer ifFreq;		// 采用来水频率
	@ApiModelProperty(value = "采用调度方案信息")
	private String opsProCd;		// 采用调度方案信息
	@ApiModelProperty(value = "时间戳")
	private Date ts;		// 时间戳
	@ApiModelProperty(value = "备注")
	private String nt;		// 备注
	
	@Length(min=1, max=20, message="方案代码长度必须介于 1 和 20 之间")
	public String getProCd() {
		return proCd;
	}

	public void setProCd(String proCd) {
		this.proCd = proCd;
	}
	
	@Length(min=1, max=9, message="实体代码长度必须介于 1 和 9 之间")
	public String getEnCd() {
		return enCd;
	}

	public void setEnCd(String enCd) {
		this.enCd = enCd;
	}
	
	@Length(min=1, max=1, message="预报方式长度必须介于 1 和 1 之间")
	public String getForPattern() {
		return forPattern;
	}

	public void setForPattern(String forPattern) {
		this.forPattern = forPattern;
	}
	
	@Length(min=1, max=1, message="是否完成长度必须介于 1 和 1 之间")
	public String getIsFnsh() {
		return isFnsh;
	}

	public void setIsFnsh(String isFnsh) {
		this.isFnsh = isFnsh;
	}
	
	@Length(min=0, max=64, message="请求代码长度必须介于 0 和 64 之间")
	public String getReqCd() {
		return reqCd;
	}

	public void setReqCd(String reqCd) {
		this.reqCd = reqCd;
	}
	
	@Length(min=0, max=200, message="水雨情库预报成果信息长度必须介于 0 和 200 之间")
	public String getForInfo() {
		return forInfo;
	}

	public void setForInfo(String forInfo) {
		this.forInfo = forInfo;
	}
	
	@Length(min=0, max=100, message="上传的文件名长度必须介于 0 和 100 之间")
	public String getFileNm() {
		return fileNm;
	}

	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}
	
	public Integer getIfFreq() {
		return ifFreq;
	}

	public void setIfFreq(Integer ifFreq) {
		this.ifFreq = ifFreq;
	}
	
	@Length(min=0, max=100, message="采用调度方案信息长度必须介于 0 和 100 之间")
	public String getOpsProCd() {
		return opsProCd;
	}

	public void setOpsProCd(String opsProCd) {
		this.opsProCd = opsProCd;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间戳不能为空")
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
