package com.jsite.szy.dispatch.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.util.Utils;

public class CacheResourceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected final String resourcePath;

	public CacheResourceServlet() {
		this.resourcePath = "http/resources";
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		String requestURI = request.getRequestURI();

		response.setCharacterEncoding("utf-8");

		if (contextPath == null) { // root context
			contextPath = "";
		}
		String uri = contextPath + servletPath;
		String path = requestURI.substring(contextPath.length() + servletPath.length());

		returnResourceFile(path, uri, response);
	}

	protected String getFilePath(String fileName) {
		return resourcePath + fileName;
	}

	protected void returnResourceFile(String fileName, String uri, HttpServletResponse response)
			throws ServletException, IOException {

		String filePath = getFilePath(fileName);

		if (filePath.endsWith(".html")) {
			response.setContentType("text/html; charset=utf-8");
		}
		if (fileName.endsWith(".jpg")) {
			byte[] bytes = Utils.readByteArrayFromResource(filePath);
			if (bytes != null) {
				response.getOutputStream().write(bytes);
			}
			return;
		}
		String text = Utils.readFromResource(filePath);
		if (text == null) {
			response.sendRedirect(uri + "/index.html");
			return;
		}
		if (fileName.endsWith(".css")) {
			response.setContentType("text/css;charset=utf-8");
		} else if (fileName.endsWith(".js")) {
			response.setContentType("text/javascript;charset=utf-8");
		}
		response.getWriter().write(text);
	}

	public String getResourcePath() {
		return resourcePath;
	}
	
}
