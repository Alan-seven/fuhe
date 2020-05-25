package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdDisWusRslt;
import com.jsite.busi.szy.formal.service.TSfrdDisWusRsltService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdDisWusRsltVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/wusrslt")
@Api(value="水量调节计算用水单元结果信息",tags="水量调节计算用水单元结果信息接口")
public class TSfrdDisWusRsltController extends BaseController{

	@Autowired
	private TSfrdDisWusRsltService tSfrdDisWusRsltService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取水量调节计算用水单元结果信息", notes = "根据id获取水量调节计算用水单元结果信息",httpMethod = "POST")
	 public String get(@RequestBody TSfrdDisWusRsltVO tSfrdDisWusRsltVO, HttpServletResponse response) {
		TSfrdDisWusRslt tSfrdDisWusRslt = new  TSfrdDisWusRslt();
		if (null != tSfrdDisWusRsltVO) {
			tSfrdDisWusRslt = BeanMapper.map(tSfrdDisWusRsltVO, tSfrdDisWusRslt.getClass());
			tSfrdDisWusRslt = tSfrdDisWusRsltService.get(tSfrdDisWusRslt);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdDisWusRslt);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询水量调节计算用水单元结果", notes = "查询水量调节计算用水单元结果", httpMethod = "POST")
	public String list(@RequestBody TSfrdDisWusRsltVO tSfrdDisWusRsltVO, HttpServletResponse response) {
		TSfrdDisWusRslt tSfrdDisWusRslt = new  TSfrdDisWusRslt();
		if (null != tSfrdDisWusRsltVO) {
			tSfrdDisWusRslt = BeanMapper.map(tSfrdDisWusRsltVO, tSfrdDisWusRslt.getClass());
		}
	    Page<TSfrdDisWusRslt> page = tSfrdDisWusRsltService.getPage(new Page<TSfrdDisWusRslt>(tSfrdDisWusRsltVO.getPageNo(),tSfrdDisWusRsltVO.getPageSize()), tSfrdDisWusRslt);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存水量调节计算用水单元结果", notes = "保存水量调节计算用水单元结果", httpMethod = "POST")
	public String save(@RequestBody TSfrdDisWusRsltVO tSfrdDisWusRsltVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdDisWusRslt tSfrdDisWusRslt = new  TSfrdDisWusRslt();
		if (null != tSfrdDisWusRsltVO) {
			tSfrdDisWusRslt = BeanMapper.map(tSfrdDisWusRsltVO, tSfrdDisWusRslt.getClass());
		}
	    if(null!=tSfrdDisWusRsltService.get(tSfrdDisWusRslt)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfrdDisWusRsltService.save(tSfrdDisWusRslt);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改水量调节计算用水单元结果", notes = "修改水量调节计算用水单元结果", httpMethod = "POST")
	public String update(@RequestBody TSfrdDisWusRslt tSfrdDisWusRslt, HttpServletResponse response) {
		ServiceResp resp = tSfrdDisWusRsltService.update(tSfrdDisWusRslt);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除水量调节计算用水单元结果", notes = "删除水量调节计算用水单元结果", httpMethod = "POST")
	public String remove(@RequestBody TSfrdDisWusRslt tSfrdDisWusRslt, HttpServletResponse response){
		ServiceResp resp = tSfrdDisWusRsltService.remove(tSfrdDisWusRslt);
		return renderString(response, resp);
	}
	
}
