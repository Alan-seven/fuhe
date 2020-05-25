package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdDisSectRslt;
import com.jsite.busi.szy.formal.service.TSfrdDisSectRsltService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdDisSectRsltVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/sectrslt")
@Api(value="水量调节计算河道断面结果信息",tags="水量调节计算河道断面结果信息接口")
public class TSfrdDisSectRsltController extends BaseController{

	@Autowired
	private TSfrdDisSectRsltService tSfrdDisSectRsltService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取水量调节计算河道断面结果信息", notes = "根据id获取水量调节计算河道断面结果信息",httpMethod = "POST")
	 public String get(@RequestBody TSfrdDisSectRsltVO tSfrdDisSectRsltVO, HttpServletResponse response) {
		TSfrdDisSectRslt tSfrdDisSectRslt = new  TSfrdDisSectRslt();
		if (null != tSfrdDisSectRsltVO) {
			tSfrdDisSectRslt = BeanMapper.map(tSfrdDisSectRsltVO, tSfrdDisSectRslt.getClass());
			tSfrdDisSectRslt = tSfrdDisSectRsltService.get(tSfrdDisSectRslt);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdDisSectRslt);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询水量调节计算河道断面结果", notes = "查询水量调节计算河道断面结果", httpMethod = "POST")
	public String list(@RequestBody TSfrdDisSectRsltVO tSfrdDisSectRsltVO, HttpServletResponse response) {
		TSfrdDisSectRslt tSfrdDisSectRslt = new  TSfrdDisSectRslt();
		if (null != tSfrdDisSectRsltVO) {
			tSfrdDisSectRslt = BeanMapper.map(tSfrdDisSectRsltVO, tSfrdDisSectRslt.getClass());
		}
	    Page<TSfrdDisSectRslt> page = tSfrdDisSectRsltService.getPage(new Page<TSfrdDisSectRslt>(tSfrdDisSectRsltVO.getPageNo(),tSfrdDisSectRsltVO.getPageSize()), tSfrdDisSectRslt);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存水量调节计算河道断面结果", notes = "保存水量调节计算河道断面结果", httpMethod = "POST")
	public String save(@RequestBody TSfrdDisSectRsltVO tSfrdDisSectRsltVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdDisSectRslt tSfrdDisSectRslt = new  TSfrdDisSectRslt();
		if (null != tSfrdDisSectRsltVO) {
			tSfrdDisSectRslt = BeanMapper.map(tSfrdDisSectRsltVO, tSfrdDisSectRslt.getClass());
		}
	    if(null!=tSfrdDisSectRsltService.get(tSfrdDisSectRslt)){
	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    	resp.setMsg("该条记录已存在");
	    }else{
	    	resp = tSfrdDisSectRsltService.save(tSfrdDisSectRslt);
	    }
	    return renderString(response, resp);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改水量调节计算河道断面结果", notes = "修改水量调节计算河道断面结果", httpMethod = "POST")
	public String update(@RequestBody TSfrdDisSectRslt tSfrdDisSectRslt, HttpServletResponse response) {
		ServiceResp resp = tSfrdDisSectRsltService.update(tSfrdDisSectRslt);
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除水量调节计算河道断面结果", notes = "删除水量调节计算河道断面结果", httpMethod = "POST")
	public String remove(@RequestBody TSfrdDisSectRslt tSfrdDisSectRslt, HttpServletResponse response){
		ServiceResp resp = tSfrdDisSectRsltService.remove(tSfrdDisSectRslt);
		return renderString(response, resp);
	}
}
