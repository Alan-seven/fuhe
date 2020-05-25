package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfmmFreqRslt;
import com.jsite.busi.szy.formal.service.TSfmmFreqRsltService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.dao.sys.po.User;
import com.jsite.szy.dispatch.formal.vo.TSfmmFreqRsltVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/freqrslt")
@Api(value="水文测站频率来水成果信息",tags="水文测站频率来水成果表信息接口")
public class TSfmmFreqRsltController extends BaseController{

	@Autowired
	private TSfmmFreqRsltService tSfmmFreqRsltService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取水文测站频率来水成果信息", notes = "根据id获取水文测站频率来水成果信息",httpMethod = "POST")
	 public String get(@RequestBody TSfmmFreqRsltVO tSfmmFreqRsltVO, HttpServletResponse response) {
		TSfmmFreqRslt tSfmmFreqRslt = new  TSfmmFreqRslt();
		if (null != tSfmmFreqRsltVO) {
			tSfmmFreqRslt = BeanMapper.map(tSfmmFreqRsltVO, tSfmmFreqRslt.getClass());
			tSfmmFreqRslt = tSfmmFreqRsltService.get(tSfmmFreqRslt);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfmmFreqRslt);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询水文测站频率来水成果", notes = "查询水文测站频率来水成果", httpMethod = "POST")
	public String list(@RequestBody TSfmmFreqRsltVO tSfmmFreqRsltVO, HttpServletResponse response) {
		TSfmmFreqRslt tSfmmFreqRslt = new  TSfmmFreqRslt();
		if (null != tSfmmFreqRsltVO) {
			tSfmmFreqRslt = BeanMapper.map(tSfmmFreqRsltVO, tSfmmFreqRslt.getClass());
		}
	    Page<TSfmmFreqRslt> page = tSfmmFreqRsltService.getPage(new Page<TSfmmFreqRslt>(tSfmmFreqRsltVO.getPageNo(),tSfmmFreqRsltVO.getPageSize()), tSfmmFreqRslt);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存水文测站频率来水成果", notes = "保存水文测站频率来水成果", httpMethod = "POST")
	public String save(@RequestBody TSfmmFreqRsltVO tSfmmFreqRsltVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfmmFreqRslt tSfmmFreqRslt = new  TSfmmFreqRslt();
		if (null != tSfmmFreqRsltVO) {
			tSfmmFreqRslt = BeanMapper.map(tSfmmFreqRsltVO, tSfmmFreqRslt.getClass());
		}
	    if(null!=tSfmmFreqRsltService.get(tSfmmFreqRslt)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfmmFreqRsltService.save(tSfmmFreqRslt);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改水文测站频率来水成果", notes = "修改水文测站频率来水成果", httpMethod = "POST", response = User.class)
	public String update(@RequestBody TSfmmFreqRslt tSfmmFreqRslt, HttpServletResponse response) {
		ServiceResp resp = tSfmmFreqRsltService.update(tSfmmFreqRslt);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除水文测站频率来水成果", notes = "删除水文测站频率来水成果", httpMethod = "POST")
	public String remove(@RequestBody TSfmmFreqRslt tSfmmFreqRslt, HttpServletResponse response){
		ServiceResp resp = tSfmmFreqRsltService.remove(tSfmmFreqRslt);
		return renderString(response, resp);
	}
}
