package com.jsite.manager.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.jsite.manager.log.LogDaoUtils;

/**
 * 重写spring异常处理类
 * 
 * @author 徐旺旺
 *
 */
public class ExceptionResolver extends SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest req, HttpServletResponse resp, Object handler,
			Exception ex) {
		LogDaoUtils.save(req, handler, ex, "异常");
		return super.doResolveException(req, resp, handler, ex);
	}

}
