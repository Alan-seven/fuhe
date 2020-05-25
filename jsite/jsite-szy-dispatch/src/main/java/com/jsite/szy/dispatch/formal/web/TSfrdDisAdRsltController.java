package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdDisAdRslt;
import com.jsite.busi.szy.formal.service.TSfrdDisAdRsltService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdDisAdRsltVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/adrslt")
@Api(value="水量调节计算行政区划统计结果信息",tags="水量调节计算行政区划统计结果信息接口")
public class TSfrdDisAdRsltController extends BaseController{

	@Autowired
	private TSfrdDisAdRsltService tSfrdDisAdRsltService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取水量调节计算行政区划统计结果信息", notes = "根据id获取水量调节计算行政区划统计结果信息",httpMethod = "POST")
	 public String get(@RequestBody TSfrdDisAdRsltVO tSfrdDisAdRsltVO, HttpServletResponse response) {
		TSfrdDisAdRslt tSfrdDisAdRslt = new  TSfrdDisAdRslt();
		if (null != tSfrdDisAdRsltVO) {
			tSfrdDisAdRslt = BeanMapper.map(tSfrdDisAdRsltVO, tSfrdDisAdRslt.getClass());
			tSfrdDisAdRslt = tSfrdDisAdRsltService.get(tSfrdDisAdRslt);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdDisAdRslt);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询水量调节计算行政区划统计结果", notes = "查询水量调节计算行政区划统计结果", httpMethod = "POST")
	public String list(@RequestBody TSfrdDisAdRsltVO tSfrdDisAdRsltVO, HttpServletResponse response) {
		TSfrdDisAdRslt tSfrdDisAdRslt = new  TSfrdDisAdRslt();
		if (null != tSfrdDisAdRsltVO) {
			tSfrdDisAdRslt = BeanMapper.map(tSfrdDisAdRsltVO, tSfrdDisAdRslt.getClass());
		}
	    Page<TSfrdDisAdRslt> page = tSfrdDisAdRsltService.getPage(new Page<TSfrdDisAdRslt>(tSfrdDisAdRsltVO.getPageNo(),tSfrdDisAdRsltVO.getPageSize()), tSfrdDisAdRslt);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存水量调节计算行政区划统计结果", notes = "保存水量调节计算行政区划统计结果", httpMethod = "POST")
	public String save(@RequestBody TSfrdDisAdRsltVO tSfrdDisAdRsltVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdDisAdRslt tSfrdDisAdRslt = new  TSfrdDisAdRslt();
		if (null != tSfrdDisAdRsltVO) {
			tSfrdDisAdRslt = BeanMapper.map(tSfrdDisAdRsltVO, tSfrdDisAdRslt.getClass());
		}
	    if(null!=tSfrdDisAdRsltService.get(tSfrdDisAdRslt)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfrdDisAdRsltService.save(tSfrdDisAdRslt);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改水量调节计算行政区划统计结果", notes = "修改水量调节计算行政区划统计结果", httpMethod = "POST")
	public String update(@RequestBody TSfrdDisAdRslt tSfrdDisAdRslt, HttpServletResponse response) {
		ServiceResp resp = tSfrdDisAdRsltService.update(tSfrdDisAdRslt);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除水量调节计算行政区划统计结果", notes = "删除水量调节计算行政区划统计结果", httpMethod = "POST")
	public String remove(@RequestBody TSfrdDisAdRslt tSfrdDisAdRslt, HttpServletResponse response){
		ServiceResp resp = tSfrdDisAdRsltService.remove(tSfrdDisAdRslt);
		return renderString(response, resp);
	}
}
