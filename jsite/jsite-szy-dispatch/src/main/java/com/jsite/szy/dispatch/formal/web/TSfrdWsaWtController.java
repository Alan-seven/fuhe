package com.jsite.szy.dispatch.formal.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsite.busi.szy.formal.po.TSfmmEnB;
import com.jsite.busi.szy.formal.po.TSfrdWsaWt;
import com.jsite.busi.szy.formal.service.TSfrdWsaWtService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfmmEnBVO;
import com.jsite.szy.dispatch.formal.vo.TSfrdWsaWtVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/wsawt")
@Api(value="需水预测用水权重指标",tags="需水预测用水权重指标接口")
public class TSfrdWsaWtController extends BaseController{
	
	@Autowired
	private TSfrdWsaWtService tSfrdWsaWtService;
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询实体基本", notes = "查询实体基本", httpMethod = "POST")
	public String list(@RequestBody TSfrdWsaWtVO tSfrdWsaWtVO, HttpServletResponse response) {
		TSfrdWsaWt tSfrdWsaWt = new  TSfrdWsaWt();
		if (null != tSfrdWsaWtVO) {
			tSfrdWsaWt = BeanMapper.map(tSfrdWsaWtVO, tSfrdWsaWt.getClass());
		}
	    List<TSfrdWsaWt> list = tSfrdWsaWtService.list(tSfrdWsaWt);
	    return renderString(response, list);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存实体基本", notes = "保存实体基本", httpMethod = "POST")
	public String save(@RequestBody TSfrdWsaWtVO tSfrdWsaWtVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdWsaWt tSfrdWsaWt = new  TSfrdWsaWt();
		if (null != tSfrdWsaWtVO) {
			tSfrdWsaWt = BeanMapper.map(tSfrdWsaWtVO, tSfrdWsaWt.getClass());
		}
	    if(null!=tSfrdWsaWtService.get(tSfrdWsaWt)){
	    	resp = tSfrdWsaWtService.update(tSfrdWsaWt);
	    }else{
	    	resp = tSfrdWsaWtService.save(tSfrdWsaWt);
	    }
	    return renderString(response, resp);
    }

}
