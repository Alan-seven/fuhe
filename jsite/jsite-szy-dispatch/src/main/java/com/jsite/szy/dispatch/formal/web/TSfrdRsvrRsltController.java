package com.jsite.szy.dispatch.formal.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsite.busi.szy.formal.po.TSfrdRsvrRslt;
import com.jsite.busi.szy.formal.service.TSfrdRsvrRsltService;
import com.jsite.core.web.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/rsvrrslt")
@Api(value="水库计算结果信息",tags="水库计算结果信息接口")
public class TSfrdRsvrRsltController extends BaseController{

	@Autowired
	private TSfrdRsvrRsltService tSfrdRsvrRsltService;
	
	@RequestMapping(value = "/list")
	@ApiOperation(value = "查询水库计算结果", notes = "查询水库计算结果", httpMethod = "POST")
	public String list(@RequestBody TSfrdRsvrRslt tSfrdRsvrRslt, HttpServletResponse response) {
	    List<TSfrdRsvrRslt> list = tSfrdRsvrRsltService.list(tSfrdRsvrRslt);
	    return renderString(response, list);
    }
	
}
