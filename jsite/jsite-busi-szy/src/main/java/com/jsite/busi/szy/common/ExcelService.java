package com.jsite.busi.szy.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

/**
 * 所属公司： 华信联创技术工程有限公司
 * 版本： 1.0
 * 创建人： 罗佳星
 * 创建时间：2017-11-26 12:49
 */
public class ExcelService {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static JsonNode readJson(String fileName) {
        JsonNode node = null;
        try {
            node = objectMapper.readTree(
                    ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX +
                            "defaultData/evaluation/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return node;
    }

    /**
     * 初始化sheet，设置列数和每列宽度以及名称
     * @param sheet
     */
    public static void initHeadSheet(XSSFWorkbook wb, XSSFSheet sheet, String[][] headData, int type){
        XSSFRow rowHead = sheet.createRow(0);
        XSSFCellStyle headStyle = setCellStyle(wb, type);
        rowHead.setHeightInPoints(25);			//head行高
        for (int i = 0; i < headData[0].length; i++) {
            int columnWidth = Integer.parseInt(headData[1][i]);
            createCell(rowHead, i, headData[0][i], headStyle);
            sheet.setColumnWidth(i, 256 * columnWidth);
        }
    }

    /**
     * 创建单元格
     * @param row 行
     * @param column 列位置
     * @param value 值
     * @param style 样式
     */
    public static void createCell(XSSFRow row, int column, Object value, XSSFCellStyle style){
        XSSFCell cell = row.createCell(column);
        cell.setCellValue(String.valueOf(value));
        cell.setCellStyle(style);
    }

    /**
     * 设置单元格样式
     * @param workbook
     * @param type
     * @return
     */
    public static XSSFCellStyle setCellStyle(XSSFWorkbook workbook, int type) {
        XSSFCellStyle cellStyle = workbook.createCellStyle(); 			// 样式对象
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);	// 垂直
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);				// 水平
        Font font = workbook.createFont();
        font.setFontName("微软雅黑");   //设置字体
        switch (type) {
            case 1:
                font.setFontHeightInPoints((short)12);   //设置字体大小
                font.setBoldweight((short) 600);     		 			//设置是否是加粗
                cellStyle.setWrapText(false);   	 	//设置是否能够换行，能够换行为true
                break;

            case 2:
                font.setFontHeightInPoints((short)10);   //设置字体大小
//                font.setBoldweight((short) 200);     		 			//设置是否是加粗
                cellStyle.setWrapText(false);   	 	//设置是否能够换行，能够换行为true
                break;

            default:
                break;
        }

        cellStyle.setFont(font);     //将字体格式加入到style中
        return cellStyle;
    }
}
