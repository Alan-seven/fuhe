//package com.jsite.szy.dispatch.formal.web;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.jsite.busi.szy.formal.po.TSfrdWtrplanVerRslt;
//import com.jsite.busi.szy.formal.service.TSfrdWtrplanVerRsltService;
//import com.jsite.core.mapper.BeanMapper;
//import com.jsite.core.page.Page;
//import com.jsite.core.service.RespCode;
//import com.jsite.core.service.ServiceResp;
//import com.jsite.core.web.BaseController;
//import com.jsite.szy.dispatch.formal.vo.TSfrdWtrplanVerRsltVO;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
//@Controller
//@RequestMapping(value = "${adminPath}/formal/verrslt")
//@Api(value="用水计划核定结果",tags="用水计划核定结果接口")
//public class TSfrdWtrplanVerRsltController extends BaseController{
//
//	@Autowired
//	private TSfrdWtrplanVerRsltService tSfrdWtrplanVerRsltService;
//	
//	@RequestMapping(value = "/get")
//    @ApiOperation(value = "根据id获取用水计划核定结果", notes = "根据id获取用水计划核定结果",httpMethod = "POST")
//	 public String get(@RequestBody TSfrdWtrplanVerRsltVO tSfrdWtrplanVerRsltVO, HttpServletResponse response) {
//		TSfrdWtrplanVerRslt tSfrdWtrplanVerRslt = new  TSfrdWtrplanVerRslt();
//		if (null != tSfrdWtrplanVerRsltVO) {
//			tSfrdWtrplanVerRslt = BeanMapper.map(tSfrdWtrplanVerRsltVO, tSfrdWtrplanVerRslt.getClass());
//			tSfrdWtrplanVerRslt = tSfrdWtrplanVerRsltService.get(tSfrdWtrplanVerRslt);
//		}
//         //return ResponseEntity.ok(user);
//	    return renderString(response, tSfrdWtrplanVerRslt);
//   }
//	
//	@RequestMapping(value = "/list")
//    @ApiOperation(value = "查询用水计划核定结果", notes = "查询用水计划核定结果", httpMethod = "POST")
//	public String list(@RequestBody TSfrdWtrplanVerRsltVO tSfrdWtrplanVerRsltVO, HttpServletResponse response) {
//		TSfrdWtrplanVerRslt tSfrdWtrplanVerRslt = new  TSfrdWtrplanVerRslt();
//		if (null != tSfrdWtrplanVerRsltVO) {
//			tSfrdWtrplanVerRslt = BeanMapper.map(tSfrdWtrplanVerRsltVO, tSfrdWtrplanVerRslt.getClass());
//		}
//	    Page<TSfrdWtrplanVerRslt> page = tSfrdWtrplanVerRsltService.getPage(new Page<TSfrdWtrplanVerRslt>(tSfrdWtrplanVerRsltVO.getPageNo(),tSfrdWtrplanVerRsltVO.getPageSize()), tSfrdWtrplanVerRslt);
//	    return renderString(response, page);
//    }
//	
//	@RequestMapping(value = "/save")
//    @ApiOperation(value = "保存用水计划核定结果", notes = "保存用水计划核定结果", httpMethod = "POST")
//	public String save(@RequestBody TSfrdWtrplanVerRsltVO tSfrdWtrplanVerRsltVO, HttpServletResponse response) {
//		ServiceResp resp = new ServiceResp();
//		TSfrdWtrplanVerRslt tSfrdWtrplanVerRslt = new  TSfrdWtrplanVerRslt();
//		if (null != tSfrdWtrplanVerRsltVO) {
//			tSfrdWtrplanVerRslt = BeanMapper.map(tSfrdWtrplanVerRsltVO, tSfrdWtrplanVerRslt.getClass());
//		}
//	    if(null!=tSfrdWtrplanVerRsltService.get(tSfrdWtrplanVerRslt)){
//	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
//	    	resp.setMsg("该条记录已存在");
//	    }else{
//	    	resp = tSfrdWtrplanVerRsltService.save(tSfrdWtrplanVerRslt);
//	    }
//	    return renderString(response, resp);
//    }
//	
//	@RequestMapping(value = "/update")
//    @ApiOperation(value = "修改用水计划核定结果", notes = "修改用水计划核定结果", httpMethod = "POST")
//	public String update(@RequestBody TSfrdWtrplanVerRslt tSfrdWtrplanVerRslt, HttpServletResponse response) {
//		ServiceResp resp = tSfrdWtrplanVerRsltService.update(tSfrdWtrplanVerRslt);
//	    return renderString(response, resp);
//    }
//	
//	@ResponseBody
//	@RequestMapping(value = "remove")
//    // 方法上加ApiOpreation注解
//    @ApiOperation(value = "删除用水计划核定结果", notes = "删除用水计划核定结果", httpMethod = "POST")
//	public String remove(@RequestBody TSfrdWtrplanVerRslt tSfrdWtrplanVerRslt, HttpServletResponse response){
//		ServiceResp resp = tSfrdWtrplanVerRsltService.remove(tSfrdWtrplanVerRslt);
//		return renderString(response, resp);
//	}
//}
