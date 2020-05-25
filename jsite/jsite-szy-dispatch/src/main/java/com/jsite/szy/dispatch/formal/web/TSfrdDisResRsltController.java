package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdDisResRslt;
import com.jsite.busi.szy.formal.service.TSfrdDisResRsltService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdDisResRsltVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/disrslt")
@Api(value="水量调节计算水库结果信息",tags="水量调节计算水库结果信息接口")
public class TSfrdDisResRsltController extends BaseController{
	@Autowired
	private TSfrdDisResRsltService tSfrdDisResRsltService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取水量调节计算水库结果信息", notes = "根据id获取水量调节计算水库结果信息",httpMethod = "POST")
	 public String get(@RequestBody TSfrdDisResRsltVO tSfrdDisResRsltVO, HttpServletResponse response) {
		TSfrdDisResRslt tSfrdDisResRslt = new  TSfrdDisResRslt();
		if (null != tSfrdDisResRsltVO) {
			tSfrdDisResRslt = BeanMapper.map(tSfrdDisResRsltVO, tSfrdDisResRslt.getClass());
			tSfrdDisResRslt = tSfrdDisResRsltService.get(tSfrdDisResRslt);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdDisResRslt);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询水量调节计算水库结果", notes = "查询水量调节计算水库结果", httpMethod = "POST")
	public String list(@RequestBody TSfrdDisResRsltVO tSfrdDisResRsltVO, HttpServletResponse response) {
		TSfrdDisResRslt tSfrdDisResRslt = new  TSfrdDisResRslt();
		if (null != tSfrdDisResRsltVO) {
			tSfrdDisResRslt = BeanMapper.map(tSfrdDisResRsltVO, tSfrdDisResRslt.getClass());
		}
	    Page<TSfrdDisResRslt> page = tSfrdDisResRsltService.getPage(new Page<TSfrdDisResRslt>(tSfrdDisResRsltVO.getPageNo(),tSfrdDisResRsltVO.getPageSize()), tSfrdDisResRslt);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存水量调节计算水库结果", notes = "保存水量调节计算水库结果", httpMethod = "POST")
	public String save(@RequestBody TSfrdDisResRsltVO tSfrdDisResRsltVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdDisResRslt tSfrdDisResRslt = new  TSfrdDisResRslt();
		if (null != tSfrdDisResRsltVO) {
			tSfrdDisResRslt = BeanMapper.map(tSfrdDisResRsltVO, tSfrdDisResRslt.getClass());
		}
	    if(null!=tSfrdDisResRsltService.get(tSfrdDisResRslt)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfrdDisResRsltService.save(tSfrdDisResRslt);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改水量调节计算水库结果", notes = "修改水量调节计算水库结果", httpMethod = "POST")
	public String update(@RequestBody TSfrdDisResRslt tSfrdDisResRslt, HttpServletResponse response) {
		ServiceResp resp = tSfrdDisResRsltService.update(tSfrdDisResRslt);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除水量调节计算水库结果", notes = "删除水量调节计算水库结果", httpMethod = "POST")
	public String remove(@RequestBody TSfrdDisResRslt tSfrdDisResRslt, HttpServletResponse response){
		ServiceResp resp = tSfrdDisResRsltService.remove(tSfrdDisResRslt);
		return renderString(response, resp);
	}
}
