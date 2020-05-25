package com.jsite.szy.dispatch.dispatch.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsite.busi.szy.sys.service.UserInfoService;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.web.BaseController;
import com.jsite.dao.sys.po.DdsSysUserinfo;
import com.jsite.dao.sys.po.User;
import com.jsite.szy.dispatch.sys.vo.DdsSysUserinfoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "${adminPath}/szy/dispatch/test")
@Api(value="test",tags="接口开放示例")
public class Test1Controller extends BaseController{
	
	@Autowired
	private UserInfoService ddsSysUserinfoService;

//	@ResponseBody
//	@RequestMapping(value = {"find", ""})
//	public String find(@RequestParam(required=false) String id, HttpServletResponse response) {
//		
//		return renderString(response, id);
//	}
	
	 @RequestMapping(value = "/{id}")
     @ApiOperation(value = "根据id获取产品信息", notes = "根据id获取产品信息",httpMethod = "POST", response = User.class)
	 public ResponseEntity<User> get(@PathVariable String id) {
        User user = new User();
        user.setName("七级滤芯净水器");
        user.setId(id);
        return ResponseEntity.ok(user);
    }
	
	@RequestMapping(value = "/update")
    @ApiOperation(value = "修改产品信息", notes = "修改产品信息", httpMethod = "POST", response = User.class)
	public String update(@RequestBody User user, HttpServletResponse response) {
       
        return renderString(response, user);
    }
	
	@ResponseBody
	@RequestMapping(value = "save")
    // 方法上加ApiOpreation注解
    @ApiOperation(value = "保存用户信息", notes = "保存用户信息", httpMethod = "POST")
	public String save(@RequestBody DdsSysUserinfoVO ddsSysUserinfoVO, HttpServletResponse response){
		
		return renderString(response, ddsSysUserinfoVO);
	}
}