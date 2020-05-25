package com.jsite.dao.sys.po;

import java.util.List;

import com.google.common.collect.Lists;
import com.jsite.dao.AbstractData;
import com.jsite.dao.sys.DdsSysUserinfoDao;

public class Role extends AbstractData<Role>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4291178435027570378L;
	private DeptInfo dept; // 归属机构
	private String name; // 角色名称
	private String enname; // 英文名称
	private String roleType;// 权限类型
	private String dataScope;// 数据范围

	private String oldName; // 原角色名称
	private String oldEnname; // 原英文名称
	private String sysData; // 是否是系统数据
	private String useable; // 是否是可用

	private DdsSysUserinfo user; // 根据用户ID查询角色列表
	
	private List<Menu> menuList = Lists.newArrayList(); // 拥有菜单列表
	private List<DeptInfo> deptList = Lists.newArrayList(); // 按明细设置数据范围

	// 数据范围（1：所有数据；2：所在公司及以下数据；3：所在公司数据；4：所在部门及以下数据；5：所在部门数据；8：仅本人数据；9：按明细设置）
	public static final String DATA_SCOPE_ALL = "1";
	public static final String DATA_SCOPE_COMPANY_AND_CHILD = "2";
	public static final String DATA_SCOPE_COMPANY = "3";
	public static final String DATA_SCOPE_OFFICE_AND_CHILD = "4";
	public static final String DATA_SCOPE_OFFICE = "5";
	public static final String DATA_SCOPE_SELF = "8";
	public static final String DATA_SCOPE_CUSTOM = "9";
	
	private String createBy;
	private String updateBy;

	public Role() {
		super();
		this.dataScope = DATA_SCOPE_SELF;
		this.useable="1";
	}
	
	public Role(String id) {
		this.id = id;
	}
	
	public Role(DdsSysUserinfo user) {
		this.user = user;
	}
	
	public DeptInfo getDept() {
		return dept;
	}

	public void setOfficeDO(DeptInfo dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDataScope() {
		return dataScope;
	}

	public void setDataScope(String dataScope) {
		this.dataScope = dataScope;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getOldEnname() {
		return oldEnname;
	}

	public void setOldEnname(String oldEnname) {
		this.oldEnname = oldEnname;
	}

	public String getSysData() {
		return sysData;
	}

	public void setSysData(String sysData) {
		this.sysData = sysData;
	}

	public String getUseable() {
		return useable;
	}

	public void setUseable(String useable) {
		this.useable = useable;
	}

	public DdsSysUserinfo getUserDO() {
		return user;
	}

	public void setUserDO(DdsSysUserinfo user) {
		this.user = user;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public List<DeptInfo> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<DeptInfo> deptList) {
		this.deptList = deptList;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

}
