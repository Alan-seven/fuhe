package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfmmGenestB;
import com.jsite.busi.szy.formal.service.TSfmmGenestBService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfmmGenestBVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/sfmmgenst")
@Api(value="概化测站基本信息",tags="概化测站基本信息接口")
public class TSfmmGenestBController extends BaseController{
	
	@Autowired
	private TSfmmGenestBService tSfmmGenestBService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取概化测站类型信息", notes = "根据id获取概化测站类型信息",httpMethod = "POST")
	 public String get(@RequestBody TSfmmGenestBVO tSfmmGenestBVO, HttpServletResponse response) {
		TSfmmGenestB tSfmmGenestB = new  TSfmmGenestB();
		if (null != tSfmmGenestBVO) {
			tSfmmGenestB = BeanMapper.map(tSfmmGenestBVO, tSfmmGenestB.getClass());
			tSfmmGenestB = tSfmmGenestBService.get(tSfmmGenestB);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfmmGenestB);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询概化测站类型信息", notes = "查询概化测站类型信息", httpMethod = "POST")
	public String list(@RequestBody TSfmmGenestBVO tSfmmGenestBVO, HttpServletResponse response) {
		TSfmmGenestB tSfmmGenestB = new  TSfmmGenestB();
		if (null != tSfmmGenestBVO) {
			tSfmmGenestB = BeanMapper.map(tSfmmGenestBVO, tSfmmGenestB.getClass());
		}
	    Page<TSfmmGenestB> page = tSfmmGenestBService.getPage(new Page<TSfmmGenestB>(tSfmmGenestBVO.getPageNo(),tSfmmGenestBVO.getPageSize()), tSfmmGenestB);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存概化测站类型信息", notes = "保存概化测站类型信息", httpMethod = "POST")
	public String save(@RequestBody TSfmmGenestBVO tSfmmGenestBVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfmmGenestB tSfmmGenestB = new  TSfmmGenestB();
		if (null != tSfmmGenestBVO) {
			tSfmmGenestB = BeanMapper.map(tSfmmGenestBVO, tSfmmGenestB.getClass());
		}
	    if(null!=tSfmmGenestBService.get(tSfmmGenestB)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfmmGenestBService.save(tSfmmGenestB);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改概化测站类型信息", notes = "修改概化测站类型信息", httpMethod = "POST")
	public String update(@RequestBody TSfmmGenestBVO tSfmmGenestBVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfmmGenestB tSfmmGenestB = new  TSfmmGenestB();
		if (null != tSfmmGenestBVO) {
			tSfmmGenestB = BeanMapper.map(tSfmmGenestBVO, tSfmmGenestB.getClass());
		}
		resp = tSfmmGenestBService.update(tSfmmGenestB);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除概化测站类型信息", notes = "删除概化测站类型信息", httpMethod = "POST")
	public String remove(@RequestBody TSfmmGenestB tSfmmGenestB, HttpServletResponse response){
		ServiceResp resp = tSfmmGenestBService.remove(tSfmmGenestB);
		return renderString(response, resp);
	}
	

}
