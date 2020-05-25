package com.jsite.busi.szy.info.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.busi.szy.info.dao.DdsDrRiverDao;
import com.jsite.busi.szy.info.po.DdsDrPptn;
import com.jsite.busi.szy.info.po.DdsDrRiver;
import com.jsite.manager.AbstractCrudService;

/**
 * 河道水情表Service
 * @author hjx
 * @version 2017-06-08
 */
@Service
@Transactional(readOnly = true)
public class DdsDrRiverService extends AbstractCrudService<DdsDrRiverDao, DdsDrRiver> {

	/**
	 * 根据测站编码和监测开始时间和结束时间查询
	 * @param ddsDrRiver
	 * 时间类型为 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public List<DdsDrRiver> listByStcd(DdsDrRiver ddsDrRiver){
		List<DdsDrRiver> list = dao.listByStcd(ddsDrRiver);
		
		Double z = 0.0 ;
		Double q = 0.00;
		List<DdsDrRiver> asclist = new ArrayList<DdsDrRiver>();
		for(int i = 0 ; i < list.size() ; i ++){
			DdsDrRiver river = list.get(i);
			Double real_z = river.getZ();
			Double real_q = river.getQ();
			if(real_z!=null){
				z = real_z;
			}else{
				if(z!=0.0){
					river.setZ(z);
				}
			}
			if(real_q!=null){
				q = real_q;
			}else{
				if(q!=0.0){
					river.setQ(q);
				}
			}
			asclist.add(river);
		}
		
		z = 0.0 ;
		q = 0.00;
		List<DdsDrRiver> desclist = new ArrayList<DdsDrRiver>();
		for(int i = asclist.size()-1 ; i >=0 ; i--){
			DdsDrRiver river = asclist.get(i);
			Double real_z = river.getZ();
			Double real_q = river.getQ();
			if(real_z!=null){
				z = real_z;
			}else{
				if(z!=0.0){
					river.setZ(z);
					river.setFlag("1");
				}
			}
			if(real_q!=null){
				q = real_q;
			}else{
				if(q!=0.0){
					river.setQ(q);
					river.setFlag("1");
				}
			}
			desclist.add(river);
		}
		return desclist;
	}
	
	public List<DdsDrRiver> findNewData(DdsDrRiver ddsDrRiver){
		return this.dao.findNewData(ddsDrRiver);
	}
	
	/**
	 * 获取测站最新记录时间
	 * @param ddsDrPptn
	 * @return
	 */
	public DdsDrRiver findMaxTime(DdsDrRiver ddsDrRiver){
		return this.dao.findMaxTime(ddsDrRiver);
	}
}