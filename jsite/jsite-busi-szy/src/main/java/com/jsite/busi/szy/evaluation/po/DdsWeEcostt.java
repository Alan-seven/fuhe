package com.jsite.busi.szy.evaluation.po;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 经济社会指标信息表Entity
 * @author hjx
 * @version 2017-09-14
 */
public class DdsWeEcostt extends AbstractData<DdsWeEcostt> {
	
	private static final long serialVersionUID = 1L;
	private String yr;		// 评价年份
	private String regCd;		// 分区代码
	private Long regType;		// 分区类型
	private Double townPp;		// 城镇人口
	private Double ruralPp;		// 农村人口
	private Double gdp1;		// 国内第一生产总值
	private Double gdp2;		// 国内第二生产总值
	private Double gdp3;		// 国内第三生产总值
	private Double indEpv;		// 火（核）电工业工业增加值
	private Double indOpv;		// 国有及规模以上工业增加值
	private Double indCpv;		// 规模以下工业增加值
	private Double indEzc;		// 直流式火（核）电装机
	private Double indExc;		// 循环式火（核）电装机
	private Double irrLand;		// 耕地面积
	private Double irrA;		// 农田有效灌溉面积
	private Double pweirA;		// 水田实灌面积
	private Double pdeirA;		// 水浇地实灌面积
	private Double pveirA;		// 菜田实灌面积
	private Double foodProd;		// 粮食产量
	private Double tfgA;		// 林果草灌溉面积
	private Double airrA;		// 草场灌溉面积
	private Double fishA;		// 鱼塘补水面积
	private Double llsNum;		// 大牲畜头数
	private Double slsNum;		// 小牲畜头数
	private Double pbldA;		// 新增建筑面积
	private String nt;		// 备注
	
	public DdsWeEcostt() {
		super();
	}

	public DdsWeEcostt(String id){
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
	
	public Double getTownPp() {
		return townPp;
	}

	public void setTownPp(Double townPp) {
		this.townPp = townPp;
	}
	
	public Double getRuralPp() {
		return ruralPp;
	}

	public void setRuralPp(Double ruralPp) {
		this.ruralPp = ruralPp;
	}
	
	public Double getGdp1() {
		return gdp1;
	}

	public void setGdp1(Double gdp1) {
		this.gdp1 = gdp1;
	}
	
	public Double getGdp2() {
		return gdp2;
	}

	public void setGdp2(Double gdp2) {
		this.gdp2 = gdp2;
	}
	
	public Double getGdp3() {
		return gdp3;
	}

	public void setGdp3(Double gdp3) {
		this.gdp3 = gdp3;
	}
	
	public Double getIndEpv() {
		return indEpv;
	}

	public void setIndEpv(Double indEpv) {
		this.indEpv = indEpv;
	}
	
	public Double getIndOpv() {
		return indOpv;
	}

	public void setIndOpv(Double indOpv) {
		this.indOpv = indOpv;
	}
	
	public Double getIndCpv() {
		return indCpv;
	}

	public void setIndCpv(Double indCpv) {
		this.indCpv = indCpv;
	}
	
	public Double getIndEzc() {
		return indEzc;
	}

	public void setIndEzc(Double indEzc) {
		this.indEzc = indEzc;
	}
	
	public Double getIndExc() {
		return indExc;
	}

	public void setIndExc(Double indExc) {
		this.indExc = indExc;
	}
	
	public Double getIrrLand() {
		return irrLand;
	}

	public void setIrrLand(Double irrLand) {
		this.irrLand = irrLand;
	}
	
	public Double getIrrA() {
		return irrA;
	}

	public void setIrrA(Double irrA) {
		this.irrA = irrA;
	}
	
	public Double getPweirA() {
		return pweirA;
	}

	public void setPweirA(Double pweirA) {
		this.pweirA = pweirA;
	}
	
	public Double getPdeirA() {
		return pdeirA;
	}

	public void setPdeirA(Double pdeirA) {
		this.pdeirA = pdeirA;
	}
	
	public Double getPveirA() {
		return pveirA;
	}

	public void setPveirA(Double pveirA) {
		this.pveirA = pveirA;
	}
	
	public Double getFoodProd() {
		return foodProd;
	}

	public void setFoodProd(Double foodProd) {
		this.foodProd = foodProd;
	}
	
	public Double getTfgA() {
		return tfgA;
	}

	public void setTfgA(Double tfgA) {
		this.tfgA = tfgA;
	}
	
	public Double getAirrA() {
		return airrA;
	}

	public void setAirrA(Double airrA) {
		this.airrA = airrA;
	}
	
	public Double getFishA() {
		return fishA;
	}

	public void setFishA(Double fishA) {
		this.fishA = fishA;
	}
	
	public Double getLlsNum() {
		return llsNum;
	}

	public void setLlsNum(Double llsNum) {
		this.llsNum = llsNum;
	}
	
	public Double getSlsNum() {
		return slsNum;
	}

	public void setSlsNum(Double slsNum) {
		this.slsNum = slsNum;
	}
	
	public Double getPbldA() {
		return pbldA;
	}

	public void setPbldA(Double pbldA) {
		this.pbldA = pbldA;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
}