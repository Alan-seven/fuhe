package com.jsite.szy.dispatch.emergency.mconfig;
 
import java.util.List;
 
import com.google.common.collect.Lists;
import com.jsite.busi.szy.emergency.po.DdsEdGisLegend;
/**
 * 应急调度模型对应的计算结果数据
 * @author admin
 *
 */
public class ModelConsecData {
    
    private String secId;
    private String secnm;
    private String stype;
    
    private List<ModelData> dataList = Lists.newArrayList();
 
    public String getSecId() {
        return secId;
    }
 
    public void setSecId(String secId) {
        this.secId = secId;
    }
 
    public String getSecnm() {
        return secnm;
    }
 
    public void setSecnm(String secnm) {
        this.secnm = secnm;
    }
 
	public List<ModelData> getDataList() {
		return dataList;
	}

	public void setDataList(List<ModelData> dataList) {
		this.dataList = dataList;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

}
