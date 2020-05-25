package com.jsite.szy.dispatch.emergency.web;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.common.collect.Maps;
import com.jsite.busi.szy.emergency.po.DdsEdBound;
import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.emergency.po.DdsMBoundry;
import com.jsite.busi.szy.emergency.po.DdsMConsec;
import com.jsite.busi.szy.emergency.po.DdsMRsv;
import com.jsite.busi.szy.emergency.service.DdsMConsecService;
import com.jsite.core.config.Global;
import com.jsite.core.excel.ImportExcel;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.FileDownload;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.cache.CacheResourceUtils;
import com.jsite.szy.dispatch.common.Constant;
import com.jsite.szy.dispatch.emergency.vo.DdsMConsecVO;

/**
 * 模型控制断面表Controller
 * @author hjx
 * @version 2017-07-05
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsmconsec")
public class DdsMConsecController extends BaseController {

	@Autowired
	private DdsMConsecService ddsMConsecService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsMConsecVO ddsMConsecVO = new DdsMConsecVO();
		if (StringUtils.isNotBlank(id)){
			DdsMConsec ddsMConsec = ddsMConsecService.get(id);
			if (null != ddsMConsec) {
				ddsMConsecVO = BeanMapper.map(ddsMConsec, ddsMConsecVO.getClass());
			}
		}
		return renderString(response, ddsMConsecVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsMConsecVO ddsMConsecVO, HttpServletResponse response) {
		DdsMConsec ddsMConsec = new DdsMConsec();
		if (null != ddsMConsecVO) {
			ddsMConsec = BeanMapper.map(ddsMConsecVO, ddsMConsec.getClass());
		}
		Page<DdsMConsec> page = ddsMConsecService.getPage(new Page<DdsMConsec>(), ddsMConsec); 
		return  renderString(response, page);
	}

	/**
	 * 根据河段代码获取上下断面信息
	 * @param ddsMConsecVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"listinit", ""})
	public String listInit(DdsMConsecVO ddsMConsecVO, HttpServletResponse response) {
		Map<String,Object> map = Maps.newHashMap();
		DdsMConsec ddsMConsec = new DdsMConsec();
		if (null != ddsMConsecVO) {
			ddsMConsec = BeanMapper.map(ddsMConsecVO, ddsMConsec.getClass());
		}
		ddsMConsec.setSecflag("up");
		List<DdsMConsec> listup = ddsMConsecService.list(ddsMConsec);
		map.put("listup", listup);
		ddsMConsec.setSecflag("down");
		List<DdsMConsec> listdown = ddsMConsecService.list(ddsMConsec);
		map.put("listdown", listdown);
		return  renderString(response, map);
	}
	
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(DdsMConsecVO ddsMConsecVO, HttpServletResponse response) {
		DdsMConsec ddsMConsec = new DdsMConsec();
		if (null != ddsMConsecVO) {
			ddsMConsec = BeanMapper.map(ddsMConsecVO, ddsMConsec.getClass());
		}
		ServiceResp serviceResp = new ServiceResp();
		DdsMConsec entity = ddsMConsecService.get(ddsMConsec);
		if(null!=entity){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("该记录已存在，不可保存");
		}else{
			serviceResp = ddsMConsecService.save(ddsMConsec);
		}
		new Thread(new Runnable() {
			public void run() {
				CacheResourceUtils.cacheData();
			}
		}).start();
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsMConsecVO ddsMConsecVO, HttpServletResponse response) {
		DdsMConsec ddsMConsec = new DdsMConsec();
		if (null != ddsMConsecVO) {
			ddsMConsec = BeanMapper.map(ddsMConsecVO, ddsMConsec.getClass());
		}
		ServiceResp serviceResp = ddsMConsecService.update(ddsMConsec);
		new Thread(new Runnable() {
			public void run() {
				CacheResourceUtils.cacheData();
			}
		}).start();
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsMConsecVO ddsMConsecVO, HttpServletResponse response) {
		DdsMConsec ddsMConsec = new DdsMConsec();
		if (null != ddsMConsecVO) {
			ddsMConsec = BeanMapper.map(ddsMConsecVO, ddsMConsec.getClass());
		}
		ServiceResp serviceResp = ddsMConsecService.remove(ddsMConsec);
		new Thread(new Runnable() {
			public void run() {
				CacheResourceUtils.cacheData();
			}
		}).start();
		logger.warn("删除模型控制断面记录：断面ID为："+ddsMConsecVO.getSecid());
		return renderString(response,serviceResp);
	}

	/**
	 * 选择导入模板
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value = "downtempletfile")
	public void downTempletFile(HttpServletRequest request,HttpServletResponse response){
		String filePath = Global.getConfig("uploadFile")+"/"+Constant.DEFAULT_UPLOADFILE+"/"+"mconsec.xlsx";
		String fileName = "mconsec.xlsx";
		FileDownload.fileDownload(response, filePath, fileName);
	}
	
	/**
	 * 导入数据
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value = "importdata")
	public String importData(HttpServletRequest request,HttpServletResponse response){
		ServiceResp serviceResp = new ServiceResp();
		serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;    
		MultipartFile mreq = multipartRequest.getFile("fileuploadfield"); 
		String msg = "";//消息提示
		int num = 0 ;//导入成功行数
		int err = 0 ; //导入出错行数
		String fieldNm = "";
		try {
			ImportExcel ei = new ImportExcel(mreq, 1,0);
			XSSFCell cell = null; 
			for (int i = ei.getDataRowNum()-1; i < ei.getLastDataRowNum(); i++) {
				XSSFRow row = (XSSFRow) ei.getRow(i);
				int rcd = 1;
				String secid = null ;
				String type = null;
				String secnm = null;
				String secFlag = null ;	
				double lendelta = 0;	
				double lenup = 0;
				
				for (int j = 0; j < ei.getLastCellNum(); j++) {
					String value = "";
					cell = row.getCell(j);  
					 if (cell != null) {  
						 switch (cell.getCellType()) {  
						 	case HSSFCell.CELL_TYPE_STRING://读取的格式为字符串  
	                            value = cell.getStringCellValue();
	                            if(j==1){
	                            	secid = value;
	                            }else if(j==2){
	                            	type = value;
	                            }else if(j==3){
	                            	secnm = value;
	                            }else if(j==4){
	                            	secFlag = value;
	                            }
	                            break;  
						 	 case HSSFCell.CELL_TYPE_NUMERIC://读取的格式为数组  
		                            //如果格式为日期格式，自定义格式输出  
		                            if (HSSFDateUtil.isCellDateFormatted(cell)) {  
		                                Date date = cell.getDateCellValue();  
		                                if (date != null) {  
		                                    value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
		                                } else {  
		                                    value = "";  
		                                }
		                            } else {  
		                                //如果格式为数值，自定义格式输出  
		                                value = new DecimalFormat().format(cell.getNumericCellValue());  
		                                double cellValue = cell.getNumericCellValue();
		                                if(j==0){
		                                	rcd = new Integer((int)cell.getNumericCellValue());
		                                }else if(j==5){
		                                	lendelta = cellValue;
		                                }else if(j==6){
		                                	lenup = cellValue;
		                                }
		                            }  
		                            break;  
						 	 case HSSFCell.CELL_TYPE_FORMULA:  
		                            // 导入时如果为公式生成的数据则无值  
	                            value = "";  
	                            break;  
	                            // 导入时如果为空  
	                        case HSSFCell.CELL_TYPE_BLANK:  
	                        	msg +="导入失败：第"+i+"行，第"+j+"列数据为空；\n";
	                            break;  
	                        case HSSFCell.CELL_TYPE_ERROR:  
	                            value = "";  
	                            msg +="导入失败：第"+i+"行，第"+j+"列数据格式错误；\n";
	                            break;  
	                            // 导入时如果为BOOLEAN型 自定义格式输出  
	                        case HSSFCell.CELL_TYPE_BOOLEAN:  
	                            value = (cell.getBooleanCellValue() == true ? "Y"  
	                                    : "N");  
	                            break;  
	                        default:  
	                            value = "";  
						 }
					 }
				}
				if(!checkNumber(rcd)){
					err++;
					msg +="导入失败：第"+i+"行，第一列：监测数据非法；\n";
    				//serviceResp.setMsg(msg+"导入成功行数："+num+",导入出错行数："+err);
    				//return renderString(response, serviceResp);
				}
				if(!checkNumber(lendelta)){
					err++;
					msg +="导入失败：第"+i+"行，第六列：监测数据非法；\n";
    				//serviceResp.setMsg(msg+"导入成功行数："+num+",导入出错行数："+err);
    				//return renderString(response, serviceResp);
				}
				if(!checkNumber(lenup)){
					err++;
					msg +="导入失败：第"+i+"行，第七列：监测数据非法；\n";
    				//serviceResp.setMsg(msg+"导入成功行数："+num+",导入出错行数："+err);
    				//return renderString(response, serviceResp);
				}
				DdsMConsec ddsMConsec = new DdsMConsec();
				ddsMConsec.setRcd(rcd);
				ddsMConsec.setSecid(secid);
				ddsMConsec.setSecflag(secFlag);
				ddsMConsec.setSecnm(secnm);
				ddsMConsec.setStype(type);
				ddsMConsec.setLendelta(lendelta);
				ddsMConsec.setLenup(lenup);
				DdsMConsec vo = ddsMConsecService.get(ddsMConsec);
				if(null!=vo){
					serviceResp.setMsg(msg+"第"+i+"行数据已存在");
					return renderString(response, serviceResp);
				}else{
					ServiceResp resp = ddsMConsecService.save(ddsMConsec);
					if(resp.getCode()==1){
						msg +="第"+i+"行数据导入成功";
					}
				}
				new Thread(new Runnable() {
					public void run() {
						CacheResourceUtils.cacheData();
					}
				}).start();
				return renderString(response,serviceResp);
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
			return renderString(response, serviceResp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(RespCode.SERVICE_RESP_ERROR_CODE_0_MSG);
			return renderString(response, serviceResp);
		}
		serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_1);
		serviceResp.setMsg(msg+"导入成功行数："+num+",导入出错行数："+err);
		return renderString(response, serviceResp);
	}
	
	public static boolean checkNumber(double value){
	        String str = String.valueOf(value);  
	        String regex = "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";
	        return str.matches(regex); 
	}
	
}