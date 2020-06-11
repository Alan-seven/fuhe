package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsite.busi.szy.formal.po.TSfmmWsaWt;
import com.jsite.busi.szy.formal.service.TSfmmWsaWtService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfmmWsaWtVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/sfmmwt")
@Api(value="需水预测基准参数",tags="需水预测基准参数接口")
public class TSfmmWsaWtController extends BaseController{

	@Autowired
	private TSfmmWsaWtService tSfmmWsaWtService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取需水预测基准参数", notes = "根据id获取需水预测基准参数",httpMethod = "POST")
	 public String get(@RequestBody TSfmmWsaWtVO tSfmmWsaWtVO, HttpServletResponse response) {
		TSfmmWsaWt tSfmmWsaWt = new  TSfmmWsaWt();
		if (null != tSfmmWsaWtVO) {
			tSfmmWsaWt = BeanMapper.map(tSfmmWsaWtVO, tSfmmWsaWt.getClass());
			tSfmmWsaWt = tSfmmWsaWtService.get(tSfmmWsaWt);
		}
	    return renderString(response, tSfmmWsaWt);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询需水预测基准参数", notes = "查询需水预测基准参数", httpMethod = "POST")
	public String list(@RequestBody TSfmmWsaWtVO tSfmmWsaWtVO, HttpServletResponse response) {
		TSfmmWsaWt tSfmmWsaWt = new  TSfmmWsaWt();
		if (null != tSfmmWsaWtVO) {
			tSfmmWsaWt = BeanMapper.map(tSfmmWsaWtVO, tSfmmWsaWt.getClass());
		}
	    Page<TSfmmWsaWt> page = tSfmmWsaWtService.getPage(new Page<TSfmmWsaWt>(tSfmmWsaWtVO.getPageNo(),tSfmmWsaWtVO.getPageSize()), tSfmmWsaWt);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存需水预测基准参数", notes = "保存需水预测基准参数", httpMethod = "POST")
	public String save(@RequestBody TSfmmWsaWtVO tSfmmWsaWtVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfmmWsaWt tSfmmWsaWt = new  TSfmmWsaWt();
		if (null != tSfmmWsaWtVO) {
			tSfmmWsaWt = BeanMapper.map(tSfmmWsaWtVO, tSfmmWsaWt.getClass());
		}
	    if(null!=tSfmmWsaWtService.get(tSfmmWsaWt)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfmmWsaWtService.save(tSfmmWsaWt);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改需水预测基准参数", notes = "修改需水预测基准参数", httpMethod = "POST")
	public String update(@RequestBody TSfmmWsaWt tSfmmWsaWt, HttpServletResponse response) {
		ServiceResp resp = tSfmmWsaWtService.update(tSfmmWsaWt);
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "remove")
    @ApiOperation(value = "删除需水预测基准参数", notes = "删除需水预测基准参数", httpMethod = "POST")
	public String remove(@RequestBody TSfmmWsaWt tSfmmWsaWt, HttpServletResponse response){
		ServiceResp resp = tSfmmWsaWtService.remove(tSfmmWsaWt);
		return renderString(response, resp);
	}
	
}
