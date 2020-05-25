package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdIfRslt;
import com.jsite.busi.szy.formal.service.TSfrdIfRsltService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdIfRsltVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/ifrslt")
@Api(value="来水预报计算结果信息",tags="来水预报计算结果信息接口")
public class TSfrdIfRsltController extends BaseController{

	@Autowired
	private TSfrdIfRsltService tSfrdIfRsltService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取来水预报计算结果信息", notes = "根据id获取来水预报计算结果信息",httpMethod = "POST")
	 public String get(@RequestBody TSfrdIfRsltVO tSfrdIfRsltVO, HttpServletResponse response) {
		TSfrdIfRslt tSfrdIfRslt = new  TSfrdIfRslt();
		if (null != tSfrdIfRsltVO) {
			tSfrdIfRslt = BeanMapper.map(tSfrdIfRsltVO, tSfrdIfRslt.getClass());
			tSfrdIfRslt = tSfrdIfRsltService.get(tSfrdIfRslt);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdIfRslt);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询来水预报计算结果", notes = "查询来水预报计算结果", httpMethod = "POST")
	public String list(@RequestBody TSfrdIfRsltVO tSfrdIfRsltVO, HttpServletResponse response) {
		TSfrdIfRslt tSfrdIfRslt = new  TSfrdIfRslt();
		if (null != tSfrdIfRsltVO) {
			tSfrdIfRslt = BeanMapper.map(tSfrdIfRsltVO, tSfrdIfRslt.getClass());
		}
	    Page<TSfrdIfRslt> page = tSfrdIfRsltService.getPage(new Page<TSfrdIfRslt>(tSfrdIfRsltVO.getPageNo(),tSfrdIfRsltVO.getPageSize()), tSfrdIfRslt);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存来水预报计算结果", notes = "保存来水预报计算结果", httpMethod = "POST")
	public String save(@RequestBody TSfrdIfRsltVO tSfrdIfRsltVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdIfRslt tSfrdIfRslt = new  TSfrdIfRslt();
		if (null != tSfrdIfRsltVO) {
			tSfrdIfRslt = BeanMapper.map(tSfrdIfRsltVO, tSfrdIfRslt.getClass());
		}
	    if(null!=tSfrdIfRsltService.get(tSfrdIfRslt)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfrdIfRsltService.save(tSfrdIfRslt);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改来水预报计算结果", notes = "修改来水预报计算结果", httpMethod = "POST")
	public String update(@RequestBody TSfrdIfRslt tSfrdIfRslt, HttpServletResponse response) {
		ServiceResp resp = tSfrdIfRsltService.update(tSfrdIfRslt);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除来水预报计算结果", notes = "删除来水预报计算结果", httpMethod = "POST")
	public String remove(@RequestBody TSfrdIfRslt tSfrdIfRslt, HttpServletResponse response){
		ServiceResp resp = tSfrdIfRsltService.remove(tSfrdIfRslt);
		return renderString(response, resp);
	}
	
}
