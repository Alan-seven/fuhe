package com.jsite.core.web;

import com.jsite.core.config.Global;

public class PageVO {
	//支持ext控件
	//public int page;
	//public int limit;
	//支持antd控件
	private int pageNo ; // 当前页码
    private int pageSize ; // 页面大小，设置为“-1”表示不进行分页（分页无效）
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
//	public int getPage() {
//		return page;
//	}
//	public void setPage(int page) {
//		this.page = page;
//	}
//	public int getLimit() {
//		return limit;
//	}
//	public void setLimit(int limit) {
//		this.limit = limit;
//	}
    
	
	
}
