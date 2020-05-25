package com.jsite.busi.szy.evaluation.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 用水定额及参数表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeWun extends AbstractData<DdsWeWun> {
	
	private static final long serialVersionUID = 1L;
	private String yr;		// 评价年份
	private String regCd;		// 分区代码
	private Long regType;		// 分区类型
	private Double awN;		// 水田灌溉定额
	private Double awsSp;		// 农田灌溉蓄水比例
	private Double awdSp;		// 农田灌溉引水比例
	private Double awLp;		// 农田灌溉提水比例
	private Double awSr;		// 蓄引灌溉水利用系数
	private Double awLr;		// 提水灌溉水利用系数
	private Double fiN;		// 林果灌溉定额
	private Double aiN;		// 草场灌溉定额
	private Double fishN;		// 鱼塘补水定额
	private Double llsN;		// 大牲畜用水定额
	private Double slsN;		// 小牲畜用水定额
	private Double ioN;		// 规模以上工业用水定额
	private Double icN;		// 规模以下工业用水定额
	private Double adN;		// 水浇地灌溉定额
	private Double avN;		// 菜田灌溉定额
	private Double pbldN;		// 建筑业用水定额
	private Double psrvN;		// 服务业用水定额
	private Double duN;		// 城镇居民用水定额
	private Double drN;		// 农村居民用水定额
	private Double evN;		// 生态环境用水定额
	private String nt;		// 备注
	
	public DdsWeWun() {
		super();
	}

	public DdsWeWun(String id){
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
	
	public Double getAwN() {
		return awN;
	}

	public void setAwN(Double awN) {
		this.awN = awN;
	}
	
	public Double getAwsSp() {
		return awsSp;
	}

	public void setAwsSp(Double awsSp) {
		this.awsSp = awsSp;
	}
	
	public Double getAwdSp() {
		return awdSp;
	}

	public void setAwdSp(Double awdSp) {
		this.awdSp = awdSp;
	}
	
	public Double getAwLp() {
		return awLp;
	}

	public void setAwLp(Double awLp) {
		this.awLp = awLp;
	}
	
	public Double getAwSr() {
		return awSr;
	}

	public void setAwSr(Double awSr) {
		this.awSr = awSr;
	}
	
	public Double getAwLr() {
		return awLr;
	}

	public void setAwLr(Double awLr) {
		this.awLr = awLr;
	}
	
	public Double getFiN() {
		return fiN;
	}

	public void setFiN(Double fiN) {
		this.fiN = fiN;
	}
	
	public Double getAiN() {
		return aiN;
	}

	public void setAiN(Double aiN) {
		this.aiN = aiN;
	}
	
	public Double getFishN() {
		return fishN;
	}

	public void setFishN(Double fishN) {
		this.fishN = fishN;
	}
	
	public Double getLlsN() {
		return llsN;
	}

	public void setLlsN(Double llsN) {
		this.llsN = llsN;
	}
	
	public Double getSlsN() {
		return slsN;
	}

	public void setSlsN(Double slsN) {
		this.slsN = slsN;
	}
	
	public Double getIoN() {
		return ioN;
	}

	public void setIoN(Double ioN) {
		this.ioN = ioN;
	}
	
	public Double getIcN() {
		return icN;
	}

	public void setIcN(Double icN) {
		this.icN = icN;
	}
	
	public Double getAdN() {
		return adN;
	}

	public void setAdN(Double adN) {
		this.adN = adN;
	}
	
	public Double getAvN() {
		return avN;
	}

	public void setAvN(Double avN) {
		this.avN = avN;
	}
	
	public Double getPbldN() {
		return pbldN;
	}

	public void setPbldN(Double pbldN) {
		this.pbldN = pbldN;
	}
	
	public Double getPsrvN() {
		return psrvN;
	}

	public void setPsrvN(Double psrvN) {
		this.psrvN = psrvN;
	}
	
	public Double getDuN() {
		return duN;
	}

	public void setDuN(Double duN) {
		this.duN = duN;
	}
	
	public Double getDrN() {
		return drN;
	}

	public void setDrN(Double drN) {
		this.drN = drN;
	}
	
	public Double getEvN() {
		return evN;
	}

	public void setEvN(Double evN) {
		this.evN = evN;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}