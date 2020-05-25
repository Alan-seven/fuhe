package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdRsvrInit;
import com.jsite.busi.szy.formal.service.TSfrdRsvrInitService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdRsvrInitVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/rsvrinit")
@Api(value="水库数据初始化信息",tags="水库数据初始化信息接口")
public class TSfrdRsvrInitController extends BaseController{
	
	@Autowired
	private TSfrdRsvrInitService tSfrdRsvrInitService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取水库数据初始化信息", notes = "根据id获取水库数据初始化信息",httpMethod = "POST")
	 public String get(@RequestBody TSfrdRsvrInitVO tSfrdRsvrInitVO, HttpServletResponse response) {
		TSfrdRsvrInit tSfrdRsvrInit = new  TSfrdRsvrInit();
		if (null != tSfrdRsvrInitVO) {
			tSfrdRsvrInit = BeanMapper.map(tSfrdRsvrInitVO, tSfrdRsvrInit.getClass());
			tSfrdRsvrInit = tSfrdRsvrInitService.get(tSfrdRsvrInit);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdRsvrInit);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询水库数据初始化", notes = "查询水库数据初始化", httpMethod = "POST")
	public String list(@RequestBody TSfrdRsvrInitVO tSfrdRsvrInitVO, HttpServletResponse response) {
		TSfrdRsvrInit tSfrdRsvrInit = new  TSfrdRsvrInit();
		if (null != tSfrdRsvrInitVO) {
			tSfrdRsvrInit = BeanMapper.map(tSfrdRsvrInitVO, tSfrdRsvrInit.getClass());
		}
	    Page<TSfrdRsvrInit> page = tSfrdRsvrInitService.getPage(new Page<TSfrdRsvrInit>(tSfrdRsvrInitVO.getPageNo(),tSfrdRsvrInitVO.getPageSize()), tSfrdRsvrInit);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存水库数据初始化", notes = "保存水库数据初始化", httpMethod = "POST")
	public String save(@RequestBody TSfrdRsvrInitVO tSfrdRsvrInitVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdRsvrInit tSfrdRsvrInit = new  TSfrdRsvrInit();
		if (null != tSfrdRsvrInitVO) {
			tSfrdRsvrInit = BeanMapper.map(tSfrdRsvrInitVO, tSfrdRsvrInit.getClass());
		}
	    if(null!=tSfrdRsvrInitService.get(tSfrdRsvrInit)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfrdRsvrInitService.save(tSfrdRsvrInit);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改水库数据初始化", notes = "修改水库数据初始化", httpMethod = "POST")
	public String update(@RequestBody TSfrdRsvrInit tSfrdRsvrInit, HttpServletResponse response) {
		ServiceResp resp = tSfrdRsvrInitService.update(tSfrdRsvrInit);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除水库数据初始化", notes = "删除水库数据初始化", httpMethod = "POST")
	public String remove(@RequestBody TSfrdRsvrInit tSfrdRsvrInit, HttpServletResponse response){
		ServiceResp resp = tSfrdRsvrInitService.remove(tSfrdRsvrInit);
		return renderString(response, resp);
	}

}
