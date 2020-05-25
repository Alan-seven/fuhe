package com.jsite.szy.dispatch.sys.vo;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.jsite.core.web.PageVO;
import com.jsite.dao.AbstractData;
import com.jsite.dao.sys.po.Role;

import javax.validation.constraints.NotNull;

/**
 * 人员信息表Entity
 * @author hjx
 * @version 2017-09-12
 */
public class DdsSysUserinfoVO extends PageVO {	
	private static final long serialVersionUID = 1L;
	private String userCode;		// 人员代码
	private String userName;		// 人员姓名
	private String depCode;		// 所属部门编码
	private String sex;		// 性别
	private String dutyLevel;		// 职务级别
	private String title;		// 技术职称
	private Date mtime;		// 时间戳
	private String note;		// 备注
	private String telnumb;		// 电话
	private String moblenumb;		// 手机
	private String email;		// 电子邮件
	private Date birthday;		// 生日
	private String highestdegree;		// 学历
	private Long ordernum;		// 顺序号
	private String ifdel;		// 删除标志
	private String passwd;		// 用户密码
	private String slSzyNode;		// 数据所属节点编码
	private UserVO user;		// 人员身份识别信息
	
	private String river;		//河流编码
	
	private List<Role> roleDOList = Lists.newArrayList(); // 拥有角色列表
	
	public DdsSysUserinfoVO() {
		super();
	}

	@Length(min=1, max=18, message="人员代码长度必须介于 1 和 18 之间")
	@NotNull(message="人员代码不能为空")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Length(min=1, max=60, message="人员姓名长度必须介于 1 和 60 之间")
	@NotNull(message="人员姓名不能为空")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=1, max=14, message="所属部门编码长度必须介于 1 和 14 之间")
	@NotNull(message="所属部门编码不能为空")
	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}
	
	@Length(min=0, max=1, message="性别长度必须介于 0 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=2, message="职务级别长度必须介于 0 和 2 之间")
	public String getDutyLevel() {
		return dutyLevel;
	}

	public void setDutyLevel(String dutyLevel) {
		this.dutyLevel = dutyLevel;
	}
	
	@Length(min=0, max=40, message="技术职称长度必须介于 0 和 40 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间戳不能为空")
	public Date getMtime() {
		return mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	
	@Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	@Length(min=0, max=20, message="电话长度必须介于 0 和 20 之间")
	public String getTelnumb() {
		return telnumb;
	}

	public void setTelnumb(String telnumb) {
		this.telnumb = telnumb;
	}
	
	@Length(min=0, max=11, message="手机长度必须介于 0 和 11 之间")
	public String getMoblenumb() {
		return moblenumb;
	}

	public void setMoblenumb(String moblenumb) {
		this.moblenumb = moblenumb;
	}
	
	@Length(min=0, max=60, message="电子邮件长度必须介于 0 和 60 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Length(min=0, max=10, message="学历长度必须介于 0 和 10 之间")
	public String getHighestdegree() {
		return highestdegree;
	}

	public void setHighestdegree(String highestdegree) {
		this.highestdegree = highestdegree;
	}
	
	public Long getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Long ordernum) {
		this.ordernum = ordernum;
	}
	
	@Length(min=0, max=1, message="删除标志长度必须介于 0 和 1 之间")
	public String getIfdel() {
		return ifdel;
	}

	public void setIfdel(String ifdel) {
		this.ifdel = ifdel;
	}
	
	@Length(min=0, max=50, message="用户密码长度必须介于 0 和 50 之间")
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Length(min=1, max=3, message="数据所属节点编码长度必须介于 1 和 3 之间")
	@NotNull(message="数据所属节点编码不能为空")
	public String getSlSzyNode() {
		return slSzyNode;
	}

	public void setSlSzyNode(String slSzyNode) {
		this.slSzyNode = slSzyNode;
	}
	
	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}
	
	@Length(min=0, max=2, message="河流编码长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}

	public List<Role> getRoleDOList() {
		return roleDOList;
	}

	public void setRoleDOList(List<Role> roleDOList) {
		this.roleDOList = roleDOList;
	}
	
}