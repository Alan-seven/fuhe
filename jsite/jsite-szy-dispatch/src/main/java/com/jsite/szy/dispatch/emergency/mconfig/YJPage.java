package com.jsite.szy.dispatch.emergency.mconfig;

import java.util.List;

/**
 * 超图返回应急数据外层对象
 * @author admin
 *
 */
public class YJPage {

	private Integer currPage;
	
	private Integer totalPage;
	
	private Integer totalRecord;
	
	private List<YJData> data;
	
	private List<YJEvent> dataList;
	
	private String message;	//提示信息
	
	private Integer code = 0;	//请求状态  默认代表请求成功  1--代表请求异常

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<YJData> getData() {
		return data;
	}

	public void setData(List<YJData> data) {
		this.data = data;
	}

	public List<YJEvent> getDataList() {
		return dataList;
	}

	public void setDataList(List<YJEvent> dataList) {
		this.dataList = dataList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
