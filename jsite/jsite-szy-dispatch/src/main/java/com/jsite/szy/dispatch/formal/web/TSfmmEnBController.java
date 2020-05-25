package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfmmEnB;
import com.jsite.busi.szy.formal.service.TSfmmEnBService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfmmEnBVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/enb")
@Api(value="实体基本信息",tags="实体基本信息接口")
public class TSfmmEnBController extends BaseController{

	@Autowired
	private TSfmmEnBService tSfmmEnBService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取实体基本信息", notes = "根据id获取实体基本信息",httpMethod = "POST")
	 public String get(@RequestBody TSfmmEnBVO tSfmmEnBVO, HttpServletResponse response) {
		TSfmmEnB tSfmmEnB = new  TSfmmEnB();
		if (null != tSfmmEnBVO) {
			tSfmmEnB = BeanMapper.map(tSfmmEnBVO, tSfmmEnB.getClass());
			tSfmmEnB = tSfmmEnBService.get(tSfmmEnB);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfmmEnB);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询实体基本", notes = "查询实体基本", httpMethod = "POST")
	public String list(@RequestBody TSfmmEnBVO tSfmmEnBVO, HttpServletResponse response) {
		TSfmmEnB tSfmmEnB = new  TSfmmEnB();
		if (null != tSfmmEnBVO) {
			tSfmmEnB = BeanMapper.map(tSfmmEnBVO, tSfmmEnB.getClass());
		}
	    Page<TSfmmEnB> page = tSfmmEnBService.getPage(new Page<TSfmmEnB>(tSfmmEnBVO.getPageNo(),tSfmmEnBVO.getPageSize()), tSfmmEnB);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存实体基本", notes = "保存实体基本", httpMethod = "POST")
	public String save(@RequestBody TSfmmEnBVO tSfmmEnBVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfmmEnB tSfmmEnB = new  TSfmmEnB();
		if (null != tSfmmEnBVO) {
			tSfmmEnB = BeanMapper.map(tSfmmEnBVO, tSfmmEnB.getClass());
		}
	    if(null!=tSfmmEnBService.get(tSfmmEnB)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfmmEnBService.save(tSfmmEnB);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改实体基本", notes = "修改实体基本", httpMethod = "POST")
	public String update(@RequestBody TSfmmEnB tSfmmEnB, HttpServletResponse response) {
		ServiceResp resp = tSfmmEnBService.update(tSfmmEnB);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除实体基本", notes = "删除实体基本", httpMethod = "POST")
	public String remove(@RequestBody TSfmmEnB tSfmmEnB, HttpServletResponse response){
		ServiceResp resp = tSfmmEnBService.remove(tSfmmEnB);
		return renderString(response, resp);
	}
	
}
