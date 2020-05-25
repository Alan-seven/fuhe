package com.jsite.szy.dispatch.formal.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsite.busi.szy.formal.po.TSfrdIfInitcond;
import com.jsite.busi.szy.formal.service.TSfrdIfInitcondService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.formal.vo.TSfrdIfInitcondVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "${adminPath}/formal/ifinit")
@Api(value="来水预报初始条件",tags="来水预报初始条件接口")
public class TSfrdIfInitcondController extends BaseController{

	@Autowired
	private TSfrdIfInitcondService tSfrdIfInitcondService;
	
	@RequestMapping(value = "/get")
    @ApiOperation(value = "根据id获取来水预报初始条件", notes = "根据id获取来水预报初始条件",httpMethod = "POST")
	 public String get(@RequestBody TSfrdIfInitcondVO tSfrdIfInitcondVO, HttpServletResponse response) {
		TSfrdIfInitcond tSfrdIfInitcond = new  TSfrdIfInitcond();
		if (null != tSfrdIfInitcondVO) {
			tSfrdIfInitcond = BeanMapper.map(tSfrdIfInitcondVO, tSfrdIfInitcond.getClass());
			tSfrdIfInitcond = tSfrdIfInitcondService.get(tSfrdIfInitcond);
		}
         //return ResponseEntity.ok(user);
	    return renderString(response, tSfrdIfInitcond);
   }
	
	@RequestMapping(value = "/list")
    @ApiOperation(value = "查询实体基本", notes = "查询实体基本", httpMethod = "POST")
	public String list(@RequestBody TSfrdIfInitcondVO tSfrdIfInitcondVO, HttpServletResponse response) {
		TSfrdIfInitcond tSfrdIfInitcond = new  TSfrdIfInitcond();
		if (null != tSfrdIfInitcondVO) {
			tSfrdIfInitcond = BeanMapper.map(tSfrdIfInitcondVO, tSfrdIfInitcond.getClass());
		}
	    Page<TSfrdIfInitcond> page = tSfrdIfInitcondService.getPage(new Page<TSfrdIfInitcond>(tSfrdIfInitcondVO.getPageNo(),tSfrdIfInitcondVO.getPageSize()), tSfrdIfInitcond);
	    return renderString(response, page);
    }
	
	@RequestMapping(value = "/save")
    @ApiOperation(value = "保存实体基本", notes = "保存实体基本", httpMethod = "POST")
	public String save(@RequestBody TSfrdIfInitcondVO tSfrdIfInitcondVO, HttpServletResponse response) {
		ServiceResp resp = new ServiceResp();
		TSfrdIfInitcond tSfrdIfInitcond = new  TSfrdIfInitcond();
		if (null != tSfrdIfInitcondVO) {
			tSfrdIfInitcond = BeanMapper.map(tSfrdIfInitcondVO, tSfrdIfInitcond.getClass());
		}
	    if(null!=tSfrdIfInitcondService.get(tSfrdIfInitcond)){
	    	resp = tSfrdIfInitcondService.update(tSfrdIfInitcond);
	    }else{
	    	resp = tSfrdIfInitcondService.save(tSfrdIfInitcond);
	    }
	    return renderString(response, resp);
    }
	
	@ResponseBody
	@RequestMapping(value = "remove")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "删除实体基本", notes = "删除实体基本", httpMethod = "POST")
	public String remove(@RequestBody TSfrdIfInitcond tSfrdIfInitcond, HttpServletResponse response){
		ServiceResp resp = tSfrdIfInitcondService.remove(tSfrdIfInitcond);
		return renderString(response, resp);
	}
	
}
