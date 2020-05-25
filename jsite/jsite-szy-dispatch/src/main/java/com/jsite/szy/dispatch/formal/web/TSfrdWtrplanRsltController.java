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
//import com.jsite.busi.szy.formal.po.TSfrdWtrplanRslt;
//import com.jsite.busi.szy.formal.service.TSfrdWtrplanRsltService;
//import com.jsite.core.mapper.BeanMapper;
//import com.jsite.core.page.Page;
//import com.jsite.core.service.RespCode;
//import com.jsite.core.service.ServiceResp;
//import com.jsite.core.web.BaseController;
//import com.jsite.szy.dispatch.formal.vo.TSfrdWtrplanRsltVO;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
//@Controller
//@RequestMapping(value = "${adminPath}/formal/planrslt")
//@Api(value="用水计划结果信息",tags="用水计划结果信息接口")
//public class TSfrdWtrplanRsltController extends BaseController{
//
//	@Autowired
//	private TSfrdWtrplanRsltService tSfrdWtrplanRsltService;
//	
//	@RequestMapping(value = "/get")
//    @ApiOperation(value = "根据id获取用水计划结果信息", notes = "根据id获取用水计划结果信息",httpMethod = "POST")
//	 public String get(@RequestBody TSfrdWtrplanRsltVO tSfrdWtrplanRsltVO, HttpServletResponse response) {
//		TSfrdWtrplanRslt tSfrdWtrplanRslt = new  TSfrdWtrplanRslt();
//		if (null != tSfrdWtrplanRsltVO) {
//			tSfrdWtrplanRslt = BeanMapper.map(tSfrdWtrplanRsltVO, tSfrdWtrplanRslt.getClass());
//			tSfrdWtrplanRslt = tSfrdWtrplanRsltService.get(tSfrdWtrplanRslt);
//		}
//         //return ResponseEntity.ok(user);
//	    return renderString(response, tSfrdWtrplanRslt);
//   }
//	
//	@RequestMapping(value = "/list")
//    @ApiOperation(value = "查询用水计划结果", notes = "查询用水计划结果", httpMethod = "POST")
//	public String list(@RequestBody TSfrdWtrplanRsltVO tSfrdWtrplanRsltVO, HttpServletResponse response) {
//		TSfrdWtrplanRslt tSfrdWtrplanRslt = new  TSfrdWtrplanRslt();
//		if (null != tSfrdWtrplanRsltVO) {
//			tSfrdWtrplanRslt = BeanMapper.map(tSfrdWtrplanRsltVO, tSfrdWtrplanRslt.getClass());
//		}
//	    Page<TSfrdWtrplanRslt> page = tSfrdWtrplanRsltService.getPage(new Page<TSfrdWtrplanRslt>(tSfrdWtrplanRsltVO.getPageNo(),tSfrdWtrplanRsltVO.getPageSize()), tSfrdWtrplanRslt);
//	    return renderString(response, page);
//    }
//	
//	@RequestMapping(value = "/save")
//    @ApiOperation(value = "保存用水计划结果", notes = "保存用水计划结果", httpMethod = "POST")
//	public String save(@RequestBody TSfrdWtrplanRsltVO tSfrdWtrplanRsltVO, HttpServletResponse response) {
//		ServiceResp resp = new ServiceResp();
//		TSfrdWtrplanRslt tSfrdWtrplanRslt = new  TSfrdWtrplanRslt();
//		if (null != tSfrdWtrplanRsltVO) {
//			tSfrdWtrplanRslt = BeanMapper.map(tSfrdWtrplanRsltVO, tSfrdWtrplanRslt.getClass());
//		}
//	    if(null!=tSfrdWtrplanRsltService.get(tSfrdWtrplanRslt)){
//	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
//	    	resp.setMsg("该条记录已存在");
//	    }else{
//	    	resp = tSfrdWtrplanRsltService.save(tSfrdWtrplanRslt);
//	    }
//	    return renderString(response, resp);
//    }
//	
//	@RequestMapping(value = "/update")
//    @ApiOperation(value = "修改用水计划结果", notes = "修改用水计划结果", httpMethod = "POST")
//	public String update(@RequestBody TSfrdWtrplanRslt tSfrdWtrplanRslt, HttpServletResponse response) {
//		ServiceResp resp = tSfrdWtrplanRsltService.update(tSfrdWtrplanRslt);
//	    return renderString(response, resp);
//    }
//	
//	@ResponseBody
//	@RequestMapping(value = "remove")
//    // 方法上加ApiOpreation注解
//    @ApiOperation(value = "删除用水计划结果", notes = "删除用水计划结果", httpMethod = "POST")
//	public String remove(@RequestBody TSfrdWtrplanRslt tSfrdWtrplanRslt, HttpServletResponse response){
//		ServiceResp resp = tSfrdWtrplanRsltService.remove(tSfrdWtrplanRslt);
//		return renderString(response, resp);
//	}
//	
//}
