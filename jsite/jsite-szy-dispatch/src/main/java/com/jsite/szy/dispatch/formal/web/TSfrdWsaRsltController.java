package com.jsite.szy.dispatch.formal.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdWsaRslt;
import com.jsite.busi.szy.formal.service.TSfrdWsaRsltService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdWsaRsltVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Controller
@RequestMapping(value = "${adminPath}/formal/wsarslt")
@Api(value="需水预测计算结果信息",tags="需水预测计算结果信息接口")
public class TSfrdWsaRsltController extends BaseController{

	@Autowired
	private TSfrdWsaRsltService tSfrdWsaRsltService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取需水预测计算结果信息", notes = "根据id获取需水预测计算结果信息",httpMethod = "POST")
	 public String get(@RequestBody TSfrdWsaRsltVO tSfrdWsaRsltVO, HttpServletResponse response) {
		TSfrdWsaRslt tSfrdWsaRslt = new  TSfrdWsaRslt();
		if (null != tSfrdWsaRsltVO) {
			tSfrdWsaRslt = BeanMapper.map(tSfrdWsaRsltVO, tSfrdWsaRslt.getClass());
			tSfrdWsaRslt = tSfrdWsaRsltService.get(tSfrdWsaRslt);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdWsaRslt);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询需水预测计算结果", notes = "查询需水预测计算结果", httpMethod = "POST")
	public String list(@RequestBody TSfrdWsaRsltVO tSfrdWsaRsltVO, HttpServletResponse response) {
		TSfrdWsaRslt tSfrdWsaRslt = new  TSfrdWsaRslt();
		if (null != tSfrdWsaRsltVO) {
			tSfrdWsaRslt = BeanMapper.map(tSfrdWsaRsltVO, tSfrdWsaRslt.getClass());
		}
	    List<TSfrdWsaRslt> list = tSfrdWsaRsltService.list(tSfrdWsaRslt);
	    return renderString(response, list);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存需水预测计算结果", notes = "保存需水预测计算结果", httpMethod = "POST")
	public String save(@RequestBody TSfrdWsaRsltVO tSfrdWsaRsltVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdWsaRslt tSfrdWsaRslt = new  TSfrdWsaRslt();
		if (null != tSfrdWsaRsltVO) {
			tSfrdWsaRslt = BeanMapper.map(tSfrdWsaRsltVO, tSfrdWsaRslt.getClass());
		}
	    if(null!=tSfrdWsaRsltService.get(tSfrdWsaRslt)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfrdWsaRsltService.save(tSfrdWsaRslt);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改需水预测计算结果", notes = "修改需水预测计算结果", httpMethod = "POST")
	public String update(@RequestBody TSfrdWsaRslt tSfrdWsaRslt, HttpServletResponse response) {
		ServiceResp resp = tSfrdWsaRsltService.update(tSfrdWsaRslt);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除需水预测计算结果", notes = "删除需水预测计算结果", httpMethod = "POST")
	public String remove(@RequestBody TSfrdWsaRslt tSfrdWsaRslt, HttpServletResponse response){
		ServiceResp resp = tSfrdWsaRsltService.remove(tSfrdWsaRslt);
		return renderString(response, resp);
	}
	
	
}
