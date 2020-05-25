package com.jsite.szy.dispatch.emergency.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

import com.jsite.busi.szy.emergency.po.DdsEdBound;
import com.jsite.busi.szy.emergency.po.DdsEdEvent;
import com.jsite.busi.szy.emergency.po.DdsEdP;
import com.jsite.busi.szy.emergency.po.DdsMBoundry;
import com.jsite.busi.szy.emergency.service.DdsEdBoundService;
import com.jsite.busi.szy.emergency.service.DdsEdEventService;
import com.jsite.busi.szy.emergency.service.DdsEdPService;
import com.jsite.busi.szy.emergency.service.DdsMBoundryService;
import com.jsite.busi.szy.sys.service.UserInfoService;
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
import com.jsite.dao.sys.po.DdsSysUserinfo;
import com.jsite.szy.dispatch.common.Constant;
import com.jsite.szy.dispatch.emergency.vo.DdsEdBoundVO;
import com.jsite.szy.dispatch.sys.vo.DdsSysUserinfoVO;

/**
 * 应急调度边界条件Controller
 * @author hjx
 * @version 2017-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/emergency/ddsEdBound")
public class DdsEdBoundController extends BaseController {

	@Autowired
	private DdsEdBoundService ddsEdBoundService;
	
	@Autowired
	private DdsEdPService ddsEdPService;
	
	@Autowired
	private DdsMBoundryService ddsMBoundryService;
	
	@Autowired
	private DdsEdEventService ddsEdEventService;
	
	@ResponseBody
	@RequestMapping(value = { "get", "" })
	public String get(@RequestParam(required=false) DdsEdBoundVO ddsEdBoundVO, HttpServletResponse response) {
		DdsEdBound ddsEdBound = new DdsEdBound();
		if (null != ddsEdBoundVO){
			ddsEdBound = BeanMapper.map(ddsEdBoundVO, ddsEdBound.getClass());
			ddsEdBound = ddsEdBoundService.get(ddsEdBound);
		}
		return renderString(response, ddsEdBound);
	}
	
	@ResponseBody
	@RequestMapping(value = {"list", ""})
	public String list(DdsEdBoundVO ddsEdBoundVO, HttpServletResponse response) {
		DdsEdBound ddsEdBound = new DdsEdBound();
		if (null != ddsEdBoundVO) {
			ddsEdBound = BeanMapper.map(ddsEdBoundVO, ddsEdBound.getClass());
		}
		if(StringUtils.isNotBlank(ddsEdBound.getProCd())){
			DdsEdP ddsEdP = ddsEdPService.get(ddsEdBound.getProCd());
			if(ddsEdP.getBgDt()!=null&&ddsEdP.getEdDt()!=null){
				ddsEdBound.setStartTime(DateUtils.formatDateTime(ddsEdP.getBgDt()));
				ddsEdBound.setEndTime(DateUtils.formatDateTime(ddsEdP.getEdDt()));
			}
		}
		Page<DdsEdBound> page = ddsEdBoundService.getPage(new Page<DdsEdBound>(), ddsEdBound); 
		return  renderString(response, page);
	}

	//批量保存
	@ResponseBody
	@RequestMapping(value = "save")
	public String save(@RequestBody List<DdsEdBoundVO> volist, HttpServletResponse response) {
		DdsEdBound ddsEdBound = new DdsEdBound();
		ServiceResp serviceResp = new ServiceResp();
		String msg = "";
		int rcd = 1 ;
		Double dvalue = 0.0d;
		double minValue = 0.0d;
		double maxValue = 1d;
		DdsMBoundry ddsMBoundry = new DdsMBoundry();
		if (null != volist && volist.size() > 0) {//获取方案对应的应急事件的河道编号
			if(StringUtils.isNotBlank(volist.get(0).getProCd())){
				DdsEdP ddsEdP = ddsEdPService.get(volist.get(0).getProCd());
				DdsEdEvent ddsEdEvent = ddsEdEventService.get(ddsEdP.getEvenCd());
				rcd = ddsEdEvent.getRcd();
				DdsMBoundry boundry = new DdsMBoundry();
				boundry.setRcd(rcd);
				boundry.setStcd(volist.get(0).getStcd());
				ddsMBoundry = ddsMBoundryService.get(boundry);
				dvalue = ddsMBoundry.getDefaultValue();
				if(dvalue!=null){
					BigDecimal  a =  new BigDecimal(dvalue*0.6d);  
					minValue = a.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); //设置最小值为默认值的0.6倍
					BigDecimal  b =  new BigDecimal(dvalue*1.6d);  
					maxValue = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();//设置最大值为默认值的1.6倍
				}
			}
			for( int i = 0 ; i < volist.size() ; i++){
				DdsEdBoundVO ddsEdBoundVO = volist.get(i);
				ddsEdBound = BeanMapper.map(ddsEdBoundVO, ddsEdBound.getClass());
				if("Z".equals(ddsMBoundry.getFieldnm())){
					if(minValue<=ddsEdBound.getZ()&& ddsEdBound.getZ()<=maxValue){
						serviceResp = ddsEdBoundService.save(ddsEdBound);
					}else{
						msg +=" 不能小于最小值："+minValue+"不能大于最大值："+maxValue;
					}
				}else if("Q".equals(ddsMBoundry.getFieldnm())){
					if(minValue<=ddsEdBound.getQ()&& ddsEdBound.getQ()<=maxValue){
						serviceResp = ddsEdBoundService.save(ddsEdBound);
					}else{
						msg +=" 不能小于最小值："+minValue+"不能大于最大值："+maxValue;
					}
				}else if("INQ".equals(ddsMBoundry.getFieldnm())){
					if(minValue<=ddsEdBound.getInq()&& ddsEdBound.getInq()<=maxValue){
						serviceResp = ddsEdBoundService.save(ddsEdBound);
					}else{
						msg +=" 不能小于最小值："+minValue+"不能大于最大值："+maxValue;
					}
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
	public String update(DdsEdBoundVO ddsEdBoundVO, HttpServletResponse response) {
		ServiceResp serviceResp = new ServiceResp();
		int rcd = 1 ;
		Double dvalue = 0.0d;
		double minValue = 0.0d;
		double maxValue =1d;
		DdsMBoundry ddsMBoundry = new DdsMBoundry();
		DdsEdP ddsEdP = ddsEdPService.get(ddsEdBoundVO.getProCd());
		DdsEdEvent ddsEdEvent = ddsEdEventService.get(ddsEdP.getEvenCd());
		rcd = ddsEdEvent.getRcd();
		DdsMBoundry boundry = new DdsMBoundry();
		boundry.setRcd(rcd);
		boundry.setStcd(ddsEdBoundVO.getStcd());
		ddsMBoundry = ddsMBoundryService.get(boundry);
		dvalue = ddsMBoundry.getDefaultValue();
		if(dvalue!=null){
			BigDecimal  a =  new BigDecimal(dvalue*0.6d);  
			minValue = a.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); //设置最小值为默认值的0.6倍
			BigDecimal  b =  new BigDecimal(dvalue*1.6d);  
			maxValue = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();//设置最大值为默认值的1.6倍
		}
		DdsEdBound ddsEdBound = new DdsEdBound();
		if (null != ddsEdBoundVO) {
			ddsEdBound = BeanMapper.map(ddsEdBoundVO, ddsEdBound.getClass());
		}
		if("Z".equals(ddsMBoundry.getFieldnm())){
			if(minValue<=ddsEdBound.getZ()&& ddsEdBound.getZ()<=maxValue){
				serviceResp = ddsEdBoundService.update(ddsEdBound);
			}else{ 
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(" 不能小于最小值："+minValue+"不能大于最大值："+maxValue);
			}
		}else if("Q".equals(ddsMBoundry.getFieldnm())){
			if(minValue<=ddsEdBound.getQ()&& ddsEdBound.getQ()<=maxValue){
				serviceResp = ddsEdBoundService.update(ddsEdBound);
			}else{
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(" 不能小于最小值："+minValue+"不能大于最大值："+maxValue);
			}
		}else if("INQ".equals(ddsMBoundry.getFieldnm())){
			if(minValue<=ddsEdBound.getInq()&& ddsEdBound.getInq()<=maxValue){
				serviceResp = ddsEdBoundService.update(ddsEdBound);
			}else{
				serviceResp.setCode(RespCode.SERVICE_RESP_ERROR_CODE_0);
				serviceResp.setMsg(" 不能小于最小值："+minValue+"不能大于最大值："+maxValue);
			}
		}
		
		return renderString(response,serviceResp);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete")
	public String delete(DdsEdBoundVO ddsEdBoundVO, HttpServletResponse response) {
		DdsEdBound ddsEdBound = new DdsEdBound();
		if (null != ddsEdBoundVO) {
			ddsEdBound = BeanMapper.map(ddsEdBoundVO, ddsEdBound.getClass());
		}
		ServiceResp serviceResp = ddsEdBoundService.remove(ddsEdBound);
		return renderString(response,serviceResp);
	}
	
	/**
	 * 选择导入模板
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value = "downtempletfile")
	public void downTempletFile(HttpServletRequest request,HttpServletResponse response){
		String filePath = Global.getConfig("uploadFile")+"/"+Constant.DEFAULT_UPLOADFILE+"/"+"edbound.xlsx";
		File file = new File(filePath);  
		try {
			 //读取文件
			// Workbook workbook = WorkbookFactory.create(file);
			 Workbook workbook = new XSSFWorkbook();
			 // sheet 对应一个工作页  
			// Sheet sheet = workbook.getSheetAt(0);
			Sheet sheet=workbook.createSheet("边界条件");  
			sheet.setColumnWidth(0, 8000);
			//设置表头
			Row title = sheet.createRow(0); 
			Cell tmCell = title.createCell(0);
			tmCell.setCellValue("时间");  
			tmCell.setCellType(HSSFCell.CELL_TYPE_STRING);
			Cell ValueCell = title.createCell(1);
			ValueCell.setCellValue("值");  
			ValueCell.setCellType(HSSFCell.CELL_TYPE_STRING);
			
	        //查询方案监测断面对应的监测数据
	        String proCd  = request.getParameter("proCd");
	        String stcd  = request.getParameter("stcd");
	        DdsEdP ddsEdP = ddsEdPService.get(proCd);
	        DdsEdBound ddsEdBound = new DdsEdBound();
	        ddsEdBound.setProCd(proCd);
	        ddsEdBound.setStcd(stcd);
	        ddsEdBound.setStartTime(DateUtils.formatDateTime(ddsEdP.getBgDt()));
	        ddsEdBound.setEndTime(DateUtils.formatDateTime(ddsEdP.getEdDt()));
	        List<DdsEdBound> list =  ddsEdBoundService.list(ddsEdBound);
	        /** 
             * 往Excel中写新数据 
             */  
            for (int j = 0; j < list.size(); j++) {  
                // 创建一行：从第二行开始，跳过属性列  
                Row row = sheet.createRow(j + 1);  
                // 得到要插入的每一条记录  
                DdsEdBound entity = list.get(j);  
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
                if(entity.getZ()!=null){
                	second.setCellValue(entity.getZ());  
                }else if(entity.getInq()!=null){
                	second.setCellValue(entity.getInq());
                }else if(entity.getQ()!=null){
                	second.setCellValue(entity.getQ());
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
			logger.warn("边界条件下载模板出错："+e.getMessage());
		} 
		String fileName = "边界条件.xlsx";
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
		//判断应急事件ID是否存在
		if(StringUtils.isBlank(proCd)){
			err++;
			msg +="导入失败：方案ID不可为空；";
			serviceResp.setMsg(msg+"导入成功行数："+num+",导入出错行数："+err);
			return renderString(response, serviceResp);
		}
		//判断下监测断面ID是否存在
		if(StringUtils.isBlank(stcd)){
			err++;
			msg +="导入失败：测站编码不可为空；";
			serviceResp.setMsg(msg+"导入成功行数："+num+",导入出错行数："+err);
			return renderString(response, serviceResp);
		}
		int rcd = 1 ;
		Double dvalue = 0.0d;
		double minValue = 0.0d;
		double maxValue = 1d;
		DdsMBoundry ddsMBoundry = new DdsMBoundry();
		DdsEdP ddsEdP = ddsEdPService.get(proCd);
		DdsEdEvent ddsEdEvent = ddsEdEventService.get(ddsEdP.getEvenCd());
		rcd = ddsEdEvent.getRcd();
		DdsMBoundry boundry = new DdsMBoundry();
		boundry.setRcd(rcd);
		boundry.setStcd(stcd);
		ddsMBoundry = ddsMBoundryService.get(boundry);
		dvalue = ddsMBoundry.getDefaultValue();
		String fieldNm = ddsMBoundry.getFieldnm();
		if(dvalue!=null){
			BigDecimal  a =  new BigDecimal(dvalue*0.6d);  
			minValue = a.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); //设置最小值为默认值的0.6倍
			BigDecimal  b =  new BigDecimal(dvalue*1.6d);  
			maxValue = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();//设置最大值为默认值的1.6倍
		}
		try {
			ImportExcel ei = new ImportExcel(mreq, 1,0);
			XSSFCell cell = null; 
			for (int i = ei.getDataRowNum()-1; i < ei.getLastDataRowNum(); i++) {
				XSSFRow row = (XSSFRow) ei.getRow(i);
				Date tm = null ;		
				double z = 0;	
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
	                                	}
		                            }  
		                            break;  
						 	 case HSSFCell.CELL_TYPE_FORMULA:  
		                            // 导入时如果为公式生成的数据则无值  
	                            value = "";  
	                            break;  
	                            // 导入时如果为空  
	                        case HSSFCell.CELL_TYPE_BLANK:  
	                        	msg +="导入失败：第"+i+"行，第"+(j+1)+"列数据为空；";
	                            break;  
	                        case HSSFCell.CELL_TYPE_ERROR:  
	                            value = "";  
	                            msg +="导入失败：第"+i+"行，第"+(j+1)+"列数据格式错误；";
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
				if(!checkNumber(z)){
					err++;
					msg +="导入失败：第"+i+"行，第二列："+z+"监测数据非法；";
					break;
				}
				//判断监测时间不可为空
				if(null==tm){
					err++;
					msg +="导入失败：第"+i+"行，第一列：监测时间不可为空；";
					break;
				}else{
					GregorianCalendar gc = new GregorianCalendar();
					gc.setTime(tm);
					if( (gc.get(gc.MINUTE)==0) && (gc.get(gc.SECOND)==0) ){
						DdsEdBound vo = new DdsEdBound();
						vo.setProCd(proCd);
						vo.setStcd(stcd);
						vo.setQtype(3);
						vo.setTm(tm);
						
						if(minValue<=z && z<=maxValue){
							if("Z".equals(fieldNm)){
								vo.setZ(z);
							}else if("Q".equals(fieldNm)){
									vo.setQ(z);
							}else if("INQ".equals(fieldNm)){
									vo.setInq(z);
							}
							DdsEdBound entity = ddsEdBoundService.get(vo);
							if(null!=entity){
								ServiceResp resp = ddsEdBoundService.update(vo);
								if(1==resp.getCode()){
									num++;
								}
							}else{
								ServiceResp resp = ddsEdBoundService.save(vo);
								if(1==resp.getCode()){
									num++;
								}
							}
						}else{
							msg +=" 不能小于最小值："+minValue+"不能大于最大值："+maxValue;
						}
					}else{
						err++;
						msg +="导入失败：第"+i+"行，第一列：不是整点数据；";
						break;
					}
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