package com.jsite.szy.dispatch.meeting.vo;

import org.hibernate.validator.constraints.Length;

import com.jsite.core.web.PageVO;

/**
 * 专家信息Entity
 * @author 徐旺旺
 * @version 2017-03-30
 */
public class DdsSExpVO extends PageVO {
	
	private String code;		// 专家编号
	private String name;		// 姓名
	private String naplace;		// 籍贯
	private String dept;		// 所属单位
	private String post;		// 职务
	private String grade;		// 职称
	private String tel;		// 联系电话
	private String mail;		// 邮箱
	private String major;		// 所学专业
	private String firmaj;		// 第一熟悉专业
	private String secmaj;		// 第二熟悉专业
	private String thimaj;		// 第三熟悉专业
	private String sex;		// 性别
	private String university;		// 毕业院校
	private String age;		// 年龄
	private String profile;		// 个人简介
	private String comments;		// 推荐意见
	private String idcard;			//身份证号码
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	public DdsSExpVO() {
		super();
	}

	@Length(min=1, max=32, message="专家编号长度必须介于 1 和 32 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=16, message="姓名长度必须介于 0 和 16 之间")
	public String getName() {
		return name; 
	}
 
	public void setName(String name) {
		this.name = name;
	}
	 
	@Length(min=0, max=64, message="籍贯长度必须介于 0 和 64 之间")
	public String getNaplace() {
		return naplace;
	}

	public void setNaplace(String naplace) {
		this.naplace = naplace;
	}
	
	@Length(min=0, max=64, message="所属单位长度必须介于 0 和 64 之间")
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Length(min=0, max=32, message="职务长度必须介于 0 和 32 之间")
	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
	@Length(min=0, max=16, message="职称长度必须介于 0 和 16 之间")
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Length(min=0, max=11, message="联系电话长度必须介于 0 和 11 之间")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Length(min=0, max=32, message="邮箱长度必须介于 0 和 32 之间")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Length(min=0, max=32, message="所学专业长度必须介于 0 和 32 之间")
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Length(min=0, max=32, message="第一熟悉专业长度必须介于 0 和 32 之间")
	public String getFirmaj() {
		return firmaj;
	}

	public void setFirmaj(String firmaj) {
		this.firmaj = firmaj;
	}
	
	@Length(min=0, max=32, message="第二熟悉专业长度必须介于 0 和 32 之间")
	public String getSecmaj() {
		return secmaj;
	}

	public void setSecmaj(String secmaj) {
		this.secmaj = secmaj;
	}
	
	@Length(min=0, max=32, message="第三熟悉专业长度必须介于 0 和 32 之间")
	public String getThimaj() {
		return thimaj;
	}

	public void setThimaj(String thimaj) {
		this.thimaj = thimaj;
	}
	
	@Length(min=0, max=2, message="性别长度必须介于 0 和 2 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=32, message="毕业院校长度必须介于 0 和 32 之间")
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}
	
	@Length(min=0, max=11, message="年龄长度必须介于 0 和 11 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=0, max=128, message="个人简介长度必须介于 0 和 128 之间")
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	@Length(min=0, max=256, message="推荐意见长度必须介于 0 和 256 之间")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Length(min=0, max=128, message="身份证号码长度必须介于 0 和 18 之间")
	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
}