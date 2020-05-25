package com.jsite.dao.sys;

import java.util.List;

import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import com.jsite.dao.sys.po.Role;

/**
 * 角色DAO接口
 */
@MyBatisDao
public interface RoleDao extends CrudDao<Role> {

	public Role getByName(Role role);

	public Role getByEnname(Role role);

	/**
	 * 维护角色与菜单权限关系
	 * 
	 * @param role
	 * @return
	 */
	public int removeRoleMenu(Role role);
	
	public int removeUserRole(Role role);

	public int saveRoleMenu(Role role);

	/**
	 * 维护角色与公司部门关系
	 * 
	 * @param role
	 * @return
	 */
	public int removeRoleDept(Role role);

	public int saveRoleDept(Role role);
	
	public List<Role> findList(Role role);
	
	public List<Role> findAllList(Role role);

}
