package com.jsite.szy.dispatch.servlet;
 
import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.commons.lang3.StringUtils;

import com.jsite.core.mapper.BeanMapper;
import com.jsite.dao.sys.po.DdsSysUserinfo;
import com.jsite.dao.sys.po.DeptInfo;
import com.jsite.manager.user.UserUtils;

import cn.com.dhcc.uums.service.uums.DepInfo;
import cn.com.dhcc.uums.service.uums.UumsServiceImplService;
import cn.com.dhcc.uums.service.uums.UumsServiceImplServiceLocator;
import cn.com.dhcc.uums.service.uums.UumsServiceImplServiceSoapBindingStub;
 
public class LoginFilter implements Filter {
         
            @Override
             public void init(FilterConfig filterConfig) throws ServletException {
                 // TODO Auto-generated method stub
             }
        
            @Override
            public void doFilter(ServletRequest request, ServletResponse response,
                     FilterChain chain) throws IOException, ServletException {
                 // 获得在下面代码中要用的request,response,session对象
                HttpServletResponse servletResponse = (HttpServletResponse) response;
                HttpServletRequest servletRequest = (HttpServletRequest)request;
               
                servletResponse.setHeader("Access-Control-Allow-Origin", "*"); 
                
                String requestUrl = servletRequest.getScheme() //当前链接使用的协议
                        +"://" + servletRequest.getServerName()//服务器地址 
                        + ":" + servletRequest.getServerPort() //端口号 
                        + servletRequest.getContextPath() //应用名称，如果应用名称为
                        + servletRequest.getServletPath() //请求的相对url 
                        + "?" + servletRequest.getQueryString(); //请求参数
                System.out.println(requestUrl);
                 // 判断如果没有取到员工信息,就跳转到登陆页面
                try{
                	
                	DdsSysUserinfo user = UserUtils.getUser(servletRequest);//SsoUtil.getUserInfo(request);
                	
                    if (user!=null) {
                            UserUtils.putCache(UserUtils.CACHE_AUTH_INFO, user);
                            chain.doFilter(request, response);
                    } else {
                       // 跳转到登陆页面
                        String contextUrl = servletRequest.getScheme() //当前链接使用的协议
                               +"://" + servletRequest.getServerName()//服务器地址 
                               + ":" + servletRequest.getServerPort() //端口号 
                               + servletRequest.getContextPath()+"/"; //应用名称，如果应用名称为
                       servletResponse.sendRedirect("http://10.136.4.157:8080/cas-server/login?service="+contextUrl);
                    }
                }catch(Exception e){
                     String contextUrl = servletRequest.getScheme() //当前链接使用的协议
                              +"://" + servletRequest.getServerName()//服务器地址 
                              + ":" + servletRequest.getServerPort() //端口号 
                              + servletRequest.getContextPath()+"/"; //应用名称，如果应用名称为
                    UserUtils.removeCache(UserUtils.CACHE_AUTH_INFO);
                    servletRequest.getSession().invalidate();
                    
                    // 跳转到登陆页面
                    servletResponse.sendRedirect("http://10.136.4.157:8080/cas-server/login?service="+contextUrl);
                }
             }
         
             @Override
             public void destroy() {
                 // TODO Auto-generated method stub
             }
    
}