/**
 */
package com.jsite.dao.sys.po;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.dao.AbstractData;

import javax.validation.constraints.NotNull;

/**
 * 部门信息表Entity
 * @author hjx
 * @version 2017-09-12
 */
public class DeptInfo extends AbstractData<DeptInfo> {
	
	private static final long serialVersionUID = 1L;
	private String depCode;		// 部门代码
	private String pcode;		// 上级部门代码
	private String depName;		// 部门名称
	private String depResp;		// 部门职责
	private String orgCode;		// 所属机构代码
	private Long ordernum;		// 顺序号
	private String ifdel = "0";		// 删除标志
	private Date mtime = new Date();		// 时间戳
	private String note;		// 备注
	private String slszyNode;		// 数据所属节点编码
	
	public DeptInfo() {
		super();
	}

	public DeptInfo(String id){
		super(id);
	}

	@Length(min=1, max=30, message="部门代码长度必须介于 1 和 30 之间")
	@NotNull(message="部门代码不能为空")
	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}
	
	@Length(min=0, max=30, message="上级部门代码长度必须介于 0 和 30 之间")
	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	
	@Length(min=1, max=100, message="部门名称长度必须介于 1 和 100 之间")
	@NotNull(message="部门名称不能为空")
	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	@Length(min=1, max=256, message="部门职责长度必须介于 1 和 256 之间")
	@NotNull(message="部门职责不能为空")
	public String getDepResp() {
		return depResp;
	}

	public void setDepResp(String depResp) {
		this.depResp = depResp;
	}
	
	@Length(min=1, max=30, message="所属机构代码长度必须介于 1 和 30 之间")
	@NotNull(message="所属机构代码不能为空")
	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	public Long getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Long ordernum) {
		this.ordernum = ordernum;
	}
	
	@Length(min=1, max=1, message="删除标志长度必须介于 1 和 1 之间")
	public String getIfdel() {
		return ifdel;
	}

	public void setIfdel(String ifdel) {
		this.ifdel = ifdel;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
	
	@Length(min=1, max=3, message="数据所属节点编码长度必须介于 1 和 3 之间")
	public String getSlszyNode() {
		return slszyNode;
	}

	public void setSlszyNode(String slszyNode) {
		this.slszyNode = slszyNode;
	}
	
}