package com.jsite.dao.sys.po;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.jsite.dao.AbstractData;

public class User extends AbstractData<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6283110645875230342L;
	private Office company; // 归属公司
	private Office office; // 归属部门
	private String loginName;// 登录名
	private String password;// 密码
	private String no; // 工号
	private String name; // 姓名
	private String email; // 邮箱
	private String phone; // 电话
	private String mobile; // 手机
	private String userType;// 用户类型
	private String loginIp; // 最后登陆IP
	private Date loginDate; // 最后登陆日期
	private Integer loginFlag; // 是否允许登陆
	private String photo; // 头像

	private String oldLoginName;// 原登录名
	private String newPassword; // 新密码

	private String oldLoginIp; // 上次登陆IP
	private Date oldLoginDate; // 上次登陆日期

	private Role role; // 根据角色查询用户条件

	private List<Role> roleDOList = Lists.newArrayList(); // 拥有角色列表
	
	public User() {
		super();
		this.loginFlag = 1;
	}
	
	public User(Role role){
		super();
		this.role = role;
	}
	
	
	public User(String id){
		super(id);
	}
	
	public User(String id, String loginName){
		super(id);
		this.loginName = loginName;
	}

	public Office getCompany() {
		return company;
	}

	public void setCompany(Office company) {
		this.company = company;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Integer getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(Integer loginFlag) {
		this.loginFlag = loginFlag;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getOldLoginName() {
		return oldLoginName;
	}

	public void setOldLoginName(String oldLoginName) {
		this.oldLoginName = oldLoginName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldLoginIp() {
		return oldLoginIp;
	}

	public void setOldLoginIp(String oldLoginIp) {
		this.oldLoginIp = oldLoginIp;
	}

	public Date getOldLoginDate() {
		return oldLoginDate;
	}

	public void setOldLoginDate(Date oldLoginDate) {
		this.oldLoginDate = oldLoginDate;
	}

	public Role getRoleDO() {
		return role;
	}

	public void setRoleDO(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoleDOList() {
		return roleDOList;
	}

	public void setRoleDOList(List<Role> roleDOList) {
		this.roleDOList = roleDOList;
	}

	public boolean isAdmin() {
		return isAdmin(this.id);
	}

	public static boolean isAdmin(String id) {
		return id != null && "1".equals(id);
	}

	@JsonIgnore
	public List<String> getRoleDOIdList() {
		List<String> roleDOIdList = Lists.newArrayList();
		for (Role role : roleDOList) {
			roleDOIdList.add(role.getId());
		}
		return roleDOIdList;
	}

	public void setRoleIdList(List<String> roleIdList) {
		roleDOList = Lists.newArrayList();
		for (String roleId : roleIdList) {
			Role role = new Role();
			role.setId(roleId);
			roleDOList.add(role);
		}
	}

	@Override
	public String toString() {
		return "UserDO [company=" + company + ", office=" + office + ", loginName=" + loginName + ", password="
				+ password + ", no=" + no + ", name=" + name + ", email=" + email + ", phone=" + phone + ", mobile="
				+ mobile + ", userType=" + userType + ", loginIp=" + loginIp + ", loginDate=" + loginDate
				+ ", loginFlag=" + loginFlag + ", photo=" + photo + ", oldLoginName=" + oldLoginName + ", newPassword="
				+ newPassword + ", oldLoginIp=" + oldLoginIp + ", oldLoginDate=" + oldLoginDate + ", roleDO=" + role
				+ ", roleDOList=" + roleDOList + "]";
	}

}
