package com.jsite.szy.dispatch.dispatchwo.convert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.jsite.busi.szy.dispatch.po.DdsRdIfres;
import com.jsite.busi.szy.dispatch.po.DdsRdP;
import com.jsite.busi.szy.dispatch.po.DdsRdWares;
import com.jsite.busi.szy.dispatch.po.DdsRdWdcons;
import com.jsite.busi.szy.dispatch.po.DdsRdWdinit;
import com.jsite.busi.szy.dispatch.po.DdsRdWdres;
import com.jsite.busi.szy.dispatch.po.DdsRdWdwun;
import com.jsite.szy.dispatch.dispatchwo.service.WaterOptimumService;

public class WODisplayConvert {
	List<DdsRdWdcons> consList;
	List<DdsRdWdinit> initList;
	List<DdsRdWares> allocateList;
	List<DdsRdIfres> forcastList;
	List<DdsRdWdres> resultList;
	List<DdsRdWdwun> wdwunsList;
	public List<DdsRdWares> getAllocateList(DdsRdP plan) {
		if(plan.getProTp().indexOf("3") >=0 ){
			List<DdsRdWares> copy = new ArrayList<>();
			for(int i=0;i<allocateList.size();i++){
				DdsRdWares single = allocateList.get(i);
				
				if(single.getBt() != null && single.getBt().getTime() >= plan.getBgDt().getTime() && single.getEt() != null && single.getEt().getTime() <= plan.getEdDt().getTime()){
					DdsRdWares copy1 = new DdsRdWares();
					DdsRdWares copy2 = new DdsRdWares();
					DdsRdWares copy3 = new DdsRdWares();
					BeanUtils.copyProperties(single, copy1);
					BeanUtils.copyProperties(single, copy2);
					BeanUtils.copyProperties(single, copy3);
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
					String sup = sdf.format(single.getBt());
					
					Date date1 = WaterOptimumService.parseDate(sup+"-11");
					Date date2 = WaterOptimumService.parseDate(sup+"-21");
					
					copy(single, copy1);
					copy1.setBt(single.getBt());
					copy1.setEt(date1);
					
					copy(single, copy2);
					copy2.setBt(date1);
					copy2.setEt(date2);
					
					copy(single, copy3);
					copy3.setBt(date2);
					copy3.setEt(single.getEt());
					
					copy.add(copy1);
					copy.add(copy2);
					copy.add(copy3);
				}
				
			}
			return copy;
		}
		else return allocateList;
	}
	public void copy(DdsRdWares source, DdsRdWares target){
		double rate = 10.0 / 31.0;
		target.setProCd(source.getProCd());
		target.setRegCd(source.getRegCd());
		target.setRsTp(source.getRsTp());
		target.setDRs(source.getDRs() * rate);
		target.setURs(source.getURs() * rate);
		target.setBhRs(source.getBhRs() * rate);
		target.setShRs(source.getShRs() * rate);
		target.setPwirRs(source.getPwirRs() * rate);
		target.setPdirRs(source.getPdirRs() * rate);
		target.setPvirRs(source.getPvirRs() * rate);
		target.setFiRs(source.getFiRs() * rate);
		target.setAiRs(source.getAiRs() * rate);
		target.setMfishRs(source.getMfishRs() * rate);
		target.setIndRs(source.getIndRs() * rate);
		target.setNindRs(source.getNindRs() * rate);
		target.setTotRs(source.getTotRs() * rate);
	}
	
	public List<DdsRdIfres> getForcastList(DdsRdP plan) {
		if(plan.getProTp().indexOf("3") >=0 ){
			List<DdsRdIfres> copy = new ArrayList<>();
			
			for(int i=0;i<forcastList.size();i++){
				DdsRdIfres single = forcastList.get(i);
				
				DdsRdIfres copy1 = new DdsRdIfres();
				DdsRdIfres copy2 = new DdsRdIfres();
				DdsRdIfres copy3 = new DdsRdIfres();
				BeanUtils.copyProperties(single, copy1);
				BeanUtils.copyProperties(single, copy2);
				BeanUtils.copyProperties(single, copy3);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				String sup = sdf.format(single.getBgtm());
				
				Date date1 = WaterOptimumService.parseDate(sup+"-11");
				Date date2 = WaterOptimumService.parseDate(sup+"-21");
				
				copy1.setBgtm(single.getBgtm());
				copy1.setEdtm((new java.sql.Date(date1.getTime())));

				copy2.setBgtm((new java.sql.Date(date1.getTime())));
				copy2.setEdtm((new java.sql.Date(date2.getTime())));

				copy3.setBgtm((new java.sql.Date(date2.getTime())));
				copy3.setEdtm(single.getEdtm());
				
				copy.add(copy1);
				copy.add(copy2);
				copy.add(copy3);
			}
			return copy;
		}
		else return forcastList;
	}
	
	public List<DdsRdWdwun> getWdwunsList() {
		return wdwunsList;
	}
	public void setWdwunsList(List<DdsRdWdwun> wdwunsList) {
		this.wdwunsList = wdwunsList;
	}
	public List<DdsRdWdres> getResultList() {
		return resultList;
	}
	public void setResultList(List<DdsRdWdres> resultList) {
		this.resultList = resultList;
	}
	public List<DdsRdWares> getAllocateList() {
		return allocateList;
	}
	public void setAllocateList(List<DdsRdWares> allocateList) {
		this.allocateList = allocateList;
	}
	public List<DdsRdIfres> getForcastList() {
		return forcastList;
	}
	public void setForcastList(List<DdsRdIfres> forcastList) {
		this.forcastList = forcastList;
	}
	public List<DdsRdWdcons> getConsList() {
		return consList;
	}
	public void setConsList(List<DdsRdWdcons> consList) {
		this.consList = consList;
	}
	public List<DdsRdWdinit> getInitList() {
		return initList;
	}
	public void setInitList(List<DdsRdWdinit> initList) {
		this.initList = initList;
	}
	
}
