package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdPro;
import com.jsite.busi.szy.formal.service.TSfrdProService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.IdGen;
import com.jsite.core.web.BaseController;
import com.jsite.dao.sys.po.User;
import com.jsite.szy.dispatch.formal.vo.TSfmmEnBVO;
import com.jsite.szy.dispatch.formal.vo.TSfrdProVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/pro")
@Api(value="常规方案",tags="常规方案接口")
public class TSfrdProController extends BaseController{

	@Autowired
	private TSfrdProService tSfrdProService;
	
	@ResponseBody
	@RequestMapping(value = {"get", ""})
    @ApiOperation(value = "根据id获取常规方案信息", notes = "根据id获取常规调度方案信息",httpMethod = "GET")
	 public String get(@RequestParam  String proCd, HttpServletResponse response) {
		TSfrdPro tSfrdPro = new  TSfrdPro();
		if (StringUtils.isNotBlank(proCd)) {
			tSfrdPro = tSfrdProService.get(proCd);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdPro);
   }
	
//	@ResponseBody
//	@RequestMapping(value = {"get", ""})
//    @ApiOperation(value = "根据id获取常规方案信息", notes = "根据id获取常规调度方案信息",httpMethod = "POST")
//	 public String get(@RequestBody TSfrdProVO tSfrdProVO, HttpServletResponse response) {
//		TSfrdPro tSfrdPro = new  TSfrdPro();
//		if (StringUtils.isNotBlank(tSfrdProVO.getProCd())) {
//			tSfrdPro = tSfrdProService.get(tSfrdProVO.getProCd());
//		}
//         //return ResponseEntity.ok(user);
//	    return renderString(response, tSfrdPro);
//   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询常规调度方案", notes = "查询常规调度方案", httpMethod = "POST")
	public String list(@RequestBody TSfrdProVO tSfrdProVO, HttpServletResponse response) {
		TSfrdPro tSfrdPro = new  TSfrdPro();
		if (null != tSfrdProVO) {
			tSfrdPro = BeanMapper.map(tSfrdProVO, tSfrdPro.getClass());
		}
	    Page<TSfrdPro> page = tSfrdProService.getPage(new Page<TSfrdPro>(tSfrdProVO.getPageNo(),tSfrdProVO.getPageSize()), tSfrdPro);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存常规调度方案", notes = "保存常规调度方案", httpMethod = "POST")
	public String save(@RequestBody TSfrdProVO tSfrdProVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdPro tSfrdPro = new  TSfrdPro();
		if (null != tSfrdProVO) {
			tSfrdPro = BeanMapper.map(tSfrdProVO, tSfrdPro.getClass());
		}
	    if(StringUtils.isNotBlank(tSfrdProVO.getProCd())){
	    	resp = tSfrdProService.update(tSfrdPro);
	    }else{
	    	tSfrdPro.setRegionCd("000000F090500001");
	    	tSfrdPro.setSbjCd("300000003");
	    	tSfrdPro.setReqCd(IdGen.randomBase62(32));
	    	String proCd = tSfrdProService.getOrderNum(tSfrdPro);
	    	tSfrdPro.setProCd(proCd);
	    	if(tSfrdProService.findByNm(tSfrdPro).size() > 0 ){
	    		resp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
	    		resp.setMsg("方案名称已存在，请修改");
	    	}else{
	    		resp = tSfrdProService.save(tSfrdPro);
	    	}
	    }
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除常规调度方案", notes = "删除常规调度方案", httpMethod = "POST")
	public String remove(@RequestBody TSfrdPro tSfrdPro, HttpServletResponse response){
		ServiceResp resp = tSfrdProService.remove(tSfrdPro);
		return renderString(response, resp);
	}
	
}
