package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdWtrplanInitcond;
import com.jsite.busi.szy.formal.service.TSfrdWtrplanInitcondService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdWtrplanInitcondVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/planinit")
@Api(value="需水预测申报水量",tags="需水预测申报水量接口")
public class TSfrdWtrplanInitcondController extends BaseController{

	@Autowired
	private TSfrdWtrplanInitcondService tSfrdWtrplanInitcondService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取需水预测申报水量", notes = "根据id获取需水预测申报水量",httpMethod = "POST")
	 public String get(@RequestBody TSfrdWtrplanInitcondVO tSfrdWtrplanInitcondVO, HttpServletResponse response) {
		TSfrdWtrplanInitcond tSfrdWtrplanInitcond = new  TSfrdWtrplanInitcond();
		if (null != tSfrdWtrplanInitcondVO) {
			tSfrdWtrplanInitcond = BeanMapper.map(tSfrdWtrplanInitcondVO, tSfrdWtrplanInitcond.getClass());
			tSfrdWtrplanInitcond = tSfrdWtrplanInitcondService.get(tSfrdWtrplanInitcond);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdWtrplanInitcond);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询需水预测申报水量", notes = "查询需水预测申报水量", httpMethod = "POST")
	public String list(@RequestBody TSfrdWtrplanInitcondVO tSfrdWtrplanInitcondVO, HttpServletResponse response) {
		TSfrdWtrplanInitcond tSfrdWtrplanInitcond = new  TSfrdWtrplanInitcond();
		if (null != tSfrdWtrplanInitcondVO) {
			tSfrdWtrplanInitcond = BeanMapper.map(tSfrdWtrplanInitcondVO, tSfrdWtrplanInitcond.getClass());
		}
	    Page<TSfrdWtrplanInitcond> page = tSfrdWtrplanInitcondService.getPage(new Page<TSfrdWtrplanInitcond>(tSfrdWtrplanInitcondVO.getPageNo(),tSfrdWtrplanInitcondVO.getPageSize()), tSfrdWtrplanInitcond);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存需水预测申报水量", notes = "保存需水预测申报水量", httpMethod = "POST")
	public String save(@RequestBody TSfrdWtrplanInitcondVO tSfrdWtrplanInitcondVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdWtrplanInitcond tSfrdWtrplanInitcond = new  TSfrdWtrplanInitcond();
		if (null != tSfrdWtrplanInitcondVO) {
			tSfrdWtrplanInitcond = BeanMapper.map(tSfrdWtrplanInitcondVO, tSfrdWtrplanInitcond.getClass());
		}
	    if(null!=tSfrdWtrplanInitcondService.get(tSfrdWtrplanInitcond)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfrdWtrplanInitcondService.save(tSfrdWtrplanInitcond);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改需水预测申报水量", notes = "修改需水预测申报水量", httpMethod = "POST")
	public String update(@RequestBody TSfrdWtrplanInitcond tSfrdWtrplanInitcond, HttpServletResponse response) {
		ServiceResp resp = tSfrdWtrplanInitcondService.update(tSfrdWtrplanInitcond);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除需水预测申报水量", notes = "删除需水预测申报水量", httpMethod = "POST")
	public String remove(@RequestBody TSfrdWtrplanInitcond tSfrdWtrplanInitcond, HttpServletResponse response){
		ServiceResp resp = tSfrdWtrplanInitcondService.remove(tSfrdWtrplanInitcond);
		return renderString(response, resp);
	}
	
}
