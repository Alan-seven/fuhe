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
//import com.jsite.busi.szy.formal.po.TSfrdWusR;
//import com.jsite.busi.szy.formal.service.TSfrdWusRService;
//import com.jsite.core.mapper.BeanMapper;
//import com.jsite.core.page.Page;
//import com.jsite.core.service.RespCode;
//import com.jsite.core.service.ServiceResp;
//import com.jsite.core.web.BaseController;
//import com.jsite.szy.dispatch.formal.vo.TSfrdWusRVO;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
//@Controller
//@RequestMapping(value = "${adminPath}/formal/wusr")
//@Api(value="调度区域实际用水结果信息",tags="调度区域实际用水结果信息接口")
//public class TSfrdWusRController extends BaseController{
//
//	@Autowired
//	private TSfrdWusRService tSfrdWusRService;
//	
//	@RequestMapping(value = "/get")
//    @ApiOperation(value = "根据id获取调度区域实际用水结果信息", notes = "根据id获取调度区域实际用水结果信息",httpMethod = "POST")
//	 public String get(@RequestBody TSfrdWusRVO tSfrdWusRVO, HttpServletResponse response) {
//		TSfrdWusR tSfrdWusR = new  TSfrdWusR();
//		if (null != tSfrdWusRVO) {
//			tSfrdWusR = BeanMapper.map(tSfrdWusRVO, tSfrdWusR.getClass());
//			tSfrdWusR = tSfrdWusRService.get(tSfrdWusR);
//		}
//         //return ResponseEntity.ok(user);
//	    return renderString(response, tSfrdWusR);
//   }
//	
//	@RequestMapping(value = "/list")
//    @ApiOperation(value = "查询调度区域实际用水结果", notes = "查询调度区域实际用水结果", httpMethod = "POST")
//	public String list(@RequestBody TSfrdWusRVO tSfrdWusRVO, HttpServletResponse response) {
//		TSfrdWusR tSfrdWusR = new  TSfrdWusR();
//		if (null != tSfrdWusRVO) {
//			tSfrdWusR = BeanMapper.map(tSfrdWusRVO, tSfrdWusR.getClass());
//		}
//	    Page<TSfrdWusR> page = tSfrdWusRService.getPage(new Page<TSfrdWusR>(tSfrdWusRVO.getPageNo(),tSfrdWusRVO.getPageSize()), tSfrdWusR);
//	    return renderString(response, page);
//    }
//	
//	@RequestMapping(value = "/save")
//    @ApiOperation(value = "保存调度区域实际用水结果", notes = "保存调度区域实际用水结果", httpMethod = "POST")
//	public String save(@RequestBody TSfrdWusRVO tSfrdWusRVO, HttpServletResponse response) {
//		ServiceResp resp = new ServiceResp();
//		TSfrdWusR tSfrdWusR = new  TSfrdWusR();
//		if (null != tSfrdWusRVO) {
//			tSfrdWusR = BeanMapper.map(tSfrdWusRVO, tSfrdWusR.getClass());
//		}
//	    if(null!=tSfrdWusRService.get(tSfrdWusR)){
//	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
//	    	resp.setMsg("该条记录已存在");
//	    }else{
//	    	resp = tSfrdWusRService.save(tSfrdWusR);
//	    }
//	    return renderString(response, resp);
//    }
//	
//	@RequestMapping(value = "/update")
//    @ApiOperation(value = "修改调度区域实际用水结果", notes = "修改调度区域实际用水结果", httpMethod = "POST")
//	public String update(@RequestBody TSfrdWusR tSfrdWusR, HttpServletResponse response) {
//		ServiceResp resp = tSfrdWusRService.update(tSfrdWusR);
//	    return renderString(response, resp);
//    }
//	
//	@ResponseBody
//	@RequestMapping(value = "remove")
//    // 方法上加ApiOpreation注解
//    @ApiOperation(value = "删除调度区域实际用水结果", notes = "删除调度区域实际用水结果", httpMethod = "POST")
//	public String remove(@RequestBody TSfrdWusR tSfrdWusR, HttpServletResponse response){
//		ServiceResp resp = tSfrdWusRService.remove(tSfrdWusR);
//		return renderString(response, resp);
//	}
//	
//}
