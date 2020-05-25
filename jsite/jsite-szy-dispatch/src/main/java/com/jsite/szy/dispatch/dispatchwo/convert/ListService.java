package com.jsite.szy.dispatch.dispatchwo.convert;

import java.util.ArrayList;
import java.util.List;

import com.jsite.busi.szy.dispatch.custom.BatchSupportedService;
import com.jsite.core.service.ServiceResp;

public class ListService {
	public static void save(List list){
		System.out.println("更新表数据 "+list.get(0).getClass().getName());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void save(List list, BatchSupportedService service){
		int flag = 0;
		List temp = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			temp.add(list.get(i));
			flag++;
			if(flag >= 100){
				ServiceResp resp = service.saveBatch(temp);
				if(resp.getMsg() != null && resp.getMsg().length() > 0){
					System.out.println(resp.getMsg());
				}
				temp.clear();
				flag = 0;
			}
		}
		if(temp.size() > 0){
			ServiceResp resp = service.saveBatch(temp);
			temp.clear();
			flag = 0;
			if(resp.getMsg() != null && resp.getMsg().length() > 0){
				System.out.println(resp.getMsg());
			}
		}
	}
}
