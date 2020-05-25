package com.jsite.dao.sys;

import com.jsite.dao.CrudDao;
import com.jsite.dao.mybatis.MyBatisDao;
import com.jsite.dao.sys.po.DdsSysUserinfo;

/**
 * 人员信息表DAO接口
 * @author hjx
 * @version 2017-09-12
 */
@MyBatisDao
public interface DdsSysUserinfoDao extends CrudDao<DdsSysUserinfo> {

	/**
	 * 更新用户角色关联数据
	 * 
	 * @param user
	 * @return
	 */
	public int saveUserDORole(DdsSysUserinfo ddsSysUserinfo);
	
	/**
	 * 删除用户角色关联数据
	 * 
	 * @param user
	 * @return
	 */
	public int deleteUserRole(DdsSysUserinfo ddsSysUserinfo);
}