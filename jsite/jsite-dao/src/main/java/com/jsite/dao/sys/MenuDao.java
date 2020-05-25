package com.jsite.dao.sys;

import java.util.List;

import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import com.jsite.dao.sys.po.Menu;

/**
 * 菜单DAO接口
 */
@MyBatisDao
public interface MenuDao extends CrudDao<Menu> {
	
	public List<Menu> findByParentIdsLike(Menu menu);

	public List<Menu> findByUserId(Menu menu);
	
	public List<Menu> findAllList(Menu menu);
	
	public List<Menu> findByRoleId(Menu menu);

	public int updateParentIds(Menu menu);

	public int updateSort(Menu menu);
	
	public int update(Menu menu);

}
