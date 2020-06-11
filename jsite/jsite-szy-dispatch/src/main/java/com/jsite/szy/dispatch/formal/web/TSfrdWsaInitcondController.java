package com.jsite.szy.dispatch.formal.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdWsaInitcond;
import com.jsite.busi.szy.formal.service.TSfrdWsaInitcondService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdWsaInitcondVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/wsainit")
@Api(value="需水预测逐月分水系数",tags="需水预测逐月分水系数接口")
public class TSfrdWsaInitcondController extends BaseController{

	@Autowired
	private TSfrdWsaInitcondService tSfrdWsaInitcondService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取需水预测逐月分水系数", notes = "根据id获取需水预测逐月分水系数",httpMethod = "POST")
	 public String get(@RequestBody TSfrdWsaInitcondVO tSfrdWsaInitcondVO, HttpServletResponse response) {
		TSfrdWsaInitcond tSfrdWsaInitcond = new  TSfrdWsaInitcond();
		if (null != tSfrdWsaInitcondVO) {
			tSfrdWsaInitcond = BeanMapper.map(tSfrdWsaInitcondVO, tSfrdWsaInitcond.getClass());
			tSfrdWsaInitcond = tSfrdWsaInitcondService.get(tSfrdWsaInitcond);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdWsaInitcond);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询需水预测逐月分水系数", notes = "查询需水预测逐月分水系数", httpMethod = "POST")
	public String list(@RequestBody TSfrdWsaInitcondVO tSfrdWsaInitcondVO, HttpServletResponse response) {
		TSfrdWsaInitcond tSfrdWsaInitcond = new  TSfrdWsaInitcond();
		if (null != tSfrdWsaInitcondVO) {
			tSfrdWsaInitcond = BeanMapper.map(tSfrdWsaInitcondVO, tSfrdWsaInitcond.getClass());
		}
	    List<TSfrdWsaInitcond> list = tSfrdWsaInitcondService.list(tSfrdWsaInitcond);
	    return renderString(response, list);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存需水预测逐月分水系数", notes = "保存需水预测逐月分水系数", httpMethod = "POST")
	public String save(@RequestBody TSfrdWsaInitcondVO tSfrdWsaInitcondVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdWsaInitcond tSfrdWsaInitcond = new  TSfrdWsaInitcond();
		if (null != tSfrdWsaInitcondVO) {
			tSfrdWsaInitcond = BeanMapper.map(tSfrdWsaInitcondVO, tSfrdWsaInitcond.getClass());
		}
	    if(null!=tSfrdWsaInitcondService.get(tSfrdWsaInitcond)){
	    	resp = tSfrdWsaInitcondService.update(tSfrdWsaInitcond);
	    }else{
	    	resp = tSfrdWsaInitcondService.save(tSfrdWsaInitcond);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改需水预测逐月分水系数", notes = "修改需水预测逐月分水系数", httpMethod = "POST")
	public String update(@RequestBody TSfrdWsaInitcond tSfrdWsaInitcond, HttpServletResponse response) {
		ServiceResp resp = tSfrdWsaInitcondService.update(tSfrdWsaInitcond);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除需水预测逐月分水系数", notes = "删除需水预测逐月分水系数", httpMethod = "POST")
	public String remove(@RequestBody TSfrdWsaInitcond tSfrdWsaInitcond, HttpServletResponse response){
		ServiceResp resp = tSfrdWsaInitcondService.remove(tSfrdWsaInitcond);
		return renderString(response, resp);
	}
	
}
