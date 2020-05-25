package com.jsite.szy.dispatch.emergency.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
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

import com.jsite.busi.szy.emergency.po.DdsEdEvent;
import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.emergency.po.DdsEdRsv;
import com.jsite.busi.szy.emergency.po.DdsMRsv;
import com.jsite.busi.szy.emergency.po.DdsMRsvr;
import com.jsite.busi.szy.emergency.service.DdsEdEventService;
import com.jsite.busi.szy.emergency.service.DdsEdPService;
import com.jsite.busi.szy.emergency.service.DdsEdRsvService;
import com.jsite.busi.szy.emergency.service.DdsMRsvService;
import com.jsite.busi.szy.emergency.service.DdsMRsvrService;
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
import com.jsite.szy.dispatch.emergency.vo.DdsEdRsvVO;
import com.jsite.szy.dispatch.emergency.vo.DdsMRsvrVO;

/**
 * 应急调度水库调节方式Controller
 * @author hjx
 * @version 2017-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdRsv")
public class DdsEdRsvController extends BaseController {

	@Autowired
	private DdsEdRsvService ddsEdRsvService;
	
	@Autowired
	private DdsEdPService ddsEdPService;
	
	@Autowired
	private DdsMRsvService ddsMRsvService;
	
	@Autowired
	private DdsMRsvrService ddsMRsvrService;
	
	@Autowired
	private DdsEdEventService ddsEdEventService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) String id, HttpServletResponse response) {
		DdsEdRsvVO ddsEdRsvVO = new DdsEdRsvVO();
		if (StringUtils.isNotBlank(id)){
			DdsEdRsv ddsEdRsv = ddsEdRsvService.get(id);
			if (null != ddsEdRsv) {
				ddsEdRsvVO = BeanMapper.map(ddsEdRsv, ddsEdRsvVO.getClass());
			}
		}
		return renderString(response, ddsEdRsvVO);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdRsvVO ddsEdRsvVO, HttpServletResponse response) {
		DdsEdRsv ddsEdRsv = new DdsEdRsv();
		if (null != ddsEdRsvVO) {
			ddsEdRsv = BeanMapper.map(ddsEdRsvVO, ddsEdRsv.getClass());
		}
		Page<DdsEdRsv> page = ddsEdRsvService.getPage(new Page<DdsEdRsv>(), ddsEdRsv); 
		return  renderString(response, page);
	}

	@ResponseBody
	@RequestMapping(value = "save")
	public String save(@RequestBody List<DdsEdRsvVO> volist, HttpServletResponse response) {
		DdsEdRsv ddsEdRsv = new DdsEdRsv();
		ServiceResp serviceResp = new ServiceResp();
		if (null != volist) {
			String msg = "";
			int rcd = 1 ;
			Double dvalue = 0.0d;
			double minValue = 0.0d;
			double maxValue = 1d;
			DdsEdP ddsEdP = ddsEdPService.get(volist.get(0).getProCd());
			DdsEdEvent ddsEdEvent = ddsEdEventService.get(ddsEdP.getEvenCd());
			rcd = ddsEdEvent.getRcd();
			DdsMRsv ddsMRsv = new DdsMRsv();
			ddsMRsv.setStcd(volist.get(0).getStcd());
			ddsMRsv.setRcd(rcd);
			List<DdsMRsv> listmrsv = ddsMRsvService.list(ddsMRsv);
			if(listmrsv.size()>0){
				dvalue = listmrsv.get(0).getDefaultValue();
				if(dvalue!=null){
					BigDecimal  a =  new BigDecimal(dvalue*0.6d);  
					minValue = a.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); //设置最小值为默认值的0.6倍
					BigDecimal  b =  new BigDecimal(dvalue*1.6d);  
					maxValue = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();//设置最大值为默认值的1.6倍
				}
			}
			for(int i = 0 ; i < volist.size(); i ++){
				DdsEdRsvVO ddsEdRsvVO = volist.get(i);
				ddsEdRsv = BeanMapper.map(ddsEdRsvVO, ddsEdRsv.getClass());
				if(minValue<=ddsEdRsv.getOtq()&& ddsEdRsv.getOtq()<=maxValue){//限制水库下泄流量
					serviceResp = ddsEdRsvService.save(ddsEdRsv);
				}else{
					msg +=" 原计划值不能小于最小值："+minValue+"不能大于最大值："+maxValue;
				}
			}
			if(msg!=""){
				serviceResp.setMsg(msg);
			}
		}
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(DdsEdRsvVO ddsEdRsvVO, HttpServletResponse response) {
		DdsEdRsv ddsEdRsv = new DdsEdRsv();
		if (null != ddsEdRsvVO) {
			ddsEdRsv = BeanMapper.map(ddsEdRsvVO, ddsEdRsv.getClass());
		}
		ServiceResp serviceResp = new ServiceResp();
		String msg = "";
		int rcd = 1 ;
		Double dvalue = 0.0d;
		double minValue = 0.0d;
		double maxValue = 1d;
		DdsEdP ddsEdP = ddsEdPService.get(ddsEdRsvVO.getProCd());
		DdsEdEvent ddsEdEvent = ddsEdEventService.get(ddsEdP.getEvenCd());
		rcd = ddsEdEvent.getRcd();
		DdsMRsv ddsMRsv = new DdsMRsv();
		ddsMRsv.setStcd(ddsEdRsvVO.getStcd());
		ddsMRsv.setRcd(rcd);
		List<DdsMRsv> listmrsv = ddsMRsvService.list(ddsMRsv);
		if(listmrsv.size()>0){
			dvalue = listmrsv.get(0).getDefaultValue();
			if(dvalue!=null){
				BigDecimal  a =  new BigDecimal(dvalue*0.6d);  
				minValue = a.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); //设置最小值为默认值的0.6倍
				BigDecimal  b =  new BigDecimal(dvalue*1.6d);  
				maxValue = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();//设置最大值为默认值的1.6倍
			}
		}
		if(minValue<=ddsEdRsv.getOtq()&& ddsEdRsv.getOtq()<=maxValue){
			serviceResp = ddsEdRsvService.update(ddsEdRsv);
		}else{
			serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
			serviceResp.setMsg(" 原计划值不能小于最小值："+minValue+"不能大于最大值："+maxValue);
		}
		return renderString(response,serviceResp);
	}
	
	/**
	 * 根据方案id，河段编码 ，如果是固定值，就更新加大流量
	 * @param ddsEdPVO
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateRsvrType")
	public String updateRsvrType(DdsMRsvrVO ddsMRsvrVO,HttpServletResponse response){
		DdsMRsvr ddsMRsvr = new DdsMRsvr();
		if(null!=ddsMRsvrVO){
			ddsMRsvr = BeanMapper.map(ddsMRsvrVO, ddsMRsvr.getClass());
		}
		ddsMRsvr = ddsMRsvrService.get(ddsMRsvr);
		ServiceResp serviceResp = new ServiceResp();
		if(null!=ddsMRsvr){
			ddsMRsvr.setExq(ddsMRsvrVO.getExq());
			ddsMRsvr.setType("1");
			serviceResp = ddsMRsvrService.update(ddsMRsvr);
		}
		DdsEdRsv ddsEdRsv = new DdsEdRsv();
		ddsEdRsv.setProCd(ddsMRsvrVO.getProCd());
		if(ddsMRsvrVO.getStarttime()!=null){
			ddsEdRsv.setStartTm(DateUtils.formatDateTime(ddsMRsvrVO.getStarttime()));
		}
		if(ddsMRsvrVO.getEndtime()!=null){
			ddsEdRsv.setEndTm(DateUtils.formatDateTime(ddsMRsvrVO.getEndtime()));
		}
		DdsMRsv ddsMRsv = new DdsMRsv();
		ddsMRsv.setRcd(ddsMRsvrVO.getRcd());
		ddsMRsv.setRescd(ddsMRsvrVO.getResCd());
		ddsMRsv = ddsMRsvService.get(ddsMRsv);
		if(null!=ddsMRsv){
			ddsEdRsv.setStcd(ddsMRsv.getStcd());
			ddsEdRsv.setExq(ddsMRsvrVO.getExq());
			ddsEdRsv.setExqtype(1);
			serviceResp = ddsEdRsvService.updateExq(ddsEdRsv);
			ddsEdRsv.setExq(0d);
			ddsEdRsv.setExqtype(1);
			serviceResp = ddsEdRsvService.updateDefault(ddsEdRsv);
		}
		return renderString(response, serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdRsvVO ddsEdRsvVO, HttpServletResponse response) {
		DdsEdRsv ddsEdRsv = new DdsEdRsv();
		if (null != ddsEdRsvVO) {
			ddsEdRsv = BeanMapper.map(ddsEdRsvVO, ddsEdRsv.getClass());
		}
		ServiceResp serviceResp = ddsEdRsvService.remove(ddsEdRsv);
		return renderString(response,serviceResp);
	}

	/**
	 * 选择导入模板
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value = "downtempletfile")
	public void downTempletFile(HttpServletRequest request,HttpServletResponse response){
		String filePath = Global.getConfig("uploadFile")+Constant.DEFAULT_UPLOADFILE+"/"+"edrsv.xlsx";
		try {
			 //读取文件
			// Workbook workbook = WorkbookFactory.create(file);
			 Workbook workbook = new XSSFWorkbook();
			 // sheet 对应一个工作页  
			 Sheet sheet = workbook.createSheet("水库调节");
			 sheet.setColumnWidth(0, 8000);
			 Row title = sheet.createRow(0); 
			 Cell tmCell = title.createCell(0);
			 tmCell.setCellValue("时间");  
			 tmCell.setCellType(HSSFCell.CELL_TYPE_STRING);
			 Cell exqCell = title.createCell(1);
			 exqCell.setCellValue("原计划值");  
			 exqCell.setCellType(HSSFCell.CELL_TYPE_STRING);
			 Cell otqCell = title.createCell(2);
			 otqCell.setCellValue("加大流量值");  
			 otqCell.setCellType(HSSFCell.CELL_TYPE_STRING);
			 // 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效  
	        //查询方案监测断面对应的监测数据
	        String proCd  = request.getParameter("proCd");
	        String stcd  = request.getParameter("stcd");
	        DdsEdP ddsEdP = ddsEdPService.get(proCd);
	        DdsEdRsv ddsEdRsv = new DdsEdRsv();
	        ddsEdRsv.setProCd(proCd);
	        ddsEdRsv.setStcd(stcd);
	        ddsEdRsv.setStartTm(DateUtils.formatDateTime(ddsEdP.getBgDt()));
	        ddsEdRsv.setEndTm(DateUtils.formatDateTime(ddsEdP.getEdDt()));
	        List<DdsEdRsv> list =  ddsEdRsvService.list(ddsEdRsv);
	        
	        /** 
             * 往Excel中写新数据 
             */  
            for (int j = 0; j < list.size(); j++) {  
                // 创建一行：从第二行开始，跳过属性列  
                Row row = sheet.createRow(j + 1);  
                // 得到要插入的每一条记录  
                DdsEdRsv entity = list.get(j);  
                Cell first = row.createCell(0);  
                first.setCellValue(entity.getTm());  
                first.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                first.setCellValue(entity.getTm());  
                CreationHelper createHelper = workbook.getCreationHelper();  
                CellStyle cellStyle = workbook.createCellStyle();  
                cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd hh:mm:ss"));  
                cellStyle.setBorderBottom(CellStyle.BORDER_THIN);  
                cellStyle.setBorderLeft(CellStyle.BORDER_THIN);  
                cellStyle.setBorderRight(CellStyle.BORDER_THIN);
                cellStyle.setBorderTop(CellStyle.BORDER_THIN);
                first.setCellStyle(cellStyle);
                
                Cell second = row.createCell(1);  
                if(entity.getOtq()!=null){
                	second.setCellValue(entity.getOtq());  
                }else{
                	second.setCellValue("");  
                }
                CellStyle cstyle = workbook.createCellStyle();  
                cstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.000"));
                cstyle.setBorderBottom(CellStyle.BORDER_THIN);  
                cstyle.setBorderLeft(CellStyle.BORDER_THIN);  
                cstyle.setBorderRight(CellStyle.BORDER_THIN);
                cstyle.setBorderTop(CellStyle.BORDER_THIN);
                second.setCellStyle(cstyle);
                
                Cell third = row.createCell(2);
                if(entity.getExq()!=null){
                	third.setCellValue(entity.getExq());  
                }else{
                	third.setCellValue("");  
                }
                third.setCellStyle(cstyle);
            }
            /** 
             * 清空Excel中历史原始数据 
             */  
	        int rowNum = sheet.getLastRowNum();
	        if(rowNum>( list.size()+1)){
	        	 for (int j = list.size()+1; j <= rowNum; j++) {  
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
			logger.warn("水库调节下载模板出错："+e.getMessage());
		} 
		String fileName = "水库调节.xlsx";
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
		String proCd = request.getParameter("proCd") ;		
		String stcd = request.getParameter("stcd");	
		String msg = "";//消息提示
		int num = 0 ;//导入成功行数
		int err = 0 ; //导入出错行数
		//判断方案ID是否存在
		if(StringUtils.isBlank(proCd)){
			err++;
			msg +="导入失败：方案ID不可为空；";
			serviceResp.setMsg(msg+"导入成功行数："+num+",导入出错行数："+err);
			return renderString(response, serviceResp);
		}
		//判断水库对应的测站编码是否存在
		if(StringUtils.isBlank(stcd)){
			err++;
			msg +="导入失败：测站编码不可为空；";
			serviceResp.setMsg(msg+"导入成功行数："+num+",导入出错行数："+err);
			return renderString(response, serviceResp);
		}
		try {
			int rcd = 1 ;
			Double dvalue = 0.0d;
			double minValue = 0.0d;
			double maxValue = 1d;
			DdsEdP ddsEdP = ddsEdPService.get(proCd);
			DdsEdEvent ddsEdEvent = ddsEdEventService.get(ddsEdP.getEvenCd());
			rcd = ddsEdEvent.getRcd();
			DdsMRsv ddsMRsv = new DdsMRsv();
			ddsMRsv.setStcd(stcd);
			ddsMRsv.setRcd(rcd);
			List<DdsMRsv> listmrsv = ddsMRsvService.list(ddsMRsv);
			if(listmrsv.size()>0){
				dvalue = listmrsv.get(0).getDefaultValue();
				if(dvalue!=null){
					BigDecimal  a =  new BigDecimal(dvalue*0.6d);  
					minValue = a.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); //设置最小值为默认值的0.6倍
					BigDecimal  b =  new BigDecimal(dvalue*1.6d);  
					maxValue = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();//设置最大值为默认值的1.6倍
				}
			}
			
			ImportExcel ei = new ImportExcel(mreq, 1,0);
			XSSFCell cell = null; 
			for (int i = ei.getDataRowNum()-1; i < ei.getLastDataRowNum(); i++) {
				XSSFRow row = (XSSFRow) ei.getRow(i);
				Date tm = null ;		
				double z = 0;	
				double exq = 0;	
				for (int j = 0; j < ei.getLastCellNum(); j++) {
					String value = "";
					if(row==null){
						continue;
					}
					cell = row.getCell(j);
					if(cell==null){
						continue;
					}else{
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
		                                    value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")  
		                                            .format(date);  
		                                } else {  
		                                    value = "";  
		                                }  
		                            } else {  
		                                //如果格式为数值，自定义格式输出  
		                                value = new DecimalFormat().format(cell  
		                                        .getNumericCellValue());  
		                                double cellValue = cell.getNumericCellValue();
	                                	if(j==1){
	                                		z = cellValue;
	                                	}else if(j==2){
	                                		exq = cellValue;
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
	                            value = (cell.getBooleanCellValue() == true ? "Y"  
	                                    : "N");  
	                            break;  
	                        default:  
	                            value = "";  
						 }
					 }
				}
				//判断监测时间不可为空
				if(null==tm){
					err++;
					msg +="导入失败：第"+i+"行，第一列：监测时间不可为空；";
					break;
				}
				if(!checkNumber(z)){
					err++;
					msg +="导入失败：第"+i+"行，第二列：监测数据非法；";
					break;
				}
				if(!checkNumber(exq)){
					err++;
					msg +="导入失败：第"+i+"行，第三列：监测数据非法；";
					break;
				}
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(tm);
				if( (gc.get(gc.MINUTE)==0) && (gc.get(gc.SECOND)==0) ){
					DdsEdRsv vo = new DdsEdRsv();
					vo.setProCd(proCd);
					vo.setStcd(stcd);
					vo.setTm(tm);
					DdsEdRsv entity = ddsEdRsvService.get(vo);
					if(minValue<=z && z<=maxValue){//限定导入水库下泄流量
						vo.setOtq(z);
						vo.setOtqtype(2);
						vo.setExq(exq);
						vo.setExqtype(2);
						if(null!=entity){
							ServiceResp resp = ddsEdRsvService.update(vo);
							if(1==resp.getCode()){
								num++;
							}
						}else{
							ServiceResp resp = ddsEdRsvService.save(vo);
							if(1==resp.getCode()){
								num++;
							}
						}
					}else{
						msg +=" 原计划值不能小于最小值："+minValue+"不能大于最大值："+maxValue;
					}
				}else{
					err++;
					msg +="导入失败：第"+i+"行，第一列：不是整点数据；";
					break;
				}
				tm = null ;		
				z = 0;	
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