package com.jsite.core.page;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsite.core.config.Global;
import com.jsite.core.web.PageVO;

/**
 * 分页类
 */
public class Page<T> {

	private int pageNo = 1; // 当前页码
    private int pageSize = Integer.valueOf(Global.getConfig("page.pageSize")); // 页面大小，设置为“-1”表示不进行分页（分页无效）
 
    private long count;// 总记录数，设置为“-1”表示不查询总数
 
    private boolean firstPage;// 是否是第一页
    private boolean lastPage;// 是否是最后一页
 
    private List<T> list = new ArrayList<T>();
 
    private String orderBy = ""; // 标准查询有效， 实例： updatedate desc, name asc
 
    private String funcName = "page"; // 设置点击页码调用的js函数名称，默认为page，在一页有多个分页对象时使用。
 
    private String funcParam = ""; // 函数的附加参数，第三个参数值。
    
    public Page() {
        this.pageSize = -1;
    }
    
    public Page(PageVO pageVO)
    {
      this(pageVO.getPageNo(), pageVO.getPageSize());
    }
    
    public Page(int pageSize)
    {
      this(1, pageSize, 0L);
    }
    /**
     * 构造方法
     * 
     * @param pageNo
     *            当前页码
     * @param pageSize
     *            分页大小
     */
    public Page(int pageNo, int pageSize) {
        this(pageNo, pageSize, 0);
    }
 
    /**
     * 构造方法
     * 
     * @param pageNo
     *            当前页码
     * @param pageSize
     *            分页大小
     * @param count
     *            数据条数
     */
    public Page(int pageNo, int pageSize, long count) {
        this(pageNo, pageSize, count, new ArrayList<T>());
    }
 
    /**
     * 构造方法
     * 
     * @param pageNo
     *            当前页码
     * @param pageSize
     *            分页大小
     * @param count
     *            数据条数
     * @param list
     *            本页数据对象列表
     */
    public Page(int pageNo, int pageSize, long count, List<T> list) {
        if (pageSize <= 0) {
            pageSize = this.pageSize;
        }
        this.setCount(count);
        this.setPageNo(pageNo);
        this.pageSize = pageSize;
        this.list = list;
    }
 
    /**
     * 获取设置总数
     * 
     * @return
     */
    public long getCount() {
        return count;
    }
 
    /**
     * 设置数据总数
     * 
     * @param count
     */
    public void setCount(long count) {
        this.count = count;
        if (pageSize >= count) {
            pageNo = 1;
        }
    }
 
    /**
     * 获取当前页码
     * 
     * @return
     */
    public int getPageNo() {
        return pageNo;
    }
 
    /**
     * 设置当前页码
     * 
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
 
    /**
     * 获取页面大小
     * 
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }
 
    /**
     * 设置页面大小（最大500）
     * 
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0 ? 10 : pageSize;// > 500 ? 500 : pageSize;
    }
 
    /**
     * 是否为第一页
     * 
     * @return
     */
    @JsonIgnore
    public boolean isFirstPage() {
        return firstPage;
    }
 
    /**
     * 是否为最后一页
     * 
     * @return
     */
    @JsonIgnore
    public boolean isLastPage() {
        return lastPage;
    }
 
    /**
     * 上一页索引值
     * 
     * @return
     */
    @JsonIgnore
    public int getPrev() {
        if (isFirstPage()) {
            return pageNo;
        } else {
            return pageNo - 1;
        }
    }
 
    /**
     * 下一页索引值
     * 
     * @return
     */
    @JsonIgnore
    public int getNext() {
        if (isLastPage()) {
            return pageNo;
        } else {
            return pageNo + 1;
        }
    }
 
    /**
     * 获取本页数据对象列表
     * 
     * @return List<T>
     */
    public List<T> getList() {
        return list;
    }
 
    /**
     * 设置本页数据对象列表
     * 
     * @param list
     */
    public Page<T> setList(List<T> list) {
        this.list = list;
        return this;
    }
 
    /**
     * 获取查询排序字符串
     * 
     * @return
     */
    @JsonIgnore
    public String getOrderBy() {
        // SQL过滤，防止注入
        String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
                + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
        Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        if (sqlPattern.matcher(orderBy).find()) {
            return "";
        }
        return orderBy;
    }
 
    /**
     * 设置查询排序，标准查询有效， 实例： updatedate desc, name asc
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
 
    /**
     * 获取点击页码调用的js函数名称 function ${page.funcName}(pageNo){location=
     * "${ctx}/list-${category.id}${urlSuffix}?pageNo="+i;}
     * 
     * @return
     */
    @JsonIgnore
    public String getFuncName() {
        return funcName;
    }
 
    /**
     * 设置点击页码调用的js函数名称，默认为page，在一页有多个分页对象时使用。
     * 
     * @param funcName
     *            默认为page
     */
    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }
 
    /**
     * 获取分页函数的附加参数
     * 
     * @return
     */
    @JsonIgnore
    public String getFuncParam() {
        return funcParam;
    }
 
    /**
     * 设置分页函数的附加参数
     * 
     * @return
     */
    public void setFuncParam(String funcParam) {
        this.funcParam = funcParam;
    }
 
    /**
     * 分页是否有效
     * 
     * @return this.pageSize==-1
     */
    @JsonIgnore
    public boolean isDisabled() {
        return this.pageSize == -1;
    }
 
    /**
     * 是否进行总数统计
     * 
     * @return this.count==-1
     */
    @JsonIgnore
    public boolean isNotCount() {
        return this.count == -1;
    }
 
    /**
     * 获取 Hibernate FirstResult
     */
    public int getFirstResult() {
        int firstResult = (getPageNo() - 1) * getPageSize();
        if (firstResult >= getCount()) {
            firstResult = 0;
        }
        return firstResult;
    }
 
    /**
     * 获取 Hibernate MaxResults
     */
    public int getMaxResults() {
        return getPageSize();
    }
}
