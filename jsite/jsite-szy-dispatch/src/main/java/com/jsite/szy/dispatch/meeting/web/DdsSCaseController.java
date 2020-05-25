package com.jsite.szy.dispatch.meeting.web;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.common.collect.Maps;
import com.jsite.busi.szy.meeting.po.DdsSCase;
import com.jsite.busi.szy.meeting.po.DdsSRes;
import com.jsite.busi.szy.meeting.service.DdsSCaseService;
import com.jsite.busi.szy.meeting.service.DdsSResService;
import com.jsite.core.config.Global;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.FileDownload;
import com.jsite.core.utils.FileUpload;
import com.jsite.core.utils.IdGen;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.common.Constant;
import com.jsite.szy.dispatch.meeting.vo.DdsSCaseVO;
import com.jsite.szy.dispatch.meeting.vo.DdsSResVO;

/**
 * 历史案例Controller
 * @author hjx
 * @version 2017-07-26
 */
@Controller
@RequestMapping(value = "${adminPath}/szy/dispatch/meeting/ddsSCase")
public class DdsSCaseController extends BaseController {

	@Autowired
	private DdsSCaseService ddsSCaseService;
	
	@Autowired
	private DdsSResService ddsSResService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsSCaseVO ddsSCaseVO = new DdsSCaseVO();
		if (StringUtils.isNotBlank(id)){
			DdsSCase ddsSCase = ddsSCaseService.get(id);
			if (null != ddsSCase) {
				ddsSCaseVO = BeanMapper.map(ddsSCase, ddsSCaseVO.getClass());
			}
		}
		return renderString(response, ddsSCaseVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsSCaseVO ddsSCaseVO, HttpServletResponse response) {
		DdsSCase ddsSCase = new DdsSCase();
		if (null != ddsSCaseVO) {
			ddsSCase = BeanMapper.map(ddsSCaseVO, ddsSCase.getClass());
		}
		Page<DdsSCase> page = ddsSCaseService.getPage(new Page<DdsSCase>(), ddsSCase); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsSCaseVO ddsSCaseVO, HttpServletResponse response) {
		String id = IdGen.uuid();
		ddsSCaseVO.setId(id);
		DdsSCase ddsSCase = new DdsSCase();
		if (null != ddsSCaseVO) {
			ddsSCase = BeanMapper.map(ddsSCaseVO, ddsSCase.getClass());
		}
		ServiceResp serviceResp = ddsSCaseService.save(ddsSCase);
		//保存附件信息
		String[] resId = ddsSCaseVO.getResId();
		if(resId!=null && resId.length > 0){
			for(String resid : resId){
				DdsSRes ddsSRes = ddsSResService.getByResId(resid);
				ddsSRes.setConId(id);
				ddsSResService.updateByResId(ddsSRes);
			}
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsSCaseVO ddsSCaseVO, HttpServletResponse response) {
		DdsSCase ddsSCase = new DdsSCase();
		if (null != ddsSCaseVO) {
			ddsSCase = BeanMapper.map(ddsSCaseVO, ddsSCase.getClass());
		}
		ServiceResp serviceResp = ddsSCaseService.update(ddsSCase);
		String[] resId = ddsSCaseVO.getResId();
		if(resId!=null&& resId.length>0){
			for(int i = 0 ; i < resId.length;i++){
				String resid = resId[i];
				DdsSRes  ddsSRes = new DdsSRes();
				ddsSRes.setConId(ddsSCaseVO.getId());
				ddsSRes.setResId(resid);
				ddsSRes = ddsSResService.get(ddsSRes);
				if(null==ddsSRes){
					ddsSRes = new DdsSRes();
					ddsSRes.setConId(ddsSCaseVO.getId());
					ddsSRes.setResId(resid);
					serviceResp = ddsSResService.updateByResId(ddsSRes);
				}
			}
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsSCaseVO ddsSCaseVO, HttpServletResponse response) {
		DdsSCase ddsSCase = new DdsSCase();
		if (null != ddsSCaseVO) {
			ddsSCase = BeanMapper.map(ddsSCaseVO, ddsSCase.getClass());
		}
		ServiceResp serviceResp = ddsSCaseService.remove(ddsSCase);
		return renderString(response,serviceResp);
	}
	
	/**
	* @Title: saveFile
	* @Description: TODO(保存附件)
	* @param @param request
	* @param @param response
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value = "saveFile")
	public String saveFile(HttpServletRequest request, HttpServletResponse response){
		//附件上传
		 ServiceResp serviceResp = new ServiceResp();
		 Map<String,Object> map = Maps.newHashMap();
		try{
			MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
			Iterator<String> fileNames = mreq.getFileNames();
			MultipartFile file = null;
	        String fileName = null;
	        while (fileNames.hasNext()) {
	            fileName = (String) fileNames.next();
	            file = mreq.getFile(fileName);
	            //文件名称
	            String name = file.getOriginalFilename();
	            //文件类型
	            String extension = name.substring(name.lastIndexOf(".")+1);
	            request.getContextPath();
	            
	            String accessUrl = request.getScheme() + "://"+ request.getServerName() + ":" +
	            			request.getServerPort()+ request.getContextPath() + "/"+Constant.DEFAULT_UPLOADFILE+"/";
	            String url = Global.getConfig("uploadFile")+Constant.DEFAULT_UPLOADFILE+"/";
	            //附件上传的文件名称
	            String fname = FileUpload.fileUp(file, url, IdGen.uuid());
	            //附件Entity
	            DdsSRes  ddsSRes = new DdsSRes();
	            String resId = IdGen.uuid();
	            ddsSRes.setResId(resId);
	            ddsSRes.setResName(name);
	            ddsSRes.setPath(accessUrl+fname);
	            serviceResp = ddsSResService.save(ddsSRes);
	            map.put("code", serviceResp.getCode());
	            map.put("resId", resId);
	            map.put("msg",serviceResp.getMsg());
	        }
		}catch(Exception e){
			e.printStackTrace();
			map.put("code",RespCode.SERVICE_RESP_ERROR_CODE_0);
			map.put("msg",RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
		    return renderString(response, map);
		}
		
        return renderString(response, map);
	}
	
	@ResponseBody
	@RequestMapping(value = "deletefile",consumes = "application/json")
	public String deletefile(@RequestBody DdsSResVO ddsSResVO, HttpServletResponse response){
		DdsSRes  ddsSRes = new DdsSRes();
		if (null != ddsSResVO) {
			ddsSRes = BeanMapper.map(ddsSResVO, ddsSRes.getClass());
		}
		ServiceResp serviceResp = ddsSResService.remove(ddsSRes);
		//删除文件
		String filePath = ddsSResVO.getPath();
		filePath = filePath.substring(filePath.indexOf("/upload/"),filePath.length());
		filePath = Global.getConfig("uploadFile")+filePath;
		File f = new File(filePath);
		if (f.exists()&&f.isFile()) {
			f.delete();
		}
		return renderString(response, serviceResp);
	}
	
	/**
	 * 附件下载
	 * @param baseFiles
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "fileDownload")
	public void fileDownload(DdsSResVO ddsSResVO, HttpServletResponse response){
		try{
			if(StringUtils.isNotBlank(ddsSResVO.getResId())){
				DdsSRes  ddsSRes = ddsSResService.getByResId(ddsSResVO.getResId());
				String filePath = ddsSRes.getPath();
				String fileName = ddsSRes.getResName();
				//变更为服务器真实存储地址
				filePath = filePath.substring(filePath.indexOf("/upload/"),filePath.length());
				filePath = Global.getConfig("uploadFile")+filePath;
				FileDownload.fileDownload(response, filePath, fileName);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
