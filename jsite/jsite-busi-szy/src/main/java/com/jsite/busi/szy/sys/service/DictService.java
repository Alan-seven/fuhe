package com.jsite.busi.szy.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.StringUtils;
import com.jsite.dao.sys.DictDao;
import com.jsite.dao.sys.po.Dict;
import com.jsite.manager.AbstractCrudService;
import com.jsite.manager.cache.CacheUtils;
import com.jsite.manager.utils.DictUtils;

/**
 * 字典Service
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class DictService extends AbstractCrudService<DictDao, Dict> {
	
	@Autowired
	private DictDao dao ;
	
	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<String> findTypeList(){
		return dao.findTypeList(new Dict());
	}

	@Transactional(readOnly = false)
	public ServiceResp save(Dict dict) {
		ServiceResp serviceResp = new ServiceResp();
		//缺少新增，修改用户信息
		if(StringUtils.isBlank(dict.getId())){
			dict.preInsert();
			serviceResp = super.save(dict);
		}else{
			dict.preUpdate();
			serviceResp = super.update(dict);
		}
		//CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
		return serviceResp;
	}

	@Transactional(readOnly = false)
	public ServiceResp delete(Dict dict) {
		ServiceResp serviceResp = super.remove(dict);
		//CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
		return serviceResp ;
	}

}
