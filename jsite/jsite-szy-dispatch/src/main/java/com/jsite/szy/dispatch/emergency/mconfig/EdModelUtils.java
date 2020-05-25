package com.jsite.szy.dispatch.emergency.mconfig;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.jsite.busi.szy.emergency.po.DdsEdRsv;
import com.jsite.busi.szy.info.po.DdsDrRiver;
import com.jsite.busi.szy.info.po.DdsDrRsvr;

/**
 * 水量调度帮助类
 * @author admin
 *
 */
public class EdModelUtils {
	
	/**
	 * 取两个时间之间的小时数
	 * @param startTm
	 * @param endTm
	 * @return
	 */
	public static List<Date> getDateBetweenTwoDate(Date startTm,Date endTm){
		List<Date> listDate = new ArrayList<Date>();
		listDate.add(startTm);
		//设置为开始时间后的整点时间
		//listDate.add(startTm);
		//把开始时间转化为最近的一个整点时间
		int minutes = startTm.getMinutes();
		int seconds = startTm.getSeconds();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startTm);
		int n = 0 ;
		if(minutes!=0){
			cal.set(Calendar.MINUTE, 0);
			n++;
		}
		if(seconds!=0){
			cal.set(Calendar.SECOND, 0);
			n++;
		}
		if(n>0){
			cal.add(Calendar.HOUR_OF_DAY,1);
		}
		boolean bContinue = true;
		while(bContinue){
			cal.add(Calendar.HOUR_OF_DAY, 1);
			if(endTm.after(cal.getTime())){
				listDate.add(cal.getTime());
			}else{
				bContinue = false;
				break;
			}
		}
		listDate.add(endTm);
		return listDate;
	}
	
	//对河道时间节点的数据进行封装
		public static List<DdsDrRiver> getFullDrRiver(List<Date> listDate,List<DdsDrRiver> listriver){
			List<DdsDrRiver> listFull = new ArrayList<DdsDrRiver>();
			for(int i = 0 ; i < listDate.size(); i++){
				Date date = listDate.get(i);
				for(int j = 0 ; j < listriver.size(); j++){
					Date tm = listriver.get(j).getTm();
					if(date.equals(tm)){
						listFull.add(listriver.get(j));
						break;
					}
					if(j==listriver.size()-1){
						DdsDrRiver vo = new DdsDrRiver();
						vo.setTm(date);
						vo.setStcd(listriver.get(j).getStcd());
						listFull.add(vo);
					}
				}
			}
			return listFull;
		}
		
		//对水库时间节点数据进行封装
		public static List<DdsDrRsvr> getFullDrRsvr(List<Date> listDate,List<DdsDrRsvr> listrsvr){
			List<DdsDrRsvr> listFull = new ArrayList<DdsDrRsvr>();
			for(int i = 0 ; i < listDate.size(); i++){
				Date date = listDate.get(i);
				for(int j = 0 ; j < listrsvr.size(); j++){
					Date tm = listrsvr.get(j).getTm();
					if(date.equals(tm)){
						listFull.add(listrsvr.get(j));
						break;
					}
					if(j==listrsvr.size()-1){
						DdsDrRsvr vo = new DdsDrRsvr();
						vo.setTm(date);
						vo.setStcd(listrsvr.get(j).getStcd());
						listFull.add(vo);
					}
				}
			}
			return listFull;
		}
		
	/**
	 * 河流数据补值
	 * @param listriver
	 * @return
	 */
	public static List<DdsDrRiver> getListRiverByIn(List<DdsDrRiver> listriver){
		/**
		 * 缺值往后差补
		 */
		double z = 0.0;
		double q = 0.00;
		for(int i = 0; i< listriver.size();i++){
			DdsDrRiver river = listriver.get(i);
			Double real_z = river.getZ();
			Double real_q = river.getQ();
			if(null!=real_z){
				z = real_z;
			}else{
				if(z!=0.0){
					river.setZ(z);
					river.setFlag("2");
				}
			}
			if(null!=real_q){
				q = real_q;
			}else{
				if(q!=0.0){
					river.setQ(q);
					river.setFlag("2");
				}
			}
			listriver.set(i, river);
		}
		/**
		 * 缺值往前差补
		 */
		z = 0.0 ;
		q = 0.00;
		for(int i = listriver.size()-1 ; i >= 0 ; i--){
			DdsDrRiver river = listriver.get(i);
			Double real_z = river.getZ();
			Double real_q = river.getQ();
			if(null!=real_z){
				z = real_z;
			}else{
				if(z!=0.0){
					river.setZ(z);
					river.setFlag("2");
				}
			}
			if(null!=real_q){
				q = real_q;
			}else{
				if(q!=0.0){
					river.setQ(q);
					river.setFlag("2");
				}
			}
			listriver.set(i, river);
		}
		return listriver;
	}

	/**
	 * 水库数据补值
	 * @param listrsvr
	 * @return
	 */
	public static List<DdsDrRsvr> getListRsvrByIn(List<DdsDrRsvr> listrsvr){
		double inq = 0.00;
		double otq = 0.00;
		/**
		 * 缺值往后差补
		 */
		for(int i = 0; i< listrsvr.size();i++){
			DdsDrRsvr rsvr = listrsvr.get(i);
			Double real_inq = rsvr.getInq();
			Double real_otq = rsvr.getOtq();
			if(null!=real_inq){
				inq = real_inq;
			}else{
				if(inq!=0.0){
					rsvr.setInq(inq);
					rsvr.setFlag("2");
				}
			}
			if(null!=real_otq){
				otq = real_otq;
			}else{
				if(otq!=0.0){
					rsvr.setOtq(otq);
					rsvr.setFlag("2");
				}
			}
			listrsvr.set(i, rsvr);
		}
		/**
		 * 缺值往前差补
		 */
		inq = 0.00 ;
		otq = 0.00;
		for(int i = listrsvr.size()-1 ; i >= 0 ; i--){
			DdsDrRsvr rsvr = listrsvr.get(i);
			Double real_inq = rsvr.getInq();
			Double real_otq = rsvr.getOtq();
			if(null!=real_inq){
				inq = real_inq;
			}else{
				if(inq!=0.0){
					rsvr.setInq(inq);
					rsvr.setFlag("2");
				}
			}
			if(null!=real_otq){
				otq = real_otq;
			}else{
				if(otq!=0.0){
					rsvr.setOtq(otq);
					rsvr.setFlag("2");
				}
			}
			listrsvr.set(i, rsvr);
		}
		return listrsvr;
	}
	
	//对水库调节读取数据时间节点数据进行封装
	public static List<DdsEdRsv> getFullEdRsv(List<Date> listDate,List<DdsEdRsv> listrsvr){
		List<DdsEdRsv> listFull = new ArrayList<DdsEdRsv>();
		for(int i = 0 ; i < listDate.size(); i++){
			Date date = listDate.get(i);
			for(int j = 0 ; j < listrsvr.size(); j++){
				Date tm = listrsvr.get(j).getTm();
				if(date.equals(tm)){
					listFull.add(listrsvr.get(j));
					break;
				}
				if(j==listrsvr.size()-1){
					DdsEdRsv vo = new DdsEdRsv();
					vo.setTm(date);
					vo.setStcd(listrsvr.get(j).getStcd());
					listFull.add(vo);
				}
			}
		}
		return listFull;
	}
	
	/**
	 * 水库调节读取数据补值
	 * @param listrsvr
	 * @return
	 */
	public static List<DdsEdRsv> getListEdRsvByIn(List<DdsEdRsv> listrsv){
		double otq = 0.00;
		double exq = 0.00;
		/**
		 * 缺值往后差补
		 */
		for(int i = 0; i< listrsv.size();i++){
			DdsEdRsv rsv = listrsv.get(i);
			Double real_otq = rsv.getOtq();
			Double real_Exq = rsv.getExq();
			if(null!=real_otq){
				otq = real_otq;
			}else{
				if(otq!=0.0){
					rsv.setOtq(otq);
					//rsv.setFlag("2");
				}
			}
			if(null!=real_Exq){
				exq = real_Exq;
			}else{
				if(exq!=0.0){
					rsv.setExq(exq);
					//rsv.setFlag("2");
				}
			}
			listrsv.set(i, rsv);
		}
		/**
		 * 缺值往前差补
		 */
		otq = 0.00 ;
		exq = 0.00;
		for(int i = listrsv.size()-1 ; i >= 0 ; i--){
			DdsEdRsv rsv = listrsv.get(i);
			Double real_otq = rsv.getOtq();
			Double real_Exq = rsv.getExq();
			if(null!=real_otq){
				otq = real_otq;
			}else{
				if(otq!=0.0){
					rsv.setOtq(otq);
				}
			}
			if(null!=real_Exq){
				exq = real_Exq;
			}else{
				if(otq!=0.0){
					rsv.setExq(exq);
				}
			}
			listrsv.set(i, rsv);
		}
		return listrsv;
	}
}
