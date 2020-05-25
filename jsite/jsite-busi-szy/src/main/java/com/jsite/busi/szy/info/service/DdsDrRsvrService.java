package com.jsite.busi.szy.info.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.info.po.DdsDrRiver;
import com.jsite.busi.szy.info.po.DdsDrRsvr;
import com.jsite.manager.AbstractCrudService;
import com.jsite.busi.szy.info.dao.DdsDrRsvrDao;

/**
 * 水库水情表Service
 * @author hjx
 * @version 2017-04-27
 */
@Service
@Transactional(readOnly = true)
public class DdsDrRsvrService extends AbstractCrudService<DdsDrRsvrDao, DdsDrRsvr> {
	
	/**
	 * 根据测站编码 和监测开始时间和结束时间查询单站数据
	 *  时间类型为 yyyy-MM-dd HH:mm:ss
	 * @param ddsDrRsvr
	 * @return
	 */
	public List<DdsDrRsvr> listByStcd(DdsDrRsvr ddsDrRsvr){
		List<DdsDrRsvr> list = dao.listByStcd(ddsDrRsvr);
		Double rz =0.00;
		Double inq = 0.00;
		List<DdsDrRsvr> asclist = new ArrayList<DdsDrRsvr>();
		for(int i = 0 ; i < list.size() ; i ++){
			DdsDrRsvr rsvr = list.get(i);
			Double real_rz = rsvr.getRz();
			Double real_inq = rsvr.getInq();
			if(real_rz!=null){
				rz = real_rz;
			}else{
				if(rz!=0.0){
					rsvr.setRz(rz);
				}
			}
			if(real_inq!=null){
				inq = real_inq;
			}else{
				if(inq!=0.0){
					rsvr.setInq(inq);
				}
			}
			asclist.add(rsvr);
		}
		
		rz =0.00;
		inq = 0.00;
		List<DdsDrRsvr> desclist = new ArrayList<DdsDrRsvr>();
		for(int i = asclist.size()-1 ; i >=0 ; i--){
			DdsDrRsvr rsvr = asclist.get(i);
			Double real_rz = rsvr.getRz();
			Double real_inq = rsvr.getInq();
			if(real_rz!=null){
				rz = real_rz;
			}else{
				if(rz!=0.0){
					rsvr.setRz(rz);
					rsvr.setFlag("1");
				}
			}
			if(real_inq!=null){
				inq = real_inq;
			}else{
				if(inq!=0.0){
					rsvr.setInq(inq);
					rsvr.setFlag("1");
				}
			}
			desclist.add(rsvr);
		}
		return desclist ;
	}
	
	public List<DdsDrRsvr> findNewData(DdsDrRsvr ddsDrRsvr){
		return  this.dao.findNewData(ddsDrRsvr);
	}
	
	/**
	 * 获取测站最新记录时间
	 * @param ddsDrPptn
	 * @return
	 */
	public DdsDrRsvr findMaxTime(DdsDrRsvr ddsDrRsvr){
		return this.dao.findMaxTime(ddsDrRsvr);
	}
}