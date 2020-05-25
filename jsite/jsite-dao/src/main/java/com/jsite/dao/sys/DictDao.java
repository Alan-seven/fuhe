package com.jsite.dao.sys;

import java.util.List;

import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import com.jsite.dao.sys.po.Dict;

/**
 * 字典DAO接口
 */
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {

	public List<String> listTypeList(Dict dict);
	
	public List<String> findTypeList(Dict dict);
	
	public List<Dict> list(Dict dict);
	
}
