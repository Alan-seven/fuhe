package com.jsite.busi.szy.meeting.po;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.jsite.dao.AbstractData;

/**
 * 会商材料Entity
 * @author 徐旺旺
 * @version 2017-03-30
 */
public class DdsSRes extends AbstractData<DdsSRes> {
	
	private static final long serialVersionUID = 1L;
	private String conId;		// 会商ID
	private String resId;		// 材料ID
	private String path;		// 相对路径
	private String resName;		// 文件名称
	private String disc;		// 描述
	
	public DdsSRes() {
		super();
	}

	public DdsSRes(String id){
		super(id);
	}

	@Length(min=0, max=8, message="会商ID长度必须介于 0 和 8 之间")
	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}
	
	@Length(min=0, max=8, message="材料ID长度必须介于 0 和 8 之间")
	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}
	
	@Length(min=0, max=64, message="相对路径长度必须介于 0 和 64 之间")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Length(min=0, max=32, message="文件名称长度必须介于 0 和 32 之间")
	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}
	
	@Length(min=0, max=256, message="描述长度必须介于 0 和 256 之间")
	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
	}

}