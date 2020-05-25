package com.jsite.szy.dispatch.dispatchwo.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jsite.szy.dispatch.dispatchwo.service.WaterOptimumService;
import com.jsite.szy.dispatch.dispatchwo.vo.WaterOptimumVOMap;

@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/wateroptimum")
public class WaterOptimumController{
	private Logger logger = LogManager.getLogger(this.getClass().getName());
	
	@Autowired
	private WaterOptimumService service;
	
	@RequestMapping(value="/test", produces="application/json;charset=UTF-8")
	public @ResponseBody String test(HttpServletRequest request,HttpServletResponse response){
		System.out.println("测试使用！test use");
		return "{\"test\": \"测试使用！test use\"}";
	}
	
	@RequestMapping(value="/initialCondition", produces="application/json;charset=UTF-8")
	public @ResponseBody WaterOptimumVOMap initialCondition(HttpServletRequest request,HttpServletResponse response){
		String schemeId = request.getParameter("schemeId");
		console("尝试读取方案 "+schemeId+" 的初始条件...");
		return service.initialCondition(schemeId);
	}
	
	@RequestMapping(value="/schedulingChart", produces="application/json;charset=UTF-8")
	public @ResponseBody WaterOptimumVOMap schedulingChart(HttpServletRequest request,HttpServletResponse response){
		String schemeId = request.getParameter("schemeId");
		console("尝试读取方案 "+schemeId+" 的调度图...");
		return service.schedulingChart(schemeId);
	}

	@RequestMapping(value="/schedulingConstraints", produces="application/json;charset=UTF-8")
	public @ResponseBody WaterOptimumVOMap schedulingConstraints(HttpServletRequest request,HttpServletResponse response){
		String schemeId = request.getParameter("schemeId");
		console("尝试读取方案 "+schemeId+" 的约束条件...");
		return service.schedulingConstraints(schemeId);
	}
	
	@RequestMapping(value="/uploadHistory", produces="application/json;charset=UTF-8")
	public @ResponseBody WaterOptimumVOMap uploadHistory(HttpServletRequest request,HttpServletResponse response){
		WaterOptimumVOMap output = new WaterOptimumVOMap();
		String eid = request.getParameter("eid");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("photo");
        try {
			InputStream input = file.getInputStream();
			output = service.uploadHistory(input, eid);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			output.put("message", "解析失败");
		}
		console("尝试保存历史信息...");
		return output;
	}
	
	@RequestMapping("/downloadHistory")
	public void downloadHistory(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Resource resource = new ClassPathResource("com/jsite/szy/dispatch/dispatchwo/template/hisdata.xlsx");
		response.setCharacterEncoding("utf-8");
	    response.setContentType("multipart/form-data");
	    response.setHeader("Content-Disposition", "attachment;fileName="+resource.getFilename());
	    try {
	    	InputStream is = resource.getInputStream();
	        OutputStream os = response.getOutputStream();
	        //循环写入输出流
	        byte[] b = new byte[2048];
	        int length;
	        while ((length = is.read(b)) > 0) {
	            os.write(b, 0, length);
	        }
	        os.close();
	        is.close();
	    } catch (Exception e){
	        e.printStackTrace();
	    }
	}

	@RequestMapping(value="/allocateResults", produces="application/json;charset=UTF-8")
	public @ResponseBody WaterOptimumVOMap allocateResults(HttpServletRequest request,HttpServletResponse response){
		String schemeId = request.getParameter("schemeId");
		console("尝试读取方案 "+schemeId+" 的水量分配结果...");
		return service.readAllocate(schemeId);
	}
	
	@RequestMapping(value="/schedulingCalculation", produces="application/json;charset=UTF-8")
	public @ResponseBody WaterOptimumVOMap schedulingCalculation(HttpServletRequest request,HttpServletResponse response){
		String schemeId = request.getParameter("schemeId");
		String initData = request.getParameter("initData");
		String constraintsData = request.getParameter("constraints");
		console("开始计算方案 "+schemeId+" ...");
		return service.calculation(schemeId, initData, constraintsData);
	}
	
	@RequestMapping(value="/schedulingResults", produces="application/json;charset=UTF-8")
	public @ResponseBody WaterOptimumVOMap schedulingResults(HttpServletRequest request,HttpServletResponse response){
		String schemeId = request.getParameter("schemeId");
		console("尝试读取方案 "+schemeId+" 的结果...");
		return service.readResult(schemeId);
	}
	
	public void console(String text){
		logger.info(text);
	}
}
