package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdRelDataitemRslt;
import com.jsite.busi.szy.formal.service.TSfrdRelDataitemRsltService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdRelDataitemRsltVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/relrslt")
@Api(value="常规调度结果与模型输出关系信息",tags="常规调度结果与模型输出关系信息接口")
public class TSfrdRelDataitemRsltController extends BaseController{

	@Autowired
	private TSfrdRelDataitemRsltService tSfrdRelDataitemRsltService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取常规调度结果与模型输出关系信息", notes = "根据id获取常规调度结果与模型输出关系信息",httpMethod = "POST")
	 public String get(@RequestBody TSfrdRelDataitemRsltVO tSfrdRelDataitemRsltVO, HttpServletResponse response) {
		TSfrdRelDataitemRslt tSfrdRelDataitemRslt = new  TSfrdRelDataitemRslt();
		if (null != tSfrdRelDataitemRsltVO) {
			tSfrdRelDataitemRslt = BeanMapper.map(tSfrdRelDataitemRsltVO, tSfrdRelDataitemRslt.getClass());
			tSfrdRelDataitemRslt = tSfrdRelDataitemRsltService.get(tSfrdRelDataitemRslt);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdRelDataitemRslt);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询常规调度结果与模型输出关系", notes = "查询常规调度结果与模型输出关系", httpMethod = "POST")
	public String list(@RequestBody TSfrdRelDataitemRsltVO tSfrdRelDataitemRsltVO, HttpServletResponse response) {
		TSfrdRelDataitemRslt tSfrdRelDataitemRslt = new  TSfrdRelDataitemRslt();
		if (null != tSfrdRelDataitemRsltVO) {
			tSfrdRelDataitemRslt = BeanMapper.map(tSfrdRelDataitemRsltVO, tSfrdRelDataitemRslt.getClass());
		}
	    Page<TSfrdRelDataitemRslt> page = tSfrdRelDataitemRsltService.getPage(new Page<TSfrdRelDataitemRslt>(tSfrdRelDataitemRsltVO.getPageNo(),tSfrdRelDataitemRsltVO.getPageSize()), tSfrdRelDataitemRslt);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存常规调度结果与模型输出关系", notes = "保存常规调度结果与模型输出关系", httpMethod = "POST")
	public String save(@RequestBody TSfrdRelDataitemRsltVO tSfrdRelDataitemRsltVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdRelDataitemRslt tSfrdRelDataitemRslt = new  TSfrdRelDataitemRslt();
		if (null != tSfrdRelDataitemRsltVO) {
			tSfrdRelDataitemRslt = BeanMapper.map(tSfrdRelDataitemRsltVO, tSfrdRelDataitemRslt.getClass());
		}
	    if(null!=tSfrdRelDataitemRsltService.get(tSfrdRelDataitemRslt)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfrdRelDataitemRsltService.save(tSfrdRelDataitemRslt);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改常规调度结果与模型输出关系", notes = "修改常规调度结果与模型输出关系", httpMethod = "POST")
	public String update(@RequestBody TSfrdRelDataitemRslt tSfrdRelDataitemRslt, HttpServletResponse response) {
		ServiceResp resp = tSfrdRelDataitemRsltService.update(tSfrdRelDataitemRslt);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除常规调度结果与模型输出关系", notes = "删除常规调度结果与模型输出关系", httpMethod = "POST")
	public String remove(@RequestBody TSfrdRelDataitemRslt tSfrdRelDataitemRslt, HttpServletResponse response){
		ServiceResp resp = tSfrdRelDataitemRsltService.remove(tSfrdRelDataitemRslt);
		return renderString(response, resp);
	}
}
