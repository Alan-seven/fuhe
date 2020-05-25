package com.jsite.szy.dispatch.formal.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdDisWu;
import com.jsite.busi.szy.formal.service.TSfrdDisWuService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdDisWuVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/diswu")
@Api(value="水量分配用水系数信息",tags="水量分配用水系数接口")
public class TSfrdDisWuController extends BaseController{

	@Autowired
	private TSfrdDisWuService tSfrdDisWuService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取水量分配用水系数信息", notes = "根据id获取水量分配用水系数信息",httpMethod = "POST")
	 public String get(@RequestBody TSfrdDisWuVO tSfrdDisWuVO, HttpServletResponse response) {
		TSfrdDisWu tSfrdDisWu = new  TSfrdDisWu();
		if (null != tSfrdDisWuVO) {
			tSfrdDisWu = BeanMapper.map(tSfrdDisWuVO, tSfrdDisWu.getClass());
			tSfrdDisWu = tSfrdDisWuService.get(tSfrdDisWu);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdDisWu);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询水量分配用水系数", notes = "查询水量分配用水系数", httpMethod = "POST")
	public String list(@RequestBody TSfrdDisWuVO tSfrdDisWuVO, HttpServletResponse response) {
		TSfrdDisWu tSfrdDisWu = new  TSfrdDisWu();
		if (null != tSfrdDisWuVO) {
			tSfrdDisWu = BeanMapper.map(tSfrdDisWuVO, tSfrdDisWu.getClass());
		}
	    List<TSfrdDisWu> list = tSfrdDisWuService.list(tSfrdDisWu);
	    return renderString(response, list);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存水量分配用水系数", notes = "保存水量分配用水系数", httpMethod = "POST")
	public String save(@RequestBody TSfrdDisWuVO tSfrdDisWuVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdDisWu tSfrdDisWu = new  TSfrdDisWu();
		if (null != tSfrdDisWuVO) {
			tSfrdDisWu = BeanMapper.map(tSfrdDisWuVO, tSfrdDisWu.getClass());
		}
	    if(null!=tSfrdDisWuService.get(tSfrdDisWu)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfrdDisWuService.save(tSfrdDisWu);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改水量分配用水系数", notes = "修改水量分配用水系数", httpMethod = "POST")
	public String update(@RequestBody TSfrdDisWu tSfrdDisWu, HttpServletResponse response) {
		ServiceResp resp = tSfrdDisWuService.update(tSfrdDisWu);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除水量分配用水系数", notes = "删除水量分配用水系数", httpMethod = "POST")
	public String remove(@RequestBody TSfrdDisWu tSfrdDisWu, HttpServletResponse response){
		ServiceResp resp = tSfrdDisWuService.remove(tSfrdDisWu);
		return renderString(response, resp);
	}
	
}
