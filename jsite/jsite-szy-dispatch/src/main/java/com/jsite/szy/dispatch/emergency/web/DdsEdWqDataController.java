package com.jsite.szy.dispatch.emergency.web;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jsite.busi.szy.emergency.po.DdsEdBound;
import com.jsite.busi.szy.emergency.po.DdsEdEvent;
import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.emergency.po.DdsEdSource;
import com.jsite.busi.szy.emergency.po.DdsEdWqData;
import com.jsite.busi.szy.emergency.po.DdsMConsec;
import com.jsite.busi.szy.emergency.service.DdsEdEventService;
import com.jsite.busi.szy.emergency.service.DdsEdSourceService;
import com.jsite.busi.szy.emergency.service.DdsEdWqDataService;
import com.jsite.busi.szy.emergency.service.DdsMConsecService;
import com.jsite.core.config.Global;
import com.jsite.core.excel.ImportExcel;
import com.jsite.core.mapper.BeanMapper;
import com.jsite.core.page.Page;
import com.jsite.core.service.RespCode;
import com.jsite.core.service.ServiceResp;
import com.jsite.core.utils.DateUtils;
import com.jsite.core.utils.FileDownload;
import com.jsite.core.utils.StringUtils;
import com.jsite.core.web.BaseController;
import com.jsite.szy.dispatch.common.Constant;
import com.jsite.szy.dispatch.emergency.mconfig.EdModelUtils;
import com.jsite.szy.dispatch.emergency.vo.DdsEdWqDataVO;

