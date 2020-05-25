package com.jsite.szy.dispatch.sys.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;

import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.CookieUtils;
import com.jsite.core.web.BaseController;
import com.jsite.dao.sys.po.DdsSysUserinfo;
import com.jsite.manager.SystemService;
import com.jsite.manager.user.UserUtils;

/**
 * 登录验证信息表Controller
 * @author hjx
 * @version 2017-09-12
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/sys/login")
public class LoginController extends BaseController{
	
	@Autowired
	private SystemService systemService;

	@RequestMapping(value = {"login", ""})
	public String login(HttpServletRequest request,HttpServletResponse response){
		DdsSysUserinfo user = UserUtils.getUser(request);
		ServiceResp serviceResp = new ServiceResp();
		if(null!=user){
			HttpSession session = request.getSession();
			session.setAttribute("USERINFO", user);
			systemService.getUserByLoginName(user.getUserName());
			CookieUtils.setCookie(response, "LOGINED", "false");
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_1_MSG);
		}else{
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
		}
		return renderString(response, serviceResp);
	}
	
	@RequestMapping(value = {"logout", ""})
	public void logout(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		String ssoUrl = ContextLoader.getCurrentWebApplicationContext().getServletContext().getInitParameter("ssoServerLoginUrl");
		session.invalidate();
		try {
			 String contextUrl = request.getScheme() //当前链接使用的协议
         		    +"://" + request.getServerName()//服务器地址 
         		    + ":" + request.getServerPort() //端口号 
         		    + request.getContextPath()+"/"; //应用名称，如果应用名称为
			response.sendRedirect("http://10.136.4.157:8080/cas-server/logout?service="+contextUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
