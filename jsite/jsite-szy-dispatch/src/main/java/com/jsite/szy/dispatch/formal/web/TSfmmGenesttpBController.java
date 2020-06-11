package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfmmGenesttpB;
import com.jsite.busi.szy.formal.service.TSfmmGenesttpBService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfmmGenesttpBVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/sfmmgensttp")
@Api(value="概化测站类型信息",tags="概化测站类型信息接口")
public class TSfmmGenesttpBController extends BaseController{

	@Autowired
	private TSfmmGenesttpBService tSfmmGenesttpBService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取概化测站类型信息", notes = "根据id获取概化测站类型信息",httpMethod = "POST")
	 public String get(@RequestBody TSfmmGenesttpBVO tSfmmGenesttpBVO, HttpServletResponse response) {
		TSfmmGenesttpB tSfmmGenesttpB = new  TSfmmGenesttpB();
		if (null != tSfmmGenesttpBVO) {
			tSfmmGenesttpB = BeanMapper.map(tSfmmGenesttpBVO, tSfmmGenesttpB.getClass());
			tSfmmGenesttpB = tSfmmGenesttpBService.get(tSfmmGenesttpB);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfmmGenesttpB);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询概化测站类型信息", notes = "查询概化测站类型信息", httpMethod = "POST")
	public String list(@RequestBody TSfmmGenesttpBVO tSfmmGenesttpBVO, HttpServletResponse response) {
		TSfmmGenesttpB tSfmmGenesttpB = new  TSfmmGenesttpB();
		if (null != tSfmmGenesttpBVO) {
			tSfmmGenesttpB = BeanMapper.map(tSfmmGenesttpBVO, tSfmmGenesttpB.getClass());
		}
	    Page<TSfmmGenesttpB> page = tSfmmGenesttpBService.getPage(new Page<TSfmmGenesttpB>(tSfmmGenesttpBVO.getPageNo(),tSfmmGenesttpBVO.getPageSize()), tSfmmGenesttpB);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存概化测站类型信息", notes = "保存概化测站类型信息", httpMethod = "POST")
	public String save(@RequestBody TSfmmGenesttpBVO tSfmmGenesttpBVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfmmGenesttpB tSfmmGenesttpB = new  TSfmmGenesttpB();
		if (null != tSfmmGenesttpBVO) {
			tSfmmGenesttpB = BeanMapper.map(tSfmmGenesttpBVO, tSfmmGenesttpB.getClass());
		}
	    if(null!=tSfmmGenesttpBService.get(tSfmmGenesttpB)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfmmGenesttpBService.save(tSfmmGenesttpB);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改概化测站类型信息", notes = "修改概化测站类型信息", httpMethod = "POST")
	public String update(@RequestBody TSfmmGenesttpBVO tSfmmGenesttpBVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfmmGenesttpB tSfmmGenesttpB = new  TSfmmGenesttpB();
		if (null != tSfmmGenesttpBVO) {
			tSfmmGenesttpB = BeanMapper.map(tSfmmGenesttpBVO, tSfmmGenesttpB.getClass());
		}
		resp = tSfmmGenesttpBService.update(tSfmmGenesttpB);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除概化测站类型信息", notes = "删除概化测站类型信息", httpMethod = "POST")
	public String remove(@RequestBody TSfmmGenesttpB tSfmmGenesttpB, HttpServletResponse response){
		ServiceResp resp = tSfmmGenesttpBService.remove(tSfmmGenesttpB);
		return renderString(response, resp);
	}
	
}
