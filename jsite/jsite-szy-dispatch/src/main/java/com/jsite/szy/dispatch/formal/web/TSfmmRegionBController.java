package com.jsite.szy.dispatch.formal.web;


import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfmmRegionB;
import com.jsite.busi.szy.formal.service.TSfmmRegionBService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.dao.sys.po.User;
import com.jsite.szy.dispatch.formal.vo.TSfmmRegionBVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/sfmmregion")
@Api(value="调度区域",tags="调度区域接口")
public class TSfmmRegionBController extends BaseController{

	@Autowired
	private TSfmmRegionBService tSfmmRegionBService;
	
	@RequestMapping(value = "/{id}")
    @ApiOperation(value = "根据id获取产品信息", notes = "根据id获取产品信息",httpMethod = "POST")
	 public String get(@PathVariable String id, HttpServletResponse response) {
	    TSfmmRegionB entity = tSfmmRegionBService.get(id);
         //return ResponseEntity.ok(user);
	    return renderString(response, entity);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询调度区域信息", notes = "查询调度区域信息", httpMethod = "POST")
	public String list(@RequestBody TSfmmRegionBVO tSfmmRegionBVO, HttpServletResponse response) {
		TSfmmRegionB tSfmmRegionB = new  TSfmmRegionB();
		if (null != tSfmmRegionBVO) {
			tSfmmRegionB = BeanMapper.map(tSfmmRegionBVO, tSfmmRegionB.getClass());
		}
	    Page<TSfmmRegionB> page = tSfmmRegionBService.getPage(new Page<TSfmmRegionB>(tSfmmRegionBVO.getPageNo(),tSfmmRegionBVO.getPageSize()), tSfmmRegionB);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存调度区域信息", notes = "保存调度区域信息", httpMethod = "POST")
	public String save(@RequestBody TSfmmRegionB tSfmmRegionB, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
	    if(null!=tSfmmRegionBService.get(tSfmmRegionB.getRegionCd())){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该调度区域代码已存在");
	    }else{
	    	resp = tSfmmRegionBService.save(tSfmmRegionB);
	    }
	    return renderString(response, resp);
    }
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改调度区域信息", notes = "修改调度区域信息", httpMethod = "POST")
	public String update(@RequestBody TSfmmRegionB tSfmmRegionB, HttpServletResponse response) {
		ServiceResp resp = tSfmmRegionBService.update(tSfmmRegionB);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除调度信息", notes = "删除调度信息", httpMethod = "POST")
	public String remove(@RequestBody TSfmmRegionB tSfmmRegionB, HttpServletResponse response){
		ServiceResp resp = tSfmmRegionBService.remove(tSfmmRegionB);
		return renderString(response, resp);
	}
	
}
