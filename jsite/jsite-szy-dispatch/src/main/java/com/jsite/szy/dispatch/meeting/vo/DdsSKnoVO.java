package com.jsite.szy.dispatch.meeting.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsite.core.web.PageVO;

/**
 * 会商知识库Entity
 * @author 徐旺旺
 * @version 2017-03-30
 */
public class DdsSKnoVO extends PageVO {
	
	private String knoId;		// 文库ID
	private String title;		// 标题
	private String creator;		// 创建人
	private String knoType;		// 类别
	private Date dt;		// 创建日期
	private String keys;		// 关键字
	private String nt;		// 备注
	private String content;		// 内容
	private String path;		// 相对路径
	
	private String river; //河流标识  后续需要配置到系统管理中 
	
	@Length(min=0, max=2, message="河流标识长度必须介于 0 和 2 之间")
	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}
	
	public DdsSKnoVO() {
		super();
	}

	@Length(min=1, max=32, message="文库ID长度必须介于 1 和 32 之间")
	public String getKnoId() {
		return knoId;
	}

	public void setKnoId(String knoId) {
		this.knoId = knoId;
	}
	
	@Length(min=1, max=32, message="标题长度必须介于 1 和 32 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=32, message="创建人长度必须介于 0 和 32 之间")
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	@Length(min=0, max=16, message="类别长度必须介于 0 和 16 之间")
	public String getKnoType() {
		return knoType;
	}

	public void setKnoType(String knoType) {
		this.knoType = knoType;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}
	
	@Length(min=0, max=64, message="关键字长度必须介于 0 和 64 之间")
	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}
	
	@Length(min=0, max=64, message="备注长度必须介于 0 和 64 之间")
	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}
	
	@Length(min=0, max=255, message="内容长度必须介于 0 和 255 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=64, message="相对路径长度必须介于 0 和 64 之间")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}