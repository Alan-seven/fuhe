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
//import com.jsite.busi.szy.formal.po.TSfrdWtrplanVerInitcond;
//import com.jsite.busi.szy.formal.service.TSfrdWtrplanVerInitcondService;
//import com.jsite.core.mapper.BeanMapper;
//import com.jsite.core.page.Page;
//import com.jsite.core.service.RespCode;
//import com.jsite.core.service.ServiceResp;
//import com.jsite.core.web.BaseController;
//import com.jsite.szy.dispatch.formal.vo.TSfrdWtrplanVerInitcondVO;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
//@Controller
//@RequestMapping(value = "${adminPath}/formal/planver")
//@Api(value="用水计划核定初始条件信息",tags="用水计划核定初始条件信息接口")
//public class TSfrdWtrplanVerInitcondController extends BaseController{
//
//	@Autowired
//	private TSfrdWtrplanVerInitcondService tSfrdWtrplanVerInitcondService;
//	
//	@RequestMapping(value = "/get")
//    @ApiOperation(value = "根据id获取用水计划核定初始条件信息", notes = "根据id获取用水计划核定初始条件信息",httpMethod = "POST")
//	 public String get(@RequestBody TSfrdWtrplanVerInitcondVO tSfrdWtrplanVerInitcondVO, HttpServletResponse response) {
//		TSfrdWtrplanVerInitcond tSfrdWtrplanVerInitcond = new  TSfrdWtrplanVerInitcond();
//		if (null != tSfrdWtrplanVerInitcondVO) {
//			tSfrdWtrplanVerInitcond = BeanMapper.map(tSfrdWtrplanVerInitcondVO, tSfrdWtrplanVerInitcond.getClass());
//			tSfrdWtrplanVerInitcond = tSfrdWtrplanVerInitcondService.get(tSfrdWtrplanVerInitcond);
//		}
//         //return ResponseEntity.ok(user);
//	    return renderString(response, tSfrdWtrplanVerInitcond);
//   }
//	
//	@RequestMapping(value = "/list")
//    @ApiOperation(value = "查询用水计划核定初始条件", notes = "查询用水计划核定初始条件", httpMethod = "POST")
//	public String list(@RequestBody TSfrdWtrplanVerInitcondVO tSfrdWtrplanVerInitcondVO, HttpServletResponse response) {
//		TSfrdWtrplanVerInitcond tSfrdWtrplanVerInitcond = new  TSfrdWtrplanVerInitcond();
//		if (null != tSfrdWtrplanVerInitcondVO) {
//			tSfrdWtrplanVerInitcond = BeanMapper.map(tSfrdWtrplanVerInitcondVO, tSfrdWtrplanVerInitcond.getClass());
//		}
//	    Page<TSfrdWtrplanVerInitcond> page = tSfrdWtrplanVerInitcondService.getPage(new Page<TSfrdWtrplanVerInitcond>(tSfrdWtrplanVerInitcondVO.getPageNo(),tSfrdWtrplanVerInitcondVO.getPageSize()), tSfrdWtrplanVerInitcond);
//	    return renderString(response, page);
//    }
//	
//	@RequestMapping(value = "/save")
//    @ApiOperation(value = "保存用水计划核定初始条件", notes = "保存用水计划核定初始条件", httpMethod = "POST")
//	public String save(@RequestBody TSfrdWtrplanVerInitcondVO tSfrdWtrplanVerInitcondVO, HttpServletResponse response) {
//		ServiceResp resp = new ServiceResp();
//		TSfrdWtrplanVerInitcond tSfrdWtrplanVerInitcond = new  TSfrdWtrplanVerInitcond();
//		if (null != tSfrdWtrplanVerInitcondVO) {
//			tSfrdWtrplanVerInitcond = BeanMapper.map(tSfrdWtrplanVerInitcondVO, tSfrdWtrplanVerInitcond.getClass());
//		}
//	    if(null!=tSfrdWtrplanVerInitcondService.get(tSfrdWtrplanVerInitcond)){
//	    	resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
//	    	resp.setMsg("该条记录已存在");
//	    }else{
//	    	resp = tSfrdWtrplanVerInitcondService.save(tSfrdWtrplanVerInitcond);
//	    }
//	    return renderString(response, resp);
//    }
//	
//	@RequestMapping(value = "/update")
//    @ApiOperation(value = "修改用水计划核定初始条件", notes = "修改用水计划核定初始条件", httpMethod = "POST")
//	public String update(@RequestBody TSfrdWtrplanVerInitcond tSfrdWtrplanVerInitcond, HttpServletResponse response) {
//		ServiceResp resp = tSfrdWtrplanVerInitcondService.update(tSfrdWtrplanVerInitcond);
//	    return renderString(response, resp);
//    }
//	
//	@ResponseBody
//	@RequestMapping(value = "remove")
//    // 方法上加ApiOpreation注解
//    @ApiOperation(value = "删除用水计划核定初始条件", notes = "删除用水计划核定初始条件", httpMethod = "POST")
//	public String remove(@RequestBody TSfrdWtrplanVerInitcond tSfrdWtrplanVerInitcond, HttpServletResponse response){
//		ServiceResp resp = tSfrdWtrplanVerInitcondService.remove(tSfrdWtrplanVerInitcond);
//		return renderString(response, resp);
//	}
//	
//}