/**
 * 应急事件水质监测表Controller
 * @author hjx
 * @version 2017-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/DdsEdWqData")
public class DdsEdWqDataController extends BaseController{

	@Autowired
	private DdsEdWqDataService ddsEdWqDataService;
	
	@Autowired
	private DdsEdEventService ddsEdEventService;
	
	@Autowired
	private DdsMConsecService ddsMConsecService;
	
	@Autowired
	private DdsEdSourceService ddsEDSourceService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) DdsEdWqDataVO ddsEdWqDataVO, HttpServletResponse response) {
		DdsEdWqData ddsEdWqData = new DdsEdWqData();
		if (null != ddsEdWqDataVO){
			ddsEdWqData = BeanMapper.map(ddsEdWqDataVO, ddsEdWqData.getClass());
			ddsEdWqData = ddsEdWqDataService.get(ddsEdWqData);
		}
		return renderString(response, ddsEdWqData);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdWqDataVO ddsEdWqDataVO, HttpServletResponse response) {
		DdsEdWqData ddsEdWqData = new DdsEdWqData();
		if (null != ddsEdWqDataVO) {
			ddsEdWqData = BeanMapper.map(ddsEdWqDataVO, ddsEdWqData.getClass());
		}
		Page<DdsEdWqData> page = ddsEdWqDataService.getPage(new Page<DdsEdWqData>(), ddsEdWqData); 
		return  renderString(response, page);
	}

	/**
	 * 设置下断面默认监测数据值
	 * @param ddsEdWqDataVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = {"listdefault", ""})
	public String listDefault(DdsEdWqDataVO ddsEdWqDataVO, HttpServletResponse response) {
		Map<String,Object> map = Maps.newHashMap();
		DdsEdWqData ddsEdWqData = new DdsEdWqData();
		if (null != ddsEdWqDataVO) {
			ddsEdWqData = BeanMapper.map(ddsEdWqDataVO, ddsEdWqData.getClass());
		}
		//DdsEdSource source = ddsEDSourceService.get(ddsEdWqDataVO.getEvenCd());
		ServiceResp serviceResp = new ServiceResp();
		if(ddsEdWqDataVO.getBegt()==null && ddsEdWqDataVO.getEdt() ==null){
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg("请先填写起始计算时间、结束计算时间！");
			return  renderString(response, serviceResp);
		}
		Date begt = ddsEdWqDataVO.getBegt();
		Date edt = ddsEdWqDataVO.getEdt();
		ddsEdWqData.setStartTm(DateUtils.formatDateTime(begt));
		ddsEdWqData.setEndTm(DateUtils.formatDateTime(edt));
		List<DdsEdWqData> list = ddsEdWqDataService.list(ddsEdWqData);
	    Double c = 0.1d;//浓度序列
	    if(ddsEdWqDataVO.getDaType()==3){//3==COD  已减去物质初始浓度
	    	c=16d; 
	    }else if(ddsEdWqDataVO.getDaType()==4){//4==NH3N
	    	c=0.79d;
	    }else if(ddsEdWqDataVO.getDaType()==5){//5==CODMN
	    	c=5d;
	    }else if(ddsEdWqDataVO.getDaType()==6){//6==TP
	    	c=0.198d;
	    }
		//默认删除所有历史数据，重新生成
		if(null==list ||  list.size() <= 0 ){
			List<Date> listDate = EdModelUtils.getDateBetweenTwoDate(begt, edt);
			for(Date date : listDate){
				DdsEdWqData wqdata = new DdsEdWqData();
				wqdata.setEvenCd(ddsEdWqDataVO.getEvenCd());
				wqdata.setDownsec(ddsEdWqDataVO.getDownsec());
				wqdata.setTm(date);
				wqdata.setC(c);
				list.add(wqdata);
				ddsEdWqDataService.save(wqdata);
			}
		}
		Double bgConc = 1d;//物质初始浓度
		if(ddsEdWqDataVO.getDaType()==3){//3==COD
			bgConc = 8d;
	    }else if(ddsEdWqDataVO.getDaType()==4){//4==NH3N
	    	bgConc = 0.41d;
	    }else if(ddsEdWqDataVO.getDaType()==5){//5==CODMN
	    	bgConc = 2.2d;
	    }else if(ddsEdWqDataVO.getDaType()==6){//6==TP
	    	bgConc = 0.042d;
	    }
		DdsEdSource source = new DdsEdSource();
		source.setEvenCd(ddsEdWqDataVO.getEvenCd());
		DdsEdSource vo = ddsEDSourceService.get(ddsEdWqDataVO.getEvenCd());//如果该事件没有保存溯源信息
		if(vo==null){//保存默认值
			source.setBgConc(bgConc);
			ddsEDSourceService.save(source);
			map.put("source", source);
		}else{
			map.put("source", vo);
		}
		map.put("list", list);
		return  renderString(response, map);
	}
	
	//批量保存
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(@RequestBody List<DdsEdWqDataVO> volist, HttpServletResponse response) {
		DdsEdWqData ddsEdWqData = new DdsEdWqData();
		ServiceResp serviceResp = new ServiceResp();
		if (null != volist && volist.size() > 0) {
			for( int i = 0 ; i < volist.size() ; i++){
				DdsEdWqDataVO ddsEdWqDataVO = volist.get(i);
				ddsEdWqData = BeanMapper.map(ddsEdWqDataVO, ddsEdWqData.getClass());
				serviceResp = ddsEdWqDataService.save(ddsEdWqData);
			}
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdWqDataVO ddsEdWqDataVO, HttpServletResponse response) {
		DdsEdWqData ddsEdWqData = new DdsEdWqData();
		if (null != ddsEdWqDataVO) {
			ddsEdWqData = BeanMapper.map(ddsEdWqDataVO, ddsEdWqData.getClass());
		}
		ServiceResp serviceResp = ddsEdWqDataService.update(ddsEdWqData);
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdWqDataVO ddsEdWqDataVO, HttpServletResponse response) {
		DdsEdWqData ddsEdWqData = new DdsEdWqData();
		if (null != ddsEdWqDataVO) {
			ddsEdWqData = BeanMapper.map(ddsEdWqDataVO, ddsEdWqData.getClass());
		}
		ServiceResp serviceResp = ddsEdWqDataService.remove(ddsEdWqData);
		return renderString(response,serviceResp);
	}
	
	/**
	 * 选择导入模板
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value = "downtempletfile")
	public void downTempletFile(HttpServletRequest request,HttpServletResponse response){
		String filePath = Global.getConfig("uploadFile")+"/"+Constant.DEFAULT_UPLOADFILE+"/"+"wqdata.xlsx";
		try {
			 //读取文件
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet=workbook.createSheet("下断面浓度");  
			sheet.setColumnWidth(0, 8000);
			//设置表头
			Row title = sheet.createRow(0); 
			Cell tmCell = title.createCell(0);
			tmCell.setCellValue("时间");  
			tmCell.setCellType(HSSFCell.CELL_TYPE_STRING);
			Cell ValueCell = title.createCell(1);
			ValueCell.setCellValue("浓度值");  
			ValueCell.setCellType(HSSFCell.CELL_TYPE_STRING);
	        //查询方案监测断面对应的监测数据
	        String evenCd  = request.getParameter("evenCd");
	        String downsec  = request.getParameter("downsec");
	        DdsEdWqData ddsEdWqData = new DdsEdWqData();
	        ddsEdWqData.setEvenCd(evenCd);
	        ddsEdWqData.setDownsec(downsec);
	        List<DdsEdWqData> list =  ddsEdWqDataService.list(ddsEdWqData);
	        /** 
            * 往Excel中写新数据 
            */  
           for (int j = 0; j < list.size(); j++) {  
               // 创建一行：从第二行开始，跳过属性列  
               Row row = sheet.createRow(j + 1);  
               // 得到要插入的每一条记录  
               DdsEdWqData entity = list.get(j);  
               Cell first = row.createCell(0);
               first.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
               first.setCellValue(entity.getTm());  
               CreationHelper createHelper = workbook.getCreationHelper();  
               CellStyle cellStyle = workbook.createCellStyle();  
               cellStyle.setBorderBottom(CellStyle.BORDER_THIN);  
               cellStyle.setBorderLeft(CellStyle.BORDER_THIN);  
               cellStyle.setBorderRight(CellStyle.BORDER_THIN);
               cellStyle.setBorderTop(CellStyle.BORDER_THIN);
               cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd hh:mm:ss"));  
               first.setCellStyle(cellStyle);
               Cell second = row.createCell(1);  
               if(entity.getC()!=null){
               	second.setCellValue(entity.getC());  
               }
               CellStyle cstyle = workbook.createCellStyle();  
               cstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000"));
               cstyle.setBorderBottom(CellStyle.BORDER_THIN);  
               cstyle.setBorderLeft(CellStyle.BORDER_THIN);  
               cstyle.setBorderRight(CellStyle.BORDER_THIN);
               cstyle.setBorderTop(CellStyle.BORDER_THIN);
               second.setCellStyle(cstyle);
           }  
           /** 
            * 清空Excel中历史原始数据 
            */  
	        int rowNum = sheet.getLastRowNum();
	        if(rowNum>( list.size()+1)){
	        	 for (int j = list.size()+1; j <=rowNum; j++) {  
	        		 Row row = sheet.getRow(j);
	        		 if(row!=null){
	        			 sheet.removeRow(row);
	        		 }
	 	        }
	        }
           // 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效  
	       OutputStream out =  new FileOutputStream(filePath);  
           workbook.write(out);  
           out.flush();
           out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn("下断面水质浓度下载模板出错："+e.getMessage());
		} 
		String fileName = "下断面浓度.xlsx";
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
		String evenCd = request.getParameter("evenCd") ;		
		String downsec = request.getParameter("downsec");
		String rcd = request.getParameter("rcd");
		String msg = "";//消息提示
		int num = 0 ;//导入成功行数
		int err = 0 ; //导入出错行数
		//判断应急事件ID是否存在
		if(StringUtils.isBlank(evenCd)){
			err++;
			msg +="导入失败：应急事件ID不可为空；";
			serviceResp.setMsg(msg+"导入成功行数："+num+",导入出错行数："+err);
			return renderString(response, serviceResp);
		}
		try {
			ImportExcel ei = new ImportExcel(mreq, 1,0);
			XSSFCell cell = null; 
			for (int i = ei.getDataRowNum()-1; i < ei.getLastDataRowNum(); i++) {
				XSSFRow row = (XSSFRow) ei.getRow(i);
				Date tm = null ;		
				double c = 0;		
				for (int j = 0; j < ei.getLastCellNum(); j++) {
					String value = "";
					cell = row.getCell(j);  
					 if (cell != null) {  
						 switch (cell.getCellType()) {  
						 	case HSSFCell.CELL_TYPE_STRING://读取的格式为字符串  
	                            value = cell.getStringCellValue();  
	                            break;  
						 	 case HSSFCell.CELL_TYPE_NUMERIC://读取的格式为数组  
		                            //如果格式为日期格式，自定义格式输出  
		                            if (HSSFDateUtil.isCellDateFormatted(cell)) {  
		                                Date date = cell.getDateCellValue();  
		                                if (date != null) {  
		                                	if(j==0){
		                                		tm = date;
		                                	}
		                                    value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  
		                                } else {  
		                                    value = "";  
		                                }  
		                            } else {  
		                                //如果格式为数值，自定义格式输出  
		                                value = new DecimalFormat().format(cell  
		                                        .getNumericCellValue());  
		                                double cellValue = cell.getNumericCellValue();
	                                	if(j==1){
	                                		c = cellValue;
	                                	}
		                            }  
		                            break;  
						 	 case HSSFCell.CELL_TYPE_FORMULA:  
		                            // 导入时如果为公式生成的数据则无值  
	                            value = "";  
	                            break;  
	                            // 导入时如果为空  
	                        case HSSFCell.CELL_TYPE_BLANK:  
	                        	msg +="导入失败：第"+i+"行，第"+j+"列数据为空；";
	                            break;  
	                        case HSSFCell.CELL_TYPE_ERROR:  
	                            value = "";  
	                            msg +="导入失败：第"+i+"行，第"+j+"列数据格式错误；";
	                            break;  
	                            // 导入时如果为BOOLEAN型 自定义格式输出  
	                        case HSSFCell.CELL_TYPE_BOOLEAN:  
	                            value = (cell.getBooleanCellValue() == true ? "Y": "N");  
	                            break;  
	                        default:  
	                            value = "";  
						 }
					 }
				}
				//判断监测时间不可为空
				if(null==tm){
					err++;
					msg +="导入失败：第"+i+"行，第三列：监测时间不可为空；";
					break;
				}
				if(!checkNumber(c)){
					err++;
					msg +="导入失败：第"+i+"行，第二列：浓度数据非法；";
					break;
				}
				DdsEdWqData vo = new DdsEdWqData();
				vo.setEvenCd(evenCd);
				vo.setDownsec(downsec);
				vo.setTm(tm);
				vo.setC(c);
				
				DdsEdWqData entity = ddsEdWqDataService.get(vo);
				if(null!=entity){
					ServiceResp resp = ddsEdWqDataService.update(vo);
					if(1==resp.getCode()){
						num++;
					}
				}else{
					ServiceResp resp = ddsEdWqDataService.save(vo);
					if(1==resp.getCode()){
						num++;
					}
				}
				 tm = null ;		
				 c = 0;
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
