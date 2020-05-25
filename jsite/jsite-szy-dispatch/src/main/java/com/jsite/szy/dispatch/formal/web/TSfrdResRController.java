package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdResR;
import com.jsite.busi.szy.formal.service.TSfrdResRService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdResRVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/resr")
@Api(value="水库实际调节过程信息",tags="水库实际调节过程信息接口")
public class TSfrdResRController extends BaseController{

	@Autowired
	private TSfrdResRService tSfrdResRService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取水库实际调节过程信息", notes = "根据id获取水库实际调节过程信息",httpMethod = "POST")
	 public String get(@RequestBody TSfrdResRVO tSfrdResRVO, HttpServletResponse response) {
		TSfrdResR tSfrdResR = new  TSfrdResR();
		if (null != tSfrdResRVO) {
			tSfrdResR = BeanMapper.map(tSfrdResRVO, tSfrdResR.getClass());
			tSfrdResR = tSfrdResRService.get(tSfrdResR);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdResR);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询水库实际调节过程", notes = "查询水库实际调节过程", httpMethod = "POST")
	public String list(@RequestBody TSfrdResRVO tSfrdResRVO, HttpServletResponse response) {
		TSfrdResR tSfrdResR = new  TSfrdResR();
		if (null != tSfrdResRVO) {
			tSfrdResR = BeanMapper.map(tSfrdResRVO, tSfrdResR.getClass());
		}
	    Page<TSfrdResR> page = tSfrdResRService.getPage(new Page<TSfrdResR>(tSfrdResRVO.getPageNo(),tSfrdResRVO.getPageSize()), tSfrdResR);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存水库实际调节过程", notes = "保存水库实际调节过程", httpMethod = "POST")
	public String save(@RequestBody TSfrdResRVO tSfrdResRVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdResR tSfrdResR = new  TSfrdResR();
		if (null != tSfrdResRVO) {
			tSfrdResR = BeanMapper.map(tSfrdResRVO, tSfrdResR.getClass());
		}
	    if(null!=tSfrdResRService.get(tSfrdResR)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfrdResRService.save(tSfrdResR);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改水库实际调节过程", notes = "修改水库实际调节过程", httpMethod = "POST")
	public String update(@RequestBody TSfrdResR tSfrdResR, HttpServletResponse response) {
		ServiceResp resp = tSfrdResRService.update(tSfrdResR);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除水库实际调节过程", notes = "删除水库实际调节过程", httpMethod = "POST")
	public String remove(@RequestBody TSfrdResR tSfrdResR, HttpServletResponse response){
		ServiceResp resp = tSfrdResRService.remove(tSfrdResR);
		return renderString(response, resp);
	}
	
}
