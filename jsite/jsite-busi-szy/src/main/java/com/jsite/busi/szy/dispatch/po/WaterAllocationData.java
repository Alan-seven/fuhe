package com.jsite.busi.szy.dispatch.po;

import java.util.List;

/**
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-10-26 10:26
 */
public class WaterAllocationData {

    // 开始月
    private Integer startMonth;
    // 结束月
    private Integer endMonth;
    // 第一个月的旬
    private List<String> firstMonthXun;
    // 可供水量数据
    private DdsRdWsa wsResult;
    // 需水数据
    private List<DdsRdWnres> xsResults;
    // 分配水数据
    private List<DdsRdWares> fqResults;
    // 市区总需水和配水数据
    private List<DdsRdWares> totalResults;
    // 月旬的可供水量数据，只供界面显示用
    private Double mxMaxSl;

    public List<String> getFirstMonthXun() {
        return firstMonthXun;
    }

    public void setFirstMonthXun(List<String> firstMonthXun) {
        this.firstMonthXun = firstMonthXun;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    public List<DdsRdWnres> getXsResults() {
        return xsResults;
    }

    public void setXsResults(List<DdsRdWnres> xsResults) {
        this.xsResults = xsResults;
    }

    public List<DdsRdWares> getFqResults() {
        return fqResults;
    }

    public void setFqResults(List<DdsRdWares> fqResults) {
        this.fqResults = fqResults;
    }

    public DdsRdWsa getWsResult() {
        return wsResult;
    }

    public void setWsResult(DdsRdWsa wsResult) {
        this.wsResult = wsResult;
    }

    public List<DdsRdWares> getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(List<DdsRdWares> totalResults) {
        this.totalResults = totalResults;
    }

    public Double getMxMaxSl() {
        return mxMaxSl;
    }

    public void setMxMaxSl(Double mxMaxSl) {
        this.mxMaxSl = mxMaxSl;
    }
}
