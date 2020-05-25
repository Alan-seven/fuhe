package com.jsite.szy.dispatch.formal.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfmmDisWu;
import com.jsite.busi.szy.formal.service.TSfmmDisWuService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfmmDisWuVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/initwu")
@Api(value="水量分配用水系数初始化参数信息",tags="水量分配用水系数初始化参数接口")
public class TSfmmDisWuController extends BaseController{

	@Autowired
	private TSfmmDisWuService tSfmmDisWuService;
	
    @ApiOperation(value = "查询水量分配用水系数初始化参数", notes = "查询水量分配用水系数初始化参数", httpMethod = "POST")
	public String list(@RequestBody TSfmmDisWuVO tSfmmDisWuVO, HttpServletResponse response) {
		TSfmmDisWu tSfmmDisWu = new  TSfmmDisWu();
		if (null != tSfmmDisWuVO) {
			tSfmmDisWu = BeanMapper.map(tSfmmDisWuVO, tSfmmDisWu.getClass());
		}
	    List<TSfmmDisWu> list = tSfmmDisWuService.list(tSfmmDisWu);
	    return renderString(response, list);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存水量分配用水系数初始化参数", notes = "保存水量分配用水系数初始化参数", httpMethod = "POST")
	public String save(@RequestBody TSfmmDisWuVO tSfmmDisWuVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfmmDisWu tSfmmDisWu = new  TSfmmDisWu();
		if (null != tSfmmDisWuVO) {
			tSfmmDisWu = BeanMapper.map(tSfmmDisWuVO, tSfmmDisWu.getClass());
		}
	    if(null!=tSfmmDisWuService.get(tSfmmDisWu)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfmmDisWuService.save(tSfmmDisWu);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改水量分配用水系数初始化参数", notes = "修改水量分配用水系数初始化参数", httpMethod = "POST")
	public String update(@RequestBody TSfmmDisWu tSfmmDisWu, HttpServletResponse response) {
		ServiceResp resp = tSfmmDisWuService.update(tSfmmDisWu);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除水量分配用水系数", notes = "删除水量分配用水系数初始化参数", httpMethod = "POST")
	public String remove(@RequestBody TSfmmDisWu tSfmmDisWu, HttpServletResponse response){
		ServiceResp resp = tSfmmDisWuService.remove(tSfmmDisWu);
		return renderString(response, resp);
	}
	
}
